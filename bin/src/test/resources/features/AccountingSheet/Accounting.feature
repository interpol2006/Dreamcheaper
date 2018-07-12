Feature: Accounting sheet

  Background: 
    Given Admin is on edit trip page

  #	Scenario: As an admin, I want to check calculation on accounting sheet for rebooked trip
  #	Given I have a trip "DC3EK5EF45J"
  #	And Admin send offer to customer
  #And User "tri60@gmail.com" log in to customer page
  #And User accept offer of trip "DC3EK5EF45J"
  #And User click on button 'Pay.Save.Enjoy'
  #And Admin rebook trip "DC1IYMBMNO5"
  #When Admin search trip "DC1IYMBMNO5" on accounting sheet
  #Then Admin should see correct values on "final" row
  Scenario: As an admin, I want to check calculation on accounting sheet for sub-sequent trip
    #Given I have a trip "DC9HED7LE86"
    #And Admin send offer to customer
    And User "tri60@gmail.com" log in to customer page
    #And User accept offer of trip "DC9HED7LE86"
    #
    #And Admin rebook trip "DC9HED7LE86"
    #And Admin send offer to customer
    And User accept sub-sequent offer of trip "DC9HED7LE86"
    When Admin search trip "DC9HED7LE86" on accounting sheet
    Then Admin should see correct values on "final" row

  Scenario: As an admin I want to compare data between Edit Trip Page and Accounting Page
    Given I have a trip "DCP0H9PYB7R"
    When Admin search trip "DCP0H9PYB7R" on accounting sheet
    Then Admin see data on Accounting sheet matched with Edit Trip on trip "DCP0H9PYB7R"
      | editPageField        | accountingPageField   |
      | ed_dcProfit          | acc_profit            |
      | ed_dcMargin          | acc_margin            |
      | ed_initialPriceinEur | acc_initialPriceinEur |
      | ed_savinginEur       | acc_savinginEUR       |
      | ed_ammountCharged    | acc_amountCharged     |
      | ed_grossPaymentinEur | acc_grossPaymentinEur |
      | ed_grossCostDC       | acc_grossCostDC       |
      | ed_paymentCostinEur  | acc_paymentCostinEur  |
