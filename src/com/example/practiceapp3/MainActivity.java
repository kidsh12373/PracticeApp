package com.example.practiceapp3;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText mUname,mPass;
    ImageView mImgSubmit;
    TextView mtxtSignUp;
    
    DBhelper myDB;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
        mUname = (EditText)findViewById(R.id.entUname);
        mPass = (EditText)findViewById(R.id.entpass);
        mtxtSignUp = (TextView)findViewById(R.id.txtSignUp);

        mImgSubmit = (ImageView)findViewById(R.id.loginBtn);

        mImgSubmit = (ImageView)findViewById(R.id.loginBtn);
        
        myDB = new DBhelper(MainActivity.this);

        mImgSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	String name = mUname.getText().toString();
				String pass = mPass.getText().toString();
				
				myDB.IsValid(name, pass);
				
				Cursor cursor = myDB.IsValid(name, pass);
				
				System.err.println("++++++++++++++" + cursor.getCount());
				
				if(cursor.getCount()==1)
				{
					Toast.makeText(MainActivity.this, "Login Successfully...", Toast.LENGTH_LONG).show();
					
					Intent welcome = new Intent(MainActivity.this,WelCome.class);
					
					welcome.putExtra("Name", name);
					
					startActivity(welcome);
				}
				else
				{
					Toast.makeText(MainActivity.this, "Invalid cradentials...", Toast.LENGTH_LONG).show();
				}

            }
        });

        mtxtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, SignUp.class);

                startActivity(i);

            }
        });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
