package com.studentclass;

/* This class:
 * Creates 3 student objects,
 * Stores the objects in a List,
 * Then retrieves and displays them from the List
 */

import java.util.ArrayList;
import java.util.List;

public class ListStudent {

    public static void main(String[] args) {
        //Create List to store Students
        List<Student> studentList = new ArrayList<Student>();

        //Add Students to List
        Student s1 = new Student();
        studentList.add(s1);

        Student s2 = new Student();
        studentList.add(s2);

        Student s3 = new Student();
        studentList.add(s3);

        //Display Students from List
        for(int i=0; i<3; i++) {
            Student s = studentList.get(i);
            System.out.println(s.getName()+", "+s.getAge()+", "+s.getSex());
        }
    }
}
