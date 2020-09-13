Feature: Validating Place APIs

@AddPlaceGetPlace @Regression
Scenario Outline: Verify AddPlace API functionality working
Given Add Place Payload "<name>" "<language>" "<address>"
When User Calls "AddPlaceAPI" with "Post" http request
Then the API call is success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And Verify place_id created to "<name>" using "GetPlaceAPI"

Examples:
   |name    |language  |address   |
   |vaishali|English   |Mumbai    |
#  |Rani    |Spanish   |Delhi     |

@DeletePlace @Regression
Scenario: Verify DeletePlace API functionality working

Given DeletePlace Payload
When User Calls "DeletePlaceAPI" with "Delete" http request
Then the API call is success with status code 200
And "status" in response body is "OK"