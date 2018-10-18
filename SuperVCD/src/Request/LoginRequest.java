package Request;

import Connection.*;
import Frame.Login;
import Model.ModelManager;
import Model.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import sun.rmi.runtime.Log;

public class LoginRequest extends BaseRequest {
    private Login l;
    public LoginRequest (Login l)
    {
        this.l=l;
        requestCode = RequestCode.User;
        actionCode = ActionCode.Login;
        RequestManager.getRequestManager().AddRequest(actionCode,this);
    }
    public void SendRequest(String username, String password,String usertype)
    {
        JSONObject json=new JSONObject();
        json.put("UserName",username);
        json.put("UserPassword",password);
        json.put("UserType",usertype);
        super.SendRequest(json.toJSONString());
    }

    public void OnResponse(String data)
    {
        String []d=data.split("/");
        ReturnCode rc=ReturnCode.values()[Integer.valueOf(d[0])];
        if(rc==ReturnCode.Successed)
        {
            User user= JSON.parseObject(d[1],User.class);
            ModelManager.Instance().setUser(user);
            l.EnterMainWindow();
        }
        else if(rc==ReturnCode.Fail)
        {
            l.SetToolTipsText("用户名或密码错误!");
        }
        else
            l.SetToolTipsText("未知错误，请重新登录！！");
    }
}
