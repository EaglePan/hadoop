package com.logCount.VO;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class OrderVO implements WritableComparable<OrderVO> {
    private String key;
    private int val;

    public OrderVO(){}

    public OrderVO(String key, int val) {
        this.key = key;
        this.val = val;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public int compareTo(OrderVO o) {
        int vo= Integer.valueOf(key.toCharArray()[0]).intValue();
        int otherVO= Integer.valueOf(o.getKey().toCharArray()[0]).intValue();
        int diff=vo-otherVO;

        if(diff!=0){
            return diff;
        }else{
            return val-o.getVal();
        }
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(key);
        dataOutput.writeInt(val);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.key = dataInput.readUTF();
        this.val=dataInput.readInt();
    }


    public static void main(String[] args) {
        System.out.println(
                Integer.valueOf(Integer.valueOf("BCD".toCharArray()[0]).intValue()).intValue());
    }
}
