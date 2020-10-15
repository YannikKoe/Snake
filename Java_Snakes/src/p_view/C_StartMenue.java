
package p_view;

import java.awt.*;
import javax.swing.*;
import p_monitor.C_ActionHandler;

/**
 * @Autoren Stephan Schellenberg, Jacob Waniek und Yannik Koesling
 * Inhalt:  Erstellung einer GUI für das Startmenue
 * 
 */
public class C_StartMenue {
	
	/**
	 * Deklaration und Initialisierung der Variablen und Konstanten
	 */
	private final int k_width  = 800, k_height = 600;
	
	// JPanel & JFrame
	public static JFrame o_startFrame = new JFrame();
	JPanel o_startPanel = new JPanel();
	
	//Titel
	JLabel l_menueTitel = new JLabel("Snake Game");

	//Modi Buttons
	public static JRadioButton rb_standardMode = new JRadioButton("Standard Mode");
	public static JRadioButton rb_freeMode = new JRadioButton("Free Mode");
	
	//Start Button
	public static JButton b_playButton = new JButton("Play");
	
	public C_StartMenue() {
		
		//Erstellung des Fensters
		o_startFrame.setTitle("Welcome to Snake!");	
		o_startFrame.setSize(k_width, k_height);
		o_startFrame.setLocationRelativeTo(null);
		o_startFrame.setVisible(true);
		o_startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		o_startFrame.setResizable(false);
		
		o_startFrame.add(o_startPanel);
		o_startPanel.setBackground(Color.WHITE);  			
		o_startPanel.updateUI();
		
		//Formatierung des Titels
		o_startPanel.setLayout(null);
		o_startPanel.add(l_menueTitel);
		l_menueTitel.setFont(new Font ("Arial", Font.BOLD, 100));
		l_menueTitel.setForeground(Color.RED);
		l_menueTitel.setBounds(100, 80, 800, 100);
				
		//Formatierung der Radio Buttons für die Modi
		o_startPanel.add(rb_standardMode);
		rb_standardMode.setBounds(200, 250, 195, 60);
		rb_standardMode.setFont(new Font ("Arial", Font.BOLD, 20));
		
		o_startPanel.add(rb_freeMode);
		rb_freeMode.setBounds(405, 250, 195, 60);
		rb_freeMode.setFont(new Font ("Arial", Font.BOLD, 20));
		
		//Button Group für Modi Buttons und vorausgewaehltem Standardmodus
		ButtonGroup rb_mode = new ButtonGroup();
		rb_mode.add(rb_standardMode);
		rb_mode.add(rb_freeMode);
		rb_standardMode.setSelected(true);
				
		//Formatierung des Start Buttons
		o_startPanel.add(b_playButton);
		b_playButton.setFont(new Font ("Arial", Font.BOLD, 20));
		b_playButton.setBounds(300, 400, 200, 50);
		b_playButton.addActionListener(new C_ActionHandler());
		
	}
	
}
