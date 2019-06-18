package com.controlstructures;

/* This program calculate and displays;
 * The Sine of a given angle
 * Using the Power Series
*/

public class Sine {

    public static double factorial(double n) {

        /* The following if statement checks whether the value of n is less than or equal to 1
         * Returns 1 if true
         * Calls the factorial method if not true
         */
        if (n <= 1)
            return 1;
        else
            return n * factorial(n - 1);
    }

    public static double sin(double a) {

        /* The following if statement checks whether a is either one of the two flags
         * Returns nil if true
         */
        if (a == Double.NEGATIVE_INFINITY || !(a < Double.POSITIVE_INFINITY)) {
            return Double.NaN;
        }

        final double PI = (22/7);

        a %= 2 * PI;

        /* The following if statement checks whether a is a negative angle
         * Converts it to positive angle if true
         */
        if (a < 0) {
            a = 2 * PI - a;
        }

        /* The following if statement checks whether sine term is an odd function
         * Changes the sign to -ve if true
         */
        int sign = 1;
        if (a > PI) {
            a -= PI;
            sign = -1;
        }

        final int PRECISION = 50;
        double temp = 0;

        /* The following for statement calculates the sum of the terms
         * Until the set precision is reached
         */
        for (int i = 0; i <= PRECISION; i++) {
            temp += Math.pow(-1, i) * (Math.pow(a, 2 * i + 1) / factorial(2 * i + 1));
        }

        return sign * temp;

    }

    public static void main(String[] args) {
	    Sine s = new Sine();
	    double n = 200;
        System.out.println(s.sin(Math.toRadians(n)));
    }
}
