package exceptionquiz.plugin.exception;

import exceptionquiz.api.Question;
import exceptionquiz.api.QuestionGenerator;
import exceptionquiz.application.DuplicateBlocker;
import exceptionquiz.application.duplicate.QuestionDuplicateBlocker;
import exceptionquiz.plugin.exception.excset.Jcp1ExcSet;
import exceptionquiz.plugin.exception.question.QuestionGeneratorImpl;

/**
 * Инициализирует классы плагина "Exception".
 */
public class ExceptionPluginRunner implements QuestionGenerator {
    private final QuestionGeneratorImpl generator;

    public ExceptionPluginRunner() {
        Jcp1ExcSet excSet = Jcp1ExcSet.getInstance();
        DuplicateBlocker<Question> blocker = new QuestionDuplicateBlocker();
        this.generator = new QuestionGeneratorImpl(excSet, blocker);
    }

    @Override
    public Question randomQuestion() {
        return generator.randomQuestion();
    }
}
