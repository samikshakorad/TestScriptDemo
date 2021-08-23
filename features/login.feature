Feature: Test Login Functinality

  Scenario: Login to the testscriptdemo
    Given open browser
    Given user pass the url "https://testscriptdemo.com/"
    Then click on accept all button
    When click on My Account
    And user enters valid user name "Samiksha" and password "Samiksha@1234"
    And user click on sign in
    Then user navigate to homepage
    Given I add four different products to my wish list
    When I view my wishlist table
    Then I find total four selected items in my Wishlist
    When I search for lowest price product
    And I am able to add the lowest price item to my cart
    Then I am able to verify the item in my cart
