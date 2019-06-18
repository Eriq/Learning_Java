package com.variables;

/*
 * This program finds the solutions to a quadratic equation
*/

import java.util.Scanner;

public class Quadratic {
	public static void main(String[] args) {

		//Variable declarations

		double a;		//Variable to store the value of a
		double b;		//Variable to store the value of b
		double c;		//Variable to store the value of c
		double x1;		//Variable to store the first solution to the quadratic equation
		double x2;		//Variable to store the second solution to the quadratic equation

		Scanner input = new Scanner(System.in);

		//Variable initialization

		System.out.print("Input a: ");
		a = input.nextDouble();				//Initialize variable a to the given the user input
		System.out.print("Input b: ");
		b = input.nextDouble();				//Initialize variable b to the given user input
		System.out.print("Input c: ");
		c = input.nextDouble();				//Initialize variable c to the given user input

		x1 = ((-b) + Math.sqrt(b * b - (4 * a * c))) /2 * a;	//Initialize x1 to the first solution of the equation
		System.out.println("The value of root1 is: " + x1);

		x2 = ((-b) - Math.sqrt(b * b - (4 * a * c))) /2 * a;	//Initialize x2 to the second solution of the equation
		System.out.println("The value of root2 is: " + x2);
	}    
}
