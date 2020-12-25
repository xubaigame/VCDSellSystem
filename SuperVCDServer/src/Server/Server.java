package Server;
import Connection.ActionCode;
import Connection.RequestCode;
import Controller.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private ServerSocket serverSocket;
    private List<Client> clientList=new ArrayList<Client>();
    private ControllerManager controllerManager;
    public Server() {
        try {
			//修改自己的端口
            serverSocket = new ServerSocket(5588);
            controllerManager=new ControllerManager(this);
            while (true) {
                //一旦有堵塞，表示服务器与客户端获得了连接
                Socket clientSocket = serverSocket.accept();
                Client client = new Client(this,clientSocket);
                System.out.println("客户端已连接");
                clientList.add(client);
            }
        } catch (IOException e) {
            System.out.println("服务器启动出现问题");
        }
    }
    public void RemoveClient(Client client)
    {
        synchronized (clientList)
        {
            clientList.remove(client);
        }
    }

    public void SendResponse(Client client, ActionCode actionCode, String data)
    {
        //相应客户端
        client.sendMessage(actionCode, data);
    }
    public void HandlerRequest(RequestCode requestCode, ActionCode actionCode, String data, Client client)
    {
        controllerManager.HandleRequest(requestCode,actionCode,data,client);
    }
}
