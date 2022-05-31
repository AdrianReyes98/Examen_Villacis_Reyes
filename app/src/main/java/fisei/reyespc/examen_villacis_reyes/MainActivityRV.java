package fisei.reyespc.examen_villacis_reyes;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivityRV extends AppCompatActivity {


    Button btnSegundaActivityRV;

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == 78){
                        Intent intent = result.getData();
                        if(intent != null){
                            Toast.makeText(MainActivityRV.this,"SI se trajo los datos",Toast.LENGTH_LONG).show();
                            //dato.setText(intent.getStringExtra("result"));
                        }else{
                            //dato.setText("SIN DATA");
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

        btnSegundaActivityRV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dos = new Intent(MainActivityRV.this, SegundaActivityRV.class);
                activityResultLauncher.launch(dos);
            }
        });
    }


    public void onClicordenarDatos(){

    }


}
