package com.example.ravin.unpocodetodo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Carrito extends AppCompatActivity {

    TextView tvTitulo;
    ListView lvCompra;
    ArrayList<Strain> strains;
    ArrayList<Integer> punteros;
    ArrayList<String> listaCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        tvTitulo = findViewById(R.id.tvTitulo);
        lvCompra = findViewById(R.id.lvCompra);

        strains = new ArrayList<>();
        punteros = new ArrayList<>();
        listaCompra = new ArrayList<>();

        strains = (ArrayList)getIntent().getExtras().getParcelableArrayList("listaStrains");
        punteros = (ArrayList) getIntent().getExtras().getParcelableArrayList("listaPunteros");

        int i = 0;
        for(Strain s : strains){
            for(Integer j : punteros){
                if(i == j)
                    listaCompra.add(s.getNombre().toString());


            }
            i++;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listaCompra);
        lvCompra.setAdapter(adapter);

        lvCompra.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}
