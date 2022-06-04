package cnt;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import mod.Direction;
import mod.Maze;
import mod.Minotaur;
import mod.Overseer;
import mod.Player;
import mod.Point1;
import mod.Point2;
import mod.Point3;
import view.MazeWindow;

import mod.Sword;
import mod.Location;
import mod.Key;

/*This class acts as the overseer class for the entire project,
 * working to integrate and control the different front and back end code.
 *  It also controls the key inputs to control the character.
 */
public class KeyController implements KeyListener {

	private Player _ply;
	private Minotaur _min;
	private Maze _maze;
	private MazeWindow _win;
	private Sword _sword;
	private boolean rico = false;
	private Location maze1MinStart;
	private Key _key;
	private Point1 _point1;
	private Point2 _point2;
	private Point3 _point3;
	private int points = 0;
	private int moveCounter = 0;
	private boolean trapSprung = false;
	
	//This is the constructor for this class, and sets up the game via paramaters for maze selection (int mazeSelect), debug mode (boolean p), and starting position (int startPos)
	public KeyController(int mazeSelect, boolean deBug, int startPos){		
		_maze = new Maze(mazeSelect);
		if(startPos==0) {
		_ply = new Player(_maze.getStart());
		}
		else if(startPos==2) {
			_ply = new Player(_maze.getVentTrapEnd());
		}
		_min = new Minotaur(_maze.getSpawn());
		_sword = new Sword(_maze.getSwordSpawn());
		_key = new Key(_maze.getKeySpawn());
		_point1 = new Point1(_maze.getPoint1());
		_point2 = new Point2(_maze.getPoint2());
		_point3 = new Point3(_maze.getPoint3());
		_win = new MazeWindow(_maze, _ply, _min, this, _sword, _key, _point1, _point2, _point3,deBug);

		setMazeStart();
		if(deBug) {
			_sword.setRico();
			_key.setRico();
		}
		}
	//This sets the first maze map
	private void setMazeStart() {
		maze1MinStart = _maze.getOrgSpawn();
	}
	
	//This method controls what happens when the game is won
	private void win(int a) {
		if(a ==0) {
		calculatePoints();
		JOptionPane.showMessageDialog(_win.getFrame(), "You won!" + "\n" + "Level Score: " + points +" points");
		_win.reset();
		KeyController k = new KeyController(1, false,0);

		}
		else if(a ==1) {
			calculatePoints();
			JOptionPane.showMessageDialog(_win.getFrame(), "You won!" + "\n" + "Level Score: " + points + " points");
			_win.reset();
			KeyController k = new KeyController(2, false,0);
	
			}
		else {
			calculatePoints();
			JOptionPane.showMessageDialog(_win.getFrame(), "You escaped the evil chef and have broken out!" + "\n"
			+ "Level Score: " + points+ " points");
		
			System.exit(0);

			}
	}
	
	//This method controls what happens when the game is won in debug mode
	private void winRico(int a) {
		if(a ==0) {
			calculatePoints();

			JOptionPane.showMessageDialog(_win.getFrame(), "You won!" + "\n" + "Level Score: " + points+ " points");
			_win.reset();
		KeyController k = new KeyController(1, true, 0);
		}
		else if(a ==1) {
			calculatePoints();

			JOptionPane.showMessageDialog(_win.getFrame(), "You won!" + "\n" + "Level Score: " + points+ " points");
			_win.reset();
			KeyController k = new KeyController(2, true, 0);
			}
		else {
			calculatePoints();

			JOptionPane.showMessageDialog(_win.getFrame(), "You escaped the evil chef and have broken out!" + "\n"
					+ "Level Score: " + points + " points");
							System.exit(0);

			}
	}
	
	//This method controls what happens when the game lost
	private void lose() {
		JOptionPane.showMessageDialog(_win.getFrame(), "The Chef caught you! You lost!" + "\n" + "Level Score: " + points + " points");
		System.exit(0);
	}
	
