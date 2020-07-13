package es.eduardsanz.blocdenotas;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup color = null;
    private EditText campoTitulo = null;
    private EditText campoContenido = null;
    private int seleccionado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        color = (RadioGroup) findViewById(R.id.color);



        campoTitulo = (EditText) findViewById(R.id.campoTitulo);
        campoContenido = (EditText) findViewById(R.id.contenido);

    }

    public void cambia_color(View view)
    {
        seleccionado = color.getCheckedRadioButtonId();
        switch (seleccionado)
        {
            case R.id.radioButton:
                    campoTitulo.setTextColor(Color.RED);
                    campoContenido.setTextColor(Color.RED);
                break;
            case R.id.radioButton2:
                campoTitulo.setTextColor(Color.BLUE);
                campoContenido.setTextColor(Color.BLUE);
                break;
            default:
                campoTitulo.setTextColor(Color.BLACK);
                campoContenido.setTextColor(Color.BLACK);
                break;
        }
    }
}
