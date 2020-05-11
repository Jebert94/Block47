import java.util.concurrent.TimeUnit;

import javax.sound.sampled.Clip;

public class Battle {
    
    private Player player;
    private Enemy enemy;
    private static boolean win;
    private static boolean dead = false;

    public Battle(Player player, Enemy enemy) throws InterruptedException
    /*
     * Constructor method for the battle object
     *
     * Input: The player object and the current enemy
     */
    {
        this.player = player;
        this.enemy = enemy;
        player.setFightingStatus(true);
        win = false;
    }

    public AbstractCharacter fasterAgility()
    /*
     * This method will determine who will attack first in the fight based on the
     * player and enemys agility points
     *
     * Returns: Whichever character is faster as a AbstractCharacter object
     */
    {
        int playerAgility = player.getAgility();
        int enemyAgility = enemy.getAgility();
        if (playerAgility >= enemyAgility) {
            return player;
        } else {
            return enemy;
        }
    }

    public void fight() throws InterruptedException
    /*
     * This method will start the fight between the player and enemy The first one
     * to attack will be the character with the higher agility It will then loop
     * through each characters turn until the fight is over
     *
     */
    {
        Sound sound = new Sound("\\SoundEffects\\Pokemon.wav");
        Clip clip = sound.getClip();
        System.out.println("You Ran Into an Enemy!\n");
        AbstractCharacter firstAttacker = fasterAgility();
        AbstractCharacter secondAttacker;
        player.setStartingFightingHealth();
        TimeUnit.SECONDS.sleep(2);
        getStats();
        if (firstAttacker.equals(player)) {
            TypedText.typedFast("You're Faster. You make the first move!\n");
            secondAttacker = enemy;
        } else {
            TypedText.typedFast("The Enemy is Faster than you. It attacks first!");
            secondAttacker = player;
        }
        TimeUnit.SECONDS.sleep(4);
        Main.clearScreen();
        while (enemy.getHealth() > 0 & player.getHealth() > 0 & player.getFightingStatus()) {
            Main.clearScreen();
            getStats();
            firstAttacker.turn(player, enemy);
            if (!player.getFightingStatus()) {
                break;
            }
            Main.clearScreen();
            getStats();
            secondAttacker.turn(player, enemy);

        }
        clip.stop();
        if (win) {
            Sound winSound = new Sound("\\SoundEffects\\Victory.wav");
            TypedText.typedFast("You Win");
            TimeUnit.SECONDS.sleep(5);
            winSound.getClip().stop();
        }
        if (dead){
            Main.clearScreen();
            Sound deadsound = new Sound("\\SoundEffects\\dead.wav");
            System.out.print("                                                                   \r\n@@@ @@@   @@@@@@   @@@  @@@     @@@@@@@   @@@  @@@@@@@@  @@@@@@@   \r\n@@@ @@@  @@@@@@@@  @@@  @@@     @@@@@@@@  @@@  @@@@@@@@  @@@@@@@@  \r\n@@! !@@  @@!  @@@  @@!  @@@     @@!  @@@  @@!  @@!       @@!  @@@  \r\n!@! @!!  !@!  @!@  !@!  @!@     !@!  @!@  !@!  !@!       !@!  @!@  \r\n !@!@!   @!@  !@!  @!@  !@!     @!@  !@!  !!@  @!!!:!    @!@  !@!  \r\n  @!!!   !@!  !!!  !@!  !!!     !@!  !!!  !!!  !!!!!:    !@!  !!!  \r\n  !!:    !!:  !!!  !!:  !!!     !!:  !!!  !!:  !!:       !!:  !!!  \r\n  :!:    :!:  !:!  :!:  !:!     :!:  !:!  :!:  :!:       :!:  !:!  \r\n   ::    ::::: ::  ::::: ::      :::: ::   ::   :: ::::   :::: ::  \r\n   :      : :  :    : :  :      :: :  :   :    : :: ::   :: :  :   \r\n                                                                  ");
            TimeUnit.SECONDS.sleep(8);
            Main.clearScreen();
            System.out.print("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@@@@@@       @@@@@@@@@@@@@@@@@@@@@@@@@@@   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@@@@.            ...*((((/***.          ,        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@@@ #       ((((((((((((((((((( ((((   *                         @@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@@       (((((((((((((((((((/*. ( . .                                .@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@****** (((((((((((((((((((((((((            .@@       (      .##,      @@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@                                 **, /******.       @  ******,          @@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@*    **  ((((((((((((((((((((((@     ,**      .****       *     ****** @@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@ ***,*** #######################      ***      ****  **   **     ******* @@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@ ******* ((((((( # ### # ((((((@*****.**** *,******** *  .,*,********* * @@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@ ******* (((((((((((((((((((((( ***,*** ************** ***** ********* @@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@@@  ** (((((((((((((((((((((( **** **** ********* ,(( ************ *@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@@  ## ((((((((////,.            @  ,********** ((((((((( ****** @@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@    ###        ,//((((((((((((/(((/.   @( **, ( @@@@@@@   ( ###(   @@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@ ** #            @@@@@@@@@@@@/**  @@@  @ # @@@    @%.* %@  ####     @@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@ * #         @@@@@@@@@@@@@@,*****,@@             @***#            @@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@   ########  ( @@@@@@@@@@@@@.*****@@            * @@(%    ######   @@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@    #   ,#/  ,* @@@@@@@@@@@@@@@@@%  *             @@@@@@  #/ ###   @@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@             /@@@@@@@@@@@@@@@@@@@@@@  @@ .@@@     @@@@@@,          @@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@              @@@@@@@@@@@@@@@@@@@@@@              @@@@@      @     @@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@      @@      @@@@@    @ @@@@@@@                   @@    @@@&@@    @@@@@@@@@@@@@@@@\r\n@@@@@@@@@@    @@    @@@@@@   *@@@@@        @@         *** @@ *      @    @@@@@@@@   @@@@@@@@@@@@@@@@\r\n@@@@@@@@@@         @@@@@@@@    @@@@%     *@        @@@@@@@@@@       *  /@@@@@@@@@@ # .@@@@@@@@@@@@@@\r\n@@@@@@@@@@@      @@@@@@@@@@@@  # @@@        ,   @@@@@@@@@@@@@@@@       @@@@@@@@@@  @@@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@    @@@@@@@@@@(## @@@@@@        &@@@@@@@@@@@@@@@@@@@@@   &@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@     @@@@@@@@@@@@@@@@@@@@@ @@@/ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            TimeUnit.SECONDS.sleep(20);
            deadsound.getClip().stop();
            System.exit(0);
        }
    }

    public void getStats() throws InterruptedException
    /*
     * This method will print out the current stats of both the player and enemy
     *
     */
    {
        Main.clearScreen();
        String enemyName = enemy.getName();
        int enemyAttack = enemy.getAttack();
        int enemyAgility = enemy.getAgility();
        int enemyHealth = enemy.getHealth();

        String playerName = player.getName();
        int playerAttack = player.getAttack();
        int playerAgility = player.getAgility();
        int playerHealth = player.getFightingHealth();

        System.out.println("+-------------------------------+                   +-------------------------------+");
        System.out.println(
                "|     " + enemyName + "      |                   |             " + playerName + "              |");
        System.out.println("|                               |                   |                               |");
        System.out.println("| Current Health: " + enemyHealth + "             |                   | Current Health: "
                + playerHealth + "             |");
        System.out.println("|                               |                   |                               |");
        System.out.println("| Attack: " + enemyAttack + "                     |                   | Attack: "
                + playerAttack + "                     |");
        System.out.println("|                               |                   |                               |");
        System.out.println("| Agility: " + enemyAgility + "                    |                   | Agility: "
                + playerAgility + "                    |");
        System.out.println("|                               |                   |                               |");
        System.out.println("|                               |                   | Inventory:                    |");
        System.out.println("|                               |                   |                               |");
        System.out.println("|                               |                   |    Armor["
                + player.inventory.get(0).getName() + "] +" + player.getArmorPoints() + " Health     |");
        System.out.println("|                               |                   |                               |");
        System.out.println("|                               |                   |    Weapon["
                + player.inventory.get(1).getName() + "] +" + player.getWeaponPoints() + " Attack    |");
        System.out.println("|                               |                   |                               |");
        System.out.println("|                               |                   |    Boost["
                + player.inventory.get(2).getName() + "] +" + player.getAgilityAcessoryPoints() + " Agility    |");
        System.out.println("|                               |                   |                               |");
        System.out.println("+-------------------------------+                   +-------------------------------+");

        TimeUnit.SECONDS.sleep(3);
    }

    public static void youWin() throws InterruptedException
    /*
     * This method will run the exit senerio when the player has won
     *
     */
    {
        win = true;
    }

    public static void gameOver() throws InterruptedException 
    /*
    * This method will run the exit senerio when the player dies
    *
    */
    {
        dead = true;
    }
    public static void runGameOver() throws InterruptedException
    {
        Main.clearScreen();
        Sound deadsound = new Sound("\\SoundEffects\\dead.wav");
        System.out.print("                                                                   \r\n@@@ @@@   @@@@@@   @@@  @@@     @@@@@@@   @@@  @@@@@@@@  @@@@@@@   \r\n@@@ @@@  @@@@@@@@  @@@  @@@     @@@@@@@@  @@@  @@@@@@@@  @@@@@@@@  \r\n@@! !@@  @@!  @@@  @@!  @@@     @@!  @@@  @@!  @@!       @@!  @@@  \r\n!@! @!!  !@!  @!@  !@!  @!@     !@!  @!@  !@!  !@!       !@!  @!@  \r\n !@!@!   @!@  !@!  @!@  !@!     @!@  !@!  !!@  @!!!:!    @!@  !@!  \r\n  @!!!   !@!  !!!  !@!  !!!     !@!  !!!  !!!  !!!!!:    !@!  !!!  \r\n  !!:    !!:  !!!  !!:  !!!     !!:  !!!  !!:  !!:       !!:  !!!  \r\n  :!:    :!:  !:!  :!:  !:!     :!:  !:!  :!:  :!:       :!:  !:!  \r\n   ::    ::::: ::  ::::: ::      :::: ::   ::   :: ::::   :::: ::  \r\n   :      : :  :    : :  :      :: :  :   :    : :: ::   :: :  :   \r\n                                                                  ");
        TimeUnit.SECONDS.sleep(8);
        Main.clearScreen();
        System.out.print("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@@@@@@       @@@@@@@@@@@@@@@@@@@@@@@@@@@   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@@@@.            ...*((((/***.          ,        @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@@@ #       ((((((((((((((((((( ((((   *                         @@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@@       (((((((((((((((((((/*. ( . .                                .@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@****** (((((((((((((((((((((((((            .@@       (      .##,      @@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@                                 **, /******.       @  ******,          @@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@*    **  ((((((((((((((((((((((@     ,**      .****       *     ****** @@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@ ***,*** #######################      ***      ****  **   **     ******* @@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@ ******* ((((((( # ### # ((((((@*****.**** *,******** *  .,*,********* * @@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@ ******* (((((((((((((((((((((( ***,*** ************** ***** ********* @@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@@@  ** (((((((((((((((((((((( **** **** ********* ,(( ************ *@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@@  ## ((((((((////,.            @  ,********** ((((((((( ****** @@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@    ###        ,//((((((((((((/(((/.   @( **, ( @@@@@@@   ( ###(   @@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@ ** #            @@@@@@@@@@@@/**  @@@  @ # @@@    @%.* %@  ####     @@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@ * #         @@@@@@@@@@@@@@,*****,@@             @***#            @@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@   ########  ( @@@@@@@@@@@@@.*****@@            * @@(%    ######   @@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@    #   ,#/  ,* @@@@@@@@@@@@@@@@@%  *             @@@@@@  #/ ###   @@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@             /@@@@@@@@@@@@@@@@@@@@@@  @@ .@@@     @@@@@@,          @@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@              @@@@@@@@@@@@@@@@@@@@@@              @@@@@      @     @@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@      @@      @@@@@    @ @@@@@@@                   @@    @@@&@@    @@@@@@@@@@@@@@@@\r\n@@@@@@@@@@    @@    @@@@@@   *@@@@@        @@         *** @@ *      @    @@@@@@@@   @@@@@@@@@@@@@@@@\r\n@@@@@@@@@@         @@@@@@@@    @@@@%     *@        @@@@@@@@@@       *  /@@@@@@@@@@ # .@@@@@@@@@@@@@@\r\n@@@@@@@@@@@      @@@@@@@@@@@@  # @@@        ,   @@@@@@@@@@@@@@@@       @@@@@@@@@@  @@@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@    @@@@@@@@@@(## @@@@@@        &@@@@@@@@@@@@@@@@@@@@@   &@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@     @@@@@@@@@@@@@@@@@@@@@ @@@/ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        TimeUnit.SECONDS.sleep(20);
        deadsound.getClip().stop();
        System.exit(0);
    }
}