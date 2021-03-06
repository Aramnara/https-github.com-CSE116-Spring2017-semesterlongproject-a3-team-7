package code.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.SwingWorker;

import code.BurningShip;
import code.Julia;
import code.Mandelbrot;
import code.Model;
import code.Multibrot;
import edu.buffalo.fractal.ColorModelFactory;
import edu.buffalo.fractal.ComputePool;
import edu.buffalo.fractal.FractalPanel;
import edu.buffalo.fractal.WorkerResult;

import java.awt.event.MouseMotionAdapter;
import java.beans.PropertyChangeEvent;

/**
 * This class contains all the method and the GUI that is needed to generate 
 * different fractals.
 * 
 * @author Zhenduo Lin
 * @author Anthony Ramnarain
 * @author JaeHoon Oh
 */
public class GUI implements Runnable{
	
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
	private JMenuItem _fileMenuItem3; //menu item in file menu
	private JMenuItem _fileMenuItem4; //menu item in file menu
	private JMenuItem _fractalMenuItem1; //menu item in fractal menu
	private JMenuItem _fractalMenuItem2; //menu item in fractal menu
	private JMenuItem _fractalMenuItem3; //menu item in fractal menu
	private JMenuItem _fractalMenuItem4; //menu item in fractal menu
	private JMenuItem _colorMenuItem1; //menu item in color menu
	private JMenuItem _colorMenuItem2; //menu item in color menu
	private JMenuItem _colorMenuItem3; //menu item in color menu
	private JMenuItem _colorMenuItem4; //menu item in color menu
	private int _startX, _startY; // starting x-coordinate and y-coordinate in type int when dragging
	private Graphics _g; // graphics item appeared to draw the rectangle when dragging
	double[] _xSet; // array of x-coordinates in type double 
	double[] _ySet; // array of y-coordinates in type double
	int[][] _image; // image generated by different set in type 2d-array
	double _newXmin; // the corresponding minimum x-value of the new coordinate in type double
	double _newXmax; // the corresponding maximum x-value of the new coordinate in type double
	double _newYmin; // the corresponding minimum y-value of the new coordinate in type double
	double _newYmax; // the corresponding maximum y-value of the new coordinate in type double
	private WorkerClass _workerClass; // instance of the subclass of SwingWorker 
	private int _startingRows=0; // starting row of the SwingWorker
	private int _endingRows=2048; // ending row of the SwingWorker
	private ComputePool _pool; // instance of the ComputePool class
	private WorkerResult _result; // instance of the WorkerResult class
	private SwingWorker<WorkerResult, Void>[] _workerArray; // instance of the SwingWorker array
	private int _thread=0; // number of thread 
	
