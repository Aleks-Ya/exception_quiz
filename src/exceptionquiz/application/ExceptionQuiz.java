package exceptionquiz.application;

import exceptionquiz.api.Answer;
import exceptionquiz.api.Question;
import exceptionquiz.api.QuestionGenerator;
import exceptionquiz.application.answer.QuitAnswer;
import exceptionquiz.application.duplicate.QuestionDuplicateBlocker;
import exceptionquiz.application.formatter.StatisticFormatter;
import exceptionquiz.application.generator.CompoundGenerator;
import exceptionquiz.application.inquirer.ConsoleInquirer;
import exceptionquiz.application.manifest.ManifestReaderImpl;
import exceptionquiz.application.statistic.StatisticImpl;
import exceptionquiz.plugin.exception.excset.Jcp1ExcSet;
import exceptionquiz.plugin.exception.question.QuestionGeneratorImpl;
import exceptionquiz.plugin.priority.PluginRunner;

import java.util.Date;

/**
 * Основное приложение.
 * todo Сохранять лог ошибок в файл для повторения и предлагать открыть после выхода
 * todo Ограничить повторение одинаковых типов вопросов 2мя повторами.
 * todo Приоритизировать исключения, чтобы более сложные повторялись чаще (NumberFormatException, ExceptionInInitializerError, NoClassDefError, ClassNotFoundException, OutOfMemoryError).
 * todo Покрыть API консоли оберткой и протестировать ConsoleInquirer
 * todo При 0 отвеченных вопросов выводить продолжительность на вопрос 0. Сейчас: Duration per question (sec): 2
 * todo Подгружать плагины с помощью reflection
 * todo Разделить на 3 gradle-проекта
 */
public class ExceptionQuiz {
    private static final Answer QUIT_ANSWER = new QuitAnswer();

    private ExceptionQuiz() {
    }

    public static void main(String[] args) {
        final Statistic statistic = new StatisticImpl();
        statistic.setStartTime(new Date());
        QuestionGenerator generator = makeGenerator();
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

    private static QuestionGenerator makeGenerator() {
        Jcp1ExcSet excSet = Jcp1ExcSet.getInstance();
        DuplicateBlocker<Question> blocker = new QuestionDuplicateBlocker();
        QuestionGenerator exceptionGenerator = new QuestionGeneratorImpl(excSet, blocker);
        QuestionGenerator priorityGenerator = new PluginRunner();
        return new CompoundGenerator(exceptionGenerator, priorityGenerator);
    }
}