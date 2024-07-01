import java.io.*;

public class SerializeStore {
    private static final String FILENAME = "quizzes.dat";

    public static void saveQuizzes(ControlQuiz controlQuiz) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(controlQuiz);
            System.out.println("Quizzes saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ControlQuiz loadQuizzes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            return (ControlQuiz) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Handle exception if file not found or unable to read
            return new ControlQuiz(); // Return a new ControlQuiz if no quizzes found
        }
    }
}