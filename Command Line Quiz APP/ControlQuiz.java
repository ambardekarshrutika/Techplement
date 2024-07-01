import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ControlQuiz implements Serializable {
    private static final long serialVersionUID = 1L;

    private Map<String, Quiz> quizzes;

    public ControlQuiz() {
        this.quizzes = new HashMap<>();
    }

    public void addQuiz(Quiz quiz) {
        quizzes.put(quiz.getName(), quiz);
    }

    public Quiz getQuiz(String name) {
        return quizzes.get(name);
    }

    public boolean quizExists(String name) {
        return quizzes.containsKey(name);
    }
}