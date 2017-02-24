package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Julia;
import code.Mandelbrot;

/**
 * This class contains JUnit tests which testing
 * the y-coordinates in each fractal row.
 * 
 * @author Zhenduo Lin
 */
public class Test2 {
	
	/**
	 * This JUnit test is testing the translation
	 * between pixel's column and the corresponding y-coordinate
	 * for the Mandelbrot Set.
	 */
	@Test
	public void MandelbrotSetTest() {
		Mandelbrot mandelbrot = new Mandelbrot();
		double[] yTest = mandelbrot.yCoordinate();
		assertEquals(-1.3, yTest[0], 0.01);
		assertEquals(-1.28, yTest[4], 0.01);
		assertEquals(0.117, yTest[279], 0.01);
		assertEquals(1.29, yTest[511], 0.01);
	}
	@Test
	public void JuiliSetTest() {
		Julia julia = new Julia();
		double[] yTest = julia.yCoordinate();
		assertEquals(-.972, yTest[7], 0.01);
		assertEquals(-.929, yTest[18], 0.01);
		assertEquals(.355, yTest[347], 0.01);
		assertEquals(.972, yTest[505], 0.01);
	}
	
}
