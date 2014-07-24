//FILE : InstructionsActivity.java
//PROG : Chris Larson
//PURP : Activity page that displays the instructions for the Grandma's Boy Soundboard application
package com.larson.grandma;


import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class InstructionsActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_instructions);
		setDoneButtonListener();
	}

	//Set up the Done button to initialize intent and finish
	private void setDoneButtonListener()
	{
		Button doneButton = (Button) findViewById(R.id.doneBTN);
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
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.instructions, menu);
		return true;
	}

}
