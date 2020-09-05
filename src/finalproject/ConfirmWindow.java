package finalproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConfirmWindow extends JFrame implements ActionListener{
	public ConfirmWindow() {
		setSize(200, 100);
		setLayout(new BorderLayout());
		JLabel confirmLabel = new JLabel("Are you sure you want to exit");
		add(confirmLabel, BorderLayout.CENTER);
		JButton exitButton = new JButton("Yes");
		exitButton.addActionListener(this);
		add(exitButton, BorderLayout.SOUTH);
		this.setLocationRelativeTo(null);
	}
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
