package p_view;

import javax.swing.*;

import p_monitor.C_KeyHandler;
/**
 * Autoren: Stephan Schellenberg, Jacob Waniek und Yannik Koesling
 * 
 */
public class C_Game {
    public static JFrame o_gameFrame;
    C_Playground o_playground;

    public static int v_width = 800, v_height = 600;
    public static int v_xoff = 130, v_yoff = 20;

    public void create(){
        o_gameFrame = new JFrame("Welcome to Snake!");
        o_gameFrame.setSize(v_width,v_height);
        o_gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        o_gameFrame.setLocationRelativeTo(null);
        o_gameFrame.setLayout(null);
        o_gameFrame.setResizable(false);
        o_gameFrame.addKeyListener(new C_KeyHandler());

        o_playground = new C_Playground();
        o_playground.setBounds(0,0,v_width,v_height);
        o_playground.setVisible(true);
        o_gameFrame.add(o_playground);

        o_gameFrame.requestFocus();
        o_gameFrame.setVisible(true);
    }
    
}