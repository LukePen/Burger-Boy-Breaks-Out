package view;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mod.Direction;
import mod.Key;
import mod.Maze;
import mod.Minotaur;
import mod.Player;
import mod.Point1;
import mod.Point2;
import mod.Point3;
import mod.Sword;

//This class controls the JPanel which displays the images to show the location of every object in the game
public class MazePanel {

	private JPanel _pan;
	private JLabel[][] _labs;
	private Maze _maze;
	private Player _ply;
	private Minotaur _min;
	private Sword _sword;
	private Key _key;
	private Point1 _point1;
	private Point2 _point2;
	private Point3 _point3;
	private static final int PIXELS = 34;
	private boolean isRico = false;
	
	//This is the constructor for the maze panel, taking in the different objects as parameters.
	public MazePanel(Maze m, Player p, Minotaur t, Sword s, Key k, Point1 p1, Point2 p2, Point3 p3, Boolean r) {
		_maze = m;
		_ply = p;
		_min = t;
		_sword = s; 
		_key = k;
		_point1 = p1;
		_point2 = p2;
		_point3 = p3;
		isRico = r;
		setupLabs();
		setupJPanel();
	}
	
	//This draws and returns the Jpanel
	public JPanel getPanel() {
		drawPanel();
		return _pan;
	}

	//This sets up the panel initially, using the size of the map to determine its dimensions
	private void setupJPanel() {
		int numRows = _labs.length;
		int numCols = _labs[0].length;
		_pan = new JPanel(new GridLayout(numRows, numCols));
		int rowSize = _maze.getMap().getArr().length * PIXELS;
		int colSize = _maze.getMap().getArr()[0].length * PIXELS;
		_pan.setSize(rowSize, colSize);
	}

	//This method draws the panel
	private void drawPanel() {
		_pan.removeAll();
		drawMap();
		for (JLabel[] arr : _labs) {
			for (JLabel lab : arr) {
				_pan.add(lab);
				_pan.repaint();
			}
		}
	}

	//This method sets up the JLabel array which will be displayed
	private void setupLabs() {
		int row = _maze.getMap().getArr().length;
		int col = _maze.getMap().getArr()[0].length;
		_labs = new JLabel[row][col];
	}

	//This method draws the map by accessing images for a JLabel array depending on the locations of the different objects
	private void drawMap() {

		int mRow = _min.getLoc().getRow();
		int mCol = _min.getLoc().getCol();
		int pRow = _ply.getLoc().getRow();
		int pCol = _ply.getLoc().getCol();
		int eRow = _maze.getEnd().getRow();
		int eCol = _maze.getEnd().getCol();
		int sRow = _sword.getLoc().getRow();
		int sCol = _sword.getLoc().getCol();
		int kRow = _key.getLoc().getRow();
		int kCol = _key.getLoc().getCol();
		int p1Row = _point1.getLoc().getRow();
		int p1Col = _point1.getLoc().getCol();
		int p2Row = _point2.getLoc().getRow();
		int p2Col = _point2.getLoc().getCol();
		int p3Row = _point3.getLoc().getRow();
		int p3Col = _point3.getLoc().getCol();
		int ventTrapRow = _maze.getVentTrap().getRow();
		int ventTrapCol = _maze.getVentTrap().getCol();
		int jumpTrapRow = _maze.getJumpTrap().getRow();
		int jumpTrapCol = _maze.getJumpTrap().getCol();

		boolean[][] map = _maze.getMap().getArr();
		int row = _labs.length;
		int col = _labs[0].length;

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (r == mRow && c == mCol) {
					_labs[r][c] = new JLabel(getMinDir(_min.getDirection()));
				} else if (r == pRow && c == pCol) {
					_labs[r][c] = new JLabel(getPlyDir(_ply.getDirection()));
				} else if (r == eRow && c == eCol) {
					_labs[r][c] = new JLabel(Graphics.DOOR.getImage());
				}
				else if (r == sRow && c == sCol && !_sword.getPickedUp()&&!_sword.getIsUsed()) {
						_labs[r][c] = new JLabel(Graphics.SWORD.getImage());
				}else if (r == kRow && c == kCol && !_key.getPickedUp()) {
						_labs[r][c] = new JLabel(Graphics.KEY.getImage());
				} 
				
				else if (r == ventTrapRow && c == ventTrapCol && isRico) {
				_labs[r][c] = new JLabel(Graphics.VENT.getImage());
				} 
				else if (r == jumpTrapRow && c == jumpTrapCol && isRico) {
				_labs[r][c] = new JLabel(Graphics.SLIP.getImage());
				} 
				else if (r == p1Row && c == p1Col && !_point1.getPickedUp()) {
				_labs[r][c] = new JLabel(Graphics.PICKLES.getImage());
				} 
				else if (r == p2Row && c == p2Col && !_point2.getPickedUp()) {
					_labs[r][c] = new JLabel(Graphics.TOMATOES.getImage());
				} 
				else if (r == p3Row && c == p3Col && !_point3.getPickedUp()) {
					_labs[r][c] = new JLabel(Graphics.BACON.getImage());
				} 
				else if (map[r][c]) {
					_labs[r][c] = new JLabel(Graphics.FLOOR.getImage());
				} else {
					_labs[r][c] = new JLabel(Graphics.BRICK.getImage());
				}
			}
		}
	}

	//This method returns the image for the Chef depending on its direction
	private ImageIcon getMinDir(Direction d) {
		if (d == Direction.UP) {
			return Graphics.CHEFUP.getImage();
		}
		else if (d == Direction.RIGHT) {
			return Graphics.CHEFRIGHT.getImage();
		}
		else if (d == Direction.LEFT) {
			return Graphics.CHEFLEFT.getImage();
		}
		else {
			return Graphics.CHEFDOWN.getImage();
		}
	}
	
	//This method returns the image for the Player depending on its direction
	private ImageIcon getPlyDir(Direction d) {
		if (d == Direction.UP) {
			return Graphics.BURGERUP.getImage();
		}
		else if (d == Direction.RIGHT) {
			return Graphics.BURGERRIGHT.getImage();
		}
		else if (d == Direction.LEFT) {
			return Graphics.BURGERLEFT.getImage();
		}
		else {
			return Graphics.BURGERDOWN.getImage();
		}
	}

}
