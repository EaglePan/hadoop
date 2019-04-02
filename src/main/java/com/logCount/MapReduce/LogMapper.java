package com.logCount.MapReduce;

import com.logCount.VO.LogVO;
import com.logCount.VoUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class LogMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private IntWritable one = new IntWritable(1);
    private Text word = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        LogVO vo = VoUtils.strToVo(value.toString());
        String url ="";
        if(StringUtils.isNotEmpty(vo.getServiceUrl())) {
            String orginUrl=vo.getServiceUrl();
            if (orginUrl.indexOf("?") > -1) {
                url = orginUrl.split("\\?")[0];
            } else {
                url = vo.getServiceUrl();
            }
            word.set(url);
            context.write(word,one);
        }
    }
}
