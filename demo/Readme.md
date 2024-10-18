# **Design RESTful API for Task Management System**

### **Objectives:**

You need to implement an API for managing tasks, with the following features:
* Users can create, update, delete, and view tasks.
* Each task has a title, description, dueDate, and status (e.g., Pending, In Progress, Completed).
* Users should be able to mark tasks as completed.
* Users should be able to filter tasks by their status.


### **Initial Setup:**

Generate basic spring boot application from Spring Initializer

- Select Maven, JAR and versions for Spring Boot and Java
- Select required starter dependencies - Web, Data JPA, MySQL JDBC Driver, Lombok
- Generate spring boot application and extract it
- Open spring boot application in IntelliJ/Eclipse IDE

### **Configurations:**

Add required configurations for mysql connectivity in application.properties file

- URL
- Username
- Password
- DDL Auto (if set to update, updates existing schema with changes)

### **Package Structure:**

**Base Package** - com.task.demo \
**Controller** - com.task.demo.controller (where we define REST endpoints)\
**Service** - com.task.demo.service (where we write business logic) \
**Repository** - com.task.demo.repository (where we can write queries by accessing db) \
**Entity** - com.task.demo.entity (where we define models/table structure that needs to be created by JPA) \
**DTO** - com.task.demo.dto (where we define fields that should be displayed to client - for decoupling schema changes with entity) \
**Mapper** - com.task.demo.mapper (where we write methods to map DTO to Entity and viceversa)

### **Application Flow:**

- Spring container starts execution from main method where we have @SpringBootApplication annotation which is a combination of @ComponentScan, @EnableAutoConfiguration and @Configuration
- It scans all files that are annotated as components (in this app, @Service, @RestController, @Repository) from base package (set as default to the main method package)
- For create task, first it goes to controller where we have API endpoint defined
- Using constructor injection, task service is injected in controller using which we call required service method
- Task Repository is also injected similarly using constructor injection in service component which interacts with repository for saving task
- Result from repository flows back from service to controller and gives response back to client with corresponding HTTP status codes













    