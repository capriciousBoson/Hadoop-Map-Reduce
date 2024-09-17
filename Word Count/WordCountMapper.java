import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordCountMapper extends Mapper<Object, Text, Text, IntWritable> {

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        // Convert the line of text to a String
        String line = value.toString();

        // Split the line into words using space as a delimiter
        String[] words = line.split("\\s+");

        // For each word in the array
        for (String w : words) {
            // Remove any leading or trailing spaces and ignore empty strings
            w = w.trim();
            if (w.length() > 0) {
                // Set the word as the output key
                word.set(w);
                // Write the word and count (1) to the context
                context.write(word, one);
            }
        }
    }
}
