# Quick Render Deployment Guide

## One-Click Deploy with Render Blueprint

This project includes a `render.yaml` Blueprint for automated deployment.

### Option 1: Deploy with Blueprint (Recommended)

1. **Fork/Push to GitHub**
   ```bash
   git add .
   git commit -m "Add Render configuration"
   git push origin main
   ```

2. **Deploy to Render**
   - Go to https://dashboard.render.com/
   - Click **"New" → "Blueprint"**
   - Connect your GitHub repository
   - Select the repository containing this project
   - Render will automatically:
     - Create a MySQL database
     - Deploy the Spring Boot application
     - Configure all environment variables
     - Set up health checks

3. **Wait for Deployment**
   - Database creation: ~2 minutes
   - Application build: ~5 minutes
   - Health checks: ~30 seconds

4. **Access Your App**
   - URL will be: `https://forts-of-swarajya.onrender.com`
   - Health check: `https://forts-of-swarajya.onrender.com/health`

### Option 2: Manual Setup

If you prefer manual configuration, see [DEPLOYMENT.md](./DEPLOYMENT.md#render-deployment) for detailed step-by-step instructions.

## Environment Variables (Render Sets Automatically)

When using the Blueprint, these are configured automatically:
- `SPRING_PROFILES_ACTIVE=prod`
- `PORT=8080`
- `DATABASE_URL` (from MySQL service)
- `DATABASE_USERNAME` (from MySQL service)
- `DATABASE_PASSWORD` (from MySQL service)

## Free Tier Limitations

- **Web Service**: Spins down after 15 minutes of inactivity
- **Database**: 1GB storage limit
- **Build Time**: First build ~5 minutes, subsequent builds ~3 minutes

## Troubleshooting

### App Shows "Service Unavailable"
- First deploy takes ~5 minutes
- Check build logs in Render dashboard
- Verify database is running

### Database Connection Failed
- Wait for MySQL service to be fully started
- Check environment variables are set
- View logs for connection errors

### App Keeps Restarting
- Check health check endpoint `/health`
- Verify Docker build completed successfully
- Review application logs

## Monitoring

- **Logs**: Dashboard → Service → Logs tab
- **Metrics**: Dashboard → Service → Metrics tab  
- **Health**: Visit `/health` endpoint

## Scaling

To upgrade from free tier:
- Dashboard → Service → Settings
- Change plan to Starter ($7/month) or higher
- Benefits: No sleep, better performance, automatic SSL

---

**For complete deployment documentation, see [DEPLOYMENT.md](./DEPLOYMENT.md)**
