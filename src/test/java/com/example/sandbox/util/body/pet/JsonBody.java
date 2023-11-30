package com.example.sandbox.util.body.pet;

import java.util.LinkedHashMap;

public class JsonBody {
	public LinkedHashMap<String, String> getJSON () {
		LinkedHashMap<String, String> jsonBody = new LinkedHashMap<>();
		jsonBody.put("id", "77");
		jsonBody.put("name", "Monoka");
		jsonBody.put("status", "sold");
		
		return jsonBody;
	}

}
