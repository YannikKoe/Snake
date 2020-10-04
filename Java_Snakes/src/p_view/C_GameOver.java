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

public class C_GameOver {
	
	public static JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel gameOver = new JLabel("Game Over");
	JLabel score = new JLabel("Score: "+C_Snake.score);
	JLabel highScore = new JLabel("High Score: "+C_Snake.bestscore);
	public static JButton exit = new JButton("Exit");
	public static JButton restart = new JButton("Restart");

    public static int width = 800, height = 600;

    public C_GameOver(){
        
    	frame.setTitle("Game Over");
    	frame.setSize(width,height);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setLocationRelativeTo(null);
    	frame.setResizable(false);
        
    	frame.requestFocus();
    	frame.setVisible(true);
        
    	frame.add(panel);
        panel.setBackground(Color.WHITE);
        panel.updateUI();
        panel.setLayout(null);
        
        panel.add(gameOver);
        gameOver.setFont(new Font ("Arial", Font.BOLD, 100));
        gameOver.setForeground(Color.RED);
        gameOver.setBounds(120, 80, 800, 100);
        
        panel.add(score);
        score.setFont(new Font ("Arial", Font.BOLD, 30));
        score.setForeground(Color.BLACK);
        score.setBounds(230, 220, 200, 40);
        
        panel.add(highScore);
        highScore.setFont(new Font ("Arial", Font.BOLD, 30));
        highScore.setForeground(Color.BLACK);
        highScore.setBounds(230, 260, 200, 40);
        
        panel.add(restart);
        restart.setFont(new Font ("Arial", Font.BOLD, 30));
        restart.setForeground(Color.BLACK);
        restart.setBounds(195, 400, 200, 50);
        restart.addActionListener(new C_ActionHandler());
        
        panel.add(exit);
        exit.setFont(new Font ("Arial", Font.BOLD, 30));
        exit.setForeground(Color.BLACK);
        exit.setBounds(405, 400, 200, 50);
        exit.addActionListener(new C_ActionHandler());
        
    }
	   
}
