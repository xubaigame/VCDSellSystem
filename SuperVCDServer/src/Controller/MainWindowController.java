package Controller;

import Connection.RequestCode;
import Connection.ReturnCode;
import DAO.*;
import Model.*;
import Server.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class MainWindowController extends BaseController {
    VCDInfoDAO vcdInfoDAO;
    public MainWindowController()
    {
        requestCode = RequestCode.MainWindow;
        vcdInfoDAO=new VCDInfoDAO();
    }

    public String GetVCDInfoList(String data, Client client, Server server)
    {

        JSONObject jsonObject=JSON.parseObject(data);
        String KeyWord=jsonObject.getString("KeyWord");
        int vcdType=jsonObject.getInteger("VCDType");
        List<VCDInfo> vcdInfoList=new ArrayList<>();
        vcdInfoList=vcdInfoDAO.GetAllVCDInfoList(KeyWord,vcdType);

        String vcdInfoListJson= JSON.toJSONString(vcdInfoList);
        return vcdInfoListJson;
    }
    public String GetVCDDis(String data, Client client, Server server)
    {
        int vcdID=JSON.parseObject(data).getInteger("VCDID");
        VCDInfo vcdInfo=vcdInfoDAO.GetVCDDis(vcdID);
        if(vcdInfo!=null)
        {
            List<VCDSong> songList=new ArrayList<>();
            songList=vcdInfoDAO.GetVcdSongList(vcdID);
            if(songList!=null)
            {
                return String.valueOf(ReturnCode.Successed.ordinal()+"!"+JSON.toJSONString(vcdInfo)+"!"+JSON.toJSONString(songList));
            }
            return String.valueOf(ReturnCode.Fail.ordinal());
        }
        return String.valueOf(ReturnCode.Fail.ordinal());
    }
}
