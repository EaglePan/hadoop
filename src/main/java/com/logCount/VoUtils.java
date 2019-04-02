package com.logCount;

import java.util.Arrays;
import java.util.List;

public class VoUtils {
    public static LogVO strToVo(String line){
        List<String> list= Arrays.asList(line.split(" "));
        System.out.println(list);
        LogVO vo = new LogVO();
        vo.setRemoteIp(list.get(0));
        vo.setTime(list.get(3));
        vo.setTimeZoom(list.get(4));
        vo.setRequestType(list.get(5));
        vo.setServiceUrl(list.get(6));
        vo.setProtocol(list.get(7));
        vo.setStatus(list.get(8));
        vo.setSize(list.get(9));
        return vo;
    }
}
