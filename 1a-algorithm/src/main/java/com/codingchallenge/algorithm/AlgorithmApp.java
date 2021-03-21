package com.codingchallenge.algorithm;

import java.util.Arrays;

/**
 * AlgorithmApp contains main method and represents the entry point of this
 * program.
 * <p>
 * The AlgorithmApp implements the main method and through her parameters and
 * Algorithm object executes the task of finding pairs of numbers that are equal
 * to checksum.
 * 
 * @author Kenan Spahiæ
 * @version 1.0
 * @since 2019-08-30
 */
public class AlgorithmApp {

	static int EXIT_STATUS_PARAMETER_IS_NOT_A_NUMBER = 2;

	/**
	 * This is the main method which makes use of Algorithm object and his methods
	 * setChecksum(), to set the value for checksum attribute and summation()
	 * method, to execute the process of finding the pairs of numbers whose sum is
	 * equal to checksum.
	 * 
	 * @param args Represents an parameter in form of an array that you want to be
	 *             processed. It can only contain numbers or it will throw an
	 *             exception. You can pass it to a method through command line.
	 *             Example: <b>mvn exec:java
	 *             -Dexec.mainClass=com.codingchallenge.algorithm.AlgorithmApp
	 *             -Dexec.args="0 24 45 11 17 33"</b>
	 */
	public static void main(String[] args) {

		// Logic which converts String[] args parameter into int[] arr
		int[] arr = new int[args.length];
		int i = 0;
		for (String str : args) {
			try {
				arr[i] = Integer.parseInt(str);
				i++;
			} catch (NumberFormatException e) {
				System.err.println("The parameter that you have passed is not a number! " + "Parameter was: [" + str
						+ " at index " + i + "]");
				System.exit(EXIT_STATUS_PARAMETER_IS_NOT_A_NUMBER);
			}
		}

		/*
		 * Making Algorithm object and setting the <b>checksum value to 47 as an example
		 * but you can change it to something else</b>. After everything is set, the
		 * program is going throw results array and printing the value. If the array is
		 * not empty, elements will be printed on console. If the array is empty
		 * appropriate message will be printed on console.
		 */
		Algorithm algorithm = new Algorithm();
		algorithm.setChecksum(47);
		int[][] results = algorithm.summation(arr);
		if (results.length != 0) {
			for (int[] result : results) {
				System.out.println(Arrays.toString(result));
			}
		} else {
			System.out.println("There aren't any members with checksum:  " + algorithm.getChecksum() + " ,in array: "
					+ Arrays.toString(arr));
		}

	}
}
