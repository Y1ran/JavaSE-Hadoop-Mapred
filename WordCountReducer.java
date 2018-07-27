package hadoops;

import java.io.*;
import javax.servlet.*;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.*;
import org.apache.hadoop.mapreduce.lib.output.*;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.fs.Path;  
import org.apache.hadoop.fs.FSDataInputStream;  
import org.apache.hadoop.fs.FSDataOutputStream;  

public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    
    public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException{
        int total = 0;
        for(IntWritable val: values) {
            total++;
        }
        
        context.write(key, new IntWritable(total));
    }
    
}