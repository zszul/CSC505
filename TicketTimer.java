import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.Timer;

public class TicketTimer implements ActionListener {

	private Timer t;
	Queue<String> concert;
	Queue<String> theatre;
	Queue<String> sports;
	int concertAmount;
	int theatreAmount;
	int sportsAmount;
	String ticketT;


	public TicketTimer(AQueue<String> c, AQueue<String> th, AQueue<String> s, int concertA, int theatreA, int sportsA, String ticketT) {
		t = new Timer(2000, this);
		concert = c;
		theatre = th;
		sports = s;
		concertAmount = concertA;
		theatreAmount = theatreA;
		sportsAmount = sportsA;

	}
	public static int random(int min, int max) { // randomizing queue length
		return (int) (Math.random() * (max - min + 1)) + min;
	}



	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < random(1,5); i++) {
			if (ticketT == "concert") {
				concert.dequeue();
				concertAmount--;
			}
			if (ticketT == "theatre") {
				theatre.dequeue();
				theatreAmount--;
			}
			if (ticketT == "sports") {
				sports.dequeue();
				sportsAmount--;
			}
		}

	}
	public int getConcert() {
		return concertAmount;
	}
	public int getTheatre() {
		return theatreAmount;
	}
	public int getSports() {
		return sportsAmount;
	}

}
