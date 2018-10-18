package Request;

import Connection.ActionCode;
import Connection.RequestCode;
import Connection.ReturnCode;
import Frame.BuyWindow;
import Model.AddressInfo;
import Model.ModelManager;
import Model.VCDInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class GetOrderDisRequest extends BaseRequest {
    BuyWindow b;
    public GetOrderDisRequest(BuyWindow b)
    {
        this.b=b;
        requestCode = RequestCode.Order;
        actionCode = ActionCode.GetOrderDis;
        RequestManager.getRequestManager().AddRequest(actionCode,this);
    }

    public void SendRequest(int vcdid,int userid)
    {
        JSONObject json=new JSONObject();
        json.put("VCDID",vcdid);
        json.put("UserID",userid);
        super.SendRequest(json.toJSONString());
    }

    public void OnResponse(String data)
    {
        String[]d=data.split("!");
        ReturnCode rc=ReturnCode.values()[Integer.valueOf(d[0])];
        if(rc==ReturnCode.Successed)
        {
            VCDInfo vcdInfo=JSON.parseObject(d[1],VCDInfo.class);
            AddressInfo addressInfo= JSON.parseObject(d[2],AddressInfo.class);
            b.UpdateWindow(vcdInfo,addressInfo);
        }
        else
        {
            b.SetToolTipsText("未知错误!");
        }
    }
}
