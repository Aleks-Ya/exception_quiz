package exceptionquiz.plugin.exception;

/**
 * Информация об исключении.
 */
public interface ExcData {
    Class getExceptionClass();

    String getExceptionDescription();
}