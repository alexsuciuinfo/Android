package com.findthecode_smartpuzzle.alex;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class Open1 extends Activity{
	
	@Override
	protected void onCreate(Bundle alex) {
		// TODO Auto-generated method stub
		super.onCreate(alex);
		setContentView(R.layout.open1);
		Thread time = new Thread(){
		public void run(){	
			
				try{
					sleep(500);
				} catch (InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openMainActivity = new Intent("com.findthecode_smartpuzzle.alex.MENU");
					startActivity(openMainActivity);
				}
			}
		};
		
	time.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
	
	
}