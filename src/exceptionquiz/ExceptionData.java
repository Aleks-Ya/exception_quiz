package exceptionquiz;

/**
 * Информация об исключении.
 */
public class ExceptionData {
    private Class exceptionClass;
    private String description;

    public ExceptionData(Class exceptionClass, String description) {
        this.exceptionClass = exceptionClass;
        this.description = description;
    }

    public String getSimpleName() {
        return exceptionClass.getSimpleName();
    }

    public String getFullName() {
        return exceptionClass.getName();
    }

    public String getDescription() {
        return description;
    }

    public Class getSuperClass() {
        return exceptionClass.getSuperclass();
    }

    public boolean isChecked() {
        Class superClass = exceptionClass;
        do {
            if (superClass == RuntimeException.class) {
                return true;
            }
            superClass = superClass.getSuperclass();
        } while (superClass != null);
        return false;
    }

    public String getPackage() {
        return exceptionClass.getPackage().toString();
    }
}
