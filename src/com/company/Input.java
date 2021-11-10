package com.company;

import java.util.Scanner;

public class Input {
    Scanner input = new Scanner(System.in);
    Subject subject = new Subject();

    public String enterName() {
        System.out.print("Enter student name: ");
        return input.nextLine();
    }

    public int enterAge() {
        System.out.print("Enter student age: ");
        return input.nextInt();
    }


    public String chooseTest() {
        for (String test : subject.tests) {
            System.out.println("- " + test);
        }
        return input.nextLine();
    }

    public static String answerQuestions() {
        String answer;
        while(true){
            System.out.println("Input answer: ");
            Scanner inputQuestion = new Scanner(System.in);
            answer = inputQuestion.nextLine();
            if (checkValidAnswer(answer)) {
                break;
            } else {
                System.out.println("ERROR: Answer must be A, B, C, D or E");
            }
        }
        return answer;
    }

    public static boolean checkValidAnswer(String studentAnswer) {
        String[] validAnswer = {"A", "B", "C", "D", "E"}; //Accepted answers
        for (String answer:validAnswer) {
            if (answer.equalsIgnoreCase(studentAnswer)) {
                return true;
            }
        }
        return false;
    }


}
