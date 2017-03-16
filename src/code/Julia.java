package code;

import java.security.InvalidParameterException;

/**
 * This class contains all the methods needed for Julia set
 * which would return a 2d-Array fractal.
 * 
 * @author Anthony Ramnarain
 */
public class Julia {
	
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
			xCalc = (xCalc * xCalc) - (yCalc * yCalc) + -0.72689;
			yCalc = 2 * xTemp * yCalc + 0.188887;
			passes += 1;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		}
		escapeTime = passes;
		return escapeTime;
		}
	
	/**
	 * This method records all the x-coordinates used in the Julia Set.
	 * 
	 * @return an array of type double containing all the x-coordinates in the fractal.
	 */
	public double[] xCoordinate() {
		double[] xSet = new double[512];
		int rows = 0;
		for (double x=-1.7; x<=1.7; x+=3.4/512) {
		xSet[rows] = x;
		rows = add(rows);
		}
		return xSet;
	}
	
	/**
	 * This method records all the y-coordinates used in the Julia Set.
	 * 
	 * @return an array of type double containing all the y-coordinates in the fractal.
	 */
	public double [] yCoordinate() {
		double [] ySet = new double[512];
		int rows = 0;
		for (double y=-1.0; y<=1.0; y+=2.0/512) {
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
		int[][] pixel = fractal();
		for (int rows=0; rows<512; rows+=1) {
			for (int cols=0; cols<512; cols+=1) {
				pixel[rows][cols] = calcEscapeTime(xCoordinate()[rows], yCoordinate()[cols]);
			}
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
	
	public int escapeDistance(int escapeDistance) {
		if (escapeDistance > 0) {
			_escapeDistance = escapeDistance;	
		} else {
			throw new InvalidParameterException();
		}
		return _escapeDistance;
	}
}
