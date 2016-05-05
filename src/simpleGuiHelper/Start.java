package simpleGuiHelper;

public class Start {
	
	public static void main(String[] args) {
        //creating and showing the applications' GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	// get contents from config.properties
            	new GetGlobal();
            	
                //create and show mainFrame
            	new MainFrame().create();
            }
        });
    }
}
