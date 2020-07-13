package es.eduardsanz.widgets;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Size;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Scroller;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RatingBar nota = null;
    private TextView titulo = null;
    private TextView descripcion = null;
   // private Scroller elementos = null;
    private RadioGroup grupo = null;
    private CheckBox color = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titulo = (TextView) findViewById(R.id.textView);
        descripcion = (TextView) findViewById(R.id.textView2);

        titulo.setText("Producto 1");
        titulo.setInputType(InputType.TYPE_CLASS_NUMBER);
        titulo.setTextColor(Color.BLUE);
        titulo.setTextSize(20);

        descripcion.setText("Este es el primer producto que vendemos, es una pasada\n Por favor haz tu compra ya.\n Quedan pocos....");

        nota = (RatingBar) findViewById(R.id.ratingBar);

        nota.setRating(4);

        grupo = (RadioGroup) findViewById(R.id.grupo);

        for (int i=0; i<20; i++)
        {
            RadioButton radio = new RadioButton(this);
            radio.setText("Caracteristica "+i);

            grupo.addView(radio);
        }

        color = (CheckBox) findViewById(R.id.checkBox);

        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (color.isChecked())
                {
                    titulo.setTextColor(Color.RED);
                }
                else
                    titulo.setTextColor(Color.BLUE);
            }
        });

    }
}
