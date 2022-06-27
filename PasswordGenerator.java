import javax.swing.*;
import java.awt.*;

public class PasswordGenerator {
    private static JTextField length = new JTextField("16", 2);

    private static JCheckBox special = new JCheckBox("Special characters allowed? (@#$%&-.,_:;()[]{}*)", true);
    private static JCheckBox repeat = new JCheckBox("Allow repeated characters?", true);
    private static JCheckBox upper = new JCheckBox("Use upper case?", true);
    private static JCheckBox lower = new JCheckBox("Use lower case?", true);
    private static JCheckBox numbers = new JCheckBox("Use numbers?", true);

    private static JButton generate = new JButton("Generate");

    public static void main(String[] args) {
        // Frame
        JFrame frame = new JFrame("Password generator"); // Make window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the window
        // frame.pack(); // allow to contain everything
        frame.setSize(600, 250);

        // Menu bar
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Help");
        mb.add(m1);

        // Panel with the things
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel length_panel = new JPanel();
        JLabel length_msg = new JLabel("Length of the password");
        length_panel.add(length_msg);
        length_panel.add(length);
        panel.add(length_panel);
        panel.add(special);
        panel.add(repeat);
        panel.add(upper);
        panel.add(lower);
        panel.add(numbers);

        // Create
        JPanel result_panel = new JPanel();
        JTextField password = new JTextField(30);
        password.setEditable(false);
        result_panel.add(generate);
        result_panel.add(password);

        // Components
        frame.getContentPane().add(BorderLayout.NORTH ,mb);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, result_panel);
        frame.setVisible(true); // show it
    }
}
