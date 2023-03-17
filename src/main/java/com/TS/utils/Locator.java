package com.TS.utils;

public interface Locator {
	String Carwale_other_brand_list="//h6[contains(text(),'POPULAR')]/following-sibling::ul)[1]/child::li";
	String Carwale_popular_brand_list="//h6[contains(text(),'OTHER BRANDS')]/following-sibling::ul)[1]/child::li";
	String Carwale_Search_car_box="input[placeholder=\"Type to select car name\"]";
	String Carwale_Search_Magnifier="div.o-duzCJV.o-bObQsr";
}
