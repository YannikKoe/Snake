package p_model;

import java.awt.*;
import java.util.ArrayList;

import p_view.C_Game;
/**
 * Autoren: Stephan Schellenberg, Jacob Waniek und Yannik Koesling
 * Inhalt:  Beinhaltet die Logik der Schlange, sprich die Bewegung und die Organisation der Koerperteile und des Kopfes der Schlange
 */
public class C_Snake {

    public static int v_score = 0, v_highScore = 0;

    public static boolean v_waitToMove = false;
    
    public static boolean v_paused = false;

    public static C_Head o_head = new C_Head(7, 7);

    public static ArrayList<C_Body> al_bodyParts = new ArrayList<>();
    
    public static C_Food o_food = new C_Food();
    
    
    //Fuegt der Schlange 5 Koerperteile hinzu
    public static void m_addInitialLength() {
    	al_bodyParts.add(new C_Body(o_head.getX(), o_head.getY()));
    	for (int i = 0; i < 4; i++) {
    		al_bodyParts.add(new C_Body(al_bodyParts.get(al_bodyParts.size() - 1).x, al_bodyParts.get(al_bodyParts.size() - 1).y));			
		}
    }
    
    //Fuegt der Schlange ein Koerperteil hinzu
    public static void m_addBodyPart() {
        al_bodyParts.add(new C_Body(al_bodyParts.get(al_bodyParts.size() - 1).x, al_bodyParts.get(al_bodyParts.size() - 1).y));
    }
    
    //Bewegung der Schlange
    public static void m_move() {
    	
        //Wenn die Schlange mindestens 2 Koerperteile hat, wird das hintere Koerperteil auf die Koordinaten des vorderen Koerperteils gesetzt
        if (al_bodyParts.size() >= 2) {
            for (int i = al_bodyParts.size() - 1; i >= 1; i--) {
                if (al_bodyParts.get(i).m_isWaiting()) {
                    al_bodyParts.get(i).m_setWaiting(false);
                } else {
                    al_bodyParts.get(i).setX(al_bodyParts.get(i - 1).getX());
                    al_bodyParts.get(i).setY(al_bodyParts.get(i - 1).getY());
                }
            }
        }

        //Das erste Koerperteil wird auf die Koordinaten des Schlangenkopfes gesetzt
        if (al_bodyParts.size() >= 1) {
            if (al_bodyParts.get(0).m_isWaiting()) {
                al_bodyParts.get(0).m_setWaiting(false);
            } else {
                al_bodyParts.get(0).setX(o_head.getX());
                al_bodyParts.get(0).setY(o_head.getY());
            }
        }

        //Die Koordinaten des Schlangenkopfes ergeben sich durch die Steuerung mit den Pfeiltasten
        switch (o_head.getCoordinate()) {
            case RIGHT:
                o_head.setX(o_head.getX() + 1);
                break;
            case UP:
                o_head.setY(o_head.getY() - 1);
                break;
            case LEFT:
                o_head.setX(o_head.getX() - 1);
                break;
            case DOWN:
                o_head.setY(o_head.getY() + 1);
                break;
        }

    }

    //Weist die entgegengenommenen Koordinaten einem Point Objekt zu und gibt dieses zurück
    public static Point m_ptc(int x, int y) {
        Point p = new Point(0, 0);
        p.x = x * 32 + C_Game.v_xoff;
        p.y = y * 32 + C_Game.v_yoff;

        return p;
    }

}
