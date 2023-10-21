import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Age Input");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        // Create the panel
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        // Set the frame visibility to true
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Create a label
        JLabel ageLabel = new JLabel("Enter age:");
        ageLabel.setBounds(20, 20, 80, 25);
        panel.add(ageLabel);

        // Create a text field for age input
        JTextField ageText = new JTextField(20);
        ageText.setBounds(110, 20, 150, 25);
        panel.add(ageText);

        // Create a button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(110, 60, 80, 25);
        panel.add(submitButton);

        // Create a label to display the result
        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(20, 90, 250, 25);
        panel.add(resultLabel);

        // Add action listener to the button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get age from the text field and parse it to an integer
                    int age = Integer.parseInt(ageText.getText());
                    // Display a message based on age
                    if (age < 18) {
                        resultLabel.setText("You are a minor.");
                    } else {
                        resultLabel.setText("You are an adult.");
                    }
                } catch (NumberFormatException ex) {
                    // Handle invalid input (non-integer)
                    resultLabel.setText("Invalid input. Please enter a valid age.");
                }
            }
        });
    }
}
