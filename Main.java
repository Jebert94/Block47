import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    
    public static void clearScreen(){
        for(int i = 0; i<50; i++){
            System.out.println();
        }
    }

	public static void main(String[] args) throws InterruptedException {
        Intro intro = new Intro();  
        Intro.introduction();
        intro.title();
        Player player = Player.getInstance();
        Intro.background();
        intro.createPlayerName(player);
        intro.createPlayerStats(player);
        Gameplay.mainGameplay();
        input.close();


        //Battle.runGameOver();
    }
}