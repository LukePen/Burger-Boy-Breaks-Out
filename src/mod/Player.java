package mod;

//This class Controls the player (burger!) and its position and sword having
public class Player {

	private Location _position;
	private boolean _isDead;
	private boolean _hasSword;
	private Direction _dir = Direction.UP;
	
	public Location getLoc() { return _position; }
	public boolean isDead() { return _isDead; }
	public boolean hasSword() { return _hasSword; }
	public Direction getDirection() { return _dir; }
	
	//Moves the player up, sets the direction up
	public void moveUp() { _position.moveUp(); _dir = Direction.UP;}
	
	//Moves the player down, sets the direction down
	public void moveDown() { _position.moveDown(); _dir = Direction.DOWN;}
	
	//Moves the player left, sets the direction left
	public void moveLeft() { _position.moveLeft(); _dir = Direction.LEFT;}
	
	//Moves the player right, sets the direction right
	public void moveRight() { _position.moveRight(); _dir = Direction.RIGHT;}

	//"Kills" the player by setting the isDead variable to true
	public void kill() { _isDead = true; }
	
	//"Revives" the player by setting the isDead variable to false
	public void revive() { _isDead = false; }
	
	//This is the constructor for the Player class, taking the parameter of starting location while setting it to alive and the sword boolean to false
	public Player(Location pos) {
		_position = pos;
		_isDead = false;
		_hasSword = false;
		
	}
}
