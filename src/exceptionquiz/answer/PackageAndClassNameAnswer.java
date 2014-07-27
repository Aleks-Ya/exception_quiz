package exceptionquiz.answer;

/**
 * Ответ: название пакета и класса.
 */
public class PackageAndClassNameAnswer extends AbstractAnswer {

    public PackageAndClassNameAnswer(Class clazz) {
        variants.add(clazz.getName());
        ignoreCase = false;
    }
}