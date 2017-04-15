package code.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import code.BurningShip;
import code.Julia;
import code.Mandelbrot;
import code.Model;
import code.Mouse;
import code.Multibrot;
import edu.buffalo.fractal.ColorModelFactory;
import edu.buffalo.fractal.FractalPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

/**
 * This class contains all the method and the GUI that is needed to generate 
 * different fractals.
 * 
 * @author Zhenduo Lin
 * @author Anthony Ramnarain
 * @author JaeHoon Oh
 */
public class GUI implements Runnable {
	
	private JFrame _frame; //provide a window for GUI
	private FractalPanel _fractalPanel; //contains required method for updating the fractal image
	private Mandelbrot _mandelbrot; //access to the code in that class
	private Julia _julia; //access to the code in that class
	private BurningShip _burningShip; //access to the code in that class
	private Multibrot _multibrot; //access to the code in that class
	private Model _model; //access to the code in that class
	private JMenuItem _fileMenuItem0;
	private JMenuItem _fileMenuItem1; //menu item in file menu
	private JMenuItem _fileMenuItem2; //menu item in file menu
	private JMenuItem _fractalMenuItem1; //menu item in fractal menu
	private JMenuItem _fractalMenuItem2; //menu item in fractal menu
	private JMenuItem _fractalMenuItem3; //menu item in fractal menu
	private JMenuItem _fractalMenuItem4; //menu item in fractal menu
	private JMenuItem _colorMenuItem1; //menu item in color menu
	private JMenuItem _colorMenuItem2; //menu item in color menu
	private JMenuItem _colorMenuItem3; //menu item in color menu
	private JMenuItem _colorMenuItem4; //menu item in color menu
	private Mouse _mouse;
	private int _startX, _startY;
	private int _prevX, _prevY;
	private boolean _dragging;
	private Graphics _g;
	double[] _xSet;
	double[] _ySet;
//	double[] _juliaXset;
//	double[] _juliaYset;
//	double[] _burningShipXset;
//	double[] _burningShipYset;
//	double[] _multibrotXset;
//	double[] _multibrotYset;
	int[][] _image;
	double _newXmin;
	double _newXmax;
	double _newYmin;
	double _newYmax;
	
	/**
	 * Composition of all the needed class.
	 */
	public GUI() {
		_fractalPanel = new FractalPanel();
//		_fractalPanel.addMouseListener(_mouse);
//		_fractalPanel.addMouseMotionListener(_mouse);
		_mandelbrot = new Mandelbrot();
		_julia = new Julia();
		_burningShip = new BurningShip();
		_multibrot = new Multibrot();
		_model = new Model();
		_mouse = new Mouse();
//		_mandelbrotXset = _mandelbrot.xCoordinate(-2.15, 0.6);
//		_mandelbrotYset = _mandelbrot.yCoordinate(-1.3, 1.3); 
//		_juliaXset = _julia.xCoordinate(-1.7, 1.7);
//		_juliaYset = _julia.yCoordinate(-1, 1);
		_newXmin = 0.0;
		_newYmin = 0.0;
		_newXmax = 0.0;
		_newYmax = 0.0;
	}
	
	/**
	 * Provide the entire GUI frame.
	 */
	public void run() {
		_frame = new JFrame("Fractals");  //entire frame
		
		//three menus in the frame
		JMenu fileMenu = new JMenu("File");  
		JMenu fractalMenu = new JMenu("Fractal"); 
		JMenu colorMenu = new JMenu("Color");
		
		//all the menu items contained in each of the menu
		_fileMenuItem0 = new JMenuItem("Change Escape Time");
		_fileMenuItem0.setEnabled(true);
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
		
		JMenuBar menuBar = new JMenuBar(); //menu bar
		
		//ActionListener used to observe and allow the input by user
		ActionListener a;
		a = new EventHandler(_model);
//		ActionListener b;
//		b = new EventHandler(_model);
//		_fileMenuItem0.addActionListener(b);
		//when clicked, pop out the window for changing the escape distance.
		_fileMenuItem1.addActionListener(a);
		//when clicked, exit the program
		_fileMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		selectedColor();  //select color for fractal
		selectedFractal(); //select fractal
		escapeTime();
		Mouse();
//		_fractalPanel.addMouseListener(_mouse);
//		_fractalPanel.addMouseMotionListener(_mouse);
		
		//add each menu item into the menu
		fileMenu.add(_fileMenuItem0);
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
		
		_model.addObserver(this); //for observe the GUI
		
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when click exit, exit the program
		_frame.pack(); //auto-size the window
		_frame.setVisible(true); //show the window
	}
	
	/**
	 * used to change the escape distance that user entered.
	 */
	public void update() {
		int i = 0;
		//a loop that restricting only 1 option pane appeared when clicked
		while (i <= 0) {
			//option pane allows user to enter escape distance
			String EscapeDistance = JOptionPane.showInputDialog("Please Enter Escape Distance");
			if (EscapeDistance.length()>0) {
				int escapeDistance = Integer.parseInt(EscapeDistance); //change the String input into int
				//calling the method from each of four fractal classes to update the entered escape distance
				_mandelbrot.escapeDistance(escapeDistance);
				_julia.escapeDistance(escapeDistance);
				_burningShip.escapeDistance(escapeDistance);
				_multibrot.escapeDistance(escapeDistance);
				//showing the error message when entering an invalid escape distance
				if (escapeDistance < 1) {
					JOptionPane.showMessageDialog(null,"The entered escape distance is invalid.","Error" ,JOptionPane.ERROR_MESSAGE);
					_model.changeEscapeDistance(); //reopen the option pane
				}
				i += 1;
			} else {
				System.out.println("Please enter some number!");
			}
		}
	}
	
