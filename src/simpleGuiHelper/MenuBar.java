package simpleGuiHelper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import cardManager.CardSwitcher;
import cardManager.CardstackSetup;


public class MenuBar {
	
	public JFrame frame;
	public JMenuBar jmb;
	
	/**
	 * create
	 * 
	 * Method for creating the main menubar on the inner top of the main frame.
	 * 
	 * @param frame JFrame	Frame on which the menubar should be anchored
	 */
	public void create(JFrame frame) {
		this.frame = frame;
		
		// setting up the Menubar
	    JMenuBar jmb = new JMenuBar();
	    
	    // ######################################
	    // # MENUBAR - MAIN BUTTONS             #
	    // ######################################
	    JMenu jmMenu = new JMenu("Menu");
	    JMenu jmAbout = new JMenu("About");
	    
	    // ######################################
	    // # MENU - SUB BUTTONS 				#
	    // ######################################
	    // subs for jmMenu
	    JMenuItem jmiSettings = new JMenuItem("Settings");
	    JMenuItem jmiExit = new JMenuItem("Exit");
	    // event listener for jmMenu subs
	    jmiSettings.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	new CardSwitcher(CardstackSetup.getCards(), CardstackSetup.SETTINGSCARD);
		    }
		});
	    jmiExit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		            System.exit(0);
		    }
		});
	 	// ######################################
	    // # ADD THE SUB ELEMENTS OF jmMenu     #
	    // ######################################
	    jmMenu.add(jmiSettings);
	    jmMenu.addSeparator();
	    jmMenu.add(jmiExit);
	    
	    // ######################################
	    // # ABOUT - SUB BUTTONS 				#
	    // ######################################
	    // subs for jmAbout
	    JMenuItem jmiQuestion = new JMenuItem("?");
	    // event listener for jmAbout subs
	    jmiQuestion.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	new CardSwitcher(CardstackSetup.getCards(), CardstackSetup.ABOUTCARD);
		    }
		});
	    // ######################################
	    // # ADD THE SUB ELEMENTS OF jmAbout    #
	    // ######################################
	    jmAbout.add(jmiQuestion);
	    
	    
	    // storing jMenuBar
	    this.jmb = jmb;
	    // ######################################
	    // # ADD THE SECTIONS TO jMenuBar		#
	    // ######################################
	    jmb.add(jmMenu);
	    jmb.add(jmAbout);
	}
	
	public void show() {
		this.frame.setJMenuBar(this.jmb);
	}
	
}
