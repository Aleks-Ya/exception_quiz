package exceptionquiz.plugin.exception;

import java.text.ParseException;

/**
 * Набор исключений, встречающийся в экзамене Java Programmer II.
 */
class Jcp2ExcSet extends Jcp1ExcSet {
    private static final Jcp2ExcSet INSTANCE = new Jcp2ExcSet();

    private Jcp2ExcSet() {
        //todo Заполнить исключения для экзамена 2го уровня
        add(ParseException.class, "Заполни!");
    }

    public static Jcp2ExcSet getInstance() {
        return INSTANCE;
    }
}