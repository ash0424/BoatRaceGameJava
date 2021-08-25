package boatgame;

public class SuperBoat extends Boat {

	public SuperBoat() {
		super(); 
	}
	
	@Override
	public void forwardMotion(int motion) {
		setSpot(getSpot() + motion + 1);
	}

	@Override
	public void backwardMotion(int motion) {
		setSpot(getSpot() - motion + 1);
	}
	
	@Override
	public String boatName() {
		
		return "Super Boat"; 
	}
	
	@Override
	public String toString() {
		
		return String.format("This is a %s", boatName()); 
	}
	
}
