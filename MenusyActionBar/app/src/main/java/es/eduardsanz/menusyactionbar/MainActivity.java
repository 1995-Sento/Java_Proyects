package es.eduardsanz.menusyactionbar;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Mi Programa");
        actionBar.setIcon(R.drawable.captura);
        */

        ImageView imagenTool = (ImageView) findViewById(R.id.imageTool);
        imagenTool.setImageResource(R.drawable.captura);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Nueva ToolBar");
        setSupportActionBar(toolbar);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         super.onOptionsItemSelected(item);

        TextView texto = (TextView) findViewById(R.id.texto);
        /*
        if (item.getItemId() == R.id.elemento1)
        {
            texto.setText("Has Presionado la Opción 1");
        }
        */
        switch (item.getItemId())
        {
            case R.id.elemento1:
                texto.setText("Has Presionado la Opción 1");
                break;
            case R.id.elemento2:
                texto.setText("Has Presionado la Opción 2");
                break;
            case  R.id.subelemento1:
                texto.setText("Has Presionado la SubOpción 1");
                break;
            case R.id.elemento3:
                texto.setText("Has presioando la Opción 3");
                break;
        }

        return true;
    }
}
