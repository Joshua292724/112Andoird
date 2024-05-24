package com.example.explictintentdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnChange = (Button) findViewById(R.id.btnChange);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtC = (EditText) findViewById(R.id.txtC);
                int tempC = Integer.parseInt(txtC.getText().toString());
                EditText edtPlace = (EditText) findViewById(R.id.edtPlace);
                Intent intent = new Intent(MainActivity.this, FActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("tempC", tempC);
                bundle.putString("PLACE", edtPlace.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}