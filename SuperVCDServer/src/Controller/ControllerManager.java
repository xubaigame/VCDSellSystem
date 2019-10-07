package Controller;

import Connection.ActionCode;
import Connection.RequestCode;
import DAO.OrderDAO;
import Server.*;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ControllerManager {
    private Map<RequestCode, BaseController> controllerDict = new HashMap<>();
    private Server server;
    public ControllerManager(Server server)
    {
        this.server = server;
        InitController();
    }
    void InitController()
    {
        DefaultController defaultController= new DefaultController();
        controllerDict.put(defaultController.requestCode, defaultController);
        UserController userController = new UserController();
        controllerDict.put(userController.requestCode, userController);
        MainWindowController mainWindowController=new MainWindowController();
        controllerDict.put(mainWindowController.requestCode,mainWindowController);
        AddressController addressController=new AddressController();
        controllerDict.put(addressController.requestCode,addressController);
        OrderController orderController=new OrderController();
        controllerDict.put(orderController.requestCode,orderController);
    }
    public void AddController(BaseController baseController)
    {
        controllerDict.put(baseController.requestCode, baseController);
    }
    public void HandleRequest(RequestCode requestCode, ActionCode actionCode, String data, Client client)
    {
        BaseController controller;
        Object o=null;
        controller = controllerDict.get(requestCode);
        if (controller == null)
        {
            System.out.println("["+requestCode+"]无法获取controller,请求被拒绝");
        }
        try {
            Method info=controller.getClass().getMethod(actionCode.toString(),String.class,Client.class,Server.class);
            o= info.invoke(controller,data, client,server);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("未在["+requestCode+"]处理类中找到对应方法["+actionCode+"]");
        }
        server.SendResponse(client,actionCode,(String) o);
    }
}
