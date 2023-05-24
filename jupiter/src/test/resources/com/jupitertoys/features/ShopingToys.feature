Feature: Shopping Toys

  Scenario: Verify total cost of bought toys are correct
    Given I am in shop page
    When I buy following items
      | Product  | Count |
      | Unicorn |     2 |
    And I navigate to cart page
    Then I can see correct quantity, product and subtotal are correct
    When I do checkout
    And I fill in contact details section in checkoutPage with following details
      | FirstName | LastName | Email          | TelephoneNo | Address    | Suburb   | State | PostCode |
      | John      | Doe      | John@gmail.com |    46786788 | 22/test Rd | Sunshine | VIC   |     1234 |
    And I navigate to delivery details section
    And I provide Yes for Same as Contact Address field
    Then I can see given contact details are filled as delivery details
    When I navigate to payment details section
    And I fill payment detail section
    And I navigate to order confirmation details section
    And I submit the order
    Then I can see order getting unsuccessfull
