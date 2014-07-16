package io.github.stupidamigo.lftadarcampaign;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserOpen extends Activity implements OnClickListener {

	
	
	EditText txtphoneNo1, txtphoneNo2, txtphoneNo3;
	EditText txtMessage;
	Button sendBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_open);
		initialize();

		/*
		SharedPreferences getData = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		String et = getData.getString("num1", "8860441365");
		
		if (et.contentEquals("123")) {
			txtphoneNo1.setText(et);
		}
		*/
	}

	private void initialize() {
		// TODO Auto-generated method stub
		txtphoneNo1 = (EditText) findViewById(R.id.editTextPhoneNo1);
		txtphoneNo2 = (EditText) findViewById(R.id.editTextPhoneNo2);
		txtphoneNo3 = (EditText) findViewById(R.id.editTextPhoneNo3);
		txtMessage = (EditText) findViewById(R.id.editTextSMS);
		
		sendBtn = (Button) findViewById(R.id.button4);
		sendBtn.setOnClickListener(this);
		
		
	}
	protected void sendSMSMessage() {
		Log.i("Send SMS", "");

		String phoneNo1 = txtphoneNo1.getText().toString();
		String phoneNo2 = txtphoneNo2.getText().toString();
		String phoneNo3 = txtphoneNo3.getText().toString();
		String message = txtMessage.getText().toString();
		String errorMsg = "SMS delivery failed on ";
		message += " \nI'm in EMERGENCY. Please HELP me!!";
		SmsManager smsManager = SmsManager.getDefault();
		try {
			// SmsManager smsManager = SmsManager.getDefault();
			smsManager.sendTextMessage(phoneNo1, null, message, null, null);
			// smsManager.sendTextMessage(phoneNo2, null, message, null, null);
			// smsManager.sendTextMessage(phoneNo3, null, message, null, null);
			Toast.makeText(getApplicationContext(), "SMS sent on 1st phone no.",
					Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			
			Toast.makeText(getApplicationContext(),
					errorMsg + "1st phone no.", Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
		try {
			smsManager.sendTextMessage(phoneNo2, null, message, null, null);
			Toast.makeText(getApplicationContext(), "SMS sent on 2nd phone no.",
					Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			
			Toast.makeText(getApplicationContext(),
					errorMsg + "2nd phone no.", Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
		try {
			smsManager.sendTextMessage(phoneNo3, null, message, null, null);
			Toast.makeText(getApplicationContext(), "SMS sent on 3rd phone no.",
					Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(),
					errorMsg + "3rd phone no.", Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		
		case R.id.button4:
			sendSMSMessage();
			txtphoneNo1.setText("");
			txtphoneNo2.setText("");
			txtphoneNo3.setText("");
			txtMessage.setText("");
			break;
			
		}
	}

}
