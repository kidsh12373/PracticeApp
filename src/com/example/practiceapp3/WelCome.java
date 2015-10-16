package com.example.practiceapp3;

import java.util.jar.Attributes.Name;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class WelCome extends Activity {

	TextView dspyName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wel_come);
		
		dspyName = (TextView)findViewById(R.id.signInUser);
		
		String UserName = getIntent().getStringExtra("Name"); 
		
		dspyName.setText("Welcome "+ UserName);
		
		dspyName.startAnimation(AnimationUtils.loadAnimation(WelCome.this, android.R.anim.slide_in_left));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wel_come, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
