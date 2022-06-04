package mod;
//These Enums control the layout of the levels through booleans, with true representing walkable and false representing walls.
public enum Map {

		//First level
	Easy(new boolean[][] { 
			{ true, false, false, false, false, false, false, false, false, true },
			{ true, false, false, false, false, false, false, false, false, true },
			{ true,  true,  true,  true, false, false, false, false, false, true },
			{ false, false, false, true, false, false, false, false, false, true },
			{ false, false, false, true, false, false, false, false, false, true },
			{ false, false, false, true, false, false, false, false, false, true },
			{ false, true, 	true,  true,  true,  true,  true,  true,  true,  true },
			{ false, true, false, false, false, false, false, false, false, false },
			{ false, true, false, false, false, false, false, false, false, false },
			{ false, true, false, false, false, false, false, false, false, false } 
			}), 
	//Second Level
	Medium(new boolean[][] { 
		{false,false,false,false,true,false,false,false,false,false },
		{false,true,false,true,true,true,true,false,true,false},
		{false,true,true,true,false,false,true,false,true,false},
		{false,false,false,false,false,true,true,false,true,false  },
		{false,true,true,true,true,true,false,false,true,false  },
		{false,true,true,true,false,true,true,true,true,false  },
		{false,true,false,false,false,true,false,false,false,false	        },
		{false,true,false,true,true,true,true,true,true,false},
		{false,true,true,true,false,true,true,true,true,false},
		{false,false,false,false,false,false,false,false,false,false} 
		}),
	//Third Level
	Hard(new boolean[][] { 
		{false,true,true,false,false,false,false,false,true,false,false,false,false,true,false,false,false,false,true,true,true,true,false,true,false},
		{false,false,true,true,true,true,true,true,true,false,false,false,false,true,true,false,false,false,false,false,false,true,false,true,false},
		{false,false,true,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,true,false,true,false},
		{true,true,true,true,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,true,false,true,false},
		{false,false,false,true,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,true,false,true,false},
		{false,false,false,true,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,true,false,true,false},
		{false,false,false,true,true,true,true,true,true,true,true,false,true,true,true,true,true,true,false,false,false,true,false,true,false},
		{false,false,false,false,false,false,true,false,true,false,true,false,true,false,false,false,false,true,false,false,false,true,false,true,false},
		{false,false,false,false,false,false,true,false,true,false,true,true,true,false,false,false,false,true,true,true,false,true,false,true,false},
		{false,false,false,false,false,false,true,true,true,false,false,false,true,false,false,false,false,true,false,true,false,true,false,true,false},
		{false,false,false,false,false,false,true,false,true,true,false,false,true,false,false,true,true,true,false,true,false,true,false,true,false},
		{true,true,true,true,true,true,true,false,false,true,true,true,true,false,false,false,false,false,false,true,false,true,false,true,false},
		{false,false,false,true,false,false,false,false,false,true,false,false,false,false,false,false,true,false,false,true,false,true,false,true,false},
		{false,false,false,true,false,false,false,false,false,true,false,false,false,false,false,false,true,false,false,true,true,true,false,true,false},
		{false,true,true,true,false,false,false,false,false,true,true,true,true,true,true,true,true,true,true,true,false,false,false,true,false},
		{false,true,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,true,true,false},
		{false,true,false,false,false,true,true,true,true,true,false,false,false,false,false,false,false,false,true,false,false,false,true,false,false},
		{false,true,false,false,false,true,false,false,false,false,false,true,true,true,true,true,true,true,true,false,false,false,true,false,false},
		{false,true,false,false,false,true,true,true,true,true,true,true,false,true,false,false,false,false,false,false,false,false,true,false,false},
		{false,true,false,false,false,false,false,false,true,false,false,false,false,true,false,false,false,false,false,false,false,false,true,false,false},
		{false,true,false,false,false,false,false,false,true,false,false,false,false,true,true,true,true,false,false,false,false,false,true,false,false},
		{false,true,false,false,false,false,false,false,true,false,false,false,false,false,false,false,true,true,true,false,false,false,true,false,false},
		{false,true,true,true,true,true,true,true,true,false,false,false,false,false,false,false,false,false,true,false,false,false,true,false,false},
		{false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,true,true,true,true,false,false}});



	
	private boolean[][] _map;

	public boolean[][] getArr() {
		return _map;
	}
//This method changes which map is being used.
	private Map(boolean[][] map) {
		_map = map;
	}
}
