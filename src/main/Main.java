package main;

import javax.swing.JOptionPane;

import cnt.KeyController;
import cnt.PointCounter;
import cnt.name;

import java.io.IOException;

//This class acts as a main level select class for the beginning of the game, instantiating the controlling class
public class Main {
 private int rc = 0;
	public Main() throws IOException{
		TitleScreen t = new TitleScreen();
		PointCounter p = new PointCounter();
		name n = new name();
		t.reset();
		boolean s = n.getIsRico();
		if(s) {
		    String[] buttons = { "First Level", "Second Level", "Third Level"};

		    rc = JOptionPane.showOptionDialog(null, "Choose which level you'd like to start at!", "Level Select", JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[2]);

		    System.out.println(rc);
		    
		}
		JOptionPane.showMessageDialog(null, "In this game, you play as Burger Boy!, the easily excited burger." + "\n" + 
		"You are trying to escape the evil Mr.Chef who will try to stop you! Along the way, you can pick up toppings to get more points!"
				+ "\n" + "Be sure to watch for traps, and look out for the legendary spatula to slow Mr.Chef!" +
		"\n" + "Press (or hold) WASD to move around the map, and, importantly, have a fantastic amount of food fun!");
		KeyController k = new KeyController(rc, s, 0);
	}
	
}
