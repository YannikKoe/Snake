package p_view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import p_model.C_Snake;
import p_monitor.C_ActionHandler;
import p_monitor.C_KeyHandler;
/**
 * Autoren: Stephan Schellenberg, Jacob Waniek und Yannik Koesling
 * Inhalt:  Erstellung einer GUI für das Game Over Fenster
 */
public class C_GameOver {
	
	public static JFrame o_gameOverFrame;
	JPanel o_gameOverPanel = new JPanel();
	JLabel l_gameOver = new JLabel("Game Over");
	JLabel l_score = new JLabel("Score: " + C_Snake.v_score);
	JLabel l_highScore = new JLabel("High Score: " + C_Snake.v_highScore);
	public static JButton b_exitButton = new JButton("Exit");
	public static JButton b_restartButton = new JButton("Restart");

    public static int width = 800, height = 600;

    public C_GameOver(){
        
    	//Erstellung des Fensters
    	o_gameOverFrame = new JFrame();
    	o_gameOverFrame.setTitle("Game Over");
    	o_gameOverFrame.setSize(width,height);
    	o_gameOverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	o_gameOverFrame.setLocationRelativeTo(null);
    	o_gameOverFrame.setResizable(false);
        
    	o_gameOverFrame.requestFocus();
    	o_gameOverFrame.setVisible(true);
        
    	//Panel & Layout
    	o_gameOverFrame.add(o_gameOverPanel);
        o_gameOverPanel.setBackground(Color.WHITE);
        o_gameOverPanel.updateUI();
        o_gameOverPanel.setLayout(null);
        
        //Formatierung JLabel Game Over Schriftzug
        o_gameOverPanel.add(l_gameOver);
        l_gameOver.setFont(new Font ("Arial", Font.BOLD, 100));
        l_gameOver.setForeground(Color.RED);
        l_gameOver.setBounds(120, 80, 800, 100);
        
        //Formatierung JLabel Score-Schriftzug
        o_gameOverPanel.add(l_score);
        l_score.setFont(new Font ("Arial", Font.BOLD, 30));
        l_score.setForeground(Color.BLACK);
        l_score.setBounds(230, 220, 250, 40);
        
        //Formatierung JLabel High Score Schriftzug
        o_gameOverPanel.add(l_highScore);
        l_highScore.setFont(new Font ("Arial", Font.BOLD, 30));
        l_highScore.setForeground(Color.BLACK);
        l_highScore.setBounds(230, 260, 250, 40);
        
        //Formatierung JButton für den Restart mit ActionListener
        o_gameOverPanel.add(b_restartButton);
        b_restartButton.setFont(new Font ("Arial", Font.BOLD, 30));
        b_restartButton.setForeground(Color.BLACK);
        b_restartButton.setBounds(195, 400, 200, 50);
        b_restartButton.addActionListener(new C_ActionHandler());
        
        //Formatierung JButton für Exit mit ActionListener
        o_gameOverPanel.add(b_exitButton);
        b_exitButton.setFont(new Font ("Arial", Font.BOLD, 30));
        b_exitButton.setForeground(Color.BLACK);
        b_exitButton.setBounds(405, 400, 200, 50);
        b_exitButton.addActionListener(new C_ActionHandler());
        
    }
	   
}
