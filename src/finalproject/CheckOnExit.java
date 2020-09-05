package finalproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CheckOnExit implements WindowListener{
	public void windowClosing(WindowEvent e) {
		ConfirmWindow checkers = new ConfirmWindow();
		checkers.setVisible(true);
	}
	public void windowOpened(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
}
