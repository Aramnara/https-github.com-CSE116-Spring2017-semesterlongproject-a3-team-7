package code;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import code.gui.GUI;
import edu.buffalo.fractal.FractalPanel;

public class Mouse implements MouseListener, MouseMotionListener{
	
	private int _startX;
	private int _startY;
	private int _prevX;
	private int _prevY;
	private boolean _dragging;
	private Graphics _g;
	private JPanel _panel;
	private FractalPanel _fractalPanel;
	private Mandelbrot _mandelbrot;
	
	public Mouse() {
		_panel = new JPanel();
		_fractalPanel = new FractalPanel();
		_mandelbrot = new Mandelbrot();
	}

	public void mouseDragged(MouseEvent e) {
		Component src = (Component) e.getSource();
		int x = e.getX();
		int y = e.getY();
		_g = src.getGraphics();
		_g.setColor(Color.BLUE);
		_g.drawRect(_startX, _startY, Math.abs(_startX-x), Math.abs(_startY-y));
		src.paint(_g);
		_prevX = x;
		_prevY = y;
		
	}

	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		Component src = (Component) e.getSource();
		_startX = e.getX();
		_startY = e.getY();
		_prevX = _startX;
		_prevY = _startY;
		
	}

	public void mouseReleased(MouseEvent e) {
		Component src = (Component) e.getSource();
		int x = e.getX();
		int y = e.getY();
		double[] xSet = _mandelbrot.xCoordinate(_startX, x);
		double[] ySet = _mandelbrot.yCoordinate(_startY, y);
//		int[][] image = _mandelbrot.finalFractal();
//		_fractalPanel.updateImage(image);
	}
	
}
