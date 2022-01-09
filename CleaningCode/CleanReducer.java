import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;
import org.apache.hadoop.io.LongWritable;

public class CleanReducer extends Reducer<Text, IntWritable, Text, Text>{
//	@Override
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException{
	
		
/*
				
		
		if (key.equals("Shot Distance")){

			for (Text value : values){
				
				context.write (key, value);
	
			}	
		if (key.equals("Shot Result")){
		
			for (Text value : values){
				context.write (key, value);
			}
	
		}
		if (key.equals("Shooter Name")){
	
			for (Text value : values){
				context.write (key, value);
			}
		}	
	
	
	
	
		}
*/

	}
}
