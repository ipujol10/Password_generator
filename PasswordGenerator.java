import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;

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
        password.setText(genration());
    }

    private String genration() {
        String[] possible_chars = {};
        if (special.isSelected()) {
            String[] news = {"@", "#", "$", "%", "&", "-", ".", ",", "_", ":", ";", "(", ")", "[", "]", "{", "}", "*"};
            int l1 = possible_chars.length;
            int l2 = news.length;
            String[] temp = new String[l1 + l2];
            System.arraycopy(possible_chars, 0, temp, 0, l1);
            System.arraycopy(news, 0, temp, l1, l2);
            possible_chars = temp;
        }

        if (upper.isSelected()) {
            String[] news = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
            int l1 = possible_chars.length;
            int l2 = news.length;
            String[] temp = new String[l1 + l2];
            System.arraycopy(possible_chars, 0, temp, 0, l1);
            System.arraycopy(news, 0, temp, l1, l2);
            possible_chars = temp;
        }

        if (lower.isSelected()) {
            String[] news = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
            int l1 = possible_chars.length;
            int l2 = news.length;
            String[] temp = new String[l1 + l2];
            System.arraycopy(possible_chars, 0, temp, 0, l1);
            System.arraycopy(news, 0, temp, l1, l2);
            possible_chars = temp;
        }

        if (numbers.isSelected()) {
            String[] news = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
            int l1 = possible_chars.length;
            int l2 = news.length;
            String[] temp = new String[l1 + l2];
            System.arraycopy(possible_chars, 0, temp, 0, l1);
            System.arraycopy(news, 0, temp, l1, l2);
            possible_chars = temp;
        }

        String pass = "";
        Random rand = new Random();
        for (int i = 0; i < Integer.parseInt(length.getText()); i++) {
            pass += possible_chars[rand.nextInt(possible_chars.length)];
        }

        return pass;
    }
}