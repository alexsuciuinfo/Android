package com.findthecode_smartpuzzle.alex;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.chartboost.sdk.*;
public class LevelSelect extends Activity implements View.OnClickListener {

	
	TextView levelselect[] = new TextView[32] ;
	private static final int[] BUTTON_IDS = { R.id.blevel1,R.id.blevel2, R.id.blevel3,R.id.blevel4,
	    R.id.blevel5, R.id.blevel6,R.id.blevel7,R.id.blevel8,R.id.blevel9, R.id.blevel10,R.id.blevel11,
	    R.id.blevel12,R.id.blevel13,R.id.blevel14,R.id.blevel15, R.id.blevel16,R.id.blevel17,R.id.blevel18,
	    R.id.blevel19, R.id.blevel20, R.id.blevel21, R.id.blevel22, R.id.blevel23, R.id.blevel24, R.id.blevel25,
	    R.id.blevel26, R.id.blevel27, R.id.blevel28, R.id.blevel29, R.id.blevel30,
	};
	String file[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16",
			"17","18","19","20","21","22","23","24","25","26","27","28","29","30"
	};
	int level=0;
	int levelmax = 0;
	EditText putanswer;
	ImageView answer;
	Context context = this;
	SharedPreferences prefs,prefs1;
	MediaPlayer songcorrect,songwrong;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.levelselect);
		prefs = getSharedPreferences("Sai",Context.MODE_PRIVATE);
		prefs1 = getSharedPreferences("Text",Context.MODE_PRIVATE);
		level  = prefs.getInt("lang_us", 0); 
		levelmax = prefs.getInt("lang_us", 0);
		linitialize();
	}

	protected void linitialize()
	{
	    // or slightly better
	    // buttons = new ArrayList<Button>(BUTTON_IDS.length);
	    for(int i = 0 ; i<30 ; i++) {
	        TextView button = (TextView) findViewById (BUTTON_IDS[i]);
	        button.setOnClickListener(this); // maybe
	        levelselect[i] = button;
	        String dataReturned = prefs1.getString(file[i], levelselect[i].getText().toString());
			levelselect[i].setText(dataReturned);
	    }
	}
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId())
		{
		
		case R.id.blevel1:
			level1();
			break;
			
		case R.id.blevel2:
			if(level<2)
				accessdenied();
			else level2();
			break;
			
		case R.id.blevel3:
			if(level<3)
				accessdenied();
			else level3();
			break;
		
		case R.id.blevel4:
			if(level<4)
				accessdenied();
			else level4();
			break;
			
		case R.id.blevel5:
			if(level<5)
				accessdenied();
			else level5();
			break;
			
		case R.id.blevel6:
			if(level<6)
				accessdenied();
			else level6();
			break;
			
		case R.id.blevel7:
			if(level<7)
				accessdenied();
			else level7();
			break;
			
		case R.id.blevel8:
			if(level<8)
				accessdenied();
			else level8();
			break;
			
		case R.id.blevel9:
			if(level<9)
				accessdenied();
			else level9();
			break;
		
		case R.id.blevel10:
			if(level<10)
				accessdenied();
			else level10();
			break;
			
		case R.id.blevel11:
			if(level<11)
				accessdenied();
			else level11();
			break;
			
		case R.id.blevel12:
			if(level<12)
				accessdenied();
			else level12();
			break;
			
		case R.id.blevel13:
			if(level<13)
				accessdenied();
			else level13();
			break;
			
		case R.id.blevel14:
			if(level<14)
				accessdenied();
			else level14();
			break;
			
		case R.id.blevel15:
			if(level<15)
				accessdenied();
			else level15();
			break;
			
		case R.id.blevel16:
			if(level<16)
				accessdenied();
			else level16();
			break;
			
		case R.id.blevel17:
			if(level<17)
				accessdenied();
			else level17();
			break;
			
		case R.id.blevel18:
			if(level<18)
				accessdenied();
			else level18();
			break;
			
		case R.id.blevel19:
			if(level<18)
				accessdenied();
			else level19();
			break;
			
		case R.id.blevel20:
			if(level<20)
				accessdenied();
			else level20();
			break;
			
		case R.id.blevel21:
			if(level<21)
				accessdenied();
			else level21();
			break;
			
		case R.id.blevel22:
			if(level<22)
				accessdenied();
			else level22();
			break;
			
		case R.id.blevel23:
			if(level<23)
				accessdenied();
			else level23();
			break;
			
		case R.id.blevel24:
			if(level<24)
				accessdenied();
			else level24();
			break;
			
		case R.id.blevel25:
			if(level<25)
				accessdenied();
			else level25();
			break;
			
		case R.id.blevel26:
			if(level<26)
				accessdenied();
			else level26();
			break;
			
		case R.id.blevel27:
			if(level<27)
				accessdenied();
			else level27();
			break;
			
		case R.id.blevel28:
			if(level<28)
				accessdenied();
			else level28();
			break;
			
		case R.id.blevel29:
			if(level<29)
				accessdenied();
			else level29();
			break;
			
		case R.id.blevel30:
			if(level<30)
				accessdenied();
			else level30();
			break;
			
		}
	
	}
	
	
	
	
	
	public void level1()
	{
		setContentView(R.layout.level1);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("My Name") || ceck.contentEquals("Your Name")
						||ceck.contentEquals("my name") ||ceck.contentEquals("your name"))
				{	
					corect();
					level = 2;
					saveLevel(level-2);
					level2();
				}
				
				
			}
		});
		
		
	}
		
	public void level2()
	{
		setContentView(R.layout.level2);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("1")|| ceck.contentEquals("2")|| ceck.contentEquals("3")|| ceck.contentEquals("4")|| ceck.contentEquals("5")||
						ceck.contentEquals("6")|| ceck.contentEquals("7")|| ceck.contentEquals("8")||
						ceck.contentEquals("9"))
				{	
					corect();
					level=3;
					saveLevel(level-2);
					level3();
				}
				
			}
		});	
	}
	
	public void level3()
	{
		setContentView(R.layout.level3);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("9"))
				{	
					corect();
					level=4;
					saveLevel(level-2);
					level4();
				}
				
			}
		});
			
	}
	
	public void level4()
	{
		setContentView(R.layout.level4);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("Mary") ||ceck.contentEquals("mary"))
				{	
					corect();
					level=5;
					saveLevel(level-2);
					level5();
					
				}
			
			}
		});
			
	}
	
	public void level5()
	{
		setContentView(R.layout.level5);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("FRH") || ceck.contentEquals("frh"))
				{	
					corect();
					level=6;
					saveLevel(level-2);
					level6();
				}
				
			}
		});
			
	}
	
	public void level6()
	{
		setContentView(R.layout.level6);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("650"))
				{	
					corect();
					level=7;
					saveLevel(level-2);
					level7();
				}
				
			}
		});
			
	}
	
	public void level7()
	{
		setContentView(R.layout.level7);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("Easy") || ceck.contentEquals("easy") 
						|| ceck.contentEquals("EASY"))
				{	
					corect();
					level=8;
					saveLevel(level-2);
					level8();
					
				}
				
			}
		});
			
	}
	
	public void level8()
	{
		setContentView(R.layout.level8);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("1322233"))
				{	
					corect();
					level=9;
					saveLevel(level-2);
					level9();
					
				}
				
			}
		});
			
	}
	
	public void level9()
	{
		setContentView(R.layout.level9);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("Rainbow") || ceck.contentEquals("rainbow")
			|| ceck.contentEquals("RAINBOW"))
				{	
					corect();
					level=10;
					saveLevel(level-2);
					level10();
					
				}
				
			}
		});
			
	}
	
	public void level10()
	{
		setContentView(R.layout.level10);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("YOU ARE A GOOD PLAYER") ||
						ceck.contentEquals("You are a good player")
						|| ceck.contentEquals("you are a good player")
						|| ceck.contentEquals("You Are A Good Player"))
				{	
					corect();
					level=11;
					saveLevel(level-2);
					level11();
					
				}
				
			}
		});
			
	}
	
	public void level11()
	{
		setContentView(R.layout.level11);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("you did it again")
						||ceck.contentEquals("You did it again")
						||ceck.contentEquals("YOU DID IT AGAIN"))
				{	
					corect();
					level=12;
					saveLevel(level-2);
					level12();
					
				}
				
			}
		});
			
	}
	
	public void level12()
	{
		setContentView(R.layout.level12);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("Trojan Horse") || ceck.contentEquals("Trojan horse")
						|| ceck.contentEquals("trojan horse") || ceck.contentEquals("TROJAN HORSE"))
				{	
					corect();
					level=13;
					saveLevel(level-2);
					level13();
					
				}
				
			}
		});
			
	}
	
	public void level13()
	{
		setContentView(R.layout.level13);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("8"))
				{	
					corect();
					level=14;
					saveLevel(level-2);
					level14();
					
				}
				
			}
		});
			
	}
	
	public void level14()
	{
		setContentView(R.layout.level14);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("5737"))
				{	
					corect();
					level=15;
					saveLevel(level-2);
					level15();
					
				}
				
			}
		});
			
	}
	
	public void level15()
	{
		setContentView(R.layout.level15);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("Silence") || ceck.contentEquals("silence")
						|| ceck.contentEquals("SILENCE"))
				{	
					corect();
					level=16;
					saveLevel(level-2);
					level16();
					
				}
				
			}
		});
			
	}
	
	public void level16()
	{
		setContentView(R.layout.level16);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("Somalia") || ceck.contentEquals("SOMALIA")
						|| ceck.contentEquals("somalia"))
				{	
					corect();
					level=17;
					saveLevel(level-2);
					level17();
					
				}
				
			}
		});
			
	}
	
	public void level17()
	{
		setContentView(R.layout.level17);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("Isaac Newton")|| ceck.contentEquals("isaac newton")
						|| ceck.contentEquals("ISAAC NEWTON"))
				{	
					corect();
					level=18;
					saveLevel(level-2);
					level18();
					
				}
				
			}
		});
			
	}
	
	public void level18()
	{
		setContentView(R.layout.level18);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("31002"))
				{	
					corect();
					level=19;
					saveLevel(level-2);
					level19();
					
				}
				
			}
		});
			
	}
	
	public void level19()
	{
		setContentView(R.layout.level19);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("MHENUSEHENDHENG") || ceck.contentEquals("Mhenusehendheng")
						|| ceck.contentEquals("mhenusehendheng"))
				{	
					corect();
					level=20;
					saveLevel(level-2);
					level20();
					
				}
				
			}
		});
			
	}
	
	public void level20()
	{
		setContentView(R.layout.level20);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("6"))
				{	
					corect();
					level=21;
					saveLevel(level-2);
					level21();
					
				}
				
			}
		});
			
	}
	
	public void level21()
	{
		setContentView(R.layout.level21);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("7"))
				{	
					corect();
					level=22;
					saveLevel(level-2);
					level22();
					
				}
				
			}
		});
			
	}
	
	public void level22()
	{
		setContentView(R.layout.level22);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("RTGPI") || ceck.contentEquals("rtgpi")
						|| ceck.contentEquals("Rtgpi"))
				{	
					corect();
					level=23;
					saveLevel(level-2);
					level23();
					
				}
				
			}
		});
			
	}
	
	public void level23()
	{
		setContentView(R.layout.level23);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("ThreeAAndSB") || ceck.contentEquals("threeaandsb"))
				{	
					corect();
					level=24;
					saveLevel(level-2);
					level24();
					
				}
				
			}
		});
			
	}
	
	public void level24()
	{
		setContentView(R.layout.level24);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("catwoman") || ceck.contentEquals("Catwoman")
						|| ceck.contentEquals("Catwoman"))
				{	
					corect();
					level=25;
					saveLevel(level-2);
					level25();
					
				}
				
			}
		});
			
	}
	
	public void level25()
	{
		setContentView(R.layout.level25);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("5"))
				{	
					corect();
					level=26;
					saveLevel(level-2);
					level26();
					
				}
				
			}
		});
			
	}
	
	public void level26()
	{
		setContentView(R.layout.level26);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("26"))
				{	
					corect();
					level=27;
					saveLevel(level-2);
					level27();
					
				}
				
			}
		});
			
	}
	
	public void level27()
	{
		setContentView(R.layout.level27);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("142"))
				{	
					corect();
					level=28;
					saveLevel(level-2);
					level28();
					
				}
				
			}
		});
			
	}
	
	public void level28()
	{
		setContentView(R.layout.level28);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("10"))
				{	
					corect();
					level=29;
					saveLevel(level-2);
					level29();
					
				}
			}
		});
			
	}
	
	public void level29()
	{
		setContentView(R.layout.level29);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("21"))
				{	
					corect();
					level=30;
					saveLevel(level-2);
					level30();
					
				}
				
			}
		});
			
	}
	
	public void level30()
	{
		setContentView(R.layout.level30);
		putanswer = (EditText) findViewById (R.id.etputanswer);
		answer = (ImageView) findViewById (R.id.banswer);
		answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ceck = putanswer.getText().toString();
				if (ceck.contentEquals("I AM THE FIRS WHO USE THAT METHOD I AM CAESAR")
						||ceck.contentEquals("I am the first who use that method i am caesar")
						||ceck.contentEquals("I Am The First Who Use That Method I Am Caesar")
						||ceck.contentEquals("i am the first who use that method i am caesar")
						||ceck.contentEquals("iamthefirstwhousethatmethodiamcaesar")
						||ceck.contentEquals("IAMTHEFIRSWHOUSETHATMETHODIAMCAESAR"))
				{	
					corect();
					level=31;
					saveLevel(level-2);
					congrat();
					
				}
				
			}
		});
			
	}
	
	public void saveLevel(int x){

	    //prefs = getSharedPreferences("Sai",Context.MODE_PRIVATE);
	    if (level > levelmax)
		
	    	{
	    		Editor editor = prefs.edit();
	    		editor.putInt("lang_us", level);
	    		editor.commit();
	    //String stringData = levelselect[x].getText().toString();
	    		x++;
	    String stringData = "Level " + x + " completed";
	    Editor editor1 = prefs1.edit();
	    		x--;
	    editor1.putString(file[x], stringData);
	    editor1.commit();
	    	}

	}
	
	
	protected void corect()
	{
		songcorrect = MediaPlayer.create(LevelSelect.this, R.raw.correct);
		songcorrect.start();
	}
	
	
	public void congrat()
	{
		setContentView(R.layout.congratulations);
	}


	protected void accessdenied()
	{
		
		 // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View promptView = layoutInflater.inflate(R.layout.dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        // set prompts.xml to be the layout file of the alertdialog builder
        alertDialogBuilder.setView(promptView);
        // setup a dialog window
        alertDialogBuilder
        .setCancelable(false)
        .setNegativeButton("OK",
        new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
         dialog.cancel();
						} 
                        });
        // create an alert dialog
        AlertDialog alertD = alertDialogBuilder.create(); 
        alertD.show();	
	}
	

	    
	
	    
	 
	

}
