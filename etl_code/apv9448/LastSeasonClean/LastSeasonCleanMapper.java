import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;
/*

As the dataset is already decently organized, my cleaning portion will focus on two things: 
- Only using columns that are relevant to our data analyses
- This means I will only focus on Home and Away team names and the Score of the games
- We will not need some statistics such as date or ref name

*/



public class LastSeasonCleanMapper extends Mapper<LongWritable, Text, Text, Text>
{


    @Override
    public void map(LongWritable key, Text value, Context context)
    throws IOException, InterruptedException {


   	    String line = value.toString();
            String[] columns = line.split(",");

        
        
        
            // Full Time
            Text Home = new Text(columns[1]);
            Text Away = new Text(columns[2]);
            Text HomeGoals = new Text(columns[3]);
            Text AwayGoals = new Text(columns[4]);


            // Half Time
            Text HomeHalfGoals = new Text(columns[6]);
            Text AwayHalfGoals = new Text(columns[7]);



           



            context.write(new Text(""), new Text("Home Team: " + Home + " | Away Team: " + Away + " | Home Goals: " + HomeGoals + " | Away Goals: " + AwayGoals + " | Home Goals at Halftime: " + HomeHalfGoals + " | Away Goals at Halftime: " + AwayHalfGoals));

        

        

        

    }
}
