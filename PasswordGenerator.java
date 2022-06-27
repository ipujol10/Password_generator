import javax.swing.JFrame;

public class PasswordGenerator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Password generator"); // Make window

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the window

        frame.setSize(600, 400);

        frame.setVisible(true); // show it

        // frame.pack(); // allow to contain everything
    }
}
