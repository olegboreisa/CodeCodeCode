package lt.boreisa.finalblog;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static lt.boreisa.finalblog.Factorial.factorial;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * TDD (Test Driven Development != Tests
 * 1. First, test to fail;
 * 2. Implement (Make a Correction) Function
 * 3. ---?
 */
public class FactorialShould {

    @Test
    void return_one_when_one_passed () {
        // given
        int input = 1;

        // when
        int result = factorial(input);

        // then
        assertEquals(1, result);
    }

    @Test
    void return_two_when_two_passed () {
        // when
        int result = factorial(2);

        // then
        assertEquals(2, result);
    }

    @Test
    void return_six_when_three_passed () {
        // when
        int result = factorial(3);

        // then
        assertEquals(6, result);
    }

    @Test
    void return_120_when_5_passed () {
        // when
        int result = factorial(5);

        // then
        assertEquals(120, result);
    }

    @Test
    void return_big_when_10_passed () {
        // when
        int result = factorial(10);

        // then
        assertEquals(10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1, result);
    }

    @Test
    void throws_exception_when_negative () {
        assertThrows(IllegalArgumentException.class, () -> factorial(-5));
    }


}
