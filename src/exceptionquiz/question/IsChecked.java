package exceptionquiz.question;

import exceptionquiz.Answer;
import exceptionquiz.ExceptionData;
import exceptionquiz.Result;
import exceptionquiz.exhibit.IExhibit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Вопрос: Является ли данное исключение проверяемым?
 */
@Component
public class IsChecked implements IQuestion {

    @Autowired
    @Qualifier("yesAnswer")
    private Answer yes;

    @Autowired
    @Qualifier("noAnswer")
    private Answer no;

    @Autowired
    @Qualifier("rightResult")
    private Result rightResult;

    @Autowired
    @Qualifier("notRightResult")
    private Result notRightResult;

    private final List<Answer> answers = new ArrayList<Answer>();

    public IsChecked() {
        answers.add(yes);
        answers.add(no);
    }

    @Override
    public Result show(ExceptionData exceptionData, List<Answer> allAnswers, IExhibit exhibit) {
        String questionText = String.format("Данное исключение проверяемое? %s", exceptionData.getFullName());
        Answer answer = exhibit.exhibitQuestion(questionText, answers);
        if ((exceptionData.isChecked() && answer == yes) || (!exceptionData.isChecked() && answer == no)) {
            return rightResult;
        } else {
            return notRightResult;
        }
    }

}
