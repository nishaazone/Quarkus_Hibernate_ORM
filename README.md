# Quarkus Hibernate ORM
Implementation of Quarkus-Hibernate-ORM by creatiing REST Endpoints and POSTGRES database.

# How to run-
## Here i am using a docker image of POSTGRES database
 * Step-1: Install a Docker Desktop
 Step-2: Go to https://code.quarkus.io/ create a new quarkus project and choose necessary dependencies for your project.
    ** Dependencies to be added in POM.xml
       ****1) Rest Easy Classic
       ****2) Rest Easy Classic Jackson
       ****3) Quarkus hibernate orm panache
       ****4) Quarkus jdbc postgresql
 * Step-3: Extract the files and open the project in IDE.
 * Step-4: Create Rest Endpoints for basic CRUD operations.
 * Step-5: Add following properties in application.properties file.
 ***quarkus.datasource.jdbc.url=jdbc:postgresql://localhost:5432/my_db_movie 
 ***quarkus.datasource.username=username 
 ***quarkus.datasource.password=password 
 ***quarkus.datasource.db-kind=postgresql 
 ***quarkus.hibernate-orm.database.generation=drop-and-create 
 * Step-6: Open the docker desktop application.
 * Step-7: Open a private command prompt for your project and type in the following docker command-
 ***docker run --name my_db_movie -e POSTGRES_USER=username -e POSTGRES_PASSWORD=password -e POSTGRES_DB=my_db_movie -p 5432:5432 postgres:12.0 
 * Step-8: Open a new private command prompt for your project and type in the following maven command- mvn quarkus:dev
 * Step-9 Run the application in postman.
 ## If you want to see the database you can use DBeaver.
