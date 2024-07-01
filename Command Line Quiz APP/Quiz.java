import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Quiz implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private List<Edit> edits;

    public Quiz(String name) {
        this.name = name;
        this.edits = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addQuestion(Edit edit) {
        edits.add(edit);
    }

    public List<Edit> getQuestions() {
        return edits;
    }
}