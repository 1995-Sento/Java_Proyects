package es.eduardsanz.dialogosclase;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button alertDialog = null;
    private Button progressDialog = null;
    private ProgressDialog progress= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alertDialog  = (Button) findViewById(R.id.alertDialog);
        final TextView texto = (TextView) findViewById(R.id.textView);
        progressDialog = (Button) findViewById(R.id.progressDialog);

        alertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lanzar_alert("Prueba 1", "Lanzado desde fuera en boton 1"))
                    texto.setText("Has Presionado Sí");
                else
                    texto.setText("Has Presionado No");
            }
        });

        progressDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress = new ProgressDialog(MainActivity.this);
                progress.setTitle("Cargando");
                progress.setCancelable(true);
                progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progress.setMax(100);
                progress.show();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progress.getProgress()<100)
                        {
                            try {
                                Thread.sleep(200);
                                progress.incrementProgressBy(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        progress.dismiss();
                    }
                }).start();
            }
        });


    }
    public boolean lanzar_alert(String titulo, String mensaje)
    {
        final boolean[] respuesta = new boolean[1];


        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
        alerta.setTitle(titulo);
        alerta.setMessage(mensaje);
        // Obligamos al usuario a contestar
        alerta.setCancelable(false);
        alerta.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                respuesta[0] = true;
            }
        });
        alerta.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                respuesta[0]=false;
            }
        });

        alerta.show();

        return respuesta[0];
    }
}
