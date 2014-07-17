package io.github.stupidamigo.lftadarcampaign;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class CMngrPref extends PreferenceActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.cmngr_pref);
	}
}
