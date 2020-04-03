package pt.ulisboa.tecnico.sise.mc.project.insureappgroup10.Activities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import pt.ulisboa.tecnico.sise.mc.project.insureappgroup10.InternalProtocol;
import pt.ulisboa.tecnico.sise.mc.project.insureappgroup10.R;

public class NewClaimActivity extends AppCompatActivity {
    private EditText dateOcorrence;
    private DatePickerDialog datePickerDialog;
    private Button submitButton;
    private Button cancelButton;
    EditText title;
    EditText plateNumber;
    EditText description;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_claim);

        title = (EditText)findViewById(R.id.titleNewClaimBtn);
        plateNumber  = (EditText)findViewById(R.id.plateNumberBtn);
        description = (EditText) findViewById(R.id.descriptionBtn);
        dateOcorrence = (EditText) findViewById(R.id.dateOcorrence_value);
        submitButton = (Button)  findViewById(R.id.submitNewClaimBtn);


        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String claimTitle = title.getText().toString();
                String claimplateNumber = plateNumber.getText().toString();
                String claimdescription = description.getText().toString();
                String claimdateOcorrence = dateOcorrence.getText().toString();


                // check the title
                if (claimTitle.equals("")) {
                    Toast.makeText(v.getContext(), "Write a claim title", Toast.LENGTH_LONG).show();
                    return;
                }
                else if (claimplateNumber.equals("")) {
                    Toast.makeText(v.getContext(), "Write a claim plate Number", Toast.LENGTH_LONG).show();
                    return;
                }

                else if (claimdescription.equals("")) {
                    Toast.makeText(v.getContext(), "Write a claim description", Toast.LENGTH_LONG).show();
                    return;
                }

                else if (claimdateOcorrence.equals("")) {
                    Toast.makeText(v.getContext(), "Write a claim Ocorrence Date", Toast.LENGTH_LONG).show();
                    return;
                }


                // return an intent containing the title and body of the new note
                Intent resultIntent = new Intent();
                resultIntent.putExtra(InternalProtocol.KEY_NEW_CLAIM_TITLE, claimTitle);
                resultIntent.putExtra(InternalProtocol.KEY_NEW_CLAIM_PLATE_NUMBER, claimplateNumber);
                resultIntent.putExtra(InternalProtocol.KEY_NEW_CLAIM_DESCRIPTION, claimdescription);
                resultIntent.putExtra(InternalProtocol.KEY_NEW_CLAIM_DATE_OCORRENCE, claimdateOcorrence);
                setResult(Activity.RESULT_OK, resultIntent);
                // write a toast message
                Toast.makeText(v.getContext(), "Claim saved", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


        cancelButton  = (Button)  findViewById(R.id.cancelNewClaimBtn);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // return the return code only; no intent message is required
                setResult(Activity.RESULT_CANCELED);
                // write a toast message
                Toast.makeText(v.getContext(), "Changed button title!", Toast.LENGTH_SHORT).show();
                // finish activity
                finish();
            }
        });




        // initiate the date picker and a button
        // perform click event on edit text

        dateOcorrence = (EditText) findViewById(R.id.dateOcorrence_value);

        dateOcorrence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(NewClaimActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                dateOcorrence.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });






    }
}
