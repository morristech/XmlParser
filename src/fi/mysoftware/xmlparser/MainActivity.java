package fi.mysoftware.xmlparser;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.example.xmlparser.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		parseData();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void parseData() {
		XmlParser xmlevent = new XmlParser();
		//File file = new File(getResources().openRawResource(R.raw.sanalista));
		BufferedInputStream bis;
	
			bis = new BufferedInputStream(getResources().openRawResource(R.raw.sanalista));
			xmlevent.parse(bis);
						
		
		
		
	}

}
