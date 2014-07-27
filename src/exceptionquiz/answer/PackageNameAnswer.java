package exceptionquiz.answer;

import exceptionquiz.Answer;

/**
 * Ответ: название пакета.
 */
public class PackageNameAnswer implements Answer {
    private final String rightAnswer;

    public PackageNameAnswer(Class clazz) {
        rightAnswer = clazz.getPackage().getName();
    }

    @Override
    public boolean isRight(String answer) {
        if (answer != null) {
            String trimmed = answer.trim();
            return rightAnswer.equals(trimmed);
        }
        return false;
    }
}