import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;

import org.apache.hadoop.mapreduce.Mapper;



public class GKMapper extends Mapper<LongWritable, Text, Text, Text>
{
    

    


    @Override
    public void map(LongWritable key, Text value, Context context)
    throws IOException, InterruptedException {
    
     

    String line = value.toString();

    if (!(line.equals("2021-22")))
    {
	 if (!(line.equals("2022-23")))


	 {	 

   		 String[] columns = line.split(",");

   		 Text Player = new Text(columns[1]);
		 Text Team = new Text(columns[4]);
    		 context.write(new Text(Player + ": " + Team), new Text(""));

	 }
    }


    



    }
}

