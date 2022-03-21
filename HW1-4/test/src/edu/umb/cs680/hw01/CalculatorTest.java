package edu.umb.cs680.hw01;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
public class CalculatorTest {

		@Test
		public void multiply5By4() {
			Calculator cut = new Calculator();
			float expected = 20;
			float actual = cut.multiply(5, 4);
			assertTrue(cut instanceof Calculator);
			assertEquals(expected, actual);
		}

		@Test
		public void divide7By2() {
			Calculator cut = new Calculator();
			float expected = 3.5f;
			float actual = cut.divide(7, 2);
			assertEquals(expected, actual);
		}

		@Test
		public void divide5By0withTryCatch() {
			Calculator cut = new Calculator();
			try {
				cut.divide(2, 0);
				fail("Division by zero");
			} catch (IllegalArgumentException ex) {
				assertEquals("division by zero", ex.getMessage());
			}
		}
	}