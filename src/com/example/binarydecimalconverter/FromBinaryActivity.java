/*
 * The activity that converts from binary to decimal
 */
package com.example.binarydecimalconverter;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;


public class FromBinaryActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tobinary_layout);
		
		// Manage the views
		setResultTextFont("Digital Computer Calculator.ttf");
		setSwitchesListeners();
		calculateDecimal(null);
		
		// Figuring out the text

		
		
	}

	private void setResultTextFont(String fontName)
	{
		// Find the resultText view
		TextView resultText = (TextView) findViewById(R.id.resultText);
		Typeface newFont = Typeface.createFromAsset(getAssets(), fontName);
		
		// Set its typeface
		resultText.setTypeface(newFont);
		
		// Set its color
		resultText.setTextColor(MainActivity.TAB_COLOR);
		
		// Manging its height
		Log.e("Game", "Width : " +getWindowManager().getDefaultDisplay().getWidth());
		Log.e("Game", "Height : " +getWindowManager().getDefaultDisplay().getHeight());
		
		
	}

	private void setSwitchesListeners()
	{
		for (int i = 0; i < 8; i++)
		{
			// Find the switch
			String switchIdText = "switch" + i;
			int switchId = getResources().getIdentifier(switchIdText, "id", "com.example.binarydecimalconverter");
			CompoundButton s = (CompoundButton)findViewById(switchId);
			
			// set its listener
			s.setOnCheckedChangeListener(new OnCheckedChangeListener()
			{
				
				@Override
				public void onCheckedChanged(CompoundButton arg0, boolean arg1)
				{
					calculateDecimal(null);
				}
			});
		}
	}

	public  void calculateDecimal(View v)
	{
		int result = 0;
		for (int i = 0; i < 8; i++)
		{
			// Find the switch
			String switchIdText = "switch" + i;
			int switchId = getResources().getIdentifier(switchIdText, "id", "com.example.binarydecimalconverter");
			CompoundButton s = (CompoundButton)findViewById(switchId);
			
			// Add its weight
			if(s.isChecked())
				result += Math.pow(2, i);
		}
		
		// Set the result Text
		TextView text = (TextView)findViewById(R.id.resultText);
		text.setText( Integer.toString(result));
			
		}

	
}
