import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Player extends AbstractCharacter{
    /**********************Instance Variables**************************/
    private String name;
    private boolean fighting;
    private int baseHealth;
    private int baseAttack;
    private int baseAgility;
    private int fightingHealth; //this allows the player to 'heal' after every battle automattically and correcly change their health during a battle"


    ArrayList<Item> inventory = new ArrayList<Item>(3);
    

    /****************** Singleton Design Pattern**********************/
    private static Player onlyPlayer;

    private Player(){
        inventory.add(new Item("empty", 0, 0));
        inventory.add(new Item("empty", 1, 0));
        inventory.add(new Item("empty", 2, 0));
    }

    public static Player getInstance() {
        if(onlyPlayer == null){
            onlyPlayer = new Player();
        }
        return onlyPlayer;
    }

    //*****************/ Getters and Setters **************************/


    /********Base stats********* */
    public int getBaseAttack(){
        return this.baseAttack;
    }
    public void setBaseAttack(int attackpoints){
        this.baseAttack = attackpoints;
    }

    public int getBaseAgility(){
        return this.baseAgility;
    }
    public void setBaseAgility(int agilitypoints){
        this.baseAgility = agilitypoints;
    }

    public int getBaseHealth(){
        return this.baseHealth;
    }
    public void setBaseHealth(int healthpoints){
        this.baseHealth = healthpoints;
    }
    public String getName() {
        return onlyPlayer.name;
    }
    public void setName(String assignedName){
        onlyPlayer.name = assignedName;
    }

    /**********Acessories ************** */

    public int getWeaponPoints(){
        Item weapon = onlyPlayer.inventory.get(0);
        int weaponAttackPoints = weapon.getBuffOrNerf();
        return weaponAttackPoints;
    }

    public int getArmorPoints(){
        Item armorItem = onlyPlayer.inventory.get(2);
        int armorDefensePoints = armorItem.getBuffOrNerf();
        return armorDefensePoints;
    }

    public int getAgilityAcessoryPoints(){
        Item agilityItem = onlyPlayer.inventory.get(1);
        int agilityAccessory = agilityItem.getBuffOrNerf();
        return agilityAccessory;
    }


    /********Combined Stats****************/

    public int getAttack(){
        Item attackItem = onlyPlayer.inventory.get(0);
        int buffOrNerf = attackItem.getBuffOrNerf();
        int totalAttack = this.baseAttack +buffOrNerf;
        return totalAttack;
        
    }

    public int getAgility(){
        Item agilityItem = onlyPlayer.inventory.get(1);
        int buffOrNerf = agilityItem.getBuffOrNerf();
        int totalAgility = this.baseAgility + buffOrNerf;
        return totalAgility;
        
    }

    public int getHealth(){
        Item armorItem = onlyPlayer.inventory.get(2);
        int buffOrNerf = armorItem.getBuffOrNerf();
        int totalHealth = this.baseHealth + buffOrNerf;
        return totalHealth;
        
    }


    /************Fighting Stats************** */
    public void setStartingFightingHealth(){
        this.fightingHealth = getHealth();
    }

    public void setUpdatedFightingHealth(int healthPoints){
        this.fightingHealth = healthPoints;
    }

    public int getFightingHealth(){
        return fightingHealth;
    }

    public boolean getFightingStatus(){
        return fighting;
    }
    public void setFightingStatus(boolean currentStatus){
        onlyPlayer.fighting = currentStatus;
    }

    /**************************Player Battle Methods*********************/
    public void turn(Player player, Enemy enemy) throws InterruptedException {
        playerChoiceQuesiton();
        playerChoiceAnswer(player, enemy);
    }

    public void playerChoiceQuesiton() throws InterruptedException {
        TypedText.typedNormal("what are you going to do??");
        TypedText.typedFast("Enter one of the following options:");
        System.out.println();
        TypedText.typedFast("1: Attack");
        TypedText.typedFast("2: Heal");
        TypedText.typedFast("3: Run",2);

    }

    public void playerChoiceAnswer(Player player, Enemy enemy) throws InterruptedException {
        int choice = Main.input.nextInt();
        switch(choice){
        case 1:
            attack(player, enemy);
            break;
        
        case 2:
            heal(player, enemy);
            break;
        
        case 3:
            run(player, enemy);
            break;
        
        default:
            TypedText.typedFast("Try again. Choose either attack, heal, or run.\n");
            playerChoiceAnswer(player, enemy);
        break;
        }

    }

    /****************Fighting Behaviors***********************************/
    public void attack(Player player, Enemy enemy) throws InterruptedException {
        ArrayList<String> kindOfAttacks = new ArrayList<String>();
        kindOfAttacks.add("You poked him in his only good eye.");
        kindOfAttacks.add("You attacked with a perfect flying armbar.");
        kindOfAttacks.add("You told him he didn't look fat in those pants...\n"+"He didn't belive you.");
        kindOfAttacks.add("You pulled the pin and tucked a grenade in his back pocket when he wasnt looking.");
        int attackPoints = player.getAttack();
        int oppHealthPoints = enemy.getHealth();
        int updatedHealth = oppHealthPoints - attackPoints;

        Random random = new Random();
        int attackLine = random.nextInt(kindOfAttacks.size());
        System.out.println("\n");
        TimeUnit.SECONDS.sleep(1);
        TypedText.typedFast(kindOfAttacks.get(attackLine));
        TypedText.typedFast("The enemy took "+ attackPoints+" damage.",2);
        System.out.println("\n");
        
        enemy.setHealth(updatedHealth);
        if(enemy.getHealth()<= 0){
            Battle.youWin();
            setFightingStatus(false);
        }
    }

    public void heal(Player player, Enemy enemy) throws InterruptedException{
        if(player.getHealth() > 10){
            int playerHealth = player.getHealth();
            int healedPlayerHealth = playerHealth + 2;
            player.setHealth(healedPlayerHealth);
            System.out.println("\n");
            TimeUnit.SECONDS.sleep(1);
            TypedText.typedFast("The enemy waited while you bandaged yourself.");
            TypedText.typedFast("You gained 2 Health points. Your current Health is "+ healedPlayerHealth+ ".");
            System.out.println("\n");
            
        }
    }

    public void run(Player player, Enemy enemy) throws InterruptedException {
        if(player.getAgility()<= enemy.getAgility()){
            int playerHealth = player.getHealth();
            int damagedPlayerHealth = playerHealth - 1;
            player.setHealth(damagedPlayerHealth);
            System.out.println("\n");
            TimeUnit.SECONDS.sleep(1);
            TypedText.typedFast("You fell and scraped your knee while trying to get away.");
            TypedText.typedFast("You took 1 damage.");
            TypedText.typedFast("Your current health is "+ damagedPlayerHealth);
        }
        if(player.getHealth() <= 0){
            Battle.gameOver();
        }
        TypedText.typedFast("You got away!");
        setFightingStatus(false);
    }

    /***********************Adding Items to Inventory************************* */
    public void addItemToInventory(Item item){

        int arrayLocation = item.getCategory();
        onlyPlayer.inventory.add(arrayLocation, item);
        
    }
}