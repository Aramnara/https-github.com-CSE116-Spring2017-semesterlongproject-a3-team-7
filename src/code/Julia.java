package code;
/**
 * This class contains all the method needed for the Julia Set
 * 
 * @author Anthony Ramnarain
 *
 */

public class Julia {

	public int[][] fractal() {
		int[][] pixel = new int[512][512];
		return pixel;
	}
	public int calcEscapeTime(double currentX, double currentY) {
		double xCalc = currentX;
		double yCalc = currentY;
		double dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		int passes = 0;
		int escapeTime = 0;
		while (dist <= 2 && passes < 225) {
			double xTemp = xCalc;
			xCalc = (xCalc * xCalc) - (yCalc * yCalc) + -0.72689;
			yCalc = 2 * xTemp * yCalc + 0.188887;
			passes += 1;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		}
		escapeTime = passes;
		return escapeTime;
		}
		public double[] xCoordinate() {
			double[] xSet = new double[512];
			int rows = 0;
			for (double x=-1.7; x<=1.7; x+=3.4/512) {
			xSet[rows] = x;
			rows = rowsAdd(rows);
		}
		return xSet;
	}
		public double [] yCoordinate() {
			double [] ySet = new double[512];
			int rows = 0;
			for (double y=-1.0; y<=1.0; y+=2.0/512) {
				ySet[rows] = y;
				rows = rowsAdd(rows);
			}
			return ySet;
		}
		public int[][]finalFractal () {
			int rows = 0;
			int cols = 0;
			int [][] pixel = fractal();
			for (double x=-1.7; x<1.7; x+=3.4/512) {
				for (double y=-1.0; y<=1.0; y+=2.0/512) {
					pixel[rows][cols] = calcEscapeTime(x,y);
					cols = colsAdd(cols);
				}
				rows = rowsAdd(rows);
			}
			return pixel;
		}
		public int rowsAdd(int targetRow) {
			int rows = targetRow;
			if (rows < 511) {
				return rows += 1;
			} else {
				rows = 0;
			}
			return rows;
			}
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
