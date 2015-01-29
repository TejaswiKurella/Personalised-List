package com.example.search;

import com.example.sitefacs.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(3000);
					
				}
				catch (InterruptedException e){
					e.printStackTrace();
				}
				finally{
					Intent openMainActivity = new Intent("com.example.search.MYFACS");
					startActivity(openMainActivity);
				}
			}
			
		};
		timer.start();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish(); // To destroy the splash activity forever
	}

}
