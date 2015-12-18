/*
 * csc5390 Mobile Development & Entrepreneurship
 * Villanova University
 * Spring 2014
 * 
 * HelloAndroid Example using Activity, EditText & Button views and Toast widget
 * HelloAndroid.java, activity_main.xml
 * 
 */

package edu.villanova.csc5930.helloandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

/**
 * Prompt user for a name then provide a shout out using a toast
 * @see <a href="http://developer.android.com/reference/android/app/Activity.html">Activity</a>
 * @see <a href="http://developer.android.com/reference/android/widget/EditText.html">EditText</a>
 * @see <a href="http://developer.android.com/reference/android/widget/Button.html>Button</a>
 * @see <a href="http://developer.android.com/guide/topics/ui/controls/text.html">Text Fields XML Guide</a>
 */
public class HelloAndroid extends Activity
{
	private static final String TAG = "HelloAndroid";
	
	private EditText firstName;
	private EditText lastName;
	private Button shoutOut;
	
	/**
	 * onCreate() is triggered by Android when the activity is first created
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		Log.d(TAG, "onCreate(Bundle) method triggered.");	// log debug message to LogCat
		
		super.onCreate(savedInstanceState);					// always call the super method
		setContentView(R.layout.activity_main);				// expand activity layout
		
		// obtain handles to activity views (ie controls or widgets)
		firstName = (EditText)findViewById(R.id.firstNameTxt);
		lastName = (EditText)findViewById(R.id.lastNameTxt);
		shoutOut = (Button)findViewById(R.id.shoutOutBtn);
		
		/**
		 * Implement a listener (anonymous inner class) to handle the button click event and send a toast
		 * @see <a href="http://www.clear.rice.edu/comp310/JavaResources/anon_inner.html">Anonymous Inner Class</a>
		 * @see <a href="http://developer.android.com/reference/android/view/View.OnClickListener.html">View.OnClickListener</a>
		 * @see <a href="http://developer.android.com/reference/android/widget/Toast.html">Toast</a>
		 */
		shoutOut.setOnClickListener(new OnClickListener ()
		{
			@Override
			public void onClick(View v) { shoutOut(); }
		});
		
		/**
		 * Let's also implement a listener (anonymous inner class) to handle the IME (input method editor) action or keyboard event and send a toast
		 * @see <a href="http://developer.android.com/reference/android/widget/TextView.OnEditorActionListener.html">TextView.OnEditorActionListener</a>
		 * @see <a href="http://developer.android.com/guide/topics/text/creating-input-method.html">Input Method</a>
		 * @see <a href="http://developer.android.com/reference/android/widget/Toast.html">Toast</a>
		 */
		lastName.setOnEditorActionListener(new OnEditorActionListener()
		{
			@Override
			public boolean onEditorAction(TextView view, int action, KeyEvent event)
			{
				if (action == EditorInfo.IME_ACTION_SEND || event.getKeyCode() == KeyEvent.KEYCODE_ENTER) { shoutOut(); }
				return false;
			}
		});
	}
	
	/**
	 * method to generate our toast
	 */
	protected void shoutOut ()
	{
		Log.d(TAG, "toasting " + firstName.getText() + " " + lastName.getText());	// log debug message to LogCat
		
		// generate the toast
		Toast toast = Toast.makeText(this, "Hello " + firstName.getText() + " " + lastName.getText() + " !", Toast.LENGTH_LONG);
		toast.show();
	}
}
