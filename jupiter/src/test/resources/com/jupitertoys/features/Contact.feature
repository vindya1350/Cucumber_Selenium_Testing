Feature: Contact submission

  Scenario: Verify contact submission fail when try to directly click on submit button
     When I navigate to contact Page
     And I submit contact form
     Then I can see following error messages are populated for Mandatory fields
       | FieldName | ErrorMsg             |
       | Forename  | Forename is required |
       | Email     | Email is required    |
       | Type      | Type is required     |
       | Message   | Message is required  |
      When I fill in contact details of feedback form with following details
       | Name | Email         |TelephoneNo|Type  |Message    |
       | John | John@gmail.com|46786788   |Review|Test Text  |
     Then I can not see error messages

   Scenario: Verify correct contact submission
     When I navigate to contact Page
     And I fill in contact details of feedback form with following details
     | Name | Email        |TelephoneNo|Type     |Message    |
     | Dan  | dan@gmail.com|46786788   |Complaint|Test Text  |
     And I submit contact form
     Then I can see success message