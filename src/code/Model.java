package code;

import code.gui.GUI;

/**
 * This class contains the calculation that is being observed by GUI.
 * 
 * @author Zhenduo Lin
 */
public class Model {
		
	private GUI _observer; // instance variable of type class GUI
	
	public Model() {
	}
	
	/**
	 * This method is used to make the association of GUI.
	 * @param gui = type class GUI, which is used for association.
	 */
	public void addObserver(GUI gui) {
		_observer = gui;  //association of GUI 
	}
	
	/**
	 * This method is used to change the escape distance observed in the update method.
	 */
	public void changeEscapeDistance() {
		_observer.update();   //tell the GUI to update
	}
	
}
