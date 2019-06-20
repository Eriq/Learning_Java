package com.jsonraw;

/* This java program generates a Json Raw String by:
 * Creating a student object from the Student class
 * The student object is then passed to a method that parses all the attributes and creates a Json string
 * Which is then displayed
 */

import java.util.Scanner;

//Student Class Declaration
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

    //Method that parses the Student object to form a Json String
    public String getJson() {
        //Initializing the Json characters
        String brace = "{";
        String close = "}";
        String quote = "\"";
        String colon = ":";
        String comma = ",";

        String json = brace + quote + "Name" + quote                    //Creating the Json Raw String
                + colon + quote + name + quote
                + comma
                + quote + "Age"+ quote
                + colon + quote + age + quote
                + comma
                + quote + "Sex" + quote + colon + quote + sex + quote + close;
        return json;
    }

    //Method to create and return a student object 
    public static Student readStudent() {
        Student st = new Student();
        Scanner n = new Scanner(System.in);

        System.out.print("First Name: ");
        st.setName(n.next());
        System.out.print("Age: ");
        st.setAge(n.next());
        System.out.print("Gender: ");
        st.setSex(n.next());
        System.out.println();

        return st;
    }

    public static void main(String[] args) {
        Student st1 = readStudent();
        System.out.println(st1.getJson());
    }
}
