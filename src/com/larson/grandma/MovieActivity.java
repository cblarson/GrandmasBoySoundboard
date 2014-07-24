//FILE : MovieActivity.java
//PROG : Chris Larson
//PURP : Activity page that displays the imdb.com webpage for the movie Grandma's Boy in a webframe 

package com.larson.grandma;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MovieActivity extends Activity 
{
	private WebView webView;
	String webPage = "http://www.imdb.com/title/tt0456554/?ref_=nv_sr_2";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_movie);
		webView = (WebView) findViewById(R.id.webView);
		webView.setWebViewClient(new WebViewClient());
		webView.getSettings().setBuiltInZoomControls(true);
		webView.loadUrl(webPage);
		setDoneButtonListener();
	}
	private void setDoneButtonListener()
	{
		Button doneButton = (Button) findViewById(R.id.btnBack);
		doneButton.setOnClickListener
		(
			new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					finish();
				}
			}
		);//END setOnClickListener
	}//END setDoneButtonListener
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.movie, menu);
		return true;
	}

}
