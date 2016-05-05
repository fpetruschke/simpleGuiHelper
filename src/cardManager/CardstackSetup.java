package cardManager;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.JPanel;

// #####################################################
// # 1. IMPORT ALL CARDS HERE	 	 				   #
// #####################################################
import cards.*;

public class CardstackSetup {

	private static JPanel cards; //a panel that uses CardLayout
	// #####################################################
	// # 2. ADD TITLES FOR EVERY CARD HERE	 			   #
	// #####################################################
    public final static String STARTCARD = "Card for Main Window";
    public final static String ABOUTCARD = "About Card";
    public final static String ABOUTCARD2 = "About Card page 2";
    public final static String SETTINGSCARD = "Settings Card";
    public final static String SHOWVALCARD = "Card for showing a handed over value";

    public void addCards(Container pane) {
    	// #####################################################
    	// # 3. INSTANTIATE YOUR CARDS HERE					   #
    	// #####################################################
    	
        // the "start" card showing up when application starts
    	JPanel startcard = new StartCard().create();

        // the "about" card
        JPanel aboutcard = new AboutCard().create();
        
        // the "about" card - page 2
        JPanel aboutcard2 = new AboutCard2().create();
        
        // the "settings" card
        JPanel settingscard = new SettingsCard().create();
        
        // the "settings" card
        JPanel showvalcard = new ShowValCard().create();
        
        // ######################################################
    	// # 4. ADD EVERY CARD TO THE JPANEL 					#
        // ######################################################
        setCards(new JPanel(new CardLayout()));
        getCards().add(startcard, STARTCARD);
        getCards().add(aboutcard, ABOUTCARD);
        getCards().add(aboutcard2, ABOUTCARD2);
        getCards().add(settingscard, SETTINGSCARD);
        getCards().add(showvalcard, SHOWVALCARD);

        pane.add(getCards(), BorderLayout.PAGE_START);
    }

	public static JPanel getCards() {
		return cards;
	}

	public static void setCards(JPanel cards) {
		CardstackSetup.cards = cards;
	}
	
}
