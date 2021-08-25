package boatgame;

import java.util.ArrayList;

public class River {

	private char[] display = {
				'~','~','~','~','~','~','~','~','~','~',
				'~','~','~','~','~','~','~','~','~','~',
				'~','~','~','~','~','~','~','~','~','~',
				'~','~','~','~','~','~','~','~','~','~',
				'~','~','~','~','~','~','~','~','~','~',
				'~','~','~','~','~','~','~','~','~','~',
				'~','~','~','~','~','~','~','~','~','~',
				'~','~','~','~','~','~','~','~','~','~',
				'~','~','~','~','~','~','~','~','~','~',
				'~','~','~','~','~','~','~','~','~','~',
	};
	
	public River() {
		
	}
	
	public River(char[] display) {
		this.display = display;
	}
	
	public void Display(ArrayList<Obstacle> obslist, int spot1, int spot2) {
		for (Obstacle a: obslist) {
			if (a instanceof Current) {
				display[a.getSpot()] = 'C';
			}
			else if (a instanceof Trap) {
				display[a.getSpot()] = '#';
			}
		}
	
		if (spot1 <= 100 && spot2 <= 100) {
			display[spot1 - 1] = 'A';
			display[spot2 - 1] = 'B';
			printdisplay();
			display[spot1 - 1] = '~';
			display[spot2 - 1] = '~';	
		}
		else {
			if (spot1 > 100) {
				display[99] = 'A';
			}
			else if (spot2 > 100) {
				display[99] = 'B';
			}
		}
	}
	
	public void Display(ArrayList<Obstacle> obslist) {
       	for(Obstacle a: obslist) {
       		if (a instanceof Current) {
       			display[a.getSpot()] = 'C';
       		}
       		else if (a instanceof Trap) {
       			display[a.getSpot()] = '#';
       		}
     	}
  
       printdisplay();
    }

	private void printdisplay() {
		for (char a: display) {
			System.out.print(a + " ");
		}
	}
	
}












