package app;
import java.awt.Dimension;
import java.util.Scanner;  // Import the Scanner class

import javax.swing.JFrame;
import javax.swing.*;  

import java.awt.BorderLayout;
import java.awt.Component;

public class Layout extends JPanel
{
	
	//required parameters
	
	//optional
	private JComponent NORTH;
	private JComponent SOUTH;
	private JComponent EAST;
	private JComponent WEST;
	private JComponent CENTER;
	

	public JComponent getNorth()  {	return NORTH; }
	public JComponent getSouth()  {	return SOUTH; }
	public JComponent getEast()   {	return EAST; }
	public JComponent getWest()   {	return WEST; }
	public JComponent getCenter() {	return CENTER; }

	
	private Layout(LayoutBuilder builder) {
		this.NORTH=builder.NORTH;
		this.SOUTH=builder.SOUTH;
	    this.EAST=builder.EAST;
		this.WEST=builder.WEST;
		this.CENTER=builder.CENTER;
		
		this.setLayout(new BorderLayout());
		this.add(NORTH, BorderLayout.NORTH);
	    this.add(SOUTH, BorderLayout.SOUTH);
	    this.add(EAST, BorderLayout.EAST);
	    this.add(WEST, BorderLayout.WEST);
	    this.add(CENTER, BorderLayout.CENTER);
		
	}
	
	//Builder Class
	public static class LayoutBuilder{

		// required parameters


		// optional parameters
		private JComponent NORTH;
		private JComponent SOUTH;
		private JComponent EAST;
		private JComponent WEST;
		private JComponent CENTER;
		
		public LayoutBuilder() {}
		public LayoutBuilder(JComponent defaut){
			try {
				NORTH=defaut.getClass().newInstance();
				SOUTH=defaut.getClass().newInstance();
				EAST=defaut.getClass().newInstance();
				WEST=defaut.getClass().newInstance();
				CENTER=defaut.getClass().newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		public LayoutBuilder setNorth(JComponent _north) {
			NORTH = _north;
			return this;
		}
		
		public LayoutBuilder setSouth(JComponent _south) {
			SOUTH = _south;
			return this;
		}
		
		public LayoutBuilder setEast(JComponent _east) {
			EAST = _east;
			return this;
		}
		
		public LayoutBuilder setWest(JComponent _west) {
			WEST = _west;
			return this;
		}
		
		public LayoutBuilder setCenter(JComponent _center) {
			CENTER = _center;
			return this;
		}

		public Layout build(){
			return new Layout(this);
		}

	}

}

