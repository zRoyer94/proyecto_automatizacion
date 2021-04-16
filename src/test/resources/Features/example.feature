Feature: Examples
  Optional description of the feature

  @test
  Scenario: Get Sites
    Given I am in App main site
    Then I load the DOM Information Spotify_registro.json
    And I click in element Email
    And I set element Email with text roger.pinedav94@gmail.com
    Then I take screenshot: Feature_0001

  @test
  Scenario: Assert contain text
    Given I am in App main site
    Then I load the DOM Information Spotify_registro.json
    And I click in element Email
    And I set element Email with text roger.pinedav94@gmail.com
    And I click in element out
    Then Assert if Email Error contains text Este correo electrónico ya está conectado a una cuenta.
    Then I take screenshot: Feature_0002

  @test
  Scenario: Assert not contain text
    Given I am in App main site
    Then I load the DOM Information Spotify_registro.json
    And I click in element Email
    And I set element Email with text roger.pinedav94@gmail.com
    And I click in element out
    Then Check if Email Error NOT contains text Este correo electrónico ya está conectado a una cuenta.
    Then I take screenshot: Feature_0003

  @test
  Scenario: Take a ScreenShot
    Given I am in App main site
    And I attach a Screenshot to Report