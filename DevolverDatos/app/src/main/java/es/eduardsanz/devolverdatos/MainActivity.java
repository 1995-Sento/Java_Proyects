package es.eduardsanz.devolverdatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultado = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton = (Button) findViewById(R.id.button);

        View.OnClickListener pulsar = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivityForResult(intent, 1);
            }
        };

        resultado = (TextView) findViewById(R.id.resultado);
        boton.setOnClickListener(pulsar);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ((requestCode == 1)&&(resultCode == RESULT_OK))
        {
            if (data != null) {
                Bundle bundle = data.getExtras();
                String nuevo = bundle.getString("NUEVO");

                resultado.setText(nuevo);
            }
        }
    }
}
