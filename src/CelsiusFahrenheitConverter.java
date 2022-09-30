import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

/**
 * The program converts fahrenheit to celsius and vice versa.
 * 
 * @author Ngoc Tran CSCI 235 02/09/2021
 */
public class CelsiusFahrenheitConverter extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;

	private JLabel labelF;
	private JTextField textfield;
	private JButton convertButton;

	private JLabel labelC;
	private JTextField textfieldC;
	private JButton convertButtonC;

	private JCheckBox checkBox;
	private JLabel formula;

	private static final int WINDOW_WIDTH = 500, WINDOW_HEIGHT = 150;

	/**
	 * Constructor of CelsiusFahrenheitConverter
	 */
	public CelsiusFahrenheitConverter() {
		setTitle("Celsius Fahrenheit Converter");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildPanel();
		add(panel);
		setVisible(true);

	}

	/**
	 * Build the panel of the program.
	 */
	private void buildPanel() {
		labelF = new JLabel("Fahrenheit");
		textfield = new JTextField(10);
		convertButton = new JButton("Convert");

		labelC = new JLabel("Celsius");
		textfieldC = new JTextField(10);
		convertButtonC = new JButton("Convert");

		checkBox = new JCheckBox("Show formula");
		checkBox.setSelected(false);
		formula = new JLabel();

		panel = new JPanel();
		// Set the group layout
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(labelF)
						.addComponent(labelC).addComponent(checkBox))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(textfield)
						.addComponent(textfieldC).addComponent(formula))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(convertButton)
						.addComponent(convertButtonC)));
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelF)
						.addComponent(textfield).addComponent(convertButton))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelC)
						.addComponent(textfieldC).addComponent(convertButtonC))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(checkBox)
						.addComponent(formula)));
		// Add action to the two buttons
		convertButton.addActionListener(new ConvertButtonListenerFtoC());
		convertButtonC.addActionListener(new ConvertButtonListenerCtoF());
		// Add an event to the check box
		checkBox.addItemListener(new CheckBoxListener());
	}

	/**
	 * ConverterButtonListenerFtoC implements ActionListener. This private inner
	 * class provides action to the convertButton which converts fahrenheit to
	 * celsius.
	 */
	private class ConvertButtonListenerFtoC implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			double fahrenheitVal;
			double celsiusVal;
			String input = textfield.getText();
			// If the user enters an invalid input, show a message.
			try {
				fahrenheitVal = Double.parseDouble(input);
				celsiusVal = (5.0 / 9) * (fahrenheitVal - 32);
				JOptionPane.showMessageDialog(panel, "Celsius: " + String.format("%10.1f", celsiusVal));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(panel, "Invalid input");
			}
			;

		}

	}

	/**
	 * CheckBoxListener implements ItemListener. This private inner class provides a
	 * checkbox with an item event. If the checkbox is checked, the formula is
	 * showed. Otherwise, the formula is hidden.
	 */

	private class CheckBoxListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			formula.setText((e.getStateChange() == 1 ? "C = (5.0 / 9) * (F - 32)" : ""));
		}

	}

	/**
	 * ConverterButtonListenerCtoF implements ActionListener. This private inner
	 * class provides an action to the convertButtonC which converts celsius to
	 * fahrenheit.
	 */
	private class ConvertButtonListenerCtoF implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			double fahrenheitVal;
			double celsiusVal;
			String input = textfieldC.getText();
			// If the user enters an invalid input, show a message.
			try {
				celsiusVal = Double.parseDouble(input);
				fahrenheitVal = celsiusVal * (9.0 / 5) + 32;
				JOptionPane.showMessageDialog(panel, "Fahrenheit: " + String.format("%10.1f", fahrenheitVal));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(panel, "Invalid input");
			}

		}
	}

	/*
	 * The main method of CelsiusFahrenheitConverter
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CelsiusFahrenheitConverter();

	}

}
