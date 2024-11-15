import java.awt.event.*;
import javax.swing.*;

public class hangman {
    
    public static void sleep(int time)
    {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        JFrame f = new JFrame("Password Field Example");

        JPasswordField value = new JPasswordField();
        JLabel l1 = new JLabel("Enter Word:", JLabel.CENTER);
        JLabel l2 = new JLabel("", JLabel.CENTER);
        JButton start = new JButton("Start");

        f.setLayout(null);

        int frameWidth = 600;  // Doubled width
        int frameHeight = 600; // Doubled height
        int labelWidth = 200;  // Doubled label width
        int fieldWidth = 300;  // Doubled password field width

        // Calculate the horizontal center for the label and password field
        
        int sizeW = 200;
        int sizeH = 60;
        int frameLoca = 60;
        // Set bounds for the components
        

        l1.setBounds(((frameWidth - sizeW) / 2), (frameLoca + (frameLoca + 10) * 1), sizeW, sizeH);  // Adjust vertical spacing (y = 150)
        value.setBounds(((frameWidth - sizeW) / 2), (frameLoca + (frameLoca + 10) * 2), sizeW, sizeH);  // Adjust vertical spacing (y = 220)
        l2.setBounds(((frameWidth - sizeW) / 2), (frameLoca + (frameLoca + 10) * 4), sizeW, sizeH);
        start.setBounds(((frameWidth - sizeW) / 2), (frameLoca + (frameLoca + 10) * 3), sizeW, sizeH);
    
        //l2.center();

        f.add(l1);
        f.add(value);
        f.add(l2);
        f.add(start);

        value.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char typedChar = e.getKeyChar();

                // Allow only letters or backspace
                if (Character.isLetter(typedChar) || typedChar == KeyEvent.VK_BACK_SPACE) {
                    if (value.getPassword().length >= 7 && typedChar != KeyEvent.VK_BACK_SPACE) {
                        e.consume();  // Prevent typing when max length reached
                        System.out.println("Maximum length reached! Only 7 characters allowed.");
                        l2.setText("Maximum length reached! Only 7 characters allowed.");
                    } else {
                        if (Character.isLetter(typedChar)) {
                            System.out.println("Typed: " + typedChar);
                        } else {
                            System.out.println("Typed: BackSpace");
                            l2.setText("Typed: BackSpace");
                        }
                    }
                } else {
                    e.consume();  // Consume invalid key events (numbers, symbols, etc.)
                    System.out.println("Invalid character! No numbers or spaces allowed.");
                    l2.setText("Invalid character! No numbers or spaces allowed.");
                }
            }
        });
        value.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = new String(value.getPassword());

                // Check if the input is exactly 7 letters and contains no spaces or numbers
                if (input.length() == 7 && input.matches("[a-zA-Z]+")) {
                    System.out.println("Valid 7-letter word: " + input);
                } else {
                    System.out.println("Invalid input! Please enter exactly 7 letters with no spaces or numbers.");
                }
            }
        });

        /*start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // What happens when the button is clicked
                JOptionPane.showMessageDialog(frame, "Button was clicked!");
            }
        });*/

        f.setSize(frameWidth, frameHeight);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
