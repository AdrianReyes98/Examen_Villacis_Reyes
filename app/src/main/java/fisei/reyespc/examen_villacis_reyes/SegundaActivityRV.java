package fisei.reyespc.examen_villacis_reyes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SegundaActivityRV extends AppCompatActivity {

    ListView listaNumeros;
    Button btnIngresar;
    Button btnCerrar;
    EditText edtNumero;
    float[] arrayNumeros;
    ArrayList<Float> numerosLista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_rv);

        listaNumeros = findViewById(R.id.lisVIewNumeros);
        btnCerrar = findViewById(R.id.buttonCerrar);
        btnIngresar = findViewById(R.id.buttonIngresar);
        edtNumero = findViewById(R.id.editTextNumber);

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAux = new Intent();
                intentAux.putExtra("result",arrayNumeros);
                setResult(78,intentAux);
                SegundaActivityRV.super.onBackPressed();
            }
        });
    }



}