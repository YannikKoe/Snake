package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import clocks.GameClockFree;
import clocks.GameClockStandard;
import game.Snake;
import gui.GameOver;
import gui.Gui;
import gui.StartMenue;

public class ActionHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == StartMenue.o_b_play) {
			Gui g = new Gui();
			GameClockStandard gc = new GameClockStandard();
	        GameClockFree gcf = new GameClockFree();
	                
	        if(StartMenue.o_b_standard.isSelected()) {
	        	g.create();
	        	gc.start();
	        	StartMenue.frame.dispose();
	        } else {
	        	g.create();
	        	gcf.start();
	        	StartMenue.frame.dispose();
	        }
	        
		} else if(e.getSource() == GameOver.restart) {
			GameOver.frame.dispose();
            Snake.paused = false;
		} else if(e.getSource() == GameOver.exit) {
			System.exit(0);
		}
		
	}

	
		
}
