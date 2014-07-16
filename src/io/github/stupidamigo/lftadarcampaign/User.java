package io.github.stupidamigo.lftadarcampaign;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.app.Activity;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;
import android.preference.PreferenceManager;

public class User extends ActionBarActivity {

	Button bstart, bstop;
	MediaPlayer scream;
	Button sendBtn;
	EditText txtphoneNo1, txtphoneNo2, txtphoneNo3;
	EditText txtMessage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user);

		scream = MediaPlayer.create(User.this,
				R.raw.stupid_amigo_deranged_women_scream);
		bstart = (Button) findViewById(R.id.button1);
		bstop = (Button) findViewById(R.id.button2);

		scream.setLooping(true);
		bstart.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				scream.start();
			}

		});

		bstop.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (scream.isPlaying()) {
					scream.pause();
				}
			}
		});
		
		/*
		SharedPreferences getData = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String et1 = getData.getString("num1", "8860441365");
		String et2 = getData.getString("num2", "8860441365");
		String et3 = getData.getString("num3", "8860441365");
		
		if(et1.contentEquals("123")){
			//question.setText(et);
			txtphoneNo1.setText("123 added");
		}
*/
		sendBtn = (Button) findViewById(R.id.button4);
		txtphoneNo1 = (EditText) findViewById(R.id.editTextPhoneNo1);
		txtphoneNo2 = (EditText) findViewById(R.id.editTextPhoneNo2);
		txtphoneNo3 = (EditText) findViewById(R.id.editTextPhoneNo3);
		txtMessage = (EditText) findViewById(R.id.editTextSMS);

		sendBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				sendSMSMessage();
				txtphoneNo1.setText("");
				txtphoneNo2.setText("");
				txtphoneNo3.setText("");
				txtMessage.setText("");
			}
		});

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
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
			Toast.makeText(getApplicationContext(), "SMS sent.",
					Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			
			Toast.makeText(getApplicationContext(),
					errorMsg + "1st phone no.", Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
		try {
			smsManager.sendTextMessage(phoneNo2, null, message, null, null);
			Toast.makeText(getApplicationContext(), "SMS sent.",
					Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			
			Toast.makeText(getApplicationContext(),
					errorMsg + "2nd phone no.", Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
		try {
			smsManager.sendTextMessage(phoneNo3, null, message, null, null);
			Toast.makeText(getApplicationContext(), "SMS sent.",
					Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(),
					errorMsg + "3rd phone no.", Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user, menu);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_user, container,
					false);
			return rootView;
		}
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		scream.release();
		finish();
	}

}
