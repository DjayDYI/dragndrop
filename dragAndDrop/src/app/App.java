package app;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Scanner;  // Import the Scanner class

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class App extends JFrame
{
	// instance private
	private static App singleton = null;
	private static final String DEFAULT_TITLE = "app";
	private static final Dimension DEFAULT_SIZE = new Dimension(800,600);
	
    private static final Menu menu = new Menu();
	private static final Toolbox toolbox = new Toolbox();
    private static final Workarea canvas = new Workarea();
    private static final BottomPage bottom = new BottomPage();


	
	//get instance static 
	public static App getInstance() {
		if (singleton == null)
				App.singleton = new App();
		return App.singleton;
	}
	
	
	// private constructor
	private App()
	{
	    super();
	    this.setTitle(DEFAULT_TITLE);
	    this.setMinimumSize(DEFAULT_SIZE);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setJMenuBar(menu);
	    this.setVisible(true);
	    this.add(new Layout.LayoutBuilder(new JPanel())
	    		.setSouth(bottom)
	    		.setWest(toolbox)
	    		.setCenter(canvas)
	    		.build());
	}

    
    public Toolbox.ToolState getCurrentTool(){
       return this.toolbox.getCurrentTool();
    }
    
    public Workarea getCanvas(){
        return this.canvas;
    }
    
    public BottomPage getBottomPage() {
    	return this.bottom;
    }
	
}
