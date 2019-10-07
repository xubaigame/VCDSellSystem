/*
 * Created by JFormDesigner on Mon Oct 08 14:24:39 CST 2018
 */

package Frame;

import java.awt.event.*;
import Model.AddressInfo;
import Model.ModelManager;
import Model.Order;
import Model.User;
import Request.GetAddressListRequest;
import Request.SetDefaultAddressRequest;
import Tool.CreateList;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 * @author jframe
 */
public class AddressWindow extends JFrame {
    private SellWindow s;
    private AddAddressWindow aa;
    private GetAddressListRequest getAddressListRequest;
    private SetDefaultAddressRequest setDefaultAddressRequest;
    public AddressWindow(SellWindow s) {
        this.s=s;
        initComponents();
        InitFrame();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                CloseWindow();
            }
        });
    }

    private void AddAddressButtonMouseClicked(MouseEvent e) {
        aa.setVisible(true);
        this.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        DefaultLabel = new JLabel();
        AllAddressLabel = new JLabel();
        DefaultPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        AddressListPanel = new JPanel();
        AddAddressButton = new JButton();
        BG = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- DefaultLabel ----
        DefaultLabel.setText("\u9ed8\u8ba4\u5730\u5740:");
        DefaultLabel.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
        DefaultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(DefaultLabel);
        DefaultLabel.setBounds(0, 0, 150, 50);

        //---- AllAddressLabel ----
        AllAddressLabel.setText("\u6240\u6709\u5730\u5740:");
        AllAddressLabel.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
        AllAddressLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(AllAddressLabel);
        AllAddressLabel.setBounds(0, 200, 150, 50);

        //======== DefaultPanel ========
        {
            DefaultPanel.setLayout(null);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < DefaultPanel.getComponentCount(); i++) {
                    Rectangle bounds = DefaultPanel.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = DefaultPanel.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                DefaultPanel.setMinimumSize(preferredSize);
                DefaultPanel.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(DefaultPanel);
        DefaultPanel.setBounds(0, 50, 900, 150);

        //======== scrollPane1 ========
        {
            scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

            //======== AddressListPanel ========
            {
                AddressListPanel.setLayout(null);
            }
            scrollPane1.setViewportView(AddressListPanel);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 250, 900, 420);

        //---- AddAddressButton ----
        AddAddressButton.setText("\u65b0\u589e\u6536\u83b7\u5730\u5740");
        AddAddressButton.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
        AddAddressButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddAddressButtonMouseClicked(e);
            }
        });
        contentPane.add(AddAddressButton);
        AddAddressButton.setBounds(685, 0, 215, 50);
        contentPane.add(BG);
        BG.setBounds(0, 0, 900, 670);

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
    private void InitFrame()
    {
        this.setResizable(false); // 去掉窗口的装饰
        this.setBounds(300,200,900,700);
        aa=new AddAddressWindow(this);
        getAddressListRequest=new GetAddressListRequest(this);
        setDefaultAddressRequest=new SetDefaultAddressRequest(this);
    }

    public void SetAddressList(List<AddressInfo> addressInfoList)
    {
        this.setTitle("收货地址管理");
        if(addressInfoList==null)
        {
            SetToolTipsText("没有收获地址");
            return;
        }
        DefaultPanel.removeAll();
        AddressListPanel.removeAll();
        int index=-1;
        for(int i=0;i<addressInfoList.size();i++)
        {
            if(addressInfoList.get(i).Default==1)
            {
                index=i;
            }
        }
        if(index!=-1)
        {
            JPanel panel=CreateList.CreateAddressPanel(addressInfoList.get(index),true, setDefaultAddressRequest);
            panel.setBounds(0,0,900,150);
            DefaultPanel.add(panel);
            DefaultPanel.updateUI();
            addressInfoList.remove(index);
        }
        List<JPanel> jPanelList=CreateList.CreateAddressPanelList(addressInfoList, setDefaultAddressRequest);
        AddressListPanel.setPreferredSize(new Dimension(900,170*jPanelList.size()-20));
        for(JPanel jPanel:jPanelList)
        {
            AddressListPanel.add(jPanel);
        }
        AddressListPanel.updateUI();
    }
    public void OpenWindow(User user)
    {
        UpdateList();
    }
    public void CloseWindow()
    {
        this.setVisible(false);
        s.setVisible(true);
        this.dispose();
    }
    public void UpdateList()
    {
        getAddressListRequest.SendRequest(ModelManager.Instance().getUser().UserID);
    }
    public void SetToolTipsText(String message)
    {
        JOptionPane.showMessageDialog(null, message, "修改失败", JOptionPane.ERROR_MESSAGE);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel DefaultLabel;
    private JLabel AllAddressLabel;
    private JPanel DefaultPanel;
    private JScrollPane scrollPane1;
    private JPanel AddressListPanel;
    private JButton AddAddressButton;
    private JLabel BG;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
