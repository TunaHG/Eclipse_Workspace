package mvctest;

import java.util.HashMap;

public class HandlerMapping {
	HashMap<String, Controller> mappings;
	// URL의 뒤에 hello가 들어오면 HelloController를 호출하도록 만들기 위함.
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("hello", new HelloController());
	}
	
	public Controller getController(String name) {
		return mappings.get(name);
	}
}
