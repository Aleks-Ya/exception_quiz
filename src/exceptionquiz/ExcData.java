package exceptionquiz;

/**
 * Информация об исключении.
 */
public interface ExcData {
    Class getExceptionClass();

    String getExceptionDescription();
}