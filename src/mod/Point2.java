package mod;

//This class controls the first Point object
public class Point2 {
	private Location _position;
	private boolean _isUsed;
	private boolean isRico;
	private boolean _isPickedUp;
	public Location getLoc() { return _position; }
	public boolean getIsUsed() { return _isUsed; }
	public boolean getPickedUp() { return _isPickedUp;}

	//This method resets the point object
	public void reset() {
		_isPickedUp = false;
		_isUsed = false;
	}
	
	public void setIsPickedUp() {_isPickedUp = true; }
	
	//This method sets debug mode on
	public void setRico() {
		isRico = true;
	}
	
	//This is the constructor for the second object, taking in the location it will be in
	public Point2(Location pos) {
		_position = pos;
		_isUsed = false;
	}
	}
