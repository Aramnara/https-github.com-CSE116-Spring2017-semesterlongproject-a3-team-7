package code.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.IndexColorModel;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
	private JMenuItem _fileMenuItem1;
	private JMenuItem _fileMenuItem2;
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

		_fileMenuItem1 = new JMenuItem("Change Escape Distance");
		_fileMenuItem1.setEnabled(true);
		_fileMenuItem2 = new JMenuItem("Exit");
		_fileMenuItem2.setEnabled(true);
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
		_colorMenuItem4 = new JMenuItem("Supreme Pink Golden Lightblue");
		_colorMenuItem4.setEnabled(true);
		
		JMenuBar menuBar = new JMenuBar();
		
		_fileMenuItem2.addActionListener(a);
		_fileMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		selectedColor();
		selectedFractal();
		
		fileMenu.add(_fileMenuItem1);
		fileMenu.add(_fileMenuItem2);
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
//		update();
		
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.pack();
		_frame.setVisible(true);
	}
	
	public void update() {
		_fileMenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				while (i <= 0) {
					String EscapeDistance = JOptionPane.showInputDialog("Please Enter Escape Distance");
					if (EscapeDistance.length()>0) {
						int escapeDistance = Integer.parseInt(EscapeDistance);
						_mandelbrot.escapeDistance(escapeDistance);
						_julia.escapeDistance(escapeDistance);
						_burningShip.escapeDistance(escapeDistance);
						_multibrot.escapeDistance(escapeDistance);
						System.out.println("Success");
						i += 1;
					} else {
						System.out.println("Please enter some number!");
					}
				}
			}
		});
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
				_fractalPanel.updateImage(_mandelbrot.finalFractal());
				_frame.setVisible(true);
				_frame.add(_fractalPanel);
				_frame.pack();
			}
		});
		_fractalMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_fractalPanel.updateImage(_julia.finalFractal());
				_frame.setVisible(true);
				_frame.add(_fractalPanel);
				_frame.pack();
			}
		});
		_fractalMenuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_fractalPanel.updateImage(_burningShip.finalFractal());
				_frame.setVisible(true);
				_frame.add(_fractalPanel);
				_frame.pack();
			}
		});
		_fractalMenuItem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_fractalPanel.updateImage(_multibrot.finalFractal());
				_frame.setVisible(true);
				_frame.add(_fractalPanel);
				_frame.pack();
			}
		});
	}
	
}
