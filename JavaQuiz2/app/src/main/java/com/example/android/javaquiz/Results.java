package com.example.android.javaquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Results extends AppCompatActivity {

    int score;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //extracting the final score and the user's name from the given intent
        Bundle extras = getIntent().getExtras();
        score = extras.getInt("score");
        name = extras.getString("user");
    }

    //creating a toast message that will communicate the user's score
    public void onClick(View view) {
        String text = getString(R.string.your_result1, name) + getString(R.string.your_result2, score);
        Toast final_score = Toast.makeText(this, text, Toast.LENGTH_LONG);
        final_score.show();
    }

    //stopping the user from turning back to a previous question
    @Override
    public void onBackPressed() {
    }

}
