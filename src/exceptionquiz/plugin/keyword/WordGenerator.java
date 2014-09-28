package exceptionquiz.plugin.keyword;

import exceptionquiz.api.Question;
import exceptionquiz.api.QuestionGenerator;

import java.util.List;
import java.util.Random;

/**
 * Генератор вопросов о приоритетах операторов Java.
 */
class WordGenerator implements QuestionGenerator {
    private final Random random = new Random();
    private final List<Word> words;

    public WordGenerator(List<Word> words) {
        this.words = words;
    }

    public Question randomQuestion() {
        int n = random.nextInt(words.size());
        return new KeywordQuestion(words.get(n));
    }
}