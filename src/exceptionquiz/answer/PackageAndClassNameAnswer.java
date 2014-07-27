package exceptionquiz.answer;

import exceptionquiz.Answer;

/**
 * Ответ: название пакета и класса.
 */
public class PackageAndClassNameAnswer implements Answer {
    private final Class clazz;

    public PackageAndClassNameAnswer(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public boolean isRight(String answer) {
        if (answer != null) {
            String trimmed = answer.trim();
            return clazz.getName().equals(trimmed);
        }
        return false;
    }
}