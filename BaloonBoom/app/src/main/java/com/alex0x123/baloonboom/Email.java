package com.alex0x123.baloonboom;

/**
 * Created by Alexandru on 30.06.2015.
 */


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Email extends Activity {

    EditText  intro, persName, sThings, hAction;
    TextView persEmail;
    Button sendEmail;
    String emailAdd, rate, good, bad, improve;


    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);
        initializeVars();
        sendEmail.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {

                convertEditTextVarsIntoStrings();
                String emailadress[] = { emailAdd };
                String message = " Application rating : " + rate + '\n'
                        + "Things you like : " + good + '\n'
                        + "Things you don't like : " + bad + '\n'
                        + "Things that can be improved : " + improve;

                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,emailadress);
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"About App");
                emailIntent.setType("plain/text");
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,message);
                startActivity(emailIntent);

            }
        });

    }

    private void initializeVars()
    {
        persEmail = (TextView) findViewById (R.id.etEmail);
        intro = (EditText) findViewById(R.id.etIntro);
        persName = (EditText) findViewById(R.id.etName);
        sThings = (EditText) findViewById(R.id.etThings);
        hAction = (EditText) findViewById(R.id.etAction);
        sendEmail = (Button) findViewById(R.id.bSentEmail);
    }


    private void convertEditTextVarsIntoStrings()
    {
        emailAdd = persEmail.getText().toString();
        rate = intro.getText().toString();
        good = persName.getText().toString();
        bad = sThings.getText().toString();
        improve = hAction.getText().toString();

    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        finish();
    }


    @Override
    protected void onPause()
    {
        super.onPause();
        finish();
    }

}
