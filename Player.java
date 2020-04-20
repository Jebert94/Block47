import java.util.ArrayList;

public class Player {
    private String name;
    private int attack;
    private int agility;
    private int health;
    ArrayList<Iitems> inventory = new ArrayList<Iitems>();

    private static Player onlyPlayer;

    private Player(){
        this.attack = 0;
        this.agility = 0;
        this.health = 5;
    }

    public static Player getInstance(){
        if(onlyPlayer == null){
            onlyPlayer = new Player();
        }
        return onlyPlayer;
    }

    //**************** */ getters and setters **************************
    public int getAttack(){
        return onlyPlayer.attack;
    }
    public void setAttack(int attackpoints){
        onlyPlayer.attack = attackpoints;
    }


    public int getAgility(){
        return onlyPlayer.agility;
    }
    public void setAgility(int agilitypoints){
        onlyPlayer.agility = agilitypoints;
    }


    public int getHealth(){
        return onlyPlayer.health;
    }
    public void setHealth(int healthpoints){
        onlyPlayer.health = healthpoints;
    }


    public String getName(){
        return onlyPlayer.name;
    }
    public void setName(String assignedName){
        onlyPlayer.name = assignedName;
    }


}