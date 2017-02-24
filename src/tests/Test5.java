package tests;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import code.BurningShip;

/**
 * This class contains JUnit test that testing
 * none of the pixels in the Burning Ship set have an escape time of 0 or 1.
 * 
 * @author Zhenduo Lin
 */
public class Test5 {

	/**
	 * This JUnit test testing that
	 * none of the pixels in the Burning Ship set have an escape time of 0 or 1.
	 */
	@Test
	public void BurningShipTest() {
		BurningShip burningship = new BurningShip();
		int[][] testArray = burningship.finalFractal();
		HashSet<Integer> set = new HashSet<Integer>();
		for (int rows=0; rows<512; rows++) {
			for (int cols=0; cols<512; cols++) {
				set.add(testArray[rows][cols]);
			}
		}
		assertFalse(set.contains(0));
		assertFalse(set.contains(1));
	}
}
