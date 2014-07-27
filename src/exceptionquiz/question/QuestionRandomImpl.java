package exceptionquiz.question;

import exceptionquiz.ExcData;
import exceptionquiz.ExcSet;
import exceptionquiz.Question;
import exceptionquiz.QuestionRandom;

import java.util.Random;
import java.util.Set;

/**
 * Генератор случайных исключений.
 */
public class QuestionRandomImpl implements QuestionRandom {
    final ExcData[] excDatas;
    final Random random = new Random();
    /**
     * Количество классов Вопросов.
     */
    final static private int QUESTION_COUNT = 4;

    public QuestionRandomImpl(ExcSet set) {
        Set<ExcData> excs = set.getExcs();
        excDatas = excs.toArray(new ExcData[excs.size()]);
    }

    @Override
    public Question randomQuestion() {
        int rndQuestion = random.nextInt(QUESTION_COUNT);
        int rndExc = random.nextInt(excDatas.length);
        ExcData excData = excDatas[rndExc];

        switch (rndQuestion) {
            case 0:
                return new ByDescription(excData);
            case 1:
                return new IsChecked(excData);
            case 2:
                return new ParentClass(excData);
            case 3:
                return new WhichPackage(excData);
            default:
                throw new IllegalStateException("Question class not exists with index " + rndQuestion);
        }
    }
}
