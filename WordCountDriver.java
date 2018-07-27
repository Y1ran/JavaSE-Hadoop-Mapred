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

public class WordCountDriver {

    public static void main(String[] args)  throws Exception{
        // TODO Auto-generated method stub
        if(args.length != 2) {
            
            String str = "Usage: MaxTemp<input path> <output path>";
            System.err.println(str);
            System.exit(-1);
            //exit 0;
        }
        
        Configuration conf = new Configuration();
        Job job = new Job(conf, "Word count");
        job.setJarByClass(WordCountDriver.class);
        //job.setJobName("Max Temprature");  !replaced by new job(...
        

        //private static void print(String strings) {
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        
        //setup the MepRed
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);
        
        //setup the output format
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        
        //exit when job finished
        System.exit(job.waitForCompletion(true) ? 0 : 1);

     }
    }
}
