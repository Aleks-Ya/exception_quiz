package exceptionquiz.plugin.priority;

import exceptionquiz.api.Answer;
import exceptionquiz.api.Question;

/**
 * Вопрос о приритетах операторов Java.
 * todo Переопределить equals, чтобы срабатывал DuplicateBlocker
 */
class PriorityQuestion implements Question {
    private final String leftFullName;
    private final String rightFullName;
    private final int leftPriority;
    private final int rightPriority;

    public PriorityQuestion(Operator operatorLeft, Operator operatorRight) {
        leftFullName = String.format("%s (%s)", operatorLeft.getSymbol(), operatorLeft.getDescription());
        rightFullName = String.format("%s (%s)", operatorRight.getSymbol(), operatorRight.getDescription());
        leftPriority = operatorLeft.getPriority();
        rightPriority = operatorRight.getPriority();
    }

    @Override
    public String getQuestionText() {
        return String.format("Which operator has more priority?%n 1 %s%n 2 %s%n 0 equal priority",
                leftFullName, rightFullName);
    }

    @Override
    public String getPrompt() {
        return "0/1/2:";
    }

    @Override
    public String getAnswerText() {
        return String.format("Operator %s has %d priority and operator %s has %d priority.", leftFullName, leftPriority,
                rightFullName, rightPriority);
    }

    @Override
    public Answer getRightAnswer() {
        if (leftPriority == rightPriority) {
            return ZeroAnswer.getInstance();
        } else if (leftPriority < rightPriority) {
            return OneAnswer.getInstance();
        } else {
            return TwoAnswer.getInstance();
        }
    }
}