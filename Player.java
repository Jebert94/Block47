import java.util.ArrayList;

public class Player extends AbstractCharacter{
    private String name;
    private int attack;
    private int agility;
    private int health;
    //ArrayList<Iitems> inventory = new ArrayList<Iitems>();

    private static Player onlyPlayer;

    public Player(){
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


    public String getName(){
        return onlyPlayer.name;
    }
    public void setName(String assignedName){
        onlyPlayer.name = assignedName;
    }


}