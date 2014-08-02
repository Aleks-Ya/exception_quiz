package exceptionquiz;

import java.util.Date;

/**
 * Подсчитывает статистику по занятию.
 */
public interface Statistic {

    void setStartTime(Date startTime);
    void setFinishTime(Date finishTime);
    Date getStartTime();
    Date getFinishTime();

    /**
     * Длительность занятия в секундах.
     */
    int getDuration();

    /**
     * Среднее время на один вопрос в секундах.
     */
    int getTimePerQuestion();

    void incFinishedQuestions();

    int getNextQuestionNumbers();

    int getFinishedQuestions();
}
