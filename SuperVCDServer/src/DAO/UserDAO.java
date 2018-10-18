package DAO;

import Model.User;
import Tool.*;

import javax.swing.text.StyledEditorKit;
import java.nio.file.ClosedWatchServiceException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    MysqlHelper mysqlHelper;

    public UserDAO()
    {
        mysqlHelper=new MysqlHelper();
    }

    public User VerifyUser(String UserName, String Password, String UserType)
    {
        String sql="select * from user where username =? and password =? and usertype=? ";
        //String sql="select * from user where username =? and password =? and usertype='user' ";
        List<Object> ps=new ArrayList<Object>();
        ps.add(UserName);
        ps.add(Password);
        ps.add(UserType);
       ResultSet rs= mysqlHelper.executeQuery(sql,ps);
        try {
            rs.last();
            int rowcount = rs.getRow();
            rs.beforeFirst();
            if(rowcount>0)
            {
                rs.next();
                User user=new User();
                user.UserID=rs.getInt("UserID");
                user.UserName=rs.getString("UserName");
                user.Name=rs.getString("Name");
                user.UserAge=rs.getInt("UserAge");
                return user;
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
    public boolean UserIsExist(String UserName) {
        String sql = "select * from user where username =?";
        List<Object> ps = new ArrayList<Object>();
        ps.add(UserName);
        ResultSet rs = mysqlHelper.executeQuery(sql, ps);
        try {
            rs.last();
            int rowcount = rs.getRow();
            rs.beforeFirst();
            if (rowcount > 0) {
                return true;
            }
            else
            {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    public boolean AddUser(User user)
    {
        if (UserIsExist(user.UserName))
        {
            return false;
        }
        String sql="insert into user(username,Name,UserAge,password,usertype) values(?,?,?,?,?)";
        //String sql="select * from user where username =? and password =? and usertype='user' ";
        List<Object> ps=new ArrayList<Object>();
        ps.add(user.UserName);
        ps.add(user.Name);
        ps.add(user.UserAge);
        ps.add(user.Password);
        ps.add(user.UserType);
       return mysqlHelper.executeUpdate(sql,ps);
    }
    public boolean UpdateUserInfo(User user)
    {
        String sql="update user set Name=?,UserAge=?,Password=? where UserID=?";
        List<Object> ps=new ArrayList<Object>();
        ps.add(user.Name);
        ps.add(user.UserAge);
        ps.add(user.Password);
        ps.add(user.UserID);
        return mysqlHelper.executeUpdate(sql,ps);
    }
}
