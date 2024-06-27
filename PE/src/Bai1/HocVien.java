package Bai1;

import Bai2.Validation;

import java.util.ArrayList;
import java.util.Scanner;

public class HocVien {

    static Scanner keyboard = new Scanner(System.in);
    ArrayList<Student> students = new ArrayList<>();
    public float getAverage(Student student)
    {
        return (((student.test1+student.test2)/2)+student.fe*2)/3;
    }

    public String getClassification(Student student)
    {
        float avg = getAverage(student);
        if(avg < 5) return "Failed";
        if(avg < 7) return "Average";
        if(avg < 8) return "Good";
        return "Excellent";
    }

    public void displayAll()
    {
        for (Student student:students)
        {
            System.out.println(student.toString());
            System.out.println(getAverage(student));
            System.out.println(getClassification(student));
        }
    }

    public void inputStudent() throws Validation {
        System.out.println("Enter id");
        String id = keyboard.nextLine();
        System.out.println("Enter full name");
        String name = keyboard.nextLine();
        System.out.println("Enter year of birth");
        int year = Integer.parseInt(keyboard.nextLine());
        System.out.println("Enter mark test 1");
        int test1 = Integer.parseInt(keyboard.nextLine());
        System.out.println("Enter mark test 2");
        int test2= Integer.parseInt(keyboard.nextLine());
        System.out.println("Enter pe mark");
        int pe = Integer.parseInt(keyboard.nextLine());
        students.add(new Student(id,name,year,test1,test2,pe));
    }

}
