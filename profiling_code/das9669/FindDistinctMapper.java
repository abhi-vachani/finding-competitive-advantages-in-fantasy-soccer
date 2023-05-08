import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import com.opencsv.CSVReader;
import java.io.StringReader;

public class FindDistinctMapper extends Mapper<LongWritable, Text, Text, Text> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        try {
            CSVReader reader = new CSVReader(new StringReader(line));
            String[] fields = reader.readNext();
            if(fields[4].toLowerCase().compareTo("squad") != 0) {
                context.write(new Text(fields[4]), new Text(""));
            }
            reader.close();
        }
        catch(Exception e) {
        }
    }
}
