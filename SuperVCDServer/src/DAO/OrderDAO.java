package DAO;

import Model.AddressInfo;
import Model.Order;
import Tool.MysqlHelper;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.lang.model.util.ElementScanner6;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    MysqlHelper mysqlHelper;

    public OrderDAO()
    {
        mysqlHelper=new MysqlHelper();
    }

    public boolean CreateOrder(int vcdid,int userid,int addressid)
    {
        String sql="insert into supervcd.order(userid,vcdid,addressid,ordertime) values(?,?,?,now())";
        List<Object>ps=new ArrayList<>();
        ps.add(userid);
        ps.add(vcdid);
        ps.add(addressid);

        return mysqlHelper.executeUpdate(sql,ps);
    }
    public List<Order> GetOrderList(int userID)
    {
        String sql="select * from address,vcdinfo,singer,supervcd.order where vcdinfo.singerid=singer.SingerID and address.addressid=supervcd.order.addressid and vcdinfo.vcdid=supervcd.order.vcdid and supervcd.order.userid=?";
        List<Object> ps=new ArrayList<>();
        ps.add(userID);
        List<Order> orderList=new ArrayList<>();
        ResultSet rs=mysqlHelper.executeQuery(sql,ps);
        try {
            rs.last();
            int rowcount = rs.getRow();
            rs.beforeFirst();
            if(rowcount>0)
            {
                while(rs.next())
                {
                    Order order=new Order();
                    order.orderID=rs.getInt("orderID");
                    order.vcdName=rs.getString("VcdName");
                    order.vcdSingerName=rs.getString("SingerName");
                    order.vcdPrice=rs.getInt("VCDUnitPrice");
                    order.addressDis=rs.getString("address");
                    order.addressLabel=rs.getString("Label");
                    order.orderTime=rs.getDate("orderTime").toString();
                    orderList.add(order);
                }
                return orderList;

            }else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }
}
