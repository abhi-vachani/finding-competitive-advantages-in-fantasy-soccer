import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class YearMapper extends Mapper<LongWritable, Text, Text, Text> {
    private Text year = new Text();
    private Text data = new Text();
    
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] columns = line.split(",");
        
        if (columns.length > 0 && columns[0].equals("Rk")) {
            int yearInt = Integer.parseInt(context.getConfiguration().get("currentYear")) - 1;
            context.getConfiguration().set("currentYear", String.valueOf(yearInt));
        } else {
            year.set(context.getConfiguration().get("currentYear") + "-" + (Integer.parseInt(context.getConfiguration().get("currentYear")) + 1));
            data.set(line);
            context.write(year, data);
        }
    }
}