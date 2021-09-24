package com.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	@Test
	void testAddWithEmptyString() {
		assertEquals(StringCalculator.add(""), 0);
	}

	@Test
	void testAddWithOneNumber() {
		assertEquals(StringCalculator.add("4"), 4);
	}

	@Test
	void testAddWithTwonumber() {
		assertEquals(StringCalculator.add("4,5"), 9);
	}

	@Test
	void testAddWithUnknownnumber() {
		assertEquals(StringCalculator.add("4,5,1"), 10);
	}

	@Test
	void testAddWithNumberSplitByComaAndNewlines() {
		assertEquals(StringCalculator.add("4,5\n1"), 10);
	}

	@Test
	void testAddWithException() {
		assertThrows(NumberFormatException.class, () -> {
			StringCalculator.add("4,5,\n1");
		});
	}

	@Test
	void testAddWithNegativeNumber() {
		assertThrows(RuntimeException.class, () -> {
			StringCalculator.add("4,-5,-1");
		});
	}

	@Test
	void testAddWithWrongDelimiter() {
		assertThrows(RuntimeException.class, () -> {
			StringCalculator.add("//4,-5,-1");
		});
	}
	@Test
	void testAddWithCustomDelimiter() {
		assertEquals(StringCalculator.add("//;\n5;2;3"), 10);
	}
}