	//These are the auto generated methods for key presses- they control the moving methods via wasd key inputs
	@Override
	public void keyPressed(KeyEvent key) {
		// TODO Auto-generated method stub
		if(key.getKeyCode() == KeyEvent.VK_W) {
			if(Overseer.isValid(_maze, _ply, Direction.UP)) {
				Overseer.movePlayer(_ply, Direction.UP);
				Overseer.moveMinotaur(_maze, _min, _ply);
				_win.reDraw();
				if(Overseer.sword(_ply, _sword)&&!rico){
					if(!_sword.getIsUsed()&&!_sword.getPickedUp()) {
					setGotSword();
					}
				}
				if(Overseer.Key(_ply, _key)&&!rico){
					if(!_key.getPickedUp()) {
					setGotKey();
					}
				}
				if(Overseer.Point1(_ply, _point1)&& !_point1.getPickedUp()){
					_point1.setIsPickedUp();
					points += 1000;
					JOptionPane.showMessageDialog(null, "Plus 1000 points!");
				}
				if(Overseer.Point2(_ply, _point2)&& !_point2.getPickedUp()){
					_point2.setIsPickedUp();
					points += 3000;
					JOptionPane.showMessageDialog(null, "Plus 3000 points!");

				}
				if(Overseer.Point3(_ply, _point3)&& !_point3.getPickedUp()){
					_point3.setIsPickedUp();
					points += 5000;
					JOptionPane.showMessageDialog(null, "Plus 5000 points!");
				}
				if(Overseer.jumpTrap(_ply, _maze)&&!trapSprung) {
					Overseer.movePlayer(_ply, Direction.LEFT);
					Overseer.movePlayer(_ply, Direction.LEFT);
					Overseer.moveMinotaur(_maze, _min, _ply);
					trapSprung = true;
					JOptionPane.showMessageDialog(null, "Burger Boy slips on the floor backwards, allowing for Mr.Chef to get closer!");

				}
				if(Overseer.ventTrap(_ply, _maze)) {
					fall();
					_win.reset();
					KeyController k = new KeyController(_maze.getTracker()-1, _sword.getRico(), 2);

				}
				if(Overseer.pVE(_ply, _min)) {
					if(_sword.getRico()) {
						stopChef();
					}
					if(((!_sword.getPickedUp()&&!rico) || (_sword.getIsUsed()&& !rico))&& !rico) {
						if(!_sword.getRico()){ lose();} System.out.println("Failed");
						
					}
					else if(!rico){
						stopChef();
						_sword.setUsed();

					}
					else {
						stopChef();
					}
				}
				if(Overseer.completed(_ply, _maze)) {
					if((_key.getPickedUp())) {
					win(_maze.getTracker());
					}
					if(rico) {
						winRico(_maze.getTracker());
					}
					else {
						JOptionPane.showMessageDialog(null, "You must first find Mr. Chef's keys to escape!");
					}
				}
				
			}
			moveCounter++;
		}
		else if(key.getKeyCode() == KeyEvent.VK_A) {
			if(Overseer.isValid(_maze, _ply, Direction.LEFT)) {
				Overseer.movePlayer(_ply, Direction.LEFT);
				Overseer.moveMinotaur(_maze, _min, _ply);
				_win.reDraw();
				if(Overseer.sword(_ply, _sword)&&!rico){
					if(!_sword.getIsUsed()&&!_sword.getPickedUp()) {
					setGotSword();
					}
				}
				if(Overseer.Key(_ply, _key)&&!rico){
					if(!_key.getPickedUp()) {
					setGotKey();
					}
				}
				if(Overseer.Point1(_ply, _point1)&&!_point1.getPickedUp()){
					_point1.setIsPickedUp();
					points += 1000;
					JOptionPane.showMessageDialog(null, "Plus 1000 points!");
				}
				if(Overseer.Point2(_ply, _point2)&& !_point2.getPickedUp()){
					_point2.setIsPickedUp();
					points += 3000;
					JOptionPane.showMessageDialog(null, "Plus 3000 points!");

				}
				if(Overseer.Point3(_ply, _point3)&& !_point3.getPickedUp()){
					_point3.setIsPickedUp();
					points += 5000;
					JOptionPane.showMessageDialog(null, "Plus 5000 points!");

				}
				if(Overseer.jumpTrap(_ply, _maze)&&!trapSprung) {
					Overseer.movePlayer(_ply, Direction.LEFT);
					Overseer.movePlayer(_ply, Direction.LEFT);
					Overseer.moveMinotaur(_maze, _min, _ply);
					trapSprung = true;
					JOptionPane.showMessageDialog(null, "Burger Boy slips on the floor backwards, allowing for Mr.Chef to get closer!");

				}
				if(Overseer.ventTrap(_ply, _maze)) {
					fall();
					_win.reset();
					KeyController k = new KeyController(_maze.getTracker()-1, _sword.getRico(), 2);

				}
				if(Overseer.pVE(_ply, _min)) {
					if(_sword.getRico()) {
						stopChef();
					}
					if(((!_sword.getPickedUp()&&!rico) || (_sword.getIsUsed()&& !rico))&& !rico) {
						if(!_sword.getRico()){ lose();} System.out.println("Failed");

					}
					else if(!rico){
						stopChef();
						_sword.setUsed();

					}
					else {
						stopChef();
					}
				}
				if(Overseer.completed(_ply, _maze)) {
					if((_key.getPickedUp())) {
					win(_maze.getTracker());
					}
					if(rico) {
						winRico(_maze.getTracker());
					}
					else {
						JOptionPane.showMessageDialog(null, "You must first find Mr. Chef's keys to escape!");
					}
				}
				
			}
			moveCounter++;

		}
		else if(key.getKeyCode() == KeyEvent.VK_S) {
			if(Overseer.isValid(_maze, _ply, Direction.DOWN)) {
				Overseer.movePlayer(_ply, Direction.DOWN);
				Overseer.moveMinotaur(_maze, _min, _ply);
				_win.reDraw();
				if(Overseer.sword(_ply, _sword)&&!rico){
					if(!_sword.getIsUsed()&&!_sword.getPickedUp()) {
					setGotSword();
					}
				}
				if(Overseer.Key(_ply, _key)&&!rico){
					if(!_key.getPickedUp()) {
					setGotKey();
					}
				}
				if(Overseer.Point1(_ply, _point1)&&!_point1.getPickedUp()){
					_point1.setIsPickedUp();
					points += 1000;
					JOptionPane.showMessageDialog(null, "Plus 1000 points!");
				}
				if(Overseer.Point2(_ply, _point2)&& !_point2.getPickedUp()){
					_point2.setIsPickedUp();
					points += 3000;
					JOptionPane.showMessageDialog(null, "Plus 3000 points!");

				}
				if(Overseer.Point3(_ply, _point3)&& !_point3.getPickedUp()){
					_point3.setIsPickedUp();
					points += 5000;
					JOptionPane.showMessageDialog(null, "Plus 5000 points!");

				}
				if(Overseer.jumpTrap(_ply, _maze)&& !trapSprung) {
					Overseer.movePlayer(_ply, Direction.LEFT);
					Overseer.movePlayer(_ply, Direction.LEFT);
					Overseer.moveMinotaur(_maze, _min, _ply);
					trapSprung = true;
					JOptionPane.showMessageDialog(null, "Burger Boy slips on the floor backwards, allowing for Mr.Chef to get closer!");

				}
				if(Overseer.ventTrap(_ply, _maze)) {
					fall();
					_win.reset();
					KeyController k = new KeyController(_maze.getTracker()-1, _sword.getRico(), 2);

				}
				if(Overseer.pVE(_ply, _min)) {
					if(_sword.getRico()) {
						stopChef();
					}
					if(((!_sword.getPickedUp()&&!rico) || (_sword.getIsUsed()&& !rico))&& !rico) {
						if(!_sword.getRico()){ lose();} System.out.println("Failed");

					}
					else if(!rico){
						stopChef();
						_sword.setUsed();

					}
					else {
						stopChef();
					}
				}
				if(Overseer.completed(_ply, _maze)) {
					if((_key.getPickedUp())) {
					win(_maze.getTracker());
					}
					if(rico) {
						winRico(_maze.getTracker());
					}
					else {
						JOptionPane.showMessageDialog(null, "You must first find Mr. Chef's keys to escape!");
					}
				}
				
			}
			moveCounter++;

		}
		else if(key.getKeyCode() == KeyEvent.VK_D) {
			if(Overseer.isValid(_maze, _ply, Direction.RIGHT)) {
				Overseer.movePlayer(_ply, Direction.RIGHT);
				Overseer.moveMinotaur(_maze, _min, _ply);
				_win.reDraw();
				if(Overseer.sword(_ply, _sword)&&!rico){
					if(!_sword.getIsUsed()&&!_sword.getPickedUp()) {
					setGotSword();
					}
				}
				if(Overseer.Key(_ply, _key)&&!rico){
					if(!_key.getPickedUp()) {
					setGotKey();
					}
				}
				if(Overseer.Point1(_ply, _point1)&&!_point1.getPickedUp()){
					_point1.setIsPickedUp();
					points += 1000;
					JOptionPane.showMessageDialog(null, "Plus 1000 points!");
				}
				if(Overseer.Point2(_ply, _point2)&& !_point2.getPickedUp()){
					_point2.setIsPickedUp();
					points += 3000;
					JOptionPane.showMessageDialog(null, "Plus 3000 points!");

				}
				if(Overseer.Point3(_ply, _point3)&& !_point3.getPickedUp()){
					_point3.setIsPickedUp();
					points += 5000;
					JOptionPane.showMessageDialog(null, "Plus 5000 points!");

				}
				if(Overseer.jumpTrap(_ply, _maze)&&!trapSprung) {
					Overseer.movePlayer(_ply, Direction.LEFT);
					Overseer.movePlayer(_ply, Direction.LEFT);
					Overseer.moveMinotaur(_maze, _min, _ply);
					trapSprung = true;
					JOptionPane.showMessageDialog(null, "Burger Boy slips on the floor backwards, allowing for Mr.Chef to get closer!");

				}
				if(Overseer.ventTrap(_ply, _maze)) {
					fall();
					_win.reset();
					KeyController k = new KeyController(_maze.getTracker()-1, _sword.getRico(), 2);

				}
				if(Overseer.pVE(_ply, _min)) {
					if(_sword.getRico()) {
						stopChef();
					}
					if(((!_sword.getPickedUp()&&!rico) || (_sword.getIsUsed()&& !rico))&& !rico) {
						System.out.println("Failed"); if(!_sword.getRico()){ lose();}
						System.out.println("Failed");

					}
					else if(!rico){
						stopChef();
						_sword.setUsed();

					}
					else {
						stopChef();
					}
				}
				if(Overseer.completed(_ply, _maze)) {
					if((_key.getPickedUp())) {
					win(_maze.getTracker());
					}
					if(rico) {
						winRico(_maze.getTracker());
					}
					else {
						JOptionPane.showMessageDialog(null, "You must first find Mr. Chef's keys to escape!");
					}
				}
				
			}
			moveCounter++;

		}	
		else if(key.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}
	//This method gives the player the sword (spatula)
	public void setGotSword() {
		JOptionPane.showMessageDialog(null, "You have gotten the legendary spatula! With this, you can slow down Mr. Chef!");
		_sword.setIsPickedUp();
	}
	
	//This method gives the player the key.
	public void setGotKey() {
		JOptionPane.showMessageDialog(null, "You have found Mr. Chef's key! Now you can exit through the door!");
		_key.setIsPickedUp();
	}
	
	//This method displays a message if the player falls
	public void fall() {
		JOptionPane.showMessageDialog(null, "Oh no! You fell through a hidden vent down to the previous stage!");
	}
	@Override
	
	//Auto-generated key method
	public void keyReleased(KeyEvent key) {
		// TODO Auto-generated method stub
	}

	//Auto-generated key method
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	//This method handles what happens when you stop the chef, resetting to its position and increasing points.
	public void stopChef() {
		JOptionPane.showMessageDialog(null, "You use the spatula to stop the chef, setting him back to the start!");
		_min.getLoc().reset(maze1MinStart.getRow(),maze1MinStart.getCol());
		_sword.setUsed();
		points += 3000;
	}
	
	//This method calculates points at the end of the level using the amount of moves made.
	public void calculatePoints() {
		points += 10000 -(moveCounter*50);
	}

}
