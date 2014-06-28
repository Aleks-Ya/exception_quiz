package exceptionquiz.exhibit;

import exceptionquiz.Answer;
import exceptionquiz.Result;
import exceptionquiz.question.IQuestion;

import java.util.List;

/**
 * Отображает информацию пользователю.
 */
public interface IExhibit {
    Answer exhibitQuestion(String questionText, List<Answer> answers);

    void showResult(Result result);
}
