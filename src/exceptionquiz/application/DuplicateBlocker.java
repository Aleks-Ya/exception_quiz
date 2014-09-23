package exceptionquiz.application;

/**
 * Блокировщик дубликатов.
 */
public interface DuplicateBlocker<T> {
    boolean isDuplicate(T obj);
}