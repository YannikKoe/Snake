package p_main;

import java.awt.*;
import javax.swing.*;

/**
 * Diese Klasse dient zur Erzeugung des Spielfeldes
 * 
 * @author Yannik Kösling
 * @version 1.0
 */
public class C_Board extends JFrame {
	
	/**
	 * Deklaration und Initialisierung der Variablen und Konstanten
	 */
	private final int k_height = 700;
	private final int k_width  = 850;
	
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
		setSize(k_width, k_height); 					//Fenstergröße
		setLocationRelativeTo(null); 			 		//Platziert Fenster in der Mitte
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 		//Beendet Applikation sobald auf 'x'-Knopf gedrückt wird
		setBackground(Color.green); 			 		//Taskleiste
	}
	
}
