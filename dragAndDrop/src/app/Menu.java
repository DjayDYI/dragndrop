package app;

import javax.swing.*; 
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//TODO: ENUM

public class Menu extends JMenuBar implements MouseListener
{
	private static final String   FILE = "File";
	private static final String   OPEN = "Open";
	private static final String   SAVE = "Save";
	private static final String   EXIT = "Exit";
	private static final String[] FILE_MENU =  { OPEN, SAVE, EXIT };
	
	private static final String   FILE2 = "SUB MENU";
	private static final String   A1 = "ACTION 1";
	private static final String   A2 = "ACTION 2";
	private static final String[] FILE_MENU2 = { A1, A2 };
	
	private static final String   EDIT = "Edit";
	private static final String   CUT = "Cut";
	private static final String   COPY = "Copy";
	private static final String   PASTE = "Paste";
	private static final String   PREVIOUS = "Previous";
	private static final String   NEXT = "Next";
	private static final String[] EDIT_MENU =  { CUT, COPY, PASTE, PREVIOUS, NEXT };
	
	private static final String   ABOUT = "About";


	/**
	 *	Constructor
	 */
	protected Menu()
	{
	  super();

	  //MENU FILE
	  JMenu f = addMenu(FILE, FILE_MENU);
          addSubMenu(f, FILE2, FILE_MENU2);
          
          //MENU ABOUT
	  addMenu(EDIT, EDIT_MENU);
          
          //MENU ABOUT
	  addMenu(ABOUT);

	}
	
	/**
	 * Function to add items
	 */
	
	private void addMenu(String _name)
	{
	    this.add(createMenu(_name));
	}

	private JMenu addMenu(String _name, String[] _itemName)
	{
	    JMenu m = createMenu(_name);
	    addMenuItem(m, _itemName); 
	    this.add(m);
	    return m;
	}
	
	private void addSubMenu(JMenu _parent,String _name, String[] _itemName)
	{
	    JMenu m = createMenu(_name);
	    addMenuItem(m, _itemName); 
	    _parent.add(m);
	}
	
	
	/**
	 * Function to create items
	 */
	private JMenu createMenu(String _name)
	{
	    JMenu m = new JMenu(_name);
	    m.setName(_name);
	    m.addMouseListener(this);
	    return m;
	}
	
	private void addMenuItem(JMenu _menu, String[] _name)
	{
		for(String i: _name)
		{
			JMenuItem items = new JMenuItem(i);
			items.setName(i);
	    		items.addMouseListener(this);
			_menu.add(items);
		}
	}
	
	
	/**
	* Mouse events
	*/
	public void mousePressed(MouseEvent e) {
	saySomething("Mouse pressed; # of clicks: " + e.getClickCount(), e);
		
		String s = ((JMenuItem)e.getSource()).getName();
		
		if (s.equals(EXIT)){ App.getInstance().dispose(); }
		if (s.equals(ABOUT)){ new about().setVisible(true); }
		
	}

	public void mouseReleased(MouseEvent e) {
	saySomething("Mouse released; # of clicks: " + e.getClickCount(), e);
	}

	public void mouseEntered(MouseEvent e) {
	saySomething("Mouse entered", e);
	}

	public void mouseExited(MouseEvent e) {
	saySomething("Mouse exited", e);
	}

	public void mouseClicked(MouseEvent e) {
	saySomething("Mouse clicked (# of clicks: "+ e.getClickCount() + ")", e);

	}

	void saySomething(String eventDescription, MouseEvent e) {
	System.out.println(eventDescription + " detected on "
		        + e.getComponent().getClass().getName());
	}
		
}
