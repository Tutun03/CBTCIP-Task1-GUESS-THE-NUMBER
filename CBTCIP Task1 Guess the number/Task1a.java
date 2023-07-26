import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Task1a extends JFrame {
    private JTextField tfusername;
    private JButton login;
    private int attemptsLeft;
    private final int MAX_ATTEMPTS = 5;
    private int userScore;

    Task1a() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel iblusername = new JLabel(" Enter the no ");
        iblusername.setBounds(40, 20, 600, 30);
        add(iblusername);

        tfusername = new JTextField();
        tfusername.setBounds(200, 20, 150, 30);
        add(tfusername);

        login = new JButton("click");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);

        attemptsLeft = MAX_ATTEMPTS;
        userScore = 0;
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }

    private void checkGuess() {
        if (attemptsLeft == 0) {
            JOptionPane.showMessageDialog(this, "You have used all your attempts! Your final score: " + userScore, "Game Over", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String userInput = tfusername.getText().trim();

        if (!userInput.isEmpty()) {
            try {
                int userNumber = Integer.parseInt(userInput);
                int randomNumber = generateRandomNumber();

                attemptsLeft--;

                if (userNumber == randomNumber) {
                    JOptionPane.showMessageDialog(this, "Congratulations! You guessed correctly. Attempts left: " + attemptsLeft, "Result", JOptionPane.INFORMATION_MESSAGE);
                    calculateScore();
                } else if (userNumber > randomNumber) {
                    JOptionPane.showMessageDialog(this, "Your guess is greater than the actual number. Attempts left: " + attemptsLeft, "Result", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Your guess is lesser than the actual number. Attempts left: " + attemptsLeft, "Result", JOptionPane.INFORMATION_MESSAGE);
                }

                if (attemptsLeft == 0) {
                    login.setEnabled(false);
                    JOptionPane.showMessageDialog(this, "You have used all your attempts! Your final score: " + userScore, "Game Over", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calculateScore() {
        // Add scoring logic here. For example, you can add more points for fewer attempts.
        userScore += (MAX_ATTEMPTS - attemptsLeft) * 10;
    }

    private int generateRandomNumber() {
        // Generate a random number between 1 and 100 (inclusive)
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    public static void main(String[] args) {
        new Task1a();
    }
}
