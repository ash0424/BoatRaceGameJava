package boatgame;

import java.util.Scanner;

public class Player extends Object {

	private int turns;
	private int score;
	private String name;
	private Boat b;
	private int motion;
	
	Scanner input = new Scanner(System.in);
	
	public Player() {
		super();
	}

	public int getTurns() {
		return turns;
	}

	public void setTurns(int turns) {
		this.turns = turns;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void forwardMove(int move) {
		motion = move;
		b.forwardMotion(move);
		setSpot(b.getSpot());
	}
	
	public void backwardMove(int move) {
		motion = move;
		b.backwardMotion(move);
		setSpot(b.getSpot());
	}
	
	public int getMove() {
		return motion;
	}

	public Boolean promptName() {
        	
		boolean bool;
		bool = true;
		while (bool) 
		{
		
        	System.out.print("Enter your Name: ");
    		name = input.nextLine();
    		setName(name);
    		
    		if (name.isBlank()) {
    			System.out.println("Name cannot be blank.");
    		}
    		
    		else {
    			setName(name);
    			bool = false;
    		}
    		
		}
		return bool; 
        }
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void playerBoat() {
		
		System.out.printf("\n%s please choose a boat:\n", getName()); 
		System.out.print("\nSuper Boat Moves One Additional Step Forward and Backward from the Dice Number. \nJet Boat Moves According to the Dice Number.\n");
        System.out.println("\nEnter '1' for Super Boat \nEnter '2' for Jet Boat\n");
        int choose;
        
        choose = input.nextInt(); 
        
        boolean bool;
        bool = true;
     
        while(bool) 
        {
 
        	if(choose == 1)  
        			
        	{
				b = new Boat();
				b.setBoatName("Super Boat");
        		bool = false; 
        	
        	}
        	else if(choose == 2)
        	{
				b = new Boat(); 
				b.setBoatName("Jet Boat");
        		bool = false; 
        		
        	}
        	else
        	{
        		System.out.println("\nInvalid input. Enter either '1' or '2'.\n"); 
        		System.out.printf("\n%s please choose a boat:\n", getName()); 
        		System.out.println("\nEnter '1' for Super Boat \nEnter '2' for Jet Boat\n");
                choose = 0;
            	choose = input.nextInt(); 
                bool = true; 
        		
        	}
        	
        	
		}
		
    	
       	choose = 0;
       	
	}
	
	public String getPlayerBoat() {
		
		return b.boatName(); 
	}
	
	@Override
	public String toString() {
		return String.format("%s", name);
	}
	
}
