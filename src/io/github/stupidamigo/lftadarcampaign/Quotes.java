package io.github.stupidamigo.lftadarcampaign;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Quotes extends Activity implements OnClickListener {

	TextView tv_q;
	Button b_q, b_share;
	Set<String> keys;
	HashMap<String, String> hm;
	Integer count_q = 1;
	String s_quote;
	Random r;

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
		b_share = (Button) findViewById(R.id.btn_share);
		b_q.setOnClickListener(this);
		b_share.setOnClickListener(this);
		
		hm = new HashMap<String, String>();
		// add key-value pair to hashmap
		hm.put("1",	"The world has the habit of making room for the man whose words and actions show that he knows where he is going. \n\n-Napoleon Hill");
		hm.put("2",	"Circumstance does not make the man; it reveals him to himself. \n\n-James Allen ");
		hm.put("3", "The greater danger for most of us is not that our aim is too high and we miss it, but that it is too low and we reach it. \n\n-Michelangelo ");
		hm.put("4", "Your life is in your hands, to make of it what you choose. \n\n-John Kehoe ");
		hm.put("5", "Let others lead small lives, but not you. Let others argue over small things, but not you. Let others cry over small hurts, but not you. Let others leave their future in someone else's hands, but not you. \n\n-Jim Rohn ");
		hm.put("6", "I challenge you to make your life a masterpiece. I challenge you to join the ranks of those people who live what they teach, who walk their talk. \n\n-Anthony Robbins ");
		hm.put("7", "The secret of getting ahead is getting started. \n\n-Mark Twain ");
		hm.put("8", "For true success ask yourself these four questions: Why? Why not? Why not me? Why not now? \n\n-James Allen ");
		hm.put("9", "Issue a blanket pardon. Forgive everyone who has ever hurt you in any way. Forgiveness is a perfectly selfish act. It sets you free from the past. \n\n-Brian Tracy ");
		hm.put("10", "Our greatest glory is not in never failing but in rising up every time we fail. \n\n-Ralph Waldo Emerson ");
		hm.put("11", "Learn to enjoy every minute of your life. Be happy now. Don't wait for something outside of yourself to make you happy in the future. Think how really precious is the time you have to spend, whether it's at work or with your family. Every minute should be enjoyed and savoured. \n\n-Earl Nightingale ");
		hm.put("12", "Far better it is to dare mighty things, to win glorious triumphs, even though chequered by failure, than to take rank with those poor souls who neither enjoy much nor suffer much, because they live in the grey twilight that knows neither victory nor defeat. \n\n-Theodore Roosevelt ");
		hm.put("13", "We are what we repeatedly do. Excellence, then, is not an act, but a habit. \n\n-Aristotle ");
		hm.put("14", "Impossible is a word to be found only in the dictionary of fools. \n\n-Napoleon Bonaparte ");
		hm.put("15", "Twenty years from now you will be more disappointed by the things that you didn't do than by the ones you did do. So throw off the bowlines. Sail away from the safe harbour. Catch the trade winds in your sails. Explore. Dream. Discover. \n\n-Mark Twain ");
		hm.put("16", "The only way of finding the limits of the possible is by going beyond them into the impossible. \n\n-Arthur C. Clarke ");
		hm.put("17", "It is hard to fail, but it is worse never to have tried to succeed. \n\n-Theodore Roosevelt ");
		hm.put("18", "Fortune favours the brave. \n\n-Publius Terence ");
		hm.put("19", "Ah, but a man's reach should exceed his grasp, or what's a heaven for? \n\n-Robert Browning ");
		hm.put("20", "People often say that motivation doesn't last. Well, neither does bathing - that's why we recommend it daily. \n\n-Zig Ziglar ");
		hm.put("21", "Desire is the starting point of all achievement, not a hope, not a wish, but a keen pulsating desire, which transcends everything. \n\n-Napoleon Hill ");
		hm.put("22", "People become really quite remarkable when they start thinking that they can do things. When they believe in themselves they have the first secret of success. \n\n-Norman Vincent Peale ");
		hm.put("23", "Men are born to succeed, not fail. \n\n-Henry David Thoreau ");
		hm.put("24", "What we can or cannot do, what we consider possible or impossible, is rarely a function of our true capability. It is more likely a function of our beliefs about who we are. \n\n-Anthony Robbins ");
		hm.put("25", "Every human has four endowments- self-awareness, conscience, independent will and creative imagination. These give us the ultimate human freedom... The power to choose, to respond, to change. \n\n-Stephen Covey ");
		hm.put("26", "All the breaks you need in life wait within your imagination, Imagination is the workshop of your mind, capable of turning mind energy into accomplishment and wealth. \n\n-Napoleon Hill ");
		hm.put("27", "There is just one life for each of us:  our own. \n\n-Euripides ");
		hm.put("28", "If you believe in what you are doing, then let nothing hold you up in your work. Much of the best work of the world has been done against seeming impossibilities. \n\n-Dale Carnegie");
		hm.put("29", "There is no such thing in anyone's life as an unimportant day. \n\n-Alexander Woollcott");
		hm.put("30", "All successful people men and women are big dreamers. They imagine what their future could be, ideal in every respect, and then they work every day toward their distant vision, that goal or purpose. \n\n-Brian Tracy");
		hm.put("31", "The fear of death follows from the fear of life.  A man who lives fully is prepared to die at any time. \n\n-Mark Twain ");
		hm.put("32", "There are no accidents... there is only some purpose that we haven't yet understood. \n\n-Deepak Chopra");
		hm.put("33", "They can because they think they can. \n\n-Virgil");
		hm.put("34", "There are those who dream and wish and there are those who dream and work. \n\n-Jeune.E. McIntyre");
		hm.put("35", "No man is a failure who is enjoying life. \n\n-William Feather");
		hm.put("36", "Death is not the biggest fear we have; our biggest fear is taking the risk to be alive -- the risk to be alive and express what we really are. \n\n-Don Miguel Ruiz");
		hm.put("37", "Be miserable. Or motivate yourself. Whatever has to be done, it's always your choice. \n\n-Wayne Dyer");
		hm.put("38", "You and I are essentially infinite choice-makers. In every moment of our existence, we are in that field of all possibilities where we have access to an infinity of choices. \n\n-Deepak Chopra");
		hm.put("39", "You can have anything you want, if you want it badly enough.  You can be anything you want to be, do anything you set out to accomplish if you hold to that desire with singleness of purpose. \n\n-Abraham Lincoln");
		hm.put("40", "If you deliberately plan on being less than you are capable of being, then I warn you that you'll be unhappy for the rest of your life. \n\n-Abraham H. Maslow");
		hm.put("41", "Remember, happiness doesn't depend upon who you are or what you have, it depends solely upon what you think. \n\n-Dale Carnegie");
		hm.put("42", "The only man who never makes mistakes is the man who never does anything. \n\n-Theodore Roosevelt");
		hm.put("43", "Self-pity gets you nowhere. One must have the adventurous daring to accept oneself as a bundle of possibilities and undertake the most interesting game in the world -- making the most of one's best. \n\n-Harry Emerson Fosdick");
		hm.put("44", "Man's mind, once stretched by a new idea, never regains its original dimensions. \n\n-Oliver Wendell Holmes, Jr");
		hm.put("45", "The nearest way to glory is to strive to be what you wish to be thought to be. \n\n-Socrates");
		hm.put("46", "The man who trims himself to suit everybody will soon whittle himself away. \n\n-Charles Schwab");
		hm.put("47", "Do not go where the path may lead, go instead where there is no path and leave a trail. \n\n-Ralph Waldo Emerson");
		hm.put("48", "At least three times every day take a moment and ask yourself what is really important. Have the wisdom and the courage to build your life around your answer. \n\n-Lee Jampolsky");
		hm.put("49", "To be yourself in a world that is constantly trying to make you something else is the greatest accomplishment. \n\n-Ralph Waldo Emerson");
		hm.put("50", "It’s not who you are that holds you back, it’s who you think you’re not. \n\n-Unknown");
		hm.put("51", "Simplicity is the key to brilliance. \n\n-Bruce Lee");
		hm.put("52", "There is no end.  There is no beginning. There is only the infinite passion of life. \n\n-Federico Fellini");
		hm.put("53", "Work as though you would live forever, and live as though you would die today. \n\n-Og Mandino");
		hm.put("54", "What the mind of man can conceive and believe, the mind of man can achieve. \n\n-Napoleon Hill");
		hm.put("55", "Know the true value of time; snatch, seize, and enjoy every moment of it. No idleness, no delay, no procrastination; never put off till tomorrow what you can do today. \n\n-Earl of Chesterfield");
		hm.put("56", "Finish each day and be done with it. You have done what you could; some blunders and absurdities have crept in; forget them as soon as you can. Tomorrow is a new day; you shall begin it serenely and with too high a spirit to be encumbered with your old nonsense. \n\n-Ralph Waldo Emerson");
		hm.put("57", "Consult not your fears but your hopes and your dreams. Think not about your frustrations, but about your unfulfilled potential. Concern yourself not with what you tried and failed in, but with what it is still possible for you to do. \n\n-Pope John XXIII");
		hm.put("58", "Look at a day when you are supremely satisfied at the end. It's not a day when you lounge around doing nothing, it's when you've had everything to do and you've done it. \n\n-Margaret Thatcher");
		hm.put("59", "You must be the change you wish to see in the world. \n\n-Mahatma Gandhi");
		hm.put("60", "The future belongs to those who believe in the beauty of their dreams. \n\n-Eleanor Roosevelt");
		hm.put("61", "Everything that is happening at this moment is a result of the choices you've made in the past. \n\n-Deepak Chopra");
		hm.put("62", "Cherish your visions and your dreams, as they are the children of your soul, the blueprints of your ultimate achievements. \n\n-Napoleon Hill");
		hm.put("63", "Successful people make money. It's not that people who make money become successful, but that successful people attract money. They bring success to what they do. \n\n-Wayne Dyer");
		hm.put("64", "Failure is simply the opportunity to begin again, this time more intelligently. \n\n-Henry Ford ");
		hm.put("65", "Victory belongs to the most persevering. \n\n-Napoleon Bonaparte");
		hm.put("66", "Dream lofty dreams, and as you dream, so you shall become. Your vision is the promise of what you shall one day be; your ideal is the prophecy of what you shall at last unveil. \n\n-James Allen");
		hm.put("67", "You will never possess what you are unwilling to pursue. \n\n-Mike Murdock");
		hm.put("68", "He who controls others may be powerful, but he who has mastered himself is mightier still. \n\n-Lao-Tzu");
		hm.put("69", "I've come to believe that all my past failure and frustrations were actually laying the foundation for the understandings that have created the new level of living I now enjoy. \n\n-Anthony Robbins");
		hm.put("70", "If you don't risk anything, then you risk even more. \n\n-Erica Jong");
		hm.put("71", "It was character that got us out of bed, commitment that moved us into action, and discipline that enabled us to follow through. \n\n-Zig Ziglar");
		hm.put("72", "No matter how hard the past, you can always begin again. \n\n-Buddha");
		hm.put("73", "The secret of health for both mind and body is not to mourn for the past, not to worry about the future, nor to anticipate troubles, but to live in the present moment wisely and earnestly. \n\n-Buddha");
		hm.put("74", "There are only two ways to live your life. One is as though nothing is a miracle. The other is as if everything is. \n\n-Albert Einstein");
		hm.put("75", "Go confidently in the direction of your dreams. Live the life you've imagined. \n\n-Henry David Thoreau");
		hm.put("76", "Only those who will risk going too far can possibly find out how far one can go. \n\n-T. S. Elliot");
		hm.put("77", "All that we are is the result of what we have thought. \n\n-Buddha");
		hm.put("78", "It is not because things are difficult that we do not dare, it is because we do not dare that they are difficult. \n\n-Seneca");
		hm.put("79", "It was a high counsel that I once heard given to a young person, \"Always do what you are afraid to do.\" \n\n-Ralph Waldo Emerson");
		hm.put("80", "The best motivation is self-motivation.  The guy says, \"I wish someone would come by and turn me on.\" What if they don’t show up?  You’ve got to have a better plan for your life. \n\n-Jim Rohn");
		hm.put("81", "It is better to be hated for what you are than to be loved for what you are not. \n\n-Andre Gide");
		hm.put("82", "Our strength grows out of our weakness. \n\n-Ralph Waldo Emerson");
		hm.put("83", "Confidence is a habit that can be developed by acting as if you already had the confidence you desire to have. \n\n-Brian Tracy");
		hm.put("84", "You gain strength, courage and confidence by every experience in which you really stop to look fear in the face.  You must do the thing that you think you cannot do. \n\n-Eleanor Roosevelt");
		hm.put("85", "If a man does only what is required of him, he is a slave. If a man does more than is required of him, he is a free man. \n\n-Chinese Proverb");
		hm.put("86", "Learn from yesterday, live for today, hope for tomorrow. The important thing is to not stop questioning. \n\n-Albert Einstein");
		hm.put("87", "The better part of happiness is to wish to be what you are. \n\n-Desiderius Erasmus");
		hm.put("88", "The whole secret of a successful life is to find out what is one's destiny to do, and then do it. \n\n-Henry Ford");
		hm.put("89", "Always bear in mind that your own resolution to succeed is more important than any one thing. \n\n-Abraham Lincoln");
		hm.put("90", "Imagination is more important than knowledge. Knowledge is limited. Imagination encircles the world. \n\n-Albert Einstein");
		hm.put("91", "Are you bored with life? Then throw yourself into some work you believe in with all your heart, live for it, die for it, and you will find happiness that you had thought could never be yours. \n\n-Dale Carnegie");
		hm.put("92", "The greatest discovery of my generation is that a human being can alter his life by altering his attitudes of mind. \n\n-William James");
		hm.put("93", "Seize the moment of excited curiosity on any subject to solve your doubts; for if you let it pass, the desire may never return, and you may remain in ignorance. \n\n-William Wirt ");
		hm.put("94", "What you are is what you have been, and what you will be is what you do now. \n\n-Buddha");
		hm.put("95", "We are what we think. All that we are arises with our thoughts. With our thoughts, we make the world. \n\n-Buddha");
		hm.put("96", "The highest reward for man's toil is not what he gets for it, but what he becomes by it. \n\n-John Ruskin");
		hm.put("97", "A day will never be anymore than what you make of it. \n\n-Josh S. Hinds");
		hm.put("98", "Do not seek to follow in the footsteps of the wise. Seek what they sought. \n\n-Basho ");
		hm.put("99", "If you always put limits on everything you do, physical or anything else. It will spread into your work and into your life. There are no limits. There are only plateaus, and you must not stay there, you must go beyond them. \n\n-Bruce Lee");
		hm.put("100", "There are two rules for success: 1) Never tell everything you know… \n\n-Roger H. Lincoln");
		hm.put("101", "You were born with potential.\nYou were born with goodness and trust. \nYou were born with ideals and dreams. \nYou were born with greatness. \nYou were born with wings.\nYou are not meant for crawling, so don’t. \nYou have wings. \nLearn to use them and fly. \n\n-Rumi ");
		

		r = new Random();

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stubb
		switch (arg0.getId()) {
		case R.id.btn_q:

			count_q = r.nextInt(102 - 1) + 1;			//(0 to 100) + 1

			tv_q.setText("Thought of the Day: \n\n"
					+ hm.get(count_q.toString()));
			// count_q++;
			b_q.setText("Next Thought");

			break;
		case R.id.btn_share:
			
			shareQuote();
			break;

		}
	}

	private void shareQuote() {
		// TODO Auto-generated method stub
		
		//works for all; self made
		Intent smsIntent = new Intent(Intent.ACTION_SEND);
		smsIntent.setData(Uri.parse("smsto:"));
		smsIntent.setType("text/plain");
		
		s_quote = tv_q.getText().toString();
		smsIntent.putExtra(Intent.EXTRA_TEXT, s_quote);
		try{
			startActivity(smsIntent);
			finish();
			Log.i("Finished sharing Quote!", "");
		}catch(Exception ex){
			Toast.makeText(Quotes.this, "Message failed, please try again later.", Toast.LENGTH_SHORT).show();
			//ex.printStackTrace();
		}
		
		/*//yes = chaton + sms; no = whatsapp + viber 
		 *Reason : SENDTO
		Uri uri = Uri.parse("smsto:"+"");
		Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);
		s_quote = tv_q.getText().toString();
		smsIntent.putExtra("sms_body", s_quote);
		try{
			startActivity(smsIntent);
		}catch(Exception ex){
			Toast.makeText(Quotes.this, "Message failed, please try again later.", Toast.LENGTH_SHORT).show();
			ex.printStackTrace();
		}
		*/
		
	/* only whatsapp
		Intent waIntent = new Intent(Intent.ACTION_SEND);
		waIntent.setType("text/plain");
		s_quote = tv_q.getText().toString();
		waIntent.setPackage("com.whatsapp");
		if(waIntent != null){
			waIntent.putExtra(Intent.EXTRA_TEXT, s_quote);
			startActivity(Intent.createChooser(waIntent, "Share this quote"));
		}else{
			Toast.makeText(Quotes.this, "Whatsapp not Installed", Toast.LENGTH_SHORT).show();
		}
*/
		
		/*yes= chaton + sms
		Log.i("Send SMS", "");

		Intent smsIntent = new Intent(Intent.ACTION_VIEW);
		smsIntent.setData(Uri.parse("smsto:"));
		smsIntent.setType("vnd.android-dir/mms-sms");
		
		smsIntent.putExtra("address", "");
		s_quote = tv_q.getText().toString();
		smsIntent.putExtra("sms_body", s_quote);
		
		try{
			startActivity(smsIntent);
			finish();
			Log.i("Finished sharing Quote!", "");
		}catch(android.content.ActivityNotFoundException ex){
			Toast.makeText(Quotes.this, "Message failed, please try again later.", Toast.LENGTH_SHORT).show();
		}
		*/
	}

}
