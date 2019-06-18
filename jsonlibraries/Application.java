package com.jsonlibraries;

/* This application using Gson and Simple Json Libraries does the following:
 * Create:
 * Allows creation of student objects from the Student Class
 * It temporarily stores those students in a List

 * Store:
 * The list is then converted to a json string
 * The json string is then stored in a students.json file

 * Retrieve:
 * The student.json file is read and parsed and the objects stored in a Json Array
 * The json objects are then each instantiated to a student object
 * The student objects are then stored in the List

 * Edit:
 * The students are <Retrieve>
 * The student object to be edited is searched in the list by its reg No
 * Its details are then obtained and used to create a new object with the necessary changes
 * The new object is then placed in the list in the position of the old object
 * The list is then <Storage>

 * Delete:
 * The students are <Retrieve>
 * The object is searched from the list using its reg NO
 * It is then removed from the list
 * The list is then <Storage>
*/


import com.google.gson.Gson;                    //Converts the list to a JSON String
import org.json.simple.JSONArray;               //Stores JSON Objects into an array
import org.json.simple.JSONObject;              //Does Object parsing
import org.json.simple.parser.JSONParser;       //Parses a json file to obtain objects
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Application{
    public static int students = 0;             //keeps count of number of students created
    public static List<Student> listOfStudents; //List that stores all created students

    //class student declaration
    public static class Student {
        public String regno;        //Auto incremented unique Registration number
        public String fname;        //Student First Name
        public String lname;        //Student Last Name
        public String age;          //Student Age
        public String gender;       //Student Gender

        //Creates Student instances by asking user to input details one at a time.
        public Student() {
            Scanner n = new Scanner(System.in);
            System.out.println("\nRegistration Details");
            regno = Integer.toString(students + 1);
            System.out.print("First Name:\t");
            fname = n.next();
            System.out.print("Last Name:\t");
            lname = n.next();
            System.out.print("Age:\t");
            age = n.next();
            System.out.print("Gender:\t");
            gender = n.next();
            System.out.println();
            students += 1;
        }

        //Creates students when the details are already available
        public Student (String regno, String fname, String lname, String age, String gender) {
            this.regno = regno;
            this.fname = fname;
            this.lname = lname;
            this.age = age;
            this.gender = gender;
        }
    }

    //Save the list of students to a json file
    public static void saveStudents(List<Student> listOfStudents) {

        String json = new Gson().toJson(listOfStudents);    //convert the list of students to a json string

        try {
            BufferedWriter br =new BufferedWriter(new FileWriter("students.json", false)); //Writes the json string to a file
            br.write(json);
            br.close();
            System.out.println("\nSaved to File Successfully!");
        } catch(IOException e) {
            System.out.println("error submitted" + e);
        }
    }

    //Create a student and returns the created student when invoked
    public static Student createStudent () {
        Student s = new Student();
        return s;
    }

    //Read the json file containing students and store them in the list of students
    public static List<Student> readStudents() {
        listOfStudents = new ArrayList<Student>();      //Initializes the list to store students

        //Check whether the file exists and whether it is empty
        File file = new File("students.json");
        if (file.length()==0) {
            return listOfStudents;          //If the file is empty the methods terminates by returning the initialized list of students
        }

        //If the file is not empty it proceeds to get Student objects from the file and adds them to the list of students
        Reader read = null;
        try {
            read = new FileReader("students.json");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        JSONParser parser = new JSONParser();

        JSONArray jsonArray = null;         //Initialize a json Array to store the student objects read from the file
        try {
            jsonArray = (JSONArray) parser.parse(read);     //Populate the Array by reading the file
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        for (Object jsonObject : jsonArray) {                               //Fetch student details from the array one at a time
            JSONObject student = (JSONObject) jsonObject;
            String regno = (String) student.get("regno");
            String fname = (String) student.get("fname");
            String sname = (String) student.get("lname");
            String age = (String) student.get("age");
            String gender = (String) student.get("gender");

            Student s = new Student(regno, fname, sname, age, gender);     //Create a student object from the read details
            listOfStudents.add(s);                                         //Add the student object to the List of students
        }

        Student e = listOfStudents.get(listOfStudents.size() - 1);          //Get the last student in the list
        students = Integer.parseInt(e.regno);                               //Set the reg number of the last student as the total number of students created

        return listOfStudents;                                              //return the list containing the read students from the file
    }

    //Display the students stored in the list of students
    public static void displayStudents(List<Student> listOfStudents){
        for (Student s : listOfStudents ){
            System.out.println("\nReg No:\t"+s.regno+"\nF Name:\t"+s.fname+"\nS Name:\t"+s.lname+"\nAge:\t"+s.age+"\nGender:\t"+s.gender);
        }
    }

    //Search a given reg no and return its index position
    public static int searchStudents(List<Student> listOfStudents, String regno) {
        for (Student s : listOfStudents) {
            if (s.regno.contentEquals(regno)) {
                return listOfStudents.indexOf(s);
            }
        }
        return Integer.MAX_VALUE;
    }

    //Search and display the student details using a given reg no
    public static void searchReg(List<Student> listOfStudents, String regno) {
        int found = searchStudents(listOfStudents,regno);
        if (found == Integer.MAX_VALUE) {
            System.out.println("Does Not Exist");
            return;
        }

        Student f = listOfStudents.get(found);
        System.out.println("\nReg No:\t"+f.regno+"\nF Name:\t"+f.fname+"\nS Name:\t"+f.lname+"\nAge:\t"+f.age+"\nGender:\t"+f.gender);
    }

    //Delete the student at the given index
    public static void deleteStudent(List<Student> listOfStudents, int index) {
        if (index == Integer.MAX_VALUE) {
            System.out.println("Student Does Not Exist");
            return;
        }
        listOfStudents.remove(index);
        System.out.println("Deleted Successfully!");
        saveStudents(listOfStudents);
    }

    //Edit Details of student at given index
    public static void editStudent(List<Student> listOfStudents, int index) {
        if (index == Integer.MAX_VALUE) {
            System.out.println("Student Does Not Exist");
            return;
        }
        Scanner n = new Scanner(System.in);
        Student s = listOfStudents.get(index);

        System.out.println("\nEnter New Details:");
        System.out.print("First Name:\t");
        String fname = n.next();
        System.out.print("Last Name:\t");
        String lname = n.next();
        System.out.print("Age:\t");
        String age = n.next();
        System.out.print("Gender:\t");
        String gender = n.next();

        Student edit = new Student(s.regno,fname,lname,age,gender);
        listOfStudents.set(index,edit);
        System.out.println("Edited Successfully");
        saveStudents(listOfStudents);
    }


    //Menu to add new student or to save the already added students
    public static void menu(){
        System.out.println("1) Add New\n2) Save\n");
        System.out.print("Selection:\t");

        Scanner s = new Scanner(System.in);
        switch (s.nextInt())
        {
            case 1:
                listOfStudents.add(createStudent());
                menu();
                break;

            case 2:
                saveStudents(listOfStudents);
                promptEnterKey();
                mainMenu();
                break;

            default:
                System.err.println ( "Unrecognized option" );
                break;
        }
    }

    public static  void promptEnterKey(){
        System.out.print("\nPress \"ENTER\" to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /* Main menu that allows:
     * Addition of new students to existing records
     * Displaying the students that are in the existing records
     * Search students
     * Edit Students
     * Delete Students
     */
    public static void mainMenu() {
        System.out.println("\n1) Add student\n2) Display Students\n3) Search Student\n4) Edit Student\n5) Delete Student\n6) Exit");
        System.out.print("Selection:\t");
        Scanner s = new Scanner(System.in);
        switch (s.nextInt())
        {
            case 1:
                readStudents();
                listOfStudents.add(createStudent());
                menu();
                break;

            case 2:
                displayStudents(readStudents());
                promptEnterKey();
                mainMenu();
                break;

            case 3:
                System.out.println("Enter Reg No to search:\t");
                searchReg(readStudents(),s.next());
                promptEnterKey();
                mainMenu();
                break;

            case 4:
                readStudents();
                System.out.print("Enter Reg No to edit:\t");
                editStudent(listOfStudents,searchStudents(listOfStudents,s.next()));
                promptEnterKey();
                mainMenu();
                break;

            case 5:
                readStudents();
                System.out.print("Enter Reg No to Delete:\t");
                deleteStudent(listOfStudents,searchStudents(listOfStudents,s.next()));
                promptEnterKey();
                mainMenu();
                break;

            case 6:
                System.exit(0);
                break;

            default:
                System.err.println ( "Unrecognized option" );
                break;
        }
    }

    public static void main(String []args){
        mainMenu();
    }
}
