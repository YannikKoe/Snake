package actions;

import game.Dir;
import game.Snake;
import gui.Draw;
import gui.GameOver;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import clocks.GameClockStandard;

public class KeyHandler implements KeyListener {  

    @Override
    /*
     * Pfeiltasten zur Steuerung der Schlange
     */
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (!(Snake.head.getDir() == Dir.DOWN) && !Snake.waitToMove) {
                    Snake.head.setDir(Dir.UP);
                    Snake.waitToMove = true;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (!(Snake.head.getDir() == Dir.RIGHT) && !Snake.waitToMove) {
                    Snake.head.setDir(Dir.LEFT);
                    Snake.waitToMove = true;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (!(Snake.head.getDir() == Dir.UP) && !Snake.waitToMove) {
                    Snake.head.setDir(Dir.DOWN);
                    Snake.waitToMove = true;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (!(Snake.head.getDir() == Dir.LEFT) && !Snake.waitToMove) {
                    Snake.head.setDir(Dir.RIGHT);
                    Snake.waitToMove = true;
                }
                break;
            
        }
    }
    
    
    @Override
    public void keyTyped(KeyEvent e) {
    	
    }
    
    @Override
    /*
     * For Pause Key
     */
    public void keyReleased(KeyEvent e) {
    	switch (e.getKeyCode()) {
    	case KeyEvent.VK_P:
        	if(Snake.paused == false) {
        		Snake.paused = true;
        	}else {
        		Snake.paused = false;  
        	}           	
        	break;
    	}
    }
}
