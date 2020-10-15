package p_controller;

import p_model.C_Snake;
import p_monitor.C_Collision;
import p_view.C_GameOver;
import p_view.C_Game;
/**
 * @Autoren Stephan Schellenberg, Jacob Waniek und Yannik Koesling
 * Inhalt: Ablauflogik Standardmodus
 */
public class C_StandardMode extends Thread{
    public static boolean v_running = true;
    
    public int v_sleepTime = 500;
    /**
     * Beinhaltet die komplette Steuerung und Ablauflogik des Standard Modus
     */
    public void run(){
        while(v_running){
        	
        	//Schlafen legen des Threads, um auf Interaktionen anderer Klassen zu warten
        	//Notwendig um nach einer Pausierung das Spiel wieder zu starten
        	try {
				sleep(1);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        	//Wenn das Spiel pausiert ist, wird die aktuelle Iteration der Schleife hier abgebrochen
        	if(C_Snake.v_paused) {
        		continue;        		
        	}
        	
        	//Falls die Schlange noch keine Körperteile besitzt, soll eine initiale Laenge angehaengt werden
        	//Wird bei Spielstart ausgeführt
        	if(C_Snake.al_bodyParts.size() < 1) {
        		C_Snake.m_addInitialLength();        		
        	}
        	
        	//Bewegung der Schlange und Regelung deren Geschwindigkeit
            try {
                sleep(v_sleepTime);
                C_Snake.m_move();
                C_Snake.v_waitToMove = false;
                
                //Erhoehung der Geschwindigkeit, wenn Futter aufgesammelt wurde
                //Begrenzung der maximalen Geschwindigkeit durch Setzen einer minimalen sleepTime von 175 Millisekunden
                if(C_Collision.m_speedUp() == true && v_sleepTime > 175) {
                	v_sleepTime-= 25;
                }
                
                //Aufsammeln des Futters
                C_Collision.m_eatFood();
                
                //Spielende bei Kollision mit dem eigenen Schwanz oder mit einer Wand
                if(C_Collision.m_collideSelf() || C_Collision.m_moveOverWall()){
                		
                	C_Snake.v_paused = true;      		
                    new C_GameOver();                    	
                    	
                    C_Snake.al_bodyParts.clear();
                    C_Snake.o_head.setX(7);
                    C_Snake.o_head.setY(7);
                    C_Snake.v_score = 0;
                    v_sleepTime=500;
                    
                	}
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
