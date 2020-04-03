package pt.ulisboa.tecnico.sise.mc.project.insureappgroup10.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import pt.ulisboa.tecnico.sise.mc.project.insureappgroup10.DataModel.ClaimItem;
import pt.ulisboa.tecnico.sise.mc.project.insureappgroup10.GlobalState;
import pt.ulisboa.tecnico.sise.mc.project.insureappgroup10.InternalProtocol;
import pt.ulisboa.tecnico.sise.mc.project.insureappgroup10.R;

public class ListOfClaimsActivity extends AppCompatActivity {
    private static final String LOG_TAG = "SISE - InSure";
    private ListView _listView;
    private ArrayList<ClaimItem> _claimItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_claims);


        // place the claim list in the application domain
        _claimItemList = new ArrayList<ClaimItem>();
        GlobalState globalState = (GlobalState) getApplicationContext();
        globalState.setClaimItemList(_claimItemList);

        // assign adapter to list view
        _listView = (ListView) findViewById(R.id.list_of_Claims_list);

        ArrayAdapter<ClaimItem> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, _claimItemList);
        _listView.setAdapter(adapter);

        // attach click listener to list view items
        _listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // create the read List activity, passing to it the index position as parameter
                Log.d("position", position+"");
                Intent intent = new Intent(ListOfClaimsActivity.this, ReadClaimActivity.class);
                intent.putExtra(InternalProtocol.READ_CLAIM_INDEX, position);
                startActivity(intent);

                // if instead of string, we pass a list with notes, we can retrieve the original Note object this way
                //ClaimItem claimItem = (claim)parent.getItemAtPosition(position);
            }
        });

        // set up the button listener for the "New Note" button
        Button BackListButton = (Button) findViewById(R.id.backListBtn);
        BackListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListOfClaimsActivity.this, MenuUserActivity.class);
                startActivityForResult(intent, InternalProtocol.NEW_CLAIM_REQUEST);
            }
        });


        
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case InternalProtocol.NEW_CLAIM_REQUEST:

                if (resultCode == Activity.RESULT_OK) {

                    // retrieve the caracteristics of the claim from the intent
                    String claimTitle = data.getStringExtra(InternalProtocol.KEY_NEW_CLAIM_TITLE);
                    String claimPlateNumber = data.getStringExtra(InternalProtocol.KEY_NEW_CLAIM_PLATE_NUMBER);
                    String claimDescription = data.getStringExtra(InternalProtocol.KEY_NEW_CLAIM_DESCRIPTION);
                    String claimDateOcorrence = data.getStringExtra(InternalProtocol.KEY_NEW_CLAIM_DATE_OCORRENCE);

                    Log.d(InternalProtocol.LOG, "New Claim:" + claimTitle + "," + claimPlateNumber + "," + claimDescription + "," + claimDateOcorrence );

                    // update the domain data structures
                    _claimItemList.add(new ClaimItem(claimTitle, claimPlateNumber, claimDescription, claimDateOcorrence));

                    // refresh the list on screen
                    _listView.setAdapter(new ArrayAdapter<>(this,
                            android.R.layout.simple_list_item_1, android.R.id.text1, _claimItemList));

                } else if (resultCode == Activity.RESULT_CANCELED) {
                    Log.d(InternalProtocol.LOG, "Cancel pressed.");
                } else {
                    Log.d(InternalProtocol.LOG, "Internal error: unknown result code.");
                }
                break;
            default:
                Log.d(InternalProtocol.LOG, "Internal error: unknown intent message.");
        }
    }

}