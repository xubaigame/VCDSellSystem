package Tool;

import java.sql.*;
import java.util.List;

public class MysqlHelper {
    private static final String Driver="com.mysql.jdbc.Driver";
	//修改自己的链接字符串
    private static final String ConnUrl="jdbc:mysql://49.232.15.95:3306/SuperVCD?useUnicode=true&characterEncoding=UTF-8";
	//修改自己的数据库用户名
    private static final String User="root";
	//修改自己的数据库密码
    private static final String Password="weizhilin815";
    private Connection conn;//数据库的链接对象

    public Connection openConnection()
    {
        try
        {
            Class.forName(Driver);
            conn= DriverManager.getConnection(ConnUrl, User, Password);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }

    public boolean executeUpdate(String sql, List<Object> ps)
    {
        openConnection();
        try
        {
            PreparedStatement pstmt =conn.prepareStatement(sql);
            if(ps!=null)
            {
                for ( int i=1;i<=ps.size();i++)
                {
                    pstmt.setObject(i,ps.get(i-1));
                }
            }
            if(pstmt.executeUpdate()>0)
            {
                return true;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBClose();
        }
        return false;
    }
    public ResultSet executeQuery(String sql, List<Object>ps)
    {
        openConnection();
        try
        {
            PreparedStatement pstmt =conn.prepareStatement(sql);
            if(ps!=null)
            {
                for ( int i=1;i<=ps.size();i++)
                {
                    pstmt.setObject(i,ps.get(i-1));
                }
            }
            ResultSet rs=null;
            rs=pstmt.executeQuery();
            return rs;
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public void DBClose()
    {
        if(conn!=null)
        {
            try
            {
                conn.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
