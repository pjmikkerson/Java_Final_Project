package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import model.Measurement;
import model.Siding;
import view.MainMenuJPanel.ButtonListener;
import model.Lumber;

/**
 * Peter Keeler - PmKeeler CIS171 25949/Wed 12:50 Apr 26, 2024
 */
public class EstimateSidingJPanel extends JPanel {
	
    private int length;
    private int width;
    private int height;



	JButton returnToMain = new JButton("Back");

	JTextField txtSiding = new JTextField(10);
	
	
	

	public EstimateSidingJPanel(int length, int width, int height) {
		this.length = length;
        this.width = width;
        this.height = height;
		double sidingEstimate = Siding.estimateSiding(length, width, height);
		
		
		JLabel header = new JLabel(" Siding for " + length/12+"x"+width/12+" sized shed");

		JLabel lblSiding = new JLabel("Siding needed:");
		
		ButtonListener bl = new ButtonListener();
		returnToMain.addActionListener(bl);
		
		txtSiding.setText(sidingEstimate+" square");
		
		setLayout(new BorderLayout());

		JPanel dimensionsPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		dimensionsPanel.add(header);
		gbc.insets.top = 45 ;
		gbc.gridy++;
		dimensionsPanel.add(lblSiding, gbc);
		gbc.insets.top = 20 ;
		gbc.gridy++;
		dimensionsPanel.add(txtSiding, gbc);
		gbc.gridy++;

		JPanel buttonsPanel = new JPanel();
		
		buttonsPanel.add(returnToMain);
		
		add(dimensionsPanel, BorderLayout.NORTH);
		add(buttonsPanel, BorderLayout.SOUTH);
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == returnToMain) {
	            sendToMainMenu(Measurement.getFeetAndInches(height), Measurement.getFeetAndInches(width), Measurement.getFeetAndInches(length));
	        }
			

		}

		  void sendToMainMenu(String height, String width, String length) {
		        MainMenuJPanel mainMenu = new MainMenuJPanel();
		        mainMenu.txtHeight.setText(height);
		        mainMenu.txtWidth.setText(width);
		        mainMenu.txtLength.setText(length);
		        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(EstimateSidingJPanel.this);
		        frame.getContentPane().removeAll();
		        frame.getContentPane().add(mainMenu);
		        frame.revalidate();
		        frame.repaint();
		    }

	}

}
