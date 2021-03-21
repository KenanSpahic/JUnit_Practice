package com.codingchallenge.algorithm;

/**
 * Algorithm is the base class for processing arrays and finding the members with
 * a corresponding checksum.
 * 
 * <p>
 * The Algorithm class contains checksum attribute with getter and setter
 * methods, and summation method which accepts array of numbers as parameter and
 * returns the corresponding result in form of multidimensional array.
 *
 * @author Kenan Spahiæ
 * @version 1.0
 * @since 2019-08-30
 */
public class Algorithm {

	/**
	 * Represents the checksum which determines the output of summation method.
	 * 
	 * @see #summation(int[])
	 */
	private int checksum = 0;

	/**
	 * Gets the checksum value
	 * 
	 * @return A number that you want to search in array
	 */
	public int getChecksum() {
		return checksum;
	}

	/**
	 * Sets the checksum value.
	 * 
	 * @param checksum A number that contains the value that you want to search in
	 *                 array
	 */
	public void setChecksum(int checksum) {
		this.checksum = checksum;
	}

	/**
	 * This method is used for processing array and based on checksum value it
	 * returns 2 dimensional array consisting of arrays with two members whose sum
	 * is equal to a checksum value.
	 * 
	 * @param numbers This is the parameter that represents an array of numbers from
	 *                which you want to find the pairs whose sum is equal to
	 *                checksum value.
	 * @return A two dimensional array whose elements represent the pairs of numbers
	 *         whose sum is equal to checksum value.
	 */
	public int[][] summation(int[] numbers) {

		int[][] results;
		int counter = 0;

		/*
		 * Searching how many pairs have the sum equal to checksum value and increasing
		 * the counter's value for every pair.
		 */
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == checksum) {
					counter++;
				}
			}
		}

		results = new int[counter][2];
		counter = 0;
		
		// Populating and returning a new array based on previous search.		 		 
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == checksum) {
					results[counter][0] = numbers[i];
					results[counter][1] = numbers[j];
					counter++;
				}
			}
		}
		return results;
	}

}
