import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class PasswordGenerator {
	public static void main(String[] args) {
		new Program();
	}
}

class Program implements ActionListener {
	JFrame frame;

	JMenuItem m1;

	JTextField length;

	JCheckBox special;
	JCheckBox repeat;
	JCheckBox upper;
	JCheckBox lower;
	JCheckBox numbers;

	JButton generate;
	JTextField password;

	Program() {
		init();
		execution();
	}

	private void init() {
		frame = new JFrame("Password generator"); // Make window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the window
		ImageIcon img = new ImageIcon("icon.png");
		frame.setIconImage(img.getImage());
		frame.setSize(600, 250);
		frame.setVisible(true);

		m1 = new JMenuItem("Help");

		length = new JTextField("16", 2);

		special = new JCheckBox("Special characters allowed? (@#$%&,etc)", true);
		repeat = new JCheckBox("Allow repeated characters?", true);
		upper = new JCheckBox("Use upper case?", true);
		lower = new JCheckBox("Use lower case?", true);
		numbers = new JCheckBox("Use numbers?", true);

		generate = new JButton("Generate");
		password = new JTextField(30);
	}

	private void execution() {
		// Menu bar
		JMenuBar mb = new JMenuBar();
		m1.addActionListener(this);
		mb.add(m1);

		// Panel with the things
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JPanel length_panel = new JPanel();
		JLabel length_msg = new JLabel("Length of the password [1-30]:");
		length_panel.add(length_msg);
		length_panel.add(length);
		panel.add(length_panel);
		panel.add(special);
		panel.add(upper);
		panel.add(lower);
		panel.add(numbers);
		panel.add(repeat);

		// Create
		JPanel result_panel = new JPanel();
		generate.addActionListener(this);
		password.setEditable(false);
		result_panel.add(generate);
		result_panel.add(password);

		// Components
		frame.getContentPane().add(BorderLayout.NORTH, mb);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(BorderLayout.SOUTH, result_panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == generate) {
			password.setText(genration());
		} else if (e.getSource() == m1) {
			JOptionPane.showMessageDialog(frame, "You need to select the length of the password and select at least one of the type of characters to use.");
		}
	}

	private String genration() {
		int error = 0;
		int pass_length = Integer.parseInt(length.getText());
		if (!(special.isSelected() || upper.isSelected() || lower.isSelected() || numbers.isSelected())) error += 1;
		if (!(0 < pass_length && pass_length < 31)) error += 10;

		if (error > 0) {
			if (error == 1) {
				JOptionPane.showMessageDialog(frame, "At least one of the types of charactes have to be selected.");
			} else if (error == 10) {
				JOptionPane.showMessageDialog(frame, "The length of the password must be between 1 and 30.");
			} else if (error == 11) {
				JOptionPane.showMessageDialog(frame, "At least one of the types of charactes have to be selected.\nThe length of the password must be between 1 and 30.");
			}

			return "";
		}

		String[] possible_chars = {};
		if (special.isSelected()) {
			String[] news = { "@", "#", "$", "%", "&", "-", ".", ",", "_", ":", ";", "(", ")", "[", "]", "{", "}", "*", "+", "/" };
			int l1 = possible_chars.length;
			int l2 = news.length;
			String[] temp = new String[l1 + l2];
			System.arraycopy(possible_chars, 0, temp, 0, l1);
			System.arraycopy(news, 0, temp, l1, l2);
			possible_chars = temp;
		}

		if (upper.isSelected()) {
			String[] news = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
					"T", "U", "V", "W", "X", "Y", "Z" };
			int l1 = possible_chars.length;
			int l2 = news.length;
			String[] temp = new String[l1 + l2];
			System.arraycopy(possible_chars, 0, temp, 0, l1);
			System.arraycopy(news, 0, temp, l1, l2);
			possible_chars = temp;
		}

		if (lower.isSelected()) {
			String[] news = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
					"t", "u", "v", "w", "x", "y", "z" };
			int l1 = possible_chars.length;
			int l2 = news.length;
			String[] temp = new String[l1 + l2];
			System.arraycopy(possible_chars, 0, temp, 0, l1);
			System.arraycopy(news, 0, temp, l1, l2);
			possible_chars = temp;
		}

		if (numbers.isSelected()) {
			String[] news = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
			int l1 = possible_chars.length;
			int l2 = news.length;
			String[] temp = new String[l1 + l2];
			System.arraycopy(possible_chars, 0, temp, 0, l1);
			System.arraycopy(news, 0, temp, l1, l2);
			possible_chars = temp;
		}

		String pass = "";
		Random rand = new Random();
		for (int i = 0; i < pass_length; i++) {
			pass += possible_chars[rand.nextInt(possible_chars.length)];
		}

		return pass;
	}
}