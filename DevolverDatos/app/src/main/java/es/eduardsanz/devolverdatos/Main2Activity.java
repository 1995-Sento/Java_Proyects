package es.eduardsanz.devolverdatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent config = new Intent();
        Bundle bundle = new Bundle();

        String nuevo = "Cadena";

        bundle.putString("NUEVO",nuevo);
        config.putExtras(bundle);

        setResult(RESULT_OK,config);
        finish();
    }
}
