Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check deals and promotions page
    Given User opens '<homePage>' page
    And User checks promo field visibility
    When User clicks 'Deals & Promotions' button
    And User checks that deals page contains '<bannerText>' in description
    Then User checks that amount of deals in catalog are '<amountOfDeals>'
    And User clicks 'Deal of the Day' button
    And User checks product list contains '<keyword>' in description

    Examples:
      | homePage                | bannerText           | amountOfDeals | keyword         |
      | https://www.amazon.com/ | Deals and Promotions |    48            | DEAL OF THE DAY |

  Scenario Outline: Check career page
    Given User opens '<homePage>' page
    And User checks footer visibility
    When User clicks 'Careers' button
    And User checks search field visibility
    Then User checks that amount of opportunities link  is '<amount>'
    And User checks 'Learn about' button visibility

    Examples:
      | homePage                | amount  |
      | https://www.amazon.com/ | 3       |

  Scenario Outline: Check login with valid credential
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks login pop-up visibility
    When User clicks 'Sign in' button
    And User writes in valid '<e-mail>'
    And User clicks 'Continue' button
    And User writes in valid '<password>' too
    And User clicks 'Sign-In' button
    Then User hovers the mouse to 'Account & Lists'
    And User clicks 'Account' button
    And User clicks 'Your orders' button
    And User checks 'Search Orders' button visibility

    Examples:
      | homePage                | e-mail              | password   |
      | https://www.amazon.com/ | illya7421@gmail.com | oracle7421 |

  Scenario Outline: Check login with invalid credential
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks login pop-up visibility
    When User clicks 'Sign in' button
    And User writes in valid '<e-mail>'
    And User clicks 'Continue' button
    And User writes in invalid '<password>'
    And User clicks 'Sign-In' button
    Then User checks that error message is '<errorMessage>'

    Examples:
      | homePage                | errorMessage        | e-mail              | password     |
      | https://www.amazon.com/ | There was a problem | illya7421@gmail.com | notValidPass |

  Scenario Outline: Check forgot your password page
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks login pop-up visibility
    When User clicks 'Sign in' button
    And User writes in valid '<e-mail>'
    And User clicks 'Continue' button
    And User clicks 'Forgot your password?' button
    And User clicks 'Sign in' button
    Then User clicks 'I need more help' button
    And User checks that verification message is '<verificationMessage>'

    Examples:
      | homePage                | verificationMessage            | e-mail             |
      | https://www.amazon.com/ | check your Junk or Spam folder | illya7421@gmail.com|

  Scenario Outline: Check catalog search
    Given User opens '<homePage>' page
    And User checks header visibility
    When User clicks 'All' button
    And User clicks 'Electronics' button
    And User clicks 'Headphones' button
    Then User checks that amount of products in catalog are '<amountOfProducts>'
    And User checks category is '<category>'
    And User clicks products page button
    And User checks category is '<category>' again

    Examples:
      | homePage                | amountOfProducts | category   |
      | https://www.amazon.com/ | 0              | Headphones |

  Scenario Outline: Check add product to cart
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks home search field visibility
    When User makes search by '<keyword>'
    And User clicks search button
    And User clicks products page button
    And User clicks 'Add to Cart' button on product
    And User checks that add to cart page is visible
    Then User clicks cart button
    And User checks 'Proceed to checkout' button visibility
    And User checks Subtotal is '<subtotal>'

    Examples:
      | homePage                | keyword  | subtotal           |
      | https://www.amazon.com/ | laptop   | Subtotal (1 item): |

  Scenario Outline: Check search field with real goods
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks search field visibility
    When User makes search by '<keyword>'
    And User clicks search button
    Then User clicks 'Camcorders' button
    And User clicks 'Under $25' button
    And User clicks products page button
    And User clicks 'Add to Cart' button on product
    And User checks that add to cart page is '<addToCart>'

    Examples:
      | homePage                | keyword | addToCart   |
      | https://www.amazon.com/ | camera  | Add to cart |

  Scenario Outline: Check search field with invalid values
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks search field visibility
    When User makes search by '<keyword>'
    And User clicks search button
    Then User checks that search error message is '<errorMessage>'

    Examples:
      | homePage                | keyword                                        | errorMessage    |
      | https://www.amazon.com/ | asgvfoasnklasjnhfiaskgbfalasfgasgaslanklnsfaks | No results for  |

  Scenario Outline: Check number of items in the cart
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks search field visibility
    When User makes search by '<keyword>'
    And User clicks search button
    And User clicks products page button
    And User clicks 'Add to Cart' button on product
    And User checks that add to cart page is visible
    And User checks 'Sign in securely' button visibility
    And User clicks home button
    And User clicks 'All' button
    And User clicks 'Electronics' button
    And User clicks 'Headphones' button
    And User clicks products page button
    Then User clicks cart button
    And User checks 'Proceed to checkout' button visibility
    And User checks Subtotal is '<subtotal>'

    Examples:
      | homePage                | keyword  | subtotal            |
      | https://www.amazon.com/ | dog food | Subtotal (3 items): |
