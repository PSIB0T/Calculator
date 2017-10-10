package com.example.arvindo.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LauncherActivity extends AppCompatActivity {

    Button launchCalc;
    EditText initValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        launchCalc = (Button) findViewById(R.id.launchCalc);
        initValue = (EditText) findViewById(R.id.initValue);
        launchCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LauncherActivity.this, MainActivity.class);
                intent.putExtra("INIT_VALUE", initValue.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }
}
