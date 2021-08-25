package boatgame;

public class Current extends Obstacle {
	
	public Current() {
		super();
	}
	
	@Override
	public String ObstacleForm() {
		return "Current";
	}

	@Override
	public String toString() {
		return String.format("You hit a %s", ObstacleForm());
	}
	
}
