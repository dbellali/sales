package com.risf.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RoundingTest {

    @Test
    public void getRoundingValueTest() {
        Double result = Rounding.getRoundingValue(1.58, 0.05);
        assertEquals(1.6, result);

        result = Rounding.getRoundingValue(1.57, 0.05);
        assertEquals(1.55, result);

    }

    @Test
    public void scaleDoubleTest() {

        Double result = Rounding.scaleDouble(3.480000000002);
        assertEquals(3.48, result);

    }

}
