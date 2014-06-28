package exceptionquiz.loader;

import exceptionquiz.ExceptionData;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Берет информацию об исключениях из хардкода.
 */
@Component
public class HardCodeLoader implements IExceptionDataLoader {
    @Override
    public List<ExceptionData> getExceptionData() {
        List<ExceptionData> result = new ArrayList<ExceptionData>();
        result.add(new ExceptionData(FileNotFoundException.class, "Файл не найден на диске"));
        return null;
    }
}