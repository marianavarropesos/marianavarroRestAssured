Feature: Validate pet


 @PetGet
 Scenario: Validate that the response of the pet by id request is 200
   Given the following get request that bring us the pet by id
   And the response is 200

 @PetPost
 Scenario Outline: Validate the response of the post is 200
   Given the following post request to add pets
   Then the body response contains the "<name>" of the new pet
   Examples:
     | name         |
     | Pez morado   |


