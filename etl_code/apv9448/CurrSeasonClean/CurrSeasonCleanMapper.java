import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;
/*

As the dataset is already decently organized, my cleaning portion will focus on two things: 
- Deleting rows that do not make sense (i.e. string of commas)
- Only using rows that are relevant to our data analyses
- Only going up to Matchweek 32 since the season is not over yet and only goes up to the 32nd week.

*/



public class CurrSeasonCleanMapper extends Mapper<LongWritable, Text, Text, Text>
{


    @Override
    public void map(LongWritable key, Text value, Context context)
    throws IOException, InterruptedException {


    String line = value.toString();
    if (!(line.equals(",,,,,,,,,,,,,")))
    {
        String[] columns = line.split(",");

        String Week = (columns[0]).toString();
        if (!(Week.equals("Wk")))
        {
            int WeekNum = Integer.parseInt(Week);
            if (WeekNum < 32 )
            {

                Text Home = new Text(columns[4]);
                Text Score = new Text(columns[6]);
                Text Away = new Text(columns[8]);





                context.write(new Text(""), new Text("Home Team: " + Home + " Away Team: " + Away + " Score: " + Score));

            }

        }

        
    }

    }
}
