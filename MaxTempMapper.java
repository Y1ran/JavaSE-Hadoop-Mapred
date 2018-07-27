package hadoop;

import org.apache.hadoop.mapreduce.Mapper;
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


public class MaxTempMapper extends Mapper <LongWritable, Text, Text, IntWritable> 
{
    private static final int MISSING = 9999;
    
    @Override
    public void map(LongWritable key, Text value, Context context) 
            throws IOException, InterruptedException 
    {
        String line = value.toString();
        //this is all lines content
        String date = line.substring(19,23);
        //extract years
        int airTemp = parseTemp(line);
        String quality = line.substring(92,93);
        
        boolean isRecord = airTemp != MISSING && quality.matches("[01459]");
        if( isRecord ){
            //output k2,v2 as year,temp
            context.write(new Text(date), new IntWritable(airTemp));
            
        }
        
            //
        }
    
     private int parseTemp(String line) {
         
        int airTemp;
        if(line.charAt(87) == '+') 
        {
            //parse positive
            airTemp = Integer.parseInt(line.substring(88,92));
        }
        else {
            airTemp = Integer.parseInt(line.substring(87,92));
        }
        
        return airTemp;
    }