package exceptionquiz.answer;

/**
 * Ответ: название пакета и класса.
 */
public class PackageAndClassNameAnswer extends AbstractAnswer {

    public PackageAndClassNameAnswer(Class clazz) {
        variants.add(clazz.getName());
        ignoreCase = false;
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", getClass().getSimpleName(), variants.get(0));
    }
}