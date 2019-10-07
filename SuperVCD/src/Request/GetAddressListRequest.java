package Request;

import Connection.ActionCode;
import Connection.RequestCode;
import Connection.ReturnCode;
import Frame.AddressWindow;
import Frame.Login;
import Model.AddressInfo;
import Model.ModelManager;
import Model.User;
import Model.VCDInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class GetAddressListRequest extends BaseRequest {
    AddressWindow a;
    public GetAddressListRequest (AddressWindow a)
    {
        this.a=a;
        requestCode = RequestCode.Address;
        actionCode = ActionCode.GetAddressList;
        RequestManager.getRequestManager().AddRequest(actionCode,this);
    }

    public void SendRequest(int UserID)
    {
        JSONObject json=new JSONObject();
        json.put("UserID",UserID);
        super.SendRequest(json.toJSONString());
    }

    public void OnResponse(String data)
    {
        System.out.println("数据"+data);
        List<AddressInfo> addressInfoList=JSONObject.parseArray(data, AddressInfo.class);
        a.SetAddressList(addressInfoList);
    }
}
