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

public class ContactUs extends Activity implements OnClickListener {

	EditText personsName, personsPhn, personsMessage, personsCollege;
	String name, phn, msg, clg;

	Button LftSend;
	InputMethodManager imm1, imm2, imm3, imm4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contactus);
		initializeVars();
		LftSend.setOnClickListener(this);

		// for hiding the Keyboard after using an EditText
		imm1 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm2 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm3 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm4 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
	}

	private void initializeVars() {
		// TODO Auto-generated method stub
		personsName = (EditText) findViewById(R.id.etName_cu);
		personsPhn = (EditText) findViewById(R.id.etPhn_cu);
		personsCollege = (EditText) findViewById(R.id.etClg_cu);
		personsMessage = (EditText) findViewById(R.id.etMessage_cu);

		LftSend = (Button) findViewById(R.id.bSendMail_cu);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		switch (arg0.getId()) {
		case R.id.bSendMail_cu:

			// hiding keyboard
			imm1.hideSoftInputFromWindow(personsName.getWindowToken(), 0);
			imm2.hideSoftInputFromWindow(personsPhn.getWindowToken(), 0);
			imm3.hideSoftInputFromWindow(personsCollege.getWindowToken(), 0);
			imm4.hideSoftInputFromWindow(personsMessage.getWindowToken(), 0);

			convertETVarsIntoStrings();

			String emailaddress[] = { "president.lft@gmail.com" };
			
			String message = "Dear LFT President,"
					+"\nMy message is: "+"\n"+msg+"\n\nMy details are:"
					+"\nName: "+name
					+"\nPhn No.: "+phn
					+"\nCollege: "+clg;

			Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

			emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
					emailaddress);
			
			emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
					"LFT Query");
			// Subject = "ADAR Member via" + volunteerName + "," +
			// collegeName
			emailIntent.setType("plain/text");
			emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
			startActivity(emailIntent);

			break;
		
		}

	}

	private void convertETVarsIntoStrings() {
		// TODO Auto-generated method stub

		name = personsName.getText().toString();
		phn = personsPhn.getText().toString();
		clg = personsCollege.getText().toString();
		msg = personsMessage.getText().toString();

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
