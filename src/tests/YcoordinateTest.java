package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.BurningShip;
import code.Julia;
import code.Mandelbrot;
import code.Multibrot;

/**
 * This class contains JUnit tests which testing
 * the y-coordinates in each fractal row.
 * 
 * @author Zhenduo Lin
 * @author Anthony Ramnarain
 * @author JaeHoon Oh
 */
public class YcoordinateTest {
	
	/**
	 * This JUnit test is testing the translation
	 * between pixel's column and the corresponding y-coordinate
	 * for the Mandelbrot Set.
	 */
	@Test
	public void MandelbrotSetTest() {
		Mandelbrot mandelbrot = new Mandelbrot();
		double[] yTest = mandelbrot.yCoordinate(-1.3, 1.3);
		assertEquals(-1.295, yTest[4], 0.01);
		assertEquals(-0.946, yTest[279], 0.01);
		assertEquals(-0.651, yTest[511], 0.01);
		assertEquals(-0.030, yTest[1000], 0.01);
	}
	
	/**
	 * This JUnit test is testing the translation
	 * between pixel's column and the corresponding y-coordinate
	 * for the Julia Set.
	 */
	@Test
	public void JuilaSetTest() {
		Julia julia = new Julia();
		double[] yTest = julia.yCoordinate(-1, 1);
		assertEquals(-.993, yTest[7], 0.01);
		assertEquals(-.982, yTest[18], 0.01);
		assertEquals(-0.661, yTest[347], 0.01);
		assertEquals(-0.507, yTest[505], 0.01);
	}
	
	/**
	 * This JUnit test is testing the translation
	 * between pixel's column and the corresponding y-coordinate
	 * for the Burning Ship Set.
	 */
	@Test
	public void BurningShipSetTest() {
		BurningShip burningship = new BurningShip();
		double[] yTest = burningship.yCoordinate(-0.08, 0.025);
		assertEquals(-0.079, yTest[10], 0.01);
		assertEquals(-0.075, yTest[99], 0.01);
		assertEquals(-0.070, yTest[200], 0.01);
		assertEquals(-0.057, yTest[451], 0.01);
	}
	
	/**
	 * This JUnit test is testing the translation
	 * between pixel's column and the corresponding y-coordinate
	 * for the Multibort Set.
	 */
	@Test
	public void MultibrotSetTest() {
		Multibrot multibrot = new Multibrot();
		double[] yTest = multibrot.yCoordinate(-1.3, 1.3);
		assertEquals(-1.294, yTest[5], 0.01);
		assertEquals(-1.154, yTest[115], 0.01);
		assertEquals(-0.862, yTest[345], 0.01);
		assertEquals(0.826, yTest[1675], 0.01);
	}
}