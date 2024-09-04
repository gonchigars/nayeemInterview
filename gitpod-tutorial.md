### Complete `pom.xml` File

This `pom.xml` is configured to use Java 11, includes necessary dependencies for a Spring Boot Movie API application, and is set up for easy building and running in a Gitpod environment.

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://www.apache.org/maven-v4_0_0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>movie-api</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>jar</packaging>

    <name>movie-api</name>
    <description>Spring Boot Movie API</description>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.7.12</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <properties>
        <java.version>11</java.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Starter Web -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- Spring Data JPA for persistence -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

        <!-- H2 Database -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Spring Boot Starter Test (for testing) -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.10.1</version>
                <configuration>
                    <source>11</source>
                    <target>11</target>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>
```

### Step-by-Step Tutorial

This tutorial is designed to help students who are using Gitpod and Spring Boot for the first time. It includes instructions for starting a Gitpod workspace, checking out a specific branch, building, running the application, and testing with Postman.

#### Step 1: Start with Gitpod

1. **Open the GitHub Repository in Gitpod:**
   - Go to the GitHub repository URL in your browser.
   - Prepend `https://gitpod.io/#` to the repository URL. For example:
     ```
     https://gitpod.io/#https://github.com/username/repository
     ```
   - Press Enter. This will open the repository in a Gitpod workspace.

#### Step 2: Checkout a Specific Branch

1. **Open the Terminal in Gitpod:**
   - In Gitpod, you’ll see a terminal window at the bottom of the screen.

2. **List Available Branches:**
   - You can list all branches by running:
     ```bash
     git branch -a
     ```

3. **Checkout the Desired Branch:**
   - To switch to a specific branch, such as `sql-2-jpa`, run:
     ```bash
     git checkout sql-2-jpa
     ```
   - If this branch is remote and not yet checked out locally, this command will also set up tracking.

#### Step 3: Grant Execute Permissions to the Maven Wrapper

1. **Make `mvnw` Executable:**
   - Before you can use the Maven wrapper, make sure it’s executable:
     ```bash
     chmod +x ./mvnw
     ```

#### Step 4: Build the Project

1. **Clean and Install the Project:**
   - Run the following command to clean and install the project dependencies:
     ```bash
     ./mvnw clean install
     ```

   - This command will compile your project, run tests, and package the application.

#### Step 5: Run the Spring Boot Application

1. **Start the Spring Boot Application:**
   - Use the Maven wrapper to run the application:
     ```bash
     ./mvnw spring-boot:run
     ```

   - This will start the embedded Tomcat server on port 8080.

#### Step 6: Find the Application URL

1. **Open the Ports Tab in Gitpod:**
   - Once the application is running, look for the "Ports" tab at the bottom of the Gitpod interface.

2. **Find Port 8080:**
   - Gitpod will list the ports that your application is using. Look for port `8080`.

3. **Open the Application in a Browser:**
   - Click on "Open Browser" next to port 8080. This will open your application in a new browser tab.
   - The URL will look something like this:
     ```
     https://8080-<your-gitpod-workspace-id>.ws-us83.gitpod.io/
     ```

#### Step 7: Test with Postman

1. **Open Postman:**
   - Use Postman to send HTTP requests to your running application.

2. **Create a New Request:**
   - Set the request method (GET, POST, etc.) depending on the endpoint you want to test.
   - Enter the URL of your running application, for example:
     ```
     https://8080-<your-gitpod-workspace-id>.ws-us83.gitpod.io/api/movies/popular
     ```

3. **Send the Request:**
   - Click "Send" to execute the request and view the response.

4. **Review the Response:**
   - The response from your API will appear in the lower section of the Postman interface. Ensure that it matches the expected output.

### Summary

- **Gitpod Setup:** Learn how to start a Gitpod workspace and checkout a specific branch.
- **Maven Wrapper:** Make the `mvnw` script executable and use it to build and run your project.
- **Find Application URL:** Use the Ports tab in Gitpod to find the URL for your running application.
- **Postman Testing:** Use Postman to send HTTP requests to your Spring Boot application and verify the responses.
