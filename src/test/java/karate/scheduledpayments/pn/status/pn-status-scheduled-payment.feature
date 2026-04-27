Feature: Consulta de estado por paymentId – Persona Natural (PN)

  Background:
    * url baseUrl
    * def basePath = '/scheduled-payments/v1/PN/scheduled-payments/'
    * def validPaymentId = 'PAY-20250001'
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
    # Note: depends on actual mock/data
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
