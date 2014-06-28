package exceptionquiz;

import exceptionquiz.loader.HardCodeLoader;
import exceptionquiz.loader.IExceptionDataLoader;
import exceptionquiz.question.IQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Конфигурация бинов Spring.
 */
@Configuration
public class Config {
    @Autowired
    ApplicationContext ctx;

    @Bean
    public Answer yesAnswer() {
        return new Answer("Да");
    }

    @Bean
    public Answer noAnswer() {
        return new Answer("Нет");
    }

    @Bean
    public IExceptionDataLoader loader() {
        return new HardCodeLoader();
    }

    @Bean
    public List<IQuestion> questions() {
        return new ArrayList<IQuestion>(ctx.getBeansOfType(IQuestion.class).values());
    }

    @Bean
    public Result rightResult() {
        return new Result(true);
    }

    @Bean
    public Result notRightResult() {
        return new Result(false);
    }
}
