package p_controller;

import p_model.C_Snake;
import p_monitor.C_Collision;
import p_view.C_GameOver;
import p_view.C_Game;

public class C_StandardMode extends Thread{
    public static boolean v_running = true;
    
    public int v_sleepTime = 500;

    public void run(){
        while(v_running){
        	
        	//Sleep(1) nötig, sonst kommt er bei "pause" nicht mehr raus
        	try {
				sleep(1);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        	if(C_Snake.paused) {
        		continue;        		
        	}
        	
        	if(C_Snake.tails.size() < 1) {
        		C_Snake.addInitialLength();        		
        	}
        	
            try {
                sleep(v_sleepTime);
                C_Snake.move();
                C_Snake.waitToMove = false;
                if(C_Collision.speedUp() == true && v_sleepTime > 175) {
                	v_sleepTime-= 25;
                }
                C_Collision.collidePickUp();
                                                	
                	if(C_Collision.collideSelf() || C_Collision.collideWall()){
                		
                		C_Snake.paused = true;      		
                    	new C_GameOver();                    	
                    	
                    	C_Snake.tails.clear();
                    	C_Snake.head.setX(7);
                    	C_Snake.head.setY(7);
                    	C_Snake.score = 0;
                    	v_sleepTime=500;
                	}
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
