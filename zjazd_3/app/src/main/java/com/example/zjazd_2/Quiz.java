package com.example.zjazd_2;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


class QuestionAnswer {

    public static String question[] ={
            "Co to jest dieta zrównoważona?",
            "Jakie są główne składniki diety zrównoważonej?",
            "Które z poniższych to źródło błonnika?",
            "Jakie są korzyści płynące z jedzenia owoców i warzyw?",
            "Co to jest tłuszcz nasycony",
            "Jakie są dobre źródła tłuszczów nienasyconych?"
    };

    public static String choices[][] = {
            {"a) Dieta, która zawiera tylko rośliny",
                    "b) Dieta, która zawiera równowagę pomiędzy składnikami odżywczymi",
                    "c) Dieta, która składa się tylko z mięsa",
                    "d) Jedzenie w tylko w macu"
                    },
            {"a) Węglowodany, białka i tłuszcze","b) Witaminy, minerały i błonnik",
                    "c) Białka, tłuszcze i woda","d) Woda + sól"},
            {"a) Mięso","b) Owoce i warzywa","c) Słodycze"
                    ,"d) Parówki"},
            {"a) Zawierają one wiele składników odżywczych","b) Pomagają one w utrzymaniu zdrowej wagi",
                    "c) Oba powyższe","d) Nie mają zalet"},
            {"a) Tłuszcz, który jest zdrowy dla serca","b) Tłuszcz, który jest szkodliwy dla serca",
                    "c) Tłuszcz, który nie ma wpływu na serce","d) Dobrze syci"},
            {"a) Oliwa z oliwek, orzechy i awokado","b) Mięso, masło i sery",
                    "c) Chipsy, krakersy i inne przekąski" ,"d) Kabanosy"}
    };

    public static String correctAnswers[] = {
            "b) Dieta, która zawiera równowagę pomiędzy składnikami odżywczymi",
            "b) Witaminy, minerały i błonnik",
            "b) Owoce i warzywa",
            "b) Pomagają one w utrzymaniu zdrowej wagi",
            "b) Tłuszcz, który jest szkodliwy dla serca",
            "b) Mięso, masło i sery"
    };

}

public class Quiz extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;

    int score=0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Liczba pytań : "+totalQuestion);

        loadNewQuestion();




    }

    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit_btn){
            if(selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();


        }else{
            //choices button clicked
            selectedAnswer  = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);

        }

    }

    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion ){
            finishQuiz();
            return;
        }

        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);

    }

    void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion*0.60){
            passStatus = "Przeszedłeś quiz";
        }else{
            passStatus = "Nie udało się :/";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Punkty "+ score+" z "+ totalQuestion)
                .setPositiveButton("Restartuj",(dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .show();


    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }

}