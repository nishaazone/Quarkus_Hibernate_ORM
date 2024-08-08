# Quarkus Hibernate ORM Implementation

This guide will help you set up a Quarkus application with Hibernate ORM, creating REST endpoints and using a PostgreSQL database.

## Prerequisites
1. **Docker Desktop**: Install Docker Desktop to run the PostgreSQL database.
2. **IDE**: Use an Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse.

## Step-by-Step Guide

### Step 1: Create a New Quarkus Project
1. Go to [Quarkus Code Generator](https://code.quarkus.io/).
2. Choose the necessary dependencies for your project:
   - **RESTEasy Classic**
   - **RESTEasy Classic Jackson**
   - **Quarkus Hibernate ORM Panache**
   - **Quarkus JDBC Postgres**

### Step 2: Extract and Open the Project in Your IDE
- Extract the generated project files.
- Open the project in your preferred IDE.

### Step 3: Create REST Endpoints for CRUD Operations
Create REST endpoints for basic CRUD operations (Create, Read, Update, Delete).

### Step 4: Configure `application.properties`
Add the following properties to `src/main/resources/application.properties`:

```properties
quarkus.datasource.jdbc.url=jdbc:postgresql://localhost:5432/my_db_movie
quarkus.datasource.username=username
quarkus.datasource.password=password
quarkus.datasource.db-kind=postgresql
quarkus.hibernate-orm.database.generation=drop-and-create
