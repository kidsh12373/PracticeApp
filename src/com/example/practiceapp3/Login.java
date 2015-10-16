package com.example.practiceapp3;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {

	EditText mEntUname,mEntPass;
	ImageView imgLogin;
	TextView mBacksignUp;
	
	DBhelper myDB;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		myDB = new DBhelper(Login.this);
		
		mEntUname = (EditText)findViewById(R.id.mLoginUname);
		mEntPass  = (EditText)findViewById(R.id.mLoginUpass);
		
		mBacksignUp = (TextView)findViewById(R.id.backToLogin);
		
		imgLogin =(ImageView)findViewById(R.id.mLoginBtn);
		
		imgLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String name = mEntUname.getText().toString();
				String pass = mEntPass.getText().toString();
				
				myDB.IsValid(name, pass);
				
				Cursor cursor = myDB.IsValid(name, pass);
				
				System.err.println("++++++++++++++" + cursor.getCount());
				
				if(cursor.getCount()==1)
				{
					Toast.makeText(Login.this, "Login Successfully...", Toast.LENGTH_LONG).show();
					
					Intent welcome = new Intent(Login.this,WelCome.class);
					
					welcome.putExtra("Name", name);
					
					startActivity(welcome);
				}
				else
				{
					Toast.makeText(Login.this, "Invalid cradentials...", Toast.LENGTH_LONG).show();
				}
			}
		});
		
		mBacksignUp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent backSignUp = new Intent(Login.this,SignUp.class);
				
				startActivity(backSignUp);
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
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
