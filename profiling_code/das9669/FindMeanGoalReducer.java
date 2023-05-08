import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FindMeanGoalReducer extends Reducer <Text, IntWritable, Text, IntWritable>{
    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context)
    throws IOException, InterruptedException {
        int numGoals = 0;
        int playerCount = 0;
        for (IntWritable value : values) {
            numGoals += value.get();
            playerCount++;
        }
        context.write(new Text("Average Goals Scored per Player: "), new IntWritable(numGoals / playerCount));
    }
}
