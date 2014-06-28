package exceptionquiz;

import exceptionquiz.exhibit.IExhibit;
import exceptionquiz.question.IQuestion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("exceptionquiz");
        Factory factory = ctx.getBean(Factory.class);
        IExhibit exhibit = ctx.getBean(IExhibit.class);
        while (true) {
            ExceptionData data = factory.getRandomExceptionData();
            IQuestion question = factory.getRandomQuestion();
            Result result = question.show(data, null, exhibit);
            exhibit.showResult(result);
        }
    }
}
