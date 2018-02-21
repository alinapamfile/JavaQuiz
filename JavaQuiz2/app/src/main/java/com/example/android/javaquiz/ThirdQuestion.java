package com.example.android.javaquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class ThirdQuestion extends AppCompatActivity {

    int score;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_question);

        //extracting the current score and the user's name from the given intent
        Bundle extras = getIntent().getExtras();
        score = extras.getInt("score");
        name = extras.getString("user");
    }

    public void onClick(View view) {
        RadioButton radioButton1 = findViewById(R.id.question3_option1_radiobutton);
        RadioButton radioButton2 = findViewById(R.id.question3_option2_radiobutton);
        RadioButton radioButton3 = findViewById(R.id.question3_option3_radiobutton);
        RadioButton radioButton4 = findViewById(R.id.question3_option4_radiobutton);

        //checking if the user got the correct answer
        if (radioButton4.isChecked())
            score += 10;

        /*verifying if the user chose any answer
          if yes, an intent containing the score and the user's name will be created and sent to the next activity that will be started
        */
        if (radioButton1.isChecked() || radioButton2.isChecked() || radioButton3.isChecked() || radioButton4.isChecked()) {
            Intent intent = new Intent(this, FourthQuestion.class);
            Bundle extras = new Bundle();
            extras.putInt("score", score);
            extras.putString("user", name);
            intent.putExtras(extras);
            startActivity(intent);
        }
    }

    //stopping the user from turning back to a previous question
    @Override
    public void onBackPressed() {
    }
}
