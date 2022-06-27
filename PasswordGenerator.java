import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PasswordGenerator {
    public static void main(String[] args) {
        new Program();
    }
}

class Program implements ActionListener {
    JFrame frame = new JFrame("Password generator"); // Make window

    JTextField length = new JTextField("16", 2);

    JCheckBox special = new JCheckBox("Special characters allowed? (@#$%&-.,_:;()[]{}*)", true);
    JCheckBox repeat = new JCheckBox("Allow repeated characters?", true);
    JCheckBox upper = new JCheckBox("Use upper case?", true);
    JCheckBox lower = new JCheckBox("Use lower case?", true);
    JCheckBox numbers = new JCheckBox("Use numbers?", true);

    JButton generate = new JButton("Generate");
    JTextField password = new JTextField(30);

    Program() {
        init();
        execution();
    }

    private void init() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the window
        frame.setSize(600, 250);
        frame.setVisible(true);
    }

    private void execution() {
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
        generate.addActionListener(this);
        password.setEditable(false);
        result_panel.add(generate);
        result_panel.add(password);

        // Components
        frame.getContentPane().add(BorderLayout.NORTH ,mb);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, result_panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        password.setText("Works");
    }

    private void genration() {

    }
}