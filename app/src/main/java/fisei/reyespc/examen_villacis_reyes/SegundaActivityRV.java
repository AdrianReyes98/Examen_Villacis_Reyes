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

    ListView listaNumerosRV;
    Button btnIngresarRV;
    Button btnCerrarRV;
    EditText edtNumeroRV;
    Float[] arrayNumeros;
    List<Float> numerosLista = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_rv);
        getSupportActionBar().hide();

        listaNumerosRV = findViewById(R.id.lisVIewNumeros);
        btnCerrarRV = findViewById(R.id.buttonCerrar);
        btnIngresarRV = findViewById(R.id.buttonIngresar);
        edtNumeroRV = findViewById(R.id.editTextNumero);

        btnCerrarRV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAux = new Intent();
                arrayNumeros = convertirDeArrayAListaRV(numerosLista);
                intentAux.putExtra("result",arrayNumeros);
                setResult(78,intentAux);
                SegundaActivityRV.super.onBackPressed();
            }
        });

        btnIngresarRV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private Float[] convertirDeArrayAListaRV(List<Float> datoRV){
        Float[] resultRV = new Float[datoRV.size()];
        int i = 0;
        for (float num: datoRV) {
            resultRV[i] = num;
            i++;
        }
        return resultRV;
    }



}