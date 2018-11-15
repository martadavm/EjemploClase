package com.example.usuario.almacenamiento;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button guardar;
    EditText texto;
    TextView mostrar;
    String miFichero="miFichero";
    EditText apellido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto=(EditText)findViewById(R.id.editText);
        guardar=(Button)findViewById(R.id.guardar);
        mostrar=(TextView) findViewById(R.id.mostrar);
        apellido=(EditText)findViewById(R.id.editTextApellido);


        //Pensada para guardar los datos de nuestras aplicaciones.
        //Solo mi aplicacion puede ver esos valores.
        SharedPreferences preferences= getSharedPreferences("miFichero",Context.MODE_PRIVATE); //SE PUUEDE PONER EN PRIVADA (solo lo veo yo) O PARA QUE LO VEAN LOS DEMAS. En este caso privada.
       String nombre=preferences.getString("nombre","No existe");//Si ese nombre no existe, devuelve no existe.
        String ape=preferences.getString("apellido","No hay apellido");
        mostrar.setText(nombre+" "+ape);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences= getSharedPreferences("miFichero",Context.MODE_PRIVATE); //SE PUUEDE PONER EN PRIVADA (solo lo veo yo) O PARA QUE LO VEAN LOS DEMAS. En este caso privada.
                String nom=texto.getText().toString();
                String ape=apellido.getText().toString();

                preferences.edit().putString("nombre",nom).commit();//para que lo guarde
                preferences.edit().putString("apellido",ape).commit();//para que lo guarde
                mostrar.setText(nom+" "+ape);


            }
        });

    }
}
