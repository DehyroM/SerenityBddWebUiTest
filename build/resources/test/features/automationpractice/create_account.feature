Feature: Crear una cuenta
  Yo como interesado en los productos que ofrece la página web Automation Practice
  Quiero poder crear una cuenta en su página Web
  Para interactuar con los servicios ofrecidos en la página web

  Background:
    Given el cliente se encuentra en el Home del sitio Web de Automation Practice
    When el cliente entra en la seccion Sign in del sitio Web, ingresa un correo y clickea en Create an account

  Scenario: Como cliente proporciono la informacion necesaria para poder crear una cuenta
    When  el cliente ingresa sus datos personales y clickea el boton Register
    Then  recibira un mensaje de confirmacion exitoso

  Scenario: Como cliente proporciono datos de contacto sin llenar el campo password
    When  el cliente ingresa sus datos personales sin ingresar el campo password y clickea en Register
    Then  recibira un mensaje de error indicando que se requiere el campo de password