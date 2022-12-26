package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class DataEntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);

        findViewById(R.id.submit_button).setOnClickListener(view -> {
            EditText name_field = (EditText) findViewById(R.id.name_field);
            String name_str = name_field.getText().toString();

            EditText surname_field = (EditText) findViewById(R.id.surname_field);
            String surname_str = surname_field.getText().toString();

            Intent intent = new Intent();
            intent.putExtra("name", name_str);
            intent.putExtra("surname", surname_str);
            setResult(1, intent);
            finish();
        });

    }

}

