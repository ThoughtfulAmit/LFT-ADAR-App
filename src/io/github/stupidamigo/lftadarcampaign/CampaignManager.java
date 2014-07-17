package io.github.stupidamigo.lftadarcampaign;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CampaignManager extends Activity implements OnClickListener {

	EditText personsEmail, personsName, personsPhn, personsYr;
	String emailAdd, name, phn, yr;
	String vname, pwd, clg;
	Button LftPledge, LftMember;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
		initializeVars();
		LftPledge.setOnClickListener(this);
		LftMember.setOnClickListener(this);
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
		vname = getData.getString("volunteer", "Amit");
		pwd = getData.getString("password", "8860441365");
		clg = getData.getString("college", "BVCOE");
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		switch (arg0.getId()) {
		case R.id.bMember:
			convertETVarsIntoStrings();
			if((vname != "") && (pwd!="") && (clg != "")){
				String emailaddress[] = { emailAdd };
				String message = "Well hello "
						+ name
						+ ",\nYou just became a member of LFT by paying the annual fee of Rs.50 only."
						+ "We welcome you in the ever expanding family of Leaders For Tomorrow. Your details as per our records are: "
						+"\nName: " + name
						+"\nEmail: " + emailAdd
						+"\nPhone No.: "+ phn
						+"\nCollege: " + clg
						+"\nYear: " + yr
						
						+"\nFollow us on Facebook: www.facebook.com/leadersfortomorrow for all the latest happenings and explore great opportunities to enhance your leadeship skills"
						+"\nYou can contact us at leadersfortomorrow@gmail.com in case of any query. We would love to help you!"
						+ "And again, Thanks for becoming a part of ADAR, our awareness campaign, to eradicate the twin menaces of ragging and substance abuse";

				Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
						emailaddress);
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
						"LFT Member via" + vname + "," + clg); 
				//Subject = "ADAR Pledge via" + volunteerName + "," + collegeName 
				emailIntent.setType("plain/text");
				emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
				startActivity(emailIntent);
			}
			else{
				Toast.makeText(getApplicationContext(), "Fill Campaign Manager Preferences",
						Toast.LENGTH_LONG).show();
			}
			
			break;
		case R.id.bPledge:

			convertETVarsIntoStrings();
			if((vname != "") && (pwd!="") && (clg != "")){
				String emailaddress[] = { emailAdd };
				String message = "Well hello "
						+ name
						+ ",\nYou just took a Pledge to stand in favour of Anti-Drug and Anti-Ragging Campaigns."
						+ "We welcome you in the ever expanding family of Leaders For Tomorrow. Your details as per our records are: "
						+"\nName: " + name
						+"\nEmail: " + emailAdd
						+"\nPhone No.: "+ phn
						+"\nCollege: " + ""
						+"\nYear: " + yr
						
						+"\nFollow us on Facebook: www.facebook.com/leadersfortomorrow for all the latest happenings and explore great opportunities to enhance your leadeship skills"
						+"\nYou can contact us at leadersfortomorrow@gmail.com in case of any query. We would love to help you!"
						+ "And again, Thanks for becoming a part of ADAR, our awareness campaign, to eradicate the twin menaces of ragging and substance abuse";

				Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
						emailaddress);
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
						"I hate you!"); 
				//Subject = "ADAR Pledge via" + volunteerName + "," + collegeName 
				emailIntent.setType("plain/text");
				emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
				startActivity(emailIntent);
			}
			else{
				Toast.makeText(getApplicationContext(), "Fill Campaign Manager Preferences",
						Toast.LENGTH_LONG).show();
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
