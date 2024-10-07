# Bill Microservice

This microservice is responsible for listening to the **quotation**, **patient**, and **payment** microservices, storing their events in order to provide the user with a formatted view of the relevant invoice information. This information is delivered in two ways: via a POST request and as a PDF.

## Table of Contents
- [Installation](#installation)
- [Examples](#Examples)
- [JavaDocs](#Documentation)
- [License](#license)

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/Deskech/isadent-Billing-microservice/
## Prerequisites
- **Java 17**
- **Maven**
- **RabbitMQ**
- **MySQL**
## Examples
In order get the patient's bill we only need the patient's name such like this:
```http
POST /bill

Content-Type: application/json
```
```json
{
  "patientName": "John Doe"
}
```
### Outcome
```json
{
"remainingPaymentCurrency": "$729,300.00",
"paymentCurrency": "$700.00",
"totalCurrency": "$730,000.00",
"patientName": "John Doe",
"patientIdentification": "22222222",
"dentalProcedures": "[{\"dentalProcedure\":\"PROVISIONAL\",\"price\":180000.0},{\"dentalProcedure\":\"NUCLEO\",\"price\":550000.0}]"
}
```

## Documentation
## License
