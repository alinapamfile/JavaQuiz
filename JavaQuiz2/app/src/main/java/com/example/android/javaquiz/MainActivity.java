package com.example.android.javaquiz;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //creating and sending an intent containing the score and the user's name to the next activity that is started
    public void onClick(View view) {
        Intent intent = new Intent(this, FirstQuestion.class);
        Bundle extras = new Bundle();
        extras.putInt("score", 0);
        EditText editText = (EditText) findViewById(R.id.users_name_editext);
        String name = editText.getText().toString();
        extras.putString("user", name);
        intent.putExtras(extras);
        startActivity(intent);
    }
}
