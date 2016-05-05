package simpleGuiHelper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import cardManager.CardSwitcher;
import cardManager.CardstackSetup;

public class CustomBtnListener implements ActionListener{

	private static JButton jbutton;
	public static String buttonValue=null;
    
    public CustomBtnListener(JButton jbutton){
    	
			CustomBtnListener.setJbutton(jbutton);
			CustomBtnListener.buttonValue = jbutton.getText();
		
			//System.out.println(jbutton);
			//System.out.println(jbutton.getText());
			//System.out.println(CustomBtnListener.jbutton.getText());
    		//System.out.println(CustomBtnListener.buttonValue);
	}
    
    public void actionPerformed(ActionEvent e) {
    	new CardSwitcher(CardstackSetup.getCards(), CardstackSetup.SHOWVALCARD);
    }
    
    public static String getButtonClicked() {
    	return buttonValue;
    }

	public static JButton getJbutton() {
		return jbutton;
	}

	public static void setJbutton(JButton jbutton) {
		CustomBtnListener.jbutton = jbutton;
	}
	
}
