package boatgame;

public class Trap extends Obstacle {
	
	public Trap() {
		super();
	}

	@Override
	public String ObstacleForm() {
		return "Trap";
	}

	@Override
	public String toString() {
		return String.format("You hit a %s", ObstacleForm());
	}
	
}
