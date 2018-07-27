package hadoops;

import java.io.*;
import javax.servlet.*;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.*;
import org.apache.hadoop.mapreduce.lib.output.*;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.fs.Path;  
import org.apache.hadoop.fs.FSDataInputStream;  
import org.apache.hadoop.fs.FSDataOutputStream;  

public class WordCountMapper extends Mapper<Object, Text, Text, IntWritable> {
    
    private static final IntWritable one = new IntWritable(1);
    private Text word = new Text();
    
    public void map(Object key, Text value, Context context) 
        throws IOException, InterruptedException{
        String[] words = value.toString().split(" ");
        
        for (String str: words)
        {
            word.set(str);
            context.write(word, one);
        }
    }
}
