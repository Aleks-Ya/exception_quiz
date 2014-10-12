package exceptionquiz.api.duplicate;

/**
 * Блокировщик дубликатов.
 */
public interface DuplicateBlocker<T> {
    boolean isDuplicate(T obj);
}