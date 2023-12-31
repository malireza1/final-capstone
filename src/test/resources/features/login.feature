
@smoke
Feature: Login

Background:
	Given User is on retail website homepage
	When User click on the login link

@login
Scenario: Verify user is able to login to tek retail website
	And User enter email 'student20@tekschool.us' and password 'Student@20'
	And User click on login button
	Then User should be logged in into Account
	
@register
Scenario Outline: Verify user is able to register with tek retail website
	And User click on create new account link
	And User enter '<name>' and '<email>' and '<password>' and '<confPassword>'
	And User click on singup button
	Then Verify user account is created
	
Examples:
|name|email|password|confPassword|
|guardians|guardiansstu156@gmail.com|Guardians345$|Guardians345$|
