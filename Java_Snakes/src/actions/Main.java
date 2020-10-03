package actions;

import clocks.*;
import gui.Gui;

public class Main {
    public static void main(String[] args) {
    	
        Gui g = new Gui();
        Stream s = new Stream();
        GameClockStandard gc = new GameClockStandard();
        GameClockFree gcf = new GameClockFree();
        boolean done = false;

        do {
        	
        	s.modeInput();
        	if(s.modeInt == 1) {        	
        		g.create();
        		gc.start();
        		done = true;
        	}else if(s.modeInt == 2) {
        		g.create();
        		gcf.start();
        		done = true;
        	}else {
        		System.out.println("Falsche Eingabe!");        	
        	}
        	
        }while(!done);
        
    }
}
