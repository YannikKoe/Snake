package p_main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Diese Klasse dient zur Erzeugung des Spielfeldes
 * 
 * @author Yannik Koesling, Jacob Waniek, Stephan Schellenberg
 * @version 1.0
 */
public class C_Board extends JFrame implements ItemListener {
	
	/**
	 * Deklaration und Initialisierung der Variablen und Konstanten
	 */
	private final int k_height = 500;
	private final int k_width  = 500;
	private boolean playingMusic = true;
	
	/**
	 * Deklaration und Initialisierung der Objekte
	 */
	// JPanel
	JPanel o_panel = new JPanel();
	
	
	//Titel
	JLabel l_menueTitel = new JLabel("Snake Game");
	
	//Settings
	JLabel o_l_settings = new JLabel("Settings");
	JRadioButton o_cb_soundOn = new JRadioButton("Sound on");
	JRadioButton o_cb_soundOff = new JRadioButton("Sound off");
	
	//Keys
	JLabel o_l_keys = new JLabel("Keys");
	JRadioButton o_b_arrowKeys = new JRadioButton("Arrow keys");
	JRadioButton o_b_gamingKeys = new JRadioButton("WASD keys");
	
	//Modi
	JRadioButton o_b_standard = new JRadioButton("Standard Mode");
	JRadioButton o_b_freeMode = new JRadioButton("Free Mode");
	
	//Snake Customizing
	JLabel l_snakeCustom = new JLabel("Snake Customizing");
	JButton b_colorLeft = new JButton("<-");
	ArrayList<String> colors;
	JLabel l_color;
	JButton b_colorRight = new JButton("->");
	
	//Food Customizing
	JLabel l_foodCustom = new JLabel("Food Customizing");
	JButton b_foodLeft = new JButton("<-");
	JLabel l_food;
	JButton b_foodRight = new JButton("->");
	
	//Start Button
	JButton o_b_play = new JButton("Play");
	
	/**
	 * Konstruktor
	 */
	public C_Board() {
		
		colors = new ArrayList<String>();
		colors.add("Red");
		colors.add("Blue");
		colors.add("Orange");
		colors.add("Yellow");
		colors.add("White");
		
		l_color = new JLabel(colors.get(1));
		l_food = new JLabel(colors.get(0));
		m_buildBoard();
	}
	
	/**
	 * Methode baut Fensterumgebung auf
	 */
	private void m_buildBoard() {
	
		
		setTitle("Welcome to Snake!");	
		setSize(k_width, k_height); 					//Fenstergroesse
		setLocationRelativeTo(null); 			 		//Platziert Fenster in der Mitte
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 		//Beendet Applikation sobald auf 'x'-Knopf gedrueckt wird
		setResizable(false);   							//Damit Fenster vergroessert/verkleinert werden kann
		
		m_addButtons();
		m_setControls();
		
		add(o_panel);
		o_panel.setBackground(Color.WHITE);  			
		o_panel.updateUI();
		
		
	}
	
	/**
	 * Fuegt alle Text-Felder und Buttons dem JFrame zu und bestimmt das Layout
	 */
	public void m_addButtons() {
		
		//Überschrift und setLayout
		o_panel.setLayout(null);
		o_panel.add(l_menueTitel);
		l_menueTitel.setBounds(213, 0, 74, 10);
		
		//Modi
		o_panel.add(o_b_standard);
		o_b_standard.setBounds(50, 50, 120, 40);
		o_panel.add(o_b_freeMode);
		o_b_freeMode.setBounds(180, 50, 120, 40);
		
		//Snake Customizing Color
		o_panel.add(l_snakeCustom);
		l_snakeCustom.setBounds(80, 140, 120, 20);
		o_panel.add(b_colorLeft);
		b_colorLeft.setBounds(50, 170, 50, 20);
		o_panel.add(l_color);
		l_color.setBounds(110, 170, 60, 20);
		o_panel.add(b_colorRight);
		b_colorRight.setBounds(170, 170, 50, 20);
		
		//Food Customizing Color
		o_panel.add(l_foodCustom);
		l_foodCustom.setBounds(80, 210, 120, 20);
		o_panel.add(b_foodLeft);
		b_foodLeft.setBounds(50, 240, 50, 20);
		o_panel.add(l_food);
		l_food.setBounds(110, 240, 60, 20);
		o_panel.add(b_foodRight);
		b_foodRight.setBounds(170, 240, 50, 20);
		
		//Settings
		o_panel.add(o_l_settings);
		o_l_settings.setBounds(350, 20, 100, 20);
		o_panel.add(o_cb_soundOn);
		o_cb_soundOn.setBounds(350, 50, 100, 20);
		o_panel.add(o_cb_soundOff);
		o_cb_soundOff.setBounds(350, 75, 100, 20);
		
		//Keys
		o_panel.add(o_l_keys);
		o_l_keys.setBounds(300, 140, 100, 20);
		o_panel.add(o_b_arrowKeys);
		o_b_arrowKeys.setBounds(300, 170, 100, 20);
		o_panel.add(o_b_gamingKeys);
		o_b_gamingKeys.setBounds(300, 200, 100, 20);
		
		//Start Button
		o_panel.add(o_b_play);
		o_b_play.setBounds(213, 350, 74, 30);
	}
	
