package Server;

import Connection.ActionCode;
import Connection.RequestCode;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    private Socket clientSocket;
    private InputStream is;
    private OutputStream os;
    private Message message;
    private Server server;
    public Client(Server server,Socket socket)
    {
        this.server=server;
        clientSocket=socket;
        message=new Message(this);
        try {
            is=socket.getInputStream();
            os=socket.getOutputStream();
        } catch (IOException e) {
            System.out.println("客户端连接失败");
        }
        init();
    }
    private void init()  {

        new Thread(){
            @Override
            public void run() {
                try {
                    byte[] buf=new byte[1024*1024];
                    int length=-1;
                    while(true){
                        if(clientSocket.isClosed())
                        {
                            Close();
                        }
                        length=is.read(buf);
                        if(length==-1)
                            break;
                        for(int i=message.getStartindex(),j=0;i<1024&&j<buf.length;i++,j++)
                        {
                            message.data[i]=buf[j];
                        }
                        message.data=buf;
                        message.readMessage(length);

                    }
                } catch (IOException e) {
                    Close();

                }
            }
        }.start();
    }
    private void Close()
    {
        try {
            is.close();
            os.close();
            clientSocket.close();
            System.out.println("客户端已断开连接");
        } catch (IOException e1) {
            System.out.println("客户端断开连接时出现问题");
        }
    }
    public void sendMessage(final ActionCode actionCode, final String data){
        //todo 发送信息
        new Thread(){
            @Override
            public void run() {
                try {
                    byte[] buf=new byte[1024*1024];
                    buf=message.packData(actionCode,data);
                    os.write(buf);
                    os.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
    public void onProcessDataCallBack(RequestCode requestCode, ActionCode actionCode, String data)
    {
        server.HandlerRequest(requestCode,actionCode,data,this);
    }
}
