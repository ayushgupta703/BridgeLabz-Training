package scenario_based;

import java.util.HashMap;
import java.util.Stack;

public class ExamProctor {

    private Stack<Integer> navigationStack;
    private HashMap<Integer, String> answers;
    private HashMap<Integer, String> correctAnswers;

    public ExamProctor() {
        navigationStack = new Stack<>();
        answers = new HashMap<>();
        correctAnswers = new HashMap<>();

        correctAnswers.put(1, "A");
        correctAnswers.put(2, "B");
        correctAnswers.put(3, "C");
    }

    public void visitQuestion(int questionId) {
        navigationStack.push(questionId);
    }

    public void answerQuestion(int questionId, String answer) {
        answers.put(questionId, answer);
    }

    public void goBack() {
        if (!navigationStack.isEmpty()) {
            navigationStack.pop();
        }
    }

    public int evaluateScore() {
        int score = 0;
        for (int qId : answers.keySet()) {
            if (answers.get(qId).equals(correctAnswers.get(qId))) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        ExamProctor exam = new ExamProctor();
        exam.visitQuestion(1);
        exam.answerQuestion(1, "A");
        exam.visitQuestion(2);
        exam.answerQuestion(2, "B");
        exam.visitQuestion(3);
        exam.answerQuestion(3, "D");
        exam.goBack();
        System.out.println("Final Score: " + exam.evaluateScore());
    }
}
