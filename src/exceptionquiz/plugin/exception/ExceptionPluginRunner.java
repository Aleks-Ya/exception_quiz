package exceptionquiz.plugin.exception;

import exceptionquiz.api.Question;
import exceptionquiz.api.QuestionGenerator;
import exceptionquiz.plugin.exception.excset.Jcp1ExcSet;
import exceptionquiz.plugin.exception.question.QuestionGeneratorImpl;

/**
 * Инициализирует классы плагина "Exception".
 */
public class ExceptionPluginRunner implements QuestionGenerator {
    private final QuestionGeneratorImpl generator;

    public ExceptionPluginRunner() {
        Jcp1ExcSet excSet = Jcp1ExcSet.getInstance();
        this.generator = new QuestionGeneratorImpl(excSet);
    }

    @Override
    public Question randomQuestion() {
        return generator.randomQuestion();
    }
}
