package boatgame;

public class Object {

	protected int spot;
	
	public Object() {
		spot = 1;
	}
	
	public Object(int a) {
		spot = a;
	}

	public int getSpot() {
		return spot;
	}

	public void setSpot(int spot) {
		this.spot = spot;
	}
	
	public void setSpot(int spot, int player) {
		this.spot = spot;
	}
	
}
