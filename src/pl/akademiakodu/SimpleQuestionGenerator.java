package pl.akademiakodu;

import java.util.ArrayList;
import java.util.List;

public class SimpleQuestionGenerator implements QuestionGenerator {


    @Override
    public List<Question> generateQuestion() {
        List<Question> questionList = new ArrayList<>();
        questionList.add(new Question(
                "Czy wolno Ci holować pojazd, którym kieruje osoba w stanie po użyciu alkoholu?", false));
        questionList.add(new Question(
                "Czy spożycie amfetaminy może zwiększać skołonność kierowcy do ryzykownych i agresywnych zachowań? ", true));
        questionList.add(new Question(
                "Czy postąpisz właściwie umieszczając ostrzegawczy trójkąt odblaskowy w odległości 30-50 m za pojazdem, który uległ awarii na drodze ekspresowej?", false));
        questionList.add(new Question(
                "Czy zamierzając kierować pojazdem po zażyciu leków, powinieneś upewnić się, że nie mają one negatywnego wpływu na twój stan psychofizyczny?", true));
        questionList.add(new Question(
                "Czy substancje psychoaktywne (m.in. \"dopalacze\") wpływają na zdolność bezpiecznego kierowania pojazdem nawet przez najbardziej doświadczonych kierowców?", true));
        questionList.add(new Question(
                "Czy jako uczestnik wypadku drogowego. w którym nie ma zabitych lub rannych, masz obowiązek niezwłocznie usunąć pojazd z miejsca zdarzenia?", true));
        questionList.add(new Question(
                "Czy jako uczestnik wypadku drogowego, w którym nie ma zabitych lub rannych, masz obowiązek wezwać Policję? ", false));
        questionList.add(new Question(
                "Czy przy omijaniu nietrzeźwego rowerzysty należy zwiększyć odstęp od niego?", true));


        return questionList;
    }
}
