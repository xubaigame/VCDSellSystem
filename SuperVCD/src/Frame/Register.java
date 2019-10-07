/*
 * Created by JFormDesigner on Fri Sep 28 13:11:08 CST 2018
 */

package Frame;

import Model.User;
import Request.RegisterRequest;
import sun.rmi.runtime.Log;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author jframe
 */
public class Register extends JFrame {
    RegisterRequest registerRequest;
    Login l;
    JPanel BGPanel;
    JLabel BGLabel;
    JTextField userNameInput;
    JTextField nameInput;
    JTextField userAgeInput;
    JPasswordField passwordInput;
    JPasswordField rightPasswordInput;
    public Register(Login l) {
        this.l=l;
        initComponents();
        initFrame();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                CloseWindow();
            }
        });
    }

    private void CancelbuttonMouseClicked(MouseEvent e) {
        this.setVisible(false);
        l.setVisible(true);
    }

    private void RegisterbuttonMouseClicked(MouseEvent e) {
        if(userNameInput.getText().length()==0)
        {
            SetToolTipsText("用户名不能为空！");
        }
        else if(passwordInput.getText().length()==0)
        {
            SetToolTipsText("密码不能为空！");
        }
        else if(userNameInput.getText().length()>10)
        {
            SetToolTipsText("用户名长度超过10位！");
        }
        else if(nameInput.getText().length()>10)
        {
            SetToolTipsText("姓名长度超过10位！");
        }
        else if(userAgeInput.getText().length()>4)
        {
            SetToolTipsText("年龄不能超过200");
        }
        else if(passwordInput.getText().length()>20)
        {
            SetToolTipsText("密码长度超过20位！");
        }
        else if(!passwordInput.getText().equals(rightPasswordInput.getText()))
        {
            SetToolTipsText("两次密码输入不一致！");
        }
        else
        {
            try {
                int age=Integer.valueOf(userAgeInput.getText());
                if(age>200)
                {
                    SetToolTipsText("年龄不能超过200");
                }
                else
                {
                    User user=new User();
                    user.UserName=userNameInput.getText();
                    user.Name=nameInput.getText();
                    user.UserAge=age;
                    user.Password=passwordInput.getText();
                    user.UserType="user";
                    registerRequest.SendRequest(user);
                }
            }
            catch (Exception ex)
            {
                SetToolTipsText("年龄格式错误！");
            }

        }
    }
    public void SetToolTipsText(String message)
    {
        JOptionPane.showMessageDialog(null, message, "注册失败", JOptionPane.ERROR_MESSAGE);
    }
    public void EnterMainWindow()
    {
        this.setVisible(false);
        l.setVisible(true);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        UserNameLabel = new JLabel();
        UserNameInput = new JTextField();
        PasswordLabel = new JLabel();
        PasswordInput = new JPasswordField();
        RightPasswordLabel = new JLabel();
        RightPasswordInput = new JPasswordField();
        Registerbutton = new JButton();
        Cancelbutton = new JButton();
        NameLabel = new JLabel();
        NameInput = new JTextField();
        UserAgeLabel = new JLabel();
        UserAgeInput = new JTextField();
        BG = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- UserNameLabel ----
            UserNameLabel.setText("\u7528\u6237\u540d\uff1a");
            UserNameLabel.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.BOLD, 28));
            UserNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            panel1.add(UserNameLabel);
            UserNameLabel.setBounds(200, 25, 120, 50);

            //---- UserNameInput ----
            UserNameInput.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 28));
            panel1.add(UserNameInput);
            UserNameInput.setBounds(330, 30, 215, 40);

            //---- PasswordLabel ----
            PasswordLabel.setText("\u5bc6\u7801\uff1a");
            PasswordLabel.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.BOLD, 28));
            PasswordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            panel1.add(PasswordLabel);
            PasswordLabel.setBounds(200, 235, 120, 50);
            panel1.add(PasswordInput);
            PasswordInput.setBounds(330, 245, 215, 40);

            //---- RightPasswordLabel ----
            RightPasswordLabel.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
            RightPasswordLabel.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.BOLD, 28));
            RightPasswordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            panel1.add(RightPasswordLabel);
            RightPasswordLabel.setBounds(165, 305, 155, 50);
            panel1.add(RightPasswordInput);
            RightPasswordInput.setBounds(330, 315, 215, 40);

            //---- Registerbutton ----
            Registerbutton.setText("\u6ce8\u518c");
            Registerbutton.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
            Registerbutton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    RegisterbuttonMouseClicked(e);
                }
            });
            panel1.add(Registerbutton);
            Registerbutton.setBounds(140, 440, 125, 55);

            //---- Cancelbutton ----
            Cancelbutton.setText("\u53d6\u6d88");
            Cancelbutton.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
            Cancelbutton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    CancelbuttonMouseClicked(e);
                }
            });
            panel1.add(Cancelbutton);
            Cancelbutton.setBounds(530, 440, 125, 55);

            //---- NameLabel ----
            NameLabel.setText("\u59d3\u540d\uff1a");
            NameLabel.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.BOLD, 28));
            NameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            panel1.add(NameLabel);
            NameLabel.setBounds(200, 95, 120, 50);

            //---- NameInput ----
            NameInput.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 28));
            panel1.add(NameInput);
            NameInput.setBounds(330, 105, 215, 40);

            //---- UserAgeLabel ----
            UserAgeLabel.setText("\u5e74\u9f84\uff1a");
            UserAgeLabel.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.BOLD, 28));
            UserAgeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            panel1.add(UserAgeLabel);
            UserAgeLabel.setBounds(200, 165, 120, 50);

            //---- UserAgeInput ----
            UserAgeInput.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 28));
            panel1.add(UserAgeInput);
            UserAgeInput.setBounds(330, 175, 215, 40);
            panel1.add(BG);
            BG.setBounds(0, 0, 850, 570);
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 850, 570);

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
    private void initFrame()
    {
        this.setResizable(false);
        this.setBounds(300,200,850,600);
        this.setTitle("用户注册界面");
        BGPanel=((JPanel) this.getContentPane().getComponent(0));
        BGLabel=(JLabel) BGPanel.getComponent(BGPanel.getComponentCount()-1);
        ImageIcon pic1 = new ImageIcon(Image.class.getResource("/image/BG3.png"));
        pic1.setImage(pic1.getImage().getScaledInstance(BGLabel.getWidth(),BGLabel.getHeight(),Image.SCALE_DEFAULT));
        BGLabel.setIcon(pic1);
        userNameInput=(JTextField) BGPanel.getComponent(1);
        nameInput=(JTextField) BGPanel.getComponent(9);
        userAgeInput=(JTextField) BGPanel.getComponent(11);
        passwordInput=(JPasswordField) BGPanel.getComponent(3);
        rightPasswordInput=(JPasswordField) BGPanel.getComponent(5);
        registerRequest=new RegisterRequest(this);
    }
    private void CloseWindow()
    {
        this.setVisible(false);
        l.setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel UserNameLabel;
    private JTextField UserNameInput;
    private JLabel PasswordLabel;
    private JPasswordField PasswordInput;
    private JLabel RightPasswordLabel;
    private JPasswordField RightPasswordInput;
    private JButton Registerbutton;
    private JButton Cancelbutton;
    private JLabel NameLabel;
    private JTextField NameInput;
    private JLabel UserAgeLabel;
    private JTextField UserAgeInput;
    private JLabel BG;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
