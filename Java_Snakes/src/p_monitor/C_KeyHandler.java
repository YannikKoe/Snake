package p_monitor;

import p_view.C_Playground;
import p_view.C_GameOver;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import p_controller.C_StandardMode;
import p_model.Enum_Route;
import p_model.C_Snake;

public class C_KeyHandler implements KeyListener {  

    @Override
    /*
     * Pfeiltasten zur Steuerung der Schlange
     */
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (!(C_Snake.head.getDir() == Enum_Route.DOWN) && !C_Snake.waitToMove) {
                    C_Snake.head.setDir(Enum_Route.UP);
                    C_Snake.waitToMove = true;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (!(C_Snake.head.getDir() == Enum_Route.RIGHT) && !C_Snake.waitToMove) {
                    C_Snake.head.setDir(Enum_Route.LEFT);
                    C_Snake.waitToMove = true;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (!(C_Snake.head.getDir() == Enum_Route.UP) && !C_Snake.waitToMove) {
                    C_Snake.head.setDir(Enum_Route.DOWN);
                    C_Snake.waitToMove = true;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (!(C_Snake.head.getDir() == Enum_Route.LEFT) && !C_Snake.waitToMove) {
                    C_Snake.head.setDir(Enum_Route.RIGHT);
                    C_Snake.waitToMove = true;
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
        	if(C_Snake.paused == false) {
        		C_Snake.paused = true;
        	}else {
        		C_Snake.paused = false;  
        	}           	
        	break;
    	}
    }
}
