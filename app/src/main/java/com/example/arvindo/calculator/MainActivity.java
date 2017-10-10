package com.example.arvindo.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView ans;
    double initAns;
    boolean isClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ans = (TextView) findViewById(R.id.ans);
        String initValue = getIntent().getStringExtra("INIT_VALUE");
        clear();
        ans.setText(initValue.isEmpty()?"0":initValue);
    }

    public void updateTextOnClick(View view){
        Button b = (Button) view;
        String buttonText = b.getText().toString();
        String ansText = ans.getText().toString();
        if(ansText.equals("0") || isClear){
            ans.setText(buttonText);
            isClear = false;
        }
        else
            ans.setText(ansText + buttonText);
    }

    public void operation(View view){
        Button b = (Button) view;
        double ansNumber = Double.parseDouble(ans.getText().toString());
        String operation = b.getText().toString();
        initAns = Operators.operation(initAns, ansNumber);
        Operators.setOperator(operation);
        Log.d("initAnswer", Double.toString(initAns));
        ans.setText(Double.toString(initAns));
        isClear = true;
    }

    public void clear(){
        initAns = 0;
        ans.setText("0");
        Operators.setOperator("+");
        isClear = false;
    }

    public void clear(View view){
        clear();
    }

    public void back(View view){
        String ansNo = ans.getText().toString();
        if(ansNo.length() > 1)
            ansNo = ansNo.substring(0, ans.length() - 1);
        else
            ansNo = "0";
        ans.setText(ansNo);
    }
}
