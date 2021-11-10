package com.company;

import com.company.Question.Question;

import java.io.IOException;

public class School {
    Test test;
    Input input = new Input();
    Student student;
    Teacher teacher;

    final String name = "Harvard Uni";
    final int yearFounded = 1895;
    final String address = "Blackford Rd";


    public void takeATest () throws IOException {
        student = new Student();
        teacher = new Teacher(student);
        test = new Test(student);
        System.out.println("Hi, what test would you like to do?: ");
        String chosenSubject = input.chooseTest();
        if (chosenSubject.equalsIgnoreCase("Swedish")) {
            test.displayQuestionToTest("swedish", student);
            teacher.correctTest();




            //test.saveAnswersToFile(student);
        }

    }


}
