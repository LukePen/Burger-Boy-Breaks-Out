package mod;


//This class controls the maze and the objects inside it
public class Maze {

	private Map _map;
	private Location _start, _end, _spawn, _swordSpawn, _orgSpawn, _key, 
	_point1, _point2, _point3, _jumpTrap, ventTrap, ventTrapEnd;
	private int tracker;

	public Map getMap() {
		return _map;
	}
	public Location getJumpTrap() {
		return _jumpTrap;
	}
	
	public Location getVentTrap() {
		return ventTrap;
	}
	public Location getVentTrapEnd() {
		return ventTrapEnd;
	}
	public int getTracker() {
		return tracker;
	}
	public Location getStart() {
		return _start;
	}
	public Location getPoint1() {
		return _point1;
	}
	public Location getPoint2() {
		return _point2;
	}
	public Location getPoint3() {
		return _point3;
	}
	
	public Location getSwordSpawn() {
		return _swordSpawn;
	}

	public Location getKeySpawn() {
		return _key;
	}

	public Location getEnd() {
		return _end;
	}

	public Location getSpawn() {
		return _spawn;
	}
	public Location getOrgSpawn() {
		return _orgSpawn;
	}
	
	//This is the constructor for the maze, using a parameter to determine which map and starting locations are used.
	public Maze(int x) {
		if (x == 0) {
			_map = Map.Easy;
			_start = new Location(9, 1);
			_end = new Location(0, 9);
			_spawn = new Location(0, 0);
			_swordSpawn = new Location(7,1);
			_orgSpawn = new Location(0, 0);
			_key = new Location(6,1);
			_point1 = new Location(5,3);
			_point2 = new Location(40,40);
			_point3 = new Location(40,40);
			_jumpTrap = new Location(6,8);
			ventTrap = new Location(20,30);
			ventTrapEnd = new Location(5,2);

			tracker = 0;
			

		} else if(x==1){
			_map = Map.Medium;
			_start = new Location(7, 3);
			_end = new Location(0, 4);
			_spawn = new Location(7, 7);
			_swordSpawn = new Location(1,4);
			_orgSpawn = new Location(7, 7);
			_key = new Location(1,8);
			_point1 = new Location(1,1);
			_point2 = new Location(5,3);
			_point3 = new Location(40,40);
			_jumpTrap = new Location(5,7);
			ventTrap = new Location(5,2);
			ventTrapEnd = new Location(7,5);
			tracker = 1;

		}
		else {
			_map = Map.Hard;
			_start = new Location(11, 9);
			_end = new Location(0, 18);
			_spawn = new Location(0, 0);
			_swordSpawn = new Location(6,13);
			_orgSpawn = new Location(0, 0);
			_key = new Location(18,9);
			_point1 = new Location(1,1);
			_point2 = new Location(5,3);
			_point3 = new Location(10,15);
			_jumpTrap = new Location(6,6);
			ventTrap = new Location(14,14);
			tracker = 2;

		}
	}

}
