Feature: WordPress Website Validation

Scenario: Validate WordPress functionalities
  Given Launch WordPress website
  When Navigate to Get WordPress page
  Then Verify Get WordPress text
  And Navigate to Photo Directory
  Then Search image and verify results
