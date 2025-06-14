# Vendor Management System Application
This project is a REST API for a Vendor Management System. The API allows users to manage vendors and their information. Users can create new vendors, retrieve vendor details, update vendor information, and delete vendors.

- Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Swagger UI
- Maven
# Endpoints
- POST /vendors: Create a new vendor by sending a POST request to this endpoint. The request body should include the vendor details such as name, contact information, and address.

- GET /vendors/{id}: Retrieve the details of a specific vendor by sending a GET request to this endpoint. This endpoint requires the vendor ID as a path parameter.

- PUT /vendors/{id}: Update the information of a specific vendor by sending a PUT request to this endpoint. This endpoint requires the vendor ID as a path parameter and the updated vendor details in the request body.

- DELETE /vendors/{id}: Delete a specific vendor by sending a DELETE request to this endpoint. This endpoint requires the vendor ID as a path parameter.

# Validation
- This project uses validation annotations to ensure that user input is in the correct format. The following validations are implemented:

- Vendor Name: Must not be empty or exceed a certain character limit.

- Contact Information: Must be a valid phone number or email address.

- Address: Must not be empty or exceed a certain character limit.

# Exception Handling
- Custom exceptions are used for handling errors in the application. A global exception handler is used to handle exceptions globally.

# Authentication
- This project does not implement authentication as it focuses on the functionality of the Vendor Management System. However, you can incorporate authentication mechanisms according to your specific requirements.


# Installation & Run
 - Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database configuration.

```server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/StudentDB;
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root

```


# API Root Endpoint
```
https://localhost:8080/
```
```
http://localhost:8080/swagger-ui/
```
