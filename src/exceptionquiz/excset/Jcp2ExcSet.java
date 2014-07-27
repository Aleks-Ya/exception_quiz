package exceptionquiz.excset;

import java.text.ParseException;

/**
 * Набор исключений, встречающийся в экзамене Java Programmer II.
 */
public class Jcp2ExcSet extends Jcp1ExcSet {
    private static final Jcp2ExcSet instance = new Jcp2ExcSet();

    private Jcp2ExcSet() {
        //todo Заполнить исключения для экзамена 2го уровня
        add(ParseException.class, "Заполни!");
    }

    public static Jcp2ExcSet getInstance() {
        return instance;
    }
}