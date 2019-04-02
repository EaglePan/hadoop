package com.logCount.MapReduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * LogReducer继承了Reducer类，如果Reducer使用泛式来声明的话，可以减少方法中参数的转型工作
 */

/*public class LogReducer extends Reducer {
    private IntWritable result = new IntWritable();

    @Override
    protected void reduce(Object key, Iterable values, Context context) throws IOException, InterruptedException {
        super.reduce(key, values, context);
    }
}*/


public class LogReducer extends Reducer<Text,IntWritable,Text,IntWritable> {
    private IntWritable result = new IntWritable();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum=0;
        for(IntWritable val:values){
            sum+=val.get();
        }
        result.set(sum);
        context.write(key,result);
    }
}

