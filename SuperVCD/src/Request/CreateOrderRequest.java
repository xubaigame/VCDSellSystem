package Request;

import Connection.ActionCode;
import Connection.RequestCode;
import Connection.ReturnCode;
import Frame.AddAddressWindow;
import Frame.BuyWindow;
import Model.AddressInfo;
import Model.ModelManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class CreateOrderRequest extends BaseRequest {
    BuyWindow b;
    public CreateOrderRequest (BuyWindow b)
    {
        this.b=b;
        requestCode = RequestCode.Order;
        actionCode = ActionCode.CreateOrder;
        RequestManager.getRequestManager().AddRequest(actionCode,this);
    }

    public void SendRequest(int vcdid,int userid,int addressid)
    {
        JSONObject json=new JSONObject();
        json.put("VCDID",vcdid);
        json.put("UserID",userid);
        json.put("AddressID",addressid);
        super.SendRequest(json.toJSONString());
    }

    public void OnResponse(String data)
    {
        ReturnCode rc=ReturnCode.values()[Integer.valueOf(data)];
        if(rc==ReturnCode.Successed)
        {
            b.CloseWindow();
        }
        else
        {
            b.SetToolTipsText("未知错误!");
        }
    }
}
