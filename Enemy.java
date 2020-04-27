
public class Enemy extends Player{
    private int attack;
    private int health;
    private int isDead;
    private String Junkie;
    private String SuperJunkie;
    private String MegaJunkie;

	public Enemy(int attack, int health, int isdead){
	    attack = attack;
	    health = health;
	    isdead = isdead;
	} 
	private int healthChange(int change, int health){
		if (change < health) {
			return 0;
		}
		if (health <= 0) {
			return isdead;
		}
		return change;
		
	}
	public void Junkie(int attack, int health) {
		attack = 1;
		health = 1;
	}
	
	public void SuperJunkie(int attack, int health) {
		attack = 1;
		health = 2;
	}
	
	public void MegaJunkie(int attack, int health) {
		attack = 2;
		health = 3;
	}
	public void battle(Player, int attack, int health)
	
}