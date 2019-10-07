/*
 * Created by JFormDesigner on Sun Oct 07 12:34:03 CST 2018
 */

package Frame;

import java.awt.event.*;

import Model.ModelManager;
import Model.User;
import Model.VCDInfo;
import Model.VCDSong;
import Request.GetVCDDisRequest;
import Tool.CreateList;

import java.awt.*;
import java.util.List;
import javax.swing.*;

/**
 * @author jframe
 */
public class DisWindow extends JFrame {
    private BuyWindow b;
    private int VCDID;
    private GetVCDDisRequest getVCDDisRequest;
    public DisWindow()
    {
        initComponents();
        b=new BuyWindow(this);
        getVCDDisRequest=new GetVCDDisRequest(this);
    }

    public void OpenWindow(int VCDID)
    {
        this.VCDID=VCDID;
        getVCDDisRequest.SendRequest(VCDID);
    }
    public void SetToolTipsText(String message)
    {
        JOptionPane.showMessageDialog(null, message, "获取详细信息失败", JOptionPane.ERROR_MESSAGE);
    }

    public void UpdateWindowInfo(VCDInfo vcdInfo)
    {
        VCDNameText.setText(vcdInfo.VCDName);
        ImageIcon pic1 = new ImageIcon(Image.class.getResource(vcdInfo.VCDIcon));
        pic1.setImage(pic1.getImage().getScaledInstance(VCDIcon.getWidth(),VCDIcon.getHeight(),Image.SCALE_DEFAULT));
        VCDIcon.setIcon(pic1);
        VCDPriceText.setText(String.valueOf(vcdInfo.VCDUnitPrice)+"元");
        VCDSingerNameText.setText(vcdInfo.SingerName);
        VCDTotalTimeText.setText("计算");
        VCDDIsTextArea.setText(vcdInfo.VCDDescribe);
        VCDSingerDisTextArea.setText(vcdInfo.SingerDis);
    }

    public void SetSongListScrollPanel(int count,List<VCDSong> songList)
    {
        MusicListPane.removeAll();
        MusicListPane.setPreferredSize(new Dimension(750,60*count-10));
        List<JPanel> songListPanel= CreateList.CreateVCDSongListPanel(songList);

        for(JPanel panel:songListPanel)
        {
            MusicListPane.add(panel);
        }
        MusicListPane.updateUI();
    }

