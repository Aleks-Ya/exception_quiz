package exceptionquiz.question;

import exceptionquiz.DuplicateBlocker;
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
    private final ExcData[] excDatas;
    private final Random random = new Random();
    private DuplicateBlocker<Question> blocker;

    /**
     * Количество классов Вопросов.
     */
    private static final int QUESTION_COUNT = 4;

    public QuestionRandomImpl(ExcSet set, DuplicateBlocker<Question> blocker) {
        Set<ExcData> excs = set.getExcs();
        excDatas = excs.toArray(new ExcData[excs.size()]);
        this.blocker = blocker;
    }

    @Override
    public Question randomQuestion() {
        if (blocker != null) {
            Question q;
            do {
                q = generate();
            } while (blocker.isDuplicate(q));
            return q;
        } else {
            return generate();
        }
    }

    private Question generate() {
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
