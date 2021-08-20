package APIs;

import org.json.simple.JSONObject;

public class Body {
	
	String access() {
		
		JSONObject body = new JSONObject();
		
		body.put( "email", "eve.holt@reqres.in");
		body.put("password", "cityslicka");
		
		return body.toJSONString();
	}
}
