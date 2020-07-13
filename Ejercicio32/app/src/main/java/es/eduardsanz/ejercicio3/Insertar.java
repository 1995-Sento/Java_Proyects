package es.eduardsanz.ejercicio3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Insertar extends AppCompatActivity {

    // Defino los elementos de las Vistas
    private EditText nombre = null;
    private EditText apellidos = null;
    private EditText telefono = null;
    private Button aceptar = null;
    private Button cancelar = null;
    private TextView error = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);

        // Obtengo acceso a los Objetos de las Vistas
        nombre = (EditText) findViewById(R.id.nombre);
        apellidos = (EditText) findViewById(R.id.apellidos);
        telefono = (EditText) findViewById(R.id.telefono);
        aceptar = (Button) findViewById(R.id.aceptar);
        cancelar = (Button) findViewById(R.id.cancelar);
        error = (TextView) findViewById(R.id.error);

        // Compruebo si me insrtar un hombre o una mujer.
        // Obtengo el Intent de la actividad anterior
        Intent intent = getIntent();
        // Obtengo los Datos del Intent
        Bundle bundle = intent.getExtras();
        // compruebo el Género
        int genero = bundle.getInt("GENERO");
        // si el Genero en 2 (mujer) desactivo el teléfono
        if (genero == 2)
        {
            telefono.setText("");
            telefono.setVisibility(View.INVISIBLE);
        }

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("CONTROL","Estoy dentro del Boton");
                Log.e("CONTROL", "Nombre: "+nombre.getText().toString());
                /*
                *   Comprobamos Condiciones de Lógica de Aplicación
                * */
                if ((nombre.getText().toString() == "") || (nombre.getText().toString()==null))
                {
                    error.setText("El Campo Nombre No puede Estar Vacio, Es Obligattorio");
                    Log.e("CONTROL","Estoy dentro del IF");
                    return;
                }
                if ((apellidos.getText().toString() == "") || (apellidos.getText().toString()==null))
                {
                    error.setText("El Campo Apellidos No puede Estar Vacio, Es Obligattorio");
                    return;
                }
                if (telefono.getText().toString()==null)
                {
                    telefono.setText("");
                }
                // TODO CORRECTO, MONTO LOS PARÁMETROS A DEVOLVER
                String resultado = "Nombre: "+nombre.getText()+"\nApellidos: "+apellidos.getText()+"\nTelefono: "+telefono.getText();
                Intent intent1= new Intent();
                Bundle bundle1 = new Bundle();
                bundle1.putString("RESULTADO", resultado);
                intent1.putExtras(bundle1);
                setResult(RESULT_OK, intent1);
                finish();
            }
        });

    }
}
