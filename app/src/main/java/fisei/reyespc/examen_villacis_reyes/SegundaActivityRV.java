package fisei.reyespc.examen_villacis_reyes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SegundaActivityRV extends AppCompatActivity {

    ListView listaNumerosRV;
    Button btnIngresarRV;
    Button btnCerrarRV;
    EditText edtNumeroRV;
    ArrayList<Integer> numerosListaRV = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_rv);

        getSupportActionBar().hide();

        listaNumerosRV = findViewById(R.id.lisVIewNumeros);
        btnCerrarRV = findViewById(R.id.buttonCerrar);
        btnIngresarRV = findViewById(R.id.buttonIngresar);
        edtNumeroRV = findViewById(R.id.editTextNumero);
        Context context = this;
        CustomAdapter adapter = new CustomAdapter(this, numerosListaRV);
        listaNumerosRV.setAdapter(adapter);

        btnCerrarRV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAux = new Intent();
                intentAux.putIntegerArrayListExtra("result",numerosListaRV);
                setResult(78,intentAux);
                SegundaActivityRV.super.onBackPressed();
            }
        });

        btnIngresarRV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numerosListaRV.add(Integer.valueOf(edtNumeroRV.getText().toString()));
                CustomAdapter adapter = new CustomAdapter(context, numerosListaRV);
                listaNumerosRV.setAdapter(adapter);
            }
        });
    }



}