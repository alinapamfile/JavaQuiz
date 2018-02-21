package com.example.android.javaquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class SeventhQuestion extends AppCompatActivity {

    int score;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh_question);

        //extracting the current score and the user's name from the given intent
        Bundle extras = getIntent().getExtras();
        score = extras.getInt("score");
        name = extras.getString("user");
    }

    public void onClick(View view) {
        CheckBox checkBox1 = findViewById(R.id.question7_option1_checkbox);
        CheckBox checkBox2 = findViewById(R.id.question7_option2_checkbox);
        CheckBox checkBox3 = findViewById(R.id.question7_option3_checkbox);

        //checking if the user got the correct answers
        if (checkBox1.isChecked() && checkBox2.isChecked() && !checkBox3.isChecked()) {
            score += 10;
        }

        /*verifying if the user chose any answer
          if yes, an intent containing the score and the user's name will be created and sent to the next activity that will be started
        */
        if (checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked()) {
            Intent intent = new Intent(this, EighthQuestion.class);
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
