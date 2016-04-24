package com.findthecode_smartpuzzle.alex;


import com.chartboost.sdk.*;
import com.google.android.gms.ads.*;
import com.google.analytics.tracking.android.EasyTracker;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import android.widget.RelativeLayout;


public class Menu extends Activity implements OnClickListener {
	
	MediaPlayer song;
	TextView start,email,share,exit;
	ToggleButton sound;
	public Boolean a=true;
	String classes[] = {"LevelSelect","Email"};
	//private InterstitialAd interstitial;
	private Chartboost cb;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		
		this.cb = Chartboost.sharedChartboost();
		String appId = "53dd5ab11873da4ec7b5a2f3";
		String appSignature = "601e488f220c28b49a9c78fb7a2b63ec45029452";
		this.cb.onCreate(this, appId, appSignature, null);

		
		initialize();
		song = MediaPlayer.create(Menu.this, R.raw.mixdown);
		song.setLooping(true);
		song.start();
		
		
		
		// Create the interstitial.
	  /*  interstitial = new InterstitialAd(this);
	    interstitial.setAdUnitId("ca-app-pub-8479975703818826/5645786393");

	    // Create ad request.
	    AdRequest adRequest = new AdRequest.Builder().build();

	    // Begin loading your interstitial.
	    interstitial.loadAd(adRequest);
	    
	    interstitial.setAdListener(new AdListener(){
	          public void onAdLoaded(){
	               displayInterstitial();
	          }
	});*/
		
	}
	
	public void initialize()
	{
		start = (TextView) findViewById (R.id.start);
		email = (TextView) findViewById (R.id.emailus);
		share = (TextView) findViewById (R.id.share);
		exit = (TextView) findViewById (R.id.exit);
		sound = (ToggleButton) findViewById(R.id.bsound);
		sound.setChecked(true);
		sound.setOnClickListener(this);
		start.setOnClickListener(this);
		email.setOnClickListener(this);
		share.setOnClickListener(this);
		exit.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId())
		{
		
		case R.id.bsound:
			if(!sound.isChecked())
			{
				song.pause();
				
			}
			else
			{
				song.start();
				
			}
			break;
			
		case R.id.start:
			try {
				Class myclass = Class.forName("com.findthecode_smartpuzzle.alex." + classes[0]);
				Intent i = new Intent(Menu.this,myclass);
				startActivity(i);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case R.id.emailus:
			try {
				Class myclass = Class.forName("com.findthecode_smartpuzzle.alex." + classes[1]);
				Intent i = new Intent(Menu.this,myclass);
				startActivity(i);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case R.id.share:
			Intent sendIntent = new Intent();
			sendIntent.setAction(Intent.ACTION_SEND);
			sendIntent.putExtra(Intent.EXTRA_TEXT, "Guess the Code - Smart Puzzle");
			sendIntent.setType("text/plain");
			String sAux = "\nThis app is great ! \n\n";
			sAux = sAux + "https://play.google.com/store/apps/details?id=com.findthecode_smartpuzzle.alex";
			sendIntent.putExtra(Intent.EXTRA_TEXT, sAux);  
			startActivity(Intent.createChooser(sendIntent, "Choose one"));
			
			break;
		
		case R.id.exit:
			
			{
			song.stop();
			finish();
			break;
			}
			
		}
		
	}
	
	

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		song.release();
		finish();
		
		if (this.cb.onBackPressed()) 
	        return; 
		else  super.onBackPressed();
		
	}
	
	/*public void displayInterstitial() {
	    if (interstitial.isLoaded()) {
	      interstitial.show();
	    }
	  }*/
	
	 @Override
	  public void onStart() {
	    super.onStart();
	    this.cb.onStart(this);

	    // Show an interstitial. This and other interstital/MoreApps cache/show calls should be used after onStart().
	    this.cb.showInterstitial(); 
	  //  EasyTracker.getInstance(this).activityStart(this);  // Add this method.
	    
	  }

	  @Override
	  public void onStop() {
	    super.onStop();
	    this.cb.onStop(this); 
	   // EasyTracker.getInstance(this).activityStop(this);  // Add this method.
	    //this.cb.onStop(this); 
	  }
	  
	  @Override
	  protected void onDestroy() { 
	     // this.cb.onDestroy(this); 
		  super.onDestroy();
		  this.cb.onDestroy(this); 
	       
	  }

	  
}
