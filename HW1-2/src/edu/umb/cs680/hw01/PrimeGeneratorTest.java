package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



class PrimeGeneratorTest {

	@Test
	public void genPrime_1To18() throws Exception {
		PrimeGenerator prime = new PrimeGenerator(1, 18);
		prime.generatePrimes();
		Long[] expectedNum = { 2L, 3L, 5L, 7L, 11L, 13L, 17L };
		assertArrayEquals(expectedNum, prime.getPrimes().toArray());

	}

	@Test
	public void GenPrime_18To1() throws Exception {
		try {
			PrimeGenerator prime = new PrimeGenerator(18, 1);

		} catch (RuntimeException ex) {
			assertEquals("Wrong input values: from=18 to=1", ex.getMessage());
		}

	}

	@Test
	public void GeneratePrimenegativeTo1() throws Exception {
		try {
			PrimeGenerator prime = new PrimeGenerator(-18, 1);

		} catch (RuntimeException ex) {
			assertEquals("Wrong input values: from=-18 to=1", ex.getMessage());
		}

	}

	

}