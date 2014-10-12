package exceptionquiz.application;

import java.util.Date;

/**
 * Подсчитывает статистику по занятию.
 */
interface Statistic {

    Date getStartTime();

    void setStartTime(Date startTime);

    Date getFinishTime();

    void setFinishTime(Date finishTime);

    /**
     * Длительность занятия в секундах.
     */
    int getDuration();

    /**
     * Среднее время на один вопрос в секундах.
     */
    int getDurationPerQuestion();

    void incRightQuestions();

    void incMistakeQuestions();

    int getNextQuestionNumber();

    int getFinishedQuestions();

    int getRightAnswers();

    int getMistakeAnswers();

    byte getRightPercent();

    byte getMistakePercent();
}