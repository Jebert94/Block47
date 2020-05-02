
public abstract class AbstractEnemy{
    private int attack;
    private int health;
    private boolean isAlive;
/****************getters and setters*****************/
	public int getAttack(){
		return attack;
	}

	public void setAttack(int attackPoints){
		attack = attackPoints;
	}

	public int getHealth(){
		return health;
	}

	public void setHealth(int healthPoints){
		health = healthPoints;
	}

	public boolean getIsAlive(){
		return isAlive;
	}

	public void setisAlive(boolean deadOrAlive){
		isAlive = deadOrAlive;
	}

/*************Constructor *********************************/

	public AbstractEnemy(int attack, int health, Boolean isDead){
	    this.attack = attack;
	    this.health = health;
	    this.isAlive = isDead;
	} 
	
}