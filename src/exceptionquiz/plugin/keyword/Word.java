package exceptionquiz.plugin.keyword;

/**
 * Ключевое или не ключевое слово из Java-кода.
 */
class Word {
    private final String word;
    private final boolean isKeyWord;

    private Word(String word, boolean isKeyWord) {
        this.word = word;
        this.isKeyWord = isKeyWord;
    }

    public String getWord() {
        return word;
    }

    public boolean isKeyWord() {
        return isKeyWord;
    }

    static Word keyWord(String word) {
        return new Word(word, true);
    }

    static Word notKeyWord(String word) {
        return new Word(word, false);
    }
}