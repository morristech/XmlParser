package fi.mysoftware.xmlparser;

import java.io.BufferedInputStream;
import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.xmlparser.R;

/**
 * Launches the program.
 * 
 * @author Otto Kivikarki
 * @version 2013-24-3
 *
 */
public class MainActivity extends Activity {

	private TextView textView;
	private EditText editText;
	private String text;
	
	/**
	 * Called when program is ran.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
			
		textView = (TextView) findViewById(R.id.textView1);
		editText = (EditText) findViewById(R.id.editText1);
	}

	/**
	 * Create options.
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/**
	 * Parses xml data with given file.
	 * 
	 * @param text text to look for in the file
	 */
	public void parseData(String text) {
		XmlParser xmlevent = new XmlParser();
		BufferedInputStream bis = new BufferedInputStream(getResources().openRawResource(R.raw.sanalista));
		ArrayList<String> list = xmlevent.parse(bis, text);
		if (list.size() > 0) {
		textView.setText(list.get(0)); 
		} else {
		textView.setText("Sanaa ei löydy");
		}		
	}
	
	/**
	 * When button is pressed.
	 * 
	 * @param v View
	 */
	public void findClicked(View v) {
		text = editText.getText().toString();
		parseData(text);
	}

}
