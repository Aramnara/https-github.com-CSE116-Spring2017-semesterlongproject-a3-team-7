package code.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import code.Model;

public class EventHandler implements ActionListener {
	
	private Model _model;
	private JMenuItem _menuItem1;
	private JMenuItem _meunItem2;
	private GUI _gui;
	
	public EventHandler() {
		_model = new Model();
		_menuItem1 = new JMenuItem("Exit");
		_meunItem2 = new JMenuItem("Mandelbrot");
		_gui = new GUI();
	}
	
	public void actionPerformed(ActionEvent e) {

	}

}