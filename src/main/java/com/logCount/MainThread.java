package com.logCount;

import java.util.Arrays;
import java.util.List;

public class MainThread {
    public static void main(String[] args) {
        String str="120.85.118.2 - - [01/Apr/2019:00:00:31 +0800] \"GET /choice-ERP/login HTTP/1.1\" 200 11493";
        LogVO vo = strToVo(str);
        System.out.println(vo.toString());
        System.out.println(vo.getTimeDate());
    }

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
