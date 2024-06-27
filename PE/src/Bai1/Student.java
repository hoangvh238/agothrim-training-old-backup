package Bai1;

import Bai2.Validation;

public class Student {
    String id;
    String fullName;
    int yearOfBirth;
    float test1;
    float test2;
    float fe;

    public Student(String id, String fullName, int yearOfBirth, float test1, float test2, float fe) throws Validation {
        if(test1 >= 0 && test1 <=10 && test2 >=0 && test2 <=10 && fe >=0 && fe <=10 )
        {
            this.id = id;
            this.fullName = fullName;
            this.yearOfBirth = yearOfBirth;
            this.test1 = test1;
            this.test2 = test2;
            this.fe = fe;
        }
        else  throw new Validation("Input wrong test mark");

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public float getTest1() {
        return test1;
    }

    public void setTest1(float test1) {
        this.test1 = test1;
    }

    public float getTest2() {
        return test2;
    }

    public void setTest2(float test2) {
        this.test2 = test2;
    }

    public float getFe() {
        return fe;
    }

    public void setFe(float fe) {
        this.fe = fe;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", test1=" + test1 +
                ", test2=" + test2 +
                ", fe=" + fe +
                '}';
    }
}
