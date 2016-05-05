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
import javax.swing.JTextArea;

import simpleGuiHelper.GetGlobal;

import cardManager.CardSwitcher;
import cardManager.CardstackSetup;

public class AboutCard2 {

	public JPanel create() {
		
		// get background color from confi.properties
		String mainBackgroundColor = GetGlobal.properties.get("yellow");
		
		JPanel aboutCard = new JPanel();
		aboutCard.setBackground(Color.decode(mainBackgroundColor));
		// use gridBagLayout
		aboutCard.setLayout( new GridBagLayout());
		
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
		mainTitle.setForeground(Color.BLACK);
		aboutCard.add(mainTitle, c);
		
		// decoration for textarea lines
		String newline = "\n";
		String hr= "-----------------------------------------------------------";

		JLabel requTitle = new JLabel("Requirements");
		requTitle.setFont(new Font("Helvetica", Font.BOLD, 24));
		requTitle.setForeground(Color.BLACK);
		aboutCard.add(requTitle, c);

		JTextArea reqText = new JTextArea(5, 20);
		reqText.setEditable(false);
		reqText.setBackground(Color.decode(mainBackgroundColor));
		reqText.append("- You need to have Java 1.7 installed." + newline);
		reqText.append("- import Project into your workspace" + newline);
		reqText.append(newline);
		reqText.append(newline);
		reqText.append(hr + newline);
		reqText.append("©2016 - F.Petruschke");
		aboutCard.add(reqText, c);
        
        JButton backBtn = new JButton("zurück");
        backBtn.setBackground(Color.decode(GetGlobal.properties.get("white")));
        backBtn.setFont(new Font("Helvetica", Font.BOLD, 16));
        backBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	new CardSwitcher(CardstackSetup.getCards(), CardstackSetup.STARTCARD);
		    }
		});
        aboutCard.add(backBtn, c);
        return aboutCard;
	}
	
}
