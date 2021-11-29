package baseball;

import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashSet;

public class Answer {

    private int ANSWER_SIZE=3;
    private String[] correctAnswer;
    private String[] userAnswer;
    private int strike;
    private int ball;
    private boolean stopped;

    public Answer() {
        correctAnswer = new String[ANSWER_SIZE];
        setCorrectAnswer(correctAnswer);
        //System.out.println("correctAnswer = " + Arrays.toString(correctAnswer));
    }

    private void setCorrectAnswer(String[] correctAnswer) {
        Set<String> set = new LinkedHashSet<>();
        int random =0;
        while (set.size()<ANSWER_SIZE){
            random = (int)(Math.random()*10);
            set.add(String.valueOf(random));
        }
        set.toArray(correctAnswer);
    }

    public void setUserAnswer(Scanner scanner) {
        System.out.println("3자리 숫자를 입력하세요. (ex: 123)");
        System.out.print("> ");
        String str = scanner.nextLine();
        this.userAnswer =str.split("");
    }

    public boolean isStop(){
        return this.stopped;
    }

    public void checkAnswer() {
        resetBallAndStrike();
        compareAnswer();
        printResult();
    }

    private void resetBallAndStrike() {
        this.ball =0;
        this.strike =0;
    }

    private void compareAnswer() {
        for (int userAnswerIndex = 0; userAnswerIndex < ANSWER_SIZE; userAnswerIndex++) {
            loopCorrectAnswer(userAnswerIndex);
        }
    }

    private void loopCorrectAnswer(int userAnswerIndex) {
        for (int correctAnswerIndex = 0; correctAnswerIndex < ANSWER_SIZE; correctAnswerIndex++) {
            checkBallAndStrike(userAnswerIndex,correctAnswerIndex);
        }
    }

    private void checkBallAndStrike(int userAnswerIndex, int correctAnswerIndex) {
        if(userAnswer[userAnswerIndex].equals(correctAnswer[correctAnswerIndex])){
            ball++;
            if(userAnswerIndex==correctAnswerIndex){
                strike++;
                ball--;
            }
        }
    }

    private void printResult() {
        if(isNotting()){
            System.out.println("낫싱");
            return;
        }
        System.out.println(strike + "스트라이크  " +ball+ "볼");
        checkNumOfStrike();
    }

    private boolean isNotting() {
        if(this.strike ==0 && this.ball==0){
            return true;
        }
        return false;
    }

    private void checkNumOfStrike() {
        if(this.strike ==ANSWER_SIZE){
            this.stopped = true;
        }
    }
}
