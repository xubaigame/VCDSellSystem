package Request;

import Connection.ActionCode;
import Connection.RequestCode;
import Connection.ReturnCode;
import Frame.Login;
import Frame.SellWindow;
import Frame.UserWindow;
import Model.ModelManager;
import Model.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class UpdateUserInfo extends BaseRequest {
    private UserWindow u;
    public UpdateUserInfo (UserWindow u)
    {
        this.u=u;
        requestCode = RequestCode.User;
        actionCode = ActionCode.UpdateUserInfo;
        RequestManager.getRequestManager().AddRequest(actionCode,this);
    }
    public void SendRequest(User user)
    {
        super.SendRequest(JSON.toJSON(user).toString());
    }

    public void OnResponse(String data)
    {
        String []d=data.split("/");
        ReturnCode rc=ReturnCode.values()[Integer.valueOf(d[0])];
        if(rc==ReturnCode.Successed)
        {
            User user= JSON.parseObject(d[1],User.class);
            ModelManager.Instance().setUser(user);
            u.UpdateSucceedCallBack();
        }
        else
        {
            u.SetToolTipsText("未知错误,请重试!");
        }
    }
}