    private void BuyButtonMouseClicked(MouseEvent e) {
        this.setVisible(false);
        b.setVisible((true));
        b.OpenWindow(VCDID, ModelManager.Instance().getUser().UserID);
        // TODO add your code here
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        VCDIcon = new JLabel();
        VCDNameLabel = new JLabel();
        VCDSingerNameLabel = new JLabel();
        VCDPriceLabel = new JLabel();
        VCDTotalTimeLabel = new JLabel();
        VCDNameText = new JLabel();
        VCDSingerNameText = new JLabel();
        VCDPriceText = new JLabel();
        VCDTotalTimeText = new JLabel();
        BuyButton = new JButton();
        VCDSingerDisLabel = new JLabel();
        VCDSingerDisPane = new JScrollPane();
        VCDSingerDisTextArea = new JTextArea();
        VCDSingerDisLabel2 = new JLabel();
        VCDDisPane = new JScrollPane();
        VCDDIsTextArea = new JTextArea();
        MusicListScrollPane = new JScrollPane();
        MusicListPane = new JPanel();
        BG = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(VCDIcon);
        VCDIcon.setBounds(505, 45, 150, 150);

        //---- VCDNameLabel ----
        VCDNameLabel.setText("\u4e13\u8f91\u540d\u79f0\uff1a");
        VCDNameLabel.setFont(new Font("Futura", Font.PLAIN, 18));
        VCDNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(VCDNameLabel);
        VCDNameLabel.setBounds(25, 40, 95, 35);

        //---- VCDSingerNameLabel ----
        VCDSingerNameLabel.setText("\u6b4c\u624b\u540d\u79f0\uff1a");
        VCDSingerNameLabel.setFont(new Font("Futura", Font.PLAIN, 18));
        VCDSingerNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(VCDSingerNameLabel);
        VCDSingerNameLabel.setBounds(25, 80, 95, 35);

        //---- VCDPriceLabel ----
        VCDPriceLabel.setText("\u4e13\u8f91\u5355\u4ef7\uff1a");
        VCDPriceLabel.setFont(new Font("Futura", Font.PLAIN, 18));
        VCDPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(VCDPriceLabel);
        VCDPriceLabel.setBounds(25, 125, 95, 35);

        //---- VCDTotalTimeLabel ----
        VCDTotalTimeLabel.setText("\u603b\u65f6\u957f\uff1a");
        VCDTotalTimeLabel.setFont(new Font("Futura", Font.PLAIN, 18));
        VCDTotalTimeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(VCDTotalTimeLabel);
        VCDTotalTimeLabel.setBounds(25, 165, 95, 35);

        //---- VCDNameText ----
        VCDNameText.setText("\u4e13\u8f91\u540d\u79f0\uff1a");
        VCDNameText.setFont(new Font("Futura", Font.PLAIN, 18));
        VCDNameText.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(VCDNameText);
        VCDNameText.setBounds(130, 40, 95, 35);

        //---- VCDSingerNameText ----
        VCDSingerNameText.setText("\u6b4c\u624b\u540d\u79f0\uff1a");
        VCDSingerNameText.setFont(new Font("Futura", Font.PLAIN, 18));
        VCDSingerNameText.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(VCDSingerNameText);
        VCDSingerNameText.setBounds(130, 80, 95, 35);

        //---- VCDPriceText ----
        VCDPriceText.setText("\u4e13\u8f91\u5355\u4ef7\uff1a");
        VCDPriceText.setFont(new Font("Futura", Font.PLAIN, 18));
        VCDPriceText.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(VCDPriceText);
        VCDPriceText.setBounds(130, 125, 95, 35);

        //---- VCDTotalTimeText ----
        VCDTotalTimeText.setText("\u603b\u65f6\u957f\uff1a");
        VCDTotalTimeText.setFont(new Font("Futura", Font.PLAIN, 18));
        VCDTotalTimeText.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(VCDTotalTimeText);
        VCDTotalTimeText.setBounds(130, 165, 95, 35);

        //---- BuyButton ----
        BuyButton.setText("\u8d2d\u4e70");
        BuyButton.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
        BuyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                BuyButtonMouseClicked(e);
            }
        });
        contentPane.add(BuyButton);
        BuyButton.setBounds(505, 200, 150, 40);

        //---- VCDSingerDisLabel ----
        VCDSingerDisLabel.setText("\u6b4c\u624b\u7b80\u4ecb\uff1a");
        VCDSingerDisLabel.setFont(new Font("Futura", Font.PLAIN, 18));
        VCDSingerDisLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(VCDSingerDisLabel);
        VCDSingerDisLabel.setBounds(25, 255, 95, 35);

        //======== VCDSingerDisPane ========
        {

            //---- VCDSingerDisTextArea ----
            VCDSingerDisTextArea.setLineWrap(true);
            VCDSingerDisTextArea.setEditable(false);
            VCDSingerDisTextArea.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 18));
            VCDSingerDisPane.setViewportView(VCDSingerDisTextArea);
        }
        contentPane.add(VCDSingerDisPane);
        VCDSingerDisPane.setBounds(30, 290, 720, 85);

        //---- VCDSingerDisLabel2 ----
        VCDSingerDisLabel2.setText("\u4e13\u8f91\u7b80\u4ecb\uff1a");
        VCDSingerDisLabel2.setFont(new Font("Futura", Font.PLAIN, 18));
        VCDSingerDisLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(VCDSingerDisLabel2);
        VCDSingerDisLabel2.setBounds(25, 395, 95, 35);

        //======== VCDDisPane ========
        {

            //---- VCDDIsTextArea ----
            VCDDIsTextArea.setLineWrap(true);
            VCDDIsTextArea.setEditable(false);
            VCDDIsTextArea.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 18));
            VCDDisPane.setViewportView(VCDDIsTextArea);
        }
        contentPane.add(VCDDisPane);
        VCDDisPane.setBounds(30, 435, 720, 85);

        //======== MusicListScrollPane ========
        {

            //======== MusicListPane ========
            {
                MusicListPane.setLayout(null);
            }
            MusicListScrollPane.setViewportView(MusicListPane);
        }
        contentPane.add(MusicListScrollPane);
        MusicListScrollPane.setBounds(0, 570, 750, 255);
        contentPane.add(BG);
        BG.setBounds(0, 0, 750, 825);

        contentPane.setPreferredSize(new Dimension(750, 850));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel VCDIcon;
    private JLabel VCDNameLabel;
    private JLabel VCDSingerNameLabel;
    private JLabel VCDPriceLabel;
    private JLabel VCDTotalTimeLabel;
    private JLabel VCDNameText;
    private JLabel VCDSingerNameText;
    private JLabel VCDPriceText;
    private JLabel VCDTotalTimeText;
    private JButton BuyButton;
    private JLabel VCDSingerDisLabel;
    private JScrollPane VCDSingerDisPane;
    private JTextArea VCDSingerDisTextArea;
    private JLabel VCDSingerDisLabel2;
    private JScrollPane VCDDisPane;
    private JTextArea VCDDIsTextArea;
    private JScrollPane MusicListScrollPane;
    private JPanel MusicListPane;
    private JLabel BG;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
