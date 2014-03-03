/*
 * The activity that converts from decimal to binary
 */
package com.example.binarydecimalconverter;

import java.util.Collection;
import java.util.Collections;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.NumberPicker;
import android.widget.TextView;

public class FromDecimalActivity extends Activity implements
		NumberPicker.OnValueChangeListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.todecimal_layout);

		// Sets the UI
		setNumberPickersStuff();
		setResultTextFont("Digital Computer Calculator.ttf");
	}

	/**
	 * Initializes the min and max values for the number pickers and sets their
	 * listener
	 */
	private void setNumberPickersStuff()
	{
		for (int i = 1; i < 4; i++)
		{
			// Find the number picker
			String numberPickerName = "numberPicker" + i;
			int numberPickerid = getResources().getIdentifier(numberPickerName,
					"id", "com.example.binarydecimalconverter");
			NumberPicker numberPicker = (NumberPicker) findViewById(numberPickerid);

			// set its min, max value and wheel and listener
			numberPicker.setMinValue(0);
			numberPicker.setMaxValue(9);
			numberPicker.setWrapSelectorWheel(true);
			numberPicker.setOnValueChangedListener(this);

		}

	}

	/**
	 * @param fontName
	 *            the name of the file in the assets with the font
	 * 
	 */
	private void setResultTextFont(String fontName)
	{
		// Find the resultText view
		TextView resultText = (TextView) findViewById(R.id.resultText2);
		Typeface newFont = Typeface.createFromAsset(getAssets(), fontName);

		// Set its typeface
		resultText.setTypeface(newFont);

		// Set its color
		resultText.setTextColor(MainActivity.TAB_COLOR);

	}

	/*
	 * The listener for the number pickers
	 */
	public void onValueChange(NumberPicker picker, int oldVal, int newVal)
	{
		// Converts the value in the number selectors to decimal and sets it to
		// the result text
		String result = calculateBinary();

		// sets that result to the text view
		TextView resultText = (TextView) findViewById(R.id.resultText2);
		resultText.setText(result);
	}

	/**
	 * @return the binary number as a string formed by the numbers in the number
	 *         chooser
	 */
	private String calculateBinary()
	{
		// Form the decimal number
		String decimalNumberStr = getDecimalStringFromPickers();

		// Calculate the binary number
		String binaryNumberStr = DecimalToBinary(decimalNumberStr);

		return binaryNumberStr;
	}

	/**
	 * @param decimalNumberStr
	 *            the decimal number required to be converted in a string
	 * @return the binary number converted from decimalNumberStr as a string the
	 *         number at index 0 is the most significant
	 */
	private String DecimalToBinary(String decimalNumberStr)
	{
		String reversedResult = "";
		Integer decimalNumber = Integer.parseInt(decimalNumberStr);

		// Calculate the number by dividing it by 2 till it reaches 0
		while (decimalNumber != 0)
		{
			if (decimalNumber % 2 == 1)
				reversedResult += "1";
			else
				reversedResult += "0";

			decimalNumber = decimalNumber / 2;
		}

		// reverse the reversed result
		String result = "";
		for (int i = reversedResult.length() - 1; i >= 0; i--)
			result += reversedResult.substring(i, i + 1);

		return result;
	}

	/**
	 * @return the combination of the number formed by the number pickers as a
	 *         string
	 */
	private String getDecimalStringFromPickers()
	{
		String result = "";
		for (int i = 1; i < 4; i++)
		{
			// Find the number picker
			String numberPickerName = "numberPicker" + i;
			int numberPickerid = getResources().getIdentifier(numberPickerName,
					"id", "com.example.binarydecimalconverter");
			NumberPicker numberPicker = (NumberPicker) findViewById(numberPickerid);

			// adds its value
			result += numberPicker.getValue();
		}
		return result;
	}
}
