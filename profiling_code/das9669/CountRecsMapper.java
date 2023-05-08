import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import com.opencsv.CSVReader;
import java.io.StringReader;

public class CountRecsMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        try {
            CSVReader reader = new CSVReader(new StringReader(line));
            String[] fields = reader.readNext();
            if (fields[0].toLowerCase().contains("rk") == false) { 
                context.write(new Text("record"), new IntWritable(1));
            }
            reader.close();
        }
        catch(Exception e) {
        }
    }
}
