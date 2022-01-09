import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;
import java.lang.*;
import java.util.*;

public class GraphMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	@Override
	public void map (LongWritable key, Text value, Context context) throws IOException, InterruptedException{
	
		String line = value.toString();
		String[] arrayOfStrings = line.split(",");

		if(!arrayOfStrings[1].equals("SHOT_DIST")){
			float distance = Float.parseFloat(arrayOfStrings[1]);

			if (distance >= 25) {
				context.write(new Text("Long:\t"), new IntWritable(1));
				if(arrayOfStrings[2].equals("made")){
					context.write(new Text("Long 3 made:"), new IntWritable(1));
				}
			}
			else if(distance < 25 && distance >= 22){
				context.write(new Text("Reg 3:\t"), new IntWritable(1));
				if(arrayOfStrings[2].equals("made")){
					context.write(new Text("Reg 3 made:"), new IntWritable(1));
				}
			}	
			else if(distance < 22 && distance >= 18){
				context.write(new Text("18-22:\t"), new IntWritable(1));
				if(arrayOfStrings[2].equals("made")){
					context.write(new Text("18-22 made:"), new IntWritable(1));
				}
			}
			else if(distance < 18 && distance >= 15){
				context.write(new Text("15-18:\t"), new IntWritable(1));
				if(arrayOfStrings[2].equals("made")){
					context.write(new Text("15-18 made:"), new IntWritable(1));
				}
			}
			else if(distance < 15 && distance >= 12){
				context.write(new Text("12-15:\t"), new IntWritable(1));
				if(arrayOfStrings[2].equals("made")){
					context.write(new Text("12-15 made:"), new IntWritable(1));
				}
			}
			else if(distance < 12 && distance >= 9){
				context.write(new Text("9-12:\t"), new IntWritable(1));
				if(arrayOfStrings[2].equals("made")){
					context.write(new Text("9-12 made:"), new IntWritable(1));
				}
			}
			else if(distance < 9 && distance >= 6){
				context.write(new Text("6-9:\t"), new IntWritable(1));
				if(arrayOfStrings[2].equals("made")){
					context.write(new Text("6-9 made:"), new IntWritable(1));
				}
			}
			else if(distance < 6 && distance >= 3){
				context.write(new Text("3-6:\t"), new IntWritable(1));
				if(arrayOfStrings[2].equals("made")){
					context.write(new Text("3-6 made:"), new IntWritable(1));
				}
			}
			else if(distance < 3){
				context.write(new Text("0-3:\t"), new IntWritable(1));
				if(arrayOfStrings[2].equals("made")){
					context.write(new Text("0-3 made:"), new IntWritable(1));
				}
			}
		}
	}
}
