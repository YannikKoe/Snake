package p_monitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import p_controller.C_FreeMode;
import p_controller.C_StandardMode;
import p_model.C_Snake;
import p_view.C_GameOver;
import p_view.C_Game;
import p_view.C_StartMenue;
/**
 * Autoren: Stephan Schellenberg, Jacob Waniek und Yannik Koesling
 * Inhalt: Ereignisbehandler fuer die Frames und Buttons
 */
public class C_ActionHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		//Auswahl des Modus
		if(e.getSource() == C_StartMenue.b_playButton) {
			C_Game o_game = new C_Game();
	                
	        if(C_StartMenue.rb_standardMode.isSelected()) {
	        	C_StandardMode o_standardMode = new C_StandardMode();
	        	o_game.create();
	        	o_standardMode.start();
	        	C_StartMenue.o_startFrame.dispose();
	        } else {
	        	C_FreeMode o_freeMode = new C_FreeMode();
	        	o_game.create();
	        	o_freeMode.start();
	        	C_StartMenue.o_startFrame.dispose();
	        }
	    
	    //Neustart auf restart Knopfdruck im GameOver Frame
		} else if(e.getSource() == C_GameOver.b_restartButton) {
			C_GameOver.o_gameOverFrame.dispose();
            C_Snake.v_paused = false;
        
        //Spiel beenden bei exit Knopfdruck im Game Over Frame
		} else if(e.getSource() == C_GameOver.b_exitButton) {
			System.exit(0);
		}
		
	}

	
		
}
