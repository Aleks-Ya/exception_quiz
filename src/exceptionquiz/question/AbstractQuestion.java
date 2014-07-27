package exceptionquiz.question;

import exceptionquiz.Answer;
import exceptionquiz.Question;

/**
 * Абстрактный суперкласс для вопросов.
 */
abstract class AbstractQuestion implements Question {
    protected Answer rightAnswer;
    protected final Class exceptionClass;

    AbstractQuestion(Class exceptionClass) {
        this.exceptionClass = exceptionClass;
    }

    @Override
    public Answer getRightAnswer() {
        return rightAnswer;
    }
}