public abstract class AbstractCharacter {

    /*Instance Variables */
    private int agility;
    private int attack;
    private int health;
    private String name;

    /*getters and setters*/
    public int getAttack(){
        return this.attack;
    }
    public void setAttack(int attackpoints){
        this.attack = attackpoints;
    }

    public int getAgility(){
        return this.agility;
    }
    public void setAgility(int agilitypoints){
        this.agility = agilitypoints;
    }

    public int getHealth(){
        return this.health;
    }
    public void setHealth(int healthpoints){
        this.health = healthpoints;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String characterName){
        this.name = characterName;
    }
    /* methods*/
    public void turn(Player player, Enemy enemy)throws InterruptedException{
        
    }

}