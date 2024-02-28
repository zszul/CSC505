import java.awt.*;
import java.awt.event.ActionEvent; // Add import for ActionEvent
import java.awt.event.ActionListener; // Add import for ActionListener
import javax.swing.*;
public class Seating {
    
    JFrame frameObj;
    JButton[][] seats;
    boolean[][] seatAvailability; // to keep track of seat availability
    

    // constructor  
    Seating()  {    
        frameObj = new JFrame();    
        
        // Creating buttons to represent seats
        seats = new JButton[3][3];
        seatAvailability = new boolean[3][3]; // initializing seat availability matrix
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                seats[i][j] = new JButton((i*3 + j + 1) + ""); // Seat number
                seats[i][j].addActionListener(new SeatListener(i, j)); // Add action listener
                seats[i][j].setBackground(Color.GREEN);
                seats[i][j].setOpaque(true);
                seats[i][j].setBorderPainted(false);
                seats[i][j].setFont(seats[i][j].getFont().deriveFont(Font.BOLD)); 
                frameObj.add(seats[i][j]);
                seatAvailability[i][j] = true; // Initially, all seats are available
            }
        }
        
        // Setting the grid layout   
        frameObj.setLayout(new GridLayout(3, 3, 20, 25));    
        frameObj.setSize(300, 300);    
        frameObj.setVisible(true);    

        
    }  
    
    // ActionListener for seat buttons
    class SeatListener implements ActionListener {
        int row, col;
        
        public SeatListener(int row, int col) {
            this.row = row;
            this.col = col;
        }
        
        public void actionPerformed(ActionEvent e) {
            if (seatAvailability[row][col]) {
                // Assign the ticket
                seatAvailability[row][col] = false; // mark seat as unavailable
                seats[row][col].setBackground(Color.RED); // visually indicate the seat is taken
                seats[row][col].setOpaque(true);
                JOptionPane.showMessageDialog(null, "Ticket assigned to Seat " + (row*3 + col + 1));
            } else {
                JOptionPane.showMessageDialog(null, "Seat " + (row*3 + col + 1) + " is already taken!");
            }
        }
    }
    
    // main method  
    public static void main(String args[]) {    
        new Seating();    
    }    
}
