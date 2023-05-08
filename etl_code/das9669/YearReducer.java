import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class YearReducer extends Reducer<Text, Text, Text, Text> {
    private Text outputKey = new Text();
    private Text outputValue = new Text();
    
    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        for (Text value : values) {
            String[] columns = value.toString().split(",");
            if (columns.length > 0 && columns[0].equals("Rk")) {
                outputKey.set("Year," + value.toString());
            } else {
                outputKey.set(key.toString() + "," + value.toString());
            }
            outputValue.set("");
            context.write(outputKey, outputValue);
        }
    }
}