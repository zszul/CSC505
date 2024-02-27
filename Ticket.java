import java.lang.Math;

public class Ticket {
    public static int getRandomArbitrary(int min, int max) { //Generating how many tickets are possible
        return (int) (Math.random() * (max - min + 1)) + min;
    }
    
}
