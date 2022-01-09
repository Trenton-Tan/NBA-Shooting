import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;
import java.lang.*;
import java.util.*;

public class AnalyticMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	@Override
	public void map (LongWritable key, Text value, Context context) throws IOException, InterruptedException {
	
		String line = value.toString();
		String[] arrayOfStrings = line.split(",");

	

		if (!arrayOfStrings[1].equals("SHOT_DIST")){

			float distance = Float.parseFloat(arrayOfStrings[1]);
	
			if (distance <= 14){
				context.write(new Text("Close Shots:\t"), new IntWritable(1));
				if (arrayOfStrings[2].equals("made")){
					context.write(new Text("Close Shots Made:"), new IntWritable(1));
				}
			}

			else if (distance > 14 && distance < 22){
				context.write(new Text("MidRange Shots:\t"), new IntWritable(1));
				if(arrayOfStrings[2].equals("made")){
					context.write(new Text("MidRange Shots Made:"), new IntWritable(1));
				}
			}
	
			else if (distance >= 22) {
				context.write(new Text("3 Point Shots\t"), new IntWritable(1));
				if (arrayOfStrings[2].equals("made")){
					context.write(new Text("3 Point Shots Made:"), new IntWritable(1));
				}
			}
		}
	
	
	}



}
