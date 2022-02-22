package com.example.fituapp.datos;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class Conexion extends AsyncTask<String, Void, URL> {

    private Exception exception;
    private HttpURLConnection conexion;

    protected URL doInBackground(String... urls) {
        URL url = null;
        try {
            url = new URL(urls[0]);
            conexion = (HttpURLConnection) url.openConnection();


            if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                String linea = reader.readLine();
                if (linea.equals("OK")) {
                    Log.e("Fit4App", "Error en servicio Web Mieva");
                }
            } else {
                Log.e("Fit4App", conexion.getResponseMessage());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.e("Fit4App", e.getMessage(), e);
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Fit4App", e.getMessage(), e);
        } finally {
            if (conexion != null) conexion.disconnect();
        }
        return url;
    }
    protected void onPostExecute(URL url) {
        // TODO: check this.exception
        // TODO: do something with the feed
    }
}


