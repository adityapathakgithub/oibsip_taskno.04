package lib;

import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class MCQ {
    private String question;
    private String[] options;
    private int correctAnswer;

    public MCQ(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

class Exam {
    private MCQ[] questions;
    private int durationInMinutes;

    public Exam(MCQ[] questions, int durationInMinutes) {
        this.questions = questions;
        this.durationInMinutes = durationInMinutes;
    }

    public void startExam(User user) {
        System.out.println("Welcome, " + user.getUsername() + "!");

        // Display questions and get answers
        Scanner scanner = new Scanner(System.in);
        int totalQuestions = questions.length;
        int score = 0;

        for (int i = 0; i < totalQuestions; i++) {
            MCQ mcq = questions[i];

            System.out.println("Question " + (i + 1) + ": " + mcq.getQuestion());
            String[] options = mcq.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }

            System.out.print("Select your answer (1-" + options.length + "): ");
            int selectedAnswer = scanner.nextInt();

            if (selectedAnswer == mcq.getCorrectAnswer()) {
                score++;
            }
        }

        System.out.println("Your score: " + score + "/" + totalQuestions);
    }
}

public class onlineExam {
    public static void main(String[] args) {
        // Create sample questions
        MCQ[] questions = new MCQ[3];
        questions[0] = new MCQ("What is the capital of France?", new String[] { "London", "Paris", "Rome" }, 2);
        questions[1] = new MCQ("Which planet is known as the Red Planet?", new String[] { "Mars", "Jupiter", "Venus" },
                1);
        questions[2] = new MCQ("Who painted the Mona Lisa?",
                new String[] { "Pablo Picasso", "Leonardo da Vinci", "Vincent van Gogh" }, 2);

        // Create an exam
        Exam exam = new Exam(questions, 10); // 10 minutes duration

        // Create a user
        User user = new User("john123", "password");

        // Perform login
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            System.out.println("Login successful!");
            exam.startExam(user);
        } else {
            System.out.println("Invalid credentials. Login failed!");
        }

        // Other functionalities such as update profile, change password, timer,
        // auto-submit, logout, etc. can be implemented here.
    }
}
