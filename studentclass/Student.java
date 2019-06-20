package com.studentclass;
import java.util.Scanner;

public class Student {
    public String name;                     //Student First Name
    public String age;                      //Student Age
    public String sex;                      //Student Gender

    //Setter and Getter Methods for the Student Class Attributes
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    //Student Class Constructor
    public Student() {
        Scanner n = new Scanner(System.in);
        System.out.print("Name: ");
        this.setName(n.next());
        System.out.print("Age: ");
        this.setAge(n.next());
        System.out.print("Gender: ");
        this.setSex(n.next());
    }
}