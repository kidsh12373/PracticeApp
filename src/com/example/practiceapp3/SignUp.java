package com.example.practiceapp3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SignUp extends Activity {

    EditText fillname,fillpassword,fillconfirmpass,filldob,filldeignation,fillphone;
    ImageView sbmt;

    DBhelper myDB;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_sign_up);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        fillname = (EditText)findViewById(R.id.entName);
        fillpassword = (EditText)findViewById(R.id.entPassword);
        fillconfirmpass = (EditText)findViewById(R.id.entConfPass);
        filldob = (EditText)findViewById(R.id.entDob);
        filldeignation = (EditText)findViewById(R.id.entDesignation);
        fillphone = (EditText)findViewById(R.id.entPhone);

        myDB = new DBhelper(SignUp.this);
        
        sbmt = (ImageView)findViewById(R.id.signUp);

        sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = fillname.getText().toString();
                String pass = fillpassword.getText().toString();
                String cpass = fillconfirmpass.getText().toString();
                String dob = filldob.getText().toString();
                String designation = filldeignation.getText().toString();
                String phone = fillphone.getText().toString();

                if(pass.equalsIgnoreCase(cpass))
                {
                	myDB.insertData(name, pass, dob, designation, phone);
                	
                	Intent intentwelcome = new Intent(SignUp.this,WelCome.class);

                	intentwelcome.putExtra("Name", name);
                
                	startActivity(intentwelcome);
                }
                else
                {
                	Toast.makeText(SignUp.this, "Password and confirm password doesn't match...", Toast.LENGTH_LONG).show();
                }
                
            }
        });
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sign_up, menu);
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
