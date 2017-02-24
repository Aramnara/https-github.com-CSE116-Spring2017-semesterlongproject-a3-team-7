package edu.buffalo.cse116;

public class EscapeTimeAlgorithms {
	
//	private double _xCalc;
//	private double _yCalc;
//	private double _dist;
//	private int _passes;
//	private int _escapeTime;
	private int[][] _pixel;
	
	public int[][] Plane() {
		_pixel = new int[512][512];
		return _pixel;
	}
	
	public int[][] MandelbrotSet(double currentX, double currentY) {
		int[][] pixel = new int[512][512];
		double xCalc = currentX;
		double yCalc = currentY;
		double dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		int passes = 0;
//		HashSet<Integer> escapeTimeList = new HashSet<Integer>();
//		for (double x=-2.15; x<0.6; x=x+2.75/512) {
//			for (double y=-1.3; y<1.3; y=y+2.6/512) {
				while (dist <= 2 && passes < 225) {
					xCalc = (xCalc * xCalc) - (yCalc * yCalc) + currentX;
					yCalc = 2 * xCalc * yCalc + currentY;
					passes = passes + 1;
					dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
				}
				int escapeTime = passes;
//				escapeTimeList.add(escapeTime);
//			}
//		}
//		for (int rows=0; rows<512; rows++) {
//			for (int cols=0; cols<512; cols++) {
//				for (int i=0; i<escapeTimeList.size(); i++)
//				pixel[rows][cols] = escapeTimeList.get()
//			}
//		}
		return pixel;
	}
	
	public int[][] JuliaSet(double currentX, double currentY) {
		double xCalc = currentX;
		double yCalc = currentY;
		double dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		int passes = 0;
		while (dist <= 2 && passes < 225) {
			xCalc = (xCalc * xCalc) - (yCalc * yCalc) - 0.72689;
			yCalc = 2 * xCalc * yCalc + 0.188887;
			passes = passes + 1;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		}
		int escapeTime = passes;	
		int[][] pixel = new int[escapeTime][escapeTime];
		return pixel;
	}
	
	public int[][] BurningShipSet(double currentX, double currentY) {
		double xCalc = currentX;
		double yCalc = currentY;
		double dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		int passes = 0;
		while (dist <= 2 && passes < 225) {
			xCalc = (xCalc * xCalc * xCalc) - (3 * xCalc * yCalc * yCalc) + currentX;
			yCalc = (3 * xCalc * xCalc * yCalc) - (yCalc * yCalc * yCalc) + currentY;
			passes = passes + 1;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		}
		int escapeTime = passes;
		int[][] pixel = new int[escapeTime][escapeTime];
		return pixel;
	}
		public void MultibrotSet(double xCalc, double yCalc) {
			_xCalc = xCalc;
			_yCalc = yCalc;
			_dist = Math.sqrt((_xCalc*_xCalc) + (_yCalc* _yCalc));
			_passes = 0;
			while (_dist<= 2 && _passes < 255) {
				_xCalc = (_xCalc*_xCalc*_xCalc) - (3*_xCalc*_yCalc*_yCalc) + xCalc;
				_yCalc = (3*_xCalc*_xCalc*_yCalc) - (_yCalc*_yCalc*_yCalc) + yCalc;
				_passes = _passes + 1;
				_dist = Math.sqrt((_xCalc*_xCalc) + (_yCalc* _yCalc));
				
			}
			_escapeTime = _passes;
		}
	}
	

