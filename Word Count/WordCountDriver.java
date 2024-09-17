import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCountDriver {

    public static void main(String[] args) throws Exception {

        // Create a new job
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "word count");

        // Set the Jar by finding the class that is the entry point
        job.setJarByClass(WordCountDriver.class);

        // Set the Mapper and Reducer classes
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);

        // Set the output key and value types (output of both Mapper and Reducer)
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // Set input and output file paths (provided as command-line arguments)
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        // Exit after job completion
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}

