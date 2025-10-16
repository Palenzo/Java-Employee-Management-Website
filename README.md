# Employee Management System

A modern REST API for employee management built with **Spring Boot 3.2.12** and **Java 21**.

## 🚀 Features

- **Full CRUD Operations** - Create, Read, Update, Delete employees
- **Input Validation** - Jakarta Bean Validation with detailed error messages
- **Filter by Status** - Query employees by their status
- **Global Exception Handling** - Structured error responses
- **MySQL Database** - JPA/Hibernate with auto-schema generation
- **CORS Support** - Configured for cross-origin requests
- **Hot Reload** - Spring Boot DevTools for development

## 📋 Tech Stack

| Technology | Version |
|------------|---------|
| **Java** | 21 (LTS) |
| **Spring Boot** | 3.2.12 |
| **Jakarta EE** | 3.x |
| **Hibernate** | 6.4.10 |
| **MySQL** | 8.x |
| **Maven** | 3.9.x |

## 🎯 Recent Upgrades

This project was recently upgraded from Java 17 to Java 21 with the following improvements:

✅ **Java 21 LTS** - Latest long-term support version  
✅ **Spring Boot 3.2.12** - Modern Spring Framework 6.x  
✅ **Jakarta EE Migration** - Migrated from `javax.*` to `jakarta.*`  
✅ **Enhanced Validation** - Bean validation with `@Valid` and `@NonNull`  
✅ **Improved Error Handling** - Global exception handler with structured responses  
✅ **Type Safety** - LocalDate for dates, wrapper types for optional fields  
✅ **Better REST API** - ResponseEntity with proper HTTP status codes  

## 🛠️ Prerequisites

Before running this application, ensure you have:

- **JDK 21** or later installed
- **MySQL 8.x** running on `localhost:3306`
- **Maven 3.9.x** (or use included Maven wrapper)
- Database: `emp_db`

## ⚡ Quick Start

### 1. Clone the Repository
```bash
git clone https://github.com/Palenzo/Java-Employee-Management-Website.git
cd Java-Employee-Management-Website
```

### 2. Setup MySQL Database
```sql
CREATE DATABASE IF NOT EXISTS emp_db;
```

Or using command line:
```bash
mysql -u root -p -e "CREATE DATABASE IF NOT EXISTS emp_db;"
```

### 3. Configure Database (Optional)
Edit `src/main/resources/application.properties` if needed:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/emp_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

### 4. Run the Application

**Using Maven Wrapper (Recommended):**
```bash
./mvnw spring-boot:run
```

**Or build and run JAR:**
```bash
./mvnw clean package
java -jar target/crud-0.0.1-SNAPSHOT.jar
```

The application will start on **http://localhost:8080**

## 📡 API Endpoints

### Base URL: `http://localhost:8080/api/employee`

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| **POST** | `/api/employee` | Create new employee | JSON (see below) |
| **GET** | `/api/employee` | Get all employees | - |
| **GET** | `/api/employee?status=1` | Filter by status | - |
| **GET** | `/api/employee/{id}` | Get employee by ID | - |
| **PUT** | `/api/employee/{id}` | Update employee | JSON (partial) |
| **DELETE** | `/api/employee/{id}` | Delete employee | - |

## 📝 Request/Response Examples

### Create Employee (POST)
```bash
curl -X POST http://localhost:8080/api/employee \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "doj": "2025-01-15",
    "status": 1,
    "salary": 50000.0
  }'
```

**Response (201 Created):**
```json
{
  "id": 1,
  "name": "John Doe",
  "doj": "2025-01-15",
  "status": 1,
  "salary": 50000.0
}
```

### Get All Employees (GET)
```bash
curl http://localhost:8080/api/employee
```

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "doj": "2025-01-15",
    "status": 1,
    "salary": 50000.0
  }
]
```

### Get Employee by ID (GET)
```bash
curl http://localhost:8080/api/employee/1
```

### Update Employee (PUT)
```bash
curl -X PUT http://localhost:8080/api/employee/1 \
  -H "Content-Type: application/json" \
  -d '{
    "salary": 55000.0
  }'
```

### Delete Employee (DELETE)
```bash
curl -X DELETE http://localhost:8080/api/employee/1
```

**Response (200 OK):**
```json
{
  "message": "Employee deleted successfully"
}
```

## 🧪 Testing with PowerShell

### Create Employee
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/employee" `
  -Method Post `
  -ContentType "application/json" `
  -Body '{"name":"Jane Smith","doj":"2025-10-16","status":1,"salary":60000.0}'
```

### Get All Employees
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/employee" -Method Get
```

