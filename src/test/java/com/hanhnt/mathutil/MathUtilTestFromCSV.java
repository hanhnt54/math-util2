
package com.hanhnt.mathutil;

import com.hanhnt.mathutil.core.MathUtil;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class MathUtilTestFromCSV {

    @ParameterizedTest
    @CsvFileSource(
            resources = "/data.csv",
            numLinesToSkip = 1
    )
    void testGetFactorial_ValidInput_FromCsv(int input, long expected) {
        assertEquals(expected, MathUtil.getFactorial(input));
    }

    @ParameterizedTest
    @CsvSource({
        "0, 1",
        "1, 1",
        "20, 2432902008176640000"
    })
    void testGetFactorial_BoundaryValues(int input, long expected) {
        assertEquals(expected, MathUtil.getFactorial(input));
    }

    @ParameterizedTest
    @CsvSource({
        "-1",
        "21"
    })
    void testGetFactorial_InvalidInput_ThrowsException(int input) {
        assertThrows(
                IllegalArgumentException.class,
                () -> MathUtil.getFactorial(input)
        );
    }

}
