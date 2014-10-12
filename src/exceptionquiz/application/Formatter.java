package exceptionquiz.application;

/**
 * Представляет объект в виде строки.
 */
interface Formatter<T> {
    String format(T obj);
}