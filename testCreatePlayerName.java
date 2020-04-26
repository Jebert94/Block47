public class testCreatePlayerName {
    public static void main(String[] args) throws InterruptedException {
        System.out.print("\033[H\033[2J\n");
        testIntro intro = new testIntro();
        // Intro.description();
        Player player = Player.getInstance();
        intro.createPlayerName(player);
        intro.createPlayerStats(player);
    }
}