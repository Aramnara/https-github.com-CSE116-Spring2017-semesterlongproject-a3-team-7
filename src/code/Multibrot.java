package code;

/** 
 * This class contains all the methods needed for Multibrot set
 * which would return a 2d-Array fractal.
 *   
 * @author Jae Hoon Oh
 */
public class Multibrot {
	
	private int _escapeDistance = 2; //Initial escape distance
	private int _escapeTime = 0;
	
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
		double[] xSet = new double[512];
		int rows = 1;
		xSet[0] = -1.0;
		for (double x=-1.0+2.0/512; x<1.0; x+=2.0/512) {
			xSet[rows] = x;
			rows = add(rows);
		}
		return xSet;
	}
	public double[] xCoordinate(double xMin, double xMax) {
		double[] xSet = new double[512];
		int rows = 0;
		double increase = (xMax - xMin)/512;
		for (double x=xMin; x<=xMax; x+=increase) {
			xSet[rows] = x;
			rows = add(rows);
		}
		return xSet;
	}
	
	/**
	 * This method records all the y-coordinates used in the Multibrot Set.
	 * 
	 * @return an array of type double containing all the y-coordinates in the fractal.
	 */
	public double[] yCoordinate(double yMin, double yMax) {
		double[] ySet = new double[512];
		int rows = 0;
		double increase = (yMax - yMin)/512;
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
	 * @return a 2d-array of fractal.
	 */
	public int[][] finalFractal(double xMin, double xMax, double yMin, double yMax) {
//		int rows = 0;
//		int cols = 0;
		int[][] pixel = fractal();
		double[] xSet = xCoordinate(xMin, xMax);
		double[] ySet = yCoordinate(yMin, yMax);
//		for (double x=-2.15; x<=0.6; x+=2.75/512) {
//			for (double y=-1.3; y<=1.3; y+=2.6/512) {
//				pixel[rows][cols] = calcEscapeTime(x, y);
//				cols = add(cols);
//			}
//			rows = add(rows);
//		}
		for (int rows=0; rows<512; rows+=1) {
			for (int cols=0; cols<512; cols+=1) {
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
	public int escapeTime(int escapeTime) {
		if (escapeTime > 0 && escapeTime <= 255) {
			_escapeTime = escapeTime;
		}
		return _escapeTime;
	}
	
}
	