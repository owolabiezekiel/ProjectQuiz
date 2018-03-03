package com.fitn.projectquiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class QuizResult extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        String quizResult = getIntent().getStringExtra("Quiz_Result");
        TextView thanksView = (TextView) findViewById(R.id.thanks_view);
        thanksView.setText("You have successfully completed the quiz. Thanks For Taking This Course on Udacity. This was ALC 3.0");
        TextView yourAnswer = (TextView) findViewById(R.id.your_answer);
        yourAnswer.setText(quizResult);
        TextView quizAnswer = (TextView) findViewById(R.id.quiz_answer);
        quizAnswer.setText("Yes\nYes\nYes\nYes\nYes");
    }

    public void backToQuiz(View view) {
        Intent viewResult = new Intent(this, MainActivity.class);
        if (viewResult.resolveActivity(getPackageManager()) != null) {
            startActivity(viewResult);
        }
    }

    public void mailToFriend(View view){
        String quizResult = getIntent().getStringExtra("Quiz_Result");
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for user");
        intent.putExtra(Intent.EXTRA_TEXT, quizResult);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}

