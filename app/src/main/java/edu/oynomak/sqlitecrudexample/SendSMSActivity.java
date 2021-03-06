package edu.oynomak.sqlitecrudexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendSMSActivity extends AppCompatActivity {

    Button buttonSend;
    EditText textPhoneNo, textSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);

        buttonSend = (Button) findViewById(R.id.buttonSend);
        textPhoneNo = (EditText) findViewById(R.id.editTextPhoneNo);
        textSMS = (EditText) findViewById(R.id.editTextSMS);

        buttonSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String phoneNo = textPhoneNo.getText().toString();
                String smsBody = textSMS.getText().toString();

                try {
                    // Sending sms...
                    sendSMS(phoneNo, smsBody);

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),
                            "SMS failed, please try again later!",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }
        });
    }

    private void sendSMS(String phoneNo, String smsBody) {

        // --- Getting intent and PendingIntent instance ---
        /*Intent intent = new Intent(getApplicationContext(),SendSMSActivity.class);
        PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, intent,0);*/
        // --- Using Intent + startActivity() ---
        //*
        Intent sendIntent = new Intent(getApplicationContext(), SendSMSActivity.class);
        sendIntent.putExtra("sms_body", smsBody);
        //sendIntent.setData(Uri.parse("smsto:"));
        sendIntent.putExtra("address", phoneNo);
        sendIntent.setType("vnd.android-dir/mms-sms");
        startActivity(sendIntent);
        //*/

        // Check self permission
        //checkSelfPermission();


        //Get the SmsManager instance and call the sendTextMessage method to send message
        //SmsManager smsManager = SmsManager.getDefault();

        //smsManager.sendTextMessage(phoneNo, null, sms, null, null);
        //smsManager.sendTextMessage(phoneNo, null, smsBody, pi,null);
        Toast.makeText(getApplicationContext(), "SMS Sent to: "+ phoneNo +" was: \n <<"+smsBody+">>",
                Toast.LENGTH_LONG).show();
    }
}