	/**
	 * Composition of all the needed class.
	 * Instantiation of all the needed instance variables.
	 */
	public GUI() {
		_fractalPanel = new FractalPanel();
		_mandelbrot = new Mandelbrot();
		_julia = new Julia();
		_burningShip = new BurningShip();
		_multibrot = new Multibrot();
		_model = new Model();
		_newXmin = 0.0;
		_newYmin = 0.0;
		_newXmax = 0.0;
		_newYmax = 0.0;
		_workerClass = new WorkerClass(_startingRows, _endingRows);
		_pool = new ComputePool();
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
		
		//Set the size of fractalPanel to 2048 * 2048
		_fractalPanel.setPreferredSize(new Dimension(2048, 2048));
		
		//all the menu items contained in each of the menu
		_fileMenuItem0 = new JMenuItem("Change Escape Time");
		_fileMenuItem0.setEnabled(true);
		_fileMenuItem1 = new JMenuItem("Change Escape Distance");
		_fileMenuItem1.setEnabled(true);
		_fileMenuItem2 = new JMenuItem("Reset zoom");
		_fileMenuItem2.setEnabled(true);
		_fileMenuItem4 = new JMenuItem("Change SwingWorker Instances");
		_fileMenuItem4.setEnabled(true);
		_fileMenuItem3 = new JMenuItem("Exit");
		_fileMenuItem3.setEnabled(true);
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
		_fileMenuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		selectedColor();  //select color for fractal
		selectedMandelbrot(); //when selecting Mandelbrot, generate the fractal, and return true
		selectedJulia(); //when selecting Julia, generate the fractal, and return true
		selectedBurningShip(); //when selecting BurningShip, generate the fractal, and return true
		selectedMultibrot(); //when selecting Multibrot, generate the fractal, and return true
		selectedMandelbrot(); //when selecting Mandelbrot, generate the fractal, and return true
		selectedJulia(); //when selecting Julia, generate the fractal, and return true
		selectedBurningShip(); //when selecting BurningShip, generate the fractal, and return true
		selectedMultibrot();//when selecting Multibrot, generate the fractal, and return true
		reset(); //reset the zoom of the fractal to default
		maximumEscapeTime(); //when selecting the change escape time menuitem, pops out a window that allows user to enter the escape time
		Mouse(); //To activate and enable all the event regarding the mouse
		_workerClass.changeSwingWorkerInstance(); // allows user to enter number of thread the program going to use
		
		//add each menu item into the menu
		fileMenu.add(_fileMenuItem0);
		fileMenu.add(_fileMenuItem1);
		fileMenu.add(_fileMenuItem2);
		fileMenu.add(_fileMenuItem4);
		fileMenu.add(_fileMenuItem3);
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
		_frame.setJMenuBar(menuBar); //add menubar into frame
		
		_model.addObserver(this); //for observe the GUI
		
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when click exit, exit the program
		_frame.setResizable(false); // stay the size of frame on 2048 * 2048
		_frame.setVisible(true); //show the window
		_frame.pack(); //auto-size the window
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
	
	/**
	 * used to change the maximum escape time that user entered
	 */
	public void maximumEscapeTime() {
		_fileMenuItem0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				//a loop that restricting only 1 option pane appeared when clicked
				while (i <= 0) {
					//option pane allows user to enter escape Time
					String MaximumEscapeTime = JOptionPane.showInputDialog("Please Enter Maximm Escape Time");
					if (MaximumEscapeTime.length()>0) {
						int escapeTime = Integer.parseInt(MaximumEscapeTime);
						//calling the method from each of four fractal classes to update the entered escape time
						_mandelbrot.escapeTime(escapeTime);
						_julia.escapeTime(escapeTime);
						_burningShip.escapeTime(escapeTime);
						_multibrot.escapeTime(escapeTime);
						//showing the error message when entering an invalid escape distance
						if (escapeTime < 1 || escapeTime > 255) {
							JOptionPane.showMessageDialog(null,"The entered escape time is invalid.","Error" ,JOptionPane.ERROR_MESSAGE);
						}
						i += 1;
					} else {
						System.out.println("Please enter some number!");
					}
				}
			}
		});
	}
	
	/**
	 * used to reset the zoom into default setting without changing the fractal and color
	 */
	public void reset() {
		_fileMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedMandelbrot()) {
					_fractalPanel.updateImage(_mandelbrot.finalFractal(-2.15, 0.6, -1.3, 1.3));
					_xSet = _mandelbrot.xCoordinate(-2.15, 0.6);
					_ySet = _mandelbrot.yCoordinate(-1.3, 1.3);
					_image = _mandelbrot.finalFractal(-2.15, 0.6, -1.3, 1.3);
				} else if (selectedJulia()){
					_fractalPanel.updateImage(_julia.finalFractal(-1.7, 1.7, -1, 1));
					_xSet = _julia.xCoordinate(-1.7, 1.7);
					_ySet = _julia.yCoordinate(-1, 1);
					_image = _julia.finalFractal(-1.7, 1.7, -1, 1);
				} else if (selectedBurningShip()) {
					_fractalPanel.updateImage(_burningShip.finalFractal(-1.8, -1.7, -0.08, 0.025));
					_xSet = _burningShip.xCoordinate(-1.8, -1.7);
					_ySet = _burningShip.yCoordinate(-0.08, 0.025);
					_image = _burningShip.finalFractal(-1.8, -1.7, -0.08, 0.025);
				} else if (selectedMultibrot()){
					_fractalPanel.updateImage( _multibrot.finalFractal(-1, 1, -1.3, 1.3));
					_xSet = _multibrot.xCoordinate();
					_ySet = _multibrot.yCoordinate(-1.3, 1.3);
					_image = _multibrot.finalFractal(-1, 1, -1.3, 1.3);
				}
			}
		});
	}
	
	/**
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
	 * This method allows user to select Mandelbrot menu item,
	 * and update the selection status of each of four fractal menu item.
	 * @return boolean value of true when Mandelbrot is selected, false otherwise
	 */
	public boolean selectedMandelbrot() {
		//when clicked, the mandelbrot fractal would appear
		_fractalMenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_xSet = _mandelbrot.xCoordinate(-2.15, 0.6);
				_ySet = _mandelbrot.yCoordinate(-1.3, 1.3);
				_fractalMenuItem1.setSelected(true);
				_fractalMenuItem2.setSelected(false);
				_fractalMenuItem3.setSelected(false);
				_fractalMenuItem4.setSelected(false);
				_workerClass.doInBackground(); //backGround calculation for threading
				_workerClass.threading(); //backGround calculation for threading
				// if the user entered the number of thread, the fractal would be generated by the workers
				if (_fileMenuItem4.isSelected()) {
					_workerClass.updateWorkerFractal();
				} else {
					_fractalPanel.updateImage(_mandelbrot.finalFractalForWorkerResult(-2.15, 0.6, -1.3, 1.3, 0, 2048));
				}
				_frame.add(_fractalPanel);
				_frame.pack();
			}
		});
		_pool.clearPool(); // clear the pool for a new set of tasks to perform
		if (_fractalMenuItem1.isSelected()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This method allows user to select Julia menu item,
	 * and update the selection status of each of four fractal menu item.
	 * @return boolean value of true when Julia is selected, false otherwise
	 */
	public boolean selectedJulia() {
		//when clicked, the julia fractal would appear
		_fractalMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_xSet = _julia.xCoordinate(-1.7, 1.7);
				_ySet = _julia.yCoordinate(-1, 1);
				_fractalMenuItem1.setSelected(false);
				_fractalMenuItem2.setSelected(true);
				_fractalMenuItem3.setSelected(false);
				_fractalMenuItem4.setSelected(false);
				_workerClass.doInBackground(); //backGround calculation for threading
				_workerClass.threading(); //backGround calculation for threading
				// if the user entered the number of thread, the fractal would be generated by the workers
				if (_fileMenuItem4.isSelected()) {
					_workerClass.updateWorkerFractal();
				} else {
					_fractalPanel.updateImage(_julia.finalFractal(-1.7, 1.7, -1, 1));
				}
				_frame.setVisible(true);
				_frame.add(_fractalPanel);
				_frame.pack();
			}
		});
		_pool.clearPool(); // clear the pool for a new set of tasks to perform
		if (_fractalMenuItem2.isSelected()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This method allows user to select BurningShip menu item,
	 * and update the selection status of each of four fractal menu item.
	 * @return boolean value of true when BurningShip is selected, false otherwise
	 */
	public boolean selectedBurningShip() {
		//when clicked, the burning ship fractal would appear
		_fractalMenuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_xSet = _burningShip.xCoordinate(-1.8, -1.7);
				_ySet = _burningShip.yCoordinate(-0.08, 0.025);
				_fractalMenuItem1.setSelected(false);
				_fractalMenuItem2.setSelected(false);
				_fractalMenuItem3.setSelected(true);
				_fractalMenuItem4.setSelected(false);
				_workerClass.doInBackground(); //backGround calculation for threading
				_workerClass.threading(); //backGround calculation for threading
				// if the user entered the number of thread, the fractal would be generated by the workers
				if (_fileMenuItem4.isSelected()) {
					_workerClass.updateWorkerFractal();
				} else {
					_fractalPanel.updateImage(_burningShip.finalFractal(-1.8, -1.7, -0.08, 0.025));
				}
				_frame.setVisible(true);
				_frame.add(_fractalPanel);
				_frame.pack();
			}
		});
		_pool.clearPool(); // clear the pool for a new set of tasks to perform
		if (_fractalMenuItem3.isSelected()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This method allows user to select Multibrot menu item,
	 * and update the selection status of each of four fractal menu item.
	 * @return boolean value of true when Multibrot is selected, false otherwise
	 */
	public boolean selectedMultibrot() {
		//when clicked, the multibrot fractal would appear
		_fractalMenuItem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_xSet = _multibrot.xCoordinate();
				_ySet = _multibrot.yCoordinate(-1.3, 1.3);
				_fractalMenuItem1.setSelected(false);
				_fractalMenuItem2.setSelected(false);
				_fractalMenuItem3.setSelected(false);
				_fractalMenuItem4.setSelected(true);
				_workerClass.doInBackground(); //backGround calculation for threading
				_workerClass.threading(); //backGround calculation for threading
				// if the user entered the number of thread, the fractal would be generated by the workers
				if (_fileMenuItem4.isSelected()) {
					_workerClass.updateWorkerFractal();
				} else {
					_fractalPanel.updateImage(_multibrot.finalFractal(-1, 1, -1.3, 1.3));
				}
				_frame.setVisible(true);
				_frame.add(_fractalPanel);
				_frame.pack();
			}
		});
		_pool.clearPool(); // clear the pool for a new set of tasks to perform
		if (_fractalMenuItem4.isSelected()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * activate the mouse event, and allows user to dragging
	 * also allows zoom in on the selected fractal within dragging area
	 */
	public void Mouse() {
		//allows the mouse event on fractal
		_fractalPanel.addMouseListener(new MouseAdapter() {
			//event generated when press the mouse
			public void mousePressed(MouseEvent e) {
				_startX = e.getX(); //starting x-coordinate when press the mouse
				_startY = e.getY();	//starting y-coordinate when press the mouse		
			}
			//event generated when release the mouse
			public void mouseReleased(MouseEvent e) {
				int x = e.getX(); //ending x-coordinate when release the mouse
				int y = e.getY(); //ending y-coordinate when release the mouse
				if (_startX < x && _startY < y) {
					_newXmin = _xSet[_startX]; //get corresponding x-coordinate in the array set as a starting domain
					_newYmin = _ySet[_startY]; //get corresponding y-coordinate in the array set as a starting range
					_newXmax = _xSet[x]; //get corresponding x-coordinate in the array set as a ending domain
					_newYmax = _ySet[y]; //get corresponding x-coordinate in the array set as a ending range
				} else if (_startX > x && _startY > y) {
					_newXmin = _xSet[x]; //get corresponding x-coordinate in the array set as a starting domain
					_newYmin = _ySet[y]; //get corresponding y-coordinate in the array set as a starting range
					_newXmax = _xSet[_startX]; //get corresponding x-coordinate in the array set as a ending domain
					_newYmax = _ySet[_startY]; //get corresponding x-coordinate in the array set as a ending range
				} else if (_startX < x && _startY > y) {
					_newXmin = _xSet[_startX]; //get corresponding x-coordinate in the array set as a starting domain
					_newYmin = _ySet[y]; //get corresponding y-coordinate in the array set as a starting range
					_newXmax = _xSet[x]; //get corresponding x-coordinate in the array set as a ending domain
					_newYmax = _ySet[_startY]; //get corresponding x-coordinate in the array set as a ending range
				} else if (_startX > x && _startY < y) {
					_newXmin = _xSet[x]; //get corresponding x-coordinate in the array set as a starting domain
					_newYmin = _ySet[_startY]; //get corresponding y-coordinate in the array set as a starting range
					_newXmax = _xSet[_startX]; //get corresponding x-coordinate in the array set as a ending domain
					_newYmax = _ySet[y]; //get corresponding x-coordinate in the array set as a ending range
				}
				//note that all the xCoordinate and yCoordinate method in four sets are identity on the algorithm
				_xSet = _mandelbrot.xCoordinate(_newXmin, _newXmax); //re-allocate the new domain of x-coordinate into the array ready for next zoom in
				_ySet = _mandelbrot.yCoordinate(_newYmin, _newYmax);//re-allocate the new range of y-coordinate into the array ready for next zoom in
				//set image to the selected fractal with new calculation (zoom in process)
				if (selectedMandelbrot()) {
					_image = _mandelbrot.finalFractal(_newXmin, _newXmax, _newYmin, _newYmax);
				} else if (selectedJulia()){
					_image = _julia.finalFractal(_newXmin, _newXmax, _newYmin, _newYmax);
				} else if (selectedBurningShip()) {
					_image = _burningShip.finalFractal(_newXmin, _newXmax, _newYmin, _newYmax);
				} else if (selectedMultibrot()){
					_image = _multibrot.finalFractal(_newXmin, _newXmax, _newYmin, _newYmax);
				}
				_fractalPanel.updateImage(_image); //generate the zoomed-in-fractal image
			}
		});
		//allows the mouse motion event on fractal
		_fractalPanel.addMouseMotionListener(new MouseMotionAdapter() {
			//event generated when dragging the mouse
			public void mouseDragged(MouseEvent e) {
				Component src = (Component) e.getSource();
				int x = e.getX(); //get current x-coordinate;
				int y = e.getY(); //get current y-coordinate;
				_g = src.getGraphics(); //get a graphics
				_g.setColor(Color.BLUE); //set graphics color to blue
				//draw a rectangle using the current x and y-coordinates when dragging
				if (_startX < x && _startY < y) {
					_g.drawRect(_startX, _startY, Math.abs(x-_startX), Math.abs(y-_startY));
				} else if (_startX > x && _startY > y) {
					_g.drawRect(x, y, Math.abs(x-_startX), Math.abs(y-_startY));
				} else if (_startX < x && _startY > y) {
					_g.drawRect(_startX, y, Math.abs(x-_startX), Math.abs(y-_startY));
				} else if (_startX > x && _startY < y) {
					_g.drawRect(x, _startY, Math.abs(x-_startX), Math.abs(y-_startY));
				}
				src.paint(_g); //depicts the rectangle
			}
		});
	}
	
	/**
	 * This is a subclass of SwingWorker which calculates the worker result of number of workers
	 * and update the fractal using the worker result of these workers.
	 * 
	 * @author Zhenduo Lin
	 */
	public class WorkerClass extends SwingWorker<WorkerResult, Void>{
		
		private int _rowStart; // starting row of the worker;
		private int _rowEnd; // ending row of the worker;
		
		/**
		 * Instantiate the WorkerClass instances
		 * 
		 * @param startingRows = starting row of the worker;
		 * @param endingRows = ending row of the worker;
		 */
		public WorkerClass(int startingRows, int endingRows) {
			_rowStart = startingRows;
			_rowEnd = endingRows;
		}
		
		/**
		 * The worker result calculated in the background
		 */
		public WorkerResult doInBackground() {
//			_result = new WorkerResult(_rowStart, _mandelbrot.finalFractalForWorkerResult(-2.15, 0.6, -1.3, 1.3, _rowStart, _rowEnd));
			if (_fractalMenuItem1.isSelected()) {
				_result = new WorkerResult(_rowStart, _mandelbrot.finalFractalForWorkerResult(-2.15, 0.6, -1.3, 1.3, _rowStart, _rowEnd));
			} else if (_fractalMenuItem2.isSelected()) {
				_result = new WorkerResult(_rowStart, _julia.finalFractalForWorkerResult(-1.7, 1.7, -1, 1, _rowStart, _rowEnd));
			} else if (_fractalMenuItem3.isSelected()) {
				_result = new WorkerResult(_rowStart, _burningShip.finalFractalForWorkerResult(-1.8, -1.7, -0.08, 0.025, _rowStart, _rowEnd));
			} else if (_fractalMenuItem4.isSelected()) {
				_result = new WorkerResult(_rowStart, _multibrot.finalFractalForWorkerResult(-1, 1, -1.3, 1.3, _rowStart, _rowEnd));
			} else {
				_result = null;
			}
			return _result;
			
		}
		
		/**
		 * Specified the number of rows to each workers(threads)
		 * then adding the worker instances into the workerArray
		 */
		public void threading() {
			_rowStart = 0;
			_rowEnd = 0;
			for (int t=0;t<_thread; t+=1) {
				_rowStart = _rowEnd;
				_rowEnd += 2048/_thread;
				if (t == _thread-1) {
					_rowEnd += 2048%_thread;
				}
				_workerArray[t] = new WorkerClass(_rowStart, _rowEnd);
			}
		}
		
		/**
		 * update the fractal generated by the number of workers
		 */
		public void updateWorkerFractal() {
			_pool.changePanel(_fractalPanel);
			_pool.generateFractal(2048, _workerArray);
		}
		
		/**
		 * This method allows user to enter the number of workers used to generate fractal
		 * @return boolean value of true when changeSwingWorkerInstance is selected, false otherwise
		 */
		public boolean changeSwingWorkerInstance() {
			_fileMenuItem4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = 0;
					//a loop that restricting only 1 option pane appeared when clicked
					while (i <= 0) {
						//option pane allows user to enter SwingWorker instance
						String SwingWorker = JOptionPane.showInputDialog("Please Enter Number of SwingWorker Instance");
						if (SwingWorker.length()>0) {
							int swingworker = Integer.parseInt(SwingWorker);
							_workerArray = new WorkerClass[swingworker]; //set size of the worker array to the entered number
							_thread = swingworker; // set the number of thread to the entered number
							_fileMenuItem4.setSelected(true);
							//showing the error message when entering an invalid escape distance
							if (swingworker < 1 || swingworker > 128) {
								JOptionPane.showMessageDialog(null,"The entered SwingWorker Instance is invalid.","Error" ,JOptionPane.ERROR_MESSAGE);
							}
							i += 1;
						} else {
							System.out.println("Please enter some number!");
						}
					}
				}
			});
			if (_fileMenuItem4.isSelected()) {
				return true;
			} else {
				return false;
			}
		}
		
	}
	
}
