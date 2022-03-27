Feature: Loguearse en una cuenta
  Yo como usuario registrado en la página web Automation Practice
  Quiero poder acceder a mi cuenta
  Para interactuar con los servicios ofrecidos en la página web

  Background:
    Given el cliente se encuentra en el Home del sitio Web de Automation Practice
    When el cliente entra en la seccion Sign in del sitio Web

  Scenario: Como cliente proporciono la informacion necesaria para poder ingresar a mi cuenta
    When  el cliente ingresa sus datos personales y clickea el boton Sign in
    Then  debera aparecer la seccion MY ACCOUNT del usuario logueado

  Scenario: Como cliente proporciono la contrasena sin un correo
    When  el cliente ingresa un password sin ingresar el campo email y clickea en Sign in
    Then  recibira un mensaje de error indicando que se requiere el campo email