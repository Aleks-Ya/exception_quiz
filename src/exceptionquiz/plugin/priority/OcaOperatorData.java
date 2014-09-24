package exceptionquiz.plugin.priority;

import java.util.ArrayList;
import java.util.List;

import static exceptionquiz.plugin.priority.Associativity.LEFT;
import static exceptionquiz.plugin.priority.Associativity.RIGHT;

/**
 * Набор операторов Java, встречающихся в экзамене OCA.
 */
class OcaOperatorData {
    private static final List<Operator> OPERATORS = new ArrayList<>();

    static {
        OPERATORS.add(new Operator("[]", "array index", 1, LEFT));
        OPERATORS.add(new Operator("()", "method call", 1, LEFT));
        OPERATORS.add(new Operator(".", "member access", 1, LEFT));

        OPERATORS.add(new Operator("++", "pre- or postfix increment", 2, RIGHT));
        OPERATORS.add(new Operator("--", "pre- or postfix decrement", 2, RIGHT));
        OPERATORS.add(new Operator("+", "unary plus", 2, RIGHT));
        OPERATORS.add(new Operator("-", "unary minus", 2, RIGHT));
        OPERATORS.add(new Operator("!", "boolean (logical) NOT", 2, RIGHT));
        OPERATORS.add(new Operator("(type)", "type cast", 2, RIGHT));
        OPERATORS.add(new Operator("new", "object creation", 2, RIGHT));

        OPERATORS.add(new Operator("*", "multiplication", 3, LEFT));
        OPERATORS.add(new Operator("/", "division", 3, LEFT));
        OPERATORS.add(new Operator("%", "remainder", 3, LEFT));

        OPERATORS.add(new Operator("+", "addition", 4, LEFT));
        OPERATORS.add(new Operator("-", "subtraction", 4, LEFT));
        OPERATORS.add(new Operator("+", "string concatenation", 4, LEFT));

        OPERATORS.add(new Operator("<", "less than", 6, LEFT));
        OPERATORS.add(new Operator("<=", "less than or equal to", 6, LEFT));
        OPERATORS.add(new Operator(">", "greater than", 6, LEFT));
        OPERATORS.add(new Operator(">=", "greater than or equal to", 6, LEFT));
        OPERATORS.add(new Operator("instanceof", "reference test", 6, LEFT));


        OPERATORS.add(new Operator("==", "equal to", 7, LEFT));
        OPERATORS.add(new Operator("!=", "not equal to", 7, LEFT));

        OPERATORS.add(new Operator("&", "boolean (logical) AND", 8, LEFT));

        OPERATORS.add(new Operator("|", "boolean (logical) OR", 10, LEFT));

        OPERATORS.add(new Operator("&&", "boolean (logical) AND", 11, LEFT));

        OPERATORS.add(new Operator("||", "boolean (logical) OR", 12, LEFT));

        OPERATORS.add(new Operator("=", "assignment", 14, RIGHT));
        OPERATORS.add(new Operator("*=", "combinated assignment", 14, RIGHT));
        OPERATORS.add(new Operator("/=", "combinated assignment", 14, RIGHT));
        OPERATORS.add(new Operator("+=", "combinated assignment", 14, RIGHT));
        OPERATORS.add(new Operator("-=", "combinated assignment", 14, RIGHT));
        OPERATORS.add(new Operator("%=", "combinated assignment", 14, RIGHT));
    }

    private OcaOperatorData() {
    }

    static List<Operator> getOperators() {
        return OPERATORS;
    }
}