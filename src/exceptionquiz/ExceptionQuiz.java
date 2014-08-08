package exceptionquiz;

import exceptionquiz.answer.QuitAnswer;
import exceptionquiz.duplicate.QuestionDuplicateBlocker;
import exceptionquiz.excset.Jcp1ExcSet;
import exceptionquiz.formatter.StatisticFormatter;
import exceptionquiz.inquirer.ConsoleInquirer;
import exceptionquiz.manifest.ManifestReaderImpl;
import exceptionquiz.question.QuestionRandomImpl;
import exceptionquiz.statistic.StatisticImpl;

import java.util.Date;

/**
 * Основное приложение.
 * todo Сохранять лог ошибок в файл для повторения и предлагать открыть после выхода
 */
public class ExceptionQuiz {
    private static final Answer QUIT_ANSWER = new QuitAnswer();

    private ExceptionQuiz() {
    }

    public static void main(String[] args) {
        final Statistic statistic = new StatisticImpl();
        statistic.setStartTime(new Date());
        Jcp1ExcSet excSet = Jcp1ExcSet.getInstance();
        DuplicateBlocker<Question> blocker = new QuestionDuplicateBlocker();
        QuestionRandom generator = new QuestionRandomImpl(excSet, blocker);
        Formatter<Statistic> formatter = new StatisticFormatter();
        final ManifestReader manifest = new ManifestReaderImpl();
        String message = String.format("\n\nEXCEPTION QUIZ v%s\nEnter \"q\" for exit\n", manifest.getVersion());
        Inquirer inquirer = new ConsoleInquirer(statistic, formatter);
        inquirer.showInfoMessage(message);
        while (true) {
            Question question = generator.randomQuestion();
            inquirer.showQuestionText(question);
            String answer = inquirer.takeAnswerText(question.getPrompt());
            if (QUIT_ANSWER.isRight(answer)) {
                statistic.setFinishTime(new Date());
                inquirer.showStatistic(statistic);
                break;
            } else if (question.getRightAnswer().isRight(answer)) {
                statistic.incRightQuestions();
                inquirer.showRightAnswerText("RIGHT!");
            } else {
                statistic.incMistakeQuestions();
                inquirer.showRightAnswerText("MISTAKE: " + question.getAnswerText());
            }
        }
    }
}