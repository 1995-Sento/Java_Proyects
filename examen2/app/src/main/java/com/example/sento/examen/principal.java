package com.example.sento.examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class principal extends AppCompatActivity {
    private static final int home = 1;
    private static final int mujer = 2;

    private Button i_hombre =null;
    private Button i_mujer =null;
    private LinearLayout c_hombre=null;
    private LinearLayout c_mujer=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        i_hombre = (Button) findViewById(R.id.hombre);
        i_mujer= (Button) findViewById(R.id.mujer);
        c_hombre = (LinearLayout) findViewById((R.id.contenedor_hombres));
        c_mujer = (LinearLayout) findViewById((R.id.contenedor_mujeres));

//abre lo del hombre
        View.OnClickListener clic = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent h = new Intent(principal.this, a_hombre.class);
                Bundle b = new Bundle();
                b.putInt("prueba",home);
                h.putExtras(b);
                startActivityForResult(h,home);

            }
        };
        this.i_hombre.setOnClickListener(clic);
        //abre mujer
       View.OnClickListener clic2 = new View.OnClickListener(){
           @Override
           public void onClick(View v) {
            Intent mujer = new Intent(principal.this, a_mujer.class);
               startActivity(mujer);
           }
       };
        this.i_mujer.setOnClickListener(clic2);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == home)
            if(resultCode == RESULT_OK){
                TextView nuevo_hombre = new TextView(this);
                nuevo_hombre.setText(data.getExtras().getString("RESULTADO"));
                c_hombre.addView(nuevo_hombre);
            }
        }



    }



