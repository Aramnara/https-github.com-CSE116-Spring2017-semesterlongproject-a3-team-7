package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.BurningShip;
import code.Julia;
import code.Mandelbrot;
import code.Multibrot;

/**
 * This class contains JUnit tests which testing
 * the x-coordinates in each fractal row.
 * 
 * @author Zhenduo Lin
 * @author Anthony Ramnarain
 * @author Jae Hoon Oh
 */
public class XcoordinateTest {
	
	/**
	 * This JUnit test is testing the translation
	 * between pixel's row and the corresponding x-coordinate
	 * for the Mandelbrot Set.
	 */
	@Test
	public void MandelbrotSetTest() {
		Mandelbrot mandelbrot = new Mandelbrot();
		double[] xTest = mandelbrot.xCoordinate(-2.15, 0.6);
		assertEquals(-2.15, xTest[0], 0.01);
		assertEquals(-2.147, xTest[2], 0.01);
		assertEquals(-2.016, xTest[100], 0.01);
		assertEquals(-1.464, xTest[511], 0.01);
	}
	
	/**
	 * This JUnit test is testing the translation
	 * between pixel's row and the corresponding x-coordinate
	 * for the Julia Set.
	 */
	@Test
	public void JuliaSetTest() {
		Julia julia = new Julia();
		double[] xTest = julia.xCoordinate(-1.7, 1.7);
		assertEquals(-1.688, xTest[7], 0.01);
		assertEquals(-1.200, xTest[301], 0.01);
		assertEquals(-1.033, xTest[402], 0.01);
		assertEquals(-0.870, xTest[500], 0.01);
	}
	
	/**
	 * This JUnit test is testing the translation
	 * between pixel's row and the corresponding x-coordinate
	 * for the Burning Ship Set.
	 */
	@Test
	public void BurningShipSetTest() {
		BurningShip burningship = new BurningShip();
		double[] xTest = burningship.xCoordinate(-1.8, -1.7);
		assertEquals(-1.80, xTest[68], 0.01);
		assertEquals(-1.787, xTest[265], 0.01);
		assertEquals(-1.775, xTest[511], 0.01);
		assertEquals(-1.702, xTest[2000], 0.01);
	}
	
	/**
	 * This JUnit test is testing the translation
	 * between pixel's row and the corresponding x-coordinate
	 * for the Multibrot Set.
	 */
	@Test
	public void MultibrotSetTest() {
		Multibrot multibrot = new Multibrot();
		double[] xTest = multibrot.xCoordinate();
		assertEquals(-1, xTest[0], 0.01);
		assertEquals(-0.996, xTest[4], 0.01);
		assertEquals(-0.734, xTest[272], 0.01);
		assertEquals(-0.501, xTest[511], 0.01);
	}
}
