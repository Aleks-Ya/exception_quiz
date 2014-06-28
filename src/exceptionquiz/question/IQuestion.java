package exceptionquiz.question;

import exceptionquiz.Answer;
import exceptionquiz.ExceptionData;
import exceptionquiz.Result;
import exceptionquiz.exhibit.IExhibit;

import java.util.List;

/**
 * Тип вопроса об исключении.
 */
public interface IQuestion {
    Result show(ExceptionData exceptionData, List<Answer> allAnswers, IExhibit exhibit);
}
