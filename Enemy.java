import java.util.ArrayList;
import java.util.Random;

public class Enemy extends AbstractCharacter {
   
/*************Constructor *********************************/

public Enemy(String name, int attack, int health, int agility){
    setName(name);
	setAttack(attack);
    setHealth(health);
    setAgility(agility);
    } 
    
/**********************Other Methods***********************************/
public void turn(Player player, Enemy enemy) throws InterruptedException{
    TypedText.typedNormal("Its the enemy's turn.\n",2);

    ArrayList<String> kindOfAttacks = new ArrayList<String>();
    kindOfAttacks.add("The enemy slashs you with a rusty knife");
    kindOfAttacks.add("The enemy started talking to you and didnt brush his teeth");
    kindOfAttacks.add("The enemy cut off your arm with a chainsaw");
    kindOfAttacks.add("The enemy shoved you... like... really hard.");
    Random random = new Random();
    int attackLine = random.nextInt(kindOfAttacks.size());


    int attackPoints = enemy.getAttack();
    int oppHealthPoints = player.getFightingHealth();
    int updatedHealth = oppHealthPoints - attackPoints;
    TypedText.typedFast(kindOfAttacks.get(attackLine));
    TypedText.typedFast("You took "+ attackPoints+ " damage.");
    System.out.println("\n");
    

    player.setUpdatedFightingHealth(updatedHealth);
    if(player.getFightingHealth()<=0){
        Battle.gameOver();
            
        }
    }
}