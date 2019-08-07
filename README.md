# crm_rest_api_demo
A demonstration of Customer Relationship Management web appliction.

This application was developed with Spring Boot, Spring Data JPA, Spring REST, Jackson, JSP, Servlet and MySQL.

It includs two parts, API part and Client part.

For API part, it uses Spring REST to create APIs. There is also a service layer set between the RestController and DAO. Used Spring Data JPA to perfrom database operations.

For Client part. Used Jackson to parse JSON data into POJO. Used Spring MVC and Thymeleaf to design the presentation layer. 

Customers are stored in MySQL database. Database creation scripts and data insert scripts can be found at Resource folder.

Used Get, POST, PUT and DELETE HTTP request to perform basic CRUD operations.

Mapped http://localhost:8080/api/customers to list all customers and http://localhost:8080/api/customers/{customerID} to list certain customers.

Save operation is restricted within POST request and update operation is restricted with PUT request.

Mapped http://localhost:8080/api/customers?theID=customerID with @DeleteMapping to implement delete operation.
