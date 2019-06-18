package com.firstapplication;

/* This is a simple java program that;
 * Calculates,
 * And displays the area of a rectangle
 */

public class Area {
	public static void main(String []args) {
		int length;								//Variable to store the length
		int width ;								//Variable to store the width
		int area;								//Variable to store the Area
		length = 4;								//length has been assigned the value 4
		width = 3;								//the width is given the value 3

		area = (length * width); 				//the area is set as the value of length x width

		System.out.println("The area is "+area);//Prints the area to the screen
	}
}
