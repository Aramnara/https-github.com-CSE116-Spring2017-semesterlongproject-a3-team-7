package edu.buffalo.cse116;

import java.awt.Point;

public class EscapeTimeAlgorithms {
	
	private double _xCalc;
	private double _yCalc;
	private double _dist;
	private int _passes;
	private int _escapeTime;
	private int[][] _pixel;
	
	public int[][] Plane() {
		_pixel = (int[][]) (new int[512][512]);
		return _pixel;
	}
	
	public double MandelbrotSet(double xCalc, double yCalc) {
		_xCalc = xCalc;
		_yCalc = yCalc;
		_dist = Math.sqrt((_xCalc * _xCalc) + (_yCalc * _yCalc));
		_passes = 0;
//		Point p = new Point(_xCalc, _yCalc);
		while (_dist <= 2 && _passes < 225) {
			_xCalc = (_xCalc * _xCalc) - (_yCalc * _yCalc) + xCalc;
			_yCalc = 2 * _xCalc * _yCalc + yCalc;
			_passes = _passes + 1;
			_dist = Math.sqrt((_xCalc * _xCalc) + (_yCalc * _yCalc));
		}
		_escapeTime = _passes;
//		double roundOff = Math.round(_dist * 100)/100;
//		_dist = roundOff;
		return _dist;
	}
	
	public void JuliaSet(double xCalc, double yCalc) {
		_xCalc = xCalc;
		_yCalc = yCalc;
		_dist = Math.sqrt((_xCalc * _xCalc) + (_yCalc * _yCalc));
		_passes = 0;
//		Point p = new Point(_xCalc, _yCalc);
		while (_dist <= 2 && _passes < 225) {
			_xCalc = (_xCalc * _xCalc) - (_yCalc * _yCalc) - 0.72689;
			_yCalc = 2 * _xCalc * _yCalc + 0.188887;
			_passes = _passes + 1;
			_dist = Math.sqrt((_xCalc * _xCalc) + (_yCalc * _yCalc));
		}
		_escapeTime = _passes;		
	}
	
	public void BurningShipSet(double xCalc, double yCalc) {
		_xCalc = xCalc;
		_yCalc = yCalc;
		_dist = Math.sqrt((_xCalc * _xCalc) + (_yCalc * _yCalc));
		_passes = 0;
//		Point p = new Point(_xCalc, _yCalc);
		while (_dist <= 2 && _passes < 225) {
			_xCalc = (_xCalc * _xCalc) - (_yCalc * _yCalc) - 0.72689;
			_yCalc = Math.abs(2 * _xCalc * _yCalc) + 0.188887;
			_passes = _passes + 1;
			_dist = Math.sqrt((_xCalc * _xCalc) + (_yCalc * _yCalc));
		}
		_escapeTime = _passes;	
	}
	
}
