package io.github.stupidamigo.lftadarcampaign;

import java.util.HashMap;
import java.util.Set;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Quotes extends Activity implements OnClickListener{

	TextView tv_q;
	Button b_q;
	Set<String> keys;
	HashMap<String, String> hm;
	Integer count_q=1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quotes);
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		tv_q = (TextView) findViewById(R.id.tv_quotes);
		b_q = (Button) findViewById(R.id.btn_q);
		b_q.setOnClickListener(this);
		hm = new HashMap<String, String>();
        //add key-value pair to hashmap
        hm.put("1", "The world has the habit of making room for the man whose words and actions show that he knows where he is going \n-Napoleon Hill");
        hm.put("2", "Circumstance does not make the man; it reveals him to himself \n-James Allen ");
        hm.put("3","The greater danger for most of us is not that our aim is too high and we miss it, but that it is too low and we reach it \n-Michelangelo ");
        
        
        
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.btn_q:
			if(count_q <3){
				tv_q.setText("Thought of the Day: \n\n" + hm.get(count_q.toString()));
				count_q++;
				b_q.setText("Next Thought");
			}else{
				tv_q.setText("Thought of the Day: \n\n" + hm.get(count_q.toString()));
				b_q.setText("That's It, Folks!");
			}
			
		
			break;
		
			
		}
	}

}
