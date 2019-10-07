package Net;
import Connection.*;

import java.lang.reflect.Array;
import java.sql.ClientInfoStatus;
public class Message {
    public byte[] data=new byte[1024*1024];
    private int startindex=0;
    public byte[] getData() {
        return data;
    }

    public int getStartindex() {
        return startindex;
    }
    public int remainSize(){
        return data.length-startindex;
    }
    public void readMessage(int newDataAmount){

        startindex+=newDataAmount;
        while(true){
            if(startindex<=4){
                return;
            }
            int count=byteArrayToInt(data,0);
            if((startindex-4)>=count){
                ActionCode actionCode=ActionCode.values()[ byteArrayToInt(data,4)];
                String s=new String(data,8,count-4);
                Client.getClient().onProcessDataCallBack(actionCode,s);
                System.arraycopy(data,count+4,data,0,startindex-4-count);
                startindex-=(count+4);
            }
            else break;
        }
    }
    public static int byteArrayToInt(byte[] bytes,int offest) {
        int value=0;
        //由高位到低位
        for(int i = 0+offest; i < 4+offest; i++) {
            int shift= (4+offest-1-i) * 8;
            value +=(bytes[i] & 0x000000FF) << shift;//往高位游
        }
        return value;
    }

    public static byte[] intToByteArray(int i) {
        byte[] result = new byte[4];
        //由高位到低位
        result[0] = (byte)((i >> 24) & 0xFF);
        result[1] = (byte)((i >> 16) & 0xFF);
        result[2] = (byte)((i >> 8) & 0xFF);
        result[3] = (byte)(i & 0xFF);
        return result;
    }

    public byte[] packData(RequestCode requestCode, ActionCode actionCode, String  data){
        byte[] request=intToByteArray(requestCode.ordinal());
        byte[] action=intToByteArray(actionCode.ordinal());
        byte[] dataBytes=data.getBytes();
        int dataCount=request.length+action.length+dataBytes.length;
        byte[] count=intToByteArray(dataCount);
        byte[] total=new byte[dataCount+4];
        System.arraycopy(count, 0, total, 0, count.length);
        System.arraycopy(request, 0, total, count.length, request.length);
        System.arraycopy(action, 0, total, count.length+request.length, action.length);
        System.arraycopy(dataBytes, 0, total, count.length+request.length+action.length, dataBytes.length);
        return  total;
    }
}
