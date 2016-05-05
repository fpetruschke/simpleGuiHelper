package simpleGuiHelper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JFrame;

import cardManager.CardstackSetup;

public class MainFrame {

		/**
		 * create
		 * 
		 * Creates and sets up the main frame with all its content:
		 * - Cards from CardstackSetup-class
		 * - MenuBar from MenuBar-class
		 */
		public void create() {
	    	// main window title, background and default close operation
	        JFrame frame = new JFrame("simpleGuiHelper");
	        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
	        frame.setBackground(SystemColor.activeCaptionBorder);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
	        // setting the initial applications window size and prevent resizing
	        frame.setMinimumSize(new Dimension(800, 500));
	        frame.setResizable(false);
	        
		    // setting the position of the frame to the middle of the screen
		    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		    frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
		    // setup the cards - Note: For adding cards, go to CardstackSetup
		    new CardstackSetup().addCards(frame.getContentPane());
		    
		    // creating the menu bar
		    MenuBar menuBar = new MenuBar();
		    menuBar.create(frame);
		    menuBar.show();
		    
	        // displaying the window.
	        frame.pack();
	        frame.setVisible(true);
		}
}
