package Frame;

import Model.VCDSong;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.rmi.CORBA.Tie;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class MusicPanel extends JPanel {
    private VCDSong vcdSong;
    private boolean Pause=true;
    private Player player;
    private Border lineBorder=BorderFactory.createEtchedBorder();
    private Font F_Size1 = new Font("方正舒体",Font.PLAIN,28);
    private Font F_Size2 = new Font("方正舒体",Font.PLAIN,18);
    public MusicPanel(VCDSong vcdSong)
    {
        this.vcdSong=vcdSong;
        this.setLayout(null);
        JButton button=new JButton("播放");
        button.setBounds(0,0,100,50);
        button.setBorder(lineBorder);
        button.setFont(F_Size1);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Pause==true)
                {
                    button.setText("暂停");
                    PlayMusic();
                    Pause=false;
                }
                else
                {
                    button.setText("播放");
                    PauseMusic();
                    Pause=true;
                }
            }
        });
        this.add(button);

        JLabel Name=new JLabel();
        Name.setHorizontalAlignment(0);
        Name.setText(vcdSong.VCDSongName);
        Name.setBounds(100,0,450,50);
        Name.setBorder(lineBorder);
        Name.setFont(F_Size1);
        this.add(Name);

        JLabel Time=new JLabel();
        Time.setHorizontalAlignment(0);
        int min=vcdSong.VCDSongTime/60;
        int second=vcdSong.VCDSongTime%60;
        Time.setText(min+"分"+second+"秒");
        Time.setBorder(lineBorder);
        Time.setFont(F_Size1);
        Time.setBounds(550,0,200,50);
        this.add(Time);

        LoadMusic();
    }

    private void LoadMusic()
    {
        try {
            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(vcdSong.VCDSongPath));
            player = new Player(buffer);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private void PlayMusic()
    {
        LoadMusic();
        new Thread()
        {
            @Override
            public void run() {
                if(player!=null) {
                    try {
                        player.play();
                    } catch (JavaLayerException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
    private void PauseMusic()
    {
        if(player!=null) {
            player.close();
        }
    }
}
