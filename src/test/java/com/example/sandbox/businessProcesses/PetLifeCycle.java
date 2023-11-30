package com.example.sandbox.businessProcesses;
import static com.example.sandbox.util.constans.Tags.REGRESSION;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.example.sandbox.Common;
import io.restassured.response.Response;
import static com.example.sandbox.util.constans.TestData.HYDRAIMAGE;

//import static com.example.sandbox.util.body.pet.JsonBody.createJsonBody;

public class PetLifeCycle extends Common {
	
	
	//Create new pet
	   @Test(enabled = true,groups = {REGRESSION},description ="Create new pet")
	    public void NewPetTest(){
	    	
			LinkedHashMap<String, String> jsonBody = new LinkedHashMap<>();
			jsonBody.put("id", "77");
			jsonBody.put("name", "Mono");
			jsonBody.put("status", "available");
	      

	        Response  response = postUrl(pet, jsonBody);
	        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code");
	        
	    }
	   
	   //Update value
	   @Test(enabled = true,groups = {REGRESSION},description ="Update value")
	    public void UpdatePet(){  	
	       Map<String, String> body = new TreeMap<>();
	       body.put("id", "77");
	       body.put("name", "Monoka");
	       body.put("status", "sold");
	       
	        Response  response2 = putUrl(pet, body);
	        Assert.assertEquals(response2.getStatusCode(),200,"Invalid response code");
	    }
	   
	   //Delete pet
	   @Test(enabled = true,groups = {REGRESSION},description ="Delete pet")
	    public void DeletePet(){  	
		   
		   String id = "77";
	       
	        Response  response2 = deleteUrl(petById+id);
	        Assert.assertEquals(response2.getStatusCode(),200,"Invalid response code");
	    }
	   
	   //Check pet by id
	   @Test(enabled = true,groups = {REGRESSION},description ="Check pet by id")
	    public void CheckPetById(){

	    	String id = "77";
	    	
	        Response  response2 = getUrl(petById+id);
	        Assert.assertEquals(response2.getStatusCode(),200,"Invalid response code");
	    }
	   
}
