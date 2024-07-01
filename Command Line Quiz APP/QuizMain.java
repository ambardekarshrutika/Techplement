import java.util.Scanner;

public class QuizMain {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ControlQuiz controlQuiz = SerializeStore.loadQuizzes();

    public static void main(String[] args) {
        System.out.println("Welcome to the Quiz App!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Create a new quiz");
            System.out.println("2. Take a quiz");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    createQuiz();
                    break;
                case 2:
                    takeQuiz();
                    break;
                case 3:
                    System.out.println("Exiting the Quiz App. Goodbye!");
                    SerializeStore.saveQuizzes(controlQuiz); // Save quizzes before exit
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void createQuiz() {
        System.out.print("\nEnter quiz name: ");
        String quizName = scanner.nextLine().toLowerCase(); // Convert to lowercase

        if (controlQuiz.quizExists(quizName)) {
            System.out.println("Quiz with this name already exists. Please choose a different name.");
            return;
        }

        Quiz quiz = new Quiz(quizName);
        boolean addingQuestions = true;

        while (addingQuestions) {
            System.out.print("\nEnter question (or type 'done' to finish adding questions): ");
            String questionText = scanner.nextLine();

            if (questionText.equalsIgnoreCase("done")) {
                addingQuestions = false;
                break;
            }

            Edit edit = new Edit(questionText);

            System.out.print("Enter number of options: ");
            int numOptions = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            for (int i = 0; i < numOptions; i++) {
                System.out.printf("Enter option %d: ", i + 1);
                String option = scanner.nextLine();
                edit.addOption(option);
            }

            System.out.print("Enter correct option number: ");
            int correctOption = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            edit.setCorrectOption(correctOption);
            quiz.addQuestion(edit);
        }

        controlQuiz.addQuiz(quiz);
        SerializeStore.saveQuizzes(controlQuiz); // Save quizzes to file
        System.out.println("Quiz created successfully!");
    }

    private static void takeQuiz() {
        System.out.print("\nEnter quiz name to take: ");
        String quizName = scanner.nextLine().toLowerCase(); // Convert to lowercase

        Quiz quiz = controlQuiz.getQuiz(quizName);

        if (quiz == null) {
            System.out.println("Quiz not found. Please enter a valid quiz name.");
            return;
        }

        Information information = new Information(quiz);
        information.runQuiz();
    }
}