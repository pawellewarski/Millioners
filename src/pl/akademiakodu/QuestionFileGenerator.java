package pl.akademiakodu;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuestionFileGenerator implements QuestionGenerator {
    @Override
    public List<Question> generateQuestion() {

        String fileName = "questions.txt";
        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            list = stream
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Question>questionList = new ArrayList<>();
        for ( String line: list){
            line.indexOf('?');
            System.out.println("Pytanie: " + line.substring(0,line.indexOf('?')+1));
            System.out.println(line.substring(line.indexOf('?')+1).contains("TAK"));

            if (line.contains("TAK")){
                questionList.add(new Question(line.substring(0,line.indexOf('?')+1),true));
            }
            if (line.contains("NIE")){
                questionList.add(new Question(line.substring(0,line.indexOf('?')+1),false));
            }


//            System.out.println(line);
        }



        return questionList;
    }

    public static void main(String[] args) {
        QuestionFileGenerator questionFileGenerator = new QuestionFileGenerator();
        questionFileGenerator.generateQuestion();
    }




}