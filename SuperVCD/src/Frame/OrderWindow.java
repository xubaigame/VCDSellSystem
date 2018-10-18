/*
 * Created by JFormDesigner on Wed Oct 17 14:06:42 CST 2018
 */

package Frame;

import Model.ModelManager;
import Model.Order;
import Request.GetOrderListRequest;
import Tool.CreateList;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.jws.WebParam;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author jframe
 */
public class OrderWindow extends JFrame {
    private SellWindow s;
    private GetOrderListRequest getOrderListRequest;
    public OrderWindow(SellWindow s) {
        this.s=s;
        initComponents();
        InitFrame();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                CloseWindow();
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        UserPanel = new JPanel();
        UserNameLabel = new JLabel();
        UserNameText = new JLabel();
        OrderCountLabel = new JLabel();
        OrderCountText = new JLabel();
        UserBG = new JLabel();
        OrderScrollPanel = new JScrollPane();
        OrderListPanel = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== UserPanel ========
        {
            UserPanel.setOpaque(false);
            UserPanel.setLayout(null);

            //---- UserNameLabel ----
            UserNameLabel.setText("\u7528\u6237\u540d:");
            UserNameLabel.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
            UserNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            UserNameLabel.setBorder(new EtchedBorder());
            UserPanel.add(UserNameLabel);
            UserNameLabel.setBounds(0, 0, 110, 90);

            //---- UserNameText ----
            UserNameText.setText("\u7528\u6237\u540d:");
            UserNameText.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
            UserNameText.setHorizontalAlignment(SwingConstants.CENTER);
            UserNameText.setBorder(new EtchedBorder());
            UserPanel.add(UserNameText);
            UserNameText.setBounds(110, 0, 290, 90);

            //---- OrderCountLabel ----
            OrderCountLabel.setText("\u8ba2\u5355\u6570:");
            OrderCountLabel.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
            OrderCountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            OrderCountLabel.setBorder(new EtchedBorder());
            UserPanel.add(OrderCountLabel);
            OrderCountLabel.setBounds(400, 0, 110, 90);

            //---- OrderCountText ----
            OrderCountText.setText("\u8ba2\u5355\u6570:");
            OrderCountText.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
            OrderCountText.setHorizontalAlignment(SwingConstants.CENTER);
            OrderCountText.setBorder(new EtchedBorder());
            UserPanel.add(OrderCountText);
            OrderCountText.setBounds(510, 0, 290, 90);
            UserPanel.add(UserBG);
            UserBG.setBounds(0, 0, 800, 90);
        }
        contentPane.add(UserPanel);
        UserPanel.setBounds(0, 0, 800, 90);

        //======== OrderScrollPanel ========
        {
            OrderScrollPanel.setOpaque(false);

            //======== OrderListPanel ========
            {
                OrderListPanel.setLayout(null);
            }
            OrderScrollPanel.setViewportView(OrderListPanel);
        }
        contentPane.add(OrderScrollPanel);
        OrderScrollPanel.setBounds(0, 90, 800, 430);

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
        this.setBounds(300,200,800,550);
        ImageIcon pic1 = new ImageIcon(Image.class.getResource("/image/BG3.png"));
        pic1.setImage(pic1.getImage().getScaledInstance(UserBG.getWidth(),UserBG.getHeight(),Image.SCALE_DEFAULT));
        UserBG.setIcon(pic1);
        getOrderListRequest=new GetOrderListRequest(this);
    }
    public void SetToolTipsText(String message)
    {
        JOptionPane.showMessageDialog(null, message, "订单信息获取失败", JOptionPane.ERROR_MESSAGE);
    }
    public void UpdateOrderListPanel(int count,List<Order> orderList)
    {
        if(count==0)
        {
            SetToolTipsText("没有订单信息");
            return;
        }
        UserNameText.setText(ModelManager.Instance().getUser().UserID+"");
        OrderCountText.setText(""+count);
        OrderListPanel.setPreferredSize(new Dimension(800,150*count-20));
        List<JPanel> orderPanelList= CreateList.CreateOrderListPanel(orderList);
        for(JPanel panel:orderPanelList)
        {
            panel.setOpaque(false);

            OrderListPanel.add(panel);
        }
        JLabel OrderBG=new JLabel();
        OrderBG.setBounds(0,0,OrderListPanel.getPreferredSize().width,OrderListPanel.getPreferredSize().height);
        ImageIcon pic1 = new ImageIcon(Image.class.getResource("/image/BG3.png"));
        pic1.setImage(pic1.getImage().getScaledInstance(OrderBG.getWidth(),OrderBG.getHeight(),Image.SCALE_DEFAULT));
        OrderBG.setIcon(pic1);
        OrderListPanel.add(OrderBG);
        OrderListPanel.updateUI();
    }
    public void OpenWindow()
    {
        getOrderListRequest.SendRequest(ModelManager.Instance().getUser().UserID);
    }
    public void CloseWindow()
    {
        this.setVisible(false);
        s.setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel UserPanel;
    private JLabel UserNameLabel;
    private JLabel UserNameText;
    private JLabel OrderCountLabel;
    private JLabel OrderCountText;
    private JLabel UserBG;
    private JScrollPane OrderScrollPanel;
    private JPanel OrderListPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
