package main;

import java.io.IOException;

import javax.swing.JOptionPane;

//This class acts like the main class for the entire program
public class MAINMAIN {

	public static void main(String[] args0) throws Throwable{
		 try {
			    // body of main method goes here, including any other error handling
				Main o = new Main();

			  } catch (Throwable t) {
			    JOptionPane.showMessageDialog(
			    		
			        null, t.getClass().getSimpleName() + ": " + t.getMessage());
			    throw t; // don't suppress Throwable
			  }
	}

}
