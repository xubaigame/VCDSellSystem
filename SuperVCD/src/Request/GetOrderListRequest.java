package Request;

import Connection.ActionCode;
import Connection.RequestCode;
import Connection.ReturnCode;
import Frame.OrderWindow;
import Model.AddressInfo;
import Model.Order;
import Model.VCDInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class GetOrderListRequest extends BaseRequest {
    private OrderWindow o;
    public GetOrderListRequest (OrderWindow o)
    {
        this.o=o;
        requestCode = RequestCode.Order;
        actionCode = ActionCode.GetOrderList;
        RequestManager.getRequestManager().AddRequest(actionCode,this);
    }
    public void SendRequest(int userID)
    {

        JSONObject json=new JSONObject();
        json.put("UserID",userID);
        super.SendRequest(json.toJSONString());
    }

    public void OnResponse(String data)
    {
        String[]d=data.split("!");
        ReturnCode rc=ReturnCode.values()[Integer.valueOf(d[0])];
        if(rc==ReturnCode.Successed)
        {
            List<Order> orderList=JSON.parseArray(d[1],Order.class);
            o.UpdateOrderListPanel(orderList.size(),orderList);
    }
        else
        {
            o.SetToolTipsText("没有订单信息!");
        }
    }
}
