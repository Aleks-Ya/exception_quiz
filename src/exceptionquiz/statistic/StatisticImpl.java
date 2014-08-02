package exceptionquiz.statistic;

import exceptionquiz.Statistic;

import java.util.Date;

public class StatisticImpl implements Statistic {
    private Date startTime;
    private Date finishTime;
    private int questionCounter;

    @Override
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public Date getStartTime() {
        return startTime;
    }

    @Override
    public Date getFinishTime() {
        return finishTime;
    }

    @Override
    public int getDuration() {
        return (int) (finishTime.getTime() - startTime.getTime()) / 1000;
    }

    @Override
    public int getTimePerQuestion() {
        return getDuration() / questionCounter;
    }

    @Override
    public void incFinishedQuestions() {
        questionCounter++;
    }

    @Override
    public int getNextQuestionNumbers() {
        return questionCounter + 1;
    }

    @Override
    public int getFinishedQuestions() {
        return questionCounter;
    }
}
