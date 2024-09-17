import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    private IntWritable result = new IntWritable();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;

        // Iterate through all values (the list of 1's for this word)
        for (IntWritable val : values) {
            sum += val.get();  // Add each value to the sum
        }

        // Set the result as the sum of counts for this word
        result.set(sum);

        // Write the word (key) and its total count (result) to the context
        context.write(key, result);
    }
}
