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

public class C_ActionHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == C_StartMenue.o_b_play) {
			C_Game g = new C_Game();
			C_StandardMode gc = new C_StandardMode();
	        C_FreeMode gcf = new C_FreeMode();
	                
	        if(C_StartMenue.o_b_standard.isSelected()) {
	        	g.create();
	        	gc.start();
	        	C_StartMenue.frame.dispose();
	        } else {
	        	g.create();
	        	gcf.start();
	        	C_StartMenue.frame.dispose();
	        }
	        
		} else if(e.getSource() == C_GameOver.restart) {
			C_GameOver.frame.dispose();
            C_Snake.paused = false;
		} else if(e.getSource() == C_GameOver.exit) {
			System.exit(0);
		}
		
	}

	
		
}
