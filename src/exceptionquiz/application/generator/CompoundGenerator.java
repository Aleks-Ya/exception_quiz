package exceptionquiz.application.generator;

import exceptionquiz.api.Question;
import exceptionquiz.api.QuestionGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Генератор вопросов на основе нескольких других генераторах.
 */
public class CompoundGenerator implements QuestionGenerator {
    private final List<QuestionGenerator> generators = new ArrayList<>();
    private final Random random = new Random();

    public CompoundGenerator(QuestionGenerator... generators) {
        if (generators == null || generators.length == 0) {
            throw new IllegalArgumentException("No generators.");
        }
        Collections.addAll(this.generators, generators);
    }

    @Override
    public Question randomQuestion() {
        return getRandomGenerator().randomQuestion();
    }

    private QuestionGenerator getRandomGenerator() {
        int n = random.nextInt(generators.size());
        return generators.get(n);
    }
}
