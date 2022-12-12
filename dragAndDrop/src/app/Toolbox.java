package app;

import javax.swing.*;  

import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseListener; // seems to be missing.


public class Toolbox extends JPanel implements MouseListener
{
    // CONSTANTES
    private static String STRING_SELECT = "hand_stop.png";
    private static String STRING_BOX = "box.gif";
    private static String STRING_MOVE = "hand_touch3.png";
    private static String STRING_RESIZE = "gif.png";
    private static String STRING_DELETE = "chainsaw.png";

    
    /**
     * Enum tool state
     */
    public enum ToolState{
           SELECT(STRING_SELECT),
           CREATE(STRING_BOX),
           MOVE(STRING_MOVE),
           RESIZE(STRING_RESIZE),
           DELETE(STRING_DELETE);
        
        private final String name;
        
        private ToolState(String name){
            this.name = name;
        }
        
        public String getName(){
            return this.name;
        }
    }
    
    private ToolState current = null;

    
	public Toolbox()
	{
		this.setBackground(Color.lightGray);
        createButtonIcon(ToolState.SELECT);
		createButtonIcon(ToolState.CREATE);
		createButtonIcon(ToolState.MOVE);
		createButtonIcon(ToolState.RESIZE);
		createButtonIcon(ToolState.DELETE);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	    this.current = ToolState.CREATE;
	}
	
	//** CREATE ICON */	
	private void createButtonIcon(ToolState _current){
		JLabel j = new JLabel(new ImageIcon("/home/san/eclipse-workspace/dragAndDrop/src/icon/" + _current.getName(), "test"));
        j.setName(_current.getName());
        j.addMouseListener(this);        
        this.add(j);
	}
    
    public ToolState getCurrentTool(){
        return this.current;
    }
    
    /**
	* Mouse events
	*/
	public void mousePressed(MouseEvent e) {
		String s = ((JLabel)e.getSource()).getName();
        
        if (s.equals(ToolState.CREATE.getName())){
	           this.current = ToolState.CREATE;
        }else if(s.equals(ToolState.MOVE.getName())){
	           this.current = ToolState.MOVE;
        }else if (s.equals(ToolState.RESIZE.getName())){
	           this.current = ToolState.RESIZE;
        }else if (s.equals(ToolState.DELETE.getName())){
	           this.current = ToolState.DELETE;        
        }else if (s.equals(ToolState.SELECT.getName())){
        	   this.current = ToolState.SELECT;        
        }
	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mouseClicked(MouseEvent e) {

	}
    
}

