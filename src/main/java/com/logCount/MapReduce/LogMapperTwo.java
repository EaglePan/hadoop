package com.logCount.MapReduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;

public class LogMapperTwo extends MapReduceBase implements Mapper<Object,Text,Object,Object> {
    private IntWritable one = new IntWritable(1);
    private Text word = new Text();

    @Override
    public void map(Object o, Text text, OutputCollector<Object, Object> outputCollector, Reporter reporter) throws IOException {

    }
}
