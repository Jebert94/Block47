import java.util.concurrent.TimeUnit;

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
        System.out.println("You Ran Into an Enemy!");
        AbstractCharacter firstAttacker = fasterAgility();
        AbstractCharacter secondAttacker;
        System.out.println();
        getStats();
        System.out.println();
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
            firstAttacker.turn(player, enemy);
            getStats();
            if(!player.getFightingStatus() ){
                break;
            }
            secondAttacker.turn(player,enemy);
            getStats();
        }
    }

    public void getStats() throws InterruptedException
    /*
    * This method will print out the current stats of both the player and enemy
    *
    */
    {
        int enemyAttack = enemy.getAttack();
        int enemyAgility = enemy.getAgility();
        int enemyHealth = enemy.getHealth();

        int playerAttack = player.getAttack();
        int playerAgility = player.getAgility();
        int playerHealth = player.getHealth();

        System.out.println("Player Stats: Health-"+ playerHealth + " Attack-"+playerAttack+" Agility-"+playerAgility );
        System.out.println("Enemy Stats: Health-"+ enemyHealth + " Attack-"+enemyAttack+" Agility-"+enemyAgility );
        System.out.println("\n");
        TimeUnit.SECONDS.sleep(3);
    }

    public static void youWin() throws InterruptedException 
    /*
    * This method will run the exit senerio when the player has won
    *
    */
    {
        TypedText.typedFast("You Win");
        //Go to current location
    }

    public static void gameOver() throws InterruptedException 
    /*
    * This method will run the exit senerio when the player dies
    *
    */{
        TypedText.typedSlow("You Lose");
        System.exit(0);

    }
}