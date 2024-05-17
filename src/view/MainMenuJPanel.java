package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Measurement;

public class MainMenuJPanel extends JPanel {

	JButton btnEstimateLumber = new JButton("Estimate Lumber");
	JButton btnEstimatePlywood = new JButton("Estimate plywood");
	JButton btnEstimateSiding = new JButton("Estimate siding");
	JButton btnClear = new JButton("Clear");

	JTextField txtHeight = new JTextField(10);
	JTextField txtWidth = new JTextField(10);
	JTextField txtLength = new JTextField(10);

	/**
	 * Create the panel.
	 */
	public MainMenuJPanel() {

		JLabel instructions = new JLabel(" Enter Building Dimensions ");

		JLabel lblHeight = new JLabel("Height:");
		JLabel lblWidth = new JLabel("Width:");
		JLabel lblLength = new JLabel("Length:");
		JLabel formatLabel = new JLabel("Enter as (FT' IN\")");

		ButtonListener bl = new ButtonListener();
		btnEstimateLumber.addActionListener(bl);
		btnEstimatePlywood.addActionListener(bl);
		btnEstimateSiding.addActionListener(bl);
		btnClear.addActionListener(bl);

		setLayout(new BorderLayout());

		JPanel dimensionsPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		dimensionsPanel.add(instructions);
		gbc.gridy++;
		dimensionsPanel.add(lblHeight, gbc);
		gbc.gridy++;
		dimensionsPanel.add(txtHeight, gbc);
		gbc.gridy++;
		txtHeight.setText("0'0\"");
		dimensionsPanel.add(lblWidth, gbc);
		gbc.gridy++;
		dimensionsPanel.add(txtWidth, gbc);
		txtWidth.setText("10'8\"");
		gbc.gridy++;
		dimensionsPanel.add(lblLength, gbc);
		gbc.gridy++;
		dimensionsPanel.add(txtLength, gbc);
		txtLength.setText("10'8\"");
		gbc.gridy++;
		dimensionsPanel.add(formatLabel, gbc);
		gbc.gridy++;
		dimensionsPanel.add(btnClear, gbc);

		JPanel buttonsPanel = new JPanel();

		buttonsPanel.add(btnEstimateLumber);
		buttonsPanel.add(btnEstimatePlywood);
		buttonsPanel.add(btnEstimateSiding);

		add(dimensionsPanel, BorderLayout.NORTH);
		add(buttonsPanel, BorderLayout.SOUTH);
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel newPanel = new JPanel();
			String errorMessage = "";
			try {
				int length = Measurement.getInch(txtLength.getText());
				int height = Measurement.getInch(txtHeight.getText());
				int width = Measurement.getInch(txtWidth.getText());

				if (e.getSource() == btnEstimateLumber) {
					newPanel = new EstimateLumberJPanel(length, width, height);
				} else if (e.getSource() == btnEstimatePlywood) {
					newPanel = new EstimatePlywoodJPanel(length, width, height);
				} else if (e.getSource() == btnEstimateSiding) {
					newPanel = new EstimateSidingJPanel(length, width, height);
				} else if (e.getSource() == btnClear) {
					txtLength.setText("0'0\"");
					txtHeight.setText("0'0\"");
					txtWidth.setText("0'0\"");
					return;
				}
				sendToNewPanel(newPanel);

			} catch (IllegalArgumentException ex) {
				errorMessage = ex.getMessage(); // Get error message from the exception
			}
			if (!errorMessage.isEmpty()) {
				JOptionPane.showMessageDialog(MainMenuJPanel.this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
				// Optionally, clear the affected text field(s)
				txtLength.setText("0'0\"");
				txtHeight.setText("0'0\"");
				txtWidth.setText("0'0\"");
			}

		}

		private void sendToNewPanel(JPanel newPanel) {
			removeAll();
			setVisible(false);
			add(newPanel);
			validate();
			setVisible(true);

		}

	}

}
