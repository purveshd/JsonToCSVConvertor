package com.accenture.lighthouse.jsontocsv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSON2CSV {

	public static void main(String[] args) throws Exception {

		/*
		 * String str = new String( Files.readAllBytes(Paths.get(
		 * "C:/Users/purvesh.dwivedi/Downloads/eclipse/Docs/example_2.json")));
		 * 
		 * JFlat flatMe = new JFlat(str);
		 * 
		 * List<Object[]> json2csv = flatMe.json2Sheet().getJsonAsSheet();
		 * 
		 * flatMe.write2csv(
		 * "C:/Users/purvesh.dwivedi/Downloads/eclipse/Docs/example_2.csv");
		 */

		JSONParser jsonParser = new JSONParser();
		try {
			JSONObject jsonObject = (JSONObject) jsonParser
					.parse(new FileReader("C:/Users/purvesh.dwivedi/Downloads/jsonlint.com-20200205T123202.json"));

			JSONObject categories = (JSONObject) jsonObject.get("categories");

			// long total = (Long) compose.get("total");

			JSONArray performance = (JSONArray) categories.get("performance");
			JSONArray accessibility = (JSONArray) categories.get("accessibility");
			JSONArray bestPractices = (JSONArray) categories.get("best-practices");
			JSONArray seo = (JSONArray) categories.get("seo");

			Object composeObj = jsonObject.get("compose");
			JSONObject jsonObject1 = (JSONObject) composeObj;
			/// Iterator itr = performance.iterator();

			/*
			 * while (itr.hasNext()) { Object slide = (Object) itr.next(); JSONObject
			 * jsonObject2 = (JSONObject) slide; JSONObject
			 * 
			 * }
			 */

			String performanceScore = (String) jsonObject.get("/categories/performance/score");
			String accessibilityScore = (String) jsonObject.get("/categories/accessibility/score");
			String bestPracticesScore = (String) jsonObject.get("/categories/best-practices/score");
			String seoScore = (String) jsonObject.get("/categories/seo/score");

			System.out.println("Performance Score:" + performanceScore);
			System.out.println("Accessibility Score:" + accessibilityScore);
			System.out.println("Best-Practices Score:" + bestPracticesScore);
			System.out.println("SEO Score:" + seoScore);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}