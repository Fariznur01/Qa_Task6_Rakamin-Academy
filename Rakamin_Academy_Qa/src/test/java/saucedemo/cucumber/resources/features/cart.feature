Feature: Menambahkan Produk ke Keranjang Belanja

  In order to membeli produk di Sauce Demo
  As a pengguna yang ingin berbelanja
  I want to menambahkan produk ke keranjang belanja dan memeriksa keranjang belanja

  Background:
    Given I am on the Sauce Demo login page
    And I am logged in with valid credentials

  @Regression @Positive
  Scenario: Menambahkan Produk ke Keranjang Belanja
    When I click on a product from the list

