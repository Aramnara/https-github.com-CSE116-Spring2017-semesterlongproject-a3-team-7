package edu.buffalo.cse116;

import static org.junit.Assert.*;

public class Test {
	
	private EscapeTimeAlgorithms _escape;

	@org.junit.Test
	public void test() {
		_escape = new EscapeTimeAlgorithms();
		assertEquals(0.4442096267, _escape.MandelbrotSet(0.3207031250000001, -0.07109374999999386), 0.001);
	}

}
