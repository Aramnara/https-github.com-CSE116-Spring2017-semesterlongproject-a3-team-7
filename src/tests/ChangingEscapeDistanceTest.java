package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import code.BurningShip;
import code.Julia;
import code.Mandelbrot;
import code.Multibrot;

/**
 * This class contains JUnit test that testing
 * the escape time for a coordinate whose distance from the origin 
 * exceeds the escape distance after a 10 passes of the loop
 * when the escape distance is 3.
 * 
 * @author Zhenduo Lin
 * @author Anthony Ramnarain
 * @author JaeHoon Oh
 */
public class ChangingEscapeDistanceTest {
	
	/**
	 * This JUnit test testing the escape time for a coordinate
	 * whose distance from the origin exceeds the escape distance 
	 * after a 10 passes of the loop for Mandelbrot Set.
	 */
	@Test
	public void MandelbrotTest() {
		Mandelbrot mandelbrot = new Mandelbrot();
		mandelbrot.escapeDistance(3);
		assertEquals(10, mandelbrot.calcEscapeTime(0.46007827788650374, -0.3383561643835661));
	}
	
	/**
	 * This JUnit test testing the escape time for a coordinate
	 * whose distance from the origin exceeds the escape distance 
	 * after a 10 passes of the loop for Julia Set.
	 */
	@Test
	public void JuliaTest() {
		Julia julia = new Julia();
		julia.escapeDistance(3);
		assertEquals(10, julia.calcEscapeTime(1.4538160469667272, -0.13502935420743645));
	}
	
	/**
	 * This JUnit test testing the escape time for a coordinate
	 * whose distance from the origin exceeds the escape distance 
	 * after a 10 passes of the loop for BurningShip Set.
	 */
	@Test
	public void BurningShipTest() {
		BurningShip burningShip = new BurningShip();
		burningShip.escapeDistance(3);
		assertEquals(10, burningShip.calcEscapeTime(-1.6999999999999802, 0.0030136986301371603));
	}
	
	/**
	 * This JUnit test testing the escape time for a coordinate
	 * whose distance from the origin exceeds the escape distance 
	 * after a 10 passes of the loop for Multibrot Set.
	 */
	@Test
	public void MultibrotTest() {
		Multibrot multibrot = new Multibrot();
		multibrot.escapeDistance(3);
		assertEquals(10, multibrot.calcEscapeTime(0.7025440313111545, -0.5520547945205528));
	}
	
}
