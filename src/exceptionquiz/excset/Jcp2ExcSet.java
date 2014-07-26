package exceptionquiz.excset;

import java.text.ParseException;

/**
 * Набор исключений, встречающийся в экзамене Java Programmer II.
 */
public class Jcp2ExcSet extends Jcp1ExcSet {
    static {
        //todo Дописать
        add(ParseException.class, "Заполни!");
    }
}