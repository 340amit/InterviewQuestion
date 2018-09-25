package com.intuit;
/*package com.intuit;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class HttpGet {

	public static void main(String[] args) {
		
		

	}
	static int getCountries(String str, int p) throws Exception {
		String urlQuery="https://jsonmock.hackerrank.com/api/countries/search?name="+str;
		URL url = new URL(urlQuery);
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    InputStream inputStream =conn.getInputStream();
	    JSONParser jsonParser = new JSONParser();
	    	JSONObject jsonObject = (JSONObject)jsonParser.parse(new InputStreamReader(inputStream, "UTF-8"));
    }

}
*/