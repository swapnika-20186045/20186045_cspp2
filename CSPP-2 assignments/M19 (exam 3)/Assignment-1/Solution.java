/**
 * Quiz.
 * @author Swapnika Vakacharla.
 */
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Class for quiz.
 */
class Quiz {
    /**
     * Question declaration as string.
     */
    private String question;
    /**
     * choice declaration as String[].
     */
    private String[] choice;
    /**
     * correct variable declaration as string.
     */
    private String correct;
    /**
     * maxmarks variable declaration as string.
     */
    private String maxMarks;
    /**
     * penality variable declaration as string.
     */
    private String penality;
    /**
     * Constructs the object.
     */
    Quiz() {
        //not used.
    }
    /**
     * Constructs the object.
     *
     * @param      questionn  The questionn
     * @param      choicee    The choicee
     * @param      correctt   The correctt
     * @param      maxMarkss  The maximum markss
     * @param      penalityy  The penalityy
     */
    Quiz(final String questionn, final String[] choicee, final String correctt,
            final String maxMarkss, final String penalityy) {
        this.question = questionn;
        this.choice = choicee;
        this.correct = correctt;
        this.maxMarks = maxMarkss;
        this.penality = penalityy;
    }
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    static ArrayList<Quiz> quizes = new ArrayList<Quiz>();
    static ArrayList<Quiz> answers = new ArrayList<Quiz>();
    //private List<Quiz> quizes;
     /**
     * Constructs the object.
     */
    private Solution() {
    // quizes = new List<Quiz>();
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
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(final Scanner s, Quiz quiz,
                                        int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        try {
            while(questionCount > 0) {
                String line = s.nextLine();
                String[] tokens = line.split(":");
                String[] choices = tokens[1].split(",");
                if(tokens[0].equals("")){
                    System.out.println("Error! Malformed question");
                    return;
                }
                if(choices.length <= 1) {
                    System.out.println("question does not have enough answer choices");
                    return;
                }
                if(Integer.parseInt(tokens[3]) < 0){
                    System.out.println("Invalid max marks for question about sony");
                    return;
                }
                if(Integer.parseInt(tokens[4]) > 0){
                    System.out.println("Invalid penalty for question about sony");
                    return;
                }
                if(!tokens[2].equals("1") && !tokens[2].equals("2") &&
                    !tokens[2].equals("3") && !tokens[2].equals("4")) {
                    System.out.println("Error!Correct answer choice number is out of range");
                    return;
                }
                Quiz q = new Quiz(tokens[0],choices,tokens[2],tokens[3],tokens[4]);
                quizes.add(q);
                questionCount--;
            }
            if(quizes.size() != 0) {
                System.out.println(quizes.size() + " are added to the quiz");
            }else {
                System.out.println("Quiz does not have questions");
            }
        } catch(Exception e) {
            System.out.println("Error! Malformed question");
        }
    }
    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        // System.out.println(quiz.getquestions());
    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
    }
}
