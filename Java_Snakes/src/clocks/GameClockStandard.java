package clocks;

import actions.Collision;
import game.Snake;
import gui.GameOver;
import gui.Gui;

public class GameClockStandard extends Thread{
    public static boolean running = true;
    
    public int sleepTime = 500;

    public void run(){
        while(running){
        	
        	//Sleep(1) nötig, sonst kommt er bei "pause" nicht mehr raus
        	try {
				sleep(1);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        	if(Snake.paused) {
        		continue;        		
        	}
        	
        	if(Snake.tails.size() < 1) {
        		Snake.addInitialLength();        		
        	}
        	
            try {
                sleep(sleepTime);
                Snake.move();
                Snake.waitToMove = false;
                if(Collision.speedUp() == true && sleepTime > 175) {
                	sleepTime-= 25;
                }
                Collision.collidePickUp();
                                                	
                	if(Collision.collideSelf() || Collision.collideWall()){
                		
                		Snake.paused = true;      		
                    	new GameOver();                    	
                    	
                    	Snake.tails.clear();
                    	Snake.head.setX(7);
                    	Snake.head.setY(7);
                    	Snake.score = 0;
                    	sleepTime=500;
                	}
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
