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
	 * expecting to return a 2d-array with 512 rows and 512 columns.
	 */
	@Test
	public void Test1() {
		int[][] testArray = new int[512][512];
		
		Mandelbrot mandelbrot = new Mandelbrot();
		assertEquals(testArray.length, mandelbrot.finalFractal().length, 0.001);
		
		Julia julia = new Julia();
		assertEquals(testArray.length, julia.finalFractal().length, 0.001);
		
		BurningShip burningship = new BurningShip();
		assertEquals(testArray.length, burningship.finalFractal().length, 0.001);
		
		Multibrot multibrot = new Multibrot();
		assertEquals(testArray.length, multibrot.finalFractal().length, 0.001);
	}

}
