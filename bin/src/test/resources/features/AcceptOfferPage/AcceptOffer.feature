Feature: Accept offer

  Background: 
    Given Admin is on edit trip page

	@tag-paynow1
  Scenario: Customer accept offer with Pay Now
    Given I have a trip "DCIBV83WTG1"
    And Admin send offer to customer
    And User "tri60@gmail.com" log in to customer page
    And User accept offer
    When User choose option 'Pay Now'
    Then User should see total amount to "Pay Now" 
   
   @tag-paylater
   Scenario: Customer accept offer with Pay Later
    Given I have a trip "DC2TRRJBTN5"
    And Admin send offer to customer
    And User "tri60@gmail.com" log in to customer page
    And User accept offer
    When User choose option 'Pay Later'
    Then User should see total amount of 'Pay Later' 
    
    @tag-paynow
    Scenario: Customer accept offer with Pay Now and currency != 'EUR'
    Given I have a trip "DCX3SCP86SC"
    And Admin send offer to customer
    And User "tri60@gmail.com" log in to customer page
    And User accept offer
    When User change currency to "USD"
    And User choose option 'Pay Now'
    Then User should see total amount to "Pay Now" 
    
    
    Scenario: Customer accept offer with Pay Later and currency != 'EUR'
    Given I have a trip "DC3I71B9ULA"
    And Admin send offer to customer
    And User "tri60@gmail.com" log in to customer page
    And User accept offer
    When User change currency to "CAD"
    And User choose option 'Pay Later'
    Then User should see total amount of 'Pay Later'
    
    @tag-paynow
    Scenario: Customer who applied voucher accepted offer with Pay Now 
    Given I have a trip "DCN90430KY5"
    And Admin send offer to customer
    And User "tri60@gmail.com" log in to customer page
    And User accept offer
    When User choose option 'Pay Now'
    Then User should see total amount to "Pay Now" 
    
     Scenario: Customer who applied voucher accepted offer with Pay Later and currency != 'EUR'
    Given I have a trip "DCXT82ILJI1"
    And Admin send offer to customer
    And User "tri60@gmail.com" log in to customer page
    And User accept offer
    When User change currency to "USD"
    And User choose option 'Pay Later'
    Then User should see total amount of 'Pay Later' 
    
    @tag-paynow
   Scenario: Customer accept sub-sequent offer with Pay Now
    Given I have a trip "DCMTBBVIY47"
    And Admin send offer to customer
    And User "tri60@gmail.com" log in to customer page
    And User accept offer
    And Admin rebook trip "DCMTBBVIY47"
    And Admin send offer to customer
    When User accept subsequent-offer
    Then User should see sub-total amount to 'Pay Now' 
    
      Scenario: Customer accept sub-sequent offer with Pay Later
    Given I have a trip "DC5JAM2A37K"
    And Admin send offer to customer
    And User "tri60@gmail.com" log in to customer page
    When User accept subsequent-offer
    And User change currency to "USD"
    Then User should see sub-total amount of 'Pay Later' 
    
    
    
    
    
		