package exceptionquiz.plugin.priority;

import exceptionquiz.api.Question;
import exceptionquiz.api.QuestionGenerator;

import java.util.List;

/**
 * Инициализирует классы плагина.
 */
public class PluginRunner implements QuestionGenerator {
    PriorityGenerator generator;

    public PluginRunner() {
        List<Operator> operators = OperatorData.getOperators();
        generator = new PriorityGenerator(operators);
    }

    @Override
    public Question randomQuestion() {
        return generator.randomQuestion();
    }
}