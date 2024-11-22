import java.awt.event.*;
import javax.swing.*;

public class Game {

    public static String word = hangman.word;
    public static void game() {
         JFrame frame = new JFrame("guess");
        
        // Setting the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting the size of the frame
        frame.setSize(600, 600);
        // Setting the frame to be visible
        frame.setVisible(true);
        // IMAg
        
        //
        //
        //

        JFrame Mage = new JFrame("The hanging man");
        // Setting the default close operation
        Mage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String a = "hangman/Stand.png";
        ImageIcon imgIcon = new ImageIcon(a);
        JLabel label = new JLabel(imgIcon);
        Mage.add(label);
        // Setting the size of the frame
        Mage.setSize(220, 201);
        // Setting the frame to be visible
        Mage.setVisible(true);

        //
        //
        //
        JFrame q = new JFrame("quit");
        JButton Quit = new JButton("Quit");
        q.setSize(400, 100);
        q.setLayout(null);
        q.setVisible(true);

        Quit.setBounds(0, 0, 400,100);
        q.add(Quit);

        Quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}