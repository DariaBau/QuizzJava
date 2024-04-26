package DariaBauerQuizz.example.DariaBauerQuizz.Model;

import lombok.Setter;

import java.util.ArrayList;

public class QuizForm {

    @Setter
    private String name;

    private final ArrayList<String> answers = new ArrayList<>();


    public String getName() {

        return name;
    }

    public ArrayList<String> getAnswers() {

        return answers;
    }

    public void setAnswer(int index, String answer) {
        while (answers.size() <= index) {
            answers.add(null);

        }
        answers.set(index, answer);
    }

}
