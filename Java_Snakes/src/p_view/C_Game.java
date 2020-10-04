package p_view;

import javax.swing.*;

import p_monitor.C_KeyHandler;

public class C_Game {
    public static JFrame jf;
    C_Playground d;

    public static int width = 800, height = 600;
    public static int xoff = 130, yoff = 20;

    public void create(){
        jf = new JFrame("Welcome to Snake!");
        jf.setSize(width,height);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
        jf.setResizable(false);
        jf.addKeyListener(new C_KeyHandler());

        d = new C_Playground();
        d.setBounds(0,0,width,height);
        d.setVisible(true);
        jf.add(d);

        jf.requestFocus();
        jf.setVisible(true);
    }
    
}