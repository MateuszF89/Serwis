# Serwis
Projekt Końcowy

# Project description
In general, it is a Spring Boot project using SQL database
The application was made as the final project of the Java Developer course at the IT Coders Lab school.
The application can be used to support the operation of compressor service or other type of service and has been developed on the basis of real data.
The application has the following functionalities:
- The ability to add, delete and edit parts in the warehouse.
- Monitoring of available parts in the warehouse and generating notifications about low inventory.
- History of all parts movements in the warehouse, including receipts and releases.
- Add and edit workers.
- List of employees.
- Planning the work of employees.
- List of employees.
- Add and edit clients.
- Customer list.
- The ability to add and edit customer-owned devices.
- Add or remove a service order list.
- List of service orders.
- Service planning with employee designation.
- Creating a protocol of the service performed.
- List of protocols.
- Details of the protocol.
- Generate a protocol in PDF using an external API.

## Technical Requirements
- Java (version 17)
- Maven 
- Spring Boot Project (https://github.com/MateuszF89/Serwis.git)
- SQL database (MySQL)

## Installation
1. Download a project
   Download the project from this repository using the git command:
   git clone https://github.com/MateuszF89/Serwis.git
   
2. Building a project
   Go to the project directory and use a build tool like Maven or Gradle to build the project. For Maven do:
   mvn install
   
3. Database configuration
   This project uses a SQL database. Make sure you have access to the database, and then configure the database connection in the 'application.properties       file. Example of database configuration in the file 'application.properties:
   spring.datasource.url=jdbc:mysql://localhost:3306/database_name?serverTimezone=Europe/Warsaw
  spring.datasource.username=your_username
  spring.datasource.password=your_password
  spring.jpa.hibernate.ddl-auto=update
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  spring.mvc.view.prefix=/WEB-INF/views/
  spring.mvc.view.suffix=.jsp
  spring.web.locale=pl_PL
  spring.web.locale-resolver=fixed
    
4. Launch the application
   Now you can launch the Spring Boot application with the command:
   mvn spring-boot:run
   
5. Testing the application
   Open a web browser and go to:
   http://localhost:8080/dashboard/

## Contact
email: mateusz.fortuna89@gmail.com




