package com.alex0x123.baloonboom;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.chartboost.sdk.*;
import com.chartboost.sdk.Model.CBError;

import org.w3c.dom.Text;

/**
 * Created by Alexandru on 28.06.2015.
 */
public class MainMenu extends Activity {


    protected void onCreate(Bundle savedInstanceState)
    {
            super.onCreate(savedInstanceState);

            String appId = "5593ce460d602532017c7e38";
            String appSignature = "9bae2063675d5c1ddc625a672133cdacdbdb6ff8";

            Chartboost.startWithAppId(this, appId, appSignature);
            Chartboost.setDelegate(delegate);
            Chartboost.onCreate(this);

            setContentView(R.layout.menu);

            ImageButton bstart = (ImageButton) findViewById(R.id.imageButton);
            ImageButton bcoins = (ImageButton) findViewById(R.id.imageButton2);
            ImageButton bshare = (ImageButton) findViewById(R.id.imageButton3);
            ImageButton bchoose = (ImageButton) findViewById(R.id.imageButton4);
            ImageButton bhigh = (ImageButton) findViewById(R.id.imageButton5);
            final TextView score = (TextView) findViewById(R.id.textView);
            final TextView coins = (TextView) findViewById(R.id.textView4);


        SharedPreferences prefs = getSharedPreferences("saves",MODE_PRIVATE);
        SharedPreferences.Editor ed = prefs.edit();

        Chartboost.showInterstitial(CBLocation.LOCATION_LEADERBOARD);

        int sc = prefs.getInt("score", 0);
        int co = prefs.getInt("money", 0);
        StringBuilder sb = new StringBuilder();
        sb.append("SCORE : ");
        sb.append(sc);
        score.setText(sb.toString());


        StringBuilder sb1 = new StringBuilder();
        sb1.append(" ");
        sb1.append(co);
        coins.setText(sb1.toString());

        bstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainMenu.this,Game.class);
                startActivity(intent);
                finish();

            }
        });

        bcoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Chartboost.showRewardedVideo(CBLocation.LOCATION_ACHIEVEMENTS);
            }
        });

        bshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Guess the Code - Smart Puzzle");
                sendIntent.setType("text/plain");
                String sAux = "\nThis app is great ! \n\n";
                sAux = sAux + "https://play.google.com/store/apps/details?id=com.alex0x123.balloonboom";
                sendIntent.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(sendIntent, "Choose one"));


            }
        });

        bchoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent1 = new Intent(MainMenu.this,CharacterMenu.class);
                startActivity(intent1);
                finish();

            }
        });

        bhigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainMenu.this,Email.class);
                startActivity(intent);
            }
        });

    }


    protected ChartboostDelegate delegate = new ChartboostDelegate() {

        @Override
        public void didCompleteRewardedVideo(String location, int reward) {

            SharedPreferences prefs = getSharedPreferences("saves",MODE_PRIVATE);
            SharedPreferences.Editor ed = prefs.edit();

            int coins = prefs.getInt("money",0);
            coins = coins + 25;
            ed.putInt("money", coins);
            ed.commit();

            StringBuilder sb1 = new StringBuilder();
            sb1.append(" ");
            sb1.append(coins);

            TextView mon = (TextView) findViewById(R.id.textView4);
            mon.setText(sb1.toString());

        }

        @Override
        public void didFailToLoadRewardedVideo(String location,
                                               CBError.CBImpressionError error) {

            Toast.makeText(getApplicationContext(), "Server is busy for the moment ! Try later",
                    Toast.LENGTH_LONG).show();
        }
    };

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub

        if (Chartboost.onBackPressed())
            return;
        else
        {
            super.onBackPressed();
            finish();
        }

    }

	/*public void displayInterstitial() {
	    if (interstitial.isLoaded()) {
	      interstitial.show();
	    }
	  }*/

    @Override
    public void onStart() {
        super.onStart();
        Chartboost.onStart(this);
       // Chartboost.showInterstitial(CBLocation.LOCATION_DEFAULT);
       // this.cb.onStart(this);

        // Show an interstitial. This and other interstital/MoreApps cache/show calls should be used after onStart().
        //this.cb.showInterstitial();
        //  EasyTracker.getInstance(this).activityStart(this);  // Add this method.

    }

    @Override
    public void onStop() {
        super.onStop();
        //this.cb.onStop(this);
        // EasyTracker.getInstance(this).activityStop(this);  // Add this method.
        Chartboost.onStop(this);
    }

    @Override
    protected void onDestroy() {
        // this.cb.onDestroy(this);
        super.onDestroy();
        Chartboost.onDestroy(this);

    }


    @Override
    public void onResume() {
        super.onResume();
        Chartboost.onResume(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        Chartboost.onPause(this);
    }






}
