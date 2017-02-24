package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.Mandelbrot;

/**
 * This class contains JUnit test that testing
 * the escape time for a coordinate 
 * whose distance from the origin exceeds the escape distance after a single loop pass.
 * 
 * @author Zhenduo Lin
 */
public class Test4 {
	
	/**
	 * This JUnit test testing the escape time for a coordinate
	 * whose distance from the origin exceeds the escape distance after a single loop pass
	 * for the MandelbrotSet.
	 */
	@Test
	public void MandelbrotSetTest() {
		Mandelbrot mandelbrot = new Mandelbrot();
		assertEquals(1 ,mandelbrot.calcEscapeTime(0.5946289062500001, 1.2949218750000122));
	}
}
