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
        Gameplay.mainGameplay();

        input.close();
    }
}