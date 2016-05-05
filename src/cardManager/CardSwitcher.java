package cardManager;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class CardSwitcher {
	
	/**
	 * CardSwitcher
	 * 
	 * Will switch the content of the parent Frame to given card.
	 * 
	 * @param cards				JPanel 	Takes the created cardstack
	 * @param cardTitleToShow	String	static final cardname to show
	 */
	public CardSwitcher(JPanel cards, String cardTitleToShow) {
		CardLayout cl = (CardLayout)(cards.getLayout());//get layout of cards from card panel
    	cl.show(cards, cardTitleToShow);//show card with given title
	}
}
