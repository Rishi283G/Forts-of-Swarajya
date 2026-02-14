# Forts of Swarajya

A full-stack Spring Boot web application showcasing the historic forts of Maharashtra, India. Built with Java, Spring Boot, Thymeleaf, and MySQL.

[![Deploy to Render](https://render.com/images/deploy-to-render-button.svg)](https://render.com/deploy)

## 🚀 Quick Deploy

### Deploy to Render (One-Click)
This project includes a `render.yaml` Blueprint for automated deployment:
1. Push code to GitHub
2. Go to [Render Dashboard](https://dashboard.render.com/)
3. New → Blueprint → Select your repo
4. Render automatically provisions database and deploys app

**See [RENDER.md](./RENDER.md) for detailed Render deployment guide.**

### Deploy to Railway
See [DEPLOYMENT.md](./DEPLOYMENT.md) for Railway deployment instructions.


## 🏰 Features

- **Dynamic Fort Listings** - Browse all Maharashtra forts with detailed information
- **Individual Fort Pages** - Comprehensive details including history, location, and image galleries
- **Search Functionality** - Find forts by name, location, or type
- **Interactive Map** - Visualize fort locations
- **Contact Form** - Get in touch with inquiries
- **Responsive Design** - Works on all devices
- **Database Seeding** - Auto-populated with 8 major forts

## 🛠️ Tech Stack

- **Backend**: Java 17, Spring Boot 3.2.0
- **Template Engine**: Thymeleaf
- **Database**: MySQL 8.0+
- **ORM**: Spring Data JPA / Hibernate
- **Build Tool**: Maven 3.8+
- **Containerization**: Docker

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.8+ (or use included wrapper)
- MySQL 8.0+ (for local development)
- Docker (optional, for containerized deployment)

## 🚀 Quick Start (Local Development)

### 1. Clone the Repository
```bash
git clone <your-repo-url>
cd forts-springboot
```

### 2. Setup MySQL Database
```sql
CREATE DATABASE forts_db;
CREATE USER 'fortuser'@'localhost' IDENTIFIED BY 'your_password';
GRANT ALL PRIVILEGES ON forts_db.* TO 'fortuser'@'localhost';
FLUSH PRIVILEGES;
```

### 3. Configure Environment Variables
Copy the example environment file:
```bash
cp .env.example .env
```

Edit `.env` and set your database credentials:
```properties
SPRING_PROFILES_ACTIVE=dev
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/forts_db?createDatabaseIfNotExist=true&useSSL=false
SPRING_DATASOURCE_USERNAME=fortuser
SPRING_DATASOURCE_PASSWORD=your_password
PORT=8080
```

### 4. Run the Application

**Using Maven:**
```bash
mvn spring-boot:run
```

**Using Maven Wrapper:**
```bash
./mvnw spring-boot:run  # Linux/Mac
mvnw.cmd spring-boot:run  # Windows
```

**Using the batch file (Windows):**
```bash
run_project.bat
```

### 5. Access the Application
Open your browser and navigate to:
- **Homepage**: http://localhost:8080/
- **Forts List**: http://localhost:8080/forts
- **Health Check**: http://localhost:8080/health

## 🐳 Docker Deployment

### Build the Docker Image
```bash
docker build -t forts-of-swarajya .
```

### Run with Docker Compose (Coming Soon)
```bash
docker-compose up -d
```

### Run Standalone Container
```bash
docker run -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=prod \
  -e DATABASE_URL=jdbc:mysql://your-db-host:3306/forts_db \
  -e DATABASE_USERNAME=your_user \
  -e DATABASE_PASSWORD=your_password \
  forts-of-swarajya
```

## ☁️ Cloud Deployment

### Render (One-Click Deploy)
Use the included `render.yaml` Blueprint:
```bash
# Push to GitHub, then use Render Blueprint
```
See [RENDER.md](RENDER.md) for complete Render deployment guide.

### Other Platforms
See [DEPLOYMENT.md](DEPLOYMENT.md) for detailed deployment guides for:
- **Railway**
- **Heroku**
- **Google Cloud Run**
- **AWS Elastic Beanstalk**

## 🔑 Environment Variables

| Variable | Description | Default | Required |
|----------|-------------|---------|----------|
| `SPRING_PROFILES_ACTIVE` | Active profile (dev/prod) | `dev` | No |
| `PORT` | Server port | `8080` | No |
| `SPRING_DATASOURCE_URL` | Database JDBC URL | localhost:3306 | Yes (prod) |
| `SPRING_DATASOURCE_USERNAME` | Database username | `root` | Yes (prod) |
| `SPRING_DATASOURCE_PASSWORD` | Database password | empty | Yes (prod) |

For production deployments using Railway/Render, use these instead:
- `DATABASE_URL` - Full database connection URL
- `DATABASE_USERNAME` - Database user
- `DATABASE_PASSWORD` - Database password

## 📂 Project Structure

```
forts-springboot/
├── src/main/java/com/forts/
│   ├── config/          # Configuration classes
│   ├── controller/      # MVC controllers
│   ├── exception/       # Exception handlers
│   ├── model/          # JPA entities
│   ├── repository/     # Data repositories
│   └── service/        # Business logic
├── src/main/resources/
│   ├── static/         # CSS, JS, images
│   ├── templates/      # Thymeleaf templates
│   ├── application.properties
│   └── application-prod.properties
├── Dockerfile
├── pom.xml
└── README.md
```

## 🧪 Testing

Run tests with:
```bash
mvn test
```

Build without tests:
```bash
mvn clean package -DskipTests
```

## 📊 API Endpoints

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/` | GET | Homepage |
| `/forts` | GET | List all forts |
| `/fort/{id}` | GET | Fort details |
| `/search?query=` | GET | Search forts |
| `/about` | GET | About page |
| `/contact` | GET/POST | Contact form |
| `/map` | GET | Interactive map |
| `/health` | GET | Health check (JSON) |
| `/ping` | GET | Simple ping endpoint |

## 🔒 Production Considerations

- ✅ Environment-based configuration (dev/prod profiles)
- ✅ Database connection pooling (HikariCP)
- ✅ Structured logging with profile-specific levels
- ✅ Global exception handling
- ✅ Input validation and sanitization
- ✅ Health check endpoints
- ✅ Docker health checks
- ✅ Non-root container user
- ✅ CORS configuration
- ✅ Static resource caching

## 🐛 Troubleshooting

### Port Already in Use
```bash
# Windows
netstat -ano | findstr :8080
taskkill /PID <process_id> /F

# Linux/Mac
lsof -ti:8080 | xargs kill -9
```

### Database Connection Issues
- Verify MySQL is running
- Check credentials in `.env` file
- Ensure database `forts_db` exists
- Check firewall rules

### Build Failures
```bash
# Clean Maven cache and rebuild
mvn clean install -U
```

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 👨‍💻 Author

**Rushikesh Jadhav**

## 🙏 Acknowledgments

- Historical information sourced from Maharashtra Tourism
- Fort images from public domain sources
- Built with Spring Boot and Thymeleaf

---

**Made with ❤️ for preserving Maharashtra's heritage**
