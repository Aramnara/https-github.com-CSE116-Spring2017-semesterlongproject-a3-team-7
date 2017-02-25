package code;

/** 
 * This class contains all the methods needed for Mandelbrot set
 * which would return a 2d-Array fractal.
 *   
 * @author Jae Hoon Oh
 */

public class Multibrot {
	
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
		while (dist <= 2 && passes < 225) {
			double xTemp = xCalc;
			xCalc = (xCalc * xCalc*xCalc) - (3*xCalc * yCalc*yCalc) + currentX;
			yCalc = (3*xTemp*xTemp*yCalc) - (yCalc*yCalc*yCalc);
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
		for (double x=-1; x<=1; x+=2/512) {
			xSet[rows] = x;
			rows = rowsAdd(rows);
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
			rows = rowsAdd(rows);
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
		for (double x=-1; x<=1; x+=2/512) {
			for (double y=-1.3; y<=1.3; y+=2.6/512) {
				pixel[rows][cols] = calcEscapeTime(x, y);
				cols = colsAdd(cols);
			}
			rows = rowsAdd(rows);
		}
		return pixel;
}
	/**
	 * This method allows to increase the current row(index) in the 2d-array by 1
	 * without exceeding the range.
	 * 
	 * @param targetRow = target row for increase.
	 * @return a row of type int.
	 */
	
	public int rowsAdd(int targetRow) {
		int rows = targetRow;
		if (rows < 511) {
			return rows += 1;
		} else {
			rows = 0;
		}
		return rows;
	}
	/**
	 * This method allows to increase the current column(index) in the 2d-array by 1
	 * without exceeding the range.
	 * 
	 * @param targetCol = target column for increase.
	 * @return a column of type int.
	 */
	public int colsAdd(int targetCol) {
		int cols = targetCol;
		if (cols < 511) {
			cols += 1;
		} else {
			cols = 0;
		}
		return cols;
	}
}
	