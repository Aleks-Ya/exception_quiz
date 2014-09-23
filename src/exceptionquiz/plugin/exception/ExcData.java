package exceptionquiz.plugin.exception;


/**
 * Данные об исключении.
 */
public class ExcData {
    private final String excDescription;
    private final Class excClass;

    public ExcData(Class excClass, String excDescription) {
        if (excClass == null || excDescription == null || excDescription.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.excClass = excClass;
        this.excDescription = excDescription;
    }

    public Class getExceptionClass() {
        return excClass;
    }

    public String getExceptionDescription() {
        return excDescription;
    }
}