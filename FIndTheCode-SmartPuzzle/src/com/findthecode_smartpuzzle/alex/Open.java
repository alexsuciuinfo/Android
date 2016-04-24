package com.findthecode_smartpuzzle.alex;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class Open extends Activity{
	

	
	@Override
	protected void onCreate(Bundle alex) {
		// TODO Auto-generated method stub
		super.onCreate(alex);
		setContentView(R.layout.open);
		Thread time = new Thread(){
		public void run(){	
			
				try{
					sleep(500);
				} catch (InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openMainActivity = new Intent("com.findthecode_smartpuzzle.alex.OPEN1");
					startActivity(openMainActivity);
				}
			}
		};
		
	time.start();
	}


	protected void onPause()
	{
		super.onPause();
		finish();
	}
		
	
}
