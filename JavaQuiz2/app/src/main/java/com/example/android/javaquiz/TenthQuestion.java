package com.example.android.javaquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TenthQuestion extends AppCompatActivity {

    int score;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenth_question);

        //extracting the current score and the user's name from the given intent
        Bundle extras = getIntent().getExtras();
        score = extras.getInt("score");
        name = extras.getString("user");
    }

    public void onClick(View view) {
        int correct = 4;
        EditText editText = (EditText) findViewById(R.id.answer_editext);
        Editable editable_answer = editText.getText();
        String string_answer = editable_answer.toString();

        //checking if the user typed any answer
        if (!string_answer.isEmpty()) {
            int answer = Integer.parseInt(string_answer);

            //checking if the user's answer is correct
            if (answer == correct)
                score += 10;

            //creating and sending an intent containing the score and the user's name to the next activity that will be started
            Intent intent = new Intent(this, Results.class);
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
