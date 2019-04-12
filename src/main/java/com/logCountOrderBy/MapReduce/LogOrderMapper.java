package com.logCountOrderBy.MapReduce;

import com.logCount.VO.LogVO;
import com.logCount.VO.VoUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class LogOrderMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private IntWritable one = new IntWritable(1);
    private Text word = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        LogVO vo = VoUtils.strToVo(value.toString());
        if(StringUtils.isNotEmpty(vo.getServiceUrl())) {
            String type=vo.getRequestType();
            word.set(type);
            context.write(word,one);
        }
    }
}
