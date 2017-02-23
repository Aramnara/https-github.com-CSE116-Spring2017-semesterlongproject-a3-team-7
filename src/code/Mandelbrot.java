package code;

public class Mandelbrot {
	
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
			xCalc = (xCalc * xCalc) - (yCalc * yCalc) + currentX;
			yCalc = 2 * xCalc * yCalc + currentY;
			passes += 1;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		}
		escapeTime = passes;
		return escapeTime;
	}
	
	public int[][] finalFractal() {
		double x;
		double xMax = 0.6;
		double y;
		double yMax = 1.3;
		int rows = 0;
		int cols = 0;
		int[][] pixel = fractal();
		for (x=-2.15; x<xMax; x+=2.75/512) {
			for (y=-1.3; y<yMax; y+=2.6/512) {
				pixel[rows][cols] = calcEscapeTime(x, y);
				colsAdd(cols);
			}
			rowsAdd(rows);
		}
		return pixel;
	}
	
	public int rowsAdd(int targetRow) {
		int rows = targetRow;
		if (rows < 512) {
			rows += 1;
		} else {
			rows = 0;
		}
		return rows;
	}
	
	public int colsAdd(int targetCol) {
		int cols = targetCol;
		if (cols < 512) {
			cols += 1;
		} else {
			cols = 0;
		}
		return cols;
	}
	
}
