package mod;


//This class controls the sword (spatula) object
public class Sword {
	private Location _position;
	private boolean _isUsed;
	private boolean isRico;
	private boolean _isPickedUp;
	public Location getLoc() { return _position; }
	public boolean getIsUsed() { return _isUsed; }
	public boolean getPickedUp() { return _isPickedUp;}
	
	//Sets the sword to used
	public void setUsed() { _isUsed = true; }
	
	//Sets the sword to Unused
	public void setUnused() { _isUsed = false; }
	
	//Resets the sword
	public void reset() {
		_isPickedUp = false;
		_isUsed = false;
	}
	
	public void setIsPickedUp() {_isPickedUp = true; }
	
	public void setRico() {
		isRico = true;
	}
	public boolean getRico() {
		return isRico;
	}
	
	//This is the constructor for this class, taking in the location in which it will be at
	public Sword(Location pos) {
		_position = pos;
		_isUsed = false;
		isRico = false;
}
}
