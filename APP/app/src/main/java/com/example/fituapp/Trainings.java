package com.example.fituapp;


import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import com.example.fituapp.datos.LoadImage;
import com.example.fituapp.datos.RequestHandler;
import com.example.fituapp.modelo.Entrenamiento;


public class Trainings extends AppCompatActivity {

    private TextView tv_lunes;
    private TextView tv_martes;
    private TextView tv_miercoles;
    private TextView tv_jueves;
    private TextView tv_viernes;
    private TextView tv_sabado;
    private TextView tv_domingo;
    private TextView tv_user_trainings;


    private int id_usuario;
    public static final String URL_OBTENER_ENTRENAMIENTOS = "https://nachodb.000webhostapp.com/FIT4YOU/getEntrenamientos.php";
    private Entrenamiento entreno_actual;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainings);

        tv_user_trainings = findViewById(R.id.tv_user_entrenos);
        tv_user_trainings.setText(PerfilUsuario.usu_loggeado.getLogin_usuario());
        tv_lunes = findViewById(R.id.tvEjercLun);
        tv_martes = findViewById(R.id.tvEjercMar);
        tv_miercoles= findViewById(R.id.tvEjercMie);
        tv_jueves = findViewById(R.id.tvEjercJue);
        tv_viernes = findViewById(R.id.tvEjercVie);
        tv_sabado = findViewById(R.id.tvEjercSab);
        tv_domingo = findViewById(R.id.tvEjercDom);
        id_usuario = PerfilUsuario.id_usuario;
        ImageView img = findViewById(R.id.id_small_training);
        new LoadImage(img).execute(PerfilUsuario.usu_loggeado.getFoto());

        obtenerEntrenamientos();





    }

    public void onClick(View view){

        Intent intent = new Intent(this, PerfilUsuario.class);
        startActivity(intent);
    }

    public void obtenerEntrenamientos(){
        if (id_usuario==0){
            Toast.makeText(Trainings.this, "Ha ocurrido un error, Id igual a 0", Toast.LENGTH_LONG).show();
        }else{
            class ObtenerEntrenamientos extends AsyncTask<Void, Void, String> {
                ProgressDialog pdLoading = new ProgressDialog(Trainings.this);

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
                    String request = requestHandler.sendPostRequest(URL_OBTENER_ENTRENAMIENTOS, params);
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
                            entreno_actual = new Entrenamiento();
                            entreno_actual.setId_usuario(id_usuario);
                            entreno_actual.setId_entrenamiento(obj.getInt("id_entrenamiento"));
                            String[] entrenos = new String[7];
                            entrenos[0] = obj.getString("lunes");
                            entrenos[1] = obj.getString("martes");
                            entrenos[2] = obj.getString("miercoles");
                            entrenos[3] = obj.getString("jueves");
                            entrenos[4] = obj.getString("viernes");
                            entrenos[5] = obj.getString("sabado");
                            entrenos[6] = obj.getString("domingo");

                            entreno_actual.setEntrenos(entrenos);
                            entreno_actual.setSemana(obj.getString("semana"));
                            entreno_actual.setMensual(obj.getString("mensual"));

                            tv_lunes.setText(entreno_actual.getEntrenos()[0]);
                            tv_martes.setText(entreno_actual.getEntrenos()[1]);
                            tv_miercoles.setText(entreno_actual.getEntrenos()[2]);
                            tv_jueves.setText(entreno_actual.getEntrenos()[3]);
                            tv_viernes.setText(entreno_actual.getEntrenos()[4]);
                            tv_sabado.setText(entreno_actual.getEntrenos()[5]);
                            tv_domingo.setText(entreno_actual.getEntrenos()[6]);

                            tv_user_trainings.setText(PerfilUsuario.usu_loggeado.getLogin_usuario());



                         //   Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_LONG).show();

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                     //   Toast.makeText(Trainings.this, "Exception: " + e, Toast.LENGTH_LONG).show();
                    }
                }
            }
            ObtenerEntrenamientos obtenerEntrenamientos = new ObtenerEntrenamientos();
            obtenerEntrenamientos.execute();
        }
    }

}