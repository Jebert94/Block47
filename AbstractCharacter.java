public abstract class AbstractCharacter {
    private int agility;
    private int attack;
    private int health;

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
    public void attack(AbstractCharacter attacker, AbstractCharacter defender){
        int attackPoints = attacker.getAttack();
        int oppHealthPoints = defender.getHealth();
        int updatedHealth = oppHealthPoints - attackPoints;
        defender.setHealth(updatedHealth);
    }


}