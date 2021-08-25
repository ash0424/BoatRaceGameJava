package boatgame;

import java.util.*; 


public class Score {
	    
	    private String firstPlace = "No place yet"; 
	    private String secondPlace = " No place yet"; 
	    private String thirdPlace = "No place yet";
	    private String fourthPlace = "No place yet"; 
	    private String fifthPlace = "No place yet"; 

	    private String firstRoundComplete = "-";
	    private String secondRoundComplete = "-"; 
	    private String thirdRoundComplete = "-"; 
	    private String fourthRoundComplete = "-";  
		private String fifthRoundComplete = "-";

	    
	    int[] roundsComplete = 
	        {0, 0, 0, 0, 0};
	    
	    String[][] topfive = 
	        {
	        	
	            {firstPlace, "1", firstRoundComplete},
	            {secondPlace, "2", secondRoundComplete},
	            {thirdPlace, "3", thirdRoundComplete},
	            {fourthPlace, "4", fourthRoundComplete},
	            {fifthPlace, "5", fifthRoundComplete}

			};
			
		ArrayList <String> names = new ArrayList <String>(); 
		ArrayList <Integer> scores = new ArrayList <Integer>(); 
	   
	    public Score() {


	    }
	    
	    public void printTop5() {
	   
	    	System.out.println("_________________________Scoreboard______________________________"); 
	    	
	    	for (int i = 0; i < topfive.length; i++)
	    	{
	    		System.out.printf("Player's name: %s\n", topfive[i][0]);
	    		System.out.printf("Placing: %s\n", topfive[i][1]);
	    		System.out.printf("Rounds completed: %s\n", topfive[i][2]);
	    		System.out.println(""); 
	    	}
	    	
	    	System.out.println("_________________________________________________________________");
	    	
	    	System.out.println("Names array: " + names); 
	    	System.out.println("Scores array: " + scores); 
	    	
	    }

	    public void setTop5(String player, int roundsDone){

			System.out.println("Updating the scoreboard..."); 
			
			for (int i = 0; i < topfive.length; i++)
	    	{
				if(topfive[i][0].equals("Spot not yet claimed"))
				{
					
				}
				else
				{
					names.add(topfive[i][0]); 
					int record = Integer.parseInt(topfive[i][2]);
					scores.add(record); 
				}
	    	}	
			
			names.add(player); 
			scores.add(roundsDone); 
			
			
			
			String[][] pair;
			pair = new String[scores.size()][2]; 
			
			for (int i = 0; i < scores.size(); i++)
			{
				
				String recordsStr = Integer.toString(scores.get(i));
				pair[i][0] = names.get(i);
				pair[i][1] = recordsStr; 
				
					
			}
			
			
			Collections.sort(scores); 
			
			System.out.println("Scores array in ascending: " + scores); 
			
			String temp; 
			String temp2; 
			
			for (int i = 0; i < pair.length; i++) 
			{
				for (int j = i + 1; j < (pair.length); j++) 
				{
					int record = Integer.parseInt(pair[i][1]);  
					int record2 = Integer.parseInt(pair[j][1]);  
					
					if (record > record2) 
					{
						temp = pair[i][1];
						pair[i][1] = pair[j][1];
						pair[j][1] = temp;
						
						temp2 = pair[i][0];
						pair[i][0] = pair[j][0];
						pair[j][0] = temp2;
					}
				}
			}
			
			for (int i = 0; i < scores.size(); i++)
			{
				
				System.out.printf("Pair's %d element: %s %s\n", i, pair[i][0], pair[i][1]);
				
			}
			
			if (scores.size() > 5)
			{
				for (int i = 0; i < scores.size(); i++)
				{
					int record = Integer.parseInt(pair[i][1]);
					
					if(scores.get(scores.size() - 1) == record)
					{
						names.remove(pair[i][0]); 
					}
				}
				
				scores.remove(scores.size() - 1); 
			}
			
		
			String[][] pairAsc;
			pairAsc = new String[scores.size()][2]; 
			
			for (int i = 0; i < scores.size(); i++)
			{
				for (int j = 0; j < pair.length/2; j++)
				{
					int record = Integer.parseInt(pair[j][1]);
					if (record == scores.get(i))
					{
						pairAsc[i][0] = pair[j][0]; 
						pairAsc[i][1] = pair[j][1]; 
					}
				}
			}
			
			for (int i = 0; i < scores.size(); i++)
			{
				
				System.out.printf("Pair's %d element: %s %s\n", i, pair[i][0], pair[i][1]);
				
			}
			

			
			for (int i = 0; i < names.size(); i++)
			{
				
				String name = "someName"; 
				String tempName = "someTempName"; 
				
				for(int j = 0; j < scores.size(); j++)
				{
					String recordsStr = Integer.toString(scores.get(j));
					name = pair[i][0]; 
					
					if (pair[i][1].equals(recordsStr) && (!tempName.equals(name)))
					{
						if(j != (scores.size() - 1))
						{
							if (scores.get(j).equals(scores.get(j+1)))
							{
								tempName = name;
								System.out.println(tempName); 
								System.out.printf("Pair's score: %s\n", pair[i][1]); 
								System.out.printf("Scores' score: %s\n", scores.get(j)); 
								names.set(j+1, pair[i][0]); 
								System.out.printf("Names' name: %s\n", names.get(j));
								System.out.println("Position " + j + " replaced"); 
							}
							else
							{
								tempName = name;
								System.out.println(tempName); 
								System.out.printf("Pair's score: %s\n", pair[i][1]); 
								System.out.printf("Scores' score: %s\n", scores.get(j)); 
								names.set(j, pair[i][0]); 
								System.out.printf("Names' name: %s\n", names.get(j));
								System.out.println("Position " + j + " replaced"); 
							}
						}

						else
						{
							tempName = name;
							System.out.println(tempName); 
							System.out.printf("Pair's score: %s\n", pair[i][1]); 
							System.out.printf("Scores' score: %s\n", scores.get(j)); 
							names.set(j, pair[i][0]); 
							System.out.printf("Names' name: %s\n", names.get(j));
							System.out.println("Position " + j + " replaced"); 
						}
						

					}
					else
					{
						System.out.println("Did not loop " + j); 
					}
					
				}
				System.out.println("Loop: " + i + " times"); 
		
			}
			
			System.out.println("Names array top 5 players: " + names); 
			System.out.println("Scores array top 5 elements: " + scores); 
			
			

	    	for (int i = 0; i < topfive.length; i++)
	    	{
	    		if(topfive[i][2].equals("-"))
	    		{
	    			System.out.println("Checking for empty placing..."); 
	    			topfive[i][2] = "100"; 
					
				}
			
			}

	    	for (int i = 0; i < scores.size(); i++) 
			{
				String recordsStr = Integer.toString(scores.get(i));
				topfive[i][2] = recordsStr; 
			}

			for (int i = 0; i < names.size(); i++)
			{
				
				topfive[i][0] = names.get(i); 
					
						
			}

			for (int i = 0; i < topfive.length; i++)
	    	{
	    		if(topfive[i][2].equals("100"))
	    		{
	    			System.out.println("Checking for empty placing..."); 
	    			topfive[i][2] = "-"; 
					
				}
				
	    		
			}
			
			pair = null; 
	    	names.clear();
	    	scores.clear();
	    }
	   

	    public String getTop5(int i, int j){
	        
	        return topfive[i][j]; 
	    }
	    
	    public void fillTop5(int i, int j, String input) {
	    	
	    	topfive[i][j] = input; 

	    }

	}    
