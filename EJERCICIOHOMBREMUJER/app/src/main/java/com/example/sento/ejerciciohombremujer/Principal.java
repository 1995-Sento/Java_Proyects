package com.example.sento.ejerciciohombremujer;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    // Atributos de Hombre o Mujer
    private static final int hombre = 1;
    private static final int mujer = 2;


    // Defino los Elementos de las Vistas
    private Button insertarHombre = null;
    private Button insertarMujer = null;
    private LinearLayout contenedorHombre=null;
    private LinearLayout contenedorMujeres = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        // Ya tengo Acceso a los Elementos de la Interfaz
        insertarHombre = (Button) findViewById(R.id.hombre);
        insertarMujer = (Button) findViewById(R.id.mujer);
        contenedorHombre = (LinearLayout) findViewById(R.id.contenedor_hombres);
        contenedorMujeres = (LinearLayout) findViewById(R.id.contenedor_mujeres);



        View.OnClickListener clic = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Principal.this, Insertar.class);
                Bundle b = new Bundle();
                switch (v.getId())
                {
                    case R.id.hombre:
                        b.putInt("GENERO",hombre);
                        i.putExtras(b);
                        startActivityForResult(i, hombre);
                        break;
                    case R.id.mujer:
                        b.putInt("GENERO",mujer);
                        i.putExtras(b);
                        startActivityForResult(i,mujer);
                        break;
                }

            }
        };

        this.insertarHombre.setOnClickListener(clic);
        this.insertarMujer.setOnClickListener(clic);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == hombre) {
            if (resultCode == RESULT_OK)
            {
                TextView nuevo_hombre = new TextView(this);
                nuevo_hombre.setText(data.getExtras().getString("RESULTADO"));
                contenedorHombre.addView(nuevo_hombre);
            }
        }
        if (requestCode == mujer) {
            if (resultCode == RESULT_OK)
            {
                TextView nuevo_mujer = new TextView(this);
                nuevo_mujer.setText(data.getExtras().getString("RESULTADO"));
                contenedorMujeres.addView(nuevo_mujer);
            }
        }



    }
}
