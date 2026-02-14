# Deployment Guide - Forts of Swarajya

This guide covers deploying the Spring Boot application to various cloud platforms.

## Table of Contents
- [Railway Deployment (Recommended)](#railway-deployment-recommended)
- [Render Deployment](#render-deployment)
- [Docker Deployment](#docker-deployment)
- [Environment Configuration](#environment-configuration)
- [Post-Deployment Verification](#post-deployment-verification)

---

## Railway Deployment (Recommended)

Railway offers the easiest deployment experience for Spring Boot applications.

### Prerequisites
- [Railway account](https://railway.app/) (free tier available)
- GitHub account
- Your code pushed to GitHub

### Step 1: Create New Project

1. Go to https://railway.app/
2. Click **"Start a New Project"**
3. Select **"Deploy from GitHub repo"**
4. Authorize Railway to access your GitHub
5. Select your `Forts-of-Swarajya` repository

### Step 2: Add MySQL Database

1. In your Railway project, click **"+ New"**
2. Select **"Database"** → **"MySQL"**
3. Railway will automatically provision a MySQL database
4. Note: Railway will create these environment variables automatically:
   - `MYSQL_URL`
   - `MYSQL_USER`
   - `MYSQL_PASSWORD`
   - `MYSQL_DATABASE`

### Step 3: Configure Environment Variables

In your Railway service settings, add these variables:

```bash
SPRING_PROFILES_ACTIVE=prod
PORT=8080

# Database connection (Railway format conversion needed)
DATABASE_URL=jdbc:mysql://${MYSQLHOST}:${MYSQLPORT}/${MYSQLDATABASE}
DATABASE_USERNAME=${MYSQLUSER}
DATABASE_PASSWORD=${MYSQLPASSWORD}
```

**Or use the automatic connection:**
Railway provides `DATABASE_URL` similar to Heroku. Add this single variable:
```bash
SPRING_DATASOURCE_URL=${DATABASE_URL}
```

### Step 4: Deploy

1. Railway automatically detects the `Dockerfile` and builds
2. Wait for the build to complete (~3-5 minutes)
3. Railway generates a public URL (e.g., `your-app.up.railway.app`)
4. Click the generated URL to access your application

### Step 5: Verify Deployment

1. Visit `https://your-app.up.railway.app/health`
2. Should return JSON with `"status": "UP"`
3. Visit `https://your-app.up.railway.app/` to see the homepage

---

## Render Deployment

Render offers two deployment methods: **Blueprint (recommended)** and **Manual Setup**.

### Method 1: Blueprint Deployment (Recommended) ⭐

The easiest way to deploy - one-click infrastructure provisioning!

#### Prerequisites
- [Render account](https://render.com/) (free tier available)
- Code pushed to GitHub

#### Steps

1. **Push Code to GitHub**
   ```bash
   git add .
   git commit -m "Add Render configuration"
   git push origin main
   ```

2. **Deploy with Blueprint**
   - Go to https://dashboard.render.com/
   - Click **"New" → "Blueprint"**
   - Connect your GitHub repository
   - Select your repository
   - Render automatically:
     - Creates MySQL database
     - Deploys Spring Boot app
     - Configures environment variables
     - Sets up health checks

3. **Wait for Deployment**
   - Database: ~2 minutes
   - Application: ~5 minutes
   - Access at: `https://forts-of-swarajya.onrender.com`

**That's it!** See [RENDER.md](../RENDER.md) for complete Blueprint documentation.

---

### Method 2: Manual Setup

For more control over configuration:

#### Step 1: Create Database

1. Render Dashboard → **"New +" → "PostgreSQL"** (or MySQL via Docker)
2. Name: `forts-db`
3. Plan: Free
4. Copy the **Internal Database URL**

#### Step 2: Create Web Service

1. **"New +" → "Web Service"**
2. Connect GitHub repository
3. Configure:
   - **Name**: `forts-of-swarajya`
   - **Environment**: `Docker`
   - **Region**: Oregon (or nearest)
   - **Plan**: Free

#### Step 3: Environment Variables

```bash
SPRING_PROFILES_ACTIVE=prod
PORT=8080
DATABASE_URL=<internal-db-url>
DATABASE_USERNAME=<db-user>
DATABASE_PASSWORD=<db-password>
```

#### Step 4: Deploy

1. **"Create Web Service"**
2. Build from Dockerfile (~5 minutes)
3. Access via generated URL

#### Step 5: Health Checks

- **Path**: `/health`
- **Interval**: 30 seconds

---

## Docker Deployment

Deploy to any Docker-compatible platform (DigitalOcean, AWS ECS, Google Cloud Run, etc.)

### Build Image
```bash
docker build -t forts-of-swarajya:latest .
```

### Run Locally (Testing)
```bash
docker run -d -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=prod \
  -e DATABASE_URL=jdbc:mysql://your-db-host:3306/forts_db \
  -e DATABASE_USERNAME=your_user \
  -e DATABASE_PASSWORD=your_password \
  --name forts-app \
  forts-of-swarajya:latest
```

### Push to Registry

**Docker Hub:**
```bash
docker tag forts-of-swarajya:latest your-username/forts-of-swarajya:latest
docker push your-username/forts-of-swarajya:latest
```

**Google Container Registry:**
```bash
docker tag forts-of-swarajya:latest gcr.io/your-project/forts-of-swarajya:latest
docker push gcr.io/your-project/forts-of-swarajya:latest
```

### Deploy to Google Cloud Run

```bash
gcloud run deploy forts-of-swarajya \
  --image gcr.io/your-project/forts-of-swarajya:latest \
  --platform managed \
  --region us-central1 \
  --allow-unauthenticated \
  --set-env-vars SPRING_PROFILES_ACTIVE=prod,DATABASE_URL=jdbc:mysql://...,DATABASE_USERNAME=...,DATABASE_PASSWORD=...
```

---

## Environment Configuration

### Development Profile (`dev`)
- Auto-creates database if not exists
- Seeds sample data automatically
- Verbose logging (DEBUG level)
- Shows SQL queries
- Thymeleaf template caching disabled

### Production Profile (`prod`)
- Requires existing database
- No automatic data seeding
- INFO level logging only
- SQL queries hidden
- Template caching enabled
- Connection pooling optimized
- Compression enabled

### Required Environment Variables (Production)

| Variable | Example | Description |
|----------|---------|-------------|
| `SPRING_PROFILES_ACTIVE` | `prod` | Activates production profile |
| `PORT` | `8080` | Port to run on (auto-set by most platforms) |
| `DATABASE_URL` | `jdbc:mysql://host:3306/db` | JDBC connection URL |
| `DATABASE_USERNAME` | `dbuser` | Database username |
| `DATABASE_PASSWORD` | `secretpass` | Database password |

---

## Post-Deployment Verification

### 1. Health Check
```bash
curl https://your-app-url/health
```
Expected response:
```json
{
  "status": "UP",
  "database": "Connected",
  "application": "Forts of Swarajya",
  "version": "1.0.0"
}
```

### 2. Ping Test
```bash
curl https://your-app-url/ping
```
Expected: `pong`

### 3. Homepage Check
Visit `https://your-app-url/` in browser - should load homepage

### 4. Forts List
Visit `https://your-app-url/forts` - should show empty list (production)
- **Note**: Production doesn't auto-seed data
- Manually add forts via admin interface or database

### 5. Database Connection
Check logs for successful connection:
```
INFO  com.forts.FortsOfSwarajyaApplication - Started FortsOfSwarajyaApplication
INFO  Hikari pool started
```

---

## Troubleshooting

### Application Won't Start
- ✅ Check environment variables are set correctly
- ✅ Verify database is accessible from app
- ✅ Check logs for connection errors
- ✅ Ensure `SPRING_PROFILES_ACTIVE=prod`

### Database Connection Failed
- ✅ Verify `DATABASE_URL` format is correct
- ✅ Check username/password
- ✅ Ensure database server allows external connections
- ✅ Check firewall rules

### Health Check Failing
- ✅ App might still be starting (wait 60 seconds)
- ✅ Check `/health` endpoint is accessible
- ✅ Verify database connectivity

### Out of Memory Errors
Add Java heap size limits:
```bash
# Railway/Render environment variable
JAVA_OPTS=-Xmx512m -Xms256m
```

Update Dockerfile ENTRYPOINT:
```dockerfile
ENTRYPOINT ["java", "-Xmx512m", "-jar", "-Dspring.profiles.active=prod", "app.jar"]
```

---

## Monitoring & Maintenance

### View Logs
- **Railway**: Dashboard → Deployments → Logs
- **Render**: Dashboard → Logs tab
- **Docker**: `docker logs -f <container-id>`

### Database Backups
- **Railway**: Automatic daily backups (paid plans)
- **Render**: Manual exports available
- **Cloud SQL**: Configure automatic backups

### Scaling
- **Railway**: Upgrade to higher tier for more resources
- **Render**: Upgrade instance type
- **Kubernetes**: Adjust replica count

---

## Security Checklist

- ✅ Never commit `.env` files
- ✅ Use environment variables for all secrets
- ✅ Enable HTTPS (automatic on Railway/Render)
- ✅ Set `SPRING_PROFILES_ACTIVE=prod` in production
- ✅ Disable debug logging in production
- ✅ Keep dependencies updated (`mvn versions:display-dependency-updates`)
- ✅ Use strong database passwords
- ✅ Regularly backup database

---

## Cost Estimates

### Railway (Free Tier)
- ✅ $5 free credit per month
- ✅ Enough for small apps
- ✅ MySQL database included

### Render (Free Tier)
- ✅ 750 hours/month (always-on)
- ✅ Sleeps after 15 min inactivity
- ✅ Database: Free tier PostgreSQL

### Heroku (Deprecated Free Tier)
- ⚠️ No longer free
- Starting at $7/month

---

**Need help?** Check the [main README](README.md) or open an issue.
