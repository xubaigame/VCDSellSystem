package Frame;

import Model.Order;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.OptionalDouble;

public class OrderPanel extends JPanel
{
    private Border lineBorder=BorderFactory.createEtchedBorder();
    private Font F_Size1 = new Font("方正舒体",Font.PLAIN,28);
    private Font F_Size2 = new Font("方正舒体",Font.PLAIN,18);
    public OrderPanel(Order order)
    {
        this.setLayout(null);
        JLabel vcdNameText=new JLabel();
        vcdNameText.setText("专辑:"+order.vcdName);
        vcdNameText.setFont(F_Size2);
        vcdNameText.setBounds(0,0,200,100);
        vcdNameText.setBorder(lineBorder);

        JLabel vcdSingerNameText=new  JLabel();
        vcdSingerNameText.setText("歌手"+order.vcdSingerName);
        vcdSingerNameText.setFont(F_Size1);
        vcdSingerNameText.setBounds(200,0,200,100);
        vcdSingerNameText.setBorder(lineBorder);

        JLabel vcdPriceText=new  JLabel();
        vcdPriceText.setText("价格"+ order.vcdPrice);
        vcdPriceText.setFont(F_Size1);
        vcdPriceText.setBounds(400,0,200,100);
        vcdPriceText.setBorder(lineBorder);

        JLabel OrderTimeText=new  JLabel();
        OrderTimeText.setText("购买时间:"+order.orderTime);
        OrderTimeText.setFont(F_Size2);
        OrderTimeText.setBounds(600,0,200,100);
        OrderTimeText.setBorder(lineBorder);

        JLabel addressDisText=new JLabel();
        addressDisText.setText("地址:"+order.addressDis);
        addressDisText.setFont(F_Size2);
        addressDisText.setBounds(0,100,600,30);
        addressDisText.setBorder(lineBorder);

        JLabel addressLabelText=new JLabel();
        addressLabelText.setText("地址标签:"+order.addressLabel);
        addressLabelText.setFont(F_Size2);
        addressLabelText.setBounds(600,100,300,30);
        addressLabelText.setBorder(lineBorder);

        this.add(vcdNameText);
        this.add(vcdSingerNameText);
        this.add(vcdPriceText);
        this.add(OrderTimeText);
        this.add(addressDisText);
        this.add(addressLabelText);
    }
}
