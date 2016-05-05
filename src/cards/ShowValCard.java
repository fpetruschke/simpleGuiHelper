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

import simpleGuiHelper.CustomBtnListener;
import simpleGuiHelper.GetGlobal;
import cardManager.CardSwitcher;
import cardManager.CardstackSetup;

public class ShowValCard {

	public JPanel create() {

		// get background color from confi.properties
		String mainBackgroundColor = GetGlobal.properties.get("purple");
		
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
		
		//String value = "Help me, I'm lost here.";
		String value = CustomBtnListener.getButtonClicked();
		//String value2 = CustomBtnListener.buttonValue;
		
		JLabel lblValueTotal = new JLabel("In total there were " + value.replaceAll("\\D+","") + " JButtons.");
		lblValueTotal.setFont(new Font("Helvetica", Font.BOLD, 18));
		lblValueTotal.setForeground(Color.decode(GetGlobal.properties.get("white")));
		startCard.add(lblValueTotal, c);
		
		JLabel lblValue = new JLabel("You clicked Button-No.: " + "-- need some help here --");
		lblValue.setFont(new Font("Helvetica", Font.BOLD, 18));
		lblValue.setForeground(Color.decode(GetGlobal.properties.get("white")));
		startCard.add(lblValue, c);
		
		JLabel lblTest = new JLabel("TestLabel:" + SettingsCard.handOver);
		lblTest.setFont(new Font("Helvetica", Font.BOLD, 18));
		lblTest.setForeground(Color.decode(GetGlobal.properties.get("white")));
		startCard.add(lblTest, c);
				
		JButton btnBack= new JButton ("Back");
		btnBack.setBackground(Color.decode(GetGlobal.properties.get("white")));
		btnBack.setFont(new Font("Helvetica", Font.BOLD, 16));
		btnBack.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	new CardSwitcher(CardstackSetup.getCards(), CardstackSetup.STARTCARD);
		    }
		});
		startCard.add(btnBack,c);
            
        
        return startCard;
	}
	
}
