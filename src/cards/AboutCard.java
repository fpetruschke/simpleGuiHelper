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

public class AboutCard {

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
		
		JLabel aboutTitle = new JLabel("About");
		aboutTitle.setFont(new Font("Helvetica", Font.BOLD, 24));
		aboutTitle.setForeground(Color.BLACK);
		aboutCard.add(aboutTitle, c);
		
		// decoration for textarea lines
		String newline = "\n";
		String hr= "------------------------------------------------------";
		
		JTextArea aboutText = new JTextArea(5, 20);
		aboutText.setEditable(false);
		aboutText.setLineWrap(true);
		aboutText.setWrapStyleWord(true);
		aboutText.setBackground(Color.decode(mainBackgroundColor));
		aboutText.append("SimpleGuiHelper is an attempt for easing the creation of guis." + newline);
		aboutText.append("For me as a java beginner it was pretty hard to get a gui look like I wanted it to." + newline);
		aboutText.append("I almost get how the whole java layout manager ish works - but it's still a long way to go." + newline);
		aboutText.append(hr + newline);
		aboutText.append("The projects aims to be a little 'framework' for setting up a gui." + newline);
		aboutText.append("Use the GuiHelper for placing your content into a gui is to adjust the configuration of MainFrame, MenuBar and Cards." + newline);
		aboutCard.add(aboutText, c);
		
		JButton btnNext = new JButton("<html><p color='black'><strong>next ></strong></p><html>");
		btnNext.setBackground(Color.decode(GetGlobal.properties.get("white")));
		btnNext.setFont(new Font("Helvetica", Font.BOLD, 16));
		btnNext.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	new CardSwitcher(CardstackSetup.getCards(), CardstackSetup.ABOUTCARD2);
		    }
		});
        aboutCard.add(btnNext, c);

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
