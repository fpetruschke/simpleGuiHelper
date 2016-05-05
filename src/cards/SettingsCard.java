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
public class SettingsCard {	
	
	public static String handOver = "Hello, I'm the public static handover string from the SettingsCard";
	
	public JPanel create() {
		
		// get background color from confi.properties
		String mainBackgroundColor = GetGlobal.properties.get("green");
		
		JPanel settingsCard = new JPanel();
		settingsCard.setBackground(Color.decode(mainBackgroundColor));
		// use gridBagLayout
		settingsCard.setLayout( new GridBagLayout());
		
		// use gridBagConstraints for configuring global grid on this card
		GridBagConstraints c = new GridBagConstraints();
		
		// use full width of the container
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridheight = 8;
        // set margin to top and bottom border
		c.insets = new Insets( 10, 0, 10, 0);
		
		// ##########################################
		// # NOW COMES THE ACTUAL CONTENT 			#
		// ##########################################
		
		JLabel mainTitle = new JLabel("simpleGuiHelper");
		mainTitle.setFont(new Font("Helvetica", Font.BOLD, 24));
		mainTitle.setForeground(Color.decode(GetGlobal.properties.get("white")));
		settingsCard.add(mainTitle, c);
		
        JButton[] jButton = new JButton[4];
        ActionListener[] actionListener = new CustomBtnListener[4];
        
        for ( int i = 0; i<4; i++ ) {
            jButton[i] = new JButton ( "JButton" + (i+1) );
            jButton[i].setBackground(Color.decode(GetGlobal.properties.get("white")));
            jButton[i].setFont(new Font("Helvetica", Font.BOLD, 16));
            
            // use custom action listener for handing over the button
            actionListener[i] = new CustomBtnListener(jButton[i]);
            jButton[i].addActionListener(actionListener[i]);
            
            settingsCard.add (jButton[i],c);
        }
        
        
        JLabel lblNote = new JLabel("Note of Initialization: " + SettingsCard.handOver);
        lblNote.setFont(new Font("Helvetica", Font.BOLD, 18));
        lblNote.setForeground(Color.decode(GetGlobal.properties.get("black")));
		settingsCard.add(lblNote, c);
		
		// now change the handover value
		SettingsCard.handOver = "Remember? I've been set before... in the SettingsCard";
		
        JButton backBtn = new JButton("zurück");
        backBtn.setBackground(Color.decode(GetGlobal.properties.get("white")));
        backBtn.setFont(new Font("Helvetica", Font.BOLD, 16));
        backBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	new CardSwitcher(CardstackSetup.getCards(), CardstackSetup.STARTCARD);
		    }
		});
        settingsCard.add(backBtn, c);
        
        return settingsCard;
	}
	
}
