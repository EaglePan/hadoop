package com.logCount.VO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LogVO {
    private String remoteIp;
    private String time;
    private String timeZoom;
    private String requestType;
    private String serviceUrl;
    private String protocol;
    private String status;
    private String size;

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    public String getTime() {
        return this.time;
    }

    public String getTimeDate() {
        DateTimeFormatter standardDf =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        DateTimeFormatter inputDf =
                DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss", Locale.US);

        LocalDateTime lt = LocalDateTime.parse(this.time, inputDf);
        return standardDf.format(lt).toString();



       /* SimpleDateFormat df=new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", Locale.US);
        SimpleDateFormat df2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        try {
            Date date = df.parse(this.time);
            return df2.format(date);
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }*/


    }

    public void setTime(String time) {
       /* DateTimeFormatter inputDf =
                DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss");*/
        if (time.indexOf("[") > -1) time = time.replace("[", "");
        this.time = time;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        if (requestType.indexOf("\"") > -1) requestType = requestType.replace("\"", "");
        this.requestType = requestType;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        if (protocol.indexOf("\"") > -1) protocol = protocol.replace("\"", "");
        this.protocol = protocol;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTimeZoom() {
        return timeZoom;
    }

    public void setTimeZoom(String timeZoom) {
        if (timeZoom.indexOf("]") > -1) timeZoom = timeZoom.replace("]", "");
        this.timeZoom = timeZoom;
    }

    @Override
    public String toString() {
        return "LogVO{" +
                "remoteIp='" + remoteIp + '\'' +
                ", time='" + time + '\'' +
                ", timeZoom='" + timeZoom + '\'' +
                ", requestType='" + requestType + '\'' +
                ", serviceUrl='" + serviceUrl + '\'' +
                ", protocol='" + protocol + '\'' +
                ", status='" + status + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
