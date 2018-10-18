package Request;
import Connection.*;
import Frame.DisWindow;
import Model.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class GetVCDDisRequest extends BaseRequest {
    private DisWindow d;
    public GetVCDDisRequest (DisWindow d)
    {
        this.d=d;
        requestCode = RequestCode.MainWindow;
        actionCode = ActionCode.GetVCDDis;
        RequestManager.getRequestManager().AddRequest(actionCode,this);
    }

    public void SendRequest(int VCDID)
    {
        JSONObject json=new JSONObject();
        json.put("VCDID",VCDID);
        super.SendRequest(json.toJSONString());
    }

    public void OnResponse(String data)
    {
        String []da=data.split("!");
        ReturnCode rc=ReturnCode.values()[Integer.valueOf(da[0])];
        if(rc==ReturnCode.Successed)
        {
            VCDInfo vcdInfo= JSON.parseObject(da[1],VCDInfo.class);
            List<VCDSong> songList=JSON.parseArray(da[2],VCDSong.class);
            d.UpdateWindowInfo(vcdInfo);
            d.SetSongListScrollPanel(songList.size(),songList);
        }
        else if(rc==ReturnCode.Fail)
        {
            d.SetToolTipsText("专辑不存在!");
        }
        else
            d.SetToolTipsText("未知错误，请重新获取！！");
    }
}
