Feature: Accept offer

  Background: 
    #Given Admin is on edit trip page

  #Scenario: Customer accept offer with Pay Now
  #  Given I have a trip "DCBCSX2E029"
   # And Admin send offer to customer
   # And User accept offer
   # When User choose option 'Pay Now'
   # Then User should see total amount to "Pay Now" 
   
   
   #Scenario: Customer accept offer with Pay Later
    #Given I have a trip "DCDJ59915D1"
    #And Admin send offer to customer
    #And User accept offer
    #When User choose option 'Pay Later'
    #Then User should see total amount of 'Pay Later' 
    
    #Scenario: Customer accept offer with Pay Now and currency != 'EUR'
    #Given I have a trip "DCDJ59915D1"
    #And Admin send offer to customer
    #And User accept offer
    #When User change currency to "USD"
    #And User choose option 'Pay Now'
    #Then User should see total amount to "Pay Now" 
    
    
    #Scenario: Customer accept offer with Pay Later and currency != 'EUR'
    #Given I have a trip "DCDJ59915D1"
    #And Admin send offer to customer
    #And User accept offer
    #When User change currency to "CAD"
    #And User choose option 'Pay Later'
    #Then User should see total amount of 'Pay Later'
    
    
    #Scenario: Customer who applied voucher accepted offer with Pay Now 
    #Given I have a trip "DCBCSX2E029"
    #And Admin send offer to customer
    #And User accept offer
    #When User choose option 'Pay Now'
    #Then User should see total amount to "Pay Now" 
    
     #Scenario: Customer who applied voucher accepted offer with Pay Later and currency != 'EUR'
    #Given I have a trip "DCBCSX2E029"
    #And Admin send offer to customer
    #And User accept offer
    #When User change currency to "USD"
    #And User choose option 'Pay Later'
    #Then User should see total amount of 'Pay Later' 
    
   #Scenario: Customer accept sub-sequent offer with Pay Now
   # Given I have a trip "DCBCSX2E029"
   # And Admin send offer to customer
   # When User accept subsequent-offer
    #Then User should see sub-total amount to 'Pay Now' 
    
      Scenario: Customer accept sub-sequent offer with Pay Later
    #Given I have a trip "DCBCSX2E029"
    #And Admin send offer to customer
    When User accept subsequent-offer
    And User change currency to "USD"
    Then User should see sub-total amount of 'Pay Later' 
    
    
    
    
    
		