package boatgame;

public class JetBoat extends Boat {

	
	public JetBoat() {
		super(); 
	}
	
	@Override
	public String boatName() {
		
		return "Jet Boat"; 
	}
	
	@Override
	public String toString() {
		
		return String.format("This is a %s", boatName()); 
	}
	
}

