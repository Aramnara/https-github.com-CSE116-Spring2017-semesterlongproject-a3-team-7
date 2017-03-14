package code.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.IndexColorModel;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import code.BurningShip;
import code.Julia;
import code.Mandelbrot;
import code.Model;
import code.Multibrot;
import edu.buffalo.fractal.ColorModelFactory;
import edu.buffalo.fractal.FractalPanel;

public class GUI implements Runnable {
	
	private JFrame _frame;
	private FractalPanel _fractalPanel;
	private Mandelbrot _mandelbrot;
	private Julia _julia;
	private BurningShip _burningShip;
	private Multibrot _multibrot;
	private ColorModelFactory _colorModelFactory;
	private Model _model;
	private JMenuItem _fractalMenuItem1;
	private JMenuItem _fractalMenuItem2;
	private JMenuItem _fractalMenuItem3;
	private JMenuItem _fractalMenuItem4;
	private JMenuItem _colorMenuItem1;
	private JMenuItem _colorMenuItem2;
	private JMenuItem _colorMenuItem3;
	private JMenuItem _colorMenuItem4;
	
	public GUI() {
		_fractalPanel = new FractalPanel();
		_mandelbrot = new Mandelbrot();
		_julia = new Julia();
		_burningShip = new BurningShip();
		_multibrot = new Multibrot();
		_colorModelFactory = new ColorModelFactory();
		_model = new Model();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new GUI());
	}
	
	public void run() {
		_frame = new JFrame("Fractals");
		
		ActionListener a;
		a = new EventHandler();
		
		JMenu fileMenu = new JMenu("File");
		JMenu fractalMenu = new JMenu("Fractal");
		JMenu colorMenu = new JMenu("Color");

		JMenuItem fileMenuItem1 = new JMenuItem("Exit");
		fileMenuItem1.setEnabled(true);
		_fractalMenuItem1 = new JMenuItem("Mandelbrot");
		_fractalMenuItem1.setEnabled(true);
		_fractalMenuItem2 = new JMenuItem("Julia");
		_fractalMenuItem2.setEnabled(true);
		_fractalMenuItem3 = new JMenuItem("BurningShip");
		_fractalMenuItem3.setEnabled(true);
		_fractalMenuItem4 = new JMenuItem("Multibrot");
		_fractalMenuItem4.setEnabled(true);
		_colorMenuItem1 = new JMenuItem("Rainbow");
		_colorMenuItem1.setEnabled(true);
		_colorMenuItem2 = new JMenuItem("Blues");
		_colorMenuItem2.setEnabled(true);
		_colorMenuItem3 = new JMenuItem("Grey");
		_colorMenuItem3.setEnabled(true);
		_colorMenuItem4 = new JMenuItem("Lightblue");
		_colorMenuItem4.setEnabled(true);
		
		JMenuBar menuBar = new JMenuBar();
		
		fileMenuItem1.addActionListener(a);
		fileMenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		selectedColor();
		selectedFractal();
		
		fileMenu.add(fileMenuItem1);
		fractalMenu.add(_fractalMenuItem1);
		fractalMenu.add(_fractalMenuItem2);
		fractalMenu.add(_fractalMenuItem3);
		fractalMenu.add(_fractalMenuItem4);
		colorMenu.add(_colorMenuItem1);
		colorMenu.add(_colorMenuItem2);
		colorMenu.add(_colorMenuItem3);
		colorMenu.add(_colorMenuItem4);
		menuBar.add(fileMenu);
		menuBar.add(fractalMenu);
		menuBar.add(colorMenu);
		_frame.setJMenuBar(menuBar);
		
		_model.addObserver(this);
		update();
		
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.pack();
		_frame.setVisible(true);
	}
	
	public void update() {

	}
	
	public void selectedColor() {
		_colorMenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_fractalPanel.setIndexColorModel(_colorModelFactory.createRainbowColorModel(226));
//				selectedFractal();
			}
		});
		_colorMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_fractalPanel.setIndexColorModel(_colorModelFactory.createBluesColorModel(226));
//				selectedFractal();
			}
		});
		_colorMenuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_fractalPanel.setIndexColorModel(_colorModelFactory.createGrayColorModel(226));
//				selectedFractal();
			}
		});
		_colorMenuItem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_fractalPanel.setIndexColorModel(_colorModelFactory.createMyOwnColorModel(226));
//				selectedFractal();
			}
		});
	}
	
//	public IndexColorModel defaultColor() {
//		return _colorModelFactory.createRainbowColorModel(226);
//	}
	
	public void selectedFractal() {
		_fractalMenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedFractal();
				_fractalPanel.updateImage(_mandelbrot.finalFractal());
				_frame.setVisible(true);
				_frame.add(_fractalPanel);
				_frame.pack();
			}
		});
		_fractalMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedFractal();
				_fractalPanel.updateImage(_julia.finalFractal());
				_frame.setVisible(true);
				_frame.add(_fractalPanel);
				_frame.pack();
			}
		});
		_fractalMenuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedFractal();
				_fractalPanel.updateImage(_burningShip.finalFractal());
				_frame.setVisible(true);
				_frame.add(_fractalPanel);
				_frame.pack();
			}
		});
		_fractalMenuItem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedFractal();
				_fractalPanel.updateImage(_multibrot.finalFractal());
				_frame.setVisible(true);
				_frame.add(_fractalPanel);
				_frame.pack();
			}
		});
	}
	
}
