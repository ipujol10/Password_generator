import javax.swing.*;
import java.awt.*;

public class PasswordGenerator {
    public static void main(String[] args) {
        // Frame
        JFrame frame = new JFrame("Password generator"); // Make window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the window
        // frame.pack(); // allow to contain everything
        frame.setSize(400, 400);

        // Menu bar
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Help");
        mb.add(m1);

        // Panel with the things
        JPanel panel = new JPanel();
        JLabel length_msg = new JLabel("Length of the password");
        JTextField length = new JTextField(2);
        panel.add(length_msg);
        panel.add(length);

        // Components
        frame.getContentPane().add(BorderLayout.NORTH ,mb);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true); // show it
    }
}
