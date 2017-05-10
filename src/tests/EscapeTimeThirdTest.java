package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.BurningShip;
import code.Julia;
import code.Mandelbrot;
import code.Multibrot;

/**
 * This class contains JUnit test that testing
 * the escape time for a coordinate 
 * whose distance from the origin never exceeds the escape distance
 * when the maximum escape time is set to 135 and the escape distance is set to 2.
 * 
 * @author Zhenduo Lin
 * @author Anthony Ramnarain
 * @author Jae Hoon Oh
 */
public class EscapeTimeThirdTest {
	
	/**
	 * This JUnit test testing the escape time for a coordinate
	 * whose distance from the origin never exceeds the escape distance
	 * when the maximum escape time is set to 135 and the escape distance is set to 2
	 * for Mandelbrot Set.
	 */
	@Test
	public void MandelbrotTest() {
		Mandelbrot mandelbrot = new Mandelbrot();
		mandelbrot.escapeDistance(2);
		mandelbrot.escapeTime(135);
		assertEquals(135, mandelbrot.calcEscapeTime(0.3207031250000001, -0.07109374999999386));
	}
	
	/**
	 * This JUnit test testing the escape time for a coordinate
	 * whose distance from the origin never exceeds the escape distance
	 * when the maximum escape time is set to 135 and the escape distance is set to 2
	 * for Julia Set.
	 */
	@Test
	public void JuliaTest() {
		Julia julia = new Julia();
		julia.escapeDistance(2);
		julia.escapeTime(135);
		assertEquals(135, julia.calcEscapeTime(1.0492187499999897, -0.234375));
	}
	
	/**
	 * This JUnit test testing the escape time for a coordinate
	 * whose distance from the origin never exceeds the escape distance
	 * when the maximum escape time is set to 135 and the escape distance is set to 2
	 * for BurningShip Set.
	 */
	@Test
	public void BurningShipTest() {
		BurningShip burningShip = new BurningShip();
		burningShip.escapeDistance(2);
		burningShip.escapeTime(135);
		assertEquals(135, burningShip.calcEscapeTime(-1.7443359374999874, -0.017451171875000338));
	}
	
	/**
	 * This JUnit test testing the escape time for a coordinate
	 * whose distance from the origin never exceeds the escape distance
	 * when the maximum escape time is set to 135 and the escape distance is set to 2
	 * for Multibrot Set.
	 */
	@Test
	public void MultibrotTest() {
		Multibrot multibrot = new Multibrot();
		multibrot.escapeDistance(2);
		multibrot.escapeTime(135);
		assertEquals(135, multibrot.calcEscapeTime(0.5859375, 0.24375000000000108));
	}
}