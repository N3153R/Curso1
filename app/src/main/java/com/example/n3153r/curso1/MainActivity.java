package com.example.n3153r.curso1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RadioGroup radioGroup;
    TextView texto,texto2;
    EditText editText;
    ImageView imagen;
    Button boton,botonA,botonB;
    Toast toast;
    Button btnN;
    Spinner spinner;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = (ToggleButton) findViewById(R.id.toggle);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this,"TRUE",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"FALSE",Toast.LENGTH_SHORT).show();
                }
            }
        });

        texto = (TextView) findViewById(R.id.textView);
        texto.setText("Nuevo Texto");

        texto2 = (TextView) findViewById(R.id.textView2);

        imagen=(ImageView) findViewById(R.id.imageView);

        boton=(Button) findViewById(R.id.button);
        botonA=(Button) findViewById(R.id.button2);
        botonB=(Button) findViewById(R.id.button3);
//-------------
        boton.setOnClickListener(this);
        botonA.setOnClickListener(this);
        botonB.setOnClickListener(this);
//-------------
        btnN=(Button) findViewById(R.id.btnNuevo);
        btnN.setOnClickListener(this);
        editText=(EditText) findViewById(R.id.editText);

//------------------------
        spinner =(Spinner) findViewById(R.id.spinner);
        List list = new ArrayList();
        list.add("Item 1");
        list.add("Item 2");

        list.add("Item 3");
        list.add("Item 4");

        list.add("Item 5");
        list.add("Item 6");

        list.add("Item 7");
        list.add("Item 8");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,list);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"Position "+String.valueOf(spinner.getSelectedItem()),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//-----------------------

        radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.radioButton){
                    Toast.makeText(getApplicationContext(),"1",Toast.LENGTH_SHORT).show();
                }
                else if(checkedId==R.id.radioButton2){
                    Toast.makeText(getApplicationContext(),"2",Toast.LENGTH_SHORT).show();
                }
                else if(checkedId==R.id.radioButton3){
                    Toast.makeText(getApplicationContext(),"3",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                Toast.makeText(getApplicationContext(),"Hola esto es un Toast", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                texto2.setText("Este texto lo puse yo");
                break;
            case R.id.button3:
                imagen.setImageResource(R.drawable.mayte);
                break;
            //----------------
            case  R.id.btnNuevo:
                Intent intent = new Intent(this,MainActivity2Activity.class);
                String dato = editText.getText().toString();
                intent.putExtra("DATO",dato);
                startActivity(intent);

                break;
            default:
                break;
        }
    }


}
