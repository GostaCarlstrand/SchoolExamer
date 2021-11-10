package com.company;

import java.util.Random;

public class Student implements StudentInterface{
    Input studentInput = new Input();
    private String name;
    private int age;

    private String studentIdNumber = "S";

    public Student(){
        name = nameInput();
        age = ageInput();
        generateStudentIdNumber();
    }

    @Override
    public String nameInput() {
        name = studentInput.enterName();
        return name;
    }

    public void generateStudentIdNumber() {
        Random randomNumber = new Random();
        for (int i = 0; i < 6; i++){
            studentIdNumber += randomNumber.nextInt(10);
        }
    }


    @Override
    public int ageInput() {
        age = studentInput.enterAge();
        return age;
    }

    public String getName() {
        return name;
    }

    public String getStudentIdNumber() {
        return studentIdNumber;
    }
    public int getAge() {
        return age;
    }
}
