package code;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

import code.gui.GUI;
import edu.buffalo.fractal.ColorModelFactory;
import edu.buffalo.fractal.FractalPanel;

public class Model {
		
	private GUI _observer;
	private FractalPanel _fractalPanel;
	private JFrame _frame;
	private Mandelbrot _mandelbrot;
	
	public Model() {
		_fractalPanel = new FractalPanel();
		_frame = new JFrame();
		_mandelbrot = new Mandelbrot();
	}
	public void addObserver(GUI gui) {
		_observer = gui;
		_observer.update();
	}
	
	public void selectExit(JMenuItem menuItem) {
//			System.exit(0);
//			_observer.update();	
	}
	
	public void selectMandelbrot(JMenuItem menuItem) {
//		_fractalPanel.setIndexColorModel(ColorModelFactory.createMyOwnColorModel(256));
//		_fractalPanel.updateImage(_mandelbrot.finalFractal());
//		_observer.getFrame().setVisible(true);
//		_observer.getFrame().add(_fractalPanel);
//		_observer.getFrame().pack();
//		_observer.update();
	}
}
