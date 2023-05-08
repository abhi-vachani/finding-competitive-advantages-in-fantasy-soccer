import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class Year {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        conf.set("currentYear", "2023");
        
        Job job = Job.getInstance(conf, "year cleaner");
        job.setNumReduceTasks(1); // Reduce Task
        job.setJarByClass(Year.class);
        job.setMapperClass(YearMapper.class);
        job.setCombinerClass(YearReducer.class);
        job.setReducerClass(YearReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
