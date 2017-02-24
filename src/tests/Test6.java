package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Julia;
import code.Mandelbrot;

/**
 * This class contains JUnit tests which testing 
 * the returns of fractals to be 2d-array with 512 rows and 512 columns.
 * 
 * @author Zhenduo Lin
 */
public class Test6 {
	
	/**
	 * This JUnit test method testing all four fractals
	 * expecting to return a 2d-array with 512 rows and 512 columns.
	 */
	@Test
	public void Test1() {
		int[][] testArray = new int[512][512];
		
		Mandelbrot mandelbrot = new Mandelbrot();
		assertEquals(testArray.length, mandelbrot.finalFractal().length, 0.001);
	}
	@Test
	public void Test2() {
		int[][] testArray = new int[512][512];
		Julia julia = new Julia();
		assertEquals(testArray.length, julia.finalFractal().length, 0.001);
	}
}
