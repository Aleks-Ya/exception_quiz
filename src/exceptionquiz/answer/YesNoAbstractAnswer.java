package exceptionquiz.answer;

import exceptionquiz.Answer;

import java.util.ArrayList;
import java.util.List;

/**
 * Абстрактный суперкласс для ответов Да/Нет.
 */
abstract class YesNoAbstractAnswer implements Answer {
    protected final List<String> variants = new ArrayList<>();

    @Override
    public boolean isRight(String answer) {
        if (answer != null) {
            String trimmed = answer.trim();
            for (String variant : variants) {
                if (variant.equalsIgnoreCase(trimmed)) {
                    return true;
                }
            }
        }
        return false;
    }
}