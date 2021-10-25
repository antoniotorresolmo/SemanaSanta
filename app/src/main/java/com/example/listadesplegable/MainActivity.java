package com.example.listadesplegable;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner lColores = findViewById(R.id.spinner);
        ImageView imgHermandad = findViewById(R.id.imgHermandad);
        TextView lblFundacion = findViewById(R.id.lblFundacion);
        TextView lblNazarenos = findViewById(R.id.lblNazarenos);
        TextView lblDuracion = findViewById(R.id.lblDuracion);
        TextView lblTunica = findViewById(R.id.lblTunica);

        lColores.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String[] sDatos = rellenarDatos(i);

                String sFundacion = "Fundacion: " + sDatos[0];
                String sNazarenos = "Nazarenos: " + sDatos[1];
                String sDuracion = "Duración: " + sDatos[2];
                String sTunica = "Túnica: " + sDatos[3];

                lblFundacion.setText(sFundacion);
                lblNazarenos.setText(sNazarenos);
                lblDuracion.setText(sDuracion);
                lblTunica.setText(sTunica);

                imgHermandad.setImageResource(cambiarImagen(i));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private int cambiarImagen(int iPosicion) {

        int iImagen = 0;

        switch (iPosicion){
            case 0:
                iImagen = R.drawable.cautivo;
                break;
            case 1:
                iImagen = R.drawable.beso_judas;
                break;
            case 2:
                iImagen = R.drawable.santa_genoveva;
                break;
            case 3:
                iImagen = R.drawable.santa_marta;
                break;
        }

        return iImagen;

    }

    private static String[] rellenarDatos(int iPosicion){

        String[] sResultado = new String[4];

        switch (iPosicion){
            case 0:
                sResultado[0] = "1979";
                sResultado[1] = "1.000";
                sResultado[2] = "35 min.";
                sResultado[3] = "Beige claro";
                break;
            case 1:
                sResultado[0] = "1956";
                sResultado[1] = "1.350";
                sResultado[2] = "52 min.";
                sResultado[3] = "Blanca";
                break;
            case 2:
                sResultado[0] = "1956";
                sResultado[1] = "1.700";
                sResultado[2] = "68 min.";
                sResultado[3] = "Blanca";
                break;
            case 3:
                sResultado[0] = "1946";
                sResultado[1] = "1.000";
                sResultado[2] = "30 min.";
                sResultado[3] = "Negra";
                break;
        }

        return sResultado;

    }
}