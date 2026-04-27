Feature: Creación Pago Único Programado – Persona Jurídica (PJ)

  Background:
    * url baseUrl
    * def basePath = '/scheduled-payments/v1/PJ/scheduled-payments'
    * def basePayload = read('pj-request-base.json')
    * def headersValues =
    """
    {
      'x-fapi-interaction-id': 'b1234567-89ab-cdef-0123-456789abcdef',
      'x-jws-signature': 'eyhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.dummy',
      'x-idempotency-key': 'idemp-123456',
      'Content-Type': 'application/json'
    }
    """

  # Casos funcionales positivos
  Scenario Outline: Creación de orden de pago programada para Persona Jurídica (PJ) - <desc>
    * def reqPayload = basePayload
    * set reqPayload.paymentsRequest.data.payments[0].debtorRepresentativeRole = role
    * set reqPayload.paymentsRequest.data.payments[0].debtorRepresentativeId = repId
    
    Given path basePath
    And headers headersValues
    And request reqPayload
    When method post
    Then status 201
    And match response.data != null

    Examples:
      | desc                                              | role       | repId          |
      | Normal request PJ con rol Apoderado               | "APODERADO"| "9.876.543-2"  |
      | debtorRepresentativeId con Letra K                | "GERENTE"  | "9.876.543-K"  |
      | Consulta con rol GERENTE                          | "GERENTE"  | "9.876.543-2"  |
      | Consulta con rol FIRMA A                          | "FIRMA_A"  | "9.876.543-2"  |

  # Casos funcionales negativos y de validación
  Scenario Outline: Validaciones funcionales negativas y estructurales PJ - <desc>
    * def reqPayload = basePayload
    * <mutator>
    
    Given path basePath
    And headers headersValues
    And request reqPayload
    When method post
    Then status <expectedStatus>

    Examples:
      | desc                                                 | mutator                                                                                             | expectedStatus |
      | grantId incorrecto (UUID no valido)                  | set reqPayload.paymentsRequest.data.payments[0].grantId = "invalid-grantId"                         | 400            |
      | debtorInstitutionId inexistente                      | set reqPayload.paymentsRequest.data.payments[0].debtorInstitutionId = "9999"                        | 422            |
      | Petición omitiendo debtorAccountNumber               | remove reqPayload.paymentsRequest.data.payments[0].debtorAccountNumber                              | 400            |
      | debtorRepresentativeRole incorrecto                  | set reqPayload.paymentsRequest.data.payments[0].debtorRepresentativeRole = "INVALIDO"               | 400            |
      | amount igual a 0                                     | set reqPayload.paymentsRequest.data.payments[0].amount = 0                                          | 422            |
      | currency distinto de CLP                             | set reqPayload.paymentsRequest.data.payments[0].currency = "USD"                                    | 400            |
      | requestedExecutionDateTime fecha pasada              | set reqPayload.paymentsRequest.data.payments[0].requestedExecutionDateTime = "2020-01-01T10:00:00Z" | 422            |
      | Multiple pagos - Envio de 2 en arreglo               | set reqPayload.paymentsRequest.data.payments[1] = reqPayload.paymentsRequest.data.payments[0]       | 422            |
      | Payload syntax malformed (Simulado vacio)            | set reqPayload = ""                                                                                 | 400            |
