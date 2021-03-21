package com.codingchallenge.algorithm;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.codingchallenge.algorithm.TestingSecurityManager.TestExitException;

/**
 * AlgorithmAppTest is a unit test for AlgorithmApp class.
 * <p>
 * In AlgorithmAppTest class we use JUnit 5 to test methods from AlgorithmApp
 * class and some possible scenarios.
 * 
 * @author Kenan Spahiæ
 * @version 1.0
 * @since 2019-08-30
 */
@DisplayName("Testing AlgorithmApp class")
public class AlgorithmAppTest {

	// Enables you to write formatted data to an underlying OutputStream.
	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	static SecurityManager originalSecurityManager;

	@BeforeAll
	public static void setup() {
		// Insert our own custom SecurityManager that throws an exception when
		// System.exit() is called.
		originalSecurityManager = System.getSecurityManager();
		System.setSecurityManager(new TestingSecurityManager());
	}

	@AfterAll
	public static void tearDown() {
		// Reinsert the original SecurityManager now that we are done with these tests.
		System.setSecurityManager(originalSecurityManager);
	}

	/**
	 * Using nested class for testing different scenarios that can be passed to main
	 * method as an argument and some output values produced by main method.
	 */
	@Nested
	@DisplayName("Main method test")
	class MainTest {

		@Test
		@DisplayName("with correct array that has checksum in his members")
		void testMainOnMatchingArray() {
			// Should print the correct output:
			// [44, 3]
			// [-15, 62]
			String[] arr1 = { "44", "3", "27", "32", "-15", "62" };
			AlgorithmApp.main(arr1);
		}

		@Test
		@DisplayName("with correct array that does not have checksum in his members")
		void testMainOnNotMatchingArray() {
			// Should print the output for not finding any matching checksum.
			String[] arr1 = { "12", "24", "34", "7", "88", "-13" };
			AlgorithmApp.main(arr1);
		}

		@Test
		@DisplayName("with letters in array")
		void testMainOnLetters() {

			String[] arr1 = { "0", "8", "15", "7", "13", "A", "4", "1" };
			try {
				AlgorithmApp.main(arr1);
				// Our custom SecurityManager should have thrown an exception when AlgorithmApp
				// exited.
				// This means this line below cannot be reached. To make sure that our custom
				// SecurityManager
				// works as expected, we fail the test if this line is ever reached:
				fail("Unreachable.");
			} catch (TestExitException e) {
				assertThat(e.getStatus(), is(AlgorithmApp.EXIT_STATUS_PARAMETER_IS_NOT_A_NUMBER));
			}
		}

		@Test
		@DisplayName("with empty array")
		public void testMainOnEmptyArray() {
			// Passing no arguments should work.
			String[] arr1 = {};
			AlgorithmApp.main(arr1);
		}

	}

}
