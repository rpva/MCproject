package pt.ulisboa.tecnico.sise.mc.project.insureappgroup10.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pt.ulisboa.tecnico.sise.mc.project.insureappgroup10.DataModel.ClaimItem;
import pt.ulisboa.tecnico.sise.mc.project.insureappgroup10.GlobalState;
import pt.ulisboa.tecnico.sise.mc.project.insureappgroup10.InternalProtocol;
import pt.ulisboa.tecnico.sise.mc.project.insureappgroup10.R;

public class ReadClaimActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_claim);



        // set up the listener of the done button
        final Button backReadClaimBtn = (Button) findViewById(R.id.backReadClaimBtn);
        backReadClaimBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // just finish the current activity
                finish();
            }
        });

        // display the title and body of the note identified by the index parameter
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.d(InternalProtocol.LOG, "Internal error: Index cannot be null.");
            finish();
            return;
        }
        int index = extras.getInt(InternalProtocol.READ_CLAIM_INDEX);
        Log.d(InternalProtocol.LOG, "Index:" + index);

        // obtain a reference to the note's data structure
        GlobalState context = (GlobalState) getApplicationContext();
        ClaimItem claimItem = context.getClaimItemList().get(index);

        // update the UI
        TextView ocorrenceDateReadClaimTextView = (TextView) findViewById(R.id.ocorrenceDateReadClaim);
        ocorrenceDateReadClaimTextView .setText(claimItem.getDateOcorrence());

        /*TextView SubmissionDateReadClaimTextView = (TextView) findViewById(R.id.SubmissionDateReadClaim);
        SubmissionDateReadClaimTextView.setText(claimItem.getBody());

         */
        TextView descriptionReadClaimTextView = (TextView) findViewById(R.id.descriptionReadClaim);
        descriptionReadClaimTextView.setText(claimItem.getDesciption());

        TextView plateNumberReadClaimTextView = (TextView) findViewById(R.id.plateNumberReadClaim);
        plateNumberReadClaimTextView.setText(claimItem.getPlateNumber());

                /*TextView claimReadClaimTextView = (TextView) findViewById(R.id.SubmissionDateReadClaim);
        SubmissionDateReadClaimTextView.setText(claimItem.getBody());

         */
        TextView title2ReadClaimTextView = (TextView) findViewById(R.id.title2ReadClaim);
        title2ReadClaimTextView.setText(claimItem.getPlateNumber());




    }

}
