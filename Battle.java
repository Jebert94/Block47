
public class Battle {

    public void fight(Player player, Enemy enemy){
        AbstractCharacter firstToAttack = fasterAgility(player, enemy);
        while()
    }

    public AbstractCharacter fasterAgility(Player player, Enemy enemy){
        int playerAgility = player.getAgility();
        int enemyAgility = enemy.getAgility();
        if (playerAgility >= enemyAgility){
            return player;
        }
        else{
            return enemy;
        }
    }

    public void playerChoice{
        
    }
}