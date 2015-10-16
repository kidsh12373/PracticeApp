package com.example.practiceapp3;

import com.example.practiceapp3.Fragments.AccountFragment;
import com.example.practiceapp3.Fragments.BlogsFragment;
import com.example.practiceapp3.Fragments.DashBoardFragment;
import com.example.practiceapp3.Fragments.DepartmentFragment;
import com.example.practiceapp3.Fragments.EventFragment;
import com.example.practiceapp3.Fragments.GallaryFragment;
import com.example.practiceapp3.Fragments.LeavesFragment;
import com.example.practiceapp3.Fragments.LogoutFragment;
import com.example.practiceapp3.Fragments.MessageFragment;
import com.example.practiceapp3.Fragments.NotificationFragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NavActivity extends Activity {

	private String[] mPlanetTitles;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_nav);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		
		mPlanetTitles = getResources().getStringArray(R.array.planets_array);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		
		mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mPlanetTitles));

		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

	}

	private class DrawerItemClickListener implements ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			// TODO Auto-generated method stub
			selectItem(position);
		}
	}
	
	private void selectItem(int position) {
		// update the main content by replacing fragments

		Fragment fragment = null;
		switch (position) {
		case 0:

			fragment = new DashBoardFragment();
			
			break;

		case 1:
			fragment = new AccountFragment();

			break;

		case 2:
			fragment = new DepartmentFragment();

			break;

		case 3:
			fragment = new EventFragment();

			break;

		case 4:
			fragment = new GallaryFragment();

			break;

		case 5:
			fragment = new BlogsFragment();

			break;

		case 6:
			fragment = new MessageFragment();

			break;
			
		case 7:
			fragment = new NotificationFragment();

			break;
			
		case 8:
			fragment = new LeavesFragment();

			break;

		case 9:
			fragment = new LogoutFragment();

			break;	
		
		default:
			break;
		}
		}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nav, menu);
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
