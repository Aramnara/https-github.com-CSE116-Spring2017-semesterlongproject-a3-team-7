package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.BurningShip;
import code.Julia;
import code.Mandelbrot;
import code.Multibrot;

/**
 * This class contains JUnit test that testing the
 * escape time for a coordinate whose distance from the origin 
 * never exceeds the escape distance.
 * 
 * @author Zhenduo Lin
 * @author Anthony Ramnarain
 * @author JaeHoon Oh
 */
public class EscapeTimeTest {
	
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
	 * for the Julia Set.
	 */
	@Test
	public void JuliaSetTest() {
		Julia julia = new Julia();
		assertEquals(225, julia.calcEscapeTime(1.0492187499999897, -0.234375));
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
	
	/**
	 * This JUnit test testing the escape time for a coordinate
	 * whose distance from the origin never exceeds the escape distance
	 * for the Multibrot Set.
	 */
	@Test
	public void MultibrotSetTest() {
		Multibrot multibrot = new Multibrot();
		assertEquals(225, multibrot.calcEscapeTime(0.5859375, 0.24375000000000108));		
	}
}
