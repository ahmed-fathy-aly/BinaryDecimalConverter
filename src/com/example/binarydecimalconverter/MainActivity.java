/*
 * Author : Ahmed Fathy Aly
 * A simple app that converts between decimal and binary
 */

package com.example.binarydecimalconverter;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity
{
	public static final int TAB_COLOR = Color.rgb(48, 192, 240);

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Manage the tab host
		TabHost tabHost = getTabHost();

		// To Decimal tab
		TabSpec toBinaryTab = tabHost.newTabSpec("To Decimal");
		toBinaryTab.setIndicator("To Decimal");
		toBinaryTab.setContent(new Intent(this, FromBinaryActivity.class));
		tabHost.addTab(toBinaryTab);
		
		// To Binary tab
		TabSpec toDecimalTab = tabHost.newTabSpec("To Binary");
		toDecimalTab.setIndicator("To Binary");
		toDecimalTab.setContent(new Intent(this, FromDecimalActivity.class));
		tabHost.addTab(toDecimalTab);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
