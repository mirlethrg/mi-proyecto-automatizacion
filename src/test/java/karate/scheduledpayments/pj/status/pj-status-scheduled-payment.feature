Feature: Consulta de estado por paymentId – Persona Jurídica (PJ)

  Background:
    * url baseUrl
    * def basePath = '/scheduled-payments/v1/PJ/scheduled-payments/'
    * def validPaymentId = 'a123bcde-45f6-7890-gh12-ijklmnopq345'
    * def headersValues =
    """
    {
      'x-fapi-interaction-id': 'b1234567-89ab-cdef-0123-456789abcdef',
      'Authorization': 'Bearer valid-token-example'
    }
    """

  Scenario: Ejecutar Petición para obtener estado por paymentId positivo
    Given path basePath + validPaymentId
    And headers headersValues
    When method get
    # Depende del mock activo
    Then status 200
    And match response.data != null

  Scenario Outline: Validaciones negativas del Path Parameter (paymentId) - <desc>
    Given path basePath + paymentId
    And headers headersValues
    When method get
    Then status <expectedStatus>

    Examples:
      | desc                                      | paymentId                              | expectedStatus |
      | Formato UUID inválido                     | "123-abc-456"                          | 400            |
      | Símbolos especiales en paymentId          | "paymentId!@#"                         | 400            |
      | ID no existente en la BD (Error 404)      | "11111111-2222-3333-4444-555555555555" | 404            |

  Scenario: Intento de consulta sin enviar credenciales
    Given path basePath + validPaymentId
    And header x-fapi-interaction-id = 'b1234567-89ab-cdef-0123-456789abcdef'
    When method get
    Then status 401

  Scenario: Consulta de un paymentId de Persona Natural (PN) utilizando el endpoint de PJ
    * def pnPaymentId = 'c123bcde-99f6-7890-gh12-ijklmnopq999'
    Given path basePath + pnPaymentId
    And headers headersValues
    When method get
    # Dependiendo de la implementación, podría devolver 404 o 403.
    Then match responseStatus == 404 || responseStatus == 403
