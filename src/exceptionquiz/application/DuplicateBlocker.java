package exceptionquiz.application;

/**
 * Блокировщик дубликатов.
 */
interface DuplicateBlocker<T> {
    boolean isDuplicate(T obj);
}