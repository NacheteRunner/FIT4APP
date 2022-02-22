package com.example.fituapp;


import static com.example.fituapp.LoginActivity.sId_usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import com.example.fituapp.datos.LoadImage;
import com.example.fituapp.datos.RequestHandler;
import com.example.fituapp.modelo.Usuario;

public class PerfilUsuario extends AppCompatActivity {

    private ImageButton ibDietas;
    private ImageButton ibEntrenamientos;
    private ImageButton ibMarcas;
    private ImageButton ibClub;
    private ImageView iv_foto;
    private TextView tv_login;
    public static final String URL_OBTENER_USUARIOS = "https://nachodb.000webhostapp.com/FIT4YOU/getUsuarios.php";
    public static final String URL_IMAGENES = "https://nachodb.000webhostapp.com/FIT4YOU/imagenes/";
    public static int id_usuario= 0;
    public static Usuario usu_loggeado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);

        ibDietas = findViewById(R.id.ibDietas);
        ibEntrenamientos = findViewById(R.id.ibEntrenamientos);
        ibMarcas = findViewById(R.id.ibMarcas);
        ibClub = findViewById(R.id.ibClub);
        iv_foto = findViewById(R.id.iv_foto);
        tv_login = findViewById(R.id.tvUsername_marcas);

        tv_login.setText(LoginActivity.username);
        id_usuario = Integer.valueOf(sId_usuario);
        obtenerUsuarios();
        //String is = aPHP.ejecutar("http://"+IP+"/imagen.php");
        //ImageView img = findViewById(R.id.img);
        //new LoadImage(img).execute(is);
        ibDietas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PerfilUsuario.this, DietaUsuario.class);
                startActivity(intent);
            }
        });

        ibEntrenamientos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(PerfilUsuario.this, Trainings.class);
                startActivity(intent2);
            }
        });

        ibMarcas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(PerfilUsuario.this, MarcasUsuario.class);
                startActivity(intent3);
            }
        });

        ibClub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(PerfilUsuario.this, Club.class);
                startActivity(intent4);
            }
        });
    }

    public void obtenerUsuarios(){
        if (id_usuario==0){
            Toast.makeText(PerfilUsuario.this, "Ha ocurrido un error, Id igual a 0", Toast.LENGTH_LONG).show();
        }else{
            class ObtenerUsuarios extends AsyncTask<Void, Void, String> {
                ProgressDialog pdLoading = new ProgressDialog(PerfilUsuario.this);

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
                    params.put("id_usuario", sId_usuario);


                    //returing the response
                    String request = requestHandler.sendPostRequest(URL_OBTENER_USUARIOS, params);
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
                            usu_loggeado = new Usuario();
                            usu_loggeado.setId_usuario(id_usuario);
                            usu_loggeado.setLogin_usuario(obj.getString("username"));;
                            usu_loggeado.setActivo(obj.getInt("activo"));
                            usu_loggeado.setDieta(obj.getInt("dieta"));
                            String imagen = obj.getString("foto");
                            imagen = URL_IMAGENES + imagen;
                            Log.e("error", imagen);
                            usu_loggeado.setFoto(imagen);
                            ImageView img = findViewById(R.id.iv_foto);
                            new LoadImage(img).execute(usu_loggeado.getFoto());




                            //finish();
                         //   Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_LONG).show();


                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                       // Toast.makeText(PerfilUsuario.this, "Exception: " + e, Toast.LENGTH_LONG).show();
                    }
                }
            }
            ObtenerUsuarios obtenerUsuarios = new ObtenerUsuarios();
            obtenerUsuarios.execute();
        }
    }
}