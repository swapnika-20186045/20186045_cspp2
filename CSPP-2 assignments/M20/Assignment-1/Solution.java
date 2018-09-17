import java.util.Scanner;
/**
 * Class for question.
 */
class Question {
    /**
     * { var_description }.
     */
    private String questiontext;
    /**
     * { var_description }.
     */
    private String[] choices;
    /**
     * { var_description }.
     */
    private int correctAnswer;
    /**
     * { var_description }.
     */
    private int maxMarks;
    /**
     * { var_description }.
     */
    private int penalty;
    /**
     * { var_description }.
     */
    private String response;
    /**
     * Constructs the object.
     */
    Question() {

    }
    /**
     * Constructs the object.
     *
     * @param      questionn       The question 1
     * @param      choicess        The choices 1
     * @param      correctAnswerr  The correct answer 1
     * @param      maxMarkss       The maximum marks 1
     * @param      penaltyy        The penalty 1
     */
    Question(final String questionn, final String[] choicess,
        final int correctAnswerr, final int maxMarkss, final int penaltyy) {
        this.questiontext = questionn;
        this.choices = choicess;
        this.correctAnswer = correctAnswerr;
        this.maxMarks = maxMarkss;
        this.penalty = penaltyy;
    }
    /**
     * { function_description }.
     *
     * @param      choice  The choice
     *
     * @return     { description_of_the_return_value }
     */
    public boolean evaluateResponse(final String choice) {
        return false;
    }
    /**
     * Gets the correct answer.
     *
     * @return     The correct answer.
     */
    public int getCorrectAnswer() {
        return correctAnswer;
    }
    /**
     * Gets the question text.
     *
     * @return     The question text.
     */
    public String getQuestionText() {
        return this.questiontext;
    }
    /**
     * Gets the choice.
     *
     * @return     The choice.
     */
    public String[] getChoice() {
        return choices;
    }
    /**
     * Gets the maximum marks.
     *
     * @return     The maximum marks.
     */
    public int getMaxMarks() {
        return this.maxMarks;
    }
    /**
     * Gets the penalty.
     *
     * @return     The penalty.
     */
    public int getPenalty() {
        return this.penalty;
    }
    /**
     * Sets the response.
     *
     * @param      answer  The answer
     */
    public void setResponse(final String answer) {
        this.response = answer;
    }
    /**
     * Gets the response.
     *
     * @return     The response.
     */
    public String getResponse() {
        return this.response;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        return s;
    }
}
/**
 * Class for quiz.
 */
class Quiz {
    /**
     * { var_description }.
     */
    private final int onehundred = 100;
    /**
     * { var_description }.
     */
    private Question[] questions;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Quiz() {
        questions = new Question[onehundred];
        size = 0;
    }
    /**
     * Adds a question.
     *
     * @param      q     The question
     */
    public void addQuestion(final Question q) {
        questions[size] = q;
        size += 1;
    }
    /**
     * Gets the size.
     *
     * @return     The size.
     */
    public int getSize() {
        return size;
    }
    /**
     * Gets the question.
     *
     * @param      index  The index
     *
     * @return     The question.
     */
    public Question getQuestion(final int index) {
        return questions[index];
    }
    /**
     * Shows the report.
     *
     * @return     { description_of_the_return_value }
     */
    public String showReport() {
        String s = "";
        return s;
    }
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
     /**
     * Constructs the object.
     */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
         // instantiate this Quiz
        Quiz q = new Quiz();
         // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
             // split the line using space
            String[] tokens = line.split(" ");
              // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
                default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      scan       The scan
     * @param      quiz       The quiz
     * @param      q          The question count
     *
     */
    public static void loadQuestions(final Scanner scan,
        final Quiz quiz, final int q) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        int count = q;
        if (q == 0) {
            System.out.println("Quiz does not have questions");
            return;
        } else {
            while (count > 0) {
                String line = scan.nextLine();
                String[] tokens = line.split(":");
                String[] choice = tokens[1].split(",");
                if (tokens.length != 5) {
                    System.out.println("Error! Malformed question");
                    return;
                }
                if (tokens[0].equals("")) {
                    System.out.println("Error! Malformed question");
                    return;
                }
                if (choice.length <= 1) {
                    System.out.print("trick question  does not have ");
                    System.out.println("enough answer choices");
                    return;
                }
                if (Integer.parseInt(tokens[3]) < 0) {
                    System.out.print("Invalid max marks for question ");
                    System.out.println("about sony");
                    return;
                }
                if (Integer.parseInt(tokens[4]) > 0) {
                    System.out.print("Invalid penalty for question ");
                    System.out.println("about sony");
                    return;
                }
                if (Integer.parseInt(tokens[2]) < 1 || Integer.parseInt(tokens[2]) > 4) {
                    System.out.print("Error! Correct answer choice number is ");
                    System.out.println("out of range for question text 1");
                    return;
                }
                Question question = new Question( tokens[0], choice, Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
                quiz.addQuestion(question);
                count--;
            }
            System.out.println(q + " are added to the quiz");
        }
    }
    /**
     * Starts a quiz.
     *
     * @param      scan  The scan
     * @param      quiz  The quiz
     * @param      q     The answer count
     */
    public static void startQuiz(final Scanner scan,
        final Quiz quiz, final int q) {
        // write your code here to display the quiz questions on the console.
        // read the user responses from the console using scanner object.
        // store the user respone in the question object
        int count = 0;
        while (count < q) {
            String line = scan.nextLine();
            String[] token = line.split(" ");
            Question question = quiz.getQuestion(count);
            question.setResponse(token[1]);
            System.out.println(question.getQuestionText() + "(" + question.getMaxMarks() + ")");
            for (int i = 0; i < question.getChoice().length - 1; i++) {
                System.out.print(question.getChoice()[i] + "\t");
            }
            System.out.println(question.getChoice()[question.getChoice().length - 1]);
            System.out.println();
            count++;
        }
    }
    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report using quiz object.
        int sum = 0;
        int quizsize = quiz.getSize();
        for (int i = 0; i < quizsize; i++) {
            Question question = quiz.getQuestion(i);
            System.out.println(question.getQuestionText());
            String[] ss = question.getChoice()[question.getCorrectAnswer() - 1].split(" ");
            if (ss[1].equals(question.getResponse())) {
                sum += question.getMaxMarks();
                System.out.println(" Correct Answer! - Marks Awarded: " + question.getMaxMarks());
            } else {
                sum += question.getPenalty();
                System.out.println(" Wrong Answer! - Penalty: " + question.getPenalty());
            }
        }
        if (quizsize != 0) {
            System.out.println("Total Score: " + sum);
        }
    }
}