	public void escapeTime() {
		_fileMenuItem0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				while (i <= 0) {
					String EscapeTime = JOptionPane.showInputDialog("Please Enter Escape Time");
					if (EscapeTime.length()>0) {
						int escapeTime = Integer.parseInt(EscapeTime);
						_mandelbrot.escapeDistance(escapeTime);
						_julia.escapeDistance(escapeTime);
						_burningShip.escapeDistance(escapeTime);
						_multibrot.escapeDistance(escapeTime);
						if (escapeTime < 1 || escapeTime > 255) {
							JOptionPane.showMessageDialog(null,"The entered escape time is invalid.","Error" ,JOptionPane.ERROR_MESSAGE);
							_model.changeEscapeTime(); 
						}
						i += 1;
					} else {
						System.out.println("Please enter some number!");
					}
				}
			}
		});
	}
	
	/*
	 * This method allows to set the color for fractals when each of the menu item is selected 
	 */
	public void selectedColor() {
		//when clicked, set the color to rainbow
		_colorMenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_fractalPanel.setIndexColorModel(ColorModelFactory.createRainbowColorModel(226));
			}
		});
		//when clicked, set the color to blue
		_colorMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_fractalPanel.setIndexColorModel(ColorModelFactory.createBluesColorModel(226));
			}
		});
		//when clicked, set the color to grey
		_colorMenuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_fractalPanel.setIndexColorModel(ColorModelFactory.createGrayColorModel(226));
			}
		});
		//when clicked, set the color to supreme pink golden lightblue
		_colorMenuItem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_fractalPanel.setIndexColorModel(ColorModelFactory.createMyOwnColorModel(226));
			}
		});
	}
	
	/**
	 * This method allows to choose the fractal that user want to depict.
	 */
	public void selectedFractal() {
		_newXmin = 0.0;
		_newYmin = 0.0;
		_newXmax = 0.0;
		_newYmax = 0.0;
		//when clicked, the mandelbrot fractal would appear
		_fractalMenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_fractalPanel.updateImage(_mandelbrot.finalFractal(-2.15, 0.6, -1.3, 1.3));
				_xSet = _mandelbrot.xCoordinate(-2.15, 0.6);
				_ySet = _mandelbrot.yCoordinate(-1.3, 1.3);
//				_image = _mandelbrot.finalFractal(_newXmin, _newXmax, _newYmin, _newYmax);
				_frame.setVisible(true);
				_frame.add(_fractalPanel);
				_frame.pack();
			}
		});
		//when clicked, the julia fractal would appear
		_fractalMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_fractalPanel.updateImage(_julia.finalFractal(-1.7, 1.7, -1, 1));
				_xSet = _julia.xCoordinate(-1.7, 1.7);
				_ySet = _julia.yCoordinate(-1, 1);
//				_image = _julia.finalFractal(_newXmin, _newXmax, _newYmin, _newYmax);
				_frame.setVisible(true);
				_frame.add(_fractalPanel);
				_frame.pack();
			}
		});
		//when clicked, the burning ship fractal would appear
		_fractalMenuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_fractalPanel.updateImage(_burningShip.finalFractal(-1.8, -1.7, -0.08, 0.025));
				_frame.setVisible(true);
				_frame.add(_fractalPanel);
				_frame.pack();
			}
		});
		//when clicked, the multibrot fractal would appear
		_fractalMenuItem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_fractalPanel.updateImage(_multibrot.finalFractal(-1, 1, -1.3, 1.3));
				_frame.setVisible(true);
				_frame.add(_fractalPanel);
				_frame.pack();
			}
		});
	}
	public JMenuItem fileMenuItem0() {
		return _fileMenuItem0;
	}
	public JMenuItem fileMenuItem1() {
		return _fileMenuItem1;
	}
	public void Mouse() {
		_fractalPanel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Component src = (Component) e.getSource();
				e.getSource();
				_startX = e.getX();
				_startY = e.getY();
				_prevX = _startX;
				_prevY = _startY;
				
			}

			public void mouseReleased(MouseEvent e) {
				Component src = (Component) e.getSource();
				int x = e.getX();
				int y = e.getY();
				_newXmin = _xSet[_startX];
				_newYmin = _ySet[_startY]; 
				_newXmax = _xSet[x];
				_newYmax = _ySet[y];
				_xSet = _mandelbrot.xCoordinate(_newXmin, _newXmax);
				_ySet = _mandelbrot.yCoordinate(_newYmin, _newYmax);
//				if (selectedFractal() == _fractalMenuItem1) {
					_image = _mandelbrot.finalFractal(_newXmin, _newXmax, _newYmin, _newYmax);
//				}
//				else if(e.getSource() == _julia) {
//					_image = _julia.finalFractal(_newXmin, _newXmax, _newYmin, _newYmax);
//				}
				_fractalPanel.updateImage(_image);
				
			}
		});
		_fractalPanel.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Component src = (Component) e.getSource();
				int x = e.getX();
				int y = e.getY();
				_g = src.getGraphics();
				_g.setColor(Color.BLUE);
				_g.drawRect(_startX, _startY, Math.abs(x-_startX), Math.abs(y-_startY));
				src.paint(_g);
				_prevX = x;
				_prevY = y;
			}
		});
	}
}
