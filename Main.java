import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
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
        
        Ticket sportsTickets = new Ticket();
        int sportsAmount = Ticket.getRandomArbitrary(80,130);
        
        Ticket concertTickets = new Ticket();
        int concertAmount = Ticket.getRandomArbitrary(220, 320);
        
        Ticket theatreTickets = new Ticket();
        int theatreAmount = Ticket.getRandomArbitrary(10,30);
        
        
        if (ticketT == "concert") {
        	for (int i = 0; i < longQueue; i++) {
        		concert.enqueue("a");
        	}
        	concert.enqueue(username);
        }
        if (ticketT == "theatre") {
        	for (int i = 0; i < shortQueue; i++) {
        		theatre.enqueue("a");
        	}
        	theatre.enqueue(username);
        }
        if (ticketT == "sports") {
        	for (int i  = 0; i < mediumQueue; i++) {
        		sports.enqueue("a");
        	}
        	sports.enqueue(username);
        }
        
        
        TicketTimer t = new TicketTimer(concert, theatre, sports, concertAmount, theatreAmount, sportsAmount, ticketT);
        if (ticketT == "concert" && t.getConcert() <= 0) {
        	System.out.println("Queue is full");
        }
        if (ticketT == "theatre" && t.getTheatre() <= 0) {
        	System.out.println("Queue is full");
        }
        if (ticketT == "sports" && t.getSports() <= 0) {
        	System.out.println("Queue is full");
        }
        
      
      }
    public static int queueLength(int min, int max) { // randomizing queue length
        return (int) (Math.random() * (max - min + 1)) + min;
    }
   
    
    
}


