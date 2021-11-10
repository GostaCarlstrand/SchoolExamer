package com.company;

import com.company.Question.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    Student student;
    QuestionSetup setupQuestions = new QuestionSetup();
    ArrayList <Question> listWithQuestions;
    private int currentPoints = 0;
    ArrayList <String> testAnswer = new ArrayList<>();

    public Test(Student student){
        this.student = student;
    }

    private ArrayList<Question> collectListWithQuestions(String subject) {
        listWithQuestions = new ArrayList<>
                (setupQuestions.initQuestionsObjects(subject));
        // Init all question for the subject and returns an arraylist with question as object
        return listWithQuestions;
    }


    public int getCurrentPoints() {
        return currentPoints;
    }
    public void increaseCurrentPoints(int points) {
        this.currentPoints += points;
    }

    public void displayQuestionToTest(String subject, Student student){
        for (Question question:collectListWithQuestions(subject)) {
            System.out.println(question.getQuestionText());
            student.addToAnswerList(Input.answerQuestions());
            //saveAnswersToFile(student,Input.answerQuestions());
        }
        saveAnswersToFile(student, student.getStudentAnswers());
    }


    public void saveAnswersToFile(Student student, ArrayList <String> answers){
        File file = new File("./student-answer/" + student.getName()+ "-Test-Answers.txt");
        try {
        FileWriter fileWriter = new FileWriter(file);
            for (String answer:answers){
                fileWriter.write(answer);
                fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
