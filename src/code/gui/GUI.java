package code.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import code.BurningShip;
import code.Julia;
import code.Mandelbrot;
import code.Model;
import code.Multibrot;
import edu.buffalo.fractal.ColorModelFactory;
import edu.buffalo.fractal.FractalPanel;

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
	
	/**
	 * Composition of all the needed class.
	 */
	public GUI() {
		_fractalPanel = new FractalPanel();
		_mandelbrot = new Mandelbrot();
		_julia = new Julia();
		_burningShip = new BurningShip();
		_multibrot = new Multibrot();
		_model = new Model();
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
		
		//add each menu item into the menu
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
		//when clicked, the mandelbrot fractal would appear
		_fractalMenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_fractalPanel.updateImage(_mandelbrot.finalFractal());
				_frame.setVisible(true);
				_frame.add(_fractalPanel);
				_frame.pack();
			}
		});
		//when clicked, the julia fractal would appear
		_fractalMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_fractalPanel.updateImage(_julia.finalFractal());
				_frame.setVisible(true);
				_frame.add(_fractalPanel);
				_frame.pack();
			}
		});
		//when clicked, the burning ship fractal would appear
		_fractalMenuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_fractalPanel.updateImage(_burningShip.finalFractal());
				_frame.setVisible(true);
				_frame.add(_fractalPanel);
				_frame.pack();
			}
		});
		//when clicked, the multibrot fractal would appear
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
