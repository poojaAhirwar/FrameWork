Feature: This is my first feature

Scenario: This is our first Test Case
	Given Open browser
	When Launch Url
	Then Application Should Lunch
	
Scenario: Verify the popular brand names come under all brand names
	Given Open browser
	When Launch Url
	Then get the list of popular brands
	Then get the list of All brands
	And check if the popular brands comes under all brands