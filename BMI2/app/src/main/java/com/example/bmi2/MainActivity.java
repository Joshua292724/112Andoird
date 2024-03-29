package com.example.bmi2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText ediHeight = (EditText) findViewById(R.id.editHeight);
        EditText ediWeight = (EditText) findViewById(R.id.editWeight);

        txtShow = (TextView) findViewById(R.id.txtShow);
        txtShow.setTextSize(36);
        Button btnCalc = (Button) findViewById(R.id.btnCalc);
        Button btnClear = (Button) findViewById(R.id.btnClear);
        btnCalc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                double height = Double.parseDouble(ediHeight.getText().toString());
                double weight = Double.parseDouble(ediWeight.getText().toString());
                double bmi = weight / Math.pow(height/100.0 , 2);
                if(bmi >= 24)
                    txtShow.setTextColor(Color.RED);
                else if(bmi < 18.5)
                    txtShow.setTextColor(Color.BLUE);
                else
                    txtShow.setTextColor(Color.GREEN);

                txtShow.setText(String.format("%.2f", bmi));
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ediHeight.setText("");
                ediWeight.setText("");
                txtShow.setText("");
            }
        });
    }
}