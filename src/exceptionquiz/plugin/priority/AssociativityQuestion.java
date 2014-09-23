package exceptionquiz.plugin.priority;

import exceptionquiz.api.Answer;
import exceptionquiz.api.Question;

/**
 * Вопрос об ассоциативности оператора Java.
 */
class AssociativityQuestion implements Question {
    private final Operator operator;

    public AssociativityQuestion(Operator operator) {
        this.operator = operator;
    }

    @Override
    public String getQuestionText() {
        return String.format("Which associativity has %s (%s)?", operator.getSymbol(), operator.getDescription());
    }

    @Override
    public String getPrompt() {
        return "L/R:";
    }

    @Override
    public String getAnswerText() {
        return String.format("The operator has %s associativity.", operator.getAssociativity());
    }

    @Override
    public Answer getRightAnswer() {
        return operator.getAssociativity() == Associativity.RIGHT ?
                RightAssociativityAnswer.getInstance() : LeftAssociativityAnswer.getInstance();
    }
}