package view;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cnt.KeyController;
import mod.Key;
import mod.Maze;
import mod.Minotaur;
import mod.Player;
import mod.Point1;
import mod.Point2;
import mod.Point3;
import mod.Sword;

//This class handles the creation and updating of the JFrame which displays the game
public class MazeWindow {
	
	private JFrame _frame;
	private MazePanel _pan;
	private Maze _maze;
	private Player _ply;
	private Minotaur _min;
	private KeyController _kcnt;
	private Sword _sword;
	private Key _key;
	private Point1 _point1;
	private Point2 _point2;
	private Point3 _point3;
	private static final int X_POS = 700;
	private static final int Y_POS = 300;
	private boolean isRico = false;
	
	public JFrame getFrame() { return _frame; }
	
	//This is the constructor, taking in the different objects as parameters
	public MazeWindow(Maze m, Player p, Minotaur t, KeyController k, Sword s, Key kk , Point1 pp, Point2 pp2, Point3 pp3, Boolean r){

		_maze = m;
		_ply = p;
		_min = t;
		_sword = s;
		_key = kk;
		_point1 = pp;
		_point2 = pp2;
		_point3 = pp3;
		isRico = r;
		_pan = new MazePanel(_maze, _ply, _min, _sword, _key, _point1, _point2, _point3, isRico);
		_kcnt = k;
		
		setupFrame();
	}
	
	//This method resets the JFrame by disposing it
	public void reset() {
		_frame.dispose();
	}
	
	//This method sets up the frame initially, using the JFrame methods to prepare the frame for its desired options
	private void setupFrame(){
		JPanel pan = _pan.getPanel();
		
		_frame = new JFrame("Burger Boy Breaks Out! by Eden & Co.");
		_frame.setLayout(new GridLayout(1,1));
		_frame.setLocation(X_POS, Y_POS);
		_frame.setSize(pan.getWidth(), pan.getHeight());
		_frame.addKeyListener(_kcnt);
		_frame.add(pan);
		_frame.setResizable(true);
		_frame.setAlwaysOnTop(false);
		
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setVisible(true);
	}
	
	//This method removes the Jpanel, then adds it, redrawing whats on screen
	public void reDraw() {
		_frame.remove(_pan.getPanel());
		_frame.add(_pan.getPanel());
		_frame.repaint();
		_frame.setVisible(true);
	
	}
}
