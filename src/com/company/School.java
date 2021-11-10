package com.company;

import com.company.Question.Question;

public class School {
    Test test = new Test();
    Input input = new Input();
    Student student;
    Teacher teacher = new Teacher();
    Question question = new Question();

    final String name = "Harvard Uni";
    final int yearFounded = 1895;
    final String address = "Blackford Rd";


    public void takeATest () {
        student = new Student();
        System.out.println("Hi, what test would you like to do?: ");
        String choosenSubject = input.chooseTest();
        if (choosenSubject.equalsIgnoreCase("Swedish")) {
            test.displayQuestionToTest("swedish", student);



            //test.readTestQuestions("./questions/questions-Swedish.txt");
            //test.saveAnswersToFile(student);
        }
        teacher.correctTest(student.getName(), choosenSubject);
        teacher.displayTestResult(student.getName(), choosenSubject);

    }


}
