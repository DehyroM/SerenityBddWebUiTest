Feature: Contacto con el Cliente
  Yo como interesado en los productos que ofrece la pagina web Automation Practice
  Quiero poder contactarme con la empresa de forma virtual
  Para recibir información útil sobre sus productos y servicios

  Background:
    Given el cliente se encuentra en el Home del sitio Web de Automation Practice
    When el cliente entra en la seccion Contact Us del sitio Web de Automation Practice

  Scenario: Como cliente proporciono la informacion necesaria para que me puedan responder
    When  el cliente ingresa la informacion de contacto requerida y clickea el boton Send
    Then  recibira un mensaje de confirmacion por diligenciar la peticion

  Scenario: Como cliente proporciono datos de contacto sin la informacion de correo electronico
    When  el cliente ingresa una informacion de contacto pero sin ingresar el email y clickea el boton Send
    Then  recibira un mensaje de error indicando que se requiere el email para enviar la peticion