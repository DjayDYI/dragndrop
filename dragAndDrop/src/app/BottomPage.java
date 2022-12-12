package app;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BottomPage extends JPanel{
	private final static String Status = "Ready!";

	public BottomPage() {
		JPanel bottomPanel = new JPanel();
		bottomPanel.add(new JLabel(Status));
		this.setBackground(Color.lightGray);
		this.add(bottomPanel);
	}
}
