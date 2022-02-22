package com.example.fituapp.datos;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fituapp.R;

import java.util.ArrayList;

import com.example.fituapp.modelo.Marca;

public class CustomAdapterMarca extends RecyclerView.Adapter<CustomAdapterMarca.ViewHolder> {

    private ArrayList<Marca> arrayList = new ArrayList<>();

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvCarrera;
        private final TextView tvDistancia;
        private final TextView tvTiempo;
        private final ImageView ivMarca;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            tvCarrera = (TextView) view.findViewById(R.id.tvCarrera);
            tvDistancia = (TextView) view.findViewById(R.id.tvDistanciaMarca);
            tvTiempo = (TextView) view.findViewById(R.id.tvTiempoMarca);
            ivMarca = (ImageView) view.findViewById(R.id.featured_image);
        }

    }

    /**
     * Initialize the dataset of the Adapter.
     * @param arrayList
     */
    public CustomAdapterMarca(ArrayList<Marca> arrayList) {
        this.arrayList = arrayList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.marca_item, viewGroup, false);

        return new ViewHolder(view);

    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        String carrera = arrayList.get(position).getCarrera();
        String distancia = arrayList.get(position).getDistancia();
        String marca = arrayList.get(position).getMarca();
        viewHolder.tvCarrera.setText(carrera);
        viewHolder.tvDistancia.setText(distancia);
        viewHolder.tvTiempo.setText(marca);
        if(arrayList.get(position).getMejor_marca() == 1){
            viewHolder.ivMarca.setImageResource(R.drawable.trophy);
        }else viewHolder.ivMarca.setImageResource(R.drawable.check);


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}







