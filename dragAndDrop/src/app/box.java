package app;

import javax.swing.*;  


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class box extends JPanel implements MouseMotionListener
{
	private static final int DEFAULT_HEIGHT = 60;
    private static final int DEFAULT_WIDTH = 60;
    
    public static final int DRAG = 0;
    public static final int NORTH_EAST = 1;
    public static final int NORTH_WEST = 2;
    public static final int SOUTH_EAST = 3;
    public static final int SOUTH_WEST = 4;
    public static final int NORTH = 5;
    public static final int SOUTH = 6;
    public static final int EAST = 7;
    public static final int WEST = 8;
    
      
    private int w = DEFAULT_WIDTH;
    private int h = DEFAULT_HEIGHT;
    private int x = 0;
    private int y = 0;
    private boolean selected = false;
      
	public box(int _x, int _y)
	{
        super();
		this.setBackground(Color.yellow);	
        this.setPosition(_x,_y);
        this.addMouseMotionListener(this);
        this.select();
	}
	
	public void setPosition(int x, int y)
	{
        this.x = x;
        this.y = y;
        this.setBounds(this.x,this.y,this.w,this.h);
	}
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public void unselect(){
        this.selected=false;
        this.setBackground(Color.yellow);
    }
    
    public void select(){
        if(!selected){
            this.selected=true;
            this.setBackground(Color.red);	
        }else{
            unselect();
        }   
    }
    
    public boolean isSelected(){
        return this.selected;
    }
    
    public int height(){
        return this.h;
    }
    
    public int width(){
        return this.w;
    }
        
    public void setWidth(int width){   
        this.w = width;
        this.setBounds(this.x,this.y,width,this.h);
    }
    
    public void setHeight(int height){   
        this.h = height;
        this.setBounds(this.x,this.y,this.w,height);
    }
    
    public void setSize(int width, int height){   
        this.w = width;
        this.h = height;
        this.setBounds(this.x,this.y,width,height);
    }

	/**
	* Mouse events
	*/
	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {
        
	}

	public void mouseExited(MouseEvent e) {

	}

	public void mouseClicked(MouseEvent e) {
        
	}

	public void mouseDragged(MouseEvent e) {

    }  
    
    public void mouseMoved(MouseEvent e) {
   	 if (e.getSource() instanceof box){
         if((e.getY() > (this.height()-5)) && (e.getX() < 5)){ 
             setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR)); 
             App.getInstance().getCanvas().setCursorType(SOUTH_WEST);
         }

         else if((e.getY() > (this.height()-5)) && (e.getX() > this.width()-5)){ 
             setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR)); 
             App.getInstance().getCanvas().setCursorType(SOUTH_EAST);
         }

         else if((e.getY() < 5) && (e.getX() < 5)){ 
             setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
             App.getInstance().getCanvas().setCursorType(NORTH_WEST);
         }

         else if((e.getY() < 5) && (e.getX() > (this.width()-5))){ 
             setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
             App.getInstance().getCanvas().setCursorType(NORTH_EAST);
         }

         else if(e.getY() > (this.height()-5)){ 
             setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR)); 
             App.getInstance().getCanvas().setCursorType(SOUTH);
         }

         else if(e.getX() < 5){ 
             setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
             App.getInstance().getCanvas().setCursorType(WEST);
         }

         else if(e.getX() > (this.width()-5)){ 
             setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
             App.getInstance().getCanvas().setCursorType(EAST);
         }

         else if(e.getY() < 5){ 
             setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
             App.getInstance().getCanvas().setCursorType(NORTH);
         }

         else { 
             setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
             App.getInstance().getCanvas().setCursorType(DRAG);
         }
    }
  }
}

