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
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2Activity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button boton1,boton2;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

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

        onCreateDialog(0).show();
    }

//    -----------------
}
