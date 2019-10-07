package Frame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Connection.*;
import Net.*;
import Request.LoginRequest;
import com.sun.xml.internal.ws.api.pipe.PipeClonerImpl;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Fri Sep 21 14:43:13 CST 2018
 */



/**
 * @author unknown
 */
public class Login extends JFrame {
    private LoginRequest loginRequest;
    JPanel BGPanel;
    JLabel BGLabel;
    JTextField UserNameInput;
    JPasswordField UserPasswordInput;
    Register r;
    public Login() {
        r=new Register(this);
        initComponents();
        initFrame();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void LoginButtonMouseClicked(MouseEvent e) {
        if(UserNameInput.getText().length()==0)
        {
            SetToolTipsText("用户名不能为空");
            return;
        }
        else if(UserPasswordInput.getText().length()==0)
        {
            SetToolTipsText("密码不能为空");
            return;
        }

        loginRequest.SendRequest(UserNameInput.getText(),UserPasswordInput.getText(),"user");
    }

    private void RegisterButtonMouseClicked(MouseEvent e) {
        r.setVisible(true);
        this.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel3 = new JPanel();
        UserName = new JLabel();
        UserPassword = new JLabel();
        UserNameText = new JTextField();
        UserPasswordText = new JPasswordField();
        LoginButton = new JButton();
        RegisterButton = new JLabel();
        BG = new JLabel();

        //======== this ========
        setIconImage(null);
        setModalExclusionType(Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel3 ========
        {
            panel3.setLayout(null);

            //---- UserName ----
            UserName.setText("\u7528\u6237\u540d\uff1a");
            UserName.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
            UserName.setHorizontalAlignment(SwingConstants.RIGHT);
            panel3.add(UserName);
            UserName.setBounds(320, 75, 120, 50);

            //---- UserPassword ----
            UserPassword.setText("\u5bc6\u7801\uff1a");
            UserPassword.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 28));
            UserPassword.setHorizontalAlignment(SwingConstants.RIGHT);
            panel3.add(UserPassword);
            UserPassword.setBounds(315, 150, 120, 50);
            panel3.add(UserNameText);
            UserNameText.setBounds(440, 85, 260, 35);
            panel3.add(UserPasswordText);
            UserPasswordText.setBounds(440, 160, 260, 35);

            //---- LoginButton ----
            LoginButton.setText("\u767b\u9646");
            LoginButton.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 36));
            LoginButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    LoginButtonMouseClicked(e);
                }
            });
            panel3.add(LoginButton);
            LoginButton.setBounds(465, 315, 125, 70);

            //---- RegisterButton ----
            RegisterButton.setText("\u8fd8\u6ca1\u6709\u8d26\u53f7\uff1f\u70b9\u51fb\u6ce8\u518c");
            RegisterButton.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.BOLD, 20));
            RegisterButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    RegisterButtonMouseClicked(e);
                }
            });
            panel3.add(RegisterButton);
            RegisterButton.setBounds(425, 400, 215, 45);
            panel3.add(BG);
            BG.setBounds(0, 0, 1100, 510);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel3.getComponentCount(); i++) {
                    Rectangle bounds = panel3.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel3.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel3.setMinimumSize(preferredSize);
                panel3.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel3);
        panel3.setBounds(0, 0, 1100, 510);

        contentPane.setPreferredSize(new Dimension(1100, 540));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    private void initFrame()
    {
        this.setResizable(false); // 去掉窗口的装饰
        this.setBounds(300,200,1100,510);
        this.setTitle("SuperVCD登陆界面");
        BGPanel=((JPanel) this.getContentPane().getComponent(0));
        BGLabel=(JLabel) BGPanel.getComponent(BGPanel.getComponentCount()-1);
        ImageIcon pic1 = new ImageIcon(Image.class.getResource("/image/BG3.png"));
        pic1.setImage(pic1.getImage().getScaledInstance(BGLabel.getWidth(),BGLabel.getHeight(),Image.SCALE_DEFAULT));
        BGLabel.setIcon(pic1);
        UserNameInput=(JTextField)BGPanel.getComponent(2);
        UserPasswordInput=(JPasswordField)BGPanel.getComponent(3);
        loginRequest=new LoginRequest(this);
    }
    public void SetToolTipsText(String message)
    {
        JOptionPane.showMessageDialog(null, message, "登录失败", JOptionPane.ERROR_MESSAGE);
    }
    public void EnterMainWindow()
    {
        this.setVisible(false);
        SellWindow s=new SellWindow();
        s.setVisible(true);
        dispose();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel3;
    private JLabel UserName;
    private JLabel UserPassword;
    private JTextField UserNameText;
    private JPasswordField UserPasswordText;
    private JButton LoginButton;
    private JLabel RegisterButton;
    private JLabel BG;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
