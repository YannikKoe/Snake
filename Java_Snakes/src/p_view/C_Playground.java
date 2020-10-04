package p_view;

import javax.swing.*;

import p_model.C_Snake;
import p_model.C_Body;

import java.awt.*;

public class C_Playground extends JLabel {

    Point p;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        //Draw Background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, C_Game.width, C_Game.height);

        //Draw Snake Tails
        g.setColor(new Color(0, 0, 128));
        for (int i = 0; i < C_Snake.tails.size(); i++) {
            p = C_Snake.ptc(C_Snake.tails.get(i).getX(), C_Snake.tails.get(i).getY());
            g.fillOval(p.x, p.y, 32, 32);
        }
        
        //Draw Snake Head
        g.setColor(new Color(0,153,0));
        p = C_Snake.ptc(C_Snake.head.getX(),C_Snake.head.getY());
        g.fillRect(p.x,p.y,32,32);

        //Draw PickUp
        g.setColor(new Color(204,51,0));
        p = C_Snake.ptc(C_Snake.pickup.getX(), C_Snake.pickup.getY());
        g.fillOval(p.x,p.y, 32,32);

        //Draw Grid
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                g.drawRect(i * 32 + C_Game.xoff, j * 32 + C_Game.yoff, 32, 32);
            }
        }

        //Draw Border
        g.setColor(Color.BLACK);
        g.drawRect(C_Game.xoff, C_Game.yoff, 512, 512);

        //Draw Score
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: "+C_Snake.score, 5,25);
        g.drawString("Best: "+C_Snake.bestscore, 5,50);
        g.drawString("Pause: P", 5, 75);

        repaint();

    }

}