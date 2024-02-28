import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI implements ActionListener {


	int longQueue = queueLength(250,350);

	int shortQueue = queueLength(20,35);

	int mediumQueue = queueLength(100,150);
	AQueue<String> concert = new AQueue<String>(longQueue); 
	AQueue<String> theatre = new AQueue<String>(shortQueue);
	AQueue<String> sports = new AQueue<String>(mediumQueue);

	Ticket sportsTickets = new Ticket();
	int sportsAmount = Ticket.getRandomArbitrary(80,130);

	Ticket concertTickets = new Ticket();
	int concertAmount = Ticket.getRandomArbitrary(220, 320);

	Ticket theatreTickets = new Ticket();
	int theatreAmount = Ticket.getRandomArbitrary(20,30);
	private int clicks = 0;
	private JFrame frame = new JFrame();
	private JButton buttonIntro;
	private JButton buttonSport;
	private JButton buttonConcert;
	private JButton buttonTheater;
	private JPanel firstPanel;
	private JPanel secondPanel;
	private JPanel thirdPanel;
	private JPanel fourPanel;
	public static JButton savedUsername;
	int sportButtonClickedNumber = 0;
	int theatreButtonClickedNumber = 0;
	int concertButtonClickedNumber = 0;
	


	public int queueLength(int min, int max) { // randomizing queue length
		return (int) (Math.random() * (max - min + 1)) + min;
	}

	public static int getRandomInt(int min, int max) { // randomizing queue length
		return (int) (Math.random() * (max - min + 1)) + min;
	}

	public GUI() {
		buttonIntro = new JButton("Welcome to TicketMaster! Press to Start");
		buttonIntro.addActionListener(this);

		firstPanel = new JPanel();
		firstPanel.setBorder(BorderFactory.createEmptyBorder(300, 300, 300, 300));
		firstPanel.setLayout(new GridLayout(0, 1));
		firstPanel.add(buttonIntro);
		firstPanel.setBackground(new Color(0, 140, 225));

		secondPanel = new JPanel();
		secondPanel.setBorder(BorderFactory.createEmptyBorder(300, 300, 300, 300));
		secondPanel.setLayout(new GridLayout(0, 1));
		secondPanel.setBackground(new Color(243, 168, 188));

		thirdPanel = new JPanel();
		thirdPanel.setBorder(BorderFactory.createEmptyBorder(300, 300, 300, 300));
		thirdPanel.setLayout(new GridLayout(0, 1));
		thirdPanel.setBackground(new Color(255, 241, 166));

		fourPanel = new JPanel();
		fourPanel.setBorder(BorderFactory.createEmptyBorder(300, 300, 300, 300));
		fourPanel.setLayout(new GridLayout(0, 1));
		fourPanel.setBackground(new Color(245, 173, 148));

		frame.add(firstPanel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("TicketMaster");

		BufferedImage myPicture = null;

		try {
			myPicture = ImageIO.read(new File("ticketmaster.jpg"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		if (myPicture != null) {
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			frame.add(picLabel, BorderLayout.SOUTH); 
		}

		frame.pack();
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		clicks++;
		if (clicks >= 1) {
			buttonIntro.setVisible(false);
			firstPanel.removeAll();
			firstPanel.repaint();

			buttonSport = new JButton("SPORTS");
			buttonSport.setFont(new Font("Serif", Font.BOLD, 20));
			buttonSport.setBounds(100, 225, 200, 200);
			buttonSport.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					buttonSportActionPerformed(e);
				}
			});
			firstPanel.setLayout(null);
			firstPanel.add(buttonSport);


			buttonConcert = new JButton("CONCERT");
			buttonConcert.setFont(new Font("Serif", Font.BOLD, 20));
			buttonConcert.setBounds(600, 225, 200, 200);
			buttonConcert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonConcertActionPerformed(e);
				}
			});
			firstPanel.setLayout(null);
			firstPanel.add(buttonConcert);

			buttonTheater = new JButton("THEATER");
			buttonTheater.setFont(new Font("Serif", Font.BOLD, 20));
			buttonTheater.setBounds(350, 225, 200, 200);
			buttonTheater.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonTheatreActionPerformed(e);
				}
			});
			firstPanel.setLayout(null);
			firstPanel.add(buttonTheater);



			JTextField whatShow = new JTextField("What Show Would You Like to Attend?");
			whatShow.setFont(new Font("Sans Serif", Font.BOLD, 30));
			whatShow.setBounds(35,20,800,90);
			whatShow.setBackground(new Color(0, 140, 225));
			whatShow.setBorder(null);
			firstPanel.add(whatShow);

			firstPanel.revalidate();
			firstPanel.repaint();
		}
	}

	public void buttonSportActionPerformed(ActionEvent e) {
		clicks++;
		sportButtonClickedNumber++;
		if (clicks >= 1) {
			firstPanel.setVisible(false);

			frame.add(thirdPanel, BorderLayout.CENTER);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("TicketMaster");
			thirdPanel.setVisible(true);

			JTextField textAskingInputUsername = new JTextField("Please enter your username:");
			textAskingInputUsername.setFont(new Font("Sans Serif", Font.BOLD, 20));
			thirdPanel.setLayout(null);
			textAskingInputUsername.setBounds(22,13,600,90);
			textAskingInputUsername.setBackground(new Color(255, 241, 166));
			textAskingInputUsername.setBorder(null);
			thirdPanel.add(textAskingInputUsername);

			JTextField textBoxForUsernameInput = new JTextField();
			textBoxForUsernameInput.setFont(new Font("Sans Serif", Font.PLAIN, 20));
			textBoxForUsernameInput.setBounds(22, 103, 400, 37);
			thirdPanel.add(textBoxForUsernameInput);

			JButton buttonSavedUsername = new JButton("Save Username");
			buttonSavedUsername.setFont(new Font("Sans Serif", Font.PLAIN, 17));
			buttonSavedUsername.setBounds(22, 150, 150, 30);
			buttonSavedUsername.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String savedUsername = textBoxForUsernameInput.getText();
					System.out.println("Saved Username: " + savedUsername);
					sportButtonClickedNumber++;
					if (sportButtonClickedNumber >= 2) {
						for (int i = 0; i < mediumQueue; i++) {
							sports.enqueue("a");
						}

						TicketTimer t1 = new TicketTimer(concert, theatre, sports, concertAmount, theatreAmount, sportsAmount, concertButtonClickedNumber, theatreButtonClickedNumber, sportButtonClickedNumber);
						JTextField textStatingPositioninQueue = new JTextField("Your Position in the Queue: " + mediumQueue);
						textStatingPositioninQueue.setFont(new Font("Sans Serif", Font.BOLD, 23));
						thirdPanel.setLayout(null);
						textStatingPositioninQueue.setBounds(100,290,600,90);
						textStatingPositioninQueue.setBackground(new Color(255, 241, 166));
						textStatingPositioninQueue.setBorder(null);
						thirdPanel.add(textStatingPositioninQueue);


						Timer refreshSport = new Timer(2000, new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								textStatingPositioninQueue.setText("Your Position in the Queue: " + sports.length());
								if (sports.length() == 0) {
									((Timer) e.getSource()).stop();
									if (t1.getSports() > 0) {
										JTextField yesTickets = new JTextField(savedUsername + " ,choose your seats (max 3)");
										thirdPanel.setLayout(null);
										yesTickets.setBounds(100, 390, 600, 90);
										yesTickets.setBackground(new Color(255, 241, 166));
										yesTickets.setBorder(null);
										thirdPanel.add(yesTickets);
										new Seating();
									}
									if (t1.getSports() <= 0) {
										JTextField noTickets = new JTextField(savedUsername + ", sorry, no tickets remaining!");
										thirdPanel.setLayout(null);
										noTickets.setBounds(100, 390, 600, 90);
										noTickets.setBackground(new Color(255, 241, 166));
										noTickets.setBorder(null);
										thirdPanel.add(noTickets);
									}
								}
							}

						});
						refreshSport.start();
					}
				}
			});
			thirdPanel.add(buttonSavedUsername);
		}


	}

	public void buttonConcertActionPerformed(ActionEvent e) {
		clicks++;
		concertButtonClickedNumber++;
		if (clicks >= 1) {
			firstPanel.setVisible(false);

			frame.add(secondPanel, BorderLayout.CENTER);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("TicketMaster");
			secondPanel.setVisible(true);

			JTextField textAskingInputUsername = new JTextField("Please enter your username:");
			textAskingInputUsername.setFont(new Font("Sans Serif", Font.BOLD, 20));
			secondPanel.setLayout(null);
			textAskingInputUsername.setBounds(22,13,600,90);
			textAskingInputUsername.setBackground(new Color(243, 168, 188));
			textAskingInputUsername.setBorder(null);
			secondPanel.add(textAskingInputUsername);

			JTextField textBoxForUsernameInput = new JTextField();
			textBoxForUsernameInput.setFont(new Font("Sans Serif", Font.PLAIN, 20));
			textBoxForUsernameInput.setBounds(22, 103, 400, 37);
			secondPanel.add(textBoxForUsernameInput);

			JButton buttonSavedUsername = new JButton("Save Username");
			buttonSavedUsername.setFont(new Font("Sans Serif", Font.PLAIN, 17));
			buttonSavedUsername.setBounds(22, 150, 150, 30);
			buttonSavedUsername.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String savedUsername = textBoxForUsernameInput.getText();
					System.out.println("Saved Username: " + savedUsername);
					concertButtonClickedNumber++;
					if (concertButtonClickedNumber >= 2) {
						for (int i = 0; i < longQueue; i++) {
							concert.enqueue("a");
						}

						TicketTimer t2 = new TicketTimer(concert, theatre, sports, concertAmount, theatreAmount, sportsAmount, concertButtonClickedNumber, theatreButtonClickedNumber, sportButtonClickedNumber);
						JTextField textStatingPositioninQueue = new JTextField("Your Position in the Queue: " + longQueue);
						textStatingPositioninQueue.setFont(new Font("Sans Serif", Font.BOLD, 23));
						secondPanel.setLayout(null);
						textStatingPositioninQueue.setBounds(100,290,600,90);
						textStatingPositioninQueue.setBackground(new Color(243, 168, 188));
						textStatingPositioninQueue.setBorder(null);
						secondPanel.add(textStatingPositioninQueue);


						Timer refreshConcert = new Timer(2000, new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								System.out.println(concert.length());
								textStatingPositioninQueue.setText("Your Position in the Queue: " + concert.length());
								if (concert.length() == 0) {
									((Timer) e.getSource()).stop();
									if (t2.getConcert() > 0) {
										JTextField yesTickets = new JTextField(savedUsername + " , choose your seats(max 3)");
										secondPanel.setLayout(null);
										yesTickets.setBounds(100, 390, 600, 90);
										yesTickets.setBackground(new Color(245, 173, 148));
										yesTickets.setBorder(null);
										secondPanel.add(yesTickets);
										new Seating();
									}
									if (t2.getConcert() <= 0) {
										JTextField noTickets = new JTextField(savedUsername + " , sorry, no tickets remaining!");
										secondPanel.setLayout(null);
										noTickets.setBounds(100, 390, 600, 90);
										noTickets.setBackground(new Color(245, 173, 148));
										noTickets.setBorder(null);
										secondPanel.add(noTickets);
									}
								}
							}

						});
						refreshConcert.start();
					}
				}
			});
			secondPanel.add(buttonSavedUsername);
		}


	}

	public void buttonTheatreActionPerformed(ActionEvent e) {
		clicks++;
		theatreButtonClickedNumber++;
		if (clicks >= 1) {
			firstPanel.setVisible(false);

			frame.add(fourPanel, BorderLayout.CENTER);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("TicketMaster");
			fourPanel.setVisible(true);

			JTextField textAskingInputUsername = new JTextField("Please enter your username:");
			textAskingInputUsername.setFont(new Font("Sans Serif", Font.BOLD, 20));
			fourPanel.setLayout(null);
			textAskingInputUsername.setBounds(22,13,600,90);
			textAskingInputUsername.setBackground(new Color(245, 173, 148));
			textAskingInputUsername.setBorder(null);
			fourPanel.add(textAskingInputUsername);

			JTextField textBoxForUsernameInput = new JTextField();
			textBoxForUsernameInput.setFont(new Font("Sans Serif", Font.PLAIN, 20));
			textBoxForUsernameInput.setBounds(22, 103, 400, 37);
			fourPanel.add(textBoxForUsernameInput);

			JButton buttonSavedUsername = new JButton("Save Username");
			buttonSavedUsername.setFont(new Font("Sans Serif", Font.PLAIN, 17));
			buttonSavedUsername.setBounds(22, 150, 150, 30);
			buttonSavedUsername.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String username = textBoxForUsernameInput.getText();
					theatreButtonClickedNumber++; //send to the other if statement
					if (theatreButtonClickedNumber >= 2) {
						for (int i = 0; i < shortQueue; i++) {
							theatre.enqueue("a");
						}

						TicketTimer t3 = new TicketTimer(concert, theatre, sports, concertAmount, theatreAmount, sportsAmount, concertButtonClickedNumber, theatreButtonClickedNumber, sportButtonClickedNumber);
						JTextField textStatingPositioninQueue = new JTextField("Your Position in the Queue: " + shortQueue);
						textStatingPositioninQueue.setFont(new Font("Sans Serif", Font.BOLD, 23));
						fourPanel.setLayout(null);
						textStatingPositioninQueue.setBounds(100,290,600,90);
						textStatingPositioninQueue.setBackground(new Color(245, 173, 148));
						textStatingPositioninQueue.setBorder(null);
						fourPanel.add(textStatingPositioninQueue);


						Timer refresh = new Timer(2000, new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								textStatingPositioninQueue.setText("Your Position in the Queue: " + theatre.length());
								if (theatre.length() == 0) {
									((Timer) e.getSource()).stop();
									if (t3.getTheatre() > 0) {
										JTextField yesTickets = new JTextField(username + ", choose your seats(max 3)");
										fourPanel.setLayout(null);
										yesTickets.setBounds(100, 390, 600, 90);
										yesTickets.setBackground(new Color(245, 173, 148));
										yesTickets.setBorder(null);
										fourPanel.add(yesTickets);
										new Seating();
									}
									if (t3.getTheatre() <= 0) {
										JTextField noTickets = new JTextField(username + ", sorry, no tickets remaining!");
										fourPanel.setLayout(null);
										noTickets.setBounds(100, 390, 600, 90);
										noTickets.setBackground(new Color(245, 173, 148));
										noTickets.setBorder(null);
										fourPanel.add(noTickets);
										
									}
								}
							}

						});
						refresh.start();

					}
				}
			});
			fourPanel.add(buttonSavedUsername);
		}
	}


	public static void main(String[] args) {
		GUI g = new GUI();
	}
}
