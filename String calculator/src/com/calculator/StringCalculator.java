package com.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

	public static int add(String stringNumber) {

		if (!stringNumber.isEmpty()) {
			String[] stringNums = splitString(stringNumber);
			int sum = 0;
			List<Integer> numbers = stringToInt(stringNums);
			checkForNegative(numbers);
			for (Integer integer : numbers) {
				sum += integer;
			}
			return sum;
		}
		return 0;
	}

	/**
	 * function to split the string.
	 * 
	 * @param stringNumbers
	 * @return
	 */
	public static String[] splitString(String stringNumbers) {
		if (stringNumbers.startsWith("//")) {
			Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(stringNumbers);
			if (matcher.matches()) {
				String delimiter = matcher.group(1);
				String toSplit = matcher.group(2);
				return toSplit.split(delimiter);
			}
			throw new RuntimeException("wrong custom delimeter format");
		}
		return stringNumbers.split(",|\n");
	}

	/**
	 * function to convert string to int
	 * 
	 * @param stringNumbers
	 * @return
	 */
	public static List<Integer> stringToInt(String[] stringNumbers) {
		List<Integer> numbers = Arrays.stream(stringNumbers).map(Integer::parseInt).collect(Collectors.toList());
		return numbers;
	}

	/**
	 * function to check for negative; if found then throwing exception
	 * 
	 * @param numbers
	 */
	public static void checkForNegative(List<Integer> numbers) {

		StringBuilder builder = new StringBuilder();
		for (Integer integer : numbers) {
			if (integer < 0)
				builder.append(integer).append(" ");
		}
		if (!builder.isEmpty()) {
			throw new RuntimeException("negative is not allowed " + builder.toString());
		}
	}

}