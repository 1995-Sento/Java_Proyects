package com.example.eduard.holatio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Vamos a Obtener acceso a los elementos del LayOUT
    private EditText txtNombre=null;
    private Button btnBoton=null;
    private Button btnLimpiar=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText)findViewById(R.id.txtName);
        btnBoton = (Button) findViewById(R.id.btnSaludar);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
    }

    public void saludar (View view)
    {
        String PersonaName = txtNombre.getText().toString();

        // Creo el Objeto Contenedor para el nuevo Layout
        Intent intent = new Intent(MainActivity.this, Resultado.class);
        // Creo el contenido del Intent
        Bundle bundle = new Bundle();
        bundle.putString("NOMBRE", PersonaName);
        bundle.putString("OPCION","Saludar");

        //Inserto el contenido en el intent
        intent.putExtras(bundle);

        //Lanzar el nuevo Layout
        startActivity(intent);
    }
    public void adios(View view)
    {
        System.exit(0);
    }

    public  void despedirBtn(View view)
    {
        String PersonaName = txtNombre.getText().toString();

        // Creo el Objeto Contenedor para el nuevo Layout
        Intent intent = new Intent(MainActivity.this, Resultado.class);
        // Creo el contenido del Intent
        Bundle bundle = new Bundle();
        bundle.putString("NOMBRE", PersonaName);
        bundle.putString("OPCION","Despedir");

        //Inserto el contenido en el intent
        intent.putExtras(bundle);

        //Lanzar el nuevo Layout
        startActivity(intent);
    }
}
