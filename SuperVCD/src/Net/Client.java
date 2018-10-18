package Net;
import Connection.*;
import Request.RequestManager;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    private Socket socket;
    private  OutputStream os;
    private InputStream in;
    private static Client client=null;
    private Message message;
    Client(){
        init();
    }
    public void init()  {

        new Thread(){
            @Override
            public void run() {
                message=new Message();
                try {
					//修改服务器的ip与端口
                    socket=new Socket("",0);
                    in=socket.getInputStream();
                    os=socket.getOutputStream();
                } catch (IOException e) {
                    System.out.print("连接服务器失败！！！");
                }
                try {
                    byte[] buf=new byte[1024*1024];
                    int length=-1;
                    while(true){
                        length=in.read(buf);
                        if(length==-1)
                            break;
                        for(int i=message.getStartindex(),j=0;i<1024&&j<buf.length;i++,j++)
                        {
                            message.data[i]=buf[j];
                        }
                        message.data=buf;
                        //解析
                        message.readMessage(length);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
    public void sendMessage(final RequestCode requestCode, final ActionCode actionCode, final String data){
        //todo 发送信息
        new Thread(){
            @Override
            public void run() {
                try {
                    byte[] buf=new byte[1024*1024];
                    buf=message.packData(requestCode,actionCode,data);

                    os.write(buf);
                    os.flush();
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
        }.start();
    }
    public void onProcessDataCallBack(ActionCode actionCode,String data){
        RequestManager.getRequestManager().HandleReponse(actionCode, data);
    }

    public static Client getClient() {
        if(client==null){
            client=new Client();
        }
        return client;
    }
}
