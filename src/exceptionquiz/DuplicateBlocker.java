package exceptionquiz;

/**
 * Блокировщик дубликатов.
 */
public interface DuplicateBlocker<T> {
    boolean isDuplicate(T obj);
}