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
    public static void introduction() throws InterruptedException {
        TypedText.typedNormal("The year is 1982 and the Soviet Union is gripping more and more each day in Yugoslavia.");
        TypedText.typedNormal("You wake up to a familiar sight.");
        TypedText.typedNormal("Concrete buildings with identical rooms, flickering hallway lights, and the smell of death are nearly overwhelming.");
        TypedText.typedNormal("You begin to call out for help as you are still dazed from what appears to be a concussion.");
        TypedText.typedNormal("Nobody is responding...",3);
        TypedText.typedSlow("But that doesn't mean you are alone.");
        TypedText.typedNormal("This is Escape From Bloc 47.",4);
        System.out.println("\n\n");
    }

    public void createPlayerName(Player onlyPlayer) throws InterruptedException {

		TypedText.typedFast("Do you remember you name?\n");
		String lname = input.nextLine();
		onlyPlayer.setName(lname);
		TimeUnit.SECONDS.sleep(1);
		if(lname.length() > 5 && lname.length() < 7) {
		    TypedText.typedNormal("Really thats your name...");
		    TypedText.typedNormal("You forget your name, and could call yourself anything but you come up with " + lname, 1);
		    TypedText.typedNormal("Whatever ",0);
		    TypedText.typedSarcasticly(lname);
            System.out.println("\n");
        }
        System.out.println("\n");
    }
    
    public static void background()throws InterruptedException{
        TypedText.typedNormal("*When you finally get your bearings you notice It's still dark outside.*");
        System.out.println("\n");

        TypedText.typedNormal("\"There's no way I'm leaving until sunrise.\"");
        TypedText.typedNormal("\"I can hardly see shit especially down that hallway.\"");
        System.out.println("\n");

        TypedText.typedSlow("*You notice something moving in the dark on the other end.*");
        TypedText.typedNormal("*You get up off the bed to get a better look.*");
        System.out.println("\n");

        TypedText.typedNormal("\"What.. is that?\"");
        TypedText.typedSlow("\"Hello?\"");
        System.out.println("\n");

        TypedText.typedNormal("*you begin to move closer to the hallway door as you try to talk to... It*");
        System.out.println("\n");

        TypedText.typedFast("\"Hey, can you answer me? Where the hell are we?\"");
        System.out.println("\n");

        TypedText.typedNormal("* You take another step and hear a blood curdling scream coming from that thing as it begins to charge at you. *"); 
        TypedText.typedFast("* You run for the same door that that thing is trying to get through to you. *");
        TypedText.typedFast("* You beat it there and shut the door literally smashing its face as it tried to rush in. *");
        TypedText.typedFast("* It continues to bash against the door, knocking you back an inch each time. *");
        TypedText.typedFast("* In between the charges, you're able to lock it with the deadbolt and a chair for good measure. *"); 
        TypedText.typedFast("* The monster continues to bang on the door. *");
        System.out.println("\n");

        TypedText.typedNormal("* Out of breath you whisper “what the fuck was that thing?” as you stare at the shaking door. *");
        TypedText.typedNormal("* On the counter next to it you notice a bottle of vodka, grab it and start downing it. *"); 
        TypedText.typedNormal("* Walking around the room and notice you're barefoot but there are some busted up shoes in the corner. *");
        TypedText.typedNormal("* You're also bleeding, that thing must have got you somehow. *");
        TypedText.typedNormal("* You head over to the window and look down through the broken glass. *");
        System.out.println("\n");

        TypedText.typedNormal("\"I'm at least 5 stories up. There's no way I can get out this way.\"");
        TypedText.typedNormal("\"That door is my only option and I'd say I have at least 5 hours until sunrise.\"");
        System.out.println("\n\n\n");

        TypedText.typedFast("Each hour you spend on a specific task will represent an added point to your different stats.",3);
        System.out.println(); 
        TypedText.typedNormal("Health, Attack, and Agility."); 
        System.out.println("\n");
        TypedText.typedNormal("Health determines how much damage you can take.");
        TypedText.typedNormal("Attack is your ability to fight off the monsters."); 
        TypedText.typedNormal("Agility determines how likely you are to get away if you decided to run from one.");

    }

    public void createPlayerStats(Player onlyPlayer) throws InterruptedException {
        int statsAvalible = 5;

        
        TypedText.typedFast("How many hours do you want to spend bandaging yourself up? This will increase your Health. You have: "+statsAvalible+" hours remaining.");
        int addedHealth = input.nextInt();
        int baseHealth = 7;
        onlyPlayer.setHealth(baseHealth + addedHealth);
        statsAvalible = statsAvalible - addedHealth;
        TimeUnit.SECONDS.sleep(1);

        TypedText.typedFast("How many hours do you want to spend building a weapon? This will increase your Attack. You have: "+statsAvalible+" hours remaining.");
        int addedAttack = input.nextInt();
        int baseAttack = 1;
        onlyPlayer.setAttack(baseAttack + addedAttack);
        statsAvalible = statsAvalible - addedAttack;
        TimeUnit.SECONDS.sleep(1);

        TypedText.typedFast("How many hours do you want to spend fixing the broken shoes? This will increase your Agility. You have: "+statsAvalible+" hours remaining.");
        int addedAgility = input.nextInt();
        input.nextLine();
        int baseAggility = 1;
        onlyPlayer.setAgility(baseAggility + addedAgility);
        statsAvalible = statsAvalible - addedAgility;
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