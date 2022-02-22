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
import java.util.Date;
import java.util.HashMap;

import com.example.fituapp.datos.CustomAdapterMarca;
import com.example.fituapp.datos.LoadImage;
import com.example.fituapp.datos.RequestHandler;
import com.example.fituapp.modelo.Marca;
import com.example.fituapp.modelo.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MarcasUsuario extends AppCompatActivity {


        private ArrayList<Marca> mArrayList = new ArrayList<>();
        private RecyclerView mRecyclerView1;
        private CustomAdapterMarca mAdapter;
        private TextView tvUsername_marcas;
        public static final String URL_OBTENER_MARCAS = "https://nachodb.000webhostapp.com/FIT4YOU/getMarcasPDO.php";
        public static int id_usuario= 0;

        public ArrayList<Marca> marcas;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_marcas_usuario);
            tvUsername_marcas = findViewById(R.id.tvUsername_marcas);
            tvUsername_marcas.setText(PerfilUsuario.usu_loggeado.getLogin_usuario());
            id_usuario = PerfilUsuario.usu_loggeado.getId_usuario();
            mRecyclerView1 =  findViewById(R.id.rvMarcas);
            ImageView img = findViewById(R.id.iv_foto_marcas);

            new LoadImage(img).execute(PerfilUsuario.usu_loggeado.getFoto());
            obtenerMarcas();


        }

        private ArrayList<Marca> getData() {   // array de prueba
            Marca marca = null;
            marca = new Marca("San Silvestre", "10K", "35'57''");
            mArrayList.add(marca);
            Marca marca1 = new Marca("Pista", "800m", "2'40''");
            mArrayList.add(marca1);
            return mArrayList;
        }

    public void obtenerMarcas(){
        if (id_usuario==0){
            Toast.makeText(MarcasUsuario.this, "Ha ocurrido un error, Id igual a 0", Toast.LENGTH_LONG).show();
        }else{
            class ObtenerMarcas extends AsyncTask<Void, Void, String> {
                ProgressDialog pdLoading = new ProgressDialog(MarcasUsuario.this);

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
                    params.put("id_usuario", LoginActivity.sId_usuario);


                    //returing the response
                    String request = requestHandler.sendPostRequest(URL_OBTENER_MARCAS, params);
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
                            JSONArray jsonArray = obj.getJSONArray("Marcas");

                            marcas = new ArrayList<>();
                            for (int i=0;i<jsonArray.length();i++){
                                Marca marca = new Marca();

                                marca.setId_marca(jsonArray.getJSONObject(i).getInt("Id_marca"));
                                marca.setMarca(jsonArray.getJSONObject(i).getString("Marca"));
                                marca.setCarrera(jsonArray.getJSONObject(i).getString("Carrera"));

                                String fecha = jsonArray.getJSONObject(i).getString("Fecha_marca");
                                DateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
                                marca.setFecha_marca(simpleDateFormat.parse(fecha));

                                marca.setDistancia(jsonArray.getJSONObject(i).getString("Distancia"));
                                marca.setId_usuario(jsonArray.getJSONObject(i).getInt("Id_usuario"));
                                marca.setMejor_marca(jsonArray.getJSONObject(i).getInt("Mejor_marca"));
                                marcas.add(marca);
                            }
                            // use this setting to improve performance if you know that changes
                            // in content do not change the layout size of the RecyclerView
                            mRecyclerView1.setHasFixedSize(true);

                            // use a linear layout manager
                            mRecyclerView1.setLayoutManager(new LinearLayoutManager(MarcasUsuario.this));

                            // specify an adapter with the list to show
                            mAdapter = new CustomAdapterMarca(marcas);
                            mRecyclerView1.setAdapter(mAdapter);



                            //finish();
                            Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_LONG).show();


                        }
                    } catch (JSONException | ParseException e) {
                        e.printStackTrace();
                      //  Toast.makeText(MarcasUsuario.this, "Exception: " + e, Toast.LENGTH_LONG).show();
                    }
                }
            }
            ObtenerMarcas obtenerMarcas = new ObtenerMarcas();
            obtenerMarcas.execute();
        }
    }




        public void onClick(View view){

            Intent intent = new Intent(this, PerfilUsuario.class);
            startActivity(intent);
        }
    }