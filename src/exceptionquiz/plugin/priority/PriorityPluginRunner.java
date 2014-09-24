package exceptionquiz.plugin.priority;

import exceptionquiz.api.Question;
import exceptionquiz.api.QuestionGenerator;

import java.util.List;

/**
 * Инициализирует классы плагина.
 */
public class PriorityPluginRunner implements QuestionGenerator {
    PriorityGenerator generator;

    public PriorityPluginRunner() {
        List<Operator> operators = OcaOperatorData.getOperators();
        generator = new PriorityGenerator(operators);
    }

    @Override
    public Question randomQuestion() {
        return generator.randomQuestion();
    }
}