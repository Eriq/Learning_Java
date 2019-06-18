package com.arrays;

/* This program asks the user for the following Student details;
 * First Name, Last Name, Age, Gender;
 * Stores them in an Array,
 * Then retrieves and displays them from the array
*/

import java.util.Scanner;

public class Arrays {

    public static void main(String[] args) {
        int n = 4;                              //Declare the size of the Array
        String[] student;                       //Declare an Array of Strings, student, to store the details
        student = new String[n];                //Initialize the Array by specifying its size

        Scanner s = new Scanner(System.in);

        //Array indexing starts at 0
        System.out.print("First Name:\t");
        student[0] = s.next();                  //First name is stored at the first index, 0
        System.out.print("Last Name:\t");
        student[1] = s.next();                  //Last Name is stored in the second index, 1
        System.out.print("Age:\t");
        student[2] = s.next();                  //Age is stored in the third index, 2
        System.out.print("Gender:\t");
        student[3] = s.next();                  //Gender is stored in the fourth index, 3

        //Items stored in the array are accessed using their position index
        System.out.println("\nEntered Details Are:\nF Name:\t"+student[0]+"\nL Name:\t"+student[1]+"\nAge:\t"+student[2]+"\nGender:\t"+student[3]);
    }
}