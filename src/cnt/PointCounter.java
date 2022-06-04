package cnt;

//This class controls the points gained.
public class PointCounter {
	private int points1 = 0;
	private int points2 = 0;
	private int points3 =0 ;
	private int total = 0;
	
	//This is the constructor for this class
	public PointCounter() {
		
	}
	
	//This method adds points to a specific counter (one for each level), determined via the two int parameters
	public void addPoints(int a, int b) {
		if(a==1) {
			points1+=b;
		}
		else if(a==2) {
			points2+=b;
		}
		else {
			points3+=b;
		}
	}
	
	//This sums up all three point counters into the total sum
	public void sum() {total = points1 +points2 +points3;}
	public int getTotal() {return total;}
}
