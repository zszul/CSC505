import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("what type of ticket would you like: concert, theatre or sports");
    
        String ticketT = myObj.nextLine();  // Read user input
        System.out.println("ticket type is: " + ticketT);  // Output user input
                String username = "a"; // change this later to a scanner input

    	int longQueue = queueLength(250,350);
    	
    	int shortQueue = queueLength(20,40);
    	
    	int mediumQueue = queueLength(100,150);
        AQueue<String> concert = new AQueue<String>(longQueue); 
        AQueue<String> theatre = new AQueue<String>(shortQueue);
        AQueue<String> sports = new AQueue<String>(mediumQueue);
        
        if (ticketT == "concert") {
        	concert.enqueue(username);
        }
        if (ticketT == "theatre") {
        	theatre.enqueue(username);
        }
        if (ticketT == "sports") {
        	sports.enqueue(username);
        }
        
      }
    public static int queueLength(int min, int max) { // randomizing queue length
        return (int) (Math.random() * (max - min + 1)) + min;
    }
      }
      //purchase
      //


    }



