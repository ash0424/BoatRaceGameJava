package boatgame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainGame {

	private Player player1, player2;
	private ArrayList<Obstacle> obstaclelist = new ArrayList<Obstacle>();
	private Dice dice;
	private River river;
	private Score score; 
	private Winner winner;
	
	Scanner input = new Scanner(System.in);
	
	public MainGame() {
		player1 = new Player();
		player2 = new Player();
		dice = new Dice();
		river = new River();
		score = new Score();
		winner = new Winner();
		
		int NumberOfCurrents = new Random().nextInt(2 + 1) + 6;
		int NumberOfTraps = new Random().nextInt(2 + 1) + 6;
    	
    	for(int i=0; i< NumberOfCurrents; i++) 
    	{
    		Current temp = new Current();
    	
    		boolean duplicate = false;
    		for(Obstacle o: obstaclelist) 
    		{
    			for(int j = 1; j <= 3; j++)
    			{
        			if (o.getSpot() == temp.getSpot()) 
        			{
        				
        				duplicate = true;
        				break; 
        			}
        			
        			else if (o.getSpot() == (temp.getSpot() + j))
        			{
        				
        				duplicate = true; 
        				break;
        			}
        			
        			else if (o.getSpot() == (temp.getSpot() - j))
        			{
        				
        				duplicate = true;
        				break;
        			}
    			}

    			
    		}
    		if (!duplicate) 
    		{
    			
    			obstaclelist.add(temp);
    		}
    		else 
    		{
    			i--;
    		}
    	}
    	
    	
    	for(int i=0; i< NumberOfTraps; i++)
    	{
            Trap temp = new Trap();

            boolean duplicate = false;

            for (Obstacle o : obstaclelist) 
            {

            	for(int j = 0; j <= 3; j++)
            	{
                    if (o.getSpot() == temp.getSpot())
                    {
                    	
                        duplicate = true;
                        break; 
                    }
        			
        			else if (o.getSpot() == (temp.getSpot() + j))
        			{
        				
        				duplicate = true; 
        				break;
        			}
        			
        			else if (o.getSpot() == (temp.getSpot() - j))
        			{
        				
        				duplicate = true;
        				break;
        			}
            	}
            }
            if (!duplicate) 
            {
            	
            	obstaclelist.add(temp);
            }
            else 
            {
                i--;
            }
    	}  	
	}
	
	public void startMainGame() {
		
		int turnsCompleted = 0;
		boolean continueGame = true;
		
        Database database = new Database(); 
		
        database.loadDatabase(score); 
                        
        score.printTop5();
		
		boolean bool; 
        bool = true; 
        while(bool)
        {
            player1.promptName();
            player2.promptName(); 
            
            if(player2.getName().equals(player1.getName())) 
            {
            	
                System.out.println("Player 2 cannot have the same name as Player 1!\n");
                bool = true;
                
            }
            else 
            {
                bool = false;
                System.out.println("\nWelcome to the Boat Race " + player1 + " and " + player2 + "!\n");     
                
            }
        }
        
		player1.playerBoat();
		player2.playerBoat();
		
		System.out.printf("\n%s's Boat is named 'A' and %s's Boat is named 'B'\n\n\n", player1.getName(), player2.getName());
		
		int NumberOfCurrents = new Random().nextInt(2 + 1) + 6;
		int NumberOfTraps = new Random().nextInt(2 + 1) + 6;
		
		System.out.println("Obstacles in the River consist of Currents (C) and Traps (#)\n");
		System.out.println("Number of Currents: " + NumberOfCurrents);
		System.out.println("Number of Traps: " + NumberOfTraps);
		
        System.out.println("\nObstacle Positions in the River:\n");
        river.Display(obstaclelist);   
   
        
        while(continueGame) 
        {
            
        	System.out.printf("\n\n%s's turn\n", player1.getName()); 
        	System.out.printf("\n%s's current position is %d\n", player1.getName(), player1.getSpot());
        	System.out.println(""); 
            dice.throwDice();
            System.out.printf("\n%s's dice number is: %d\n", player1.getName(), dice.getDiceNum()); 
          
            
            if(player1.getSpot() > 7)
            {
            	
            	
        		for(Obstacle a: obstaclelist)
            	{
                    if (player1.getSpot() == a.getSpot()) 
                    {
                        if (a instanceof Current) 
                        {
                            player1.forwardMove(a.getStrength());
                            
                            System.out.printf("\nYES! You hit a current that brings you %d steps forward!\n", a.getStrength());
                            System.out.println(""); 
                           
                            if (player1.getPlayerBoat().equals("Super Boat")) {
                            	player1.forwardMove(1);
                            }
                                                                               
                        }
                        
                        else if (a instanceof Trap) 
                        {
                        	player1.backwardMove(a.getStrength());
                            
                            System.out.printf("\nOH NO! You hit a trap that brings you %d steps backwards!\n", a.getStrength());
                            System.out.println(""); 
                            
                            if (player1.getPlayerBoat().equals("Super Boat")) {
                            	player1.backwardMove(1);
                            }
                                                   
                        }
                    }
            	}
            	
            }
            
            player1.forwardMove(dice.getDiceNum());
            

        
            System.out.println("\nPlayer and Obstacle Positions in the River:\n "); 
            river.Display(obstaclelist, player1.getSpot(), player2.getSpot());
            System.out.println(""); 
            
            if(player1.getSpot() < 90) 
            {
            	
            	System.out.printf("\n%s's new position is %d\n", player1.getName(), player1.getSpot());
            	
            }
            
            else if(player1.getSpot() < 100 && player1.getSpot() >= 90) 
            {
            	System.out.printf("\n%s's new position is %d\n", player1.getName(), player1.getSpot());
            	System.out.printf("\n%s IS GOING TO WIN SOON!\n", player1.getName());
            }
            
            else if (player1.getSpot() >= 100) 
            {
            	
                
                System.out.printf("\nCongratulations! %s has won the boat race!\n", player1.getName());
                
                winner.setWinner(player1.getName());
                System.out.println("");
 
                continueGame = false;
                break;
            }
            
            System.out.print("");
            
            System.out.println("_______________________________________________________________________________________________________________________________________________________________________________________________________");


            System.out.printf("\n%s's turn\n", player2.getName()); 
            System.out.printf("\n%s's current position is %d\n", player2.getName(), player2.getSpot());
            System.out.println(""); 
            dice.throwDice();
            System.out.printf("\n%s's dice number is: %d\n", player2.getName(), dice.getDiceNum()); 
          
            
            if(player2.getSpot() > 7)
            {
            	
       
        		for(Obstacle a: obstaclelist)
            	{
                    if (player2.getSpot() == a.getSpot()) 
                    {
                        if (a instanceof Current) 
                        {
                            player2.forwardMove(a.getStrength());
                            
                            System.out.printf("\nYES! You hit a current that brings you %d steps forward!\n", a.getStrength());
                            System.out.println("");
                            
                            if (player2.getPlayerBoat().equals("Super Boat")) {
                            	player2.forwardMove(1);
                            }
                                                                                  
                        }
                        
                        else if (a instanceof Trap) 
                        {
                            player2.backwardMove(a.getStrength());
                           
                            System.out.printf("\nOH NO! You hit a trap that brings you %d steps backwards!\n", a.getStrength());
                            System.out.println(""); 
                           
                            if (player2.getPlayerBoat().equals("Super Boat")) {
                            	player2.backwardMove(1);
                            }
                                                                             
                        }                          
                     }
                 }
        		
            }
            	
            
            player2.forwardMove(dice.getDiceNum());
          
            
            System.out.println("\nPlayer and Obstacle Positions in the River:\n "); 
            river.Display(obstaclelist, player2.getSpot(), player2.getSpot());
            System.out.println(""); 
         

            if(player2.getSpot() < 90) 
            {
            	
            	System.out.printf("\n%s's new position is %d\n", player2.getName(), player2.getSpot());
            	System.out.println(""); 
            }
            
            else if(player2.getSpot() < 100 && player2.getSpot() >= 90) 
            {
            	System.out.printf("\n%s's new position is %d\n", player2.getName(), player2.getSpot());
            	System.out.printf("\n%s IS GOING TO WIN SOON!\n", player2.getName());
            }
            
            else if (player2.getSpot() >= 100) 
            {
            	
                
                System.out.printf("\nCongratulations! %s has won the boat race!\n", player2.getName());
               
                winner.setWinner(player2.getName());
                System.out.println(""); 

                continueGame = false;
                break;
            }
            
            
            turnsCompleted++; 
            
            System.out.println("_______________________________________________________________________________________________________________________________________________________________________________________________________");

        }  
          
        System.out.printf("\nIt took %s %d turns to win!\n", winner.getWinner(), turnsCompleted);
        
        System.out.println("New scoreboard: "); 
        score.setTop5(winner.getWinner(), turnsCompleted);
        score.printTop5();
        
    	boolean bool1 = true;
    	while(bool1)
    	{
    		System.out.print("\nEnter 's' to restart game or 'e' to end: "); 
    		String answer;
    		answer = input.nextLine(); 
    		if(answer.equals("s") || answer.equals("S"))
    		{
    			player1.setSpot(1);
    			player2.setSpot(1);
    			database.storeDatabase(score);
    		
    			startMainGame(); 
    			
    		}
    		else if(answer.equals("e") || answer.equals("E"))
    		{
    			
    			System.out.println("\nThanks for playing!"); 
    			
    			database.storeDatabase(score);
    			bool1 = false; 
    			System.exit(0);
    		}
    		else
    		{
    			System.out.println("Invalid input!"); 
    			bool1 = true; 
    		}
    		
    		
    	}
        
	}

    
}


















