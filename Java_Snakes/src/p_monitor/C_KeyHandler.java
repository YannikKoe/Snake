package p_monitor;

import p_view.C_Playground;
import p_view.C_GameOver;
import p_view.C_Pause;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import p_controller.C_StandardMode;
import p_model.Enum_Route;
import p_model.C_Snake;
/**
 * Autoren: Stephan Schellenberg, Jacob Waniek und Yannik Kösling
 * Inhalt: Beinhaltet die Ereignisbehandler der Tastatur
 */
public class C_KeyHandler implements KeyListener {  

    /**
     * Pfeiltasten zur Steuerung der Schlange
     */
	@Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (!(C_Snake.o_head.getCoordinate() == Enum_Route.DOWN) && !C_Snake.v_waitToMove) {
                    C_Snake.o_head.setCoordinate(Enum_Route.UP);
                    C_Snake.v_waitToMove = true;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (!(C_Snake.o_head.getCoordinate() == Enum_Route.RIGHT) && !C_Snake.v_waitToMove) {
                    C_Snake.o_head.setCoordinate(Enum_Route.LEFT);
                    C_Snake.v_waitToMove = true;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (!(C_Snake.o_head.getCoordinate() == Enum_Route.UP) && !C_Snake.v_waitToMove) {
                    C_Snake.o_head.setCoordinate(Enum_Route.DOWN);
                    C_Snake.v_waitToMove = true;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (!(C_Snake.o_head.getCoordinate() == Enum_Route.LEFT) && !C_Snake.v_waitToMove) {
                    C_Snake.o_head.setCoordinate(Enum_Route.RIGHT);
                    C_Snake.v_waitToMove = true;
                }
                break;
            
        }
    }

    
    /**
     * Fuer Pause Key
     */
	@Override
    public void keyReleased(KeyEvent e) {
    	switch (e.getKeyCode()) {
    	case KeyEvent.VK_P:
        	if(C_Snake.v_paused == false) {
        		C_Snake.v_paused = true;
        		new C_Pause();
        	}else {
        		C_Pause.o_pauseFrame.dispose();
        		C_Snake.v_paused = false;  
        	}           	
        	break;
    	}
    }
    
    
    @Override
    public void keyTyped(KeyEvent e) {
    	
    }
}