	/**
	 * Fuegt die Bedienelemente hinzu
	 */
	
	private void m_setControls() {
		
		//Radio Buttons for modes with selected Standard Mode 
		o_b_standard.setEnabled(true);
		o_b_standard.addItemListener(this);
		o_b_freeMode.setEnabled(true);
		o_b_freeMode.addItemListener(this);
		
		ButtonGroup rb_mode = new ButtonGroup();
		rb_mode.add(o_b_standard);
		rb_mode.add(o_b_freeMode);
		o_b_standard.setSelected(true);
		
		//Radio Buttons for playing keys with selected Arrow Keys
		o_b_arrowKeys.setEnabled(true);
		o_b_arrowKeys.addItemListener(this);
		o_b_gamingKeys.setEnabled(true);
		o_b_gamingKeys.addItemListener(this);
		
		ButtonGroup rb_keys = new ButtonGroup();
		rb_keys.add(o_b_arrowKeys);
		rb_keys.add(o_b_gamingKeys);
		o_b_arrowKeys.setSelected(true);
		
		//Radio Buttons for sound settings with Sound On selected
		o_cb_soundOn.setEnabled(true);
		o_cb_soundOn.addItemListener(this);
		o_cb_soundOff.setEnabled(true);
		o_cb_soundOff.addItemListener(this);
		
		ButtonGroup rb_sound = new ButtonGroup();
		rb_sound.add(o_cb_soundOn);
		rb_sound.add(o_cb_soundOff);
		o_cb_soundOn.setSelected(true);
	}

	/**
	 * Eventhandler beziehungsweise Behandler fuer ItemListener
	 */
	public void itemStateChanged(ItemEvent e) {
		
		/**
		 * Action for selectable Radio Buttons
		 */
		Object source = e.getItemSelectable();
		
		if(source == o_cb_soundOn) {
			playingMusic = true;
		}
		if(source == o_cb_soundOff) {
			playingMusic = false;
		}
		
		/**
		 * Action Listener for JButtons
		 */
		//AL for Play Button
		o_b_play.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				//System.exit(0);
			}
		});
		
		/**
		 * JButtons for Customizing Color of snake and food
		 */
		//AactionListener (AL) for Color Button Left
		b_colorLeft.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				String color = l_color.getText();
				for(int i = 0; i<colors.size(); i++) {
					if(colors.get(i) == color) {
						if(i == 0) {
							l_color.setText(colors.get(colors.size()-1));
						} else {
							l_color.setText((colors.get(i-1)));
						}
					}
				}
				
			}
		});
		
		//Snake Customizing Color change to the right
		b_colorRight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String color = l_color.getText();
				for(int i = 0; i<colors.size(); i++) {
					if(colors.get(i) == color) {
						if(i == colors.size()-1) {
							l_color.setText(colors.get(0));
						} else {
							l_color.setText((colors.get(i+1)));
						}
					}
				}
			}
		});
		
		//Food Customizing Color change to the left
		b_foodLeft.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				String color = l_food.getText();
				for(int i = 0; i<colors.size(); i++) {
					if(colors.get(i) == color) {
						if(i == 0) {
							l_food.setText(colors.get(colors.size()-1));
						} else {
							l_food.setText((colors.get(i-1)));
						}
					}
				}
				
			}
		});
		
		//Food Customizing Color change to the right
		b_foodRight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String color = l_food.getText();
				for(int i = 0; i<colors.size(); i++) {
					if(colors.get(i) == color) {
						if(i == colors.size()-1) {
							l_food.setText(colors.get(0));
						} else {
							l_food.setText((colors.get(i+1)));
						}
					}
				}
			}
		});
	}
	
}








