package DAO;

import Model.AddressInfo;
import Tool.MysqlHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO {
    MysqlHelper mysqlHelper;

    public AddressDAO()
    {
        mysqlHelper=new MysqlHelper();
    }

    public List<AddressInfo> GetAddressInfoList(int UserID)
    {
        String sql="select * from address where userid=?";
        List<Object> ps = new ArrayList<Object>();
        ps.add(UserID);
        ResultSet rs = mysqlHelper.executeQuery(sql, ps);
        List<AddressInfo> addressInfoList=new ArrayList<>();
        try {
            rs.last();
            int rowcount = rs.getRow();
            rs.beforeFirst();
            if (rowcount > 0) {
                while (rs.next())
                {
                    AddressInfo addressInfo=new AddressInfo();
                    addressInfo.UserID=rs.getInt("UserID");
                    addressInfo.AddressID=rs.getInt("AddressID");
                    addressInfo.Address=rs.getString("Address");
                    addressInfo.Label=rs.getString("Label");
                    addressInfo.Default=rs.getInt("isDefault");

                    addressInfoList.add(addressInfo);
                }
            return addressInfoList;
            }
            else
            {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    public boolean SetDefaultAddress(int AddressID,int userID)
    {
        String sql="select * from address where isdefault=1 and userid=?";
        List<Object> ps = new ArrayList<Object>();
        ps.add(userID);
        ResultSet rs=mysqlHelper.executeQuery(sql,ps);
        try {
            rs.last();
            int rowcount = rs.getRow();
            rs.beforeFirst();
            if(rowcount>0)
            {
                rs.next();
                int defaultAddressID=rs.getInt("addressid");
                sql="update address set isdefault=0 where addressid=?";
                ps = new ArrayList<Object>();
                ps.add(defaultAddressID);
                boolean result=mysqlHelper.executeUpdate(sql,ps);
                if(result)
                {
                    sql="update address set isdefault=1 where addressid=?";
                    ps = new ArrayList<Object>();
                    ps.add(AddressID);
                    result=mysqlHelper.executeUpdate(sql,ps);
                    return result;
                }
                else
                {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
    public boolean AddAddress(AddressInfo addressInfo)
    {
        String sql="insert into address(userid,address,label,isdefault) values (?,?,?,?)";
        List<Object> ps=new ArrayList<>();
        ps.add(addressInfo.UserID);
        ps.add(addressInfo.Address);
        ps.add(addressInfo.Label);
        ps.add(addressInfo.Default);
        boolean result=mysqlHelper.executeUpdate(sql,ps);
        return result;
    }
    public AddressInfo GetDefaultAddress(int userid)
    {
        String sql="select * from address where isdefault=1 and userid=?";
        List<Object> ps=new ArrayList<>();
        ps.add(userid);
        ResultSet rs=mysqlHelper.executeQuery(sql,ps);
        try {
            rs.last();
            int rowcount = rs.getRow();
            rs.beforeFirst();
            if(rowcount>0)
            {
                rs.next();
                AddressInfo addressInfo=new AddressInfo();
                addressInfo.UserID=rs.getInt("UserID");
                addressInfo.AddressID=rs.getInt("AddressID");
                addressInfo.Address=rs.getString("Address");
                addressInfo.Label=rs.getString("Label");
                addressInfo.Default=rs.getInt("isDefault");
                return addressInfo;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }
}



























