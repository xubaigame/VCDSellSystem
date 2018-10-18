/*
 * Created by JFormDesigner on Tue Oct 16 20:13:47 CST 2018
 */

package Frame;

import java.awt.event.*;
import javax.swing.border.*;
import Model.*;
import Request.*;
import java.awt.*;
import javax.swing.*;

/**
 * @author jframe
 */
public class BuyWindow extends JFrame {
    private CreateOrderRequest createOrderRequest;
    private GetOrderDisRequest getOrderDisRequest;
    DisWindow d;
    private int vcdid=-1;
    private int userid=-1;
    private int addressid=-1;

    public BuyWindow(DisWindow d) {
        this.d=d;
        initComponents();
        InitFrame();

    }

    private void BuyButtonMouseClicked(MouseEvent e) {
        if(vcdid!=-1&&userid!=-1&&addressid!=-1)
            createOrderRequest.SendRequest(vcdid,userid,addressid);
    }

    private void CancelButtonMouseClicked(MouseEvent e) {
        CloseWindow();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        VCDInfo = new JPanel();
        VCDNameLabel = new JLabel();
        VCDNameText = new JLabel();
        SingerNameLabel = new JLabel();
        SingerNameText = new JLabel();
        VCDPriceLabel = new JLabel();
        VCDPriceText = new JLabel();
        AddressInfo = new JPanel();
        AddressScrollPane = new JScrollPane();
        AddressDisText = new JTextArea();
        AddressLabelText = new JLabel();
        UserInfo = new JPanel();
        UserIDText = new JLabel();
        UserNameText = new JLabel();
        UserAgeText = new JLabel();
        BuyButton = new JButton();
        CancelButton = new JButton();
        BG = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== VCDInfo ========
        {
            VCDInfo.setOpaque(false);
            VCDInfo.setLayout(null);

            //---- VCDNameLabel ----
            VCDNameLabel.setText("\u4e13\u8f91\u540d\u79f0:");
            VCDNameLabel.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 18));
            VCDNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            VCDNameLabel.setBorder(new EtchedBorder());
            VCDInfo.add(VCDNameLabel);
            VCDNameLabel.setBounds(250, 0, 85, 65);

