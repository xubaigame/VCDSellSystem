/*
 * Created by JFormDesigner on Sat Sep 29 13:36:17 CST 2018
 */

package Frame;

import java.awt.event.*;
import javax.jws.WebParam;
import javax.swing.border.*;

import Model.ModelManager;
import Model.User;
import Model.VCDInfo;
import Request.LoginRequest;
import Request.VCDInfoListRequest;
import Tool.CreateList;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 * @author jframe
 */
public class SellWindow extends JFrame {
    private JPanel VCDInfoListPanel;
    private DisWindow disWindow;
    private OrderWindow orderWindow;

    private VCDInfoListRequest vcdInfoListRequest;
    public SellWindow() {

        initComponents();
        initFrame();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void UserManagerButtonMouseClicked(MouseEvent e) {
        UserWindow userWindow=new UserWindow(this);
        this.setVisible(false);
        userWindow.setVisible(true);
        userWindow.OpenWindow(ModelManager.Instance().getUser());
    }

    private void AddressManagerButtonMouseClicked(MouseEvent e) {
        AddressWindow addressWindow=new AddressWindow(this);
        this.setVisible(false);
        addressWindow.setVisible(true);
        addressWindow.OpenWindow(ModelManager.Instance().getUser());
    }

    private void OrderManagerButtonMouseClicked(MouseEvent e) {
        this.setVisible(false);
        orderWindow.setVisible(true);
        orderWindow.OpenWindow();

    }

    private void SelectButtonMouseClicked(MouseEvent e) {
        String keyword;
        if(SelectField.getText().length()<=0)
            keyword="";
        else
        {
            keyword=SelectField.getText();
        }
        int vcdType=SelectComboBox.getSelectedIndex();
        vcdInfoListRequest.SendRequest(keyword,vcdType);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        panel7 = new JPanel();
        BG = new JLabel();
        UserPanel = new JPanel();
        UserName = new JLabel();
        UserID = new JLabel();
        UserAge = new JLabel();
        AddressManagerButton = new JButton();
        UserManagerButton = new JButton();
        OrderManagerButton = new JButton();
        SelectPanel = new JPanel();
        SelectField = new JTextField();
        SelectButton = new JButton();
        SelectComboBox = new JComboBox<>();
        SelectBG = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

            //======== panel7 ========
            {
                panel7.setLayout(null);
                panel7.add(BG);
                BG.setBounds(0, 0, 820, 585);
            }
            scrollPane1.setViewportView(panel7);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(180, 85, 820, 585);

        //======== UserPanel ========
        {
            UserPanel.setForeground(Color.pink);
            UserPanel.setBackground(new Color(255, 204, 255));
            UserPanel.setLayout(null);

            //---- UserName ----
            UserName.setText("\u59d3\u540d");
            UserName.setHorizontalAlignment(SwingConstants.CENTER);
            UserName.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
            UserName.setBorder(new EtchedBorder());
            UserPanel.add(UserName);
            UserName.setBounds(0, 100, 180, 45);

            //---- UserID ----
            UserID.setText("ID");
            UserID.setHorizontalAlignment(SwingConstants.CENTER);
            UserID.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
            UserID.setBorder(new EtchedBorder());
            UserPanel.add(UserID);
            UserID.setBounds(0, 30, 180, 45);

            //---- UserAge ----
            UserAge.setText("\u5e74\u9f84");
            UserAge.setHorizontalAlignment(SwingConstants.CENTER);
            UserAge.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
            UserAge.setBorder(new EtchedBorder());
            UserPanel.add(UserAge);
            UserAge.setBounds(0, 165, 180, 45);

            //---- AddressManagerButton ----
            AddressManagerButton.setText("\u6536\u8d27\u5730\u5740\u7ba1\u7406");
            AddressManagerButton.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 24));
            AddressManagerButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    AddressManagerButtonMouseClicked(e);
                }
            });
            UserPanel.add(AddressManagerButton);
            AddressManagerButton.setBounds(0, 515, 180, 45);

            //---- UserManagerButton ----
            UserManagerButton.setText("\u8d26\u6237\u7ba1\u7406");
            UserManagerButton.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 24));
            UserManagerButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    UserManagerButtonMouseClicked(e);
                }
            });
            UserPanel.add(UserManagerButton);
            UserManagerButton.setBounds(0, 455, 180, 45);

            //---- OrderManagerButton ----
            OrderManagerButton.setText("\u8ba2\u5355\u67e5\u8be2");
            OrderManagerButton.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 24));
            OrderManagerButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    OrderManagerButtonMouseClicked(e);
                }
            });
            UserPanel.add(OrderManagerButton);
            OrderManagerButton.setBounds(0, 575, 180, 45);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < UserPanel.getComponentCount(); i++) {
                    Rectangle bounds = UserPanel.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = UserPanel.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                UserPanel.setMinimumSize(preferredSize);
                UserPanel.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(UserPanel);
        UserPanel.setBounds(0, 0, 180, 670);

        //======== SelectPanel ========
        {
            SelectPanel.setLayout(null);

            //---- SelectField ----
            SelectField.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
            SelectPanel.add(SelectField);
            SelectField.setBounds(275, 15, 225, 50);

            //---- SelectButton ----
            SelectButton.setText("\u641c\u7d22");
            SelectButton.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
            SelectButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    SelectButtonMouseClicked(e);
                }
            });
            SelectPanel.add(SelectButton);
            SelectButton.setBounds(575, 20, 100, 40);

            //---- SelectComboBox ----
            SelectComboBox.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
            SelectComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
                "\u5168\u90e8",
                "\u6d41\u884c",
                "\u6447\u6eda",
                "\u6c11\u8c23"
            }));
            SelectPanel.add(SelectComboBox);
            SelectComboBox.setBounds(110, 15, 85, 55);
            SelectPanel.add(SelectBG);
            SelectBG.setBounds(0, 0, 820, 85);
        }
        contentPane.add(SelectPanel);
        SelectPanel.setBounds(180, 0, 820, 85);

        contentPane.setPreferredSize(new Dimension(1000, 700));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    private void initFrame()
    {
        this.setResizable(false); // 去掉窗口的装饰
        this.setBounds(300,200,1000,700);
        this.setTitle("SuperVCD登陆界面");
        VCDInfoListPanel=(JPanel) ((JViewport)((JScrollPane)this.getContentPane().getComponent(0)).getComponent(0)).getComponent(0);
        disWindow=new DisWindow();
        orderWindow=new OrderWindow(this);
        vcdInfoListRequest=new VCDInfoListRequest(this);
        vcdInfoListRequest.SendRequest("",0);
        SetUserPanel();
    }
    public void SetToolTipsText(String message)
    {
        JOptionPane.showMessageDialog(null, message, "查询失败", JOptionPane.ERROR_MESSAGE);
    }
    public void SetVCDInfoList(int cout,List<VCDInfo> vcdInfoList)
    {
        if(cout<=0)
        {
            SetToolTipsText("专辑不存在!");
            vcdInfoListRequest.SendRequest("",0);
            return;
        }
        VCDInfoListPanel.removeAll();
        VCDInfoListPanel.setPreferredSize(new Dimension(800,170*cout-20));
        List<JPanel> jPanelList=new ArrayList<>();
        jPanelList= CreateList.CreateVCDInfoPanel(vcdInfoList,disWindow);
        for (JPanel panel :jPanelList)
        {
            VCDInfoListPanel.add(panel);
        }
        JLabel BGLabel=new JLabel("");
        BGLabel.setName("BGLabel");
        BGLabel.setBounds(0,0,VCDInfoListPanel.getPreferredSize().width,VCDInfoListPanel.getPreferredSize().height);
        ImageIcon pic1 = new ImageIcon(Image.class.getResource("/image/BG3.png"));
        pic1.setImage(pic1.getImage().getScaledInstance(BGLabel.getWidth(),BGLabel.getHeight(),Image.SCALE_DEFAULT));
        BGLabel.setIcon(pic1);
        VCDInfoListPanel.add(BGLabel);
        VCDInfoListPanel.updateUI();
    }
    public void SetUserPanel()
    {
        User user= ModelManager.Instance().getUser();
        UserID.setText(String.valueOf("编号:"+user.UserID));
        if(user.Name==null)
        {
            UserName.setText(user.UserName);
        }
        else
        {
            UserName.setText(user.Name);
        }
        UserAge.setText(String.valueOf("年龄:"+user.UserAge));
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JPanel panel7;
    private JLabel BG;
    private JPanel UserPanel;
    private JLabel UserName;
    private JLabel UserID;
    private JLabel UserAge;
    private JButton AddressManagerButton;
    private JButton UserManagerButton;
    private JButton OrderManagerButton;
    private JPanel SelectPanel;
    private JTextField SelectField;
    private JButton SelectButton;
    private JComboBox<String> SelectComboBox;
    private JLabel SelectBG;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
