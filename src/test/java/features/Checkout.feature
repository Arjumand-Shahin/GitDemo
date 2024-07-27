Feature: Search and Place the Order for Products

@PlaceOrder
Scenario Outline: Search Experience for product search in both home and offers page
Given User is on GreenCart Landing Page
When User searched with shortname <Name> and extracted actual name of the product
And Added "3" items to the selected product to cart
Then User proceed to checkout and validate the <Name> items in checkout page
And verify user has ability to enter promocode and place the order

Examples:
| Name |
| Tom |
