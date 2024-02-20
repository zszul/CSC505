import java.lang.Math;

public class Tickets {
double concert; 
double theatre;    
double sports;

public class concert {
    int getRandomArbitrary(int min, int max) { //Generating how many tickets are possible
        return (int) (Math.random() * (max - min + 1)) + min;
    }

public class theatre {
    int getRandomArbitrary(int min, int max) { //Generating how many tickets are possible
        return (int) (Math.random() * (max - min + 1)) + min;
    }

public class sports {
    int getRandomArbitrary(int min, int max) { //Generating how many tickets are possible
        return (int) (Math.random() * (max - min + 1)) + min;
    }    
}
}}}