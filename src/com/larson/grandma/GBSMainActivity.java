//FILE : GBSMainActivity.java
//PROG : Chris Larson
//PURP : Main activity file for Grandma's Boy Soundboard application.  Displays buttons and each button plays a corresponding sound

package com.larson.grandma;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

public class GBSMainActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_gbsmain);
		setFreakButtonClickListener();
		setGeniusButtonClickListener();
		setSeeMeButtonClickListener();
		setMetalLegsButtonClickListener();
		setMiddleNameButtonClickListener();
		setDelusionalButtonClickListener();
		setNeverButtonClickListener();
		setRobotButtonClickListener();
		setTakeCareButtonClickListener();
		setExitButtonClickListener();
		setMovieButtonClickListener();
		setInstructionsButtonClickListener(); 
		
	}
	
	private void setFreakButtonClickListener()
	{
		Button btnFreak = (Button) findViewById(R.id.btnFreak);
		final MediaPlayer mpFreak = MediaPlayer.create(this, R.raw.freak);
		btnFreak.setOnClickListener
		(
			new View.OnClickListener() 
			{				
				@Override
				public void onClick(View v) 
				{
					mpFreak.start();
					startAnimation(findViewById(R.id.btnFreak));
					ScrollView picture = (ScrollView) findViewById(R.id.background);
					picture.setBackgroundResource(R.drawable.puzzled);
				}
			}	
		);
		btnFreak.setOnLongClickListener
		(
				new View.OnLongClickListener() 
				{	
					@Override
					public boolean onLongClick(View v) 
					{
						AlertDialog.Builder builder = new AlertDialog.Builder(GBSMainActivity.this)
						.setTitle(R.string.alertTitle)
						.setItems(R.array.alert_array, new DialogInterface.OnClickListener() 
						{
							
							@Override
							public void onClick(DialogInterface dialog, int which) 
							{
								switch (which) 
								{
									case 0: 
									{
										ContentResolver mCr = GBSMainActivity.this.getContentResolver();
										File newSoundFile = new File(Environment.getExternalStorageDirectory().getPath(), "freak");
										Uri mUri = Uri.parse("android.resource://com.larson.grandma/R.raw.freak");
										
										AssetFileDescriptor soundFile;
										try 
										{
											soundFile= mCr.openAssetFileDescriptor(mUri, "r");
										} 
										catch (FileNotFoundException e) 
										{
											soundFile=null;   
										}
										try 
										{
										    byte[] readData = new byte[1024];
										    InputStream fis = getResources().openRawResource(R.raw.freak);
										    FileOutputStream fos = new FileOutputStream(newSoundFile);
										    int i = fis.read(readData);

										    while (i != -1) 
										    {
										        fos.write(readData, 0, i);
										        i = fis.read(readData);
										    }
										      fos.close();
										 } 
										catch (IOException io) 
										{
										}
										ContentValues values = new ContentValues();
							               values.put(MediaStore.MediaColumns.DATA, newSoundFile.getAbsolutePath());
							               values.put(MediaStore.MediaColumns.TITLE, "JP-I'm a freak");
							               values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/oog");
							               values.put(MediaStore.MediaColumns.SIZE, newSoundFile.length());						
							               values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
							               values.put(MediaStore.Audio.Media.IS_NOTIFICATION, false);
							               values.put(MediaStore.Audio.Media.IS_ALARM, false);
							               values.put(MediaStore.Audio.Media.IS_MUSIC, false);

							               Uri uri = MediaStore.Audio.Media.getContentUriForPath(newSoundFile.getAbsolutePath());
							               Uri newUri = mCr.insert(uri, values);
							               

							               try 
							               {
							                   RingtoneManager.setActualDefaultRingtoneUri(GBSMainActivity.this, RingtoneManager.TYPE_RINGTONE, newUri);
							               } 
							               catch (Throwable t) 
							               {
							                  // Log.d(TAG, "catch exception");
							               }
							               	
									}
									Toast.makeText(GBSMainActivity.this, "Ringtone set!", Toast.LENGTH_SHORT).show();
									break;
									
									case 1: 
									{
										ContentResolver mCr = GBSMainActivity.this.getContentResolver();
										File newSoundFile = new File(Environment.getExternalStorageDirectory().getPath(), "freak");
										Uri mUri = Uri.parse("android.resource://com.larson.grandma/R.raw.freak");
										
										AssetFileDescriptor soundFile;
										try 
										{
											soundFile= mCr.openAssetFileDescriptor(mUri, "r");
										} 
										catch (FileNotFoundException e) 
										{
											soundFile=null;   
										}
										try 
										{
										    byte[] readData = new byte[1024];
										    InputStream fis = getResources().openRawResource(R.raw.freak);
										    FileOutputStream fos = new FileOutputStream(newSoundFile);
										    int i = fis.read(readData);

										    while (i != -1) 
										    {
										        fos.write(readData, 0, i);
										        i = fis.read(readData);
										    }
										      fos.close();
										 } 
										catch (IOException io) 
										{
										}
										ContentValues values = new ContentValues();
							               values.put(MediaStore.MediaColumns.DATA, newSoundFile.getAbsolutePath());
							               values.put(MediaStore.MediaColumns.TITLE, "JP-I'm a freak");
							               values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/oog");
							               values.put(MediaStore.MediaColumns.SIZE, newSoundFile.length());						
							               values.put(MediaStore.Audio.Media.IS_RINGTONE, false);
							               values.put(MediaStore.Audio.Media.IS_NOTIFICATION, true);
							               values.put(MediaStore.Audio.Media.IS_ALARM, false);
							               values.put(MediaStore.Audio.Media.IS_MUSIC, false);

							               Uri uri = MediaStore.Audio.Media.getContentUriForPath(newSoundFile.getAbsolutePath());
							               Uri newUri = mCr.insert(uri, values);
							               

							               try 
							               {
							                   RingtoneManager.setActualDefaultRingtoneUri(GBSMainActivity.this, RingtoneManager.TYPE_NOTIFICATION, newUri);
							               } 
							               catch (Throwable t) 
							               {
							                  // Log.d(TAG, "catch exception");
							               }
							               	
									}
									Toast.makeText(GBSMainActivity.this, "Notification set!", Toast.LENGTH_SHORT).show();
									break;
									default:
										break;
								}
								
							}
						})
						.setCancelable(true);
						builder.create().show();
						return true;
					}
				}
		);

	}
	
	private void setGeniusButtonClickListener()
	{
		Button btnGenius = (Button) findViewById(R.id.btnGenius);
		final MediaPlayer mpGenius = MediaPlayer.create(this, R.raw.genius);
		btnGenius.setOnClickListener
		(
			new View.OnClickListener() 
			{				
				@Override
				public void onClick(View v) 
				{
					mpGenius.start();
					startAnimation(findViewById(R.id.btnGenius));
					ScrollView picture = (ScrollView) findViewById(R.id.background);
					picture.setBackgroundResource(R.drawable.face);
				}
			}	
		);
		btnGenius.setOnLongClickListener
		(
				new View.OnLongClickListener() 
				{	
					@Override
					public boolean onLongClick(View v) 
					{
						AlertDialog.Builder builder = new AlertDialog.Builder(GBSMainActivity.this)
						.setTitle(R.string.alertTitle)
						.setItems(R.array.alert_array, new DialogInterface.OnClickListener() 
						{
							
							@Override
							public void onClick(DialogInterface dialog, int which) 
							{
								switch (which) 
								{
									case 0: 
									{
										ContentResolver mCr = GBSMainActivity.this.getContentResolver();
										File newSoundFile = new File(Environment.getExternalStorageDirectory().getPath(), "genius");
										Uri mUri = Uri.parse("android.resource://com.larson.grandma/R.raw.genius");
										
										AssetFileDescriptor soundFile;
										try 
										{
											soundFile= mCr.openAssetFileDescriptor(mUri, "r");
										} 
										catch (FileNotFoundException e) 
										{
											soundFile=null;   
										}
										try 
										{
										    byte[] readData = new byte[1024];
										    InputStream fis = getResources().openRawResource(R.raw.genius);
										    FileOutputStream fos = new FileOutputStream(newSoundFile);
										    int i = fis.read(readData);

										    while (i != -1) 
										    {
										        fos.write(readData, 0, i);
										        i = fis.read(readData);
										    }
										      fos.close();
										 } 
										catch (IOException io) 
										{
										}
										ContentValues values = new ContentValues();
							               values.put(MediaStore.MediaColumns.DATA, newSoundFile.getAbsolutePath());
							               values.put(MediaStore.MediaColumns.TITLE, "JP-I am a genius");
							               values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/oog");
							               values.put(MediaStore.MediaColumns.SIZE, newSoundFile.length());						
							               values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
							               values.put(MediaStore.Audio.Media.IS_NOTIFICATION, false);
							               values.put(MediaStore.Audio.Media.IS_ALARM, false);
							               values.put(MediaStore.Audio.Media.IS_MUSIC, false);

							               Uri uri = MediaStore.Audio.Media.getContentUriForPath(newSoundFile.getAbsolutePath());
							               Uri newUri = mCr.insert(uri, values);
							               

							               try 
							               {
							                   RingtoneManager.setActualDefaultRingtoneUri(GBSMainActivity.this, RingtoneManager.TYPE_RINGTONE, newUri);
							               } 
							               catch (Throwable t) 
							               {
							                  // Log.d(TAG, "catch exception");
							               }
							               	
									}
									Toast.makeText(GBSMainActivity.this, "Ringtone set!", Toast.LENGTH_SHORT).show();
									break;
									
									case 1: 
									{
										ContentResolver mCr = GBSMainActivity.this.getContentResolver();
										File newSoundFile = new File(Environment.getExternalStorageDirectory().getPath(), "Genius");
										Uri mUri = Uri.parse("android.resource://com.larson.grandma/R.raw.genius");
										
										AssetFileDescriptor soundFile;
										try 
										{
											soundFile= mCr.openAssetFileDescriptor(mUri, "r");
										} 
										catch (FileNotFoundException e) 
										{
											soundFile=null;   
										}
										try 
										{
										    byte[] readData = new byte[1024];
										    InputStream fis = getResources().openRawResource(R.raw.genius);
										    FileOutputStream fos = new FileOutputStream(newSoundFile);
										    int i = fis.read(readData);

										    while (i != -1) 
										    {
										        fos.write(readData, 0, i);
										        i = fis.read(readData);
										    }
										      fos.close();
										 } 
										catch (IOException io) 
										{
										}
										ContentValues values = new ContentValues();
							               values.put(MediaStore.MediaColumns.DATA, newSoundFile.getAbsolutePath());
							               values.put(MediaStore.MediaColumns.TITLE, "JP-I am a genius");
							               values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/oog");
							               values.put(MediaStore.MediaColumns.SIZE, newSoundFile.length());						
							               values.put(MediaStore.Audio.Media.IS_RINGTONE, false);
							               values.put(MediaStore.Audio.Media.IS_NOTIFICATION, true);
							               values.put(MediaStore.Audio.Media.IS_ALARM, false);
							               values.put(MediaStore.Audio.Media.IS_MUSIC, false);

							               Uri uri = MediaStore.Audio.Media.getContentUriForPath(newSoundFile.getAbsolutePath());
							               Uri newUri = mCr.insert(uri, values);
							               

							               try 
							               {
							                   RingtoneManager.setActualDefaultRingtoneUri(GBSMainActivity.this, RingtoneManager.TYPE_NOTIFICATION, newUri);
							               } 
							               catch (Throwable t) 
							               {
							                  // Log.d(TAG, "catch exception");
							               }
							               	
									}
									Toast.makeText(GBSMainActivity.this, "Notification set!", Toast.LENGTH_SHORT).show();
									break;
									default:
										break;
								}
								
							}
						});
						builder.create().show();
						return true;
					}
				}
		);
	
	}
	

	private void setSeeMeButtonClickListener()
	{
		Button btnSeeMe = (Button) findViewById(R.id.btnSeeMe);
		final MediaPlayer mpSeeMe = MediaPlayer.create(this, R.raw.seeme);
		btnSeeMe.setOnClickListener
		(
			new View.OnClickListener() 
			{				
				@Override
				public void onClick(View v) 
				{
					mpSeeMe.start();
					startAnimation(findViewById(R.id.btnSeeMe));
					ScrollView picture = (ScrollView) findViewById(R.id.background);
					picture.setBackgroundResource(R.drawable.hiding);
				}
			}	
		);
		btnSeeMe.setOnLongClickListener
		(
				new View.OnLongClickListener() 
				{	
					@Override
					public boolean onLongClick(View v) 
					{
						AlertDialog.Builder builder = new AlertDialog.Builder(GBSMainActivity.this)
						.setTitle(R.string.alertTitle)
						.setItems(R.array.alert_array, new DialogInterface.OnClickListener() 
						{
							
							@Override
							public void onClick(DialogInterface dialog, int which) 
							{
								switch (which) 
								{
									case 0: 
									{
										ContentResolver mCr = GBSMainActivity.this.getContentResolver();
										File newSoundFile = new File(Environment.getExternalStorageDirectory().getPath(), "see me");
										Uri mUri = Uri.parse("android.resource://com.larson.grandma/R.raw.seeme");
										
										AssetFileDescriptor soundFile;
										try 
										{
											soundFile= mCr.openAssetFileDescriptor(mUri, "r");
										} 
										catch (FileNotFoundException e) 
										{
											soundFile=null;   
										}
										try 
										{
										    byte[] readData = new byte[1024];
										    InputStream fis = getResources().openRawResource(R.raw.seeme);
										    FileOutputStream fos = new FileOutputStream(newSoundFile);
										    int i = fis.read(readData);

										    while (i != -1) 
										    {
										        fos.write(readData, 0, i);
										        i = fis.read(readData);
										    }
										      fos.close();
										 } 
										catch (IOException io) 
										{
										}
										ContentValues values = new ContentValues();
							               values.put(MediaStore.MediaColumns.DATA, newSoundFile.getAbsolutePath());
							               values.put(MediaStore.MediaColumns.TITLE, "JP-How can he see me?");
							               values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/oog");
							               values.put(MediaStore.MediaColumns.SIZE, newSoundFile.length());						
							               values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
							               values.put(MediaStore.Audio.Media.IS_NOTIFICATION, false);
							               values.put(MediaStore.Audio.Media.IS_ALARM, false);
							               values.put(MediaStore.Audio.Media.IS_MUSIC, false);

							               Uri uri = MediaStore.Audio.Media.getContentUriForPath(newSoundFile.getAbsolutePath());
							               Uri newUri = mCr.insert(uri, values);
							               

							               try 
							               {
							                   RingtoneManager.setActualDefaultRingtoneUri(GBSMainActivity.this, RingtoneManager.TYPE_RINGTONE, newUri);
							               } 
							               catch (Throwable t) 
							               {
							                  // Log.d(TAG, "catch exception");
							               }
							               	
									}
									Toast.makeText(GBSMainActivity.this, "Ringtone set!", Toast.LENGTH_SHORT).show();
									break;
									
									case 1: 
									{
										ContentResolver mCr = GBSMainActivity.this.getContentResolver();
										File newSoundFile = new File(Environment.getExternalStorageDirectory().getPath(), "see me");
										Uri mUri = Uri.parse("android.resource://com.larson.grandma/R.raw.seeme");
										
										AssetFileDescriptor soundFile;
										try 
										{
											soundFile= mCr.openAssetFileDescriptor(mUri, "r");
										} 
										catch (FileNotFoundException e) 
										{
											soundFile=null;   
										}
										try 
										{
										    byte[] readData = new byte[1024];
										    InputStream fis = getResources().openRawResource(R.raw.seeme);
										    FileOutputStream fos = new FileOutputStream(newSoundFile);
										    int i = fis.read(readData);

										    while (i != -1) 
										    {
										        fos.write(readData, 0, i);
										        i = fis.read(readData);
										    }
										      fos.close();
										 } 
										catch (IOException io) 
										{
										}
										ContentValues values = new ContentValues();
							               values.put(MediaStore.MediaColumns.DATA, newSoundFile.getAbsolutePath());
							               values.put(MediaStore.MediaColumns.TITLE, "JP-How can he see me?");
							               values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/oog");
							               values.put(MediaStore.MediaColumns.SIZE, newSoundFile.length());						
							               values.put(MediaStore.Audio.Media.IS_RINGTONE, false);
							               values.put(MediaStore.Audio.Media.IS_NOTIFICATION, true);
							               values.put(MediaStore.Audio.Media.IS_ALARM, false);
							               values.put(MediaStore.Audio.Media.IS_MUSIC, false);

							               Uri uri = MediaStore.Audio.Media.getContentUriForPath(newSoundFile.getAbsolutePath());
							               Uri newUri = mCr.insert(uri, values);
							               

							               try 
							               {
							                   RingtoneManager.setActualDefaultRingtoneUri(GBSMainActivity.this, RingtoneManager.TYPE_NOTIFICATION, newUri);
							               } 
							               catch (Throwable t) 
							               {
							                  // Log.d(TAG, "catch exception");
							               }
							               	
									}
									Toast.makeText(GBSMainActivity.this, "Notification set!", Toast.LENGTH_SHORT).show();
									break;
									default:
										break;
								}
								
							}
						});
						builder.create().show();
						return true;
					}
				}
		);

	}

	private void setMetalLegsButtonClickListener()
	{
		Button btnMetalLegs = (Button) findViewById(R.id.btnMetalLegs);
		final MediaPlayer mpMetalLegs = MediaPlayer.create(this, R.raw.metallegs);
		btnMetalLegs.setOnClickListener
		(
			new View.OnClickListener() 
			{				
				@Override
				public void onClick(View v) 
				{
					mpMetalLegs.start();
					startAnimation(findViewById(R.id.btnMetalLegs));
					ScrollView picture = (ScrollView) findViewById(R.id.background);
					picture.setBackgroundResource(R.drawable.cool);
				}
			}	
		);
		btnMetalLegs.setOnLongClickListener
		(
				new View.OnLongClickListener() 
				{	
					@Override
					public boolean onLongClick(View v) 
					{
						AlertDialog.Builder builder = new AlertDialog.Builder(GBSMainActivity.this)
						.setTitle(R.string.alertTitle)
						.setItems(R.array.alert_array, new DialogInterface.OnClickListener() 
						{
							
							@Override
							public void onClick(DialogInterface dialog, int which) 
							{
								switch (which) 
								{
									case 0: 
									{
										ContentResolver mCr = GBSMainActivity.this.getContentResolver();
										File newSoundFile = new File(Environment.getExternalStorageDirectory().getPath(), "metallegs");
										Uri mUri = Uri.parse("android.resource://com.larson.grandma/R.raw.metallegs");
										
										AssetFileDescriptor soundFile;
										try 
										{
											soundFile= mCr.openAssetFileDescriptor(mUri, "r");
										} 
										catch (FileNotFoundException e) 
										{
											soundFile=null;   
										}
										try 
										{
										    byte[] readData = new byte[1024];
										    InputStream fis = getResources().openRawResource(R.raw.metallegs);
										    FileOutputStream fos = new FileOutputStream(newSoundFile);
										    int i = fis.read(readData);

										    while (i != -1) 
										    {
										        fos.write(readData, 0, i);
										        i = fis.read(readData);
										    }
										      fos.close();
										 } 
										catch (IOException io) 
										{
										}
										ContentValues values = new ContentValues();
							               values.put(MediaStore.MediaColumns.DATA, newSoundFile.getAbsolutePath());
							               values.put(MediaStore.MediaColumns.TITLE, "JP-Metal Legs");
							               values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/oog");
							               values.put(MediaStore.MediaColumns.SIZE, newSoundFile.length());						
							               values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
							               values.put(MediaStore.Audio.Media.IS_NOTIFICATION, false);
							               values.put(MediaStore.Audio.Media.IS_ALARM, false);
							               values.put(MediaStore.Audio.Media.IS_MUSIC, false);

							               Uri uri = MediaStore.Audio.Media.getContentUriForPath(newSoundFile.getAbsolutePath());
							               Uri newUri = mCr.insert(uri, values);
							               

							               try 
							               {
							                   RingtoneManager.setActualDefaultRingtoneUri(GBSMainActivity.this, RingtoneManager.TYPE_RINGTONE, newUri);
							               } 
							               catch (Throwable t) 
							               {
							                  // Log.d(TAG, "catch exception");
							               }
							               	
									}
									Toast.makeText(GBSMainActivity.this, "Ringtone set!", Toast.LENGTH_SHORT).show();
									break;
									
									case 1: 
									{
										ContentResolver mCr = GBSMainActivity.this.getContentResolver();
										File newSoundFile = new File(Environment.getExternalStorageDirectory().getPath(), "metallegs");
										Uri mUri = Uri.parse("android.resource://com.larson.grandma/R.raw.metallegs");
										
										AssetFileDescriptor soundFile;
										try 
										{
											soundFile= mCr.openAssetFileDescriptor(mUri, "r");
										} 
										catch (FileNotFoundException e) 
										{
											soundFile=null;   
										}
										try 
										{
										    byte[] readData = new byte[1024];
										    InputStream fis = getResources().openRawResource(R.raw.metallegs);
										    FileOutputStream fos = new FileOutputStream(newSoundFile);
										    int i = fis.read(readData);

										    while (i != -1) 
										    {
										        fos.write(readData, 0, i);
										        i = fis.read(readData);
										    }
										      fos.close();
										 } 
										catch (IOException io) 
										{
										}
										ContentValues values = new ContentValues();
							               values.put(MediaStore.MediaColumns.DATA, newSoundFile.getAbsolutePath());
							               values.put(MediaStore.MediaColumns.TITLE, "JP-Metal Legs");
							               values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/oog");
							               values.put(MediaStore.MediaColumns.SIZE, newSoundFile.length());						
							               values.put(MediaStore.Audio.Media.IS_RINGTONE, false);
							               values.put(MediaStore.Audio.Media.IS_NOTIFICATION, true);
							               values.put(MediaStore.Audio.Media.IS_ALARM, false);
							               values.put(MediaStore.Audio.Media.IS_MUSIC, false);

							               Uri uri = MediaStore.Audio.Media.getContentUriForPath(newSoundFile.getAbsolutePath());
							               Uri newUri = mCr.insert(uri, values);
							               

							               try 
							               {
							                   RingtoneManager.setActualDefaultRingtoneUri(GBSMainActivity.this, RingtoneManager.TYPE_NOTIFICATION, newUri);
							               } 
							               catch (Throwable t) 
							               {
							                  // Log.d(TAG, "catch exception");
							               }
							               	
									}
									Toast.makeText(GBSMainActivity.this, "Notification set!", Toast.LENGTH_SHORT).show();
									break;
									default:
										break;
								}
								
							}
						});
						builder.create().show();
						return true;
					}
				}
		);

	}
	
	private void setMiddleNameButtonClickListener()
	{
		Button btnMiddleName = (Button) findViewById(R.id.btnMiddleName);
		final MediaPlayer mpMiddleName = MediaPlayer.create(this, R.raw.middlename);
		btnMiddleName.setOnClickListener
		(
			new View.OnClickListener() 
			{				
				@Override
				public void onClick(View v) 
				{
					mpMiddleName.start();
					startAnimation(findViewById(R.id.btnMiddleName));
					ScrollView picture = (ScrollView) findViewById(R.id.background);
					picture.setBackgroundResource(R.drawable.look);
				}
			}	
		);
		btnMiddleName.setOnLongClickListener
		(
				new View.OnLongClickListener() 
				{	
					@Override
					public boolean onLongClick(View v) 
					{
						AlertDialog.Builder builder = new AlertDialog.Builder(GBSMainActivity.this)
						.setTitle(R.string.alertTitle)
						.setItems(R.array.alert_array, new DialogInterface.OnClickListener() 
						{
							
							@Override
							public void onClick(DialogInterface dialog, int which) 
							{
								switch (which) 
								{
									case 0: 
									{
										ContentResolver mCr = GBSMainActivity.this.getContentResolver();
										File newSoundFile = new File(Environment.getExternalStorageDirectory().getPath(), "middlename");
										Uri mUri = Uri.parse("android.resource://com.larson.grandma/R.raw.middlename");
										
										AssetFileDescriptor soundFile;
										try 
										{
											soundFile= mCr.openAssetFileDescriptor(mUri, "r");
										} 
										catch (FileNotFoundException e) 
										{
											soundFile=null;   
										}
										try 
										{
										    byte[] readData = new byte[1024];
										    InputStream fis = getResources().openRawResource(R.raw.middlename);
										    FileOutputStream fos = new FileOutputStream(newSoundFile);
										    int i = fis.read(readData);

										    while (i != -1) 
										    {
										        fos.write(readData, 0, i);
										        i = fis.read(readData);
										    }
										      fos.close();
										 } 
										catch (IOException io) 
										{
										}
										ContentValues values = new ContentValues();
							               values.put(MediaStore.MediaColumns.DATA, newSoundFile.getAbsolutePath());
							               values.put(MediaStore.MediaColumns.TITLE, "JP-My middle name");
							               values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/oog");
							               values.put(MediaStore.MediaColumns.SIZE, newSoundFile.length());						
							               values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
							               values.put(MediaStore.Audio.Media.IS_NOTIFICATION, false);
							               values.put(MediaStore.Audio.Media.IS_ALARM, false);
							               values.put(MediaStore.Audio.Media.IS_MUSIC, false);

							               Uri uri = MediaStore.Audio.Media.getContentUriForPath(newSoundFile.getAbsolutePath());
							               Uri newUri = mCr.insert(uri, values);
							               

							               try 
							               {
							                   RingtoneManager.setActualDefaultRingtoneUri(GBSMainActivity.this, RingtoneManager.TYPE_RINGTONE, newUri);
							               } 
							               catch (Throwable t) 
							               {
							                  // Log.d(TAG, "catch exception");
							               }
							               	
									}
									Toast.makeText(GBSMainActivity.this, "Ringtone set!", Toast.LENGTH_SHORT).show();
									break;
									
									case 1: 
									{
										ContentResolver mCr = GBSMainActivity.this.getContentResolver();
										File newSoundFile = new File(Environment.getExternalStorageDirectory().getPath(), "middlename");
										Uri mUri = Uri.parse("android.resource://com.larson.grandma/R.raw.middlename");
										
										AssetFileDescriptor soundFile;
										try 
										{
											soundFile= mCr.openAssetFileDescriptor(mUri, "r");
										} 
										catch (FileNotFoundException e) 
										{
											soundFile=null;   
										}
										try 
										{
										    byte[] readData = new byte[1024];
										    InputStream fis = getResources().openRawResource(R.raw.middlename);
										    FileOutputStream fos = new FileOutputStream(newSoundFile);
										    int i = fis.read(readData);

										    while (i != -1) 
										    {
										        fos.write(readData, 0, i);
										        i = fis.read(readData);
										    }
										      fos.close();
										 } 
										catch (IOException io) 
										{
										}
										ContentValues values = new ContentValues();
							               values.put(MediaStore.MediaColumns.DATA, newSoundFile.getAbsolutePath());
							               values.put(MediaStore.MediaColumns.TITLE, "JP-My middle name");
							               values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/oog");
							               values.put(MediaStore.MediaColumns.SIZE, newSoundFile.length());						
							               values.put(MediaStore.Audio.Media.IS_RINGTONE, false);
							               values.put(MediaStore.Audio.Media.IS_NOTIFICATION, true);
							               values.put(MediaStore.Audio.Media.IS_ALARM, false);
							               values.put(MediaStore.Audio.Media.IS_MUSIC, false);

							               Uri uri = MediaStore.Audio.Media.getContentUriForPath(newSoundFile.getAbsolutePath());
							               Uri newUri = mCr.insert(uri, values);
							               

							               try 
							               {
							                   RingtoneManager.setActualDefaultRingtoneUri(GBSMainActivity.this, RingtoneManager.TYPE_NOTIFICATION, newUri);
							               } 
							               catch (Throwable t) 
							               {
							                  // Log.d(TAG, "catch exception");
							               }
							               	
									}
									Toast.makeText(GBSMainActivity.this, "Notification set!", Toast.LENGTH_SHORT).show();
									break;
									default:
										break;
								}
								
							}
						});
						builder.create().show();
						return true;
					}
				}
		);

	}
	
	private void setDelusionalButtonClickListener()
	{
		Button btnDelusional = (Button) findViewById(R.id.btnDelusional);
		final MediaPlayer mpDelusional = MediaPlayer.create(this, R.raw.crazy);
		btnDelusional.setOnClickListener
		(
			new View.OnClickListener() 
			{				
				@Override
				public void onClick(View v) 
				{
					mpDelusional.start();
					startAnimation(findViewById(R.id.btnDelusional));
					ScrollView picture = (ScrollView) findViewById(R.id.background);
					picture.setBackgroundResource(R.drawable.angry);
				}
			}	
		);
		btnDelusional.setOnLongClickListener
		(
				new View.OnLongClickListener() 
				{	
					@Override
					public boolean onLongClick(View v) 
					{
						AlertDialog.Builder builder = new AlertDialog.Builder(GBSMainActivity.this)
						.setTitle(R.string.alertTitle)
						.setItems(R.array.alert_array, new DialogInterface.OnClickListener() 
						{
							
							@Override
							public void onClick(DialogInterface dialog, int which) 
							{
								switch (which) 
								{
									case 0: 
									{
										ContentResolver mCr = GBSMainActivity.this.getContentResolver();
										File newSoundFile = new File(Environment.getExternalStorageDirectory().getPath(), "crazy");
										Uri mUri = Uri.parse("android.resource://com.larson.grandma/R.raw.crazy");
										
										AssetFileDescriptor soundFile;
										try 
										{
											soundFile= mCr.openAssetFileDescriptor(mUri, "r");
										} 
										catch (FileNotFoundException e) 
										{
											soundFile=null;   
										}
										try 
										{
										    byte[] readData = new byte[1024];
										    InputStream fis = getResources().openRawResource(R.raw.crazy);
										    FileOutputStream fos = new FileOutputStream(newSoundFile);
										    int i = fis.read(readData);

										    while (i != -1) 
										    {
										        fos.write(readData, 0, i);
										        i = fis.read(readData);
										    }
										      fos.close();
										 } 
										catch (IOException io) 
										{
										}
										ContentValues values = new ContentValues();
							               values.put(MediaStore.MediaColumns.DATA, newSoundFile.getAbsolutePath());
							               values.put(MediaStore.MediaColumns.TITLE, "JP-Delusional thoughts");
							               values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/oog");
							               values.put(MediaStore.MediaColumns.SIZE, newSoundFile.length());						
							               values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
							               values.put(MediaStore.Audio.Media.IS_NOTIFICATION, false);
							               values.put(MediaStore.Audio.Media.IS_ALARM, false);
							               values.put(MediaStore.Audio.Media.IS_MUSIC, false);

							               Uri uri = MediaStore.Audio.Media.getContentUriForPath(newSoundFile.getAbsolutePath());
							               Uri newUri = mCr.insert(uri, values);
							               

							               try 
							               {
							                   RingtoneManager.setActualDefaultRingtoneUri(GBSMainActivity.this, RingtoneManager.TYPE_RINGTONE, newUri);
							               } 
							               catch (Throwable t) 
							               {
							                  // Log.d(TAG, "catch exception");
							               }
							               	
									}
									Toast.makeText(GBSMainActivity.this, "Ringtone set!", Toast.LENGTH_SHORT).show();
									break;
									
									case 1: 
									{
										ContentResolver mCr = GBSMainActivity.this.getContentResolver();
										File newSoundFile = new File(Environment.getExternalStorageDirectory().getPath(), "crazy");
										Uri mUri = Uri.parse("android.resource://com.larson.grandma/R.raw.crazy");
										
										AssetFileDescriptor soundFile;
										try 
										{
											soundFile= mCr.openAssetFileDescriptor(mUri, "r");
										} 
										catch (FileNotFoundException e) 
										{
											soundFile=null;   
										}
										try 
										{
										    byte[] readData = new byte[1024];
										    InputStream fis = getResources().openRawResource(R.raw.crazy);
										    FileOutputStream fos = new FileOutputStream(newSoundFile);
										    int i = fis.read(readData);

										    while (i != -1) 
										    {
										        fos.write(readData, 0, i);
										        i = fis.read(readData);
										    }
										      fos.close();
										 } 
										catch (IOException io) 
										{
										}
										ContentValues values = new ContentValues();
							               values.put(MediaStore.MediaColumns.DATA, newSoundFile.getAbsolutePath());
							               values.put(MediaStore.MediaColumns.TITLE, "JP-Delusional thoughts");
							               values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/oog");
							               values.put(MediaStore.MediaColumns.SIZE, newSoundFile.length());						
							               values.put(MediaStore.Audio.Media.IS_RINGTONE, false);
							               values.put(MediaStore.Audio.Media.IS_NOTIFICATION, true);
							               values.put(MediaStore.Audio.Media.IS_ALARM, false);
							               values.put(MediaStore.Audio.Media.IS_MUSIC, false);

							               Uri uri = MediaStore.Audio.Media.getContentUriForPath(newSoundFile.getAbsolutePath());
							               Uri newUri = mCr.insert(uri, values);
							               

							               try 
							               {
							                   RingtoneManager.setActualDefaultRingtoneUri(GBSMainActivity.this, RingtoneManager.TYPE_NOTIFICATION, newUri);
							               } 
							               catch (Throwable t) 
							               {
							                  // Log.d(TAG, "catch exception");
							               }
							               	
									}
									Toast.makeText(GBSMainActivity.this, "Notification set!", Toast.LENGTH_SHORT).show();
									break;
									default:
										break;
								}
								
							}
						});
						builder.create().show();
						return true;
					}
				}
		);

	}

	private void setNeverButtonClickListener()
	{
		Button btnNever = (Button) findViewById(R.id.btnNever);
		final MediaPlayer mpNever = MediaPlayer.create(this, R.raw.never);
		btnNever.setOnClickListener
		(
			new View.OnClickListener() 
			{				
				@Override
				public void onClick(View v) 
				{
					mpNever.start();
					startAnimation(findViewById(R.id.btnNever));
					ScrollView picture = (ScrollView) findViewById(R.id.background);
					picture.setBackgroundResource(R.drawable.face);
				}
			}	
		);
		btnNever.setOnLongClickListener
		(
				new View.OnLongClickListener() 
				{	
					@Override
					public boolean onLongClick(View v) 
					{
						AlertDialog.Builder builder = new AlertDialog.Builder(GBSMainActivity.this)
						.setTitle(R.string.alertTitle)
						.setItems(R.array.alert_array, new DialogInterface.OnClickListener() 
						{
							
							@Override
							public void onClick(DialogInterface dialog, int which) 
							{
								switch (which) 
								{
									case 0: 
									{
										ContentResolver mCr = GBSMainActivity.this.getContentResolver();
										File newSoundFile = new File(Environment.getExternalStorageDirectory().getPath(), "never");
										Uri mUri = Uri.parse("android.resource://com.larson.grandma/R.raw.never");
										
										AssetFileDescriptor soundFile;
										try 
										{
											soundFile= mCr.openAssetFileDescriptor(mUri, "r");
										} 
										catch (FileNotFoundException e) 
										{
											soundFile=null;   
										}
										try 
										{
										    byte[] readData = new byte[1024];
										    InputStream fis = getResources().openRawResource(R.raw.never);
										    FileOutputStream fos = new FileOutputStream(newSoundFile);
										    int i = fis.read(readData);

										    while (i != -1) 
										    {
										        fos.write(readData, 0, i);
										        i = fis.read(readData);
										    }
										      fos.close();
										 } 
										catch (IOException io) 
										{
										}
										ContentValues values = new ContentValues();
							               values.put(MediaStore.MediaColumns.DATA, newSoundFile.getAbsolutePath());
							               values.put(MediaStore.MediaColumns.TITLE, "JP-Never get metal legs");
							               values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/oog");
							               values.put(MediaStore.MediaColumns.SIZE, newSoundFile.length());						
							               values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
							               values.put(MediaStore.Audio.Media.IS_NOTIFICATION, false);
							               values.put(MediaStore.Audio.Media.IS_ALARM, false);
							               values.put(MediaStore.Audio.Media.IS_MUSIC, false);

							               Uri uri = MediaStore.Audio.Media.getContentUriForPath(newSoundFile.getAbsolutePath());
							               Uri newUri = mCr.insert(uri, values);
							               

							               try 
							               {
							                   RingtoneManager.setActualDefaultRingtoneUri(GBSMainActivity.this, RingtoneManager.TYPE_RINGTONE, newUri);
							               } 
							               catch (Throwable t) 
							               {
							                  // Log.d(TAG, "catch exception");
							               }
							               	
									}
									Toast.makeText(GBSMainActivity.this, "Ringtone set!", Toast.LENGTH_SHORT).show();
									break;
									
									case 1: 
									{
										ContentResolver mCr = GBSMainActivity.this.getContentResolver();
										File newSoundFile = new File(Environment.getExternalStorageDirectory().getPath(), "never");
										Uri mUri = Uri.parse("android.resource://com.larson.grandma/R.raw.never");
										
										AssetFileDescriptor soundFile;
										try 
										{
											soundFile= mCr.openAssetFileDescriptor(mUri, "r");
										} 
										catch (FileNotFoundException e) 
										{
											soundFile=null;   
										}
										try 
										{
										    byte[] readData = new byte[1024];
										    InputStream fis = getResources().openRawResource(R.raw.never);
										    FileOutputStream fos = new FileOutputStream(newSoundFile);
										    int i = fis.read(readData);

										    while (i != -1) 
										    {
										        fos.write(readData, 0, i);
										        i = fis.read(readData);
										    }
										      fos.close();
										 } 
										catch (IOException io) 
										{
										}
										ContentValues values = new ContentValues();
							               values.put(MediaStore.MediaColumns.DATA, newSoundFile.getAbsolutePath());
							               values.put(MediaStore.MediaColumns.TITLE, "JP-Never get metal legs");
							               values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/oog");
							               values.put(MediaStore.MediaColumns.SIZE, newSoundFile.length());						
							               values.put(MediaStore.Audio.Media.IS_RINGTONE, false);
							               values.put(MediaStore.Audio.Media.IS_NOTIFICATION, true);
							               values.put(MediaStore.Audio.Media.IS_ALARM, false);
							               values.put(MediaStore.Audio.Media.IS_MUSIC, false);

							               Uri uri = MediaStore.Audio.Media.getContentUriForPath(newSoundFile.getAbsolutePath());
							               Uri newUri = mCr.insert(uri, values);
							               

							               try 
							               {
							                   RingtoneManager.setActualDefaultRingtoneUri(GBSMainActivity.this, RingtoneManager.TYPE_NOTIFICATION, newUri);
							               } 
							               catch (Throwable t) 
							               {
							                  // Log.d(TAG, "catch exception");
							               }
							               	
									}
									Toast.makeText(GBSMainActivity.this, "Notification set!", Toast.LENGTH_SHORT).show();
									break;
									default:
										break;
								}
								
							}
						});
						builder.create().show();
						return true;
					}
				}
		);

	}

	private void setRobotButtonClickListener()
	{
		Button btnRobot = (Button) findViewById(R.id.btnRobot);
		final MediaPlayer mpRobotEars = MediaPlayer.create(this, R.raw.robotears);
		btnRobot.setOnClickListener
		(
			new View.OnClickListener() 
			{				
				@Override
				public void onClick(View v) 
				{
					mpRobotEars.start();
					startAnimation(findViewById(R.id.btnRobot));
					ScrollView picture = (ScrollView) findViewById(R.id.background);
					picture.setBackgroundResource(R.drawable.phone);
				}
			}	
		);
		btnRobot.setOnLongClickListener
		(
				new View.OnLongClickListener() 
				{	
					@Override
					public boolean onLongClick(View v) 
					{
						AlertDialog.Builder builder = new AlertDialog.Builder(GBSMainActivity.this)
						.setTitle(R.string.alertTitle)
						.setItems(R.array.alert_array, new DialogInterface.OnClickListener() 
						{
							
							@Override
							public void onClick(DialogInterface dialog, int which) 
							{
								switch (which) 
								{
									case 0: 
									{
										ContentResolver mCr = GBSMainActivity.this.getContentResolver();
										File newSoundFile = new File(Environment.getExternalStorageDirectory().getPath(), "robotears");
										Uri mUri = Uri.parse("android.resource://com.larson.grandma/R.raw.robotears");
										
										AssetFileDescriptor soundFile;
										try 
										{
											soundFile= mCr.openAssetFileDescriptor(mUri, "r");
										} 
										catch (FileNotFoundException e) 
										{
											soundFile=null;   
										}
										try 
										{
										    byte[] readData = new byte[1024];
										    InputStream fis = getResources().openRawResource(R.raw.robotears);
										    FileOutputStream fos = new FileOutputStream(newSoundFile);
										    int i = fis.read(readData);

										    while (i != -1) 
										    {
										        fos.write(readData, 0, i);
										        i = fis.read(readData);
										    }
										      fos.close();
										 } 
										catch (IOException io) 
										{
										}
										ContentValues values = new ContentValues();
							               values.put(MediaStore.MediaColumns.DATA, newSoundFile.getAbsolutePath());
							               values.put(MediaStore.MediaColumns.TITLE, "JP-If you had robot ears");
							               values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/oog");
							               values.put(MediaStore.MediaColumns.SIZE, newSoundFile.length());						
							               values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
							               values.put(MediaStore.Audio.Media.IS_NOTIFICATION, false);
							               values.put(MediaStore.Audio.Media.IS_ALARM, false);
							               values.put(MediaStore.Audio.Media.IS_MUSIC, false);

							               Uri uri = MediaStore.Audio.Media.getContentUriForPath(newSoundFile.getAbsolutePath());
							               Uri newUri = mCr.insert(uri, values);
							               

							               try 
							               {
							                   RingtoneManager.setActualDefaultRingtoneUri(GBSMainActivity.this, RingtoneManager.TYPE_RINGTONE, newUri);
							               } 
							               catch (Throwable t) 
							               {
							                  // Log.d(TAG, "catch exception");
							               }
							               	
									}
									Toast.makeText(GBSMainActivity.this, "Ringtone set!", Toast.LENGTH_SHORT).show();
									break;
									
									case 1: 
									{
										ContentResolver mCr = GBSMainActivity.this.getContentResolver();
										File newSoundFile = new File(Environment.getExternalStorageDirectory().getPath(), "robotears");
										Uri mUri = Uri.parse("android.resource://com.larson.grandma/R.raw.robotears");
										
										AssetFileDescriptor soundFile;
										try 
										{
											soundFile= mCr.openAssetFileDescriptor(mUri, "r");
										} 
										catch (FileNotFoundException e) 
										{
											soundFile=null;   
										}
										try 
										{
										    byte[] readData = new byte[1024];
										    InputStream fis = getResources().openRawResource(R.raw.robotears);
										    FileOutputStream fos = new FileOutputStream(newSoundFile);
										    int i = fis.read(readData);

										    while (i != -1) 
										    {
										        fos.write(readData, 0, i);
										        i = fis.read(readData);
										    }
										      fos.close();
										 } 
										catch (IOException io) 
										{
										}
										ContentValues values = new ContentValues();
							               values.put(MediaStore.MediaColumns.DATA, newSoundFile.getAbsolutePath());
							               values.put(MediaStore.MediaColumns.TITLE, "JP-If you had robot ears");
							               values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/oog");
							               values.put(MediaStore.MediaColumns.SIZE, newSoundFile.length());						
							               values.put(MediaStore.Audio.Media.IS_RINGTONE, false);
							               values.put(MediaStore.Audio.Media.IS_NOTIFICATION, true);
							               values.put(MediaStore.Audio.Media.IS_ALARM, false);
							               values.put(MediaStore.Audio.Media.IS_MUSIC, false);

							               Uri uri = MediaStore.Audio.Media.getContentUriForPath(newSoundFile.getAbsolutePath());
							               Uri newUri = mCr.insert(uri, values);
							               

							               try 
							               {
							                   RingtoneManager.setActualDefaultRingtoneUri(GBSMainActivity.this, RingtoneManager.TYPE_NOTIFICATION, newUri);
							               } 
							               catch (Throwable t) 
							               {
							                  // Log.d(TAG, "catch exception");
							               }
							               	
									}
									Toast.makeText(GBSMainActivity.this, "Notification set!", Toast.LENGTH_SHORT).show();
									break;
									default:
										break;
								}
								
							}
						});
						builder.create().show();
						return true;
					}
				}
		);

	}

	private void setTakeCareButtonClickListener()
	{
		Button btnTakeCare = (Button) findViewById(R.id.btnTakeCare);
		final MediaPlayer mpTakeCare = MediaPlayer.create(this, R.raw.takecare);
		btnTakeCare.setOnClickListener
		(
			new View.OnClickListener() 
			{				
				@Override
				public void onClick(View v) 
				{
					mpTakeCare.start();
					startAnimation(findViewById(R.id.btnTakeCare));
					ScrollView picture = (ScrollView) findViewById(R.id.background);
					picture.setBackgroundResource(R.drawable.adios);
				}
			}	
		);
		btnTakeCare.setOnLongClickListener
		(
				new View.OnLongClickListener() 
				{	
					@Override
					public boolean onLongClick(View v) 
					{
						AlertDialog.Builder builder = new AlertDialog.Builder(GBSMainActivity.this)
						.setTitle(R.string.alertTitle)
						.setItems(R.array.alert_array, new DialogInterface.OnClickListener() 
						{
							
							@Override
							public void onClick(DialogInterface dialog, int which) 
							{
								switch (which) 
								{
									case 0: 
									{
										ContentResolver mCr = GBSMainActivity.this.getContentResolver();
										File newSoundFile = new File(Environment.getExternalStorageDirectory().getPath(), "takecare");
										Uri mUri = Uri.parse("android.resource://com.larson.grandma/R.raw.takecare");
										
										AssetFileDescriptor soundFile;
										try 
										{
											soundFile= mCr.openAssetFileDescriptor(mUri, "r");
										} 
										catch (FileNotFoundException e) 
										{
											soundFile=null;   
										}
										try 
										{
										    byte[] readData = new byte[1024];
										    InputStream fis = getResources().openRawResource(R.raw.takecare);
										    FileOutputStream fos = new FileOutputStream(newSoundFile);
										    int i = fis.read(readData);

										    while (i != -1) 
										    {
										        fos.write(readData, 0, i);
										        i = fis.read(readData);
										    }
										      fos.close();
										 } 
										catch (IOException io) 
										{
										}
										ContentValues values = new ContentValues();
							               values.put(MediaStore.MediaColumns.DATA, newSoundFile.getAbsolutePath());
							               values.put(MediaStore.MediaColumns.TITLE, "Take care JP");
							               values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/oog");
							               values.put(MediaStore.MediaColumns.SIZE, newSoundFile.length());						
							               values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
							               values.put(MediaStore.Audio.Media.IS_NOTIFICATION, false);
							               values.put(MediaStore.Audio.Media.IS_ALARM, false);
							               values.put(MediaStore.Audio.Media.IS_MUSIC, false);

							               Uri uri = MediaStore.Audio.Media.getContentUriForPath(newSoundFile.getAbsolutePath());
							               Uri newUri = mCr.insert(uri, values);
							               

							               try 
							               {
							                   RingtoneManager.setActualDefaultRingtoneUri(GBSMainActivity.this, RingtoneManager.TYPE_RINGTONE, newUri);
							               } 
							               catch (Throwable t) 
							               {
							                  // Log.d(TAG, "catch exception");
							               }
							               	
									}
									Toast.makeText(GBSMainActivity.this, "Ringtone set!", Toast.LENGTH_SHORT).show();
									break;
									
									case 1: 
									{
										ContentResolver mCr = GBSMainActivity.this.getContentResolver();
										File newSoundFile = new File(Environment.getExternalStorageDirectory().getPath(), "takecare");
										Uri mUri = Uri.parse("android.resource://com.larson.grandma/R.raw.takecare");
										
										AssetFileDescriptor soundFile;
										try 
										{
											soundFile= mCr.openAssetFileDescriptor(mUri, "r");
										} 
										catch (FileNotFoundException e) 
										{
											soundFile=null;   
										}
										try 
										{
										    byte[] readData = new byte[1024];
										    InputStream fis = getResources().openRawResource(R.raw.takecare);
										    FileOutputStream fos = new FileOutputStream(newSoundFile);
										    int i = fis.read(readData);

										    while (i != -1) 
										    {
										        fos.write(readData, 0, i);
										        i = fis.read(readData);
										    }
										      fos.close();
										 } 
										catch (IOException io) 
										{
										}
										ContentValues values = new ContentValues();
							               values.put(MediaStore.MediaColumns.DATA, newSoundFile.getAbsolutePath());
							               values.put(MediaStore.MediaColumns.TITLE, "Take care JP");
							               values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/oog");
							               values.put(MediaStore.MediaColumns.SIZE, newSoundFile.length());						
							               values.put(MediaStore.Audio.Media.IS_RINGTONE, false);
							               values.put(MediaStore.Audio.Media.IS_NOTIFICATION, true);
							               values.put(MediaStore.Audio.Media.IS_ALARM, false);
							               values.put(MediaStore.Audio.Media.IS_MUSIC, false);

							               Uri uri = MediaStore.Audio.Media.getContentUriForPath(newSoundFile.getAbsolutePath());
							               Uri newUri = mCr.insert(uri, values);
							               

							               try 
							               {
							                   RingtoneManager.setActualDefaultRingtoneUri(GBSMainActivity.this, RingtoneManager.TYPE_NOTIFICATION, newUri);
							               } 
							               catch (Throwable t) 
							               {
							                  // Log.d(TAG, "catch exception");
							               }
							               	
									}
									Toast.makeText(GBSMainActivity.this, "Notification set!", Toast.LENGTH_SHORT).show();
									break;
									default:
										break;
								}
								
							}
						});
						builder.create().show();
						return true;
					}
				}
		);

	}

	public void setExitButtonClickListener() 
	{
		Button btnExit = (Button) findViewById(R.id.btnExit);
		btnExit.setOnClickListener
		(
			new View.OnClickListener() 
			{
				
				@Override
				public void onClick(View v) 
				{
					finish();
				}
			}	
		);
	}
	
	private void setMovieButtonClickListener() 
	{
		Button btnExit = (Button) findViewById(R.id.btnMovie);
		btnExit.setOnClickListener
		(
			new View.OnClickListener() 
			{
				
				@Override
				public void onClick(View v) 
				{
					launchMovieActivity();
				}
			}	
		);
	}
	
	private void setInstructionsButtonClickListener() 
	{
		Button btnInstructions = (Button) findViewById(R.id.btnInstructions);
		btnInstructions.setOnClickListener
		(
			new View.OnClickListener() 
			{
				
				@Override
				public void onClick(View v) 
				{
					launchInstructionsActivity();
				}
			}	
		);
	}
	
	protected void launchMovieActivity() 
	{
    	//Set up Intent
    	Intent launchMovie = new Intent(this, MovieActivity.class);
    	startActivity(launchMovie);
    }
	
	protected void launchInstructionsActivity() 
	{
    	//Set up Intent
    	Intent launchInstructions = new Intent(this, InstructionsActivity.class);
    	startActivity(launchInstructions);
    }
	
	public void startAnimation(View view)
	{
		Animator animator = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f);
		animator.setDuration(500); // 1 second = 1,000 milliseconds
		
		final View viewToAnimate = view;
		animator.addListener(new AnimatorListener() 
		{
			public void onAnimationStart(Animator animation) { }
		
			public void onAnimationRepeat(Animator animation) { }
		
			public void onAnimationEnd(Animator animation) 
			{
				Animator animator2 = ObjectAnimator.ofFloat(viewToAnimate, "alpha", 0f, 1f);
				animator2.setDuration(1500);
				animator2.start();
			}
		
			public void onAnimationCancel(Animator animation) { }
		
		});
		animator.start();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gbsmain, menu);
		return true;
	}

}
