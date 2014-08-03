package exceptionquiz;

/**
 * Представляет объект в виде строки.
 */
public interface Formatter<T> {
    String format(T obj);
}