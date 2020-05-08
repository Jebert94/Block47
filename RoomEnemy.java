public class RoomEnemy extends Room {
    private Enemy enemyInRoom;

    RoomEnemy(String roomDescription, String enemyName, int enemyAttack, int enemyHealth, int enemyAgility) throws InterruptedException {
        super(roomDescription);
        Enemy enemy = new Enemy(enemyName, enemyAttack, enemyHealth, enemyAgility);
        this.enemyInRoom = enemy;
    }
    @Override
    public void enter() throws InterruptedException {
        TypedText.typedFast(this.roomDescription);
        Battle battle = new Battle(Player.getInstance(), this.enemyInRoom);
        battle.fight();
        this.alreadyBeenInRoom = true;
    }
}