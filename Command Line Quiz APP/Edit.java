import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Edit implements Serializable {
    private static final long serialVersionUID = 1L;

    private String text;
    private List<String> options;
    private int correctOption;

    public Edit(String text) {
        this.text = text;
        this.options = new ArrayList<>();
    }

    public String getText() {
        return text;
    }

    public void addOption(String option) {
        options.add(option);
    }

    public List<String> getOptions() {
        return options;
    }

    public void setCorrectOption(int correctOption) {
        this.correctOption = correctOption;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}