package com.studentclass;

/* This class:
 * Creates 3 student objects,
 * Each object is then passed to a method that parses all the attributes and creates a Json string
 * The Json String is then displayed
 */

public class JsonStudent {

    public static String getJson(Student student) {
        String brace = "{";
        String close = "}";
        String quote = "\"";
        String colon = ":";
        String comma = ",";

        String json = brace + quote + "Name" + quote
                + colon + quote + student.getName() + quote
                + comma
                + quote + "Age"+ quote
                + colon + quote + student.getAge() + quote
                + comma
                + quote + "Sex" + quote + colon + quote + student.getSex() + quote + close;
        return json;
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        System.out.println(getJson(s1));
        System.out.println(getJson(s2));
        System.out.println(getJson(s3));
    }
}
