package com.example.n3153r.curso1;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity2Activity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button boton1,boton2;
    Context context = this;

    Button boton;
    AutoCompleteTextView auto;
    TextView textAuto;

    String[] nombre = {"Neiser","Hans", "Carmen","Jhan", "Katia","Elvis"};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        listView =(ListView) findViewById(R.id.listView);

//        Autocompletar texto

        boton = (Button) findViewById(R.id.btnComp);
        auto = (AutoCompleteTextView) findViewById(R.id.auto);
        textAuto = (TextView) findViewById(R.id.textView);

        boton.setOnClickListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,nombre);
        auto.setThreshold(3);
        auto.setAdapter(adapter);


//        -----------
//        BOTON DIALOG

        boton1 = (Button) findViewById(R.id.btnClick);

        boton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setMessage("Mensaje")
                        .setCancelable(false)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Lo que quieras hace cuando se da click a "SI"
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Lo que quieras hace cuando se da click a "SI"
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialogBuilder.show();
            }
        });

//        --------------
        textView =(TextView) findViewById(R.id.texto);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        if(bundle!=null){
            String cadena = (String) bundle.get("DATO");
            textView.setText(cadena);

        }
//-------------------------------
//        BOTON DIALOGO IMAGEN

        boton2 = (Button) findViewById(R.id.btnClick2);
        boton2.setOnClickListener(this);

    }

    protected Dialog onCreateDialog(int id){
        Dialog dialog = null;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder = builder.setIcon(R.drawable.mayte);
        builder = builder.setTitle("Mi primer dialogo");

        dialog = builder.create();

        return dialog;
    }

    @Override
    public void onClick(View v) {



        switch (v.getId()){
            case R.id.btnComp:
                String cambio= auto.getText().toString();
                textAuto.setText(cambio);

                break;
            case R.id.btnClick:
                onCreateDialog(0).show();
                break;
            case R.id.btnClick2:
                onCreateDialog(0).show();
                break;
        }


    }

//    -----------------
}
