public class RoomEnemy extends Room {
    private Enemy enemyInRoom;

    RoomEnemy(String roomDescription, String enemyName, int enemyAttack, int enemyHealth, int enemyAgility)  {
        super(roomDescription);
        Enemy enemy = new Enemy(enemyName, enemyAttack, enemyHealth, enemyAgility);
        this.enemyInRoom = enemy;
    }
    @Override
    public void enter() throws InterruptedException {
        TypedText.typedFast(getRoomDescription());
        Battle battle = new Battle(Player.getInstance(), this.enemyInRoom);
        battle.fight();
        setAlreadyBeenInRoom(true);
    }
}