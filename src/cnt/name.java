package cnt;

import javax.swing.JOptionPane;

//This method controls the name the player chooses
public class name {
	private String _name ="";
	private boolean p = false;
	
	//This is the constructor which controls this class and asks for the name, instantiating the name value and checking if it is in debug mode
	public name() {
		_name = JOptionPane.showInputDialog(null, "Welcome to Burger Boy Breaks Out! What is your name? (Rico for DEBUG mode)");
		if(_name.equalsIgnoreCase("Rico")) {
			p = true;
			
		}
	}
	public boolean getIsRico(){
		return p;
	}
	
	public String getName() {
		return _name;
	}
}
