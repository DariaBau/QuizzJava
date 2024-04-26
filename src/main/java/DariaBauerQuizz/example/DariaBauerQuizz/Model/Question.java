package DariaBauerQuizz.example.DariaBauerQuizz.Model;

import java.util.Map;

public class Question {

    private String questionText;
    private Map<String, String> options;
    private String correctAnswer;

    public Question(String questionText, Map<String, String> options, String correctAnswer) {        //sozdaem constructor
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }



    public Map<String, String> getOptions() {
        return options;
    }

    public void setOptions(Map<String, String> options) {
        this.options = options;
    }



    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
