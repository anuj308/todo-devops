# To-Do List Application – DevOps Project

This is a simple Java-based To-Do List application created to demonstrate basic DevOps concepts such as version control, build automation, and continuous integration.

## Technologies Used
- Java 11
- Maven
- Git & GitHub
- GitHub Actions (CI)
- JUnit 5
- Java Swing (UI)

## Features
- Add tasks
- Remove tasks
- View task list
- Simple graphical user interface
- Automated build and test using CI

## How to Run Locally

1. Build the project:
```bash
mvn clean package
```

2. Run the application using Maven (choose one method):

   **Method A: Run main class directly (no JAR needed):**
   ```bash
   mvn exec:java -Dexec.mainClass="com.example.todo.Main"
   ```

   **Method B: Run the packaged JAR using Maven:**
   ```bash
   mvn exec:exec -Dexec.executable="java" -Dexec.args="-jar target/todo-devops-project-1.0.0.jar"
   ```

   **Method C: Run JAR without Maven (traditional approach):**
   ```bash
   java -jar target/todo-devops-project-1.0.0.jar
   ```

## How to Run Tests
```bash
mvn test
```

## Project Structure & Maven Configuration

### Understanding pom.xml
The `pom.xml` (Project Object Model) is Maven's core configuration file that defines project metadata, dependencies, and build configurations.

#### Key Components:

**1. Project Coordinates:**
```xml
<groupId>com.example</groupId>
<artifactId>todo-devops-project</artifactId>
<version>1.0.0</version>
```
- `groupId`: Uniquely identifies your organization/project group
- `artifactId`: Name of the project/module
- `version`: Current version of the project

**2. Properties:**
```xml
<maven.compiler.source>11</maven.compiler.source>
<maven.compiler.target>11</maven.compiler.target>
```
- Specifies Java 11 as both source and target version
- Ensures compatibility across different environments

**3. Dependencies:**

**JUnit 5 (junit-jupiter 5.9.3):**
- Purpose: Unit testing framework
- Scope: `test` (only available during test compilation and execution)
- Used for writing and running automated tests
- Modern successor to JUnit 4 with improved features

**4. Build Plugins:**

**Maven Compiler Plugin (3.11.0):**
- Compiles Java source code
- Configured to use Java 11

**Maven Surefire Plugin (3.0.0):**
- Executes unit tests during the build lifecycle
- Runs tests in the `src/test/java` directory
- Generates test reports in `target/surefire-reports/`

**Maven Shade Plugin (3.4.1):**
- Creates an executable "uber-jar" (fat jar) with all dependencies
- Configures the Main class (`com.example.todo.Main`) in the JAR manifest
- Allows running the application with `java -jar` command

### Different Ways to Run with Maven

**`mvn exec:java`** (Method A):
- Runs the main class directly from compiled classes
- No JAR file needed
- Faster for development (skips packaging step)
- Uses Maven exec plugin's `java` goal

**`mvn exec:exec`** (Method B):
- Executes external programs (in this case, `java -jar`)
- Runs the packaged JAR through Maven
- Everything managed by Maven
- Useful for consistent execution across environments

**Direct `java -jar`** (Method C):
- Standard Java execution without Maven
- Requires JAR to be already built
- Doesn't leverage Maven's execution framework

### Why Use Maven?

1. **Dependency Management**: Automatically downloads and manages libraries
2. **Standardized Build**: Consistent build process across different environments
3. **Project Structure**: Enforces standard directory layout
4. **Build Lifecycle**: Provides standard phases (compile, test, package, install)
5. **Plugin Ecosystem**: Extensible with thousands of available plugins
6. **CI/CD Integration**: Easy integration with CI/CD pipelines
7. **Consistent Execution**: Maven commands work the same across all platforms

## Continuous Integration
GitHub Actions is used to automatically build and test the project on every push or pull request.

## Purpose
This project is developed for academic learning to understand Maven, Git, and Continuous Integration in DevOps.

## Author
Anuj Kumar Sharma
