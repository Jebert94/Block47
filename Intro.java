import java.util.concurrent.TimeUnit;

/* 
* This class will hold all of the methods needed to start the introduciton of the game. 
* This includes the Title screen, The background of the game, and the Player creation.
*
*/

public class Intro {

	
	
    // add computer boot up sound and wait a few seconds to start typing
    // add in blinking cursor
    // need change to take in a text file to easily read descriptions
    public static void introduction() throws InterruptedException {
        Main.clearScreen();
        Sound sound = new Sound("\\SoundEffects\\comp.wav");
        for(int i = 0; i<2; i++){
            System.out.print("Establishing Connection   \r");
            TimeUnit.SECONDS.sleep(1);
            System.out.print("Establishing Connection.  \r");
            TimeUnit.SECONDS.sleep(1);
            System.out.print("Establishing Connection.. \r");
            TimeUnit.SECONDS.sleep(1);
            System.out.print("Establishing Connection...\r");
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.print("\rEstablished Connection      \n\n");
        TimeUnit.SECONDS.sleep(1);

        TypedText.typedNormalSound("The year is 1982 and the Soviet Union is gripping more and more each day in Yugoslavia.");
        TypedText.typedNormalSound("You wake up to a familiar sight.");
        TypedText.typedNormalSound("Concrete buildings with identical rooms, flickering hallway lights, and the smell of death are nearly overwhelming.");
        TypedText.typedNormalSound("You begin to call out for help as you are still dazed from what appears to be a concussion.");
        TypedText.typedNormalSound("Nobody is responding...");
        TypedText.typedNormalSound("But that doesn't mean you are alone.");
        TypedText.typedNormalSound("This is Escape From Bloc 47.");
        System.out.println("\n\n");
        sound.getClip().stop();
    }
    //clear screeen
    //play USSR National Anthom
    //Print out title and ascii art
    public void title() throws InterruptedException {
        Sound sound = new Sound("\\SoundEffects\\USSR.wav");
        System.out.print("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\r\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\r\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%,,%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\r\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%,,,,%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\r\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%,,,,,%%%%%%%%%%%%%%%%%%%%%%%%%%%\r\n%%%%%%%%%%%%%%%%%%%%%%%%,,,,(%%%%%%%%%%%%%%%%%%%%%%,,,,,(%%%%%%%%%%%%%%%%%%%%%%%\r\n%%%%%%%%%%%%%%%%%%%%%%,,,,,,,,,,,,,,,,%%%%%%%%%%%%%%%%,,,,,/%%%%%%%%%%%%%%%%%%%%\r\n%%%%%%%%%%%%%%%%%%%,,,,,,,,,,,,,,,,,,%%%%%%%%%%%%%%%%%%%,,,,,,%%%%%%%%%%%%%%%%%%\r\n%%%%%%%%%%%%%%%%%,,,,,,,,,,,,,,,,,%%%%%%%%%%%%%%%%%%%%%%%%,,,,,,%%%%%%%%%%%%%%%%\r\n%%%%%%%%%%%%%%,,,,,,,,,,,,,,,,,%%%%%%%%%%%%%%%%%%%%%%%%%%%%%,,,,,,%%%%%%%%%%%%%%\r\n%%%%%%%%%%%%,,,,,,,,,,,,,,,,,,,%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%,,,,,,,%%%%%%%%%%%%\r\n%%%%%%%%%,,,,,,,,,,,,,,,,,,,,,,,,%%%%%%%%%%%%%%%%%%%%%%%%%%%%%,,,,,,,,%%%%%%%%%%\r\n%%%%%%%%%%%%,,,,,,,,,,,%%%,,,,,,,,,,%%%%%%%%%%%%%%%%%%%%%%%%%%%,,,,,,,,%%%%%%%%%\r\n%%%%%%%%%%%%%%,,,,,,,%%%%%%%,,,,,,,,,,%%%%%%%%%%%%%%%%%%%%%%%%%%,,,,,,,,%%%%%%%%\r\n%%%%%%%%%%%%%%%%%,,%%%%%%%%%%%*,,,,,,,,,,%%%%%%%%%%%%%%%%%%%%%%%,,,,,,,,,%%%%%%%\r\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%,,,,,,,,,,%%%%%%%%%%%%%%%%%%%%%%,,,,,,,,%%%%%%%\r\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%,,,,,,,,,,,%%%%%%%%%%%%%%%%%%%,,,,,,,,,%%%%%%\r\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%,,,,,,,,,,(%%%%%%%%%%%%%%%%,,,,,,,,,%%%%%%\r\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%,,,,,,,,,,,%%%%%%%%%%%%%%,,,,,,,,%%%%%%%\r\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%,,,,,,,,,,,%%%%%%%%%%%,,,,,,,,%%%%%%%\r\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%,,,,,,,,,,,%%%%%%%%,,,,,,,,%%%%%%%%\r\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%,,,,,,,,,,,,%%%#,,,,,,,,,%%%%%%%%\r\n%%%%%%%%%%%%%%%%%%%%%%%%,,,,%%%%%%%%%%%%%%%%%%%%%%,,,,,,,,,,,,,,,,,,,,,%%%%%%%%%\r\n%%%%%%%%%%%%%%%%%,,,,,,,,,,,,,,%%%%%%%%%%%%%%%%%%%%%,,,,,,,,,,,,,,,,,%%%%%%%%%%%\r\n%%%%%%%%%%%%%%%%,,,,,,,%,,,,,,,,,,,%%%%%%%%%%%%%%%%%%%#,,,,,,,,,,,,,%%%%%%%%%%%%\r\n%%%%%%%%%%%%%#,,,,,,,,,%%%%,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,%%%%%%%%%%%\r\n%%%%%%%%%%,,,,,,,,,%%%%%%%%%%%,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,%%%%%%%%%\r\n%%%%%%%,,,,,,,,,,%%%%%%%%%%%%%%%%%,,,,,,,,,,,,,,,,,,,,,,,,,%%%,,,,,,,,,,,,%%%%%%\r\n%%%%%,,,,,,,,,,%%%%%%%%%%%%%%%%%%%%%%%%%/,,,,,,,,,,,,%%%%%%%%%%%,,,,,,,,,,,,#%%%\r\n%%%%,,,,,,,,,%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%,,,,,,,,,%%%%\r\n%%%%%,,,,,%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%,,,,%%%%%%%\r\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.print("\r\t@@@@@@@   @@@        @@@@@@    @@@@@@@          @@@   @@@@@@@@  \r\n\t@@@@@@@@  @@@       @@@@@@@@  @@@@@@@@         @@@@   @@@@@@@@  \r\n\t@@!  @@@  @@!       @@!  @@@  !@@             @@!@!        @@!  \r\n\t!@   @!@  !@!       !@!  @!@  !@!            !@!!@!       !@!   \r\n\t@!@!@!@   @!!       @!@  !@!  !@!           @!! @!!      @!!    \r\n\t!!!@!!!!  !!!       !@!  !!!  !!!          !!!  !@!     !!!     \r\n\t!!:  !!!  !!:       !!:  !!!  :!!          :!!:!:!!:   !!:      \r\n\t:!:  !:!   :!:      :!:  !:!  :!:          !:::!!:::  :!:       \r\n\t :: ::::   :: ::::  ::::: ::   ::: :::          :::    ::       \r\n\t:: : ::   : :: : :   : :  :    :: :: :          :::   : :       \r\n                                                                ");
        System.out.println("\n");
        TimeUnit.SECONDS.sleep(20);
        Main.clearScreen();
    }

    
    public static void background()throws InterruptedException{
        Sound sound = new Sound("\\SoundEffects\\background.wav");

        TypedText.typedFast("*When you finally get your bearings you notice It's still dark outside.*",2);
        System.out.println("\n");

        TypedText.typedNormal("\"There's no way I'm leaving until sunrise.\"");
        TypedText.typedNormal("\"I can hardly see shit especially down that hallway.\"",2);
        System.out.println("\n");

        TypedText.typedFast("*You notice something moving in the dark on the other end.*",2);
        TypedText.typedFast("*You get up off the bed to get a better look.*",2);
        System.out.println("\n");

        TypedText.typedNormal("\"What.. is that?\"",2);
        TypedText.typedNormal("\"Hello?\"",3);
        System.out.println("\n");

        TypedText.typedFast("*You begin to move closer to the hallway door as you try to talk to... It*",3);
        System.out.println("\n");

        TypedText.typedNormal("\"Hey, can you answer me? Where the hell are we?\"",3);
        System.out.println("\n");


        TypedText.typedFast("* That noise... Its like nothing you've ever heard before *",4);
        TypedText.typedFast("* You peer into the darkness ahead of you as the ligths above you flicker erratically. *",3);
        TypedText.typedNormal("* You take another step and hear a blood curdling scream coming from that thing as it begins to charge at you. *",1); 
        TypedText.typedFast("* You run for the same door that that thing is trying to get through to you. *",2);
        TypedText.typedFast("* You beat it there and shut the door literally smashing its face as it tried to rush in. *",3);
        TypedText.typedFast("* It continues to bash against the door, knocking you back an inch each time. *",4);
        TypedText.typedFast("* In between the charges, you're able to lock it with the deadbolt and a chair for good measure. *",2); 
        TypedText.typedFast("* The monster continues to bang on the door. *",3);
        System.out.println("\n");

        TypedText.typedFast("* Out of breath you whisper â€œwhat the fuck was that thing?â€� as you stare at the shaking door. *",2);
        TypedText.typedFast("* On the counter next to it you notice a bottle of vodka, grab it and start downing it. *",3); 
        TypedText.typedFast("* Walking around the room and notice you're barefoot. *",2);
        TypedText.typedFast("* You're also bleeding, that thing must have got you somehow. *",2);
        TypedText.typedFast("* You head over to the window and look down through the broken glass. *",3);
        System.out.println("\n");

        TypedText.typedNormal("\"I'm at least 3 stories up. There's no way I can get out this way.\"",8);
        Main.clearScreen();

        TypedText.typedNormal("\"That door is my only option and I'd say I have at least 5 hours until sunrise.\"");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("\n\n\n");

        System.out.println("Each hour you spend on a specific task will represent an added point to your different stats.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println(); 
        System.out.println("Health, Attack, and Agility.");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("\n");
        System.out.println("Health: determines how much damage you can take.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Attack: is your ability to fight off the monsters.");
        TimeUnit.SECONDS.sleep(2); 
        System.out.println("Agility: determines how likely you are to get away if you decided to run from one.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println();
        System.out.println("As you attempt to leave this hell hole, items can be found to either boost or hinder these stats\n");
        TimeUnit.SECONDS.sleep(10);
        Main.clearScreen();

    }

    public void createPlayerName(Player onlyPlayer) throws InterruptedException {
        System.out.println("What is your name?");
		String lname = Main.input.nextLine();
		onlyPlayer.setName(lname);
		TimeUnit.SECONDS.sleep(1);
        System.out.println("\n");
    }

    public void createPlayerStats(Player onlyPlayer) throws InterruptedException {
        int statsAvalible = 5;
        System.out.println("How many hours do you want to spend bandaging yourself up? This will increase your Health. You have: "+statsAvalible+" hours remaining.");
        int addedHealth = Main.input.nextInt();
        int startingHealth = 7;
        onlyPlayer.setBaseHealth(startingHealth + addedHealth);
        statsAvalible = statsAvalible - addedHealth;
        TimeUnit.SECONDS.sleep(1);

        System.out.println("How many hours do you want to spend watching Never Back Down? This will increase your Attack. You have: "+statsAvalible+" hours remaining.");
        int addedAttack = Main.input.nextInt();
        int startingAttack = 1;
        onlyPlayer.setBaseAttack(startingAttack + addedAttack);
        statsAvalible = statsAvalible - addedAttack;
        TimeUnit.SECONDS.sleep(1);

        System.out.println("How many hours do you want to spend running in place? This will increase your Agility. You have: "+statsAvalible+" hours remaining.");
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
            Main.clearScreen();
            createPlayerStats(onlyPlayer);
        }

        askIfCorrect(onlyPlayer);
    }

    private void askIfCorrect(Player onlyPlayer) throws InterruptedException {
        Main.clearScreen();
        System.out.println("These are your players stats.");
        System.out.println("\nName: "+onlyPlayer.getName()+"\nHealth: "+onlyPlayer.getBaseHealth()+"\nAttack: "+onlyPlayer.getBaseAttack()+"\nAgility: "+onlyPlayer.getBaseAgility());
        TimeUnit.SECONDS.sleep(4);
        System.out.println("\nIs this correct? \n1: Yes\n2: No\n");
        int correct = Main.input.nextInt();
        switch(correct){

        case 1:
            System.out.println("\n");
            Main.clearScreen();
            break;

        case 2:
            Main.clearScreen();
            createPlayerStats(onlyPlayer);
            break;

        default:
            System.out.println("Error. Try again.");
            Main.clearScreen();
            askIfCorrect(onlyPlayer);
        break;
        }
    }
}