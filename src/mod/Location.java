package mod;

//This method controls the locations of all objects
public class Location {

	private int _row, _col;
	
	public int getRow() { return _row; }
	public int getCol() { return _col; }
	
	//This method moves the location down by adding to the row variable (acting like an array)
	public void moveDown() { _row++; }
	
	//This method moves the location up by subtracting to the row variable (acting like an array)
	public void moveUp() { _row--; }
	
	//This method moves the location left by subtracting to the column variable (acting like an array)
	public void moveLeft() { _col--; }
	
	//This method moves the location right by adding to the column variable (acting like an array)
	public void moveRight() { _col++; }
	
	//This is the constructor, with the starting parameter of location
	public Location(int row, int col) {
		_row = row;
		_col = col;
	}
	
	//This method "resets" the location by changing the row and column variable to whatever is passed as a parameter
	public void reset(int row, int col) {
		_row = row;
		_col = col;
	}
}