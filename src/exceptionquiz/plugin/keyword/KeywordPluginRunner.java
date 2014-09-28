package exceptionquiz.plugin.keyword;

import exceptionquiz.api.Question;
import exceptionquiz.api.QuestionGenerator;

/**
 * Запуск плагина "Ключевые слова Java".
 */
public class KeywordPluginRunner implements QuestionGenerator {
    private static final QuestionGenerator GENERATOR = new WordGenerator(WordData.getWords());

    @Override
    public Question randomQuestion() {
        return GENERATOR.randomQuestion();
    }
}