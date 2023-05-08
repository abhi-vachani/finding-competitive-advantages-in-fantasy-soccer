import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.StringReader;

public class CleanMapper extends Mapper<LongWritable, Text, NullWritable, Text>{
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        try {
            
            String[] columns = line.split(",");

            // Only keep the necessary columns
            StringBuilder newLineBuilder = new StringBuilder();
            newLineBuilder.append(columns[0]); // Year [0]
            newLineBuilder.append(",");
            newLineBuilder.append(columns[2]); // Player [1]
            newLineBuilder.append(",");
            newLineBuilder.append(columns[3]); // Nation [2]
            newLineBuilder.append(",");
            newLineBuilder.append(columns[4]); // Pos [3]
            newLineBuilder.append(",");
            newLineBuilder.append(columns[5]); // Squad [4]
            newLineBuilder.append(",");
            newLineBuilder.append(columns[6]); // Age [5]
            newLineBuilder.append(",");
            newLineBuilder.append(columns[7]); // Born [6]
            newLineBuilder.append(",");
            newLineBuilder.append(columns[8]); // MP [7]
            newLineBuilder.append(",");
            newLineBuilder.append(columns[9]); // Starts [8]
            newLineBuilder.append(",");
            newLineBuilder.append(columns[10]); // Min [9]
            newLineBuilder.append(",");
            newLineBuilder.append(columns[11]); // 90s [10]
            newLineBuilder.append(",");
            newLineBuilder.append(columns[12]); // Gls [11]
            newLineBuilder.append(",");
            newLineBuilder.append(columns[13]); // Ast [12]
            newLineBuilder.append(",");
            newLineBuilder.append(columns[16]); // PK [13]
            newLineBuilder.append(",");
            newLineBuilder.append(columns[17]); // PKatt [14]
            newLineBuilder.append(",");
            newLineBuilder.append(columns[18]); // CrdY [15]
            newLineBuilder.append(",");
            newLineBuilder.append(columns[19]); // CrdR [16]
            newLineBuilder.append(",");
            newLineBuilder.append(columns[20]); // xG [17]
            newLineBuilder.append(",");
            newLineBuilder.append(columns[21]); // npxG [18]
            newLineBuilder.append(",");
            newLineBuilder.append(columns[22]); // xAG [19]
            newLineBuilder.append(",");
            newLineBuilder.append(columns[24]); // PrgC [20]
            newLineBuilder.append(",");
            newLineBuilder.append(columns[25]); // PrgP [21]
            newLineBuilder.append(",");
            newLineBuilder.append(columns[26]); // PrgR [22]
            context.write(NullWritable.get(), new Text(newLineBuilder.toString()));
        }
        catch (Exception e) {
        }
    }
}
