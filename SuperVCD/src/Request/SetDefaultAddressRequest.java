package Request;

import Connection.ActionCode;
import Connection.RequestCode;
import Connection.ReturnCode;
import Frame.AddressWindow;
import Frame.SellWindow;
import Model.ModelManager;
import Model.VCDInfo;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class SetDefaultAddressRequest extends BaseRequest {
    private AddressWindow a;
    public SetDefaultAddressRequest (AddressWindow a)
    {
        this.a=a;
        requestCode = RequestCode.Address;
        actionCode = ActionCode.SetDefaultAddress;
        RequestManager.getRequestManager().AddRequest(actionCode,this);
    }
    public void SendRequest(int AddressID)
    {
        JSONObject json=new JSONObject();
        json.put("AddressID",AddressID);
        json.put("UserID", ModelManager.Instance().getUser().UserID);
        super.SendRequest(json.toJSONString());
    }

    public void OnResponse(String data)
    {
        ReturnCode rc=ReturnCode.values()[Integer.valueOf(data)];
        if(rc==ReturnCode.Successed)
        {
            a.UpdateList();
        }
        else
        {
            a.SetToolTipsText("未知错误！！");
        }
    }
}

