package exceptionquiz.plugin.priority;

/**
 * Оператор Java.
 */
class Operator {
    /**
     * Обозначение оператора.
     */
    private String symbol;

    /**
     * Описание назначения оператора.
     */
    private String description;

    /**
     * Приоритет оператора (0 - минимальный).
     */
    private int priority;

    private Associativity associativity;

    public Operator(String symbol, String description, int priority, Associativity associativity) {
        this.symbol = symbol;
        this.description = description;
        this.priority = priority;
        this.associativity = associativity;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getPriority() {
        return priority;
    }

    public Associativity getAssociativity() {
        return associativity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Operator) {
            Operator o = (Operator) obj;
            return symbol.equals(o.symbol) && priority == o.priority && associativity == o.associativity;
        }
        return false;
    }

    public String getDescription() {
        return description;
    }
}
