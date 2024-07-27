Feature: Search and Place the Order for Products

@SearchOrder
Scenario Outline: Search Experience for product search in both home and offers page
Given User is on GreenCart Landing Page
When User searched with shortname <Name> and extracted actual name of the product
Then User searched with same shortname <Name> in offers page
And Validate product name in offers page matches with the landing page

Examples:
| Name |
| Tom |
| Beet |
