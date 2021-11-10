package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Student implements StudentInterface{
    Input studentInput = new Input();
    private String name;
    private int age;
    private String studentIdNumber = "S";

    private ArrayList <String> studentAnswers = new ArrayList<>();

    public Student(){
        name = nameInput();     //When a student is created, name and age is required to enter
        age = ageInput();
        generateStudentIdNumber();
    }

    public ArrayList<String> getStudentAnswers() {
        return studentAnswers;
    }

    public void addToAnswerList(String answer){
        studentAnswers.add(answer);
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
