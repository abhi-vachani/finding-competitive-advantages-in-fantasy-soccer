import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;



public class FinalCodeMapper extends Mapper<LongWritable, Text, Text, IntWritable>
{


    @Override
    public void map(LongWritable key, Text value, Context context)
    throws IOException, InterruptedException {


    String line = value.toString();
    if (!(line.equals("Date,HomeTeam,AwayTeam,FTHG,FTAG,FTR,HTHG,HTAG,HTR,Referee,HS,AS,HST,AST,HF,AF,HC,AC,HY,AY,HR,AR")))
    {
        String[] columns = line.split(",");

        Text Away = new Text(columns[2]);
	Text Home = new Text(columns[1]);


	IntWritable AwayGoalsConceded = new IntWritable(Integer.parseInt(columns[3]));
	IntWritable HomeGoalsConceded = new IntWritable(Integer.parseInt(columns[4]));
	


        context.write(Away, AwayGoalsConceded);
	context.write(Home, HomeGoalsConceded);
    }

    }
}
