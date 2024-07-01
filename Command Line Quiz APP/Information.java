import java.util.List;
import java.util.Scanner;

public class Information {
    private Quiz quiz;
    private Scanner scanner;

    public Information(Quiz quiz) {
        this.quiz = quiz;
        this.scanner = new Scanner(System.in);
    }

    public void runQuiz() {
        int score = 0;

        System.out.printf("\nStarting quiz: %s\n", quiz.getName());

        for (Edit edit : quiz.getQuestions()) {
            System.out.println("\n" + edit.getText());
            List<String> options = edit.getOptions();

            for (int i = 0; i < options.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, options.get(i));
            }

            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (userAnswer == edit.getCorrectOption()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect.");
            }
        }

        System.out.printf("\nQuiz ended. Your score: %d/%d\n", score, quiz.getQuestions().size());
    }
}