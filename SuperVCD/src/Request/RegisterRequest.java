package Request;

import Connection.ActionCode;
import Connection.RequestCode;
import Connection.ReturnCode;
import Frame.Login;
import Frame.Register;
import Model.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class RegisterRequest extends BaseRequest {
    private Register r;
    public RegisterRequest (Register r)
    {
        this.r=r;
        requestCode = RequestCode.User;
        actionCode = ActionCode.Register;
        RequestManager.getRequestManager().AddRequest(actionCode,this);
    }
    public void SendRequest(User user)
    {
        super.SendRequest(JSON.toJSON(user).toString());
    }

    public void OnResponse(String data)
    {
        ReturnCode rc=ReturnCode.values()[Integer.valueOf(data)];
        if(rc==ReturnCode.Successed)
        {
            r.EnterMainWindow();
        }
        else if(rc==ReturnCode.Fail)
        {
            r.SetToolTipsText("用户名重复");
        }
        else
            r.SetToolTipsText("未知错误，请重新操作！！");
    }
}
