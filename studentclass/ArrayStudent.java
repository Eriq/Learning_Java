package com.studentclass;

/* This class:
 * Creates 3 student objects,
 * Stores the objects in an Array,
 * Then retrieves and displays them from the Array
 */

public class ArrayStudent {

    public static void main(String[] args) {
        //Create Array to store Students
        Student[] studentArray = new Student[3];

        //Add Students to Array
        for (int i=0; i<3; i++) {
            Student s = new Student();
            studentArray[i] = s;
        }

        //Display Students from Array
        for(int i=0; i<3; i++) {
            Student s = studentArray[i];
            System.out.println(s.getName()+", "+s.getAge()+", "+s.getSex());
        }
    }
}
