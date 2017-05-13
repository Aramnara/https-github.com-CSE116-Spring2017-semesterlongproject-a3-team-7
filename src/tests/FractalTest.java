package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.BurningShip;
import code.Julia;
import code.Mandelbrot;
import code.Multibrot;

/**
 * This class contains JUnit tests which testing 
 * the returns of fractals to be 2d-array with 512 rows and 512 columns.
 * 
 * @author Zhenduo Lin
 * @author Anthony Ramnarain
 * @author Jae Hoon Oh
 */
public class FractalTest {
	
	/**
	 * This JUnit test method testing all four fractals
	 * expecting to return a 2d-array with 2048 rows and 2048 columns.
	 */
	@Test
	public void Test1() {
		int[][] testArray = new int[2048][2048];
		
		Mandelbrot mandelbrot = new Mandelbrot();
		assertEquals(testArray.length, mandelbrot.finalFractal(-2.16, 0.6, -1.3, 1.3).length, 0.001);
		
		Julia julia = new Julia();
		assertEquals(testArray.length, julia.finalFractal(-1.7, 1.7, -1, 1).length, 0.001);
		
		BurningShip burningship = new BurningShip();
		assertEquals(testArray.length, burningship.finalFractal(-1.8, -1.7, -0.08, 0.025).length, 0.001);
		
		Multibrot multibrot = new Multibrot();
		assertEquals(testArray.length, multibrot.finalFractal(-1, 1, -1.3, 1.3).length, 0.001);
	}
}
