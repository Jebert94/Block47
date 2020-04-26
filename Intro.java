package idontcare;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/* 
* This class will hold all of the methods needed to start the introduciton of the game. 
* This includes the Title screen, The background of the game, and the Player creation.
*
*/

public class Intro {
	
	private Scanner input = new Scanner(System.in);
	
    public void title() {
        
    }
    
    // need change to take in a text file to easily read descriptions
    public static void description() throws InterruptedException {
        TypedText.typedNormal("\nThe year is 1982 and the Soviet Union is gripping more and more each day in Yugoslavia.");
        TimeUnit.SECONDS.sleep(1);
        TypedText.typedNormal("\nYou wake up to a familiar sight.");
        TimeUnit.SECONDS.sleep(1);
        TypedText.typedNormal("\nConcrete buildings with identical rooms, flickering hallway lights, and the smell of death are nearly overwhelming.");
        TimeUnit.SECONDS.sleep(1);
        TypedText.typedNormal("\nYou begin to call out for help as you are still dazed from what appears to be a concussion.");
        TimeUnit.SECONDS.sleep(1);
        TypedText.typedNormal("\nNobody is responding...");
        TimeUnit.SECONDS.sleep(2);
        TypedText.typedSlow("\nBut that doesn't mean you are alone.");
        TimeUnit.SECONDS.sleep(2);
        TypedText.typedNormal("\nThis is Escape From Bloc 47.");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("\n\n");
    }

    public void createPlayerName(Player onlyPlayer) throws InterruptedException {

		TypedText.typedFast("Do you remember you name?\n");
		String lname = input.nextLine();
		onlyPlayer.setName(lname);
		TimeUnit.SECONDS.sleep(1);
		if(lname.length() > 5 && lname.length() < 7) {
		    TypedText.typedNormal("\nReally thats your name...");
		    TimeUnit.SECONDS.sleep(2);
		    TypedText.typedNormal("\nYou forget your name, and could call yourself anything but you come up with " + lname);
		    TimeUnit.SECONDS.sleep(2);
		    TypedText.typedNormal("\nWhatever ");
		    TimeUnit.SECONDS.sleep(1);
		    TypedText.typedSarcasticly(lname);
		    TimeUnit.SECONDS.sleep(2);
		}
	}

    public void createPlayerStats(Player onlyPlayer) throws InterruptedException {
        int statsAvalible = 5;
        int lhealth = 0;
        
        TypedText.typedFast("\nHow many hours do you want to spend bandaging yourself up? You have: "+statsAvalible+" hours remaining.\n");
        lhealth = input.nextInt();
        onlyPlayer.setHealth(onlyPlayer.getHealth()+ lhealth);
        statsAvalible = statsAvalible - lhealth;
        TimeUnit.SECONDS.sleep(1);

        TypedText.typedFast("How many hours do you want to spend building a weapon? You have: "+statsAvalible+" hours remaining.\n");
        int lattack = input.nextInt();
        onlyPlayer.setAttack(lattack);
        statsAvalible = statsAvalible - lattack;
        TimeUnit.SECONDS.sleep(1);

        TypedText.typedFast("How many hours do you want to spend fixing the broken shoes? You have: "+statsAvalible+" hours remaining.\n");
        int lagility = input.nextInt();
        input.nextLine();
        onlyPlayer.setAgility(lagility);
        statsAvalible = statsAvalible - lagility;
        TimeUnit.SECONDS.sleep(1);

        if(statsAvalible < 0) {
            TypedText.typedNormal("Stop trying to cheat asshole...");
            TimeUnit.SECONDS.sleep(2);
            TypedText.typedNormal("Do it again\n\n\n");
            TimeUnit.SECONDS.sleep(1);
            createPlayerStats(onlyPlayer);
        }

        askIfCorrect(onlyPlayer);
    }

    private void askIfCorrect(Player onlyPlayer) throws InterruptedException {
        Scanner stats = new Scanner(System.in);
        System.out.println("\nName: "+onlyPlayer.getName()+"\nHealth: "+onlyPlayer.getHealth()+"\nAttack: "+onlyPlayer.getAttack()+"\nAgility: "+onlyPlayer.getAgility());
        TimeUnit.SECONDS.sleep(5);
        System.out.println("\nIs this correct? \nEnter 'Yes' or 'No'");
        String correct = stats.nextLine();
        
        if(correct.equalsIgnoreCase("no")) {
            createPlayerStats(onlyPlayer);
        }
        
        if(correct.equalsIgnoreCase("yes")) {
            stats.close();
        }
        
        else {
            askIfCorrect(onlyPlayer);
        }
    }
}