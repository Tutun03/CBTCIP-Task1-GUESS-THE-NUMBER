import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Task1 extends JFrame {
    private JLabel headingLabel;
    private JButton continueButton;

    public Task1() {
        setTitle("Guess The Number");
        setSize(1170, 650);
        setLocationRelativeTo(null); // Center the frame on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and customize components
        headingLabel = new JLabel("GUESS THE NUMBER");
         headingLabel.setFont(new Font("Arial", Font.BOLD, 36));
        

        headingLabel.setForeground(Color.BLACK);
        continueButton = new JButton("Click here to continue");
        continueButton.setBackground(Color.BLACK);
        continueButton.setForeground(Color.WHITE);
        continueButton.setFont(new Font("Arial", Font.PLAIN, 18));

        // Set layout manager to a custom panel with background image
        setLayout(new BorderLayout());
        ImagePanel contentPane = new ImagePanel("icons/SEO1269-thumb.png");
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

       
        gbc.gridy = 1;
        contentPane.add(headingLabel, gbc);

        gbc.gridy = 2;
        contentPane.add(continueButton, gbc);

        add(contentPane, BorderLayout.CENTER);

        // Add an ActionListener to the continueButton
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic for button click
                // For example, open a new window for the game or perform other actions
                // Replace the code below with the actual game logic or navigation to the game screen.
                try{
                    new Task1a();
                    setVisible(false);
                }
                catch(Exception as ) {
                JOptionPane.showMessageDialog(Task1.this,
                        "Game not implemented yet. Clicked on Continue!",
                        "Message", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    // Custom JPanel to draw background image
    class ImagePanel extends JPanel {
        private Image backgroundImage;

        public ImagePanel(String imagePath) {
            // Load the image and store it as the background
            ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource(imagePath));
            backgroundImage = imageIcon.getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the background image
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        // Use the Event Dispatch Thread (EDT) to ensure the GUI components are handled properly.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Task1();
            }
        });
    }
}

