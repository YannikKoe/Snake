package p_main;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

/**
 * Diese Klasse dient zur Erzeugung des Spielfeldes
 * 
 * @author Yannik K�sling
 * @version 1.0
 */
public class C_Board extends JFrame implements ItemListener {
	
	/**
	 * Deklaration und Initialisierung der Variablen und Konstanten
	 */
	private final int k_height = 700;
	private final int k_width  = 850;
	
	/**
	 * Deklaration und Initialisierung der Objekte
	 */
	JCheckBox o_cb_sound = new JCheckBox("Sound on");
	JPanel o_panel = new JPanel();
	
	/**
	 * Konstruktor
	 */
	public C_Board() {
		m_buildBoard();
	}
	
	/**
	 * Methode baut Fensterumgebung auf
	 */
	private void m_buildBoard() {
	
		setTitle("Welcome to Snake!");	
		setSize(k_width, k_height); 					//Fenstergr��e
		setLocationRelativeTo(null); 			 		//Platziert Fenster in der Mitte
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 		//Beendet Applikation sobald auf 'x'-Knopf gedrückt wird
		setResizable(true);   							// Damit Fenster vergroessert/verkleinert werden kann
		
		m_setControls();
		
		add(o_panel);
		o_panel.setBackground(Color.black);  			
		o_panel.updateUI();
		
	}
	
	/**
	 * Fügt die Bedienelemente hinzu
	 */
	private void m_setControls() {
		o_panel.add(o_cb_sound);
		o_cb_sound.setForeground(Color.yellow);
		o_cb_sound.setEnabled(true);
		o_cb_sound.addItemListener(this);
	}

	/**
	 * Eventhandler beziehungsweise Behandler f�r ItemListener
	 */
	public void itemStateChanged(ItemEvent e) {
		
		Object source = e.getItemSelectable();
		
		if(source == o_cb_sound) {
			System.out.println("hihi");
		}
		
	}
	
}








