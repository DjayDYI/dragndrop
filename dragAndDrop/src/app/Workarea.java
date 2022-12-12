package app;

import javax.swing.*;  

import java.util.ArrayList;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Workarea extends JPanel implements MouseListener, MouseMotionListener
{
    private ArrayList<box> comp = new ArrayList();
    private box current = null;
    private int cursorType = box.DRAG;

    public Workarea()
	{
		this.setBackground(Color.white);	
        this.addMouseListener(this);
	}
	
    public void add(int x, int y){
        box b = new box(x,y);
        b.addMouseListener(this);
        b.addMouseMotionListener(this);
        this.comp.add(b);
        this.add(b);
    }
    
    private void unselectAll(){
        for(box c: comp){
            c.unselect();   
        }
    }
    
    public void setCursorType(int _c){
        cursorType = _c;
    }
    
    	
	/**
	* Mouse events
	*/
	public void mousePressed(MouseEvent e) {
		
        if(App.getInstance().getCurrentTool().equals(Toolbox.ToolState.CREATE)){
            if(e.getSource() instanceof Workarea){
                this.unselectAll();
                this.add(e.getX(),e.getY());
            }
            if(e.getSource() instanceof box){
	            current = (box) e.getSource();     
            }
       }
        
        if(App.getInstance().getCurrentTool().equals(Toolbox.ToolState.DELETE)){            
            this.removeAll();
            this.comp.clear();
            this.revalidate();
        }
        
        if(App.getInstance().getCurrentTool().equals(Toolbox.ToolState.SELECT)){            
                this.unselectAll();
                for(box b:comp){
                    if(b == e.getSource()){
                        b.select();
                        current = b;
                    } else {
                        b.unselect();
                    }
                }   

        }
        this.repaint();   

	}

	public void mouseReleased(MouseEvent e) {
        current = null;
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mouseClicked(MouseEvent e) {
        //if(App.getInstance().getCurrentTool().equals(Toolbox.ToolState.MOVE)){            
            if(e.getSource() instanceof Workarea){
                for(box b:comp){
                    if(b.isSelected()){
                        b.setPosition(e.getX(), e.getY());
                    }
                }     
            }
        //}
	}

    public void mouseDragged(MouseEvent e) {
        if(current != null){
        	if(e.getSource() == current) {
            switch(cursorType){
                case box.DRAG:
                   int delta_x = e.getX()+current.getX();
                   int delta_y = e.getY()+current.getY();
                   current.setPosition(delta_x, delta_y);  
                break;
                case box.SOUTH:
                    current.setHeight(e.getY());
                break;
                case box.NORTH:
                    current.setHeight(current.height()-e.getY());
                    current.setPosition(current.getX(), current.getY()+e.getY());
                break;
                case box.EAST:
                    current.setWidth(e.getX());                
                    break;
                case box.WEST:
                    current.setWidth(current.width()-e.getX());
                    current.setPosition(current.getX()+e.getX(),current.getY());
                break;
                case box.NORTH_EAST:
                	current.setSize(e.getX(), current.height()-e.getY());
                    current.setPosition(current.getX(), current.getY()+e.getY());
                	break;
                case box.SOUTH_EAST:
                	current.setHeight(e.getY());
                    current.setWidth(e.getX());                
                	break;
                case box.NORTH_WEST:
                	current.setSize(current.width()-e.getX(), current.height()-e.getY());
                    current.setPosition(current.getX()+e.getX(), current.getY()+e.getY());
                    break;
                case box.SOUTH_WEST:
                	current.setSize(current.width()-e.getX(), e.getY());
                    current.setPosition(current.getX()+e.getX(),current.getY());
                	break;
                default:                     
                	break;
                }
        	}
        }
    }
    
    public void mouseMoved(MouseEvent e) {

   }
}
   

