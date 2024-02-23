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
    private JButton button;

    public GUI() {
        // the clickable button
        button = new JButton("Welcome to TicketMaster! Press to Start");
        button.addActionListener(this);

        // the panel with the button and text
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 300, 300));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.setBackground(new Color(2, 108, 223));

        // set up the frame and display it
        frame.add(panel, BorderLayout.CENTER);
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

    // process the button clicks
    public void actionPerformed(ActionEvent e) {
        clicks++;
        if (clicks >= 1) {
            button.setVisible(false);
        }
    }


    public static void main(String[] args) {
        new GUI();
    }
}
