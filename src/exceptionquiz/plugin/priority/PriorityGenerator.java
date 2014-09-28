package exceptionquiz.plugin.priority;

import exceptionquiz.api.Question;
import exceptionquiz.api.QuestionGenerator;

import java.util.List;
import java.util.Random;

/**
 * Генератор вопросов о приоритетах операторов Java.
 */
class PriorityGenerator implements QuestionGenerator {
    private final Random random = new Random();
    private final List<Operator> operators;

    public PriorityGenerator(List<Operator> operators) {
        this.operators = operators;
    }

    public Question randomQuestion() {
        if (getRandomIsPriority()) {
            Operator operatorLeft = getRandomOperator();
            Operator operatorRight = getRandomOperator(operatorLeft);
            return new PriorityQuestion(operatorLeft, operatorRight);
        } else {
            return new AssociativityQuestion(getRandomOperator());
        }
    }

    private Operator getRandomOperator() {
        int n = random.nextInt(operators.size());
        return operators.get(n);
    }

    /**
     * Генерирует без дубликатов.
     */
    private Operator getRandomOperator(Operator duplicate) {
        Operator operator;
        do {
            operator = getRandomOperator();
        } while (operator.equals(duplicate));
        return operator;
    }

    /**
     * Генерирует случайный тип вопроса (на приоритет операторов или ассоциативность).
     * Вероятность 10 к 1.
     *
     * @return true - вопрос на приортиет, false - на ассоциативность.
     */
    private boolean getRandomIsPriority() {
        return random.nextInt(10) != 0;
    }
}