package exceptionquiz.plugin.exception;

import exceptionquiz.api.Answer;
import exceptionquiz.api.Question;

/**
 * Абстрактный суперкласс для вопросов.
 */
abstract class AbstractQuestion implements Question {
    protected Answer rightAnswer;
    protected final Class exceptionClass;

    public AbstractQuestion(Class exceptionClass) {
        this.exceptionClass = exceptionClass;
    }

    @Override
    public Answer getRightAnswer() {
        return rightAnswer;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Question) {
            Question o = (Question) obj;
            return o.getQuestionText().equals(getQuestionText())
                    && o.getAnswerText().equals(getAnswerText())
                    && o.getPrompt().equals(getPrompt())
                    && o.getRightAnswer().equals(getRightAnswer());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return exceptionClass.hashCode();
    }
}