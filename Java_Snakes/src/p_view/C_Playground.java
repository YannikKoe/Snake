package p_view;

import javax.swing.*;

import p_model.C_Snake;
import p_model.C_Body;

import java.awt.*;
/**
 * Autoren: Stephan Schellenberg, Jacob Waniek und Yannik Koesling
 * 
 */
public class C_Playground extends JLabel {

    Point v_p;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        //Hintergrund
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, C_Game.v_width, C_Game.v_height);

        //Körperteile der Schlange
        g.setColor(new Color(0, 0, 128));
        for (int i = 0; i < C_Snake.al_bodyParts.size(); i++) {
            v_p = C_Snake.m_ptc(C_Snake.al_bodyParts.get(i).getX(), C_Snake.al_bodyParts.get(i).getY());
            g.fillOval(v_p.x, v_p.y, 32, 32);
        }
        
        //Kopf der Schlange
        g.setColor(new Color(0,153,0));
        v_p = C_Snake.m_ptc(C_Snake.o_head.getX(),C_Snake.o_head.getY());
        g.fillRect(v_p.x,v_p.y,32,32);

        //Futter der Schlange
        g.setColor(new Color(204,51,0));
        v_p = C_Snake.m_ptc(C_Snake.o_food.getX(), C_Snake.o_food.getY());
        g.fillOval(v_p.x,v_p.y, 32,32);

        //Hier wird das Grid gezeichnet
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                g.drawRect(i * 32 + C_Game.v_xoff, j * 32 + C_Game.v_yoff, 32, 32);
            }
        }

        //Hier wird die Border gezeichnet
        g.setColor(Color.BLACK);
        g.drawRect(C_Game.v_xoff, C_Game.v_yoff, 512, 512);

        //Hier wird der Score am linken oberen Rand des Fensters gezeichnet
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: "+C_Snake.v_score, 5,25);
        g.drawString("Best: "+C_Snake.v_highScore, 5,50);
        g.drawString("Pause: P", 5, 75);

        repaint();

    }

}