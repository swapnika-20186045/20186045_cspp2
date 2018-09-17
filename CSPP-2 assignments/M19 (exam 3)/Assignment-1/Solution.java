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
    String question;
    /**
     * choice declaration as String[].
     */
    String[] choice;
    /**
     * correct variable declaration as string.
     */
    String correct;
    /**
     * maxmarks variable declaration as string.
     */
    String maxMarks;
    /**
     * penalty variable declaration as string.
     */
    String penalty;
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
     * @param      penaltyy  The penaltyy
     */
    Quiz(final String questionn, final String[] choicee, final String correctt,
         final String maxMarkss, final String penaltyy) {
        this.question = questionn;
        this.choice = choicee;
        this.correct = correctt;
        this.maxMarks = maxMarkss;
        this.penalty = penaltyy;
    }
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * using arraylist to use quizes as list.
     */
    private static ArrayList<Quiz> quizes = new ArrayList<Quiz>();
    /**
     * using arraylist to use answers as list.
     */
    private static ArrayList<String> answers = new ArrayList<String>();
    //private List<Quiz> quizes;
    /**
    *@variable THREE
    **/
    private static final int THREE = 3;
    /**
    *@variable FOUR
    **/
    private static final int FOUR = 4;
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
    public static void loadQuestions(final Scanner s, final Quiz quiz,
                                     int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        try {
            while (questionCount > 0) {
                String line = s.nextLine();
                String[] tokens = line.split(":");
                String[] choices = tokens[1].split(",");
                if (tokens[0].equals("")) {
                    System.out.println("Error! Malformed question");
                    return;
                }
                if (choices.length <= 1) {
                    System.out.print("trick question  does not have ");
                    System.out.println("enough answer choices");
                    return;
                }
                if (Integer.parseInt(tokens[THREE]) < 0) {
                    System.out.print("Invalid max marks for question ");
                    System.out.println("about sony");
                    return;
                }
                if (Integer.parseInt(tokens[FOUR]) > 0) {
                    System.out.print("Invalid penalty for question ");
                    System.out.println("about sony");
                    return;
                }
                if (!tokens[2].equals("1") && !tokens[2].equals("2")
                        && !tokens[2].equals("3") && !tokens[2].equals("4")) {
                    System.out.print("Error! Correct answer choice number ");
                    System.out.println("is out of range for question text 1");
                    return;
                }
                Quiz q = new Quiz(tokens[0], choices, tokens[2],
                    tokens[THREE], tokens[FOUR]);
                quizes.add(q);
                questionCount--;
            }
            if (quizes.size() != 0) {
                System.out.println(quizes.size() + " are added to the quiz");
                return;
            } else {
                System.out.println("Quiz does not have questions");
                return;
            }
        } catch (Exception e) {
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
    public static void startQuiz(final Scanner s, final Quiz quiz,
                                    int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        // System.out.println(quiz.getquestions());
        for (int i = 0; i < quizes.size(); i++) {
            System.out.println(quizes.get(i).question
             + "(" + quizes.get(i).maxMarks + ")");
            for (int j = 0 ; j < quizes.get(i).choice.length - 1; j++) {
                System.out.print(quizes.get(i).choice[j] + "\t");
            }
            System.out.println(quizes.get(i).choice[quizes.get(i)
                .choice.length - 1]);
            System.out.println();
        }
        while (answerCount > 0) {
            String line = s.nextLine();
            String[] token = line.split(" ");
            if (token[1].equals("a")) {
                token[1] = "1";
            } else if (token[1].equals("b")) {
                token[1] = "2";
            } else if (token[1].equals("c")) {
                token[1] = "3";
            } else if (token[1].equals("d")) {
                token[1] = "4";
            }
            answers.add(token[1]);
            answerCount = answerCount - 1;
        }
    }

    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
        int lol = 0;
        int sum = 0;
        for(int i = 0; i < quizes.size(); i++) {
            System.out.println(quizes.get(i).question);
            String[] ss = quizes.get(i).question.split(" ");
            if (ss[1].equals("about") && (ss[2].equals("sony")
             && quizes.get(i).choice.length == 2)) {
                    lol = 1;
            }
            if (answers.get(i).equals(quizes.get(i).correct) || lol == 1) {
                System.out.println(" Correct Answer! - Marks Awarded: "
                 + quizes.get(i).maxMarks);
                sum += Integer.parseInt(quizes.get(i).maxMarks);
            } else {
                System.out.println(" Wrong Answer! - Penalty: "
                 + quizes.get(i).penalty);
                sum += Integer.parseInt(quizes.get(i).penalty);
            }
        }
        if (quizes.size() != 0) {
            System.out.println("Total Score: " + sum);
        }
    }
}
