package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.BurningShip;
import code.Mandelbrot;

/**
 * This class contains JUnit test that testing the
 * escape time for a coordinate whose distance from the origin 
 * never exceeds the escape distance.
 * 
 * @author Zhenduo Lin
 */
public class Test3 {
	
	/**
	 * This JUnit test testing the escape time for a coordinate
	 * whose distance from the origin never exceeds the escape distance
	 * for the Mandelbrot Set.
	 */
	@Test
	public void MandelbrotSetTest() {
		Mandelbrot mandelbrot = new Mandelbrot();
		assertEquals(225, mandelbrot.calcEscapeTime(0.3207031250000001, -0.07109374999999386));
	}
	
	/**
	 * This JUnit test testing the escape time for a coordinate
	 * whose distance from the origin never exceeds the escape distance
	 * for the Burningship Set.
	 */
	@Test
	public void BurningShipSetTest() {
		BurningShip burningship = new BurningShip();
		assertEquals(225, burningship.calcEscapeTime(-1.7443359374999874, -0.017451171875000338));
	}
}
