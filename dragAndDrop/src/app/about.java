package app;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class about extends JDialog implements ActionListener {
	public about () {
	      this.setBounds(132, 132, 300, 200);
	      Container dialogContainer = this.getContentPane();
	      JLabel cvLabel = new JLabel("http://www.linkedin.com/in/jboucherveilleux/");
	      JButton okButton = new JButton("Ok");
	      okButton.addActionListener(this);
	      this.add(new Layout.LayoutBuilder(new JPanel())
		    		.setSouth(okButton)
		    		.setCenter(cvLabel)
		    		.build());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
	}
		         

}
