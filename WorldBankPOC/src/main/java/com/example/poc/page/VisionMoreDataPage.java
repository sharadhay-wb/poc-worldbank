package com.example.poc.page;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class VisionMoreDataPage {
	Page page;

	public VisionMoreDataPage(Page page) {
		this.page = page;
	}

	public List<Locator> getCountries() {
		List<Locator> countryLoc = new ArrayList<>();
		countryLoc = page.locator("//div[@class='text-ellipsis']").all();
		return countryLoc;
	}
	////div[@col-id='SI_POV_DDAY_achievedBaseVal']/span
	
	//div[@col-id='SI_POV_DDAY_latestYear']/span
	
	//div[@col-id='SI_POV_UMIC_achievedBaseVal']/span
	
	//div[@col-id='SI_POV_UMIC_latestYear']/span
	
	
	
	
	
	

}
