package io.github.stupidamigo.lftadarcampaign;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String classes[] = { "Registration", "Events","IYM", "SDP", "MediaCoverage", "Quotes","GoodnessDays", "ActiveEvents", "ContactUs", "SocialMedia" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this,
				android.R.layout.simple_list_item_1, classes));

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String cheese = classes[position];
		try {
			Class ourClass = Class
					.forName("io.github.stupidamigo.lftadarcampaign." + cheese);
			Intent ourIntent = new Intent(Menu.this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp= getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);
		return true;
	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.m_aboutUs:
			Intent i = new Intent("io.github.stupidamigo.lftadarcampaign.ABOUT");
			startActivity(i);
			break;
		
		/* On clicking back, exited, couldn't resolve at the moment
		case R.id.campaign:
			//String s = "io.github.stupidamigo.lftadarcampaign.CMNGRPREF";
			Intent cmngr_q = new Intent("io.github.stupidamigo.lftadarcampaign.CMNGRPREF");
			startActivity(cmngr_q);
			*/
		case R.id.m_exit:
			finish();
			break;
		}
		return false;

	}	

	
}
