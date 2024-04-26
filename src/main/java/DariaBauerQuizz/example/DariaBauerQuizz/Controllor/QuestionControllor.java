package DariaBauerQuizz.example.DariaBauerQuizz.Controllor;

import DariaBauerQuizz.example.DariaBauerQuizz.Model.Question;
import DariaBauerQuizz.example.DariaBauerQuizz.Model.QuizForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("quizForm")


public class QuestionControllor {

    private static final List<String> allResults = new ArrayList<>();

    @GetMapping("/")
    public String home(Model model) {   //sozdaem metod
        model.addAttribute("quizForm", new QuizForm());
        return "home";
    }

    @PostMapping("/start")
    public String startQuiz(@ModelAttribute QuizForm quizForm, Model model) {
        model.addAttribute("quizForm", quizForm);
        return "redirect:/question/0";
    }


    @GetMapping("/question/{index}")
    public String question(@PathVariable int index, @ModelAttribute("quizForm") QuizForm quizForm, Model model) {
        if (index >= questions.size()) {
            return "redirect:/result";
        }

        model.addAttribute("question", questions.get(index));
        model.addAttribute("index", index);
        return "question";
    }

    @PostMapping("/answer/{index}")   //methode answer
    public String answer(@PathVariable int index, @RequestParam String answer, @ModelAttribute("quizForm") QuizForm quizForm) {
        quizForm.setAnswer(index, answer);
        return "redirect:/question/" + (index + 1);
    }



    @GetMapping("/result")
    public String result(@ModelAttribute("quizForm") QuizForm quizForm, Model model) {
        int score = calculateScore(quizForm.getAnswers());
        String result = quizForm.getName() + " Result " + score + " out of 3";
        allResults.add(result);
        model.addAttribute("score", score);
        model.addAttribute("allResults", allResults);
        return "result";
    }

    public int calculateScore(ArrayList<String> answers) {
        int score = 0;
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i) != null && answers.get(i).equals(questions.get(i).getCorrectAnswer())) {
                score++;
            }
        }
        return score;
    }

    private List<Question> questions = List.of(
            new Question(
                    "Quel réalisateur est considéré comme le pionnier du cinéma de science-fiction avec son film \"2001 : L'Odyssée de l'espace\" ?",
                    Map.of(
                            "Hitchcock", "Alfred Hitchcock",
                            "Spielberg", "Steven Spielberg",
                            "Kubrick", "Stanley Kubrick",
                            "Lucas", "George Lucas"
                    ),
                    "Kubrick"
            ),
            new Question(
                    "Quel film a remporté l'Oscar du meilleur film en 1994 et a été réalisé par Quentin Tarantino ?",
                    Map.of(
                            "PulpFiction", "Pulp Fiction",
                            "FightClub", "Fight Club",
                            "LesEvades", "Les Évadés",
                            "LeSilenceDesAgneaux", "Le Silence des agneaux"
                    ),
                    "PulpFiction"
            ),
            new Question(
                    "Qui a réalisé le film d'animation \"Le Voyage de Chihiro\", qui a remporté l'Oscar du meilleur film d'animation en 2003 ?",
                    Map.of(
                            "Miyazaki", "Hayao Miyazaki",
                            "Burton", "Tim Burton",
                            "Disney", "Walt Disney",
                            "Bird", "Brad Bird"
                    ),
                    "Miyazaki"
            )

    );

}
