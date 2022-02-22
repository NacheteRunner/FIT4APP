package com.example.fituapp.datos;



import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fituapp.PerfilUsuario;
import com.example.fituapp.R;

import java.util.ArrayList;

import com.example.fituapp.modelo.Usuario;

public class CustomAdapterUser extends RecyclerView.Adapter<CustomAdapterUser.ViewHolder> {

    public static final String URL_IMAGENES = "https://nachodb.000webhostapp.com/FIT4YOU/imagenes/";

    private ArrayList<Usuario> arrayList = new ArrayList<>();

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName;
        private final TextView textViewMail;
        private final TextView textViewTelefono;
        private final ImageView ivUser;




        @SuppressLint("WrongViewCast")
        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textViewName = (TextView) view.findViewById(R.id.tvNombreUser);
            textViewMail = (TextView) view.findViewById(R.id.tvMailUser);
            textViewTelefono = (TextView) view.findViewById(R.id.tvTelefonoUser);
            ivUser = (ImageView) view.findViewById(R.id.ivUser);
        }


    }


    /**
     * Initialize the dataset of the Adapter.
     * @param arrayList
     */
    public CustomAdapterUser(ArrayList<Usuario> arrayList) {
        this.arrayList = arrayList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.user_item, viewGroup, false);

        return new ViewHolder(view);

    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        String nombre = arrayList.get(position).getNombre_usuario();
        String mail = arrayList.get(position).getEmail();
        String telefono = String.valueOf(arrayList.get(position).getTelefono());
        String img = URL_IMAGENES + arrayList.get(position).getFoto();
        viewHolder.textViewName.setText(nombre);
        viewHolder.textViewMail.setText(mail);
        viewHolder.textViewTelefono.setText(telefono);
        new LoadImage(viewHolder.ivUser).execute(img);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}








