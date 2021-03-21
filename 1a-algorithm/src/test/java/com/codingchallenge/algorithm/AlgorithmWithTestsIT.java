package com.codingchallenge.algorithm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Integration test for the AlgorithmApp program.
 * <p>
 * An integration test verifies the workings of a complete program or a module.
 */
@DisplayName("Integration test for AlgorithmApp program")
public class AlgorithmWithTestsIT {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void before() {
        // By putting our own PrintStream in the place of the normal System.out,
        // the output produced by the application can be verified.
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    public void cleanUp() {
        // Restore the original System.out to prevent weirdness in any following tests.
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("when the parameter contains the correct checksum")
    public void doesItPrint2() {
        String[] arr1 		= { "44", "3", "27", "32", "-15", "62" };
        int[] result1 		= {44, 3};
        int[] result2		= {-15, 62};
        AlgorithmApp.main(arr1);
        
        String printResult = String.format("%1$s%2$s%3$s%2$s", Arrays.toString(result1), System.lineSeparator(), Arrays.toString(result2));
        assertThat(out.toString(), is(printResult));
    }

    @Test
    @DisplayName("when the parameter does not contain the correct checksum")
    public void doesItPrintMismatch() {
        String[] arr1 	= {};
        AlgorithmApp.main(arr1);
        
        String result1 	= "There aren't any members with checksum:  47 ,in array: []";
        String expectedOut = String.format("%s%s", result1, System.lineSeparator());
        assertThat(out.toString(), is(expectedOut));
    }
}
