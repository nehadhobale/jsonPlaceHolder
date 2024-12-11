# jsonPlaceHolder
This project automates the functional API testing of the JSONPlaceholder REST API using Java, TestNG, and RestAssured. The tests verify API functionality, including retrieving user email address, validating user posts, and creating posts.

## Setup Instruction
1. Clone the Repository: 
````
git clone https://github.com/nehadhobale/jsonPlaceHolder.git
cd jsonPlaceHolder
````
2. Configure Environment:
- Edit the src/test/resources/test-env.properties file to configure the API endpoints for users and posts.
3. Dependencies:
- Maven automatically resolves dependencies from pom.xml. To install them, run:
````
mvn clean install
````
## Running Test
1. Via TestNG.xml :- Right click on TestNG.xml file and then click on run.
2. From Test Classes:- Right click on Test class file and then click on run.
3. Command Line :- To execute tests directly via Maven, run:
````
mvn test -Denv=test 
````
## Reports and Logs
1. Test Reports:-
TestNG generates reports in the target/surefire-reports directory after execution.
2. Logs:-
Log files with detailed execution steps are generated using Log4j2.

## Approach to Automation Pipeline
This project adopts a modular and scalable approach for API test automation.
1. Folder Structure:- Clear separation between test cases, utilities, and resources ensures maintainability.
2. Data-Driven Testing:- Test data is externalized in CSV and JSON files to allow flexibility and reuse.
3. Execution Options:- Tests can be executed through TestNG XML, Java classes, or Maven.
4. Validation:- Validates API responses using assertions to ensure data integrity and functionality.
5. CI/CD Integration:- Can be included in any run via maven
6. Test Execution :- Regression Tests
7. Stage in the Automation Pipeline:- Can be run test in different env.
8. Scalability for Future Integration:- Utilize the same framework for different environments by modifying configuration files. 
   Add new test cases for APIs without restructuring the project.

## References
1. [JSONPlaceholder API Documentation](https://jsonplaceholder.typicode.com/)
2. [TestNG Documentation](https://testng.org/doc/)
3. [RestAssured Documentation](https://rest-assured.io/)
4. [Maven Surefire Plugin](https://maven.apache.org/surefire/maven-surefire-plugin/)
