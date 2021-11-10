package com.company.Question;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionSetup {
    String tempQuestionText = "";            //A temporary variable used to collect Question text
    String [] arrayWithQuestions;
    public static ArrayList<Question> listWithQuestionObjects = new ArrayList<>();

    public ArrayList<Question> initQuestionsObjects(String subject) {
        splitFileToQuestionArray(subject);
        createQuestionsObject();
        return listWithQuestionObjects;
    }


    private String readFile(String path, Charset encoding) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public void splitFileToQuestionArray(String subject) {
        String filePath = "./questions/"+ subject + ".txt";

        String content = null;
        try {
            content = readFile(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        arrayWithQuestions = content.split("-");
    }

    private String findCorrectAnswer(int i) {
        Scanner scanner = new Scanner(arrayWithQuestions[i]);
        String correctAnswerAsString = "";
        while (scanner.hasNextLine()){
            String alternative = scanner.nextLine();
            String findCorrectAnswerInFile = "CORRECT ";
            if (alternative.startsWith(findCorrectAnswerInFile)){
                correctAnswerAsString = alternative.replaceAll(findCorrectAnswerInFile, "");
                alternative = correctAnswerAsString;
            }
            collectQuestionText(alternative);
        }
        return correctAnswerAsString;
    }

    private void createQuestionsObject() {
        for (int i = 0; i < arrayWithQuestions.length; i++) {
            Question question = new Question();
            question.setCorrectAnswer(findCorrectAnswer(i));
            question.setQuestionText(setQuestionTextToObject());
            listWithQuestionObjects.add(question);
        }
    }

    private void collectQuestionText(String text) {
        tempQuestionText += (text+ "\n");
    }

    private String setQuestionTextToObject(){
        String text = tempQuestionText;
        tempQuestionText = ""; //Clears the class variable
        return text;
    }


}
