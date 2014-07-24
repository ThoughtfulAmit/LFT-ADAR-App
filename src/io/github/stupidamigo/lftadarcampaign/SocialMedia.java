package io.github.stupidamigo.lftadarcampaign;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SocialMedia extends Activity implements OnClickListener {

	Button b_fb, b_tw;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.socialmedia);

		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		b_fb = (Button) findViewById(R.id.btn_fb);
		b_tw = (Button) findViewById(R.id.btn_tw);
		b_fb.setOnClickListener(this);
		b_tw.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.btn_fb:

			try {

				Intent intent = new Intent(Intent.ACTION_VIEW,
						Uri.parse("fb://page/93836892919"));
				startActivity(intent);
			} catch (Exception e) {
				startActivity(new Intent(Intent.ACTION_VIEW,
						Uri.parse("https://www.facebook.com/LeadersForTomorrow")));
			}
			break;
		case R.id.btn_tw:

			try {

				Intent intent = new Intent(Intent.ACTION_VIEW,
						Uri.parse("twitter://user?screen_name=tweetlft"));
				startActivity(intent);
			} catch (Exception e) {
				startActivity(new Intent(Intent.ACTION_VIEW,
						Uri.parse("https://twitter.com/tweetlft")));
			}
			break;

		}
	}
/*
	public static Intent getOpenFbIntentC(Context context) {
		// TODO Auto-generated method stub
		try {
			context.getPackageManager().getPackageInfo(
					"com.facebook.com.katana", 0);
			return new Intent(Intent.ACTION_VIEW,
					Uri.parse("fb://profile/93836892919"));
		} catch (Exception e) {
			return new Intent(Intent.ACTION_VIEW,
					Uri.parse("https://www.facebook.com/LeadersForTomorrow"));
		}
	}
*/
}
