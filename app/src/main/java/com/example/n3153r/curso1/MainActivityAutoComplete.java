package com.example.n3153r.curso1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivityAutoComplete extends AppCompatActivity implements View.OnClickListener{

    String[] nombre = {"Neiser","Hans", "Carmen","Jhan", "Katia","Elvis"};

    ListView listView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_auto_complete);



        FrutasVerduras frutasVerdurases_datos[] = new FrutasVerduras[]{
                new FrutasVerduras(R.drawable.ic_launcher,"Manzana"),
                new FrutasVerduras(R.drawable.ic_launcher,"pera"),
                new FrutasVerduras(R.drawable.ic_launcher,"lechuga"),
                new FrutasVerduras(R.drawable.ic_launcher,"limon"),
                new FrutasVerduras(R.drawable.ic_launcher,"tomate"),
        };



        FrutasVerdurasAdapter adapter = new FrutasVerdurasAdapter(this,R.layout.listview_item_row, frutasVerdurases_datos);

        listView =(ListView) findViewById(R.id.listView);

        View header =(View) getLayoutInflater().inflate(R.layout.list_header_row,null);
        listView.addHeaderView(header);
        listView.setAdapter(adapter);

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,nombre);
////        auto.setThreshold(3);
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),String.valueOf(i),Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public void onClick(View view) {

    }
}
