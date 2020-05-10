import java.util.concurrent.TimeUnit;

import javax.sound.sampled.Clip;

public class Battle {
    
    private Player player;
    private Enemy enemy;

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
    }



    public AbstractCharacter fasterAgility()
    /*
    * This method will determine who will attack first in the fight
    * based on the player and enemys agility points
    *
    * Returns: Whichever character is faster as a AbstractCharacter object
    */
    {
        int playerAgility = player.getAgility();
        int enemyAgility = enemy.getAgility();
        if (playerAgility >= enemyAgility){
            return player;
        }
        else{
            return enemy;
        }
    }

    public void fight() throws InterruptedException
    /*
    * This method will start the fight between the player and enemy
    * The first one to attack will be the character with the higher agility
    * It will then loop through each characters turn until the fight is over
    *
    */
    {
        Sound sound = new Sound("\\SoundEffects\\Pokemon.wav");
        Clip clip = sound.getClip();
        System.out.println("You Ran Into an Enemy!\n");
        AbstractCharacter firstAttacker = fasterAgility();
        AbstractCharacter secondAttacker;
        player.setStartingFightingHealth();
        TimeUnit.SECONDS.sleep(3);

        if(firstAttacker.equals(player) ){
            TypedText.typedFast("You're Faster. You make the first move!\n");
            secondAttacker = enemy;
        }
        else{
            TypedText.typedFast("The Enemy is Faster than you. It attacks first!");
            secondAttacker = player;
        }
        while(enemy.getHealth()>0 & player.getHealth()>0 & player.getFightingStatus() ){
            Main.clearScreen();
            getStats();
            firstAttacker.turn(player, enemy);
            if(!player.getFightingStatus() ){
                break;
            }
            Main.clearScreen();
            getStats();
            secondAttacker.turn(player,enemy);
            
        }
        clip.stop();
    }

    public void getStats() throws InterruptedException
    /*
    *This method will print out the current stats of both the player and enemy
    *
    */
    {
        Main.clearScreen();
        int enemyAttack = enemy.getAttack();
        int enemyAgility = enemy.getAgility();
        int enemyHealth = enemy.getHealth();

        int playerAttack = player.getAttack();
        int playerAgility = player.getAgility();
        int playerHealth = player.getFightingHealth();


        System.out.println("+-------------------------------+    +-------------------------------+");
        System.out.println("|             ENEMY             |    |             PLAYER            |");
        System.out.println("|                               |    |                               |");
        System.out.println("| Current Health: "+enemyHealth+"             |    | Current Health: "+playerHealth+"             |");
        System.out.println("|                               |    |                               |");
        System.out.println("| Attack: "+enemyAttack+"                     |    | Attack: "+playerAttack+"                     |");
        System.out.println("|                               |    |                               |");
        System.out.println("| Agility: "+enemyAgility+"                    |    | Agility: "+playerAgility+"                    |");
        System.out.println("|                               |    |                               |");
        System.out.println("|                               |    | Inventory:                    |");
        System.out.println("|                               |    |                               |");
        System.out.println("|                               |    |    Armor["+player.inventory.get(0).getName()+"] +"+player.getArmorPoints()+" Health     |");
        System.out.println("|                               |    |                               |");
        System.out.println("|                               |    |    Weapon["+player.inventory.get(1).getName()+"] +"+player.getWeaponPoints()+" Attack    |");
        System.out.println("|                               |    |                               |");
        System.out.println("|                               |    |    Boost["+player.inventory.get(2).getName()+"] +"+player.getAgilityAcessoryPoints()+" Agility    |");
        System.out.println("|                               |    |                               |");
        System.out.println("+-------------------------------+    +-------------------------------+");

        TimeUnit.SECONDS.sleep(3);
    }

    public static void youWin() throws InterruptedException 
    /*
    * This method will run the exit senerio when the player has won
    *
    */
    {
        Sound sound = new Sound("\\SoundEffects\\Victory.wav");
        Clip clip = sound.getClip();
        TypedText.typedFast("You Win");
        TimeUnit.SECONDS.sleep(5);
        clip.stop();

        
        
    }

    public static void gameOver() throws InterruptedException 
    /*
    * This method will run the exit senerio when the player dies
    *
    */
    {
        TypedText.typedSlow("You Lose");
        System.exit(0);

    }
}