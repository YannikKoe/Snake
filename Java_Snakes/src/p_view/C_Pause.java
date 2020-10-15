package p_view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import p_monitor.C_KeyHandler;
/**
 * @Autoren Stephan Schellenberg, Jacob Waniek und Yannik Koesling
 * Inhalt:  Erstellung einer GUI für das Pause Fenster
 */
public class C_Pause {

	public static JFrame o_pauseFrame;
	JPanel o_pausePanel = new JPanel();
	JLabel l_gamePaused = new JLabel("Game paused");
	JLabel l_continue = new JLabel("Press P to continue");

    public static int width = 450, height = 160;

    public C_Pause(){
    	
        //Erstellung des Fensters mit KeyListener
    	o_pauseFrame = new JFrame();
    	o_pauseFrame.setTitle("Pause");
    	o_pauseFrame.setSize(width,height);
    	o_pauseFrame.setLocationRelativeTo(null);
    	o_pauseFrame.setResizable(false);        
    	o_pauseFrame.requestFocus();
    	o_pauseFrame.setVisible(true);
    	o_pauseFrame.addKeyListener(new C_KeyHandler());
        
    	//Panel und Layout
    	o_pauseFrame.add(o_pausePanel);
        o_pausePanel.setBackground(Color.WHITE);
        o_pausePanel.updateUI();
        
        //Formatierung Schriftzug "Game paused"
        o_pausePanel.add(l_gamePaused);
        l_gamePaused.setFont(new Font ("Arial", Font.BOLD, 40));
        l_gamePaused.setForeground(Color.RED);
        
        //Formatierung Schriftzug "Press P to continue"
        o_pausePanel.add(l_continue);
        l_continue.setFont(new Font ("Arial", Font.BOLD, 35));
        l_continue.setForeground(Color.RED);
        
    }
}
