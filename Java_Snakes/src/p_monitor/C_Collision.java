package p_monitor;

import p_model.C_Snake;

public class C_Collision {

	    public static boolean collideSelf() {
	        for(int i = 0; i<C_Snake.tails.size(); i++){
	            if(C_Snake.head.getX() == C_Snake.tails.get(i).getX() && C_Snake.head.getY() == C_Snake.tails.get(i).getY()
	                    && !C_Snake.tails.get(i).isWait()){
	                return true;
	            }

	        }

	        return false;
	    }
	    
	    public static boolean collideWall() {

	        return (C_Snake.head.getX() < 0 || C_Snake.head.getX() > 15 || C_Snake.head.getY() < 0 || C_Snake.head.getY() > 15);
	    }
	    
	    public static boolean speedUp() {
	    	 if (C_Snake.head.getX() == C_Snake.pickup.getX() && C_Snake.head.getY() == C_Snake.pickup.getY()) {
	    		 return true;
	    	 } return false;
	    }
	    
	    public static void collidePickUp() {
	        if (C_Snake.head.getX() == C_Snake.pickup.getX() && C_Snake.head.getY() == C_Snake.pickup.getY()) {
	            C_Snake.pickup.reset();
	            C_Snake.addTail();
	            C_Snake.score +=1;	           
	            
	            if(C_Snake.score > C_Snake.bestscore) C_Snake.bestscore = C_Snake.score;
	            
	        } 
	    }
	    
	  

}
	

