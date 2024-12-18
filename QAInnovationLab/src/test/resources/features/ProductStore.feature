@TestExam
Feature: Automatización de pruebas para la tienda en línea
  Para garantizar la estabilidad de la tienda en línea
  Como automatizador principal
  Necesito validar diferentes escenarios en la tienda


  Scenario: Inicio de sesión exitoso con credenciales válidas
    Given que estoy en la página de inicio de sesión
    When ingreso el usuario "jesusmqp@gmail.com" y la contraseña "12345678910Ab.cd"
    Then debería ver la página principal de la tienda

@TestExamdos
  Scenario: Inicio de sesión fallido con credenciales inválidas
    Given que estoy en la página de inicio de sesiónDos
    When ingreso el usuario "invalid_user@gmail.com" y la contraseñaDos "wrongpassword"
    Then debería ver un mensaje de error indicando fallo en la autenticación

@TestExamtres
  Scenario: Navegación a una categoría inexistente
    Given que estoy en la página de inicio de sesiónTres
    When ingreso el usuario "jesusmqp@gmail.com" y la contraseñaTres "12345678910Ab.cd"
    And navego a la categoría "Autos"
    Then debería ver un mensaje indicando que la categoría no existe
