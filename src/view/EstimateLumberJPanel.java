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
import view.MainMenuJPanel.ButtonListener;
import model.Lumber;

/**
 * Peter Keeler - PmKeeler CIS171 25949/Wed 12:50 Apr 26, 2024
 */
public class EstimateLumberJPanel extends JPanel {

	/**
	 * @param txtLength
	 * @param txtWidth
	 * @param txtHeight
	 */
	
    private int length;
    private int width;
    private int height;



	JButton returnToMain = new JButton("Back");

	JTextField txtStuds = new JTextField(10);
	JTextField txtLineal = new JTextField(10);
	
	

	public EstimateLumberJPanel(int length, int width, int height) {
		this.length = length;  // Store length
        this.width = width;    // Store width
        this.height = height;  // Store height
		int studCount = Lumber.getStudCount(length, width);
		int LinealLumber = Lumber.getLinealLumber(length, width);
		
		JLabel header = new JLabel(" Lumber for " + length/12+"x"+width/12+" sized shed");

		JLabel lblStuds = new JLabel("Studs needed:");
		JLabel lblLineal = new JLabel("Lineal Lumber:");
		
		ButtonListener bl = new ButtonListener();
		returnToMain.addActionListener(bl);
		
		txtLineal.setText(LinealLumber+ "\'");
		txtStuds.setText(studCount+"");
		
		setLayout(new BorderLayout());

		JPanel dimensionsPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		dimensionsPanel.add(header);
		gbc.gridy++;
		dimensionsPanel.add(lblStuds, gbc);
		gbc.gridy++;
		dimensionsPanel.add(txtStuds, gbc);
		gbc.gridy++;
		dimensionsPanel.add(lblLineal, gbc);
		gbc.gridy++;
		dimensionsPanel.add(txtLineal, gbc);
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
		        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(EstimateLumberJPanel.this);
		        frame.getContentPane().removeAll();
		        frame.getContentPane().add(mainMenu);
		        frame.revalidate();
		        frame.repaint();
		    }

	}

}