### Filter by Status
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/employee?status=1" -Method Get
```

### Update Employee
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/employee/1" `
  -Method Put `
  -ContentType "application/json" `
  -Body '{"salary":65000.0}'
```

### Delete Employee
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/employee/1" -Method Delete
```

## 🔍 Validation Rules

The API validates incoming requests:

| Field | Rule | Error Message |
|-------|------|---------------|
| **name** | Required, not blank | "name is required" |
| **doj** | Not in future | "date of joining cannot be in the future" |
| **salary** | Optional | - |
| **status** | Optional | - |

**Validation Error Response (400 Bad Request):**
```json
{
  "name": "name is required",
  "doj": "date of joining cannot be in the future"
}
```

## 🗂️ Project Structure

```
src/
├── main/
│   ├── java/com/employee/crud/
│   │   ├── CrudApplication.java          # Main application
│   │   ├── controller/
│   │   │   ├── EmployeeController.java   # REST endpoints
│   │   │   ├── GlobalExceptionHandler.java  # Error handling
│   │   │   └── WebConfig.java            # CORS configuration
│   │   ├── entity/
│   │   │   └── Employee.java             # JPA entity
│   │   ├── repository/
│   │   │   └── EmployeeRepository.java   # Data access
│   │   └── service/
│   │       ├── EmployeeService.java      # Service interface
│   │       └── EmployeeServiceImpl.java  # Business logic
│   └── resources/
│       └── application.properties        # Configuration
└── test/
    └── java/com/employee/crud/
        └── CrudApplicationTests.java     # Unit tests
```

## 🐛 Troubleshooting

### MySQL Connection Failed
**Error:** `Communications link failure`

**Solution:**
1. Verify MySQL is running: `Get-Service -Name "*mysql*"`
2. Start MySQL: `Start-Service MySQL`
3. Check credentials in `application.properties`
4. Ensure database `emp_db` exists

### Port 8080 Already in Use
**Error:** `Port 8080 is already in use`

**Solution:**
```powershell
# Find process using port 8080
netstat -ano | findstr :8080

# Kill the process (replace PID)
Stop-Process -Id <PID> -Force
```

### JDK Version Issues
**Error:** `Unsupported class file major version`

**Solution:** Ensure you're using JDK 21 or later:
```bash
java -version
```

If using an older JDK, install JDK 21 and set `JAVA_HOME`:
```powershell
$env:JAVA_HOME = 'C:\Program Files\Java\jdk-21'
```

## 🔧 Development

### Running Tests
```bash
./mvnw test
```

### Building Without Tests
```bash
./mvnw clean package -DskipTests
```

### Hot Reload (DevTools)
The project includes Spring Boot DevTools. Changes to Java files will auto-reload during development.

### Database Schema
Hibernate auto-generates the schema (`spring.jpa.hibernate.ddl-auto=update`). The `employee` table structure:

| Column | Type | Constraints |
|--------|------|-------------|
| id | BIGINT | PRIMARY KEY, AUTO_INCREMENT |
| name | VARCHAR(255) | NOT NULL |
| doj | DATE | - |
| status | INT | - |
| salary | FLOAT | - |

## 🌐 CORS Configuration

CORS is enabled for:
- **Origin:** `http://localhost` (configurable in `WebConfig.java`)
- **Methods:** GET, POST, PUT, DELETE, OPTIONS
- **Headers:** All
- **Credentials:** Enabled

## 📦 Maven Dependencies

Key dependencies:
- `spring-boot-starter-web` - REST API support
- `spring-boot-starter-data-jpa` - JPA/Hibernate
- `spring-boot-starter-validation` - Bean validation
- `mysql-connector-j` - MySQL driver
- `spring-boot-devtools` - Hot reload
- `spring-boot-starter-test` - Testing support

## 🤝 Contributing

Contributions are welcome! Please:
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 👤 Author

**Palenzo**
- GitHub: [@Palenzo](https://github.com/Palenzo)
- Repository: [Java-Employee-Management-Website](https://github.com/Palenzo/Java-Employee-Management-Website)

## 📞 Support

If you encounter any issues or have questions:
1. Check the [Troubleshooting](#-troubleshooting) section
2. Open an issue on GitHub
3. Review existing issues for solutions

## 🎓 Learning Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Jakarta EE Documentation](https://jakarta.ee/)
- [Java 21 Documentation](https://docs.oracle.com/en/java/javase/21/)
- [MySQL Documentation](https://dev.mysql.com/doc/)

---

**Built with ❤️ using Java 21 and Spring Boot 3.2.12**
