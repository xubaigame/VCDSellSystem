package Controller;

import Connection.RequestCode;
import Connection.ReturnCode;
import DAO.AddressDAO;
import DAO.OrderDAO;
import DAO.UserDAO;
import DAO.VCDInfoDAO;
import Model.AddressInfo;
import Model.Order;
import Model.User;
import Model.VCDInfo;
import Server.Client;
import Server.Server;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.swing.text.StyledEditorKit;
import java.util.List;

public class OrderController extends BaseController {
    private OrderDAO orderDAO;
    private AddressDAO addressDAO;
    private UserDAO userDAO;
    private VCDInfoDAO vcdInfoDAO;
    public OrderController()
    {
        requestCode = RequestCode.Order;
        orderDAO=new OrderDAO();
        addressDAO=new AddressDAO();
        userDAO=new UserDAO();
        vcdInfoDAO=new VCDInfoDAO();
    }
    public String GetOrderDis(String data, Client client, Server server)
    {
        JSONObject jsonObject=JSONObject.parseObject(data);
        int vcdid=jsonObject.getInteger("VCDID");
        int userid=jsonObject.getInteger("UserID");
        AddressInfo addressInfo=addressDAO.GetDefaultAddress(userid);
        VCDInfo vcdInfo=vcdInfoDAO.GetVCDDis(vcdid);
        if(addressInfo!=null&&vcdInfo!=null)
        {
            return String.valueOf(ReturnCode.Successed.ordinal()+"!"+jsonObject.toJSONString(vcdInfo)+"!"+jsonObject.toJSONString(addressInfo));
        }
        else
        {
            return String.valueOf(ReturnCode.Fail.ordinal());
        }
    }
    public String CreateOrder(String data, Client client, Server server)
    {
        JSONObject jsonObject=JSONObject.parseObject(data);
        int vcdid=jsonObject.getInteger("VCDID");
        int userid=jsonObject.getInteger("UserID");
        int addressid=jsonObject.getInteger("AddressID");

        boolean result=orderDAO.CreateOrder(vcdid,userid,addressid);
        if(result)
        {
            return String.valueOf(ReturnCode.Successed.ordinal());
        }
        else
        {
            return String.valueOf(ReturnCode.Fail.ordinal());
        }
    }
    public String GetOrderList(String data, Client client, Server server)
    {
        JSONObject jsonObject=JSONObject.parseObject(data);
        int userid=jsonObject.getInteger("UserID");
        List<Order> orderList=orderDAO.GetOrderList(userid);
        if(orderList!=null)
        {
            return String.valueOf(ReturnCode.Successed.ordinal()+"!"+JSON.toJSONString(orderList));
        }
        else
        {
            return String.valueOf(ReturnCode.Fail.ordinal());
        }
    }
}
