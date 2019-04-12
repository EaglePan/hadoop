package com.logCountOrderBy;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class logCountPartition extends Partitioner<Text,IntWritable> {
    @Override
    public int getPartition(Text text, IntWritable intWritable, int i) {
        if( text.toString().equals("POST")){
            return 0;
        }else {
            return 1;
        }

    }
}
