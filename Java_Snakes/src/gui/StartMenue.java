package gui;

import java.awt.*;
import javax.swing.*;
import actions.ActionHandler;

public class StartMenue {
	
	/**
	 * Deklaration und Initialisierung der Variablen und Konstanten
	 */
	private final int k_width  = 800, k_height = 600;
	
	/**
	 * Deklaration und Initialisierung der Objekte
	 */
	// JPanel & JFrame
	public static JFrame frame = new JFrame();
	JPanel o_panel = new JPanel();
	
	//Titel
	JLabel l_menueTitel = new JLabel("Snake Game");

	//Modi
	public static JRadioButton o_b_standard = new JRadioButton("Standard Mode");
	public static JRadioButton o_b_freeMode = new JRadioButton("Free Mode");
	boolean standardMode = true;
	
	//Start Button
	public static JButton o_b_play = new JButton("Play");
	
	
	/**
	 * Konstruktor
	 */
	public StartMenue() {
		
		frame.setTitle("Welcome to Snake!");	
		frame.setSize(k_width, k_height);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		frame.add(o_panel);
		o_panel.setBackground(Color.WHITE);  			
		o_panel.updateUI();
		
		m_addButtons();
	}
	
	
	/**
	 * Fuegt alle Text-Felder und Buttons dem JFrame zu
	 */
	public void m_addButtons() {
		
		//Titel
		o_panel.setLayout(null);
		o_panel.add(l_menueTitel);
		l_menueTitel.setFont(new Font ("Arial", Font.BOLD, 100));
		l_menueTitel.setForeground(Color.RED);
		l_menueTitel.setBounds(100, 80, 800, 100);
		
		//Modi
		o_panel.add(o_b_standard);
		o_b_standard.setBounds(200, 250, 195, 60);
		o_b_standard.setFont(new Font ("Arial", Font.BOLD, 20));
		o_panel.add(o_b_freeMode);
		o_b_freeMode.setBounds(405, 250, 195, 60);
		o_b_freeMode.setFont(new Font ("Arial", Font.BOLD, 20));
		
		//Radio Buttons for modes with selected Standard Mode 
		o_b_standard.setEnabled(true);
		o_b_freeMode.setEnabled(true);
		
		ButtonGroup rb_mode = new ButtonGroup();
		rb_mode.add(o_b_standard);
		rb_mode.add(o_b_freeMode);
		o_b_standard.setSelected(true);
		
		//Start Button
		o_panel.add(o_b_play);
		o_b_play.setFont(new Font ("Arial", Font.BOLD, 20));
		o_b_play.setBounds(300, 400, 200, 50);
		o_b_play.addActionListener(new ActionHandler());
	}
	
}
