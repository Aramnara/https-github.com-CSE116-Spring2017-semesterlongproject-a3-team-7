package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Mandelbrot;

public class Test6 {
	
	@Test
	public void Test() {
		Mandelbrot mandelbrot = new Mandelbrot();
		int[][] testArray = new int[512][512];
		assertEquals(testArray.length, mandelbrot.finalFractal().length, 0.001);
	}

}
