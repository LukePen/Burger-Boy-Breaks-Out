package mod;



public class Overseer {
	//This method controls and checks for PVE, checking if the minotaur (chef) and player are in the same location
	public static boolean pVE(Player ply, Minotaur min) {
		int pRow = ply.getLoc().getRow();
		int pCol = ply.getLoc().getCol();
		int mRow = min.getLoc().getRow();
		int mCol = min.getLoc().getCol();
		if(pRow == mRow && pCol == mCol) {
			ply.kill();
			return true;
		}
		return false;
	}
	//This method checks if the game is completed (player in end spot and having key)
	public static boolean completed(Player ply, Maze maze) {
		int pRow = ply.getLoc().getRow();
		int pCol = ply.getLoc().getCol();
		int eRow = maze.getEnd().getRow();
		int eCol = maze.getEnd().getCol();
		if(pRow == eRow && pCol == eCol) {
			return true;
		}
		return false;
	}
	
	//This method checks if the player is in the same location as the sword (spatula)
	public static boolean sword(Player ply, Sword s) {
		int pRow = ply.getLoc().getRow();
		int pCol = ply.getLoc().getCol();
		int eRow = s.getLoc().getRow();
		int eCol = s.getLoc().getCol();
		if(pRow == eRow && pCol == eCol) {
			return true;
		}
		return false;
	}
	//This method checks if the player is in the same location as the Key
	public static boolean Key(Player ply, Key s) {
		int pRow = ply.getLoc().getRow();
		int pCol = ply.getLoc().getCol();
		int eRow = s.getLoc().getRow();
		int eCol = s.getLoc().getCol();
		if(pRow == eRow && pCol == eCol) {
			return true;
		}
		return false;
	}
	//This method checks if the player is in the same location as the first point object
	public static boolean Point1(Player ply, Point1 s) {
		int pRow = ply.getLoc().getRow();
		int pCol = ply.getLoc().getCol();
		int eRow = s.getLoc().getRow();
		int eCol = s.getLoc().getCol();
		if(pRow == eRow && pCol == eCol) {
			return true;
		}
		return false;
	}
	//This method checks if the player is in the same location as the second point object
	public static boolean Point2(Player ply, Point2 s) {
		int pRow = ply.getLoc().getRow();
		int pCol = ply.getLoc().getCol();
		int eRow = s.getLoc().getRow();
		int eCol = s.getLoc().getCol();
		if(pRow == eRow && pCol == eCol) {
			return true;
		}
		return false;
	}
	
	//This method checks if the player is in the same location as the third point object
	public static boolean Point3(Player ply, Point3 s) {
		int pRow = ply.getLoc().getRow();
		int pCol = ply.getLoc().getCol();
		int eRow = s.getLoc().getRow();
		int eCol = s.getLoc().getCol();
		if(pRow == eRow && pCol == eCol) {
			return true;
		}
		return false;
	}
	
	//This method checks if the player is on the vent trap
	public static boolean ventTrap(Player ply, Maze s) {
		int pRow = ply.getLoc().getRow();
		int pCol = ply.getLoc().getCol();
		int eRow = s.getVentTrap().getRow();
		int eCol = s.getVentTrap().getCol();
		if(pRow == eRow && pCol == eCol) {
			return true;
		}
		return false;
	}
	//This method checks if the player is on the jump trap

	public static boolean jumpTrap(Player ply, Maze s) {
		int pRow = ply.getLoc().getRow();
		int pCol = ply.getLoc().getCol();
		int eRow = s.getJumpTrap().getRow();
		int eCol = s.getJumpTrap().getCol();
		if(pRow == eRow && pCol == eCol) {
			return true;
		}
		return false;
	}
	
	//This method checks if the position the player is trying to move to is able to be moved in
	public static boolean isValid(Maze maze, Player ply, Direction d) {
		boolean[][] map = maze.getMap().getArr();
		int row = ply.getLoc().getRow();
		int col = ply.getLoc().getCol();
		
		if(d == Direction.UP) {
			if(row == 0)
				return false;
			row--;
			return map[row][col];
		}
		else if(d == Direction.DOWN) {
			if(row == map.length - 1)
				return false;
			row++;
			return map[row][col];
		}
		else if(d == Direction.LEFT) {
			if(col == 0)
				return false;
			col--;
			return map[row][col];
		}
		else {
			if(col == map[row].length - 1)
				return false;
			col++;
			return map[row][col];
		}
	}
	//This method randomly checks if the sword (spatula) is gonna be broken after PVE
	public static boolean breakSword() {
		int x = (int)(101 * Math.random());
		return x > 50;
	}
	
	//This method controls moving the player via a direction parameter 
	public static void movePlayer(Player ply, Direction d) {

		if(d == Direction.UP) 
			ply.moveUp();
		
		else if(d == Direction.DOWN) 
			ply.moveDown();
		
		else if(d == Direction.LEFT) 
			ply.moveLeft();
		
		else 
			ply.moveRight();
	}
	
	//This method moves the minotaur, acting as a "dumb" ai to go towards the player
	public static void moveMinotaur(Maze maze, Minotaur min, Player ply) {
		int _minRow = min.getLoc().getRow();
		int _minCol = min.getLoc().getCol();
		boolean[][] map = maze.getMap().getArr();
		
		int rowDist = min.getLoc().getRow() - ply.getLoc().getRow();
		int colDist = min.getLoc().getCol() - ply.getLoc().getCol();
		
		if(rowDist > 0){ // Min Row > Ply Row
			if(map[_minRow - 1][_minCol]){
				min.moveUp();
			}
			else{
				if(colDist > 0 && map[_minRow][_minCol - 1]){ // Move Left
					min.moveLeft();
				}
				else if(colDist < 0 && map[_minRow][_minCol + 1]){ 
					min.moveRight();
				}
			}
		}
		else if(rowDist < 0){ // Min Row < Ply Row
			if(map[_minRow + 1][_minCol]){
				min.moveDown();
			}
			else{
				if(colDist > 0 && map[_minRow][_minCol - 1]){
					min.moveLeft();
				}
				else if(colDist < 0 && map[_minRow][_minCol + 1]){
					min.moveRight();
				}
			}
		}
		else {
			if(colDist > 0 && map[_minRow][_minCol - 1]){
				min.moveLeft();
			}
			else if(colDist < 0 && map[_minRow][_minCol + 1]){
				min.moveRight();
			}
			
		}
	}
	
	
	
	
	
	
}
