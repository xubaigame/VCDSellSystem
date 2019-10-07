package Request;

import Connection.ActionCode;
import Connection.RequestCode;
import Connection.ReturnCode;
import Frame.AddAddressWindow;
import Frame.AddressWindow;
import Model.AddressInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class AddAddressRequest extends BaseRequest {
    private AddAddressWindow aa;
    public AddAddressRequest (AddAddressWindow aa)
    {
        this.aa=aa;
        requestCode = RequestCode.Address;
        actionCode = ActionCode.AddAddress;
        RequestManager.getRequestManager().AddRequest(actionCode,this);
    }

    public void SendRequest(AddressInfo addressInfo)
    {
        super.SendRequest(JSON.toJSONString(addressInfo));
    }

    public void OnResponse(String data)
    {
        ReturnCode rc=ReturnCode.values()[Integer.valueOf(data)];
        if(rc==ReturnCode.Successed)
        {
            aa.OnRespone();
        }
        else
        {
            aa.SetToolTipsText("未知错误！！");
        }
    }
}
