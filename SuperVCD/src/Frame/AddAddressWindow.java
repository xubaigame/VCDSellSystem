/*
 * Created by JFormDesigner on Fri Oct 12 14:55:31 CST 2018
 */

package Frame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Model.AddressInfo;
import Model.ModelManager;
import Request.AddAddressRequest;
import net.miginfocom.swing.*;

/**
 * @author jframe
 */
public class AddAddressWindow extends JFrame {
    private AddressWindow a;
    private AddAddressRequest addAddressRequest;
    public AddAddressWindow(AddressWindow a)
    {
        this.a=a;
        initComponents();
        InitFame();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                CloseWindow();
            }
        });
    }
    public void CloseWindow()
    {
        this.setVisible(false);
        a.setVisible(true);
    }
    private void CancelButtonMouseClicked(MouseEvent e) {
        this.setVisible(false);
        AddressField.setText("");
        LabelField.setText("");
        a.setVisible(true);
    }

    private void OKButtonMouseClicked(MouseEvent e) {
        if(AddressField.getText().length()>100)
        {
            SetToolTipsText("地址过长！");
        }
        else if(LabelField.getText().length()>45)
        {
            SetToolTipsText("标签过长！");
        }
        else {
            AddressInfo addressInfo=new AddressInfo();
            addressInfo.Address=AddressField.getText();
            addressInfo.Label=LabelField.getText();
            addressInfo.Default=0;
            addressInfo.UserID= ModelManager.Instance().getUser().UserID;
            addressInfo.AddressID=-1;
            addAddressRequest.SendRequest(addressInfo);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        AddressLabel = new JLabel();
        AddressField = new JTextField();
        LabelLabel = new JLabel();
        LabelField = new JTextField();
        OKButton = new JButton();
        CancelButton = new JButton();
        BG = new JLabel();

        //======== this ========
        setLayout(null);

        //---- AddressLabel ----
        AddressLabel.setText("\u6536\u8d27\u5730\u5740\uff1a");
        AddressLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        AddressLabel.setFont(new Font("Futura", Font.PLAIN, 28));
        add(AddressLabel);
        AddressLabel.setBounds(5, 75, 170, 40);

        //---- AddressField ----
        AddressField.setFont(new Font("Futura", Font.PLAIN, 18));
        add(AddressField);
        AddressField.setBounds(180, 65, 515, 60);

        //---- LabelLabel ----
        LabelLabel.setText("\u6807\u7b7e\uff1a");
        LabelLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        LabelLabel.setFont(new Font("Futura", Font.PLAIN, 28));
        add(LabelLabel);
        LabelLabel.setBounds(5, 235, 170, 40);

        //---- LabelField ----
        LabelField.setFont(new Font("Futura", Font.PLAIN, 18));
        add(LabelField);
        LabelField.setBounds(180, 235, 515, 60);

        //---- OKButton ----
        OKButton.setText("\u6dfb\u52a0");
        OKButton.setFont(new Font("Futura", Font.PLAIN, 28));
        OKButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                OKButtonMouseClicked(e);
            }
        });
        add(OKButton);
        OKButton.setBounds(55, 385, 145, 75);

        //---- CancelButton ----
        CancelButton.setText("\u53d6\u6d88");
        CancelButton.setFont(new Font("Futura", Font.PLAIN, 28));
        CancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CancelButtonMouseClicked(e);
            }
        });
        add(CancelButton);
        CancelButton.setBounds(480, 380, 145, 75);
        add(BG);
        BG.setBounds(0, 0, 700, 500);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    public void InitFame()
    {
        this.setResizable(false); // 去掉窗口的装饰
        this.setBounds(300,200,700,500);
        ImageIcon pic1 = new ImageIcon(Image.class.getResource("/image/BG3.png"));
        pic1.setImage(pic1.getImage().getScaledInstance(BG.getWidth(),BG.getHeight(),Image.SCALE_DEFAULT));
        BG.setIcon(pic1);
        addAddressRequest=new AddAddressRequest(this);
    }
    public void SetToolTipsText(String message)
    {
        JOptionPane.showMessageDialog(null, message, "添加失败", JOptionPane.ERROR_MESSAGE);
    }
    public void OnRespone()
    {
        this.setVisible(false);
        a.setVisible(true);
        a.UpdateList();
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel AddressLabel;
    private JTextField AddressField;
    private JLabel LabelLabel;
    private JTextField LabelField;
    private JButton OKButton;
    private JButton CancelButton;
    private JLabel BG;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
