import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.util.*;




public class FinalCodeReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

 @Override
 public void reduce(Text key, Iterable<IntWritable> values, Context context)
 throws IOException, InterruptedException {
   int totalConceded = 0;


   for (IntWritable value: values)
   {
	   totalConceded += value.get();

   }







   
   context.write(key, new IntWritable(totalConceded));


  }


 }        
