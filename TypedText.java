import java.util.Random;



public class TypedText {

    public static void typedInstant(String line){
        for(int i =0; i<line.length();i++){
            System.out.print(line.charAt(i));
            try {
                Thread.sleep(0); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void typedNormal(String line){
        for(int i =0; i<line.length();i++){
            System.out.print(line.charAt(i));
            try {
                Thread.sleep(100); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void typedSlow(String line){
        for(int i =0; i<line.length();i++){
            System.out.print(line.charAt(i));
            try {
                Thread.sleep(200); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void typedRandom(String line){
        Random rand = new Random();
        for(int i =0; i<line.length();i++){
            System.out.print(line.charAt(i));
            int time = rand.nextInt(200);
            try {
                Thread.sleep(time); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void typedFast(String line){
        for(int i =0; i<line.length();i++){
            System.out.print(line.charAt(i));
            try {
                Thread.sleep(50); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void typedSarcasticly(String line){
        for(int i =0; i<line.length();i++){
            if(i % 2 == 0){
                char evenLetter = line.charAt(i);
                char lower = Character.toLowerCase(evenLetter);
                System.out.print(lower);
            }
            else{
                char oddLetter = line.charAt(i);
                char upper = Character.toUpperCase(oddLetter);
                System.out.print(upper);
            }
            
            try {
                Thread.sleep(200); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}