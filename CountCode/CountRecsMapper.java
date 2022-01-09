import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class CountRecsMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

	@Override
	public void map (LongWritable key, Text value, Context context) throws IOException, InterruptedException{
	
	String line = value.toString();
	String[] arrayOfStrings = line.split(",");
	
	int i = 0;
	boolean x = true;

	while(x){
		if (arrayOfStrings[i].equals("W") || arrayOfStrings[i].equals("L")){
			x = false;
			break;
		}
		i++;
	}
	
	
		
	context.write (new Text("Count"), new IntWritable(1));


	}





}
