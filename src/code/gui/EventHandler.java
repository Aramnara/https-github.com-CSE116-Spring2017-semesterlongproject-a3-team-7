package code.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.Model;

/**
 * This class provides the EventHandler for the JMenuItem of 
 * changing the escape distance.
 * 
 * @author Zhenduo Lin
 */
public class EventHandler implements ActionListener {
	
	private Model _model; //access to the Model class
	private GUI _gui;
	
	/**
	 * This method is association of Model class.
	 * @param m = type Model used for association.
	 */
	public EventHandler(Model m) {
		_model = m; //association
		_gui = new GUI();
	}
	
	/**
	 * This method allows to handle the change from the model class.
	 */
	public void actionPerformed(ActionEvent e) {
//		Object obj = e.getSource();
//		if (e.getSource() == _gui.fileMenuItem0()) {
//			_model.changeEscapeTime();	
//		} else {
//			_model.changeEscapeDistance();			
//		}
		_model.changeEscapeDistance();
//		_model.changeEscapeTime();
	}
}