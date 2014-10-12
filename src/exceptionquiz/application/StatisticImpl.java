package exceptionquiz.application;

import java.util.Date;

class StatisticImpl implements Statistic {
    private Date startTime;
    private Date finishTime;
    private int rightAnswers;
    private int mistakeAnswers;

    @Override
    public Date getStartTime() {
        return startTime;
    }

    @Override
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public Date getFinishTime() {
        return finishTime;
    }

    @Override
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public int getDuration() {
        return (int) (getFinishTime().getTime() - getStartTime().getTime()) / 1000;
    }

    @Override
    public int getDurationPerQuestion() {
        int questions = getFinishedQuestions();
        int duration = getDuration();
        return questions != 0 ? duration / questions : duration;
    }

    @Override
    public void incRightQuestions() {
        rightAnswers++;
    }

    @Override
    public void incMistakeQuestions() {
        mistakeAnswers++;
    }

    @Override
    public int getNextQuestionNumber() {
        return getFinishedQuestions() + 1;
    }

    @Override
    public int getFinishedQuestions() {
        return getRightAnswers() + getMistakeAnswers();
    }

    @Override
    public int getRightAnswers() {
        return rightAnswers;
    }

    @Override
    public int getMistakeAnswers() {
        return mistakeAnswers;
    }

    @Override
    public byte getRightPercent() {
        int questions = getFinishedQuestions();
        return questions > 0 ? (byte) (getRightAnswers() * 100 / questions) : 0;
    }

    @Override
    public byte getMistakePercent() {
        int questions = getFinishedQuestions();
        return questions > 0 ? (byte) (100 - getRightPercent()) : 0;
    }
}