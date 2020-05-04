package idontcare;

import java.util.Scanner;

public class FloorNav {
	
	Scanner input = new Scanner(System.in);
	boolean roomBoolean = false;
	boolean roomCheck1 = false;
	boolean roomCheck2 = false;
	boolean roomCheck3 = false;
    int answer;
    
    // If the user makes a mistake in room 2
    public void DaggerInteraction() {
    	System.out.println("It looks like you couldn't make a decision");
    	System.out.println("Do you want to pick up the dagger?\n");
        System.out.println("1: Yes");
        System.out.println("2: No\n");
        System.out.println("------------------------------------------------------------------\n");
        answer = input.nextInt();
        
        // Option 1 for Dagger
        if (answer == 1) {
        	System.out.println("You place the dagger into your backpack");
        	roomCheck2 = true;
        	
        	// All rooms have been fully interacted with sent to Floor2 Interaction
        	if (roomCheck1 && roomCheck2 && roomCheck3 == true) {
           		System.out.println("It looks like every room on this floor has been check let's move on.");
           		Floor2();
           	}
           	
        	// All rooms haven't been checked send them back until they do
           	else {
           		Floor3(); 
           	} 
        }
        
        // Option 2 for Dagger
        else if (answer == 2) {
        	System.out.println("You decided that the dagger is useless garbage and yeet it out a window");
        	roomCheck2 = true;
        	
        	if (roomCheck1 && roomCheck2 && roomCheck3 == true) {
        		System.out.println("It looks like every room on this floor has been check let's move on.");
        		Floor2();
        	}
       	
           	else {
           		Floor3(); 
           	} 
        }
        
        // Make sure the user picks option 1 or 2
        else {
        	DaggerInteraction();
        }
    }

    // Start of Floor3 Interaction
    public void Floor3() {

	    System.out.println("\n------------------------------------------------------------------\n");
	    System.out.println("You are at the top floor and begin to search around");
	    System.out.println("You come across 3 rooms");
	    System.out.println("");
	    System.out.println("What do you want to do?");
	    System.out.println("");
        System.out.println("1: Enter room 1. It's mostly untouched");
        System.out.println("2: Enter room 2. This place is a shithole");
        System.out.println("3: Room 3 is barricaded and there's no way in");
        System.out.println("\n------------------------------------------------------------------\n");

        answer = input.nextInt();
        
        // Room 1
        if (answer == 1 && roomCheck1 == false) {
        	System.out.println("You find scattered blood stains on the walls and floor. There isn't anything of interest in here");
        	roomCheck1 = true;
        	
        	// All rooms have been fully interacted with sent to Floor2 Interaction
        	if (roomCheck1 && roomCheck2 && roomCheck3 == true) {
        		 System.out.println("It looks like every room on this floor has been check let's move on.");
        		 Floor2();
        	}
        	
        	// All rooms haven't been checked send them back until they do
        	else {
        		Floor3(); 
        	} 
        }
        
        else if (answer == 1 && roomCheck1 == true) {
        	System.out.println("You shouldn't go back in there it reeks.");
            Floor3();  
        }

        // Room 2
        else if (answer == 2 && roomCheck2 == false) {
            System.out.println("You enter the room. It smells incredibly funky. You look around and notice a rusted dagger that still has some use to it.\n");
            System.out.println("Do you want to pick up the dagger?\n");
            System.out.println("1: Yes");
            System.out.println("2: No\n");
            System.out.println("------------------------------------------------------------------\n");
            answer = input.nextInt();
            
            // Option 1 for Dagger
            if (answer == 1) {
            	System.out.println("You place the dagger into your backpack");
            	roomCheck2 = true;
            	
            	// All rooms have been fully interacted with sent to Floor2 Interaction
            	if (roomCheck1 && roomCheck2 && roomCheck3 == true) {
	           		System.out.println("It looks like every room on this floor has been check let's move on.");
	           		Floor2();
	           	}
	           	
            	// All rooms haven't been checked send them back until they do
	           	else {
	           		Floor3(); 
	           	} 
            }
            
            // Option 2 for Dagger
            else if (answer == 2) {
            	System.out.println("You decided that the dagger is useless garbage and yeet it out a window");
            	roomCheck2 = true;
            	
            	// All rooms have been fully interacted with sent to Floor2 Interaction
            	if (roomCheck1 && roomCheck2 && roomCheck3 == true) {
            		System.out.println("It looks like every room on this floor has been check let's move on.");
            		Floor2();
            	}
            	
            	// All rooms haven't been checked send them back until they do
	           	else {
	           		Floor3(); 
	           	} 
            }
            
            // Don't let user leave w/o picking 1 or 2
            else {
            	DaggerInteraction();
            }
        }
        
        // Room 2 if User has checked once
        else if (answer == 2 && roomCheck2== true) {
            System.out.println("You've already entered that room you should venture elsewhere.");
            Floor3();
        }
        
        // Room 3 if User hasn't checked yet
        else if (answer == 3 && roomCheck3 == false) {
            System.out.println("It's completely blocked off. Choose a different option");
            roomCheck3 = true;
            
            // All rooms have been fully interacted with sent to Floor2 Interaction
        	if (roomCheck1 && roomCheck2 && roomCheck3 == true) {
        		System.out.println("It looks like every room on this floor has been check let's move on.");
        		Floor2();
        	}
        	
        	// All rooms haven't been checked send them back until they do
           	else {
           		Floor3(); 
           	} 
        }
        
        // Room 3 if User has checked once
        else if (answer == 3 && roomCheck3 == true) {
            System.out.println("You can't enter here.");
            
            // All rooms have been fully interacted with sent to Floor2 Interaction
        	if (roomCheck1 && roomCheck2 && roomCheck3 == true) {
        		System.out.println("It looks like every room on this floor has been check let's move on.");
        		Floor2();
        	}
        	
        	// All rooms haven't been checked send them back until they do
           	else {
           		Floor3(); 
           	} 
        }
        
        else {
        	System.out.println("They're no other options please try again");
            Floor3();
        }
	}
    
    public void Floor2() {
    	
    }
}