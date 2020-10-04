package p_model;

import java.awt.*;
import java.util.ArrayList;

import p_view.C_Game;

public class C_Snake {

    public static int score = 0, bestscore = 0;

    public static boolean waitToMove = false;
    
    public static boolean paused = false;

    public static C_Head head = new C_Head(7, 7);

    public static ArrayList<C_Body> tails = new ArrayList<>();
    
    public static C_Food pickup = new C_Food();
    
    //Schlange kriegt eine initiale Länge von 5
    public static void addInitialLength() {
    	tails.add(new C_Body(head.getX(), head.getY()));
    	for (int i = 0; i < 4; i++) {
    		tails.add(new C_Body(tails.get(tails.size() - 1).x, tails.get(tails.size() - 1).y));			
		}
    }
    
    //fügt 1 Body hinzu
    public static void addTail() {
        tails.add(new C_Body(tails.get(tails.size() - 1).x, tails.get(tails.size() - 1).y));
    }
      
    public static void move() {
        //Move Tails
        if (tails.size() >= 2) {
            for (int i = tails.size() - 1; i >= 1; i--) {
                if (tails.get(i).isWait()) {
                    tails.get(i).setWait(false);
                } else {
                    tails.get(i).setX(tails.get(i - 1).getX());
                    tails.get(i).setY(tails.get(i - 1).getY());
                }
            }
        }

        //Move first Tail to Head
        if (tails.size() >= 1) {
            if (tails.get(0).isWait()) {
                tails.get(0).setWait(false);
            } else {
                tails.get(0).setX(head.getX());
                tails.get(0).setY(head.getY());
            }
        }

        //Move Head
        switch (head.getDir()) {
            case RIGHT:
                head.setX(head.getX() + 1);
                break;
            case UP:
                head.setY(head.getY() - 1);
                break;
            case LEFT:
                head.setX(head.getX() - 1);
                break;
            case DOWN:
                head.setY(head.getY() + 1);
                break;
        }

    }

    //Position to Coordiantes
    public static Point ptc(int x, int y) {
        Point p = new Point(0, 0);
        p.x = x * 32 + C_Game.xoff;
        p.y = y * 32 + C_Game.yoff;

        return p;
    }

}
