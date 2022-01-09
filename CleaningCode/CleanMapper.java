import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class CleanMapper extends Mapper <LongWritable, Text, Text, Text>{
	@Override
	public void map (LongWritable key, Text value, Context context) throws IOException, InterruptedException {
	
		String line = value.toString();
		String[] arrayOfStrings = line.split (",");
		
		int i = 0;
		boolean x = true;
	
		while (x){
			if (arrayOfStrings[i].equals("W") || arrayOfStrings[i].equals("L")){
				x = false;
				break;
			}
			i++;
		}

		String location = arrayOfStrings[i];
		String shotDistance = arrayOfStrings[i+8];
		String shotResult = arrayOfStrings[i+10];

		context.write (new Text(""), new Text(location + "," + shotDistance + "," + shotResult));


/*
		for (i; i < arrayOfStrings.length; i++){
			if (arrayOfStrings[i]
		
		}


		for (int i = 0; i < arrayOfStrings.length; i++){
			
			if (i == 11 && arrayOfStrings[i] != "SHOT_DIST"){
//				long temp = Long.parseLong (arrayOfStrings[i]);
				
				context.write (new Text("Shot Distance"), new Text (arrayOfStrings[i]));
			}
			else if (i == 13 && arrayOfStrings[i] != "SHOT_RESULT"){
				context.write (new Text("Shot Result"), new Text (arrayOfStrings[i]));
			}
			else if (i == 19 && arrayOfStrings[i] != ""){
				context.write (new Text("Shooter Name"), new Text (arrayOfStrings[i]));
			}
			
		
		}
		
	
	
	
*/	
	}



}
