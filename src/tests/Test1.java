package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Julia;
import code.Mandelbrot;

/**
 * This class contains JUnit tests which testing
 * the x-coordinates in each fractal row.
 * 
 * @author Zhenduo Lin
 */
public class Test1 {
	
	/**
	 * This JUnit test is testing the translation
	 * between pixel's row and the corresponding x-coordinate
	 * for the Mandelbrot Set.
	 */
	@Test
	public void MandelbrotSetTest() {
		Mandelbrot mandelbrot = new Mandelbrot();
		double[] xTest = mandelbrot.xCoordinate();
		assertEquals(-2.15, xTest[0], 0.01);
		assertEquals(-2.139, xTest[2], 0.01);
		assertEquals(-1.613, xTest[100], 0.01);
		assertEquals(0.6, xTest[511], 0.01);
	}
	@Test
	public void JuliaSetTest() {
		Julia julia = new Julia();
		double[] xTest = julia.xCoordinate();
		assertEquals(-1.65, xTest[7], 0.01);
		assertEquals(.298, xTest[301], 0.01);
		assertEquals(.969, xTest[402], 0.01);
		assertEquals(1.62, xTest[500], 0.01);
	}
}
