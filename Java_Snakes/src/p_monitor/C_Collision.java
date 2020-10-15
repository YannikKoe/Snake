package p_monitor;

import p_model.C_Snake;
/**
 * @Autoren Stephan Schellenberg, Jacob Waniek und Yannik Koesling
 * Inhalt:  Beinhaltet die Methoden zur Ueberpruefung ob eine Kollision der Schlange aufgetreten ist
 */
public class C_Collision {
	
		//Ueberprueft ob die Schlange mit sich selbst kollidiert und gibt einen Wahrheitswert zurueck
	    public static boolean m_collideSelf() {
	        for(int i = 0; i<C_Snake.al_bodyParts.size(); i++){
	            if(C_Snake.o_head.getX() == C_Snake.al_bodyParts.get(i).getX() && C_Snake.o_head.getY() == C_Snake.al_bodyParts.get(i).getY()
	                    && !C_Snake.al_bodyParts.get(i).m_isWaiting()){
	                return true;
	            }
	        }
	        return false;
	    }
	    
	    //Ueberprueft ob die Schlange das Spielfeld verlaesst und gibt einen Wahrheitswert zurueck
	    public static boolean m_moveOverWall() {
	        return (C_Snake.o_head.getX() < 0 || C_Snake.o_head.getX() > 15 || C_Snake.o_head.getY() < 0 || C_Snake.o_head.getY() > 15);
	    }
	    
	 
	    //Ueberprueft ob die Schlange etwas gefressen hat und gibt einen Wahrheitswert zurueck	     
	    public static boolean m_speedUp() {
	    	 if (C_Snake.o_head.getX() == C_Snake.o_food.getX() && C_Snake.o_head.getY() == C_Snake.o_food.getY()) {
	    		 return true;
	    	 } return false;
	    }
	    
	    //Ueberprueft ob die Schlange sich auf den selben Koordinaten wie das Essen befindet
	    //Falls ja wird das Essen entfernt, der Schlange ein Koerperteil hinzugefügt und der Score hochgezaehlt
	    public static void m_eatFood() {
	        if (C_Snake.o_head.getX() == C_Snake.o_food.getX() && C_Snake.o_head.getY() == C_Snake.o_food.getY()) {
	            C_Snake.o_food.m_reset();
	            C_Snake.m_addBodyPart();
	            C_Snake.v_score +=1;	           
	            
	            //Falls es sich um den besten Versuch handelt, wird zudem der High Score hochgezaehlt
	            if(C_Snake.v_score > C_Snake.v_highScore) C_Snake.v_highScore = C_Snake.v_score;
	            
	        } 
	    }
	    
	  

}
	

