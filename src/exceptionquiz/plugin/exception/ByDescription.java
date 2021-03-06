package exceptionquiz.plugin.exception;

/**
 * Вопрос.
 * Известно: описание исключения.
 * Вопрос: пакет и название исключения?
 */
class ByDescription extends AbstractQuestion {
    private final String excDescription;

    public ByDescription(ExcData excData) {
        super(excData.getExceptionClass());
        rightAnswer = new PackageAndClassNameAnswer(exceptionClass);
        excDescription = excData.getExceptionDescription();
    }

    @Override
    public String getQuestionText() {
        return String.format("Which exception is used for \"%s\"?", excDescription);
    }

    @Override
    public String getAnswerText() {
        return exceptionClass.getName();
    }

    @Override
    public String getPrompt() {
        return "Package and class name:";
    }
}