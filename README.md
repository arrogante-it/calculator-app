# Calculator Application

##### Calculator for basic operation +/*-.
 
##### Code is covered with unit tests with JUnit. 

## Install application:
- Clone application to your directory:
`git clone https://github.com/arrogante-it/calculator-app.git`

- Build project: `mvn clean install`

- Run application with command: `mvn spring-boot:run`

## Prerequisite:
- JDK 11 or higher
- Maven 4.0.0 or higher

## Program main functional:
- #### add: `/api/v1/calculator/add`
     ###### example: `/api/v1/calculator/addnumber1=6&number2=3`

- #### subtract: `/api/v1/calculator/subtract`
    ###### example: `/api/v1/calculator/subtract?number1=6&number2=3`

- #### multiply: `/api/v1/calculator/multiply`
    ###### example: `/api/v1/calculator/multiply?number1=6&number2=3`

- #### divide: `/api/v1/calculator/divide`
    ###### example: `/api/v1/calculator/divide?number1=6&number2=3`