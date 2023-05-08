import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import com.opencsv.CSVReader;
import java.io.StringReader;

public class FindMeanGoalMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        try {
            CSVReader reader = new CSVReader(new StringReader(line));
            String[] fields = reader.readNext();
            if(fields[11].toLowerCase().compareTo("gls") != 0) {
                int goals = Integer.parseInt(fields[11]);
                context.write(new Text(""), new IntWritable(goals));
            }
            reader.close();
        }
        catch(Exception e) {
        }
    }
}
