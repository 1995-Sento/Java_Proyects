package com.example.eduard.holatio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        //Obtener Objetos del Layout
        TextView txtResult = (TextView) findViewById(R.id.txtResult);
        Button btnVolver = (Button) findViewById(R.id.btnVolver);
        Button btnCerrar = (Button) findViewById(R.id.btnCerrar);

        // Obtengo el Intent Asociado
        Bundle b = this.getIntent().getExtras();

        // Recupero el String del Nombre
        String nombre = b.getString("NOMBRE");
        String opcion = b.getString("OPCION");

        //Inserto el texto
        switch ( opcion){
            case "Saludar":
                txtResult.setText("Hola "+nombre+" BienVenido al Curso");
                break;
            case "Despedir":
                txtResult.setText("Adios "+nombre+" Gracias por Venir");
                break;
        }


        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }

}
