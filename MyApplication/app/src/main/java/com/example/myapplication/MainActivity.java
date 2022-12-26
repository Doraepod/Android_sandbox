package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityResultLauncher<Intent> someActivityResultLaunch = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        TextView t = (TextView) findViewById(R.id.result_text_field);
                        if (result.getResultCode() == 1) {
                            String name_text = result.getData().getStringExtra("name");
                            String surname_text = result.getData().getStringExtra("surname");
                            t.setText(name_text.concat(" ").concat(surname_text));
                        }
                        else {
                            t.setText("Something went wrong");
                        }
                    }
                }

        );

        findViewById(R.id.pressable_button).setOnClickListener(view -> {
            Intent my_intent = new Intent(this, DataEntryActivity.class);
            someActivityResultLaunch.launch(my_intent);
        });
    }


}