package pt.ulisboa.tecnico.sise.mc.project.insureappgroup10.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pt.ulisboa.tecnico.sise.mc.project.insureappgroup10.R;

public class PerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);


        Button backPerfilBtn = (Button) findViewById(R.id.backPerfilBtn);
        backPerfilBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PerfilActivity.this, MenuUserActivity.class);
                startActivity(intent);

            }
        });
    }
}
