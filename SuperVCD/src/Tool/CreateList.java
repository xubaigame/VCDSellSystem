package Tool;
import Model.*;
import Frame.*;
import Request.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class CreateList {
    public static List<JPanel> CreateVCDInfoPanel(List<VCDInfo> vcdInfoList, DisWindow disWindow)
    {
        List<JPanel> jPanelList=new ArrayList<>();
        for(int i=0;i<vcdInfoList.size();i++)
        {
            JPanel panel=CreateVCDInfoPanelItem(vcdInfoList.get(i),disWindow);
            panel.setBounds(0,i*170,800,150);
            panel.setBackground(Color.WHITE);
            panel.setOpaque(false);
            jPanelList.add(panel);
        }
        return jPanelList;
    }

    private static JPanel CreateVCDInfoPanelItem(VCDInfo vcdInfo,DisWindow disWindow)
    {
        //System.out.println(vcdInfo.VCDID+":"+vcdInfo.VCDName+":"+vcdInfo.VCDIcon+":"+vcdInfo.VCDSingerName+":"+vcdInfo.VCDDescribe+":"+vcdInfo.VCDUnitPrice);
        //Border lineBorder = BorderFactory.createLineBorder(Color.green);
        Border lineBorder=BorderFactory.createEtchedBorder();
        Font F_Size1 = new Font("方正舒体",Font.PLAIN,28);
        Font F_Size2 = new Font("方正舒体",Font.PLAIN,18);

        JPanel panel=new JPanel();
        panel.setName("VCDInfoPanel");
        panel.setLayout(null);

        JLabel icon=new JLabel("");
        icon.setBounds(0,0,150,150);
        icon.setName("Icon");
        icon.setBorder(lineBorder);
        ImageIcon pic1 = new ImageIcon(Image.class.getResource(vcdInfo.VCDIcon));
        pic1.setImage(pic1.getImage().getScaledInstance(icon.getWidth(),icon.getHeight(),Image.SCALE_DEFAULT));
        icon.setIcon(pic1);

        JLabel name=new JLabel("VCD名字",JLabel.CENTER);
        name.setBounds(150,0,650,40);
        name.setName("name");
        name.setBorder(lineBorder);
        name.setFont(F_Size1);
        name.setText(vcdInfo.VCDName);

        JLabel price=new JLabel("VCD价格",JLabel.CENTER);
        price.setBounds(600,80,100,70);
        price.setName("price");
        price.setBorder(lineBorder);
        price.setFont(F_Size2);
        price.setText(String.valueOf(vcdInfo.VCDUnitPrice)+"元");

        JLabel dis=new JLabel("VCD详细信息",JLabel.CENTER);
        dis.setBounds(150,80,450,70);
        dis.setName("dis");
        dis.setBorder(lineBorder);
        dis.setFont(F_Size2);
        dis.setText(vcdInfo.VCDDescribe);

        JLabel singerName=new JLabel("VCD歌手名字",JLabel.CENTER);
        singerName.setBounds(150,40,650,40);
        singerName.setName("singerName");
        singerName.setBorder(lineBorder);
        singerName.setFont(F_Size1);
        singerName.setText(vcdInfo.SingerName);

        JButton disButton=new JButton("详情");
        disButton.setBounds(700,80,100,70);
        disButton.setName("disButton");
        disButton.setFont(F_Size1);
        disButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disWindow.OpenWindow(vcdInfo.VCDID);
                disWindow.setVisible(true);
            }
        });


        panel.add(icon);
        panel.add(name);
        panel.add(singerName);
        panel.add(dis);
        panel.add(price);
        panel.add(disButton);
        return panel;
    }

    public static JPanel CreateAddressPanel(AddressInfo addressInfo, boolean isdefault, SetDefaultAddressRequest setDefaultAddressRequest)
    {
        System.out.println(addressInfo.Address+" "+addressInfo.Label);

        Border lineBorder=BorderFactory.createEtchedBorder();
        Font F_Size1 = new Font("方正舒体",Font.PLAIN,28);
        Font F_Size2 = new Font("方正舒体",Font.PLAIN,18);

        JPanel panel=new JPanel();
        panel.setName("AddressPanel");
        panel.setLayout(null);

        JLabel Address=new JLabel("用户详细地址");
        Address.setBounds(0,0,700,150);
        Address.setName("Address");
        Address.setBorder(lineBorder);
        Address.setFont(F_Size2);
        Address.setText(addressInfo.Address);
        Address.setHorizontalAlignment(0);

        JLabel Label=new JLabel("地址标签");
        Label.setHorizontalAlignment(0);
        Label.setName("Label");
        Label.setBorder(lineBorder);
        Label.setFont(F_Size1);


        JLabel BG=new JLabel("背景图片");
        BG.setBounds(0,0,900,150);
        ImageIcon pic1 = new ImageIcon(Image.class.getResource("/image/BG3.png"));
        pic1.setImage(pic1.getImage().getScaledInstance(BG.getWidth(),BG.getHeight(),Image.SCALE_DEFAULT));
        BG.setIcon(pic1);

        panel.add(Address);
        panel.add(Label);
        panel.add(BG);
        if(isdefault==false)
        {
            JButton SetDefaultButton=new JButton("设为默认");
            SetDefaultButton.setBounds(700,50,200,100);
            SetDefaultButton.setName("disButton");
            SetDefaultButton.setFont(F_Size1);
            SetDefaultButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setDefaultAddressRequest.SendRequest(addressInfo.AddressID);
                }
            });

            panel.add(SetDefaultButton);
            Label.setBounds(700,0,200,50);
            Label.setText("标签："+addressInfo.Label);
        }
        else
        {
            Label.setBounds(700,0,200,150);

            Label.setText("标签：\n"+addressInfo.Label);
        }
        return panel;
    }

    public static  List<JPanel> CreateAddressPanelList(List<AddressInfo>addressInfoList,SetDefaultAddressRequest setDefaultAddressRequest)
    {
        List<JPanel> jPanelList=new ArrayList<>();
        for(int i=0;i<addressInfoList.size();i++)
        {
            JPanel panel=new JPanel();
            panel=CreateAddressPanel(addressInfoList.get(i),false,setDefaultAddressRequest);
            panel.setBounds(0,i*170,900,150);
            jPanelList.add(panel);
        }
        return jPanelList;
    }

    public static List<JPanel> CreateVCDSongListPanel(List<VCDSong> songList)
    {
        List<JPanel> songListPanel=new ArrayList<>();
        for(int i=0;i<songList.size();i++)
        {
            MusicPanel musicPanel=new MusicPanel(songList.get(i));
            musicPanel.setBounds(0,60*i,750,50);
            songListPanel.add(musicPanel);
        }
        return songListPanel;
    }

    public static List<JPanel> CreateOrderListPanel(List<Order> songList)
    {
        List<JPanel> orderListPanel=new ArrayList<>();
        for(int i=0;i<songList.size();i++)
        {
            OrderPanel panel= new OrderPanel(songList.get(i));
            panel.setBounds(0,i*150,800,130);
            orderListPanel.add(panel);
        }
        return orderListPanel;
    }
}
