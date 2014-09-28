package exceptionquiz.plugin.keyword;

import exceptionquiz.api.Answer;
import exceptionquiz.api.Question;
import exceptionquiz.api.answer.NoAnswer;
import exceptionquiz.api.answer.YesAnswer;

/**
 * Вопрос "Ключевые слова Java".
 */
class KeywordQuestion implements Question {
    private final String word;
    private final boolean isKeyword;

    public KeywordQuestion(Word word) {
        this.word = word.getWord();
        this.isKeyword = word.isKeyWord();
    }

    @Override
    public String getQuestionText() {
        return String.format("Is \"%s\" a Java key word?", word);
    }

    @Override
    public String getPrompt() {
        return "y/n:";
    }

    @Override
    public String getAnswerText() {
        return isKeyword ?
                String.format("\"%s\" is Java key word.", word) :
                String.format("\"%s\" is NOT Java key word.", word);
    }

    @Override
    public Answer getRightAnswer() {
        return isKeyword ? YesAnswer.getInstance() : NoAnswer.getInstance();
    }
}
