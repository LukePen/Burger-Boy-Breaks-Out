package mod;

//This class controls the variables of the Minotaur (Chef)
public class Minotaur {
	
	private Location _position;
	private boolean _isDead;
	private Direction _dir = Direction.DOWN;
	private Location _orgPosition;
	public Location getLoc() { return _position; }
	public boolean isDead() { return _isDead; }
	public Direction getDirection() { return _dir; }
	public Location getOrg() {return _orgPosition;}
	//Moves the chef up and sets the direction up
	public void moveUp() { _position.moveUp(); _dir = Direction.UP; }
	
	//Moves the chef down and sets the direction down
	public void moveDown() { _position.moveDown(); _dir = Direction.DOWN;}
	
	//Moves the chef left and sets the direction left
	public void moveLeft() { _position.moveLeft(); _dir = Direction.LEFT;}
	
	//Moves the chef right and sets the direction right
	public void moveRight() { _position.moveRight(); _dir = Direction.RIGHT;}
	public void setPosition(Location s) { _position = s;}
	
	//This method sets the position to the starting position
	public void setStart() {_position = _orgPosition;}
	
	//"Kills" the chef by setting the isDead to true
	public void kill() { _isDead = true; }
	
	//"Revives" the chef by setting the isDead to false
	public void revive() { _isDead = false; }
	
	//This is the constructor for the minotaur, setting its position to the parameter and setting isDead to false
	public Minotaur(Location pos) {
		_position = pos;
		_isDead = false;
		_orgPosition = pos;
	}
	

	

}
