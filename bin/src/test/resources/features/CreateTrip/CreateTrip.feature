#Sample Feature Definition Template
@tag
Feature: Create trip for customer of DreamCheaper

  @tag1
  Scenario: Create new Trip for customer
    Given I am on Home page
    Then I click on Create Trip
    And I enter valid data on the page
      | Fields                  | Values          |
      | Email Address           | tri30@gmail.com |
      | Hotel                   | Sheraton Saigon |
      | Customer Purchase Price |             500 |
      | Currency                | USD             |
      | Checkin Date            | 2017/Nov/11     |
      | Checkout Date           | 2017/Nov/13     |
      | Refundable Date         | 2017/Nov/10     |
      | Booking Platform        | booking.com     |
      | Room description        | Double Deluxe   |
      | First Name              | Tom             |
      | Last Name               | Kenny           |
    Then trip is created successfully
