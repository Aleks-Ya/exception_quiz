package exceptionquiz.excdata;

import exceptionquiz.ExcData;

/**
 * Данные об исключении.
 */
public class ExcDataImpl implements ExcData {
    private final String excDescription;
    private final Class excClass;

    public ExcDataImpl(Class excClass, String excDescription) {
        if (excClass == null || excDescription == null || excDescription.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.excClass = excClass;
        this.excDescription = excDescription;
    }

    @Override
    public Class getExceptionClass() {
        return excClass;
    }

    @Override
    public String getExceptionDescription() {
        return excDescription;
    }
}