package com.alex0x123.baloonboom;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Alexandru on 28.06.2015.
 */
public class CharacterMenu extends Activity {


    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.character);


        final TextView score = (TextView) findViewById(R.id.textView2);
        final TextView coins = (TextView) findViewById(R.id.textView3);

        final CheckBox c1 = (CheckBox) findViewById(R.id.checkBox);
        final CheckBox c2 = (CheckBox) findViewById(R.id.checkBox2);
        final CheckBox c3 = (CheckBox) findViewById(R.id.checkBox3);
        final CheckBox c4 = (CheckBox) findViewById(R.id.checkBox4);
        final CheckBox c5 = (CheckBox) findViewById(R.id.checkBox5);
        final CheckBox c6 = (CheckBox) findViewById(R.id.checkBox6);

        final Button b1 = (Button) findViewById(R.id.button);
        final Button b2 = (Button) findViewById(R.id.button2);
        final Button b3 = (Button) findViewById(R.id.button3);
        final Button b4 = (Button) findViewById(R.id.button4);
        final Button b5 = (Button) findViewById(R.id.button5);
        final Button b6 = (Button) findViewById(R.id.button6);


        SharedPreferences prefs1 = getSharedPreferences("saves", MODE_PRIVATE);
        SharedPreferences.Editor ed = prefs1.edit();
        int s = prefs1.getInt("caracter", 0);
        int c = prefs1.getInt("money", 0);
        int sc = prefs1.getInt("score",0);
        Boolean car2 = prefs1.getBoolean("c2", false);
        Boolean car3 = prefs1.getBoolean("c3", false);
        Boolean car4 = prefs1.getBoolean("c4",false);
        Boolean car5 = prefs1.getBoolean("c5",false);
        Boolean car6 = prefs1.getBoolean("c6",false);



        //set coins

        StringBuilder sb1 = new StringBuilder();
        sb1.append("");
        sb1.append(c);
        String money11 = sb1.toString();
        coins.setText(money11);

        //set score

        StringBuilder sb2 = new StringBuilder();
        sb2.append("SCORE : ");
        sb2.append(sc);
        String scors = sb2.toString();
        score.setText(scors);


        //set character status locked or unlocked

        if(car2) b2.setText("Unlocked");
        if(car3) b3.setText("Unlocked");
        if(car4) b4.setText("Unlocked");
        if(car5) b5.setText("Unlocked");
        if(car6) b6.setText("Unlocked");




        //set character choosen
        switch(s){

            case 1 : c1.setChecked(true); break;
            case 2 : c2.setChecked(true); break;
            case 3 : c3.setChecked(true); break;
            case 4 : c4.setChecked(true); break;
            case 5 : c5.setChecked(true); break;
            case 6 : c6.setChecked(true); break;
            default : c1.setChecked(true);  ed.putInt("caracter",1); ed.commit();
        }


        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c1.setChecked(true);
                c2.setChecked(false);
                c3.setChecked(false);
                c4.setChecked(false);
                c5.setChecked(false);
                c6.setChecked(false);
                SharedPreferences prefs = getSharedPreferences("saves", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("caracter", 1);
                editor.commit();

            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(b2.getText().toString().equals("Buy it"))
                {
                    c2.setChecked(false);
                    Toast.makeText(getApplicationContext(), "Character is locked",
                            Toast.LENGTH_LONG).show();

                }
                else {
                    c1.setChecked(false);
                    c2.setChecked(true);
                    c3.setChecked(false);
                    c4.setChecked(false);
                    c5.setChecked(false);
                    c6.setChecked(false);
                    SharedPreferences prefs = getSharedPreferences("saves",MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt("caracter", 2);
                    editor.commit();
                }

            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(b3.getText().toString().equals("Buy it"))
                {
                    c3.setChecked(false);
                    Toast.makeText(getApplicationContext(), "Character is locked",
                            Toast.LENGTH_LONG).show();

                }
                else {
                    c1.setChecked(false);
                    c2.setChecked(false);
                    c3.setChecked(true);
                    c4.setChecked(false);
                    c5.setChecked(false);
                    c6.setChecked(false);
                    SharedPreferences prefs = getSharedPreferences("saves",MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt("caracter", 3);
                    editor.commit();
                }

            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(b4.getText().toString().equals("Buy it"))
                {
                    c4.setChecked(false);
                    Toast.makeText(getApplicationContext(), "Character is locked",
                            Toast.LENGTH_LONG).show();

                }
                else {
                    c1.setChecked(false);
                    c2.setChecked(false);
                    c3.setChecked(false);
                    c4.setChecked(true);
                    c5.setChecked(false);
                    c6.setChecked(false);
                    SharedPreferences prefs = getSharedPreferences("saves",MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt("caracter", 4);
                    editor.commit();
                }

            }
        });

        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(b5.getText().toString().equals("Buy it"))
                {
                    c5.setChecked(false);
                    Toast.makeText(getApplicationContext(), "Character is locked",
                            Toast.LENGTH_LONG).show();

                }
                else {
                    c1.setChecked(false);
                    c2.setChecked(false);
                    c3.setChecked(false);
                    c4.setChecked(false);
                    c5.setChecked(true);
                    c6.setChecked(false);
                    SharedPreferences prefs = getSharedPreferences("saves",MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt("caracter", 5);
                    editor.commit();
                }

            }
        });

        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(b6.getText().toString().equals("Buy it"))
                {
                    c6.setChecked(false);
                    Toast.makeText(getApplicationContext(), "Character is locked",
                            Toast.LENGTH_LONG).show();

                }
                else {
                    c1.setChecked(false);
                    c2.setChecked(false);
                    c3.setChecked(false);
                    c4.setChecked(false);
                    c5.setChecked(false);
                    c6.setChecked(true);
                    SharedPreferences prefs = getSharedPreferences("saves",MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt("caracter", 6);
                    editor.commit();
                }

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs = getSharedPreferences("saves",MODE_PRIVATE);
                int money = prefs.getInt("money", 0);
                SharedPreferences.Editor editor = prefs.edit();
                if(money > 250)
                {
                    money = money - 250;
                    editor.putInt("money", money);
                    Toast.makeText(getApplicationContext(), "You unlock character",
                            Toast.LENGTH_LONG).show();
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(money);
                    String money1 = sb.toString();
                    coins.setText(money1);
                    editor.putBoolean("c2", true);
                    editor.commit();
                    b2.setText("Unlocked");
                }

                else{

                    Toast.makeText(getApplicationContext(), "You don't have enough coins",
                            Toast.LENGTH_LONG).show();
                }


            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs = getSharedPreferences("saves",MODE_PRIVATE);
                int money = prefs.getInt("money", 0);
                SharedPreferences.Editor editor = prefs.edit();
                if(money > 500)
                {
                    money = money - 500;
                    editor.putInt("money", money);
                    Toast.makeText(getApplicationContext(), "You unlock character",
                            Toast.LENGTH_LONG).show();
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(money);
                    String money1 = sb.toString();
                    coins.setText(money1);
                    editor.putBoolean("c3", true);
                    editor.commit();
                    b3.setText("Unlocked");
                }

                else{

                    Toast.makeText(getApplicationContext(), "You don't have enough coins",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs = getSharedPreferences("saves",MODE_PRIVATE);
                int money = prefs.getInt("money", 0);
                SharedPreferences.Editor editor = prefs.edit();
                if(money > 750)
                {
                    money = money - 750;
                    editor.putInt("money", money);
                    Toast.makeText(getApplicationContext(), "You unlock character",
                            Toast.LENGTH_LONG).show();
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(money);
                    String money1 = sb.toString();
                    coins.setText(money1);
                    editor.putBoolean("c4", true);
                    editor.commit();
                    b4.setText("Unlocked");
                }

                else{

                    Toast.makeText(getApplicationContext(), "You don't have enough coins",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs = getSharedPreferences("saves",MODE_PRIVATE);
                int money = prefs.getInt("money", 0);
                SharedPreferences.Editor editor = prefs.edit();
                if(money > 1000)
                {
                    money = money - 1000;
                    editor.putInt("money", money);
                    Toast.makeText(getApplicationContext(), "You unlock character",
                            Toast.LENGTH_LONG).show();
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(money);
                    String money1 = sb.toString();
                    coins.setText(money1);
                    editor.putBoolean("c5", true);
                    editor.commit();
                    b5.setText("Unlocked");
                }

                else{

                    Toast.makeText(getApplicationContext(), "You don't have enough coins",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs = getSharedPreferences("saves",MODE_PRIVATE);
                int money = prefs.getInt("money", 0);
                SharedPreferences.Editor editor = prefs.edit();
                if(money > 1500)
                {
                    money = money - 1500;
                    editor.putInt("money", money);
                    Toast.makeText(getApplicationContext(), "You unlock character",
                            Toast.LENGTH_LONG).show();
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(money);
                    String money1 = sb.toString();
                    coins.setText(money1);
                    editor.putBoolean("c6", true);
                    editor.commit();
                    b6.setText("Unlocked");
                }

                else{

                    Toast.makeText(getApplicationContext(), "You don't have enough coins",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        Intent intent = new Intent(CharacterMenu.this, MainMenu.class);
        startActivity(intent);
        finish();
    }




    }
