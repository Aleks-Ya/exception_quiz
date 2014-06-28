package exceptionquiz.exhibit;

import exceptionquiz.Answer;
import exceptionquiz.Result;
import org.springframework.stereotype.Component;

import java.io.Console;
import java.io.PrintStream;
import java.util.List;

/**
 * Вывод информации на консоль.
 */
@Component
public class ConsoleExhibit implements IExhibit {
    private static final PrintStream out = System.out;
    private Console console;

    public ConsoleExhibit() {
        console = System.console();
        if (console == null) {
            throw new IllegalStateException("Чтобы была консоль, нужно запускать из командной строки");
        }
    }

    @Override
    public Answer exhibitQuestion(String questionText, List<Answer> answers) {
        out.println(questionText);
        for (int i = 0; i < answers.size(); i++) {
            out.print(i + 1);
            out.println(answers.get(i).getText());
        }
        String line = console.readLine();
        int answerNum = Integer.parseInt(line);
        return answers.get(answerNum - 1);
    }

    @Override
    public void showResult(Result result) {
        out.println(result.isRight() ? "Верно!" : "Не верно...");
    }
}