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
    ArrayList<Item> inventory = new ArrayList<Item>(3);

    /****************** Singleton Design Pattern**********************/
    private static Player onlyPlayer;

    private Player(){
    }

    public static Player getInstance() {
        if(onlyPlayer == null){
            onlyPlayer = new Player();
        }
        return onlyPlayer;
    }

    //*****************/ Getters and Setters **************************
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


    public int getAttack(){
        Item attackItem = onlyPlayer.inventory.get(0);
        if(attackItem == null){
            return this.baseAttack;
        }
        else{
            int buffOrNerf = attackItem.getBuffOrNerf();
            return this.baseAttack + buffOrNerf;
        }
    }


    public int getAgility(){
        Item agilityItem = onlyPlayer.inventory.get(1);
        if(agilityItem == null){
            return this.baseAgility;
        }
        else{
            int buffOrNerf = agilityItem.getBuffOrNerf();
            return this.baseAgility + buffOrNerf;
        }
    }


    public int getHealth(){
        Item armorItem = onlyPlayer.inventory.get(2);
        if(armorItem == null){
            return this.baseHealth;
        }
        else{
            int buffOrNerf = armorItem.getBuffOrNerf();
            return this.baseHealth + buffOrNerf;
        }
    }


    public String getName() {
        return onlyPlayer.name;
    }
    public void setName(String assignedName){
        onlyPlayer.name = assignedName;
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
        TypedText.typedFast("Attack");
        TypedText.typedFast("Heal");
        TypedText.typedFast("Run",2);

    }

    public void playerChoiceAnswer(Player player, Enemy enemy) throws InterruptedException {
        String choice = Main.input.nextLine();
        String normalizedChoice = choice.toLowerCase();
        if(normalizedChoice.equals("attack")){
            attack(player, enemy);
        }
        if (normalizedChoice.equals("heal")) {
            heal(player, enemy);
        }
        if(normalizedChoice.equals("run")){
            run(player, enemy);
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