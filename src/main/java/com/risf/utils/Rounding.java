package com.risf.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rounding {

    public static Double getRoundingValue(Double val, Double roudingValue) {
        float division = (float) (val / roudingValue);
        int rounded = Math.round(division);
        return rounded * roudingValue;
    }

    public static Double scaleDouble(Double num) {
        return BigDecimal.valueOf(num).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
