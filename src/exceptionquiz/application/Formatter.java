package exceptionquiz.application;

/**
 * Представляет объект в виде строки.
 */
public interface Formatter<T> {
    String format(T obj);
}