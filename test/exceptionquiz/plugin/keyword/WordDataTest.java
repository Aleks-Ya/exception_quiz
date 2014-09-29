package exceptionquiz.plugin.keyword;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;

public class WordDataTest {

    /**
     * Одинаковое слов в списке ключевых и не ключевых слов.
     */
    @Test(expected = RuntimeException.class)
    public void duplicate() throws Exception {
        Field notKeyWordsField = WordData.class.getDeclaredField("NOT_KEY_WORDS");
        notKeyWordsField.setAccessible(true);
        List<Word> notKeyWords = (List<Word>) notKeyWordsField.get(WordData.class);
        notKeyWords.add(Word.notKeyWord("int"));

        Constructor<WordData> constructor = WordData.class.getConstructor();
        constructor.setAccessible(true);

        constructor.newInstance();
    }
}