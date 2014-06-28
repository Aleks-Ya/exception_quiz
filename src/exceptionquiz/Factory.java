package exceptionquiz;

import exceptionquiz.question.IQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

/**
 * Хранит все исключения и все виды опросов.
 */
@Component
public class Factory {
    @Value("#{loader.getExceptionData}")
    private List<ExceptionData> exceptionData;

    @Autowired
    @Qualifier("questions")
    private List<IQuestion> questions;

    private final Random random = new Random();

    public ExceptionData getRandomExceptionData() {
        return exceptionData.get(random.nextInt(exceptionData.size()));
    }

    public IQuestion getRandomQuestion() {
        return questions.get(random.nextInt(questions.size()));
    }

//    private List<Answer> answers = new ArrayList<Answer>();

//    public Factory() {
//        for (IQuestion question : questions) {
//            answers.add(question.get)
//        }
//    }
}
