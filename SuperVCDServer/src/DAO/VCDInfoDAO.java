package DAO;

import Model.VCDInfo;
import Model.VCDSong;
import Tool.MysqlHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VCDInfoDAO {
    MysqlHelper mysqlHelper;

    public VCDInfoDAO()
    {
        mysqlHelper=new MysqlHelper();
    }

    public List<VCDInfo> GetAllVCDInfoList(String keyWord,int VcdType)
    {
        List<Object> ps=new ArrayList<>();
        ps.add("%"+keyWord+"%");
        String sql;
        if(VcdType==0)
        {
            sql ="select * from vcdinfo,singer where singer.SingerID=vcdinfo.SingerID and VcdName like ?";
        }
        else
        {
            sql="select * from vcdinfo,singer where singer.SingerID=vcdinfo.SingerID and VcdName like ? and Vcdtype=?";
            ps.add(VcdType);
        }
        ResultSet rs=mysqlHelper.executeQuery(sql,ps);
        List<VCDInfo> vcdInfoList=new ArrayList<>();
        try {
            while(rs.next())
            {
                VCDInfo vcdInfo=new VCDInfo();
                vcdInfo.VCDID=rs.getInt("VCDID");
                vcdInfo.VCDName=rs.getString("VCDName");
                vcdInfo.VCDIcon=rs.getString("VCDIcon");
                vcdInfo.SingerName=rs.getString("SingerName");
                vcdInfo.SingerDis=rs.getString("SingerDis");
                vcdInfo.VCDDescribe=rs.getString("VCDDescribe");
                vcdInfo.VCDUnitPrice=rs.getInt("VCDUnitPrice");
                vcdInfoList.add(vcdInfo);
            }
            return vcdInfoList;
        }
        catch (SQLException e)
        {
            return vcdInfoList;
        }
    }
    public VCDInfo GetVCDDis(int VCDID)
    {
        String sql="select * from vcdinfo,singer where singer.SingerID=vcdinfo.SingerID and VCDID=?";
        List<Object> ps=new ArrayList<>();
        ps.add(VCDID);
        ResultSet rs=mysqlHelper.executeQuery(sql,ps);
        try {
            rs.last();
            int rowcount = rs.getRow();
            rs.beforeFirst();
            if (rowcount > 0)
            {
                rs.next();
                VCDInfo vcdInfo=new VCDInfo();
                vcdInfo.VCDID=rs.getInt("VCDID");
                vcdInfo.VCDName=rs.getString("VCDName");
                vcdInfo.VCDIcon=rs.getString("VCDIcon");
                vcdInfo.SingerName=rs.getString("SingerName");
                vcdInfo.SingerDis=rs.getString("SingerDis");
                vcdInfo.VCDDescribe=rs.getString("VCDDescribe");
                vcdInfo.VCDUnitPrice=rs.getInt("VCDUnitPrice");
                return vcdInfo;
            }
            return null;
        }
        catch (SQLException e)
        {
            return null;
        }
    }
    public List<VCDSong> GetVcdSongList(int VCDID)
    {
        String sql="select * from VCDSong where VCDID=?";
        List<Object> ps=new ArrayList<>();
        ps.add(VCDID);
        ResultSet rs=mysqlHelper.executeQuery(sql,ps);
        try {
            rs.last();
            int rowcount = rs.getRow();
            rs.beforeFirst();
            if (rowcount > 0)
            {
                List<VCDSong> songList=new ArrayList<>();
                while(rs.next())
                {
                    VCDSong vcdSong=new VCDSong();
                    vcdSong.VCDID=rs.getInt("VCDID");
                    vcdSong.VCDSongName=rs.getString("VCDSongName");
                    vcdSong.VCDSongID=rs.getInt("VCDSongID");
                    vcdSong.VCDSongTime=rs.getInt("VCDSongTime");
                    vcdSong.VCDSongPath=rs.getString("VCDSongPath");
                    songList.add(vcdSong);
                }
                return songList;
            }
            return null;
        }
        catch (SQLException e)
        {
            return null;
        }
    }
}
