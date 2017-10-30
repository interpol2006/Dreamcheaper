

Feature: Edit Trip

Background:
Given Admin is on edit trip page

#Scenario: History entry for cancel
#Given I have a booking to cancel "DCCVQCNJRRC"
#And I click on tab 'Booking No'
#When I choose option 'I cancelled'
#And I click button 'Save'
#And I open Trip History
#Then I should see a history entry "Booking was cancelled"

Scenario: Calculation DC margin 
Given I have a trip "DCAPFOCP5R0"
When I check the value of trip
Then I should see correct Profit after all 
And correct Real Profit Margin 