            //---- VCDNameText ----
            VCDNameText.setText("\u4e13\u8f91\u540d\u79f0:");
            VCDNameText.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 18));
            VCDNameText.setHorizontalAlignment(SwingConstants.LEFT);
            VCDNameText.setBorder(new EtchedBorder());
            VCDInfo.add(VCDNameText);
            VCDNameText.setBounds(350, 0, 140, 65);

            //---- SingerNameLabel ----
            SingerNameLabel.setText("\u6b4c\u624b\u540d\u79f0:");
            SingerNameLabel.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 18));
            SingerNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            SingerNameLabel.setBorder(new EtchedBorder());
            VCDInfo.add(SingerNameLabel);
            SingerNameLabel.setBounds(0, 0, 85, 65);

            //---- SingerNameText ----
            SingerNameText.setText("\u6b4c\u624b\u540d\u79f0:");
            SingerNameText.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 18));
            SingerNameText.setHorizontalAlignment(SwingConstants.LEFT);
            SingerNameText.setBorder(new EtchedBorder());
            VCDInfo.add(SingerNameText);
            SingerNameText.setBounds(95, 0, 140, 65);

            //---- VCDPriceLabel ----
            VCDPriceLabel.setText("\u4e13\u8f91\u5355\u4ef7:");
            VCDPriceLabel.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 18));
            VCDPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            VCDPriceLabel.setBorder(new EtchedBorder());
            VCDInfo.add(VCDPriceLabel);
            VCDPriceLabel.setBounds(505, 0, 85, 65);

            //---- VCDPriceText ----
            VCDPriceText.setText("\u4e13\u8f91\u5355\u4ef7:");
            VCDPriceText.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 18));
            VCDPriceText.setHorizontalAlignment(SwingConstants.LEFT);
            VCDPriceText.setBorder(new EtchedBorder());
            VCDInfo.add(VCDPriceText);
            VCDPriceText.setBounds(605, 0, 140, 65);
        }
        contentPane.add(VCDInfo);
        VCDInfo.setBounds(0, 0, 750, 65);

        //======== AddressInfo ========
        {
            AddressInfo.setOpaque(false);
            AddressInfo.setLayout(null);

            //======== AddressScrollPane ========
            {
                AddressScrollPane.setOpaque(false);

                //---- AddressDisText ----
                AddressDisText.setEditable(false);
                AddressDisText.setBorder(new EtchedBorder());
                AddressDisText.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 20));
                AddressScrollPane.setViewportView(AddressDisText);
            }
            AddressInfo.add(AddressScrollPane);
            AddressScrollPane.setBounds(0, 0, 615, 135);

            //---- AddressLabelText ----
            AddressLabelText.setBorder(new EtchedBorder());
            AddressLabelText.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 20));
            AddressLabelText.setHorizontalAlignment(SwingConstants.CENTER);
            AddressInfo.add(AddressLabelText);
            AddressLabelText.setBounds(615, 0, 135, 135);
        }
        contentPane.add(AddressInfo);
        AddressInfo.setBounds(0, 110, 750, 135);

        //======== UserInfo ========
        {
            UserInfo.setOpaque(false);
            UserInfo.setLayout(null);

            //---- UserIDText ----
            UserIDText.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 36));
            UserIDText.setHorizontalAlignment(SwingConstants.CENTER);
            UserIDText.setBorder(new EtchedBorder());
            UserInfo.add(UserIDText);
            UserIDText.setBounds(0, 0, 140, 70);

            //---- UserNameText ----
            UserNameText.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
            UserNameText.setHorizontalAlignment(SwingConstants.CENTER);
            UserNameText.setBorder(new EtchedBorder());
            UserInfo.add(UserNameText);
            UserNameText.setBounds(140, 0, 400, 70);

            //---- UserAgeText ----
            UserAgeText.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
            UserAgeText.setHorizontalAlignment(SwingConstants.CENTER);
            UserAgeText.setBorder(new EtchedBorder());
            UserInfo.add(UserAgeText);
            UserAgeText.setBounds(540, 0, 210, 70);
        }
        contentPane.add(UserInfo);
        UserInfo.setBounds(0, 300, 750, 70);

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
        BuyButton.setBounds(180, 405, 125, 55);

        //---- CancelButton ----
        CancelButton.setText("\u53d6\u6d88");
        CancelButton.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
        CancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CancelButtonMouseClicked(e);
            }
        });
        contentPane.add(CancelButton);
        CancelButton.setBounds(430, 405, 125, 55);
        contentPane.add(BG);
        BG.setBounds(0, 0, 750, 460);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    public void InitFrame()
    {
        this.setResizable(false); // 去掉窗口的装饰
        this.setBounds(300,200,750,500);
        this.setTitle("VCD购买界面");
        ImageIcon pic1 = new ImageIcon(Image.class.getResource("/image/BG3.png"));
        pic1.setImage(pic1.getImage().getScaledInstance(BG.getWidth(),BG.getHeight(),Image.SCALE_DEFAULT));
        BG.setIcon(pic1);
        getOrderDisRequest=new GetOrderDisRequest(this);
        createOrderRequest=new CreateOrderRequest(this);

    }
    public void OpenWindow(int vcdid,int userid)
    {
        getOrderDisRequest.SendRequest(vcdid,userid);

    }
    public void SetToolTipsText(String message)
    {
        JOptionPane.showMessageDialog(null, message, "购买失败", JOptionPane.ERROR_MESSAGE);
    }
    public void UpdateWindow(VCDInfo vcdInfo,AddressInfo addressInfo)
    {
        User user= ModelManager.Instance().getUser();
        VCDNameText.setText(vcdInfo.VCDName);
        VCDPriceText.setText(String.valueOf(vcdInfo.VCDUnitPrice)+"元");
        SingerNameText.setText(vcdInfo.SingerName);
        vcdid=vcdInfo.VCDID;

        AddressDisText.setText(addressInfo.Address);
        AddressLabelText.setText("标签:"+addressInfo.Label);
        addressid=addressInfo.AddressID;

        UserIDText.setText("ID:"+user.UserID);
        UserNameText.setText(user.UserName);
        UserAgeText.setText(user.UserAge+"岁");
        userid=user.UserID;
    }
    public void CloseWindow()
    {
        this.setVisible(false);
        d.setVisible(true);
        dispose();
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel VCDInfo;
    private JLabel VCDNameLabel;
    private JLabel VCDNameText;
    private JLabel SingerNameLabel;
    private JLabel SingerNameText;
    private JLabel VCDPriceLabel;
    private JLabel VCDPriceText;
    private JPanel AddressInfo;
    private JScrollPane AddressScrollPane;
    private JTextArea AddressDisText;
    private JLabel AddressLabelText;
    private JPanel UserInfo;
    private JLabel UserIDText;
    private JLabel UserNameText;
    private JLabel UserAgeText;
    private JButton BuyButton;
    private JButton CancelButton;
    private JLabel BG;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
