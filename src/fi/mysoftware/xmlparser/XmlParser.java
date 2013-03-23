package fi.mysoftware.xmlparser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.util.Log;
import android.util.Xml;

/**
 * Parses Xml files with given inputstream.
 * 
 * @author Otto Kivikarki
 * @version 2013-24-3
 * 
 */
public class XmlParser {
	
	/**
	 * Initializes a xml parser.
	 * 
	 * @param in
	 *            InputStream in
	 * @return parser
	 * @throws XmlPullParserException
	 * @throws IOException
	 */
	public void parse(InputStream in) {
		
		ArrayList<String> data = new ArrayList<String>();
		
		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			XmlPullParser parser = factory.newPullParser();		
			parser.setInput(in, "UTF-8");
			
			int eventType = parser.getEventType();
			
			while (eventType != XmlPullParser.END_DOCUMENT) {
				
				String tagname = parser.getName();
                switch (eventType) {
                case XmlPullParser.START_TAG:
                    if (tagname.equalsIgnoreCase("s")) {
                        //data.add("1");
                    }
                    break;
 
                case XmlPullParser.TEXT:
                	if(parser.getText().equals("aakkonen")) {
                    data.add(parser.getText());
                    Log.d("DAT", "in");
                	}
                    break;
 
                case XmlPullParser.END_TAG:
                    if (tagname.equalsIgnoreCase("employee")) {
                        data.add("2");
                    } 
                    break;
 
                default:
                    break;
                }
                
                eventType = parser.next();
            }
		} catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } /*finally {
			Log.d("Parser", "Method works");
			in.close();
		}*/
	}
}
