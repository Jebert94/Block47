import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {
        System.out.print("\033[H\033[2J"+"\n");
        Intro intro = new Intro();  
        //Intro.introduction();
        Player player = Player.getInstance();
        intro.createPlayerName(player);
        //Intro.background();
        intro.createPlayerStats(player);
        Enemy lvl1Enemy = new Enemy(2, 5, 1);
        Battle firstFight = new Battle(player, lvl1Enemy);
        firstFight.fight();
        Enemy lvl2Enemy = new Enemy(1, 3, 3);
        Battle secondFight = new Battle(player,lvl2Enemy);
        secondFight.fight();
        input.close();
    }
}