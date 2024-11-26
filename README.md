Banking Application

Overview

This is a Banking Application developed using Java and Spring Boot. It offers core banking functionalities such as managing accounts and processing transactions. The application is built with a clean architecture, leveraging the power of Spring Boot for dependency injection, data persistence, and RESTful APIs.

Features

Account Management:
 Add new accounts.
 Retrieve account details by ID.
 Delete all accounts.
Transaction Processing:
 Deposit and withdraw funds.
 Retrieve a log of transaction history.
Exception Handling:
 Graceful handling of invalid inputs and missing resources.
 Custom error responses for clarity.

Tech Stack

 Backend: Java, Spring Boot, Spring Data JPA
 Database: MySQL 
 Build Tool: Maven 

API Endpoints

Accounts:
 POST /accounts: Add a new account.
 GET /{id}: Retrieve account details by ID.
 PUT /{id}: Updates
 DELETE /{id}: Delete all accounts.
Transactions:
 POST /{id}/deposit: Deposit funds into an account.
 POST /{id}/withdraw: Withdraw funds from an account.
 GET /{id}/transactions: Retrieve a log of transaction history.

Exception Handling

 Resource Not Found:
 Returns a 404 Not Found status with a custom error message if an account or transaction is missing.
 Global Error Handling:
 Centralized exception handling using @ControllerAdvice for consistent error responses.

Future Enhancements

 Add account statement generation.
 
 
