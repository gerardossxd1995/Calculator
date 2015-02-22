import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Main extends JFrame {

	double number1, number2, result;
	int variableOperation; // 1 for sum, 2 subs, 3 multiply, 4 divide
	JTextArea txtNumber = new JTextArea("");
	JButton[] buttonSci = new JButton[4];
	JButton[] jbtNumbers = new JButton[12];
	JButton[] operations = new JButton[5];

	JPanel panelSci = new JPanel(new GridLayout(0, 1));
	JPanel panelButtons = new JPanel(new GridLayout(4, 2));
	JPanel panelOpp = new JPanel(new GridLayout(0, 1));

	public Main() {
		txtNumber.setRows(2);
		setTitle("Calc 2.0");
		// jbtNUmbers
		for (int i = 0; i < jbtNumbers.length; i++) {
			jbtNumbers[i] = new JButton(" " + (9 - i));
		}

		jbtNumbers[10].setText(".");
		jbtNumbers[11].setText("AC");

		for (int i = 0; i < jbtNumbers.length; i++) {
			panelButtons.add(jbtNumbers[i]);
		}
		// End...jbtNUmbers

		// buttonSCI
		buttonSci[0] = new JButton("MC");
		buttonSci[1] = new JButton("MIR");
		buttonSci[2] = new JButton("MS");
		buttonSci[3] = new JButton("MT");

		for (int i = 0; i < buttonSci.length; i++) {
			panelSci.add(buttonSci[i]);
		}

		// end..buttonSci

		// operations

		operations[0] = new JButton("+");
		operations[1] = new JButton("-");
		operations[2] = new JButton("*");
		operations[3] = new JButton("/");
		operations[4] = new JButton("=");

		for (int i = 0; i < operations.length; i++) {
			panelOpp.add(operations[i]);
		}

		// Add buttonSci to JPanel

		// AddActionlistener to numberButton
		for (int j = 0; j < jbtNumbers.length; j++) {
			jbtNumbers[j].addActionListener(new NumberAction(j));
		}

		// AddActionListener to opperations
		for (int i = 0; i < operations.length; i++) {
			operations[i].addActionListener(new OperationAction());
		}

		this.getContentPane().add(txtNumber, BorderLayout.NORTH);
		this.getContentPane().add(panelButtons, BorderLayout.CENTER);
		this.getContentPane().add(panelSci, BorderLayout.WEST);
		this.getContentPane().add(panelOpp, BorderLayout.EAST);
	}

	public static void main(String[] args) {

		JFrame frame = new Main();
		frame.setVisible(true);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

	}

	class NumberAction implements ActionListener {

		public NumberAction(int number) {

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object b = e.getSource();

			if (b == jbtNumbers[0]) {
				txtNumber.append("9");
			}
			if (b == jbtNumbers[1]) {
				txtNumber.append("8");
			}
			if (b == jbtNumbers[2]) {
				txtNumber.append("7");
			}
			if (b == jbtNumbers[3]) {
				txtNumber.append("6");
			}
			if (b == jbtNumbers[4]) {
				txtNumber.append("5");
			}
			if (b == jbtNumbers[5]) {
				txtNumber.append("4");
			}
			if (b == jbtNumbers[6]) {
				txtNumber.append("3");
			}
			if (b == jbtNumbers[7]) {
				txtNumber.append("2");
			}
			if (b == jbtNumbers[8]) {
				txtNumber.append("1");
			}
			if (b == jbtNumbers[9]) {
				txtNumber.append("0");
			}
			if (b == jbtNumbers[10]) {
				txtNumber.append(".");
			}
			if (b == jbtNumbers[11]) {
				txtNumber.setText("");
			}
		}

	}

	class OperationAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent f) {
			Object op = f.getSource();

			if (op == operations[0]) {
				// System.out.println("plus");
				number1 = Double.parseDouble(txtNumber.getText());
				// System.out.println(number1);
				txtNumber.setText("");
				variableOperation = 1;
			}
			if (op == operations[1]) {
				System.out.println("sub");
				number1 = Double.parseDouble(txtNumber.getText());
				txtNumber.setText("");
				variableOperation = 2;
			}
			if (op == operations[2]) {
				System.out.println("multiply");
				number1 = Double.parseDouble(txtNumber.getText());
				txtNumber.setText("");
				variableOperation = 3;
			}
			if (op == operations[3]) {
				System.out.println("plus");
				number1 = Double.parseDouble(txtNumber.getText());
				txtNumber.setText("");
				variableOperation = 4;
			}
			if (op == operations[4]) {
				System.out.println("equals");
				number2 = Double.parseDouble(txtNumber.getText());
				System.out.println(number2 + " n2");
				if (variableOperation == 1) {
					result = number1 + number2;
					txtNumber.setText("" + result);
				} else if (variableOperation == 2) {
					result = number1 - number2;
					txtNumber.setText("" + result);
				} else if (variableOperation == 3) {
					result = number1 * number2;
					txtNumber.setText("" + result);
				} else if (variableOperation == 4) {
					result = number1 / number2;
					txtNumber.setText("" + result);
				}
			}
		}

	}
}
