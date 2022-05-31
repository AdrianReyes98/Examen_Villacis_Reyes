package fisei.reyespc.examen_villacis_reyes;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivityRV extends AppCompatActivity {
    Button btnSegundaActivityRV;
    Button btnOrdenarRV;
    Button btnMostrarRV;

    ListView listaOriginalRV;
    ListView listaIndicesOrdenadoRV;
    ListView listaVectorOrdenadoRV;

    Integer[] arrayNumerosOrdenar;
    ArrayList<Integer> numerosVectorRV = new ArrayList<>();
    ArrayList<Integer> indicesRv = new ArrayList<>();

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == 78){
                        Intent intent = result.getData();
                        if(intent != null){
                            numerosVectorRV = new ArrayList<>();
                            numerosVectorRV = intent.getIntegerArrayListExtra("result");
                            btnMostrarRV.setEnabled(true);
                            btnOrdenarRV.setEnabled(true);
                        }else{
                            Toast.makeText(MainActivityRV.this,"NO se trajo los datos",Toast.LENGTH_LONG).show();
                        }
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_rv);
        getSupportActionBar().hide();

        btnSegundaActivityRV = findViewById(R.id.buttonSiguienteRV);
        btnOrdenarRV = findViewById(R.id.buttonOrdenarRV);
        btnMostrarRV = findViewById(R.id.buttonMostrarRV);
        listaOriginalRV = findViewById(R.id.listViewVectorOriginal);
        listaIndicesOrdenadoRV = findViewById(R.id.listViewIndicesVector);
        listaVectorOrdenadoRV = findViewById(R.id.listViewVector);

        btnMostrarRV.setEnabled(false);
        btnOrdenarRV.setEnabled(false);

        btnSegundaActivityRV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dos = new Intent(MainActivityRV.this, SegundaActivityRV.class);
                activityResultLauncher.launch(dos);
            }
        });
        btnMostrarRV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomAdapter adapter = new CustomAdapter(MainActivityRV.this, numerosVectorRV);
                listaOriginalRV.setAdapter(adapter);
                int i=0;
                int j;
                int c = 0;
                int tam = numerosVectorRV.size();

                while(c < tam){
                    indicesRv.add(c);
                    c++;
                }

                while(i < tam){
                    j = i;
                    while(j < tam){
                        if(numerosVectorRV.get(i) > numerosVectorRV.get(j)){
                            int temp = indicesRv.get(i);
                            indicesRv.set(j,indicesRv.get(i));
                            indicesRv.set(i,temp);
                        }
                        j++;
                    }
                    i++;
                }

                CustomAdapter adapter2 = new CustomAdapter(MainActivityRV.this, indicesRv);
                listaIndicesOrdenadoRV.setAdapter(adapter2);
            }
        });


        btnOrdenarRV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomAdapter adapter = new CustomAdapter(MainActivityRV.this, numerosVectorRV);
                listaVectorOrdenadoRV.setAdapter(adapter);

                /*
                int i = 0;
                int j;
                int temp = 0;
                int n;

                CustomAdapter adapter = new CustomAdapter(MainActivityRV.this, numerosVectorRV);
                listaOriginalVectorRV.setAdapter(adapter);

                while ( i < numerosVector.size() ){

                    numerosVectorOriginal = new ArrayList<>();
                    listaOriginalRV.setAdapter(adapter);
                    i++;

                }

                 */

            }
        });


    }

}
