package com.codingchallenge.algorithm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.codingchallenge.algorithm.Algorithm;

/**
 * AlgorithmTest is a test for Algorithm class.
 * <p>
 * In AlgorithmTest class we use JUnit 5 to test methods from Algorithm class
 * and some possible scenarios.
 * 
 * @author Kenan Spahiæ
 * @version 1.0
 * @since 2019-08-30
 */
@DisplayName("Testing Algorithm class")
public class AlgorithmTest {

	Algorithm algorithm;

	/**
	 * Creating an object of Algorithm class before every test method.
	 */
	@BeforeEach
	void init() {
		algorithm = new Algorithm();
	}

	/**
	 * This method is testing some of the possible scenarios of summation() method.
	 * Declaring and passing different arrays as an parameter to summation() method
	 * and also setting different value to checksum attribute.
	 */
	@Test
	@DisplayName("Summation method test with different array and checksum parameters")
	void testSummationMethodOnDifferentChecksum() {

		// Examples of arrays.
		int[] numbers1 = { 44, 3, 27, 32, -15, 62 };
		int[] numbers2 = { 10, 18, 7, 24, 2, 74, 4, 57, -29 };
		int[] numbers3 = { -42, 21, 5, 24, 10, -18, 17 };

		// Expected values that will summation() method return.
		int[][] expected1 = { { 44, 3 }, { -15, 62 } };
		int[][] expected2 = { { 10, 18 }, { 24, 4 }, { 57, -29 } };
		int[][] expected3 = {};

		// Setting checksum to different values and passing the result of summation()
		// method to a new array for easier asserting.
		algorithm.setChecksum(47);
		int[][] actual1 = algorithm.summation(numbers1);
		algorithm.setChecksum(28);
		int[][] actual2 = algorithm.summation(numbers2);
		algorithm.setChecksum(0);
		int[][] actual3 = algorithm.summation(numbers3);
		assertAll(() -> assertArrayEquals(expected1[0], actual1[0], "Should return the correct array."),
				() -> assertArrayEquals(expected1[1], actual1[1], "Should return the correct array."),
				() -> assertArrayEquals(expected2[0], actual2[0], "Should return the correct array."),
				() -> assertArrayEquals(expected2[1], actual2[1], "Should return the correct array."),
				() -> assertArrayEquals(expected2[2], actual2[2], "Should return the correct array."),
				() -> assertArrayEquals(expected3, actual3, "Should return an empty array with message."));
	}
}
