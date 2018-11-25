package pl.akademiakodu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame implements ActionListener {


    private QuestionGenerator questionGenerator;

    public QuestionGenerator getQuestionGenerator() {
        return questionGenerator;
    }

    public void setQuestionGenerator(QuestionGenerator questionGenerator) {
        this.questionGenerator = questionGenerator;
    }

    private int currentQuestion;

    private int score;

    private List<Question> questionList = new ArrayList<>();


    public Main() {
        setQuestionGenerator(new SimpleQuestionGenerator());
        questionList = questionGenerator.generateQuestion();
        setSize(800, 600);
        setTitle("Millionaires");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JButton yesButton = new JButton("TAK");
        yesButton.addActionListener(this);
        JButton noButton = new JButton("NIE");
        noButton.addActionListener(this);
        label = new JLabel(questionList.get(currentQuestion).getContent(), SwingConstants.CENTER);
        scoreLabel = new JLabel(("Aktualny wynik: " + score));

        setLayout(new GridLayout(4, 1));
        add(label);
        add(yesButton);
        add(noButton);
        add(scoreLabel);

    }

    private JLabel label;
    private JLabel scoreLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main main = new Main();
            }

        });


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();
        System.out.println(button.getText());


        if (questionList.get(currentQuestion).isCorrect()) {
            if (button.getText() == "TAK") {
                score++;
            }
        }
        if (!questionList.get(currentQuestion).isCorrect()) {
            if (button.getText() == "NIE") {
                score++;
            }
        }
        if (currentQuestion <= questionList.size() - 2) {
            currentQuestion++;
        }

        scoreLabel.setText("Aktualny wynik: " + score);
        label.setText(questionList.get(currentQuestion).getContent());
        Object[] options = {"Yes, please",
                "No, thanks"};
        int replayGame;

        if (currentQuestion == questionList.size() - 1) {


            replayGame = JOptionPane.showOptionDialog(null,
                    ("Twój wynik to: " + score + "\n" + "Czy rozpocząć nową grę?"), "Silly question!",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (replayGame == 0) {
                currentQuestion = 0;
                validate();
                revalidate();
                repaint();
                score = 0;
                Main main1 = new Main();
            }
            if (replayGame == 1) {
                System.exit(0);
            }

        }




    }
}
