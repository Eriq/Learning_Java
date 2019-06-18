package com.operators;

/* This java program uses the Pythagoras theorem to calculate;
 * The length of the base
 * And the sizes of two angles
 * Of a right angled triangle
*/

import java.lang.Math;
import static java.lang.Math.acos;

public class Pythagoras {
	public static void main(String[] args) {
		double height = 3, hypotenuse = 5;      // '=' is used to assign a value to a variable
        double base, angleA, angleB, area;

        base = Math.sqrt((hypotenuse*hypotenuse) - (height*height)); // '-' is used to get the difference between two values
		System.out.print("\n" + "The size of the Base is: " + base); // '+' is used to concatenate values

		angleA = Math.toDegrees(acos(base/hypotenuse));              // '/' is used to divide two values
		angleB = Math.toDegrees(acos(height/hypotenuse));

		System.out.println("The size of the angle A is:" + angleA);
		System.out.println("The size of the angle B is:" + angleB);

		area = (height*base)/2;                                      // '*' is used to find the product of two values
		System.out.print("Area of triangle is: " + area);
	}   
}