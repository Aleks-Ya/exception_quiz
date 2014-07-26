package exceptionquiz;

/**
 * Основное приложение.
 */
public class ExceptionQuiz {
    public static void main(String[] args) {
        QuestionGenerator generator = null;
        Inquirer inquirer = null;
        while (true) {
            Question question = generator.randomQuestion();
            inquirer.showQuestionText(question);
            String answer = inquirer.takeAnswerText();
            if (question.getAnswerText().equals(answer)) {
                inquirer.showRightAnswerText("RIGHT!");
            } else {
                inquirer.showRightAnswerText("MISTAKE: " + question.getAnswerText());
            }
        }
    }
}