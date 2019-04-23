package com.logCountOrderBy;

import com.logCount.MapReduce.LogReducer;
import com.logCountOrderBy.MapReduce.LogOrderMapper;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * 分区branches123
 */

public class OrderByMainThread {
        public static void main(String[] args)  throws IOException, ClassNotFoundException, InterruptedException {

            Configuration conf=new Configuration();
            conf.set("fs.defaultFS","file:///");
            Job job=Job.getInstance(conf, "LogCounter");

            job.setJarByClass(OrderByMainThread.class);
            job.setInputFormatClass(TextInputFormat.class);

            job.setPartitionerClass(logCountPartition.class);
            job.setNumReduceTasks(2);

            job.setMapperClass(LogOrderMapper.class);    //为job设置Mapper类
            System.out.println(job.getNumReduceTasks());
            job.setReducerClass(LogReducer.class);    //为job设置Reducer类

            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(IntWritable.class);

            job.setOutputValueClass(IntWritable.class);    //为job输出设置value类
            job.setOutputKeyClass(Text.class);        //为job的输出数据设置Key类
            job.setOutputFormatClass(TextOutputFormat.class);

            DateTimeFormatter dtf=
                    DateTimeFormatter.ofPattern("yyyyMMddHHmmss", Locale.CHINA);
            FileInputFormat.addInputPath(job,new Path("src/main/resources/access_log.txt"));    //为job设置输入路径
            FileOutputFormat.setOutputPath(job,
                    new Path("src/main/output/logCount"+dtf.format(LocalDateTime.now())));//为job设置输出路径

            System.exit(job.waitForCompletion(true) ?0 : 1);        //运行job

        }
}
