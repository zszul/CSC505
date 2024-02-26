import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GUI implements ActionListener {
    private int clicks = 0;
    private JFrame frame = new JFrame();
    private JButton buttonIntro;
    private JButton buttonSport;
    private JButton buttonConcert;
    private JButton buttonTheater;
    private JPanel firstPanel;

    public GUI() {
        buttonIntro = new JButton("Welcome to TicketMaster! Press to Start");
        buttonIntro.addActionListener(this);

        firstPanel = new JPanel();
        firstPanel.setBorder(BorderFactory.createEmptyBorder(300, 300, 300, 300));
        firstPanel.setLayout(new GridLayout(0, 1));
        firstPanel.add(buttonIntro);
        firstPanel.setBackground(new Color(0, 140, 225));

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
            buttonSport.addActionListener(this);
            firstPanel.setLayout(null);
            firstPanel.add(buttonSport);

            buttonConcert = new JButton("CONCERT");
            buttonConcert.setFont(new Font("Serif", Font.BOLD, 20));
            buttonConcert.setBounds(600, 225, 200, 200);
            buttonConcert.addActionListener(this);
            firstPanel.setLayout(null);
            firstPanel.add(buttonConcert);

            buttonTheater = new JButton("THEATER");
            buttonTheater.setFont(new Font("Serif", Font.BOLD, 20));
            buttonTheater.setBounds(350, 225, 200, 200);
            buttonTheater.addActionListener(this);
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

    public static void main(String[] args) {
        new GUI();
    }
}
