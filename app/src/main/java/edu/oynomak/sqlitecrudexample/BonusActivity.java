package edu.oynomak.sqlitecrudexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BonusActivity extends AppCompatActivity implements View.OnClickListener {

    Button addEmployeeLink, sendSMSLink, sendEmailLink, googleMapLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus);

        sendSMSLink = (Button) findViewById(R.id.btnSendSMS);
        sendEmailLink = (Button) findViewById(R.id.btnSendMail);
        googleMapLink = (Button) findViewById(R.id.btnMap);

        sendSMSLink.setOnClickListener(this);
        sendEmailLink.setOnClickListener(this);
        googleMapLink.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnSendSMS:

                startActivity(new Intent(this, SendSMSActivity.class));

                break;

            case R.id.btnSendMail:

                startActivity(new Intent(this, SendMailActivity.class));

                break;

            case R.id.btnMap:

                startActivity(new Intent(this, GoogleMapsActivity.class));

                break;
        }
    }
}
