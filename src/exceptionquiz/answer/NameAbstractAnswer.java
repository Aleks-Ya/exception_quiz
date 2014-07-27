package exceptionquiz.answer;

import exceptionquiz.Answer;

/**
 * Абстрактный суперкласс для ответов с именем класса или пакета.
 */
abstract class NameAbstractAnswer implements Answer {
    protected String rightAnswer;

    @Override
    public boolean isRight(String answer) {
        if (answer != null) {
            String trimmed = answer.trim();
            return rightAnswer.equals(trimmed);
        }
        return false;
    }
}