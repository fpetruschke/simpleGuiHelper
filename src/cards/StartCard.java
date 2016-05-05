package cards;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import simpleGuiHelper.GetGlobal;
import cardManager.CardSwitcher;
import cardManager.CardstackSetup;

public class StartCard {

	public JPanel create() {

		// get background color from confi.properties
		String mainBackgroundColor = GetGlobal.properties.get("darkblue");
		
		JPanel startCard = new JPanel();
		startCard.setBackground(Color.decode(mainBackgroundColor));
		// use gridBagLayout
		startCard.setLayout( new GridBagLayout());
		
		// use gridBagConstraints for configuring global grid on this card
		GridBagConstraints c = new GridBagConstraints();
		
		// use full width of the container
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridheight = 2;
        // set margin to top and bottom border
		c.insets = new Insets( 10, 0, 10, 0);
        
		// ##########################################
		// # NOW COMES THE ACTUAL CONTENT 			#
		// ##########################################
		JLabel mainTitle = new JLabel("simpleGuiHelper");
		mainTitle.setFont(new Font("Helvetica", Font.BOLD, 24));
		mainTitle.setForeground(Color.decode(GetGlobal.properties.get("white")));
		startCard.add(mainTitle, c);
		
		JButton btnSettings= new JButton ("Settings");
		btnSettings.setBackground(Color.decode(GetGlobal.properties.get("white")));
		btnSettings.setFont(new Font("Helvetica", Font.BOLD, 16));
		btnSettings.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	new CardSwitcher(CardstackSetup.getCards(), CardstackSetup.SETTINGSCARD);
		    }
		});
		startCard.add(btnSettings,c);
		
		JButton btnAbout= new JButton ("About");
		btnAbout.setBackground(Color.decode(GetGlobal.properties.get("white")));
		btnAbout.setFont(new Font("Helvetica", Font.BOLD, 16));
		btnAbout.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	new CardSwitcher(CardstackSetup.getCards(), CardstackSetup.ABOUTCARD);
		    }
		});
		startCard.add(btnAbout,c);
		
		JButton btnExit = new JButton ("Quit");
		btnExit.setBackground(Color.decode(GetGlobal.properties.get("white")));
		btnExit.setFont(new Font("Helvetica", Font.BOLD, 16));
		btnExit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	System.exit(0);
		    }
		});
		startCard.add(btnExit,c);
            
        
        return startCard;
	}
	
}
