package com.example.sandbox.getPet;

import com.example.sandbox.Common;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static com.example.sandbox.util.constans.Tags.SMOKE;
public class petDetailTest extends Common{
	
	//Find By Status Tests
	
    @Test(enabled = true,groups = {SMOKE},description ="description")
    public void Test1(){
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("status","available");

        Response  response = getUrl(findByStatus, queryParams);
        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code");

        String id = response.jsonPath().get("[0].id").toString();

        Response  response2 = getUrl(petById+id);
        Assert.assertEquals(response2.getStatusCode(),200,"Invalid response code");
    }
    
    
    @Test(enabled = true,groups = {SMOKE},description ="description")
    public void Test2(){
        Map<String, String> queryParams = new TreeMap<>();
        queryParams.put("status","available");

        Response  response = getUrl(findByStatus, queryParams);
        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code");

        String id = response.jsonPath().get("[0].id").toString();

        Response  response2 = getUrl(petById+id);
        Assert.assertEquals(response2.getStatusCode(),200,"Invalid response code");
    }
    
    
    
    //-------------------------------------------------------------------------------------------   
   
    //Pet POST Tests
    
    @Test(enabled = true,groups = {SMOKE},description ="Testing POST method - auto generated ID")
    public void Test3(){
        Map<String, String> body = new TreeMap<>();

        Response  response = postUrl(pet, body);
        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code");
    }
    
    
    @Test(enabled = true,groups = {SMOKE},description ="Testing POST method with custom body (name and status)")
    public void Test4(){
       Map<String, String> body = new TreeMap<>();
       body.put("name", "Mono");
       body.put("status", "sold");

        Response  response = postUrl(pet, body);
        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code");
        
    }
    
    
   @Test(enabled = true,groups = {SMOKE},description ="Testing POST method with custom ID, name and status")
    public void Test5(){
    	
		LinkedHashMap<String, String> jsonBody = new LinkedHashMap<>();
		jsonBody.put("id", "77");
		jsonBody.put("name", "Monoka");
		jsonBody.put("status", "sold");
      

        Response  response = postUrl(pet, jsonBody);
        Assert.assertEquals(response.getStatusCode(),200,"Invalid response code");
        
    }
    
    
    //-------------------------------------------------------------------------------------------   
    
    //Pet PUT Tests
    
    @Test(enabled = true,groups = {SMOKE},description ="Testing PUT method")
    public void Test6(){  	
       Map<String, String> body = new TreeMap<>();
       body.put("id", "9223372016900020682");
       body.put("name", "Monoka");
       
        Response  response2 = putUrl(pet, body);
        Assert.assertEquals(response2.getStatusCode(),200,"Invalid response code");
    }
    
    @Test(enabled = true,groups = {SMOKE},description ="Testing PUT method to FAIL")
    public void Test7(){  	
       Map<String, String> body = new TreeMap<>();
       body.put("id", "9223372016900020682m");
       body.put("name", "Mono");
       
        Response  response2 = putUrl(pet, body);
        Assert.assertEquals(response2.getStatusCode(),200,"Invalid response code");
    }
    
    
    //-------------------------------------------------------------------------------------------   
    
    //Pet DELETE Tests
    
    @Test(enabled = true,groups = {SMOKE},description ="Testing DELETE method - delete the first item with 'status'='available'")
    public void Test8(){  	
    	
    	 Map<String, String> queryParams = new TreeMap<>();
         queryParams.put("status","available");

         Response  response = getUrl(findByStatus, queryParams);
         Assert.assertEquals(response.getStatusCode(),200,"Invalid response code");

         String id = response.jsonPath().get("[0].id").toString();
       
        Response  response2 = deleteUrl(petById+id);
        Assert.assertEquals(response2.getStatusCode(),200,"Invalid response code");
    }
    
 
   
    
}
