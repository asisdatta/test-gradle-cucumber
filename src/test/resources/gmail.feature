@gmail
Feature: Login Action

@gmailLogin
Scenario: Successful Login with Valid Credentials
	Given User is on Gmail home Page
	When User enters UserName and Password
	Then Should login successfully

