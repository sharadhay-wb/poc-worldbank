package com.example.poc.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class VisionPovMoreDataPage {
	Page page;
	

	public VisionPovMoreDataPage(Page page) {
		this.page = page;
	}

	public List<String> getCountriesList() {
		List<String> countryList = new ArrayList<>();
		countryList = page.locator("//div[@class='text-ellipsis']").allTextContents();
		return countryList;
	}

	public List<Locator> rowList() {
		List<Locator> rowList = new ArrayList<>();
		rowList = page.locator("//div[@class='ag-center-cols-container']/div[@role='row']").all();
		System.err.println("rowCount "+ rowList.size());
		return rowList;
	}

	public HashMap<String, HashMap<Integer, Double>> getCountryValue(String perDayValue) {
		System.err.println("Comes in here in more data "+ perDayValue);
		
		HashMap<String, HashMap<Integer, Double>> resultMap = new HashMap<>();
		HashMap<Integer, Double> innerMap = new HashMap<>();
		page.waitForTimeout(3000);
		int rowCount=rowList().size();
		
		rowList().forEach(row -> {
			row.scrollIntoViewIfNeeded();
			
			String country = row.locator("xpath=/div[1]").textContent().trim();
			System.err.println("Country:- " + country);
			page.waitForTimeout(500);
			String year6_85= page.locator("//div[@class='ag-pinned-right-cols-container'][1]//div[@col-id='SI_POV_UMIC_latestYear']/span/span").first().textContent();
			System.err.println("Country:- " + country + "   Year: " + year6_85 );
//			Double value2_15= Double.parseDouble(row.locator("xpath=/div[2]//span").textContent());
//			System.err.println("Country:- " + country + "   Year: " + year6_85 + " Value: " + value2_15);
			String year2_15 = page.locator("xpath=.//div[@col-id='SI_POV_DDAY_achievedBaseVal'][1]/span/span").textContent();
			System.err.println("Country:- " + country + "   Year: " + year2_15 );
			Double value6_85 = Double.parseDouble(row.locator("xpath=/div[5]//span").textContent());
			
//			
//			System.err.println("Country:- " + country + "   Year: " + year2_15 + " Value: " + value2_15);
//			System.err.println("Country:- " + country + "   Year: " + year6_85 + " Value: " + value6_85);
//			int year = 0;
//			Double value = 0.0;
//			page.waitForTimeout(100);
//			
//			
//			if (perDayValue.contains("2.15"	)) {
////				year = Integer.parseInt(row.locator("xpath=./div[3]").textContent());
////				value = Double.parseDouble(row.locator("xpath=./div[2]").textContent());
//				innerMap.put(year2_15, value2_15);
//			} else if (perDayValue.contains("6.85")) {
////				year = Integer.parseInt(row.locator("xpath=/div[6]").textContent());
////				value = Double.parseDouble(row.locator("xpath=/div[5]").textContent());
//				innerMap.put(year6_85, value6_85);
//			}
//			innerMap.put(year, value);
//			System.err.println("Country:- " + country + "   Year: " + year + " Value: " + value);
//			resultMap.put(country, innerMap);

		});
		return resultMap;
	}

}
