package boatgame;

import java.util.Random;

public class Obstacle extends Object {

	private int energy;
	
	public Obstacle(int point, int strength) {
		super(point);
		energy = strength;
	}
	
	public Obstacle() {
		
		Random x = new Random();
		spot = 5 + x.nextInt(95);
		energy = 1 + x.nextInt(5);			
	}
	
	public int changeStrength() {
		Random x = new Random();
		return energy = 1 + x.nextInt(7); 
	}
	
	public int getStrength() {
		return energy;
	}

	public void setStrength(int energy) {
		this.energy = energy;
	}
	
	public String ObstacleForm() {
		return "Obstacle";
	}
	
	public String toString() {
		return String.format("You hit a %s,", ObstacleForm());
	}	
	
}
