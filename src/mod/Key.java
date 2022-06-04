package mod;

//This class controls the keys needed to open the door at the end of the level
public class Key {
	private Location _position;
	private boolean _isUsed;
	private boolean isRico;
	private boolean _isPickedUp;
	public Location getLoc() { return _position; }
	public boolean getIsUsed() { return _isUsed; }
	public boolean getPickedUp() { return _isPickedUp;}

	//This method resets the key
	public void reset() {
		_isPickedUp = false;
		_isUsed = false;
	}
	
	//This method sets th ekey to picked up
	public void setIsPickedUp() {_isPickedUp = true; }
	
	//This method sets debug mode to true
	public void setRico() {
		isRico = true;
	}
	
	//This is the constructor for this class, taking in a position for it to start in
	public Key(Location pos) {
		_position = pos;
		_isUsed = false;
		isRico = false;
}
}
