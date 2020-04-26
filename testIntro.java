import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/* 
* This class will hold all of the methods needed to start the introduciton of the game. 
* This includes the Title screen, The background of the game, and the Player creation.
*
*/

public class testIntro {

    private Scanner input;

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
        TypedText.typedSlow("\nbut that doesn't mean you are alone.");
        TimeUnit.SECONDS.sleep(2);
        TypedText.typedNormal("\nThis is Escape From Bloc 47.");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("\n\n\n");
    }

    public void createPlayerName(Player testOnlyPlayer) throws InterruptedException {

        input = new Scanner(System.in);
        TypedText.typedFast("Do you remember you name?\n");
        String lname = input.nextLine();
        testOnlyPlayer.setName(lname);
        TimeUnit.SECONDS.sleep(1);
        if(lname.length() > 5 && lname.length() < 7) {
            TypedText.typedNormal("\nReally thats your name...");
            TimeUnit.SECONDS.sleep(2);
            TypedText.typedNormal("\nYou forget your name, and could call yourself anything but you come up with " + lname);
            TimeUnit.SECONDS.sleep(2);
            TypedText.typedNormal("\nWhatever ");
            TimeUnit.SECONDS.sleep(1);
            TypedText.typedSarcasticly(lname+"\n");
            TimeUnit.SECONDS.sleep(2);
        }      
    }

    public void createPlayerStats(Player testOnlyPlayer) throws InterruptedException {
    	
        int statsAvalible = 5;
        int lhealth = 2;

        input = new Scanner(System.in);
		TypedText.typedFast("How many hours do you want to spend bandaging yourself up? Each hour will add + 1 to your current health of: "+lhealth+ "\nYou have: "+statsAvalible+" hours remaining.\n");
		Integer hoursSpent = input.nextInt();
		lhealth = lhealth + hoursSpent;
		TypedText.typedFast("You now have "+lhealth+" health points.");
	    testOnlyPlayer.setHealth(testOnlyPlayer.getHealth()+ lhealth);
	    statsAvalible = statsAvalible - lhealth;
	    TimeUnit.SECONDS.sleep(1);
	}
}


//        TypedText.typedFast("How many hours do yu want to spend building a weapon? you have" +statsAvalible+" hours remaining");
//        int lattack = stats.nextInt();
//        testOnlyPlayer.setAttack(lattack);
//        statsAvalible = statsAvalible - lattack;
//        TimeUnit.SECONDS.sleep(1);
//
//        TypedText.typedFast("How many hours do you want to spend fixing the broken shoes? You have: "+statsAvalible+" hours remaining.");
//        int lagility = stats.nextInt();
//        stats.nextLine();
//        testOnlyPlayer.setAgility(lagility);
//        statsAvalible = statsAvalible - lagility;
//        TimeUnit.SECONDS.sleep(1);
//
//        if(statsAvalible < 0) {
//            TypedText.typedNormal("Stop trying to cheat asshole...");
//            TimeUnit.SECONDS.sleep(2);
//            TypedText.typedNormal("Do it again\n\n\n");
//            TimeUnit.SECONDS.sleep(1);
//            createPlayerStats(testOnlyPlayer);
//        }
//
//        askIfCorrect(testOnlyPlayer);
//
//        stats.close();
//
//    }
//
//    private void askIfCorrect(Player testOnlyPlayer) throws InterruptedException {
//        Scanner stats = new Scanner(System.in);
//        System.out.println("\n\nName: "+testOnlyPlayer.getName()+"\nHealth: "+testOnlyPlayer.getHealth()+"\nAttack: "+testOnlyPlayer.getAttack()+"\nAgility: "+onlyPlayer.getAgility());
//        TimeUnit.SECONDS.sleep(5);
//        System.out.println("\n\n\nIs this correct? \n Enter 'Yes' or 'No'");
//        String correct = stats.nextLine();
//        
//        if(correct.equalsIgnoreCase("no")) {
//            createPlayerStats(testOnlyPlayer);
//        }
//        
//        if(correct.equalsIgnoreCase("yes")) {
//            stats.close();
//        }
//        
//        else {
//            askIfCorrect(testOnlyPlayer);
//        }
//    }
//}