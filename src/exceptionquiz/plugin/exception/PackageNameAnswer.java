package exceptionquiz.plugin.exception;

import exceptionquiz.api.answer.AbstractAnswer;

/**
 * Ответ: название пакета.
 */
class PackageNameAnswer extends AbstractAnswer {

    public PackageNameAnswer(Class clazz) {
        variants.add(clazz.getPackage().getName());
        ignoreCase = false;
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", getClass().getSimpleName(), variants.get(0));
    }
}