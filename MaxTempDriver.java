package hadoop;

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

public class MaxTempDriver {

    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        
    if(args.length != 2) {
        
        String str = "Usage: MaxTemp<input path> <output path>";
        System.err.println(str);
        System.exit(-1);
        //exit 0;
    }
    
    Job job = new Job();
    job.setJarByClass(MaxTempDriver.class);
    job.setJobName("Max Temprature");
    

    //private static void print(String strings) {
        // TODO Auto-generated method stub
       // System.err.println(strings);
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    
    //setup the MepRed
    job.setMapperClass(MaxTempMapper.class);
    job.setReducerClass(MaxTempReducer.class);
    
    //setup the output format
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    
    //exit when job finished
    System.exit(job.waitForCompletion(true) ? 0 : 1);

 }
}
