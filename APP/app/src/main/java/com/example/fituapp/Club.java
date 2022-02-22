package com.example.fituapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.fituapp.datos.CustomAdapterMarca;
import com.example.fituapp.datos.CustomAdapterUser;

import com.example.fituapp.datos.LoadImage;
import com.example.fituapp.datos.RequestHandler;
import com.example.fituapp.modelo.Marca;
import com.example.fituapp.modelo.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Club extends AppCompatActivity {

    private ArrayList<Usuario> mArrayList = new ArrayList<>();
    private RecyclerView mRecyclerView1;
    private CustomAdapterUser mAdapter;
    private TextView tv_username_club;

    public static final String URL_OBTENER_USUARIOS_CLUB = "https://nachodb.000webhostapp.com/FIT4YOU/getClub.php";
    public static int id_usuario= 0;

    public ArrayList<Usuario> usuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);
        id_usuario = PerfilUsuario.usu_loggeado.getId_usuario();
        ImageView img = findViewById(R.id.iv_small_club);
        new LoadImage(img).execute(PerfilUsuario.usu_loggeado.getFoto());
        tv_username_club = findViewById(R.id.tv_user_club);
        tv_username_club.setText(PerfilUsuario.usu_loggeado.getLogin_usuario());

        mRecyclerView1 =  findViewById(R.id.rv);
        obtenerUsuariosClub();













    }

    private ArrayList<Usuario> getData() {
        Usuario user = null;
        user = new Usuario("David", "eladmindd@gmail.com", "612345678");
        mArrayList.add(user);
        Usuario user1 = null;
        user1 = new Usuario("Adri", "eladri@gmail.com", "611223344");
        mArrayList.add(user1);
        return mArrayList;
    }

    public void obtenerUsuariosClub() {
        if (id_usuario == 0) {
            Toast.makeText(Club.this, "Ha ocurrido un error, Id igual a 0", Toast.LENGTH_LONG).show();
        } else {
            class ObtenerUsuariosClub extends AsyncTask<Void, Void, String> {
                ProgressDialog pdLoading = new ProgressDialog(Club.this);

                @Override
                protected void onPreExecute() {
                    super.onPreExecute();

                    //this method will be running on UI thread
                    pdLoading.setMessage("\tLoading...");
                    pdLoading.setCancelable(false);
                    pdLoading.show();
                }

                @Override
                protected String doInBackground(Void... voids) {
                    //creating request handler object
                    RequestHandler requestHandler = new RequestHandler();

                    //creating request parameters
                    HashMap<String, String> params = new HashMap<>();
                    //params.put("id_usuario", LoginActivity.sId_usuario);


                    //returing the response
                    String request = requestHandler.sendPostRequest(URL_OBTENER_USUARIOS_CLUB, params);
                    Log.e("error", request);
                    return request;
                }

                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                    pdLoading.dismiss();

                    try {
                        //converting response to json object
                        JSONObject obj = new JSONObject(s);
                        //if no error in response
                        if (!obj.getBoolean("error")) {
                            JSONArray jsonArray = obj.getJSONArray("Usuarios");

                            usuarios = new ArrayList<>();
                            for (int i = 0; i < jsonArray.length(); i++) {

                                Usuario usuario = new Usuario();
                                usuario.setId_usuario(jsonArray.getJSONObject(i).getInt("Id_usuario"));
                                usuario.setLogin_usuario(jsonArray.getJSONObject(i).getString("Username"));
                                usuario.setNombre_usuario(jsonArray.getJSONObject(i).getString("Nombre"));
                                usuario.setEmail(jsonArray.getJSONObject(i).getString("email"));
                                usuario.setDieta(jsonArray.getJSONObject(i).getInt("Dieta"));
                                usuario.setEntrenamiento(jsonArray.getJSONObject(i).getInt("Entrenamiento"));
                                usuario.setActivo(jsonArray.getJSONObject(i).getInt("Activo"));
                                usuario.setTelefono(jsonArray.getJSONObject(i).getInt("Telefono"));
                                usuario.setFoto(jsonArray.getJSONObject(i).getString("Foto"));
                                usuario.setEdad(jsonArray.getJSONObject(i).getInt("Edad"));


                                //String fecha = jsonArray.getJSONObject(i).getString("Fecha_marca");
                                //DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                //marca.setFecha_marca(simpleDateFormat.parse(fecha));


                                usuarios.add(usuario);
                            }
                            // use this setting to improve performance if you know that changes
                            // in content do not change the layout size of the RecyclerView
                            mRecyclerView1.setHasFixedSize(true);

                            // use a linear layout manager
                            mRecyclerView1.setLayoutManager(new LinearLayoutManager(Club.this));

                            // specify an adapter with the list to show
                            mAdapter = new CustomAdapterUser(usuarios);
                            mRecyclerView1.setAdapter(mAdapter);

                            ImageView img = findViewById(R.id.iv_foto_marcas);
                            new LoadImage(img).execute(PerfilUsuario.usu_loggeado.getFoto());

                            //finish();
                            //Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_LONG).show();


                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                     //   Toast.makeText(Club.this, "Exception: " + e, Toast.LENGTH_LONG).show();
                    }
                }
            }
            ObtenerUsuariosClub obtenerUsuariosClub = new ObtenerUsuariosClub();
            obtenerUsuariosClub.execute();
        }

    }
    public void onClick(View view){

        Intent intent = new Intent(this, PerfilUsuario.class);
        startActivity(intent);
    }
}