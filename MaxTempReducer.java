package hadoop;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import java.io.*;
import javax.servlet.*;
import org.apache.commons.compress.utils.IOUtils;  
import org.apache.hadoop.conf.Configuration;  
import org.apache.hadoop.fs.FileStatus;  
import org.apache.hadoop.fs.FileSystem;  
import org.apache.hadoop.fs.LocatedFileStatus;  
import org.apache.hadoop.fs.RemoteIterator;  


public class MaxTempReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
        
    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context)
        throws IOException, InterruptedException
    {
        int maxValue = findmax( values );
        context.write(key, new IntWritable(maxValue));
    }
    
    private static int findmax(Iterable<IntWritable> values) {
        int tmpValue = Integer.MIN_VALUE;
        for( IntWritable value: values) {
            tmpValue = Math.max(tmpValue ,value.get());
        }
        
        int maxValue = tmpValue;
        
        return maxValue;
    }
    
    
    
    
}
