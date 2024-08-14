### README.md

# GitHub Repository Details Service

## Overview
This project is a simple REST service developed in Java (version 21) using the Spring Framework. The service fetches details of a specified GitHub repository and caches the response in a database. The details include:
- Full name of the repository
- Description of the repository
- Git clone URL
- Number of stars
- Date of creation

## API Endpoint

### GET `/repositories/{owner}/{repositoryName}`

**Response:**
```json
{
   "full_name": "PramodHasitha/git-repo-details",
   "description": "Sprint boot project to get git repo details by owner",
   "clone_url": "https://github.com/PramodHasitha/git-repo-details.git",
   "stargazers_count": 0,
   "created_at": "2024-08-13T14:38:02"
}
```

## Project Structure

- **common**: Contains constants class and enums which are common for all.
- **config**: Configuration classes for caching and other settings.
- **controller**: Contains REST controller classes to handle HTTP requests.
- **dto**: Contains Data Transfer Objects (DTO) for transferring data between layers.
- **exception**: Handles custom exceptions and error responses.
- **model**: Holds entity classes representing database tables.
- **repository**: Manages the database interactions using JPA.
- **config**: Configuration classes for caching and other settings.
- **service**: Contains the service layer where business logic is implemented.

## How to Run

### Prerequisites
- Java 21
- Maven
- Git

### Steps

1. **Clone the repository:**
   ```bash
   git clone git@github.com:PramodHasitha/git-repo-details.git
   cd git-repo-details
   ```

2. **Build the project:**
   ```bash
   mvn clean install
   ```

3. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the API:**
   Use a tool like `curl` or Postman to send requests to the service.
   Example:
   ```bash
   curl http://localhost:9090/repositories/PramodHasitha/git-repo-details
   ```

### Database Configuration
The application uses an embedded H2 database for caching repository details. This is configured to be simple for testing. For production, you can configure it to use any other relational database supported by Spring Data JPA.

### Caching
The application uses Spring Cache for caching repository details in memory. The cache is configured to persist data using the database.

## Error Handling

The service includes custom error handling to manage various exceptions that may occur:

1. **GitHub API Errors:**
    - If the GitHub API fails (e.g., repository not found, Failed to get details), a user-friendly error message is returned.


### Example Error Response:
```json
{
   "timestamp": "2024-08-14T10:00:03.9468",
   "errorMessage": "Unable to find repository",
   "error": "Not Found",
   "path": "/repositories/PramodHasitha/git-repo-details1",
   "status": 404
}
```

## Testing

To run the tests, execute the following command:
```bash
mvn test
```

The project includes unit tests for the service layer and integration tests for the API endpoints. The tests are written using JUnit and MockMvc.

## Deployment

For deployment, you can package the application as a JAR file and deploy it on any Java-compatible cloud service or on-premise server.

```bash
mvn package
java -jar target/git-repo-details-0.0.1-SNAPSHOT.jar
```

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -am 'Add new feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Create a new Pull Request.

---
