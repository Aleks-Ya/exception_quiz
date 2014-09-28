package exceptionquiz.plugin.keyword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static exceptionquiz.plugin.keyword.Word.keyWord;
import static exceptionquiz.plugin.keyword.Word.notKeyWord;

/**
 * Хранит набор ключевых слов Java и не ключевых (для запутывания).
 */
class WordData {
    /**
     * Ключевые слова Java.
     * Источник: Java Language Specification (http://docs.oracle.com/javase/specs/jls/se7/html/jls-3.html#jls-3.9)
     */
    private static final List<Word> KEY_WORDS = Arrays.asList(
            keyWord("abstract"), keyWord("continue"), keyWord("for"),
            keyWord("new"), keyWord("switch"), keyWord("assert"),
            keyWord("default"), keyWord("if"), keyWord("package"),
            keyWord("synchronized"), keyWord("boolean"), keyWord("do"),
            keyWord("goto"), keyWord("private"), keyWord("this"),
            keyWord("break"), keyWord("double"), keyWord("implements"),
            keyWord("protected"), keyWord("throw"), keyWord("byte"),
            keyWord("else"), keyWord("import"), keyWord("public"),
            keyWord("throws"), keyWord("case"), keyWord("enum"),
            keyWord("instanceof"), keyWord("catch"), keyWord("return"),
            keyWord("transient"), keyWord("extends"), keyWord("int"),
            keyWord("short"), keyWord("try"), keyWord("char"),
            keyWord("final"), keyWord("interface"), keyWord("static"),
            keyWord("void"), keyWord("class"), keyWord("finally"),
            keyWord("long"), keyWord("strictfp"), keyWord("volatile"),
            keyWord("const"), keyWord("float"), keyWord("native"),
            keyWord("super"), keyWord("while")
    );

    private static final List<Word> NOT_KEY_WORDS = Arrays.asList(
            notKeyWord("String"),
            notKeyWord("main"),
            notKeyWord("instanceOf"),
            notKeyWord("extend"),
            notKeyWord("Byte"),
            notKeyWord("Char"),
            notKeyWord("Character"),
            notKeyWord("Short"),
            notKeyWord("Long"),
            notKeyWord("Int"),
            notKeyWord("Integer"),
            notKeyWord("Float"),
            notKeyWord("Double"),
            notKeyWord("Enum"),
            notKeyWord("implement")
    );
    private static final List<Word> ALL_WORDS = new ArrayList<>();

    static {
        ALL_WORDS.addAll(KEY_WORDS);
        ALL_WORDS.addAll(NOT_KEY_WORDS);
    }

    private WordData() {
    }

    static List<Word> getWords() {
        return ALL_WORDS;
    }
}