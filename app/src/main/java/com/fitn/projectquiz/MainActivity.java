package com.fitn.projectquiz;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button toTop = (Button) findViewById(R.id.back_to_top);
        final ScrollView myScrollView = (ScrollView) findViewById(R.id.main_view);
        toTop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                myScrollView.smoothScrollTo(0, 0);
            }
        });
    }

    public void getQuizResult(View view) {
        String quizResult;
        String answerOneS;
        String answerTwoS;
        String answerThreeS;
        String answerFourS;
        String answerFiveS;

        RadioGroup radioOne = (RadioGroup) findViewById(R.id.radio_group_1);
        RadioButton answerOne = (RadioButton) findViewById(radioOne.getCheckedRadioButtonId());
        answerOneS = checkRadioButtonForNull(answerOne);

        RadioGroup radioTwo = (RadioGroup) findViewById(R.id.radio_group_2);
        RadioButton answerTwo = (RadioButton) findViewById(radioTwo.getCheckedRadioButtonId());
        answerTwoS = checkRadioButtonForNull(answerTwo);

        RadioGroup radioThree = (RadioGroup) findViewById(R.id.radio_group_3);
        RadioButton answerThree = (RadioButton) findViewById(radioThree.getCheckedRadioButtonId());
        answerThreeS = checkRadioButtonForNull(answerThree);

        RadioGroup radioFour = (RadioGroup) findViewById(R.id.radio_group_4);
        RadioButton answerFour = (RadioButton) findViewById(radioFour.getCheckedRadioButtonId());
        answerFourS = checkRadioButtonForNull(answerFour);

        RadioGroup radioFive = (RadioGroup) findViewById(R.id.radio_group_5);
        RadioButton answerFive = (RadioButton) findViewById(radioFive.getCheckedRadioButtonId());
        answerFiveS = checkRadioButtonForNull(answerFive);


        if (answerOneS == "No answer" || answerTwoS == "No answer" || answerThreeS == "No answer" || answerFourS == "No answer" || answerFiveS == "No answer") {
            Toast.makeText(this, "All Questions Must Be Answered", Toast.LENGTH_SHORT).show();
            return;
        } else {
            quizResult = answerOneS;
            quizResult += "\n" + answerTwoS;
            quizResult += "\n" + answerThreeS;
            quizResult += "\n" + answerFourS;
            quizResult += "\n" + answerFiveS;

            TextView resultView = (TextView) findViewById(R.id.result_view);
            resultView.setText(quizResult);

            Toast.makeText(this, "Thanks For Taking This Quiz", Toast.LENGTH_SHORT).show();

            Intent viewResult = new Intent(this, QuizResult.class);
            viewResult.putExtra("Quiz_Result", quizResult);
            if (viewResult.resolveActivity(getPackageManager()) != null) {
                startActivity(viewResult);
            }
        }
    }


    public String checkRadioButtonForNull(RadioButton radioButton) {
        String answer;
        if (radioButton != null) {
            answer = radioButton.getText().toString();
        } else {
            answer = "No answer";
        }
        return answer;
    }
}
