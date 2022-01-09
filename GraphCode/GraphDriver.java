import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class GraphDriver{
	public static void main (String[] args) throws Exception{
		if (args.length != 2){
			System.err.println ("<input path> <output path>");
			System.exit(-1);
		}

		Job job = new Job();
		job.setNumReduceTasks(1);
		job.setJarByClass(GraphDriver.class);
		job.setJobName("GraphDriver");

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.setMapperClass(GraphMapper.class);
		job.setReducerClass(GraphReducer.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
