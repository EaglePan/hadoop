package com.logCount;

import com.wordCount.Main;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class MainThread {
    public static void main(String[] args)  throws Exception{
        Job job =new Job(new Configuration(), "word count");    //设置一个用户定义的job名称
        job.setJarByClass(Main.class);
        job.setJobName("LogCounter");

        job.setMapperClass(LogMapper.class);    //为job设置Mapper类
        //job.setCombinerClass(Reducer.class);    //为job设置Combiner类
        job.setReducerClass(LogReducer.class);    //为job设置Reducer类

        job.setOutputKeyClass(Text.class);        //为job的输出数据设置Key类
        job.setOutputValueClass(IntWritable.class);    //为job输出设置value类
        job.setOutputFormatClass(TextOutputFormat.class);

        //src/main/resources/access_log.txt
        //src/main/resources/logCount
        FileInputFormat.addInputPath(job,new Path("src/main/resources/access_log"));    //为job设置输入路径
        FileOutputFormat.setOutputPath(job, new Path("src/main/resources/logCount"));//为job设置输出路径

        System.exit(job.waitForCompletion(true) ?0 : 1);        //运行job
    }

}
