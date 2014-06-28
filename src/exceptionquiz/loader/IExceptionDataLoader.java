package exceptionquiz.loader;

import exceptionquiz.ExceptionData;

import java.util.List;

/**
 * Читает исключения из файла.
 */
public interface IExceptionDataLoader {
    List<ExceptionData> getExceptionData();
}
