Feature: Validate pet


 @PetGet
 Scenario: Validate that the response of the pet by id request is 200
   Given the following get request that bring us the pet by id
   And the response is 200

