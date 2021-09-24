package com.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	@Test
	void testAddWithEmptyString() {
		assertEquals(StringCalculator.add(""), 0);
	}

	
}
