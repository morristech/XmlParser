package fi.mysoftware.xmlparser;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
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
	private ArrayList<String> list;

	/**
	 * Called when program is ran.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		list = new ArrayList<String>();
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
	 * @param text
	 *            text to look for in the file
	 * @throws IOException
	 */
	public void parseData(String text) throws IOException {
		XmlParser xmlevent = new XmlParser();
		BufferedInputStream bis = new BufferedInputStream(getResources()
				.openRawResource(R.raw.sanalista));

		list = xmlevent.parse(bis, text);
		String result = "";
		for(String s : list) {
			result = result + s + "\n";
		}
		if (list.size() > 0) {
			textView.setText(result);
		} else {
			textView.setText("Sanaa ei löydy");
		}
	}

	/**
	 * When button is pressed.
	 * 
	 * @param v
	 *            View
	 */
	public void findClicked(View v) {
		text = editText.getText().toString();

		try {
			parseData(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
