package clocks;

import javax.swing.JLabel;

import actions.Collision;
import game.Snake;
import gui.GameOver;
import gui.Gui;

public class GameClockFree extends Thread{
    public static boolean running = true;
    
    public int sleepTime = 500;

    public void run(){

        while(running){
        	
        	//Sleep(1) noetig, sonst kommt er bei "pause" nicht mehr raus
        	try {
				sleep(1);
			} catch (InterruptedException e1) {
			
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
                	
                	if(Collision.collideWall()) {
                		               		
                		if(Snake.head.getX() > 15) {               			
                			Snake.head.setX(0);               
                		}else if(Snake.head.getX() < 0){
                			Snake.head.setX(15);
                		}else if(Snake.head.getY() > 15) {
                			Snake.head.setY(0);
                		}else if(Snake.head.getY() < 0) {
                			Snake.head.setY(15);
                		}
                		
                	}
                
                	if(Collision.collideSelf()){
                		
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
