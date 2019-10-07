/*
 * Created by JFormDesigner on Sun Oct 07 19:09:04 CST 2018
 */

package Frame;

import java.awt.event.*;

import Model.ModelManager;
import Model.User;
import Request.UpdateUserInfo;
import javafx.scene.control.PasswordField;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 * @author jframe
 */
public class UserWindow extends JFrame {
    private SellWindow s;
    private UpdateUserInfo updateUserInfo;
    public UserWindow(SellWindow s)
    {
        this.s=s;
        initComponents();
        InitFrame();
        updateUserInfo=new UpdateUserInfo(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                CloseWindow();
            }
        });
    }

    private void CancelbuttonMouseClicked(MouseEvent e) {
        CloseWindow();
    }

    private void OKbuttonMouseClicked(MouseEvent e) {
        if(UserPasswordField.getText().length()==0)
        {
            SetToolTipsText("密码不能为空！");
        }
        else if(UserPasswordField.getText().length()>10)
        {
            SetToolTipsText("用户名长度超过10位！");
        }
        else if(NameField.getText().length()>10)
        {
            SetToolTipsText("姓名长度超过10位！");
        }
        else if(UserAgeField.getText().length()>4)
        {
            SetToolTipsText("年龄不能超过200");
        }
        else if(UserPasswordField.getText().length()>20)
        {
            SetToolTipsText("密码长度超过20位！");
        }
        else if(!UserPasswordField.getText().equals(RightPasswordField.getText()))
        {
            SetToolTipsText("两次密码输入不一致！");
        }
        else
        {
            try {
                int age=Integer.valueOf(UserAgeField.getText());
                if(age>200)
                {
                    SetToolTipsText("年龄不能超过200");
                }
                else
                {
                    User user=new User();
                    user.UserID= ModelManager.Instance().getUser().UserID;
                    user.UserName=ModelManager.Instance().getUser().UserName;
                    user.Name=NameField.getText();
                    user.UserAge=age;
                    user.Password=UserPasswordField.getText();
                    user.UserType="user";
                    updateUserInfo.SendRequest(user);
                }
            }
            catch (Exception ex)
            {
                SetToolTipsText("年龄格式错误！");
            }

        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        UserNameLabel = new JLabel();
        UserName = new JLabel();
        NameLabel = new JLabel();
        NameField = new JTextField();
        UserAgeLabel = new JLabel();
        UserAgeField = new JTextField();
        UserPasswordLabel = new JLabel();
        UserPasswordField = new JPasswordField();
        RightPasswordLabel = new JLabel();
        RightPasswordField = new JPasswordField();
        OKbutton = new JButton();
        Cancelbutton = new JButton();
        BG = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- UserNameLabel ----
        UserNameLabel.setText("\u7528\u6237\u540d:");
        UserNameLabel.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
        UserNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(UserNameLabel);
        UserNameLabel.setBounds(220, 20, 115, 45);

        //---- UserName ----
        UserName.setText("text");
        UserName.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
        contentPane.add(UserName);
        UserName.setBounds(365, 20, 225, 45);

        //---- NameLabel ----
        NameLabel.setText("\u59d3\u540d:");
        NameLabel.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
        NameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(NameLabel);
        NameLabel.setBounds(220, 90, 115, 45);

        //---- NameField ----
        NameField.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
        contentPane.add(NameField);
        NameField.setBounds(355, 90, 175, 45);

        //---- UserAgeLabel ----
        UserAgeLabel.setText("\u5e74\u9f84:");
        UserAgeLabel.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
        UserAgeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(UserAgeLabel);
        UserAgeLabel.setBounds(220, 160, 115, 45);

        //---- UserAgeField ----
        UserAgeField.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
        contentPane.add(UserAgeField);
        UserAgeField.setBounds(355, 160, 175, 45);

        //---- UserPasswordLabel ----
        UserPasswordLabel.setText("\u65b0\u5bc6\u7801:");
        UserPasswordLabel.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
        UserPasswordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(UserPasswordLabel);
        UserPasswordLabel.setBounds(220, 230, 115, 45);

        //---- UserPasswordField ----
        UserPasswordField.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
        contentPane.add(UserPasswordField);
        UserPasswordField.setBounds(355, 230, 175, 45);

        //---- RightPasswordLabel ----
        RightPasswordLabel.setText("\u786e\u8ba4\u5bc6\u7801:");
        RightPasswordLabel.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
        RightPasswordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(RightPasswordLabel);
        RightPasswordLabel.setBounds(210, 300, 125, 45);

        //---- RightPasswordField ----
        RightPasswordField.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
        contentPane.add(RightPasswordField);
        RightPasswordField.setBounds(355, 305, 175, 45);

        //---- OKbutton ----
        OKbutton.setText("\u786e\u8ba4\u4fee\u6539");
        OKbutton.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
        OKbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                OKbuttonMouseClicked(e);
            }
        });
        contentPane.add(OKbutton);
        OKbutton.setBounds(85, 445, 150, 60);

        //---- Cancelbutton ----
        Cancelbutton.setText("\u53d6\u6d88\u4fee\u6539");
        Cancelbutton.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
        Cancelbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CancelbuttonMouseClicked(e);
            }
        });
        contentPane.add(Cancelbutton);
        Cancelbutton.setBounds(525, 445, 150, 60);
        contentPane.add(BG);
        BG.setBounds(0, 0, 800, 570);

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
        this.setBounds(300,200,800,600);
        this.setTitle("用户信息管理界面");
        ImageIcon pic1 = new ImageIcon(Image.class.getResource("/image/BG3.png"));
        pic1.setImage(pic1.getImage().getScaledInstance(BG.getWidth(),BG.getHeight(),Image.SCALE_DEFAULT));
        BG.setIcon(pic1);
    }
    public void OpenWindow(User user)
    {
        UserName.setText(user.UserName);
        NameField.setText(user.Name);
        UserAgeField.setText(String.valueOf(user.UserAge));

    }
    public void CloseWindow()
    {
        UserName.setText("");
        UserPasswordField.setText("");
        NameField.setText("");
        UserAgeField.setText("");
        this.setVisible(false);
        s.setVisible(true);
        this.dispose();
    }
    public void UpdateSucceedCallBack ()
    {
        s.SetUserPanel();
        CloseWindow();
    }
    public void SetToolTipsText(String message)
    {
        JOptionPane.showMessageDialog(null, message, "修改失败", JOptionPane.ERROR_MESSAGE);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel UserNameLabel;
    private JLabel UserName;
    private JLabel NameLabel;
    private JTextField NameField;
    private JLabel UserAgeLabel;
    private JTextField UserAgeField;
    private JLabel UserPasswordLabel;
    private JPasswordField UserPasswordField;
    private JLabel RightPasswordLabel;
    private JPasswordField RightPasswordField;
    private JButton OKbutton;
    private JButton Cancelbutton;
    private JLabel BG;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
