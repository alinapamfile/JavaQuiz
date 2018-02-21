package com.example.android.javaquiz;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class FirstQuestion extends MainActivity {

    int score;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);

        //extracting the current score and the user's name from the given intent
        Bundle extras = getIntent().getExtras();
        score = extras.getInt("score");
        name = extras.getString("user");
    }

    public void onClick(View view) {
        CheckBox checkBox1 = findViewById(R.id.question1_option1_checkbox);
        CheckBox checkBox2 = findViewById(R.id.question1_option2_checkbox);
        CheckBox checkBox3 = findViewById(R.id.question1_option3_checkbox);
        CheckBox checkBox4 = findViewById(R.id.question1_option4_checkbox);

        //checking if the user got the correct answers
        if (checkBox2.isChecked() && checkBox3.isChecked() && !checkBox1.isChecked() && !checkBox4.isChecked())
            score += 10;

        /*verifying if the user chose any answer
          if yes, an intent containing the score and the user's name will be created and sent to the next activity that will be started
        */
        if (checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked() || checkBox4.isChecked()) {
            Intent intent = new Intent(this, SecondQuestion.class);
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
