package es.eduardsanz.pestanas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Textos extends AppCompatActivity {

    private TextView Titulo;
    private TextView Cuerpo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textos);

        Intent intent = getIntent();
        texto Noticia = intent.getParcelableExtra("NOTICIA");

        Titulo = (TextView) findViewById(R.id.titulo);
        Cuerpo = (TextView) findViewById(R.id.contenido);

        Titulo.setText(Noticia.getTitulo());
        Cuerpo.setText(Noticia.getContenido());
    }
}
