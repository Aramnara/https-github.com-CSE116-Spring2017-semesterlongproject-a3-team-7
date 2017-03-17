package code;

/** 
 * This class contains all the methods needed for Mandelbrot set
 * which would return a 2d-Array fractal.
 *   
 * @author Zhenduo Lin
 */
public class Mandelbrot {
	
	private int _escapeDistance = 2; //Initial escape distance
	
	/** 
	 * This method returns a 2d-Array of type int
	 *  with 512 rows and 512 columns
	 *  which would be the fractal that we will be working on.
	 * 
	 * @return a 2d-Array on int.
	 */
	public int[][] fractal() {
		int[][] pixel = new int[512][512];
		return pixel;
	}
	
	/**
	 * This method calculates the escape time of the given coordinates
	 * according to the formula given by Escape-time algorithms.
	 * 
	 * @param currentX = the current x-coordinate that we will be using.
	 * @param currentY = the current y-coordinate that we will be using.
	 * @return an escape time of type int.
	 */
	public int calcEscapeTime(double currentX, double currentY) {
		double xCalc = currentX;
		double yCalc = currentY;
		double dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		int passes = 0;
		int escapeTime = 0;
		while (dist <= _escapeDistance && passes < 225) {
			double xTemp = xCalc;
			xCalc = (xCalc * xCalc) - (yCalc * yCalc) + currentX;
			yCalc = 2 * xTemp * yCalc + currentY;
			passes += 1;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		}
		escapeTime = passes;
		return escapeTime;
	}
	
	/**
	 * This method records all the x-coordinates used in the Mandelbrot Set.
	 * 
	 * @return an array of type double containing all the x-coordinates in the fractal.
	 */
	public double[] xCoordinate() {
		double[] xSet = new double[512];
		int rows = 0;
		for (double x=-2.15; x<=0.6; x+=2.75/512) {
			xSet[rows] = x;
			rows = add(rows);
		}
		return xSet;
	}
	
	/**
	 * This method records all the y-coordinates used in the Mandelbrot Set.
	 * 
	 * @return an array of type double containing all the y-coordinates in the fractal.
	 */
	public double[] yCoordinate() {
		double[] ySet = new double[512];
		int rows = 0;
		for (double y=-1.3; y<=1.3; y+=2.6/512) {
			ySet[rows] = y;
			rows = add(rows);
		}
		return ySet;
	}
	
	/**
	 * This method depicts the final 2d-array of the fractal
	 * within certain range and filled with escape time.
	 * 
	 * @return a 2d-array of fractal.
	 */
	public int[][] finalFractal() {
		int rows = 0;
		int cols = 0;
		int[][] pixel = fractal();
		for (double x=-2.15; x<=0.6; x+=2.75/512) {
			for (double y=-1.3; y<=1.3; y+=2.6/512) {
				pixel[rows][cols] = calcEscapeTime(x, y);
				cols = add(cols);
			}
			rows = add(rows);
		}
		return pixel;
	}
	
	/**
	 * This method allows to increase the current integer by 1
	 * without exceeding the range for the fractals.
	 * 
	 * @param target = target for increase.
	 * @return an integer of type int.
	 */
	public int add(int target) {
		int add = target;
		if (add < 511) {
			add += 1;
		} else {
			add = 0;
		}
		return add;
	}
	
	/**
	 * This method allows to change the escape distance 
	 * of the fractal for the escape time calculation.
	 * 
	 * @param escapeDistance = user-entered escape distance.
	 * @return a user-entered escape distance of type int.
	 */
	public int escapeDistance(int escapeDistance) {
		if (escapeDistance > 0) {
			_escapeDistance = escapeDistance;	
		} 
		return _escapeDistance;
	}
}
