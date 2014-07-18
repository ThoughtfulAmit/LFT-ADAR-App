package io.github.stupidamigo.lftadarcampaign;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CampaignManager extends Activity implements OnClickListener {

	EditText personsEmail, personsName, personsPhn, personsYr;
	String emailAdd, name, phn, yr;
	String vname, pwd, clg;
	Button LftPledge, LftMember;
	InputMethodManager imm1, imm2, imm3, imm4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
		initializeVars();
		LftPledge.setOnClickListener(this);
		LftMember.setOnClickListener(this);
		
		//for hiding the Keyboard after using an EditText
		imm1 =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		imm2 =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		imm3 =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		imm4 =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		

	}

	private void initializeVars() {
		// TODO Auto-generated method stub
		personsName = (EditText) findViewById(R.id.etName);
		personsEmail = (EditText) findViewById(R.id.etEmails);
		personsPhn = (EditText) findViewById(R.id.etPhn);
		personsYr = (EditText) findViewById(R.id.etYr);

		LftPledge = (Button) findViewById(R.id.bPledge);
		LftMember = (Button) findViewById(R.id.bMember);

		SharedPreferences getData = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		vname = getData.getString("volunteer", "");
		pwd = getData.getString("password", "");
		clg = getData.getString("college", "");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.m_cmngr, menu);
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {

		case R.id.cm_campaign:

			Intent cmngr_q = new Intent(
					"io.github.stupidamigo.lftadarcampaign.CMNGRPREF");
			startActivity(cmngr_q);

		case R.id.cm_exit:
			finish();
			break;
		}
		return false;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		switch (arg0.getId()) {
		case R.id.bMember:
			
			//hiding keyboard
			imm1.hideSoftInputFromWindow(personsName.getWindowToken(), 0);
			imm2.hideSoftInputFromWindow(personsEmail.getWindowToken(), 0);
			imm3.hideSoftInputFromWindow(personsPhn.getWindowToken(), 0);
			imm4.hideSoftInputFromWindow(personsYr.getWindowToken(), 0);
			
			convertETVarsIntoStrings();
			if ((vname.contentEquals("")) || (pwd.contentEquals(""))
					|| (clg.contentEquals(""))) {
				Toast.makeText(getApplicationContext(),
						"Fill Campaign Manager Settings", Toast.LENGTH_LONG)
						.show();
			} else {
				
				String emailaddress[] = { emailAdd };
				String[] BCC = {"coreteam.lft@gmail.com"};
				String message = "Well hello "
						+ name
						+ ",\nYou just became a member of LFT by paying the annual fee of Rs.50 only."
						+ "We welcome you in the ever expanding family of Leaders For Tomorrow. Your details as per our records are: "
						+ "\nName: "
						+ name
						+ "\nEmail: "
						+ emailAdd
						+ "\nPhone No.: "
						+ phn
						+ "\nCollege: "
						+ clg
						+ "\nYear: "
						+ yr

						+ "\nFollow us on Facebook: www.facebook.com/leadersfortomorrow for all the latest happenings and explore great opportunities to enhance your leadeship skills"
						+ "\nYou can contact us at leadersfortomorrow@gmail.com in case of any query. We would love to help you!"
						+ "And again, Thanks for becoming a part of ADAR, our awareness campaign, to eradicate the twin menaces of ragging and substance abuse";

				Intent emailIntent = new Intent(
						android.content.Intent.ACTION_SEND);
				
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
						emailaddress);
				emailIntent.putExtra(Intent.EXTRA_BCC, BCC);
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
						"LFT Member via " + vname + "," + clg);
				// Subject = "ADAR Member via" + volunteerName + "," +
				// collegeName
				emailIntent.setType("plain/text");
				emailIntent
						.putExtra(android.content.Intent.EXTRA_TEXT, message);
				startActivity(emailIntent);
			}

			break;
		case R.id.bPledge:

			//hiding keyboard
			imm1.hideSoftInputFromWindow(personsName.getWindowToken(), 0);
			imm2.hideSoftInputFromWindow(personsEmail.getWindowToken(), 0);
			imm3.hideSoftInputFromWindow(personsPhn.getWindowToken(), 0);
			imm4.hideSoftInputFromWindow(personsYr.getWindowToken(), 0);
			
			convertETVarsIntoStrings();
			if ((vname.contentEquals("")) || (pwd.contentEquals(""))
					|| (clg.contentEquals(""))) {
				Toast.makeText(getApplicationContext(),
						"Fill Campaign Manager Settings", Toast.LENGTH_LONG)
						.show();
			} else {
				String emailaddress[] = { emailAdd };
				String[] BCC = {"coreteam.lft@gmail.com"};
				
				String message = "Well hello "
						+ name
						+ ",\nYou just took a Pledge to stand in favour of Anti-Drug and Anti-Ragging Campaigns. You can also become a member of LFT by paying the annual fee of Rs.50 only."
						+ "We welcome you in the ever expanding family of Leaders For Tomorrow. Your details as per our records are: "
						+ "\nName: "
						+ name
						+ "\nEmail: "
						+ emailAdd
						+ "\nPhone No.: "
						+ phn
						+ "\nCollege: "
						+ clg
						+ "\nYear: "
						+ yr

						+ "\nFollow us on Facebook: www.facebook.com/leadersfortomorrow for all the latest happenings and explore great opportunities to enhance your leadeship skills"
						+ "\nYou can contact us at leadersfortomorrow@gmail.com in case of any query. We would love to help you!"
						+ "And again, Thanks for becoming a part of ADAR, our awareness campaign, to eradicate the twin menaces of ragging and substance abuse";

				Intent emailIntent = new Intent(
						android.content.Intent.ACTION_SEND);
				
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
						emailaddress);
				emailIntent.putExtra(Intent.EXTRA_BCC, BCC);
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
						"LFT Pledge via " + vname + "," + clg);
				// Subject = "ADAR Pledge via" + volunteerName + "," +
				// collegeName
				emailIntent.setType("plain/text");
				emailIntent
						.putExtra(android.content.Intent.EXTRA_TEXT, message);
				startActivity(emailIntent);
			}

			break;
		}

	}

	private void convertETVarsIntoStrings() {
		// TODO Auto-generated method stub
		emailAdd = personsEmail.getText().toString();
		name = personsName.getText().toString();
		phn = personsPhn.getText().toString();
		yr = personsYr.getText().toString();

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
