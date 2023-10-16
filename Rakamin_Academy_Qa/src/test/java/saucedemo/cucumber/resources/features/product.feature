Feature: Penjelajahan Produk di Sauce Demo

  In order to melihat produk yang tersedia
  As a pengguna yang sudah login
  I want to bisa menjelajahi produk di Sauce Demo website.

  Background:
    Given I am on the Sauce Demo login page
    And I am logged in with valid credentials
  @Regression @Positive
  Scenario: Mengakses Detail Produk
    When I click on a product from the list
    Then I should see the details of the selected product
