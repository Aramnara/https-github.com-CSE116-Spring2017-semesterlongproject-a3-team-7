package code;

/** 
 * This class contains all the methods needed for Multibrot set
 * which would return a 2d-Array fractal.
 *   
 * @author Jae Hoon Oh
 */
public class Multibrot {
	
	private int _escapeDistance = 2; //Initial escape distance
	private int _maximumEscapeTime = 225; //Inital escape time
	
	/** 
	 * This method returns a 2d-Array of type int
	 *  with 512 rows and 512 columns
	 *  which would be the fractal that we will be working on.
	 * 
	 * @return a 2d-Array on int.
	 */
	public int[][] fractal() {
		int[][] pixel = new int[2048][2048];
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
		while (dist <= _escapeDistance && passes < _maximumEscapeTime) {
			double xTemp = xCalc;
			xCalc = (xCalc * xCalc * xCalc) - (3 * xCalc * yCalc * yCalc) + currentX;
			yCalc = (3 * xTemp * xTemp * yCalc) - (yCalc * yCalc * yCalc) + currentY;
			passes += 1;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		}
		escapeTime = passes;
		return escapeTime;
	}
	
	/**
	 * This method records all the x-coordinates used in the Multibrot Set.
	 * 
	 * @return an array of type double containing all the x-coordinates in the fractal.
	 */
	public double[] xCoordinate() {
		double[] xSet = new double[2048];
		int rows = 1;
		xSet[0] = -1.0;
		for (double x=-1.0+2.0/2048; x<1.0; x+=2.0/2048) {
			xSet[rows] = x;
			rows = add(rows);
		}
		return xSet;
	}
	
	/**
	 * This method records all the x-coordinates used in the Multibrot Set.
	 * 
	 * @param xMin = starting x-coordinate, minimum x-coordinate
	 * @param xMax = ending x-coordinate, maximum x-coordinate
	 * @return an array of type double containing all the x-coordinates in the fractal.
	 */
	public double[] xCoordinate(double xMin, double xMax) {
		double[] xSet = new double[2048];
		int rows = 0;
		double increase = (xMax - xMin)/2048;
		for (double x=xMin; x<=xMax; x+=increase) {
			xSet[rows] = x;
			rows = add(rows);
		}
		return xSet;
	}
	
	/**
	 * This method records all the y-coordinates used in the Multibrot Set.
	 * 
	 * @param yMin = starting y-coordinate, minimum y-coordinate
	 * @param yMax = ending y-coordinate, maximum y-coordinate
	 * @return an array of type double containing all the y-coordinates in the fractal.
	 */
	public double[] yCoordinate(double yMin, double yMax) {
		double[] ySet = new double[2048];
		int rows = 0;
		double increase = (yMax - yMin)/2048;
		for (double y=yMin; y<=yMax; y+=increase) {
			ySet[rows] = y;
			rows = add(rows);
		}
		return ySet;
	}
	
	/**
	 * This method depicts the final 2d-array of the fractal
	 * within certain range and filled with escape time.
	 * 
	 * @param xMin = starting x-coordinate, minimum x-coordinate
	 * @param xMax = ending x-coordinate, maximum x-coordinate
	 * @param yMin = starting y-coordinate, minimum y-coordinate
	 * @param yMax = ending y-coordinate, maximum y-coordinate
	 * @return a 2d-array of fractal.
	 */
	public int[][] finalFractal(double xMin, double xMax, double yMin, double yMax) {
		int[][] pixel = fractal();
		double[] xSet = xCoordinate(xMin, xMax);
		double[] ySet = yCoordinate(yMin, yMax);
		for (int rows=0; rows<2048; rows+=1) {
			for (int cols=0; cols<2048; cols+=1) {
				pixel[rows][cols] = calcEscapeTime(xSet[rows], ySet[cols]);
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
		if (add < 2047) {
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
	
	/**
	 * This method allows to change the maximum escape time 
	 * of the fractal for the calculation.
	 * 
	 * @param maximumEscapeTime = user-entered maximum escape time.
	 * @return a user-entered maximum escape time of type int.
	 */
	public int escapeTime(int maximumEscapeTime) {
		if (maximumEscapeTime > 0 && maximumEscapeTime <= 255) {
			_maximumEscapeTime = maximumEscapeTime;
		}
		return _maximumEscapeTime;
	}
		
	
}
	