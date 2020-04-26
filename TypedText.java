import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TypedText {
    private static int defaultWaitTime1 = 1;
    private static int defaultWaitTime2 = 2;


/* 
* Overrided methods typedFast(), typedNormal(), and typedSlow() to act like they have optional peramiters.
* The optional perameter being a int called waitTime
* It's pourpose is to determine how long to wait until printing a new line
*/

    public static void typedFast(String line, int waitTime) throws InterruptedException {
        for(int i =0; i<line.length();i++){
            System.out.print(line.charAt(i));
            try {
                Thread.sleep(50); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        TimeUnit.SECONDS.sleep(waitTime);
        System.out.println();
    }

    public static void typedFast(String line) throws InterruptedException {
        typedFast(line, defaultWaitTime1);
        
    }





    public static void typedNormal(String line, int waitTime) throws InterruptedException {
        for(int i =0; i<line.length();i++){
            System.out.print(line.charAt(i));
            try {
                Thread.sleep(100); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        TimeUnit.SECONDS.sleep(waitTime);
        System.out.println();
    }
    public static void typedNormal(String line) throws InterruptedException {
        typedNormal(line, defaultWaitTime2);
    }






    public static void typedSlow(String line, int waitTime) throws InterruptedException {
        for(int i =0; i<line.length();i++){
            System.out.print(line.charAt(i));
            try {
                Thread.sleep(200); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        TimeUnit.SECONDS.sleep(waitTime);
        System.out.println();
    }

    public static void typedSlow(String line) throws InterruptedException {
        typedSlow(line, defaultWaitTime2);
    }





    public static void typedRandom(String line) throws InterruptedException {
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
        TimeUnit.SECONDS.sleep(defaultWaitTime1);
        System.out.println();
    }




    public static void typedSarcasticly(String line) throws InterruptedException {
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
        TimeUnit.SECONDS.sleep(defaultWaitTime1);
        System.out.println();
    }
}