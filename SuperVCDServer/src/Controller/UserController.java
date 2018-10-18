package Controller;

import Connection.RequestCode;
import Connection.ReturnCode;
import DAO.UserDAO;
import Model.User;
import Server.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class UserController extends BaseController {

    private UserDAO userDAO;
    public UserController()
    {
        requestCode = RequestCode.User;
        userDAO=new UserDAO();
    }
    public String Login(String data, Client client, Server server)
    {
        JSONObject jsonObject=JSONObject.parseObject(data);

        User user=userDAO.VerifyUser(jsonObject.getString("UserName"),jsonObject.getString("UserPassword"),jsonObject.getString("UserType"));
        if(user!=null)
        {
            return String.valueOf(ReturnCode.Successed.ordinal()+"/"+ JSON.toJSON(user));
        }
        else
        {
            return String.valueOf(ReturnCode.Fail.ordinal());
        }
    }
    public String Register(String data, Client client, Server server)
    {
        User user=JSONObject.parseObject(data,User.class);
        boolean result=userDAO.AddUser(user);
        if(result)
        {
            return String.valueOf(ReturnCode.Successed.ordinal());
        }
        else
        {
            return String.valueOf(ReturnCode.Fail.ordinal());
        }
    }
    public String UpdateUserInfo(String data, Client client, Server server)
    {
        User user=JSONObject.parseObject(data,User.class);
        boolean result=userDAO.UpdateUserInfo(user);
        if(result)
        {
            return String.valueOf(ReturnCode.Successed.ordinal()+"/"+ JSON.toJSON(user));
        }
        else
        {
            return String.valueOf(ReturnCode.Fail.ordinal());
        }
    }
}
