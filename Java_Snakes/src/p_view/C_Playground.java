package p_view;

import javax.swing.*;

import p_model.C_Snake;
import p_model.C_Body;

import java.awt.*;
/**
 * @Autoren Stephan Schellenberg, Jacob Waniek und Yannik Koesling
 * Inhalt: Erstellung des Grids und der Komponenten im Frame des Spielfelds (Schlange, Futter, Score, HighScore)
 * 
 */
public class C_Playground extends JLabel {

    Point o_point;

    protected void paintComponent(Graphics o_graphics) {
        super.paintComponent(o_graphics);
        Graphics2D g2d = (Graphics2D) o_graphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        //Hintergrund
        o_graphics.setColor(Color.WHITE);
        o_graphics.fillRect(0, 0, C_Game.v_width, C_Game.v_height);

        //Körperteile der Schlange
        o_graphics.setColor(new Color(0, 0, 128));
        for (int i = 0; i < C_Snake.al_bodyParts.size(); i++) {
            o_point = C_Snake.m_ptc(C_Snake.al_bodyParts.get(i).getX(), C_Snake.al_bodyParts.get(i).getY());
            o_graphics.fillOval(o_point.x, o_point.y, 32, 32);
        }
        
        //Kopf der Schlange
        o_graphics.setColor(new Color(0,153,0));
        o_point = C_Snake.m_ptc(C_Snake.o_head.getX(),C_Snake.o_head.getY());
        o_graphics.fillRect(o_point.x,o_point.y,32,32);

        //Futter der Schlange
        o_graphics.setColor(new Color(204,51,0));
        o_point = C_Snake.m_ptc(C_Snake.o_food.getX(), C_Snake.o_food.getY());
        o_graphics.fillOval(o_point.x,o_point.y, 32,32);

        //Hier wird das Grid gezeichnet
        o_graphics.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                o_graphics.drawRect(i * 32 + C_Game.v_xoff, j * 32 + C_Game.v_yoff, 32, 32);
            }
        }

        //Hier wird die Border gezeichnet
        o_graphics.setColor(Color.BLACK);
        o_graphics.drawRect(C_Game.v_xoff, C_Game.v_yoff, 512, 512);

        //Hier wird der Score am linken oberen Rand des Fensters gezeichnet
        o_graphics.setFont(new Font("Arial", Font.BOLD, 20));
        o_graphics.drawString("Score: "+C_Snake.v_score, 5,25);
        o_graphics.drawString("Best: "+C_Snake.v_highScore, 5,50);
        o_graphics.drawString("Pause: P", 5, 75);

        repaint();

    }

}