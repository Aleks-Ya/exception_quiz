package exceptionquiz.answer;

import exceptionquiz.Answer;

import java.util.ArrayList;
import java.util.List;

/**
 * Абстрактный суперкласс для ответов.
 */
abstract class AbstractAnswer implements Answer {
    protected final List<String> variants = new ArrayList<>();
    protected boolean ignoreCase = true;

    @Override
    public boolean isRight(String answer) {
        if (answer != null) {
            String trimmed = answer.trim();
            for (String variant : variants) {
                if (ignoreCase) {
                    if (variant.equalsIgnoreCase(trimmed)) {
                        return true;
                    }
                } else {
                    if (variant.equals(trimmed)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AbstractAnswer) {
            AbstractAnswer o = (AbstractAnswer) obj;
            if ((ignoreCase == o.ignoreCase)
                    && variants.size() == o.variants.size()
                    && o.variants.containsAll(variants)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return variants.hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}