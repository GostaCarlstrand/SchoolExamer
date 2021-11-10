package com.company;

import com.company.Question.Question;
import com.company.Question.QuestionSetup;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class Teacher {
    Student student;

    public Teacher(Student student) {
        this.student = student;
    }

    public void correctTest() throws IOException {
        try {
            ArrayList<String> studentAnswers = student.getStudentAnswers();
            File studentResult = new File("./student-result/" + student.getName() + "-Test-Result.txt");
            for (int i = 0; i <= QuestionSetup.listWithQuestionObjects.size(); i++) {
                FileWriter fileWriter = new FileWriter(studentResult);

                Question currentQuestion = QuestionSetup.listWithQuestionObjects.get(i);
                String correctAnswer = currentQuestion.getCorrectAnswer();
                String studentAnswer = studentAnswers.get(i).toUpperCase(Locale.ROOT); //In uppercase letter to easier compare
                //writeResultToFile(currentQuestion.getQuestionText(), correctAnswer, studentAnswer);
                fileWriter.write("Question: " + currentQuestion.getQuestionText() + "\n");
                fileWriter.write("Correct answer: " + correctAnswer + "\n");
                fileWriter.write("Your answer: " + studentAnswer);
                if (correctAnswer.startsWith(studentAnswer)) {
                    fileWriter.write("✓");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeResultToFile(String question, String questionAnswer, String studentAnswer) {
        try {
            File studentResult = new File("./student-result/" + student.getName() + "-Test-Result.txt");
            FileWriter fileWriter = new FileWriter(studentResult);
            fileWriter.write("Question: " + question + "\n");
            fileWriter.write("Correct answer: " + questionAnswer + "\n");
            fileWriter.write("Your answer: " + studentAnswer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public void correctTest2(String studentName, String subject) {
        try {
            BufferedReader studentAnswer = new BufferedReader(new FileReader("./student-answer/" + studentName+ "-Test-Answers.txt"));
            BufferedReader correctAnswer = new BufferedReader(new FileReader("./correct-answers/" + subject + ".txt"));

            int lineNum = 1;
            String lineStudentAnswer = studentAnswer.readLine();
            String lineCorrectAnswer = correctAnswer.readLine();

            while (lineStudentAnswer != null || lineCorrectAnswer != null)
            {
                if(lineStudentAnswer == null || lineCorrectAnswer == null)
                {
                    break;
                }
                else if(lineStudentAnswer.equalsIgnoreCase(lineCorrectAnswer))
                {
                }

                lineStudentAnswer = studentAnswer.readLine();
                lineCorrectAnswer = correctAnswer.readLine();
                lineNum++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void displayTestResult(String studentName, String subject) {
        try {
            File studentResult = new File("./student-result/" + studentName + "-Test-Result.txt");
            FileWriter fileWriter = new FileWriter(studentResult);
            BufferedReader question = new BufferedReader(new FileReader("./questions/questions-" + subject+ ".txt"));
            BufferedReader correctAnswer = new BufferedReader(new FileReader("./correct-answers/" + subject + ".txt"));
            BufferedReader studentAnswer = new BufferedReader(new FileReader("./student-answer/" + studentName+ "-Test-Answers.txt"));
            

            Integer lineNum = 1;
            String lineQuestion = question.readLine();
            String lineCorrectAnswer = correctAnswer.readLine();
            String lineStudentAnswer = studentAnswer.readLine();

            while (lineQuestion != null || lineCorrectAnswer != null)
            {
                if(lineQuestion == null || lineCorrectAnswer == null)
                {
                    break;
                }
                else if(Character.isDigit(lineQuestion.charAt(0))) {
                    fileWriter.write("Question: " + lineQuestion + "\n");
                    lineQuestion = question.readLine();
                    continue;
                }
                if (lineQuestion.charAt(0) == lineCorrectAnswer.charAt(0)){
                    fileWriter.write("Answer: " + lineQuestion + "\n");
                    if (lineStudentAnswer.charAt(0) == lineCorrectAnswer.charAt(0)){
                        fileWriter.write("Correct  ✓" + "\n");
                    } else {
                        fileWriter.write("Incorrect, your answer was " + lineStudentAnswer + "\n");
                    }
                    while (!Character.isDigit(lineQuestion.charAt(0))) {
                        lineQuestion = question.readLine();
                    }
                        lineCorrectAnswer = correctAnswer.readLine();
                        lineStudentAnswer = studentAnswer.readLine();
                }

                lineQuestion = question.readLine();

                lineNum++;
                fileWriter.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }


    }

}
