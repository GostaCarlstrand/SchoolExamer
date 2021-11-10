package com.company;

import java.io.*;

public class Teacher {
    Test test = new Test();
    String confirmed = "✓";




    public void correctTest(String studentName, String subject) {
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
                    test.increaseCurrentPoints(1);
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
