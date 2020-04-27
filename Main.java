public class Main
{

    public static void main(String[] args) throws InterruptedException {
        System.out.print("\033[H\033[2J");
        Intro intro = new Intro();
        intro.description();
        Player player = Player.getInstance();
        intro.createPlayerName(player);
        intro.createPlayerStats(player);
    }


}
