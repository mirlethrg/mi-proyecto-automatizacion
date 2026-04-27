Feature: Creación Pago Único Programado – Persona Natural (PN)

  Background:
    * url baseUrl
    * def basePath = '/scheduled-payments/v1/PN/scheduled-payments'
    * def basePayload = read('pn-request-base.json')
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
  Scenario Outline: Creación de orden de pago programada para Persona Natural (PN) - <desc>
    * def reqPayload = basePayload
    * set reqPayload.paymentsRequest.data.payments[0].debtorIdentification = rut
    * set reqPayload.paymentsRequest.data.payments[0].debtorAccountType = accType
    
    Given path basePath
    And headers headersValues
    And request reqPayload
    When method post
    Then status 201
    And match response.data != null

    Examples:
      | desc                                    | rut            | accType  |
      | Normal request                          | "12.345.678-9" | CHECKING |
      | debtorIdentification con Letra K        | "12.345.678-K" | CHECKING |
      | debtorAccountType SIGHT                 | "12.345.678-9" | SIGHT    |
      | debtorAccountType PREPAID               | "12.345.678-9" | PREPAID  |

  # Casos funcionales negativos y de validación
  Scenario Outline: Validaciones funcionales negativas y estructurales PN - <desc>
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
      | transactionType incorrecto                           | set reqPayload.paymentsRequest.data.payments[0].transactionType = "WRONG_TYPE"                      | 400            |
      | debtorInstitutionId inexistente                      | set reqPayload.paymentsRequest.data.payments[0].debtorInstitutionId = "9999"                        | 422            |
      | creditorIdentification incorrecta                    | set reqPayload.paymentsRequest.data.payments[0].creditorIdentification = "invalid"                  | 400            |
      | amount igual a 0                                     | set reqPayload.paymentsRequest.data.payments[0].amount = 0                                          | 422            |
      | amount igual a -100                                  | set reqPayload.paymentsRequest.data.payments[0].amount = -100                                       | 422            |
      | currency distinto de CLP                             | set reqPayload.paymentsRequest.data.payments[0].currency = "USD"                                    | 400            |
      | requestedExecutionDateTime fecha pasada              | set reqPayload.paymentsRequest.data.payments[0].requestedExecutionDateTime = "2020-01-01T10:00:00Z" | 422            |
      | Objeto raíz faltante (paymentsRequest vacio)         | set reqPayload = {}                                                                                 | 400            |
      | Array payments vacío                                 | set reqPayload.paymentsRequest.data.payments = []                                                   | 400            |
      | Amount decimal invalido o no numérico                | set reqPayload.paymentsRequest.data.payments[0].amount = "45000"                                    | 400            |
      | CreditorAccountType fuera de permitidos              | set reqPayload.paymentsRequest.data.payments[0].creditorAccountType = "OTHER"                       | 400            |
      | SQL Injection en Identification                      | set reqPayload.paymentsRequest.data.payments[0].debtorIdentification = "1=1; DROP TABLE users;"     | 400            |

  Scenario: Unsupported Content-Type retorna error
    * def reqPayload = basePayload
    
    Given path basePath
    And header x-fapi-interaction-id = 'b1234567-89ab-cdef-0123-456789abcdef'
    And header x-jws-signature = 'dummy'
    And header x-idempotency-key = 'idemp-123456'
    And header Content-Type = 'application/xml'
    And request '<xml>not json</xml>'
    When method post
    Then status 415
