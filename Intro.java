
import java.util.concurrent.TimeUnit;

/* 
* This class will hold all of the methods needed to start the introduciton of the game. 
* This includes the Title screen, The background of the game, and the Player creation.
*
*/

public class Intro {
	
	
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

        TypedText.typedFast("Do you remember you name?");
        TypedText.typedFast("What is it?");
		String lname = Main.input.nextLine();
		onlyPlayer.setName(lname);
		TimeUnit.SECONDS.sleep(1);
		if(lname.length() > 5 && lname.length() < 7) {
		    TypedText.typedNormal("Really, thats your name...");
		    TypedText.typedNormal("You forget your name, and could call yourself anything but you come up with " + lname, 1);
		    TypedText.typedNormal("Whatever ",0);
		    TypedText.typedSarcasticly(lname);
            System.out.println("\n");
        }
        System.out.println("\n");
    }
    
    public static void background()throws InterruptedException{
        TypedText.typedFast("*When you finally get your bearings you notice It's still dark outside.*");
        System.out.println("\n");

        TypedText.typedFast("\"There's no way I'm leaving until sunrise.\"");
        TypedText.typedFast("\"I can hardly see shit especially down that hallway.\"");
        System.out.println("\n");

        TypedText.typedSlow("*You notice something moving in the dark on the other end.*");
        TypedText.typedFast("*You get up off the bed to get a better look.*");
        System.out.println("\n");

        TypedText.typedFast("\"What.. is that?\"");
        TypedText.typedSlow("\"Hello?\"");
        System.out.println("\n");

        TypedText.typedFast("*you begin to move closer to the hallway door as you try to talk to... It*");
        System.out.println("\n");

        TypedText.typedFast("\"Hey, can you answer me? Where the hell are we?\"");
        System.out.println("\n");

        TypedText.typedFast("* You take another step and hear a blood curdling scream coming from that thing as it begins to charge at you. *"); 
        TypedText.typedFast("* You run for the same door that that thing is trying to get through to you. *");
        TypedText.typedFast("* You beat it there and shut the door literally smashing its face as it tried to rush in. *");
        TypedText.typedFast("* It continues to bash against the door, knocking you back an inch each time. *");
        TypedText.typedFast("* In between the charges, you're able to lock it with the deadbolt and a chair for good measure. *"); 
        TypedText.typedFast("* The monster continues to bang on the door. *");
        System.out.println("\n");

        TypedText.typedFast("* Out of breath you whisper “what the fuck was that thing?” as you stare at the shaking door. *");
        TypedText.typedFast("* On the counter next to it you notice a bottle of vodka, grab it and start downing it. *"); 
        TypedText.typedFast("* Walking around the room and notice you're barefoot. *");
        TypedText.typedFast("* You're also bleeding, that thing must have got you somehow. *");
        TypedText.typedFast("* You head over to the window and look down through the broken glass. *");
        System.out.println("\n");

        TypedText.typedFast("\"I'm at least 3 stories up. There's no way I can get out this way.\"");
        TypedText.typedFast("\"That door is my only option and I'd say I have at least 5 hours until sunrise.\"");
        System.out.println("\n\n\n");

        TypedText.typedFast("Each hour you spend on a specific task will represent an added point to your different stats.",3);
        System.out.println(); 
        TypedText.typedFast("Health, Attack, and Agility."); 
        System.out.println("\n");
        TypedText.typedFast("Health determines how much damage you can take.");
        TypedText.typedFast("Attack is your ability to fight off the monsters."); 
        TypedText.typedFast("Agility determines how likely you are to get away if you decided to run from one.");
        TypedText.typedFast("As you attempt to leave this hell hole, items can be found to either boost or hinder these stats\n");

    }

    public void createPlayerStats(Player onlyPlayer) throws InterruptedException {
        int statsAvalible = 5;

        
        TypedText.typedFast("How many hours do you want to spend bandaging yourself up? This will increase your Health. You have: "+statsAvalible+" hours remaining.");
        int addedHealth = Main.input.nextInt();
        int startingHealth = 7;
        onlyPlayer.setBaseHealth(startingHealth + addedHealth);
        statsAvalible = statsAvalible - addedHealth;
        TimeUnit.SECONDS.sleep(1);

        TypedText.typedFast("How many hours do you want to spend watching Never Back Down? This will increase your Attack. You have: "+statsAvalible+" hours remaining.");
        int addedAttack = Main.input.nextInt();
        int startingAttack = 1;
        onlyPlayer.setBaseAttack(startingAttack + addedAttack);
        statsAvalible = statsAvalible - addedAttack;
        TimeUnit.SECONDS.sleep(1);

        TypedText.typedFast("How many hours do you want to spend running in place? This will increase your Agility. You have: "+statsAvalible+" hours remaining.");
        int addedAgility = Main.input.nextInt();
        Main.input.nextLine();
        int startingAggility = 1;
        onlyPlayer.setBaseAgility(startingAggility + addedAgility);
        statsAvalible = statsAvalible - addedAgility;
        System.out.println("\n");
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
        System.out.println("These are your players stats.");
        System.out.println("\nName: "+onlyPlayer.getName()+"\nHealth: "+onlyPlayer.getBaseHealth()+"\nAttack: "+onlyPlayer.getBaseAttack()+"\nAgility: "+onlyPlayer.getBaseAgility());
        TimeUnit.SECONDS.sleep(4);
        System.out.println("\nIs this correct? \n1: Yes\n2: No\n");
        int correct = Main.input.nextInt();
        switch(correct){

        case 1:
            System.out.println("\n");
            break;

        case 2:
            createPlayerStats(onlyPlayer);
            break;

        default:
            askIfCorrect(onlyPlayer);
        break;
        }
    }
}