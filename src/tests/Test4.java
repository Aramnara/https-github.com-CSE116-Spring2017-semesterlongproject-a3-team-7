package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.Julia;
import code.Mandelbrot;
import code.Multibrot;

/**
 * This class contains JUnit test that testing
 * the escape time for a coordinate 
 * whose distance from the origin exceeds the escape distance after a single loop pass.
 * 
 * @author Zhenduo Lin
 * @author Anthony Ramnarain
 * @author Jae Hoon Oh
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
	
	/**
	 * This JUnit test testing the escape time for a coordinate
	 * whose distance from the origin exceeds the escape distance after a single loop pass
	 * for the Julia Set.
	 */
	@Test
	public void JuliaSetTest() {
		Julia julia = new Julia();
		assertEquals(1, julia.calcEscapeTime(1.6933593749999853, 0.9765625));
	}
	
	/**
	 * This JUnit test testing the escape time for a coordinate
	 * whose distance from the origin exceeds the escape distance after a single loop pass
	 * for the Multibrot Set.
	 */
	@Test
	public void MultibrotSetTest(){		
		Multibrot multibrot = new Multibrot();
		assertEquals(1, multibrot.calcEscapeTime(0.9921875, 1.05625));	
	}

}
