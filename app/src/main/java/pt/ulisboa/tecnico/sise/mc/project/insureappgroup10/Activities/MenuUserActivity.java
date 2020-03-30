package pt.ulisboa.tecnico.sise.mc.project.insureappgroup10.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pt.ulisboa.tecnico.sise.mc.project.insureappgroup10.R;

public class MenuUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_user);


        Button myAccountButton = (Button) findViewById(R.id.myAccountBtn);
        myAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuUserActivity.this, PerfilActivity.class);
                startActivity(intent);

            }
        });


        Button addNewClaimButton = (Button) findViewById(R.id.addClaimBtn);
        addNewClaimButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuUserActivity.this, NewClaimActivity.class);
                startActivity(intent);
            }
        });


        Button listOfClaimButton = (Button) findViewById(R.id.listClaimBtn);
        listOfClaimButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuUserActivity.this, ListOfClaimsActivity.class);
                startActivity(intent);

            }
        });

        Button logoutButton = (Button) findViewById(R.id.logoutBtn);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuUserActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });










    }
}
