package com.example.n3153r.curso1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2Activity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        textView =(TextView) findViewById(R.id.texto);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        if(bundle!=null){
            String cadena = (String) bundle.get("DATO");
            textView.setText(cadena);

        }

    }
}
