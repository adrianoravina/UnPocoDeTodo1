package com.example.ravin.unpocodetodo1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ravin on 27/02/2018.
 */

public class Adaptador extends BaseAdapter{

    Context contexto;
    List<Strain> lista;

    public Adaptador(Context contexto, List<Strain> lista) {
        this.contexto = contexto;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Strain getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View vista=view;
        LayoutInflater inflate = LayoutInflater.from(contexto); //Obtenemos el contexto del item sobre el cual estamos trabajando del ListView
        vista=inflate.inflate(R.layout.list_item, null); //Consigo referenciar a la vista en sí

        ImageView imagen = vista.findViewById(R.id.ivStrain);
        TextView tvDescripcion = vista.findViewById(R.id.tvDescripcion);

        imagen.setImageResource(lista.get(i).getImagen());
        tvDescripcion.setText("Nombre: "+lista.get(i).getNombre()+" \t"+tvDescripcion.getText() + lista.get(i).getDescripcion());

        return vista;
    }
}
