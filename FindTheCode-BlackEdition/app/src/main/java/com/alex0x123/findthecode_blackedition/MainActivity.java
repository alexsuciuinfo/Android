package com.alex0x123.findthecode_blackedition;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.chartboost.sdk.*;
import com.chartboost.sdk.Model.CBError;



public class MainActivity extends Activity{


    private int level=15,i,max = 38,ads = 0;
    private String question[] = {
            "2 + 2 : 2" ,
            "1 2 3 4 5 6",
            "1 2 1 3 1 5 1 7 1 11 1 13 1 _ \n(PS : The answer of next question is OK)",
            "If you have problems with a question send us a mail : alexsuciuinfo@gmail.com",
            "Black + White",
            "Black + White + White + White",
            "_ and Seven dwarfs",
            "Do yoU kNow what is missing from this gaME?",
            "MENU = (13)(5)(14)(?)",
            "What's the only word which contains 11 letters and it's always pronounced incorrectly ?",
            "_ _ _ GRESS\n_ _ _ DUCT\n_ _ _ GRAM",
            "United Kingdom - Great Britain",
            "alokiN alseT",
            "It's in London, but not in Dortmund",
            "I am a delicious chocolate planet . Who am I ?",
            "Intruder : IVXLKCDM",
            "Newton / square^2",
            "     1     \n    1 1    \n   1 2 1   \n  1 3 3 1  \n 1 4 6 4 1 \n1 _ _ _ _ 1",
            "B + Y = G , B + R = P, R + Y = ?",
            "Half of two is two\nHalf of three is three\nHalf of ten is five\nHalf of twelve is _ ",
            "Eclair, Gingerbread, Jelly Bean, Lollipop",
            "Bird without an eye ",
            "In which state is Mississippi River ? (science)",
            "-- --- .-. ... .",
            "M in M (music)",
            "I IX MCMXXXIX",
            "(65)(83)(67)(73)(73) Code",
            "What am I ?",
            "T(Q+1)A(E+1)A(M-1)(F+1)A(S-1) E=mc_ LOCATION",
            "31.47 35.13 city",
            "From A8 to B7,C6,D5,E4,F3,G2,H1",
            "Onestone is a physics genius",
            "I am an odd number, but I become even if you decapitate me",
            "Thirteen - Three",
            "- + | = +\n /  + \\ +  | = ?",
            "| + _ + | + - (Linux Superuser) of 9",
            "Product of digits . Look up ! ",
            "500030 | 500002\n500030 | 500002\n game",
            "On my left is the ing and on my right is the night (K is the key)",
            "Congratulations ! \n\n\n You did it !"
    };
    private String rez[][] = {
            {"3"},
            {"7"},
            {"17"},
            {"OK"},
            {"grey", "gray"},
            {"lightgray", "lightgrey", "light gray", "light grey"},
            {"snow white", "snowwhite"},
            {"menu"},
            {"21"},
            {"incorrectly"},
            {"pro"},
            {"Northern Ireland","NorthernIreland"},
            {"Nikola Tesla","NikolaTesla"},
            {"l"},
            {"Mars"},
            {"K"},
            {"Pascal"},
            {"510105","5 10 10 5"},
            {"O"},
            {"seven","7","VII"},
            {"Android"},
            {"brd"},
            {"liquid"},
            {"Morse"},
            {"eminem"},
            {"WW2","WorldWarTwo","WorldWar2","World War Two","World War 2","World War II", "WWII"},
            {"ASCII"},
            {"question"},
            {"London"},
            {"Jerusalem"},
            {"Bishop","queen"},
            {"Einstein"},
            {"seven","7"},
            {"iten"},
            {"*"},
            {"3"},
            {"18"},
            {"backgammon"},
            {"bishop"},
            {""}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String appId = "565e1c04a8b63c592ed7245c";
        String appSignature = "49f1932b4bd06943e90678843cc5613d5a3f8f9b";


        Chartboost.startWithAppId(this, appId, appSignature);
        Chartboost.onCreate(this);


        setContentView(R.layout.activity_main);


        final TextView textView = (TextView) findViewById(R.id.textview);
        final EditText answ = (EditText) findViewById(R.id.edtext);
        final TextView textView1 = (TextView) findViewById(R.id.textviewlevel);
        final Button butt = (Button) findViewById(R.id.button);

        SharedPreferences prefs = getSharedPreferences("saves", MODE_PRIVATE);
        SharedPreferences.Editor ed = prefs.edit();

        //level = prefs.getInt("level",0);

        textView.setText(question[level]);
        textView1.setText("Level " + level);

        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(i=0; i<rez[level].length; i++)

                   if (answ.getText().toString().equalsIgnoreCase(rez[level][i]))
                   {

                       if(level == max)
                       {
                           textView.setText(question[level+1]);
                           textView1.setText("");
                           answ.setText("");
                           textView.setTextColor(Color.parseColor("#00FF00"));
                           ViewGroup layout = (ViewGroup) butt.getParent();
                           ViewGroup layout1 = (ViewGroup) answ.getParent();
                           if(null!=layout)
                               layout.removeView(butt);

                           if(null!=layout1)
                               layout1.removeView(answ);
                       }

                       else {
                           level++;
                           SharedPreferences prefs1 = getSharedPreferences("saves", MODE_PRIVATE);
                           SharedPreferences.Editor ed1 = prefs1.edit();
                           ed1.putInt("level", level);
                           ed1.commit();
                           textView.setText(question[level]);
                           textView1.setText("Level " + level);
                           answ.setText("");
                       }

                   }

                if (level != max )
                    answ.setText("");

                ads++;

                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(i);
                String strI = sb.toString();

               if (ads % 17 == 0 || level % 5 == 0 )
               {
                   Chartboost.cacheInterstitial(CBLocation.LOCATION_DEFAULT);
                   Chartboost.showInterstitial(CBLocation.LOCATION_DEFAULT);
               }

            }
        });



    }

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
