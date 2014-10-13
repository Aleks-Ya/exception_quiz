package exceptionquiz.application;

import exceptionquiz.api.Answer;
import exceptionquiz.api.Question;
import exceptionquiz.api.QuestionGenerator;
import exceptionquiz.plugin.exception.ExceptionPluginRunner;
import exceptionquiz.plugin.keyword.KeywordPluginRunner;
import exceptionquiz.plugin.priority.PriorityPluginRunner;

import java.util.Date;

/**
 * Основное приложение.
 * todo Сохранять лог ошибок в файл для повторения и предлагать открыть после выхода
 * todo Ограничить повторение одинаковых типов вопросов 2мя повторами.
 * todo Приоритизировать исключения, чтобы более сложные повторялись чаще (NumberFormatException, ExceptionInInitializerError, NoClassDefError, ClassNotFoundException, OutOfMemoryError).
 * todo Покрыть API консоли оберткой и протестировать ConsoleInquirer
 * todo При 0 отвеченных вопросов выводить продолжительность на вопрос 0. Сейчас: Duration per question (sec): 2
 * todo Подгружать плагины с помощью reflection
 * todo Разделить на 5 gradle-проектов
 * todo Механизм конфигурирования плагинов (Programmer I или II)
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
        DuplicateBlocker<Question> blocker = new QuestionDuplicateBlocker();
        while (true) {
            Question question;
            do {
                question = generator.randomQuestion();
            } while (blocker.isDuplicate(question));
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
        QuestionGenerator exceptionGenerator = new ExceptionPluginRunner();
        QuestionGenerator priorityGenerator = new PriorityPluginRunner();
        QuestionGenerator keywordGenerator = new KeywordPluginRunner();
        return new CompoundGenerator(exceptionGenerator, priorityGenerator, keywordGenerator);
    }
}