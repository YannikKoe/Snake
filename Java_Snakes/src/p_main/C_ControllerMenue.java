package p_main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class C_ControllerMenue extends C_Menue implements ItemListener{

	/**
	 * Listener for buttons
	 */
	public void itemStateChanged(ItemEvent e) {
		
		
		Object source = e.getItemSelectable();
		
		if(source == o_cb_soundOn) {
			playingMusic = true;
		}
		if(source == o_cb_soundOff) {
			playingMusic = false;
		}
		
		o_b_play.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				System.out.println("Hihihoho Mein name");
			}
		});
		
		b_colorLeft.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				String color = l_color.getText();
				for(int i = 0; i<colors.size(); i++) {
					if(colors.get(i) == color) {
						if(i == 0) {
							l_color.setText(colors.get(colors.size()-1));
						} else {
							l_color.setText((colors.get(i-1)));
						}
					}
				}
				
			}
		});
		
		b_colorRight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String color = l_color.getText();
				for(int i = 0; i<colors.size(); i++) {
					if(colors.get(i) == color) {
						if(i == colors.size()-1) {
							l_color.setText(colors.get(0));
						} else {
							l_color.setText((colors.get(i+1)));
						}
					}
				}
			}
		});
		
		b_foodLeft.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				String color = l_food.getText();
				for(int i = 0; i<colors.size(); i++) {
					if(colors.get(i) == color) {
						if(i == 0) {
							l_food.setText(colors.get(colors.size()-1));
						} else {
							l_food.setText((colors.get(i-1)));
						}
					}
				}
				
			}
		});
		
		b_foodRight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String color = l_food.getText();
				for(int i = 0; i<colors.size(); i++) {
					if(colors.get(i) == color) {
						if(i == colors.size()-1) {
							l_food.setText(colors.get(0));
						} else {
							l_food.setText((colors.get(i+1)));
						}
					}
				}
			}
		});
	}
	
}
