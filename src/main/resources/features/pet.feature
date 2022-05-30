Feature: Validate pet


 @PetGet
 Scenario: Validate that the response of the pet by id request is 200
   Given the following get request that bring us the pet by id
   And the response is 200

 @PetPost
 Scenario Outline: Validate the response of the post is 200
   Given the following post request to add pets
   And the response is 200 for post
   Then the body response contains the "<name>" of the new pet
   Examples:
     | name         |
     | Pez morado   |

   @PetPut
   Scenario Outline: Validate the response of the put is 200
     Given the following post request to update a pet
     And the response is 200 for put
     Then the body response contains the "<name>" of the pet updated
     Examples:
       | name                 |
       | Pez morado update    |

   @PetDelete
   Scenario: Validate delete a pet
     Given the following request that delete a pet
     Then the response is 200 for delete
