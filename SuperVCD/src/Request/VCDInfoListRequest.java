package Request;

import Connection.*;
import Frame.*;
import Model.*;
import com.alibaba.fastjson.*;
import java.util.*;

public class VCDInfoListRequest extends BaseRequest {
    private SellWindow s;
    public VCDInfoListRequest (SellWindow s)
    {
        this.s=s;
        requestCode = RequestCode.MainWindow;
        actionCode = ActionCode.GetVCDInfoList;
        RequestManager.getRequestManager().AddRequest(actionCode,this);
    }
    public void SendRequest(String word,int VcdType)
    {
        JSONObject json=new JSONObject();
        json.put("KeyWord",word);
        json.put("VCDType",VcdType);

        super.SendRequest(json.toJSONString());
    }

    public void OnResponse(String data)
    {
        System.out.println(data);
        List<VCDInfo> vcdInfoList = JSONObject.parseArray(data, VCDInfo.class);
        s.SetVCDInfoList(vcdInfoList.size(),vcdInfoList);
    }
}
