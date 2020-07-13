package es.eduardsanz.pestanas;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

import org.w3c.dom.Text;

public class contenedor extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor);

        // Nos Creamos las pestañas
        // 1. Obtener Acceso Al contenedor de pestañas
            TabHost tabHost = getTabHost();
        // Las Pestañas
            TabHost.TabSpec pestañas;
        // 2. Creo las Pestañas

        /*
            Pestaña 1 - Noticia 1
         */
        // Este es el Objeto que pasaré a la siguiente Actividad

        for (int i =1;i<=4;i++) {
            texto Noticia = new texto();
            Noticia.setTitulo("Noticia " + i);
            Noticia.setContenido("Noticia " + i + "\n Este es el contenido de la noticia 1.\n" +
                    "fjgs lfgsihsriohjhgioñhsfhgig hsfghs f hgñsgh ñs");
            Intent n1 = new Intent(contenedor.this, Textos.class);
            n1.putExtra("NOTICIA", Noticia);

            pestañas = tabHost
                    .newTabSpec(Noticia.getTitulo())
                    .setIndicator(Noticia.getTitulo())
                    .setContent(n1);

            tabHost.addTab(pestañas);
        }
        /*
            Pestaña 2 - Noticia 2

        // Este es el Objeto que pasaré a la siguiente Actividad
        texto Noticia2 = new texto();
        Noticia2.setTitulo("Noticia 2");
        Noticia2.setContenido("Noticia 2\n Este es el contenido de la noticia 2.\n" +
                "fjgs lfgsihsriohjhgioñhsfhgig hsfghs f hgñsgh ñs");
        Intent n2 = new Intent(contenedor.this, Textos.class);
        n2.putExtra("NOTICIA",Noticia2);

        pestañas = tabHost
                .newTabSpec(Noticia2.getTitulo())
                .setIndicator(Noticia2.getTitulo())
                .setContent(n2);

        tabHost.addTab(pestañas);
*/

    }
}
