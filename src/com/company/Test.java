package com.company;

import com.company.Question.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    QuestionSetup setupQuestions = new QuestionSetup();
    ArrayList <Question> listWithQuestions;
    private int currentPoints = 0;
    final int amountOfAlternatives = 6;

    ArrayList <String> testAnswer = new ArrayList<>();

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
            saveAnswersToFile(student,Input.answerQuestions());
        }
    }

    public void saveAnswersToFile(Student student, String answer){
        File file = new File("./student-answer/" + student.getName()+ "-Test-Answers.txt");
        try {
        FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(answer);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
