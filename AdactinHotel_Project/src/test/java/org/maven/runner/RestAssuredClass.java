package org.maven.runner;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestAssuredClass {

	public static void main(String[] args) {

		Response response = RestAssured.get("https://reqres.in/api/users");
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		JsonPath jsonPath = response.jsonPath();
		System.out.println(jsonPath.get("data.first_name"));
		System.out.println(jsonPath.get("data.avatar"));
	}

}
