package exceptionquiz.excset;

import exceptionquiz.ExcData;
import exceptionquiz.ExcSet;
import exceptionquiz.excdata.ExcDataImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Набор исключений, встречающийся в экзамене Java Programmer I.
 */
public class Jcp1ExcSet implements ExcSet {
    private static final Jcp1ExcSet instance = new Jcp1ExcSet();
    private final Set<ExcData> set = new HashSet<>();

    protected Jcp1ExcSet() {
        add(Throwable.class, "This class is the superclass of all errors and exceptions in the Java language");
        add(Exception.class, "This class and its subclasses are a form of Throwable that indicates conditions that a reasonable application might want to catch.");
        add(FileNotFoundException.class, "Signals that an attempt to open the file denoted by a specified pathname has failed");
        add(IOException.class, "Signals that an I/O exception of some sort has occurred");
        add(ClassNotFoundException.class, "Thrown when an application tries to load in a class through its string name");
        add(RuntimeException.class, "This exception is the superclass of those exceptions that can be thrown during the normal operation of the Java Virtual Machine");
        add(ArrayIndexOutOfBoundsException.class, "Thrown to indicate that an array has been accessed with an illegal index");
        add(IndexOutOfBoundsException.class, "Thrown to indicate that an index of some sort (such as to an array, to a string, or to a vector) is out of range");
        add(ClassCastException.class, "Thrown to indicate that the code has attempted to cast an object to a subclass of which it is not an instance");
        add(IllegalArgumentException.class, "Thrown to indicate that a method has been passed an illegal or inappropriate argument");
        add(IllegalStateException.class, "Signals that a method has been invoked at an illegal or inappropriate time");
        add(NullPointerException.class, "Thrown when an application attempts to use null in a case where an object is required");
        add(NumberFormatException.class, "Thrown to indicate that the application has attempted to convert a string to one of the numeric types, but that the string does not have the appropriate format");
        add(ExceptionInInitializerError.class, "Signals that an unexpected exception has occurred in a static initializer");
        add(NoClassDefFoundError.class, "Thrown if the Java Virtual Machine or a ClassLoader instance tries to load in the definition of a class (as part of a normal method call or as part of creating a new instance using the new expression) and no definition of the class could be found");
        add(StackOverflowError.class, "Thrown when a stack overflow occurs because an application recurses too deeply");
        add(OutOfMemoryError.class, "Thrown when the Java Virtual Machine cannot allocate an object because it is out of memory, and no more memory could be made available by the garbage collector");
    }

    @Override
    public Set<ExcData> getExcs() {
        return set;
    }

    protected void add(Class excClass, String excDescription) {
        set.add(new ExcDataImpl(excClass, excDescription));
    }

    public static Jcp1ExcSet getInstance() {
        return instance;
    }
}