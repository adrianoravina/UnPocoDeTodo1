package com.example.ravin.unpocodetodo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class Detalle extends AppCompatActivity {

    ImageView ivFoto;
    TextView tvNombre;
    ImageButton ibForward, ibBack;
    ArrayList<Strain>strains;
    ArrayList<Integer> punteros;

    int puntero;
    int totalStrains;
    int numCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        strains = new ArrayList<>();
        punteros = new ArrayList<>();


        ivFoto = findViewById(R.id.ivFoto);
        tvNombre = findViewById(R.id.tvNombre);
        ibBack = findViewById(R.id.ibBack);
        ibForward = findViewById(R.id.ibForward);

        Strain obj = (Strain)getIntent().getExtras().getSerializable("objeto");

        ivFoto.setImageResource(obj.getImagen());
        tvNombre.setText("Nombre: "+obj.getNombre());

        strains = (ArrayList)getIntent().getExtras().getParcelableArrayList("lista");

        //System.out.println("LISTAA!!!"+strains.get(2).getNombre());
        int i = 0;
        for(Strain str : strains){
            if(str.getNombre().equalsIgnoreCase(obj.getNombre()))
                puntero = i;
            i++;
        }
        totalStrains = strains.size();

        numCompra = getIntent().getExtras().getInt("numCompra");

        punteros = (ArrayList) getIntent().getExtras().getParcelableArrayList("listaPunteros");

    }

    public void forward(View view){

        puntero--;

        if(puntero == -1)
            puntero = totalStrains-1;

        tvNombre.setText("Nombre: "+strains.get(puntero).getNombre());
        ivFoto.setImageResource(strains.get(puntero).getImagen());
    }

    public void back(View view){



        puntero++;

        if(puntero == totalStrains)
            puntero = 0;

        tvNombre.setText("Nombre: "+strains.get(puntero).getNombre());
        ivFoto.setImageResource(strains.get(puntero).getImagen());
    }

    public void carrito(View view){
        numCompra++;
        punteros.add(puntero);
        Intent paso = new Intent(getApplicationContext(), MainActivity.class);
        paso.putExtra("listaPunteros", punteros);
        paso.putExtra("numCompra", numCompra);
        startActivity(paso);
    }
}
