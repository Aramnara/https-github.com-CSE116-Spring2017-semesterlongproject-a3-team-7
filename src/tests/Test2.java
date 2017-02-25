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
public class Test2 {
	
	/**
	 * This JUnit test is testing the translation
	 * between pixel's column and the corresponding y-coordinate
	 * for the Mandelbrot Set.
	 */
	@Test
	public void MandelbrotSetTest() {
		Mandelbrot mandelbrot = new Mandelbrot();
		double[] yTest = mandelbrot.yCoordinate();
		assertEquals(-1.3, yTest[0], 0.01);
		assertEquals(-1.28, yTest[4], 0.01);
		assertEquals(0.117, yTest[279], 0.01);
		assertEquals(1.29, yTest[511], 0.01);
	}
	
	/**
	 * This JUnit test is testing the translation
	 * between pixel's column and the corresponding y-coordinate
	 * for the Julia Set.
	 */
	@Test
	public void JuilaSetTest() {
		Julia julia = new Julia();
		double[] yTest = julia.yCoordinate();
		assertEquals(-.972, yTest[7], 0.01);
		assertEquals(-.929, yTest[18], 0.01);
		assertEquals(.355, yTest[347], 0.01);
		assertEquals(.972, yTest[505], 0.01);
	}
	
	/**
	 * This JUnit test is testing the translation
	 * between pixel's column and the corresponding y-coordinate
	 * for the Burning Ship Set.
	 */
	@Test
	public void BurningShipSetTest() {
		BurningShip burningship = new BurningShip();
		double[] yTest = burningship.yCoordinate();
		assertEquals(-0.078, yTest[10], 0.01);
		assertEquals(-0.06, yTest[99], 0.01);
		assertEquals(-0.039, yTest[200], 0.01);
		assertEquals(0.012, yTest[451], 0.01);
	}
	@Test
	public void MultibrotSetTest() {
		Multibrot multibrot = new Multibrot();
		double[] yTest = multibrot.yCoordinate();
		assertEquals(-1.3, yTest[], 0.01);
		assertEquals(-1.28, yTest[], 0.01);
		assertEquals(0.117, yTest[], 0.01);
		assertEquals(1.29, yTest[], 0.01);
}
}