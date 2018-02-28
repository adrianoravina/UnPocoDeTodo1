package com.example.ravin.unpocodetodo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView lvTop;
    ArrayList<Strain> strains;
    ArrayList<Integer>punteros;
    TextView tvSeleccionado, tvTop, tvBienvenido;
    int numCompra;
    int puntero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvTop = findViewById(R.id.lvTop);
        tvSeleccionado = findViewById(R.id.tvSeleccionados);
        tvTop = findViewById(R.id.tvTop);
        tvBienvenido = findViewById(R.id.tvBienvenido);


        strains = new ArrayList<>();
        punteros = new ArrayList<>();

        strains.add(new Strain("Super Silver Haze", "Sativa dominante, hibrido con efecto feliz", R.drawable.silver));
        strains.add(new Strain("Hawaiian", "Sativa feliz, eleccion perfecta para una velada por la ciudad", R.drawable.hawaiian));
        strains.add(new Strain("Laughing Buddha", "Risas aseguradas", R.drawable.buddha));
        strains.add(new Strain("Chronic", "Hibrido clasico, fumada guay", R.drawable.chronic));
        strains.add(new Strain("Girl Scout Cookies", "Efecto cerebral potente", R.drawable.girl));
        strains.add(new Strain("Chocolope", "Se parece al café, prueba el intercambio cada mañana", R.drawable.chocolope));
        strains.add(new Strain("Agent Orange", "Citrico", R.drawable.agent));
        strains.add(new Strain("Strawberry Cough", "Potente, energizante, fumadon", R.drawable.strawberry));

        Adaptador adapter = new Adaptador(getApplicationContext(), strains);

        lvTop.setAdapter(adapter);

        lvTop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Strain obj = (Strain)adapterView.getItemAtPosition(i);

                Intent paso = new Intent(getApplicationContext(), Detalle.class);
                paso.putExtra("objeto", (Serializable)obj);
                paso.putExtra("lista", strains);
                paso.putExtra("numCompra", numCompra);
                paso.putExtra("listaPunteros", punteros);
                startActivity(paso);
            }
        });

        try{
            Bundle bundle = getIntent().getExtras();
            puntero = bundle.getInt("compra");
            numCompra = bundle.getInt("numCompra");
            punteros = bundle.getIntegerArrayList("listaPunteros");

            for(Integer num : punteros){
                System.out.println("puntero: "+num+"");
            }
        }catch(Exception e){
            numCompra = 0;
        }


        tvSeleccionado.setText(tvSeleccionado.getText()+" "+numCompra);
    }

    public void mostrar(View view){

        Intent paso = new Intent(getApplicationContext(), Carrito.class);
        paso.putExtra("listaStrains", strains);
        paso.putExtra("listaPunteros", punteros);
        startActivity(paso);
    }

}
