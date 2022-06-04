package view;

import javax.swing.ImageIcon;

//This enum contains all the path names to the images used to display the game
public enum Graphics {

	PATH("path.png"), WALL("wall.png"),
	PUP("PUp.png"),PDOWN("PDown.png"),
	PRIGHT("PRight.png"),PLEFT("PLeft.png"),
	MUP("MUp.png"),MDOWN("MDown.png"),
	MRIGHT("MRight.png"),MLEFT("MLeft.png"),
	End("End.png"),BOWSAPATH("bowsercarpet.png"),BOWSAWALLS("bowserBrick.png"),MARUP("marioUp.png"), 
	MARLEFT("marioLeft.png")
	,MARRIGHT("marioRight.png"), MADOWN("marioDown.png"), BRICK("brick.png"), BURGERDOWN("burgerdown.png"),
	BURGERLEFT("burgerleft.png"),BURGERRIGHT("burgerright.png"),BURGERUP("burgerup.png"), FLOOR("floor.png")
	, CHEFUP("chefup.png"), CHEFDOWN("chefdown.png"), CHEFLEFT("chefleft.png"), CHEFRIGHT("chefright.png"),
	KEY("key.png"), BACON("bacon.png"), PICKLES("pickles.png"), TOMATOES("tomatoes.png"), VENT("ricovent.png"),
	SWORD("Capture.png"), DOOR("door.png"), SLIP("slip.png");
	private ImageIcon _img;
	
	public ImageIcon getImage(){ return _img; }
	private Graphics(String fName) {
		_img = new ImageIcon(getClass().getResource("/images/"+fName));
	}
}
