package exceptionquiz.answer;

/**
 * Ответ: название пакета и класса.
 */
public class PackageAndClassNameAnswer extends NameAbstractAnswer {

    public PackageAndClassNameAnswer(Class clazz) {
        rightAnswer = clazz.getName();
    }
}