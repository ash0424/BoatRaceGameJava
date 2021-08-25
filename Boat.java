package boatgame;

public class Boat extends Object {
 
	private String boatName;
	
	public Boat() {
		super();
	}
	
	public void forwardMotion(int motion) {
		setSpot(getSpot() + motion);
	}
	
	public void backwardMotion(int motion) {
		setSpot(getSpot() - motion);
	}
	
	public String getBoatName() {
		return boatName;
	}

	public void setBoatName(String boatName) {
		this.boatName = boatName;
	}
	
	public String boatName() {		
		return "boat"; 
	}

	@Override
	public String toString() {
		return String.format("This is a %s", boatName()); 
	}
	
}
