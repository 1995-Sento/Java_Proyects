package com.example.sento.examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class a_hombre extends AppCompatActivity {
    private EditText Nombre =null;
    private EditText Apellido = null;
    private EditText Telefono = null;
    private Button Aceptar= null;
    private Button Cancelar=null;
    private TextView Error = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_hombre);

        Nombre=(EditText)findViewById(R.id.Nombre);
        Apellido=(EditText)findViewById(R.id.Apellido);
        Telefono=(EditText)findViewById(R.id.Telefono);
        Aceptar=(Button)findViewById(R.id.Aceptar);
        Cancelar=(Button)findViewById(R.id.Cancelar);
        Error=(TextView)findViewById(R.id.Error);
        Intent intent = getIntent();
        Bundle bundle =intent.getExtras();


        Cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
        Aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Nombre.getText().toString().equals("") ) || (Nombre.getText().toString().equals(null)))
                {
                    Error.setText("El Campo Nombre No puede Estar Vacio, Es Obligattorio");

                    return;
                }
                if ((Apellido.getText().toString().equals("")) || (Apellido.getText().toString().equals(null)))
                {
                    Error.setText("El Campo Apellidos No puede Estar Vacio, Es Obligattorio");
                    return;
                }
                if (Telefono.getText().toString().equals(null))
                {
                    Telefono.setText("");
                }
                // TODO CORRECTO, MONTO LOS PARÁMETROS A DEVOLVER
                String resultado = "Nombre: "+Nombre.getText()+"\nApellidos: "+Apellido.getText()+"\nTelefono: "+Telefono.getText();
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
